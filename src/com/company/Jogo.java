package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Jogo extends Canvas implements Runnable {

    //calculo de altura para manter a proporção de tela de 6:9
    public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;

    //necessário para a execução do jogo
    private Thread thread;
    private boolean running = false;

    public static boolean pausa = false;

    private Handler handler;
    private HUD hud;
    private GeraInimigos geraInimigos;
    private Menu menu;

    private Random r = new Random();

    public enum ESTADOS {
        Menu, Iniciar, Fim
    };

    public ESTADOS estadoDoJogo = ESTADOS.Menu;

    public Jogo(){
        handler = new Handler();
        hud = new HUD();
        menu = new Menu(this, hud, handler);
        this.addKeyListener(new InputTeclado(handler));
        this.addMouseListener(new Menu(this, hud, handler));

        new Janela(WIDTH, HEIGHT, "Projeto de Curso - Jogo", this);
        geraInimigos = new GeraInimigos(handler, hud);

        if(estadoDoJogo == ESTADOS.Iniciar){
            handler.addObjeto(new Jogador(WIDTH/2-32, HEIGHT/2-32, ID.Jogador, handler));
            handler.addObjeto(new Inimigo(r.nextInt(Jogo.WIDTH), r.nextInt(Jogo.HEIGHT), ID.Inimigo, handler));
        }

    }

    //inicia uma thread nessa classe utilizando o this como parâmetro
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    //tenta finalizar a thread para parar o jogo e, caso não consiga,
    //retorna o erro ocorrido.
    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //variáveis de teste/análise da taxa de atualização.
    private long tempoDoProximoStatus = System.currentTimeMillis() + 1000; // 1 segundo depois do status atual
    private int fps, ups;

    /* método responsável por gerar o loop do jogo,
    gerando 60 frames a cada segundo (taxa de atualização) */
    public void run(){
        this.requestFocus(); //tenta deixar a janela do jogo como a janela ativa do windows (ação de dar um clique em uma
                            // e deixar ela "focada").
        double taxaDeAtualizacao = 1.0d/60.0d;
        double accumulator = 0;
        long tempoAtual, ultimaAtualizacao = System.currentTimeMillis();

        while(running){
            tempoAtual = System.currentTimeMillis();
            double ultimaRenderEmSegundos = (tempoAtual - ultimaAtualizacao)/1000d;
            accumulator += ultimaRenderEmSegundos;
            ultimaAtualizacao = tempoAtual;

            while (accumulator > taxaDeAtualizacao){
                update();
                accumulator -= taxaDeAtualizacao;
            }
            render();
            mostraStatus();
        }
    }

    //método para análise da renderização e taxa de atualização do jogo.
    private void mostraStatus(){
        if(System.currentTimeMillis() > tempoDoProximoStatus){
            System.out.println(String.format("FPS: %d UPS: %d", fps, ups));
            fps = 0;
            ups = 0;
            tempoDoProximoStatus = System.currentTimeMillis() + 1000;
        }
    }

    //renderiza todos os elementos gráficos do jogo: display de vida e pontuação (HUD), jogador, inimigos e menu.
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        if(pausa){
            g.drawString("PAUSADO", 100, 100);
        }

        if(estadoDoJogo == ESTADOS.Iniciar) {
            hud.render(g);
        }else{
            menu.render(g);
        }

        g.dispose();
        bs.show();
        fps++;
    }
    //atualiza todas as informações de posição do jogador e dos inimigos, quantidade de vida e verifica o estadoDoJogo
    //a cada atualização da tela
    private void update(){
        if(estadoDoJogo == ESTADOS.Iniciar) {
            if(!pausa){
                hud.update();
                geraInimigos.update();
                handler.update();
                ups++;

                if(hud.getVIDA() <= 0){
                    hud.setVIDA(100);
                    hud.setNivel(1);
                    hud.setPontos(0);

                    geraInimigos.setNivelAux(1);
                    geraInimigos.setPontosAux(0);

                    estadoDoJogo = ESTADOS.Fim;
                    handler.limpaTela();
                    handler.removeJogador();
                }
            }
        }else if(estadoDoJogo == ESTADOS.Menu || estadoDoJogo == ESTADOS.Fim){
            menu.update();
        }
    }

    //verifica a colisão do jogador com os limites da janela
    public static int limiteDaTela(int pos, int max, int min){
        if(pos >= max)
            return pos = max;
        if(pos <= min)
            return  pos = min;
        else
            return pos;
    }

    public static void main(String[] args) {
        new Jogo();
    }
}
