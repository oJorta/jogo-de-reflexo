package com.company;

import javax.net.ssl.SNIHostName;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Jogo extends Canvas implements Runnable {

    //calculo de altura para manter a proporção de tela de 6:9
    public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;

    //necessário para a execução do jogo
    private Thread thread;
    private boolean running = false;

    private Handler handler;
    private HUD hud;

    private Random r = new Random();

    public Jogo(){
        handler = new Handler();
        this.addKeyListener(new InputTeclado(handler));
        new Janela(WIDTH, HEIGHT, "Projeto de Curso - Jogo", this);
        hud = new HUD();
        handler.addObjeto(new Jogador(WIDTH/2-32, HEIGHT/2-32, ID.Jogador, handler));
        handler.addObjeto(new Inimigo(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Inimigo, handler));
        handler.addObjeto(new Inimigo(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Inimigo, handler));
        handler.addObjeto(new Inimigo(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Inimigo, handler));
        handler.addObjeto(new Inimigo(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Inimigo, handler));
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

    //variáveis de teste de taxa de atualização.
    private long tempoDoProximoStatus = System.currentTimeMillis() + 1000; // 1 segundo depois do status atual
    private int fps, ups;

    /* método responsável por gerar o loop e renderização do jogo,
    gerando 60 frames a cada segundo (taxa de atualização) */
    public void run(){
        this.requestFocus();
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

        hud.render(g);

        g.dispose();
        bs.show();
        fps++;
    }
    private void update(){
        handler.update();
        hud.update();
        ups++;
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
