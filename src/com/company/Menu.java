package com.company;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {
    Jogo jogo;
    HUD hud;
    Handler handler;
    Random r = new Random();

    public Menu(Jogo jogo, HUD hud, Handler handler){
        this.jogo = jogo;
        this.hud = hud;
        this.handler = handler;
    }

    //métodos da classe MouseAdapter
    public void mousePressed(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();

        //compara a posição do cursor no momento do click, se coincidir com
        //a posição do botão "Iniciar", inicia o jogo
        if(jogo.estadoDoJogo == Jogo.ESTADOS.Menu && mouseX >= 230 && mouseX <= 410){
            if(mouseY >= 130 && mouseY <= 194){
                jogo.estadoDoJogo = Jogo.ESTADOS.Iniciar;
                handler.addObjeto(new Jogador(Jogo.WIDTH/2-32, Jogo.HEIGHT/2-32, ID.Jogador, handler));
                handler.addObjeto(new Inimigo(r.nextInt(Jogo.WIDTH), r.nextInt(Jogo.HEIGHT), ID.Inimigo, handler));
            }
        }

        if(jogo.estadoDoJogo == Jogo.ESTADOS.Menu && mouseX >= 230 && mouseX <= 410) {
            if (mouseY >= 230 && mouseY <= 294) {
                System.exit(1);
            }
        }

        if(jogo.estadoDoJogo == Jogo.ESTADOS.Fim && mouseX >= 210 && mouseX <= 415) {
            if (mouseY >= 230 && mouseY <= 294) {
                jogo.estadoDoJogo = Jogo.ESTADOS.Iniciar;
                handler.addObjeto(new Jogador(Jogo.WIDTH/2-32, Jogo.HEIGHT/2-32, ID.Jogador, handler));
                handler.addObjeto(new Inimigo(r.nextInt(Jogo.WIDTH), r.nextInt(Jogo.HEIGHT), ID.Inimigo, handler));
            }
        }
    }
    public void mouseReleased(MouseEvent e){

    }

    public void update(){

    }
    public void render(Graphics g){
        if(jogo.estadoDoJogo == Jogo.ESTADOS.Menu){
            Font fonte = new Font("Verdana", 1, 45);
            Font fonte2 = new Font("Verdana", 1, 30);
            g.setColor(Color.white);

            g.setFont(fonte);
            g.drawString("Projeto Final - LP3", 75, 80);

            g.setFont(fonte2);
            g.drawString("Iniciar", 265, 175);
            g.drawRect(230, 130, 180, 64);

            g.drawString("Sair", 285, 275);
            g.drawRect(230, 230, 180, 64);
        }else if(jogo.estadoDoJogo == Jogo.ESTADOS.Fim){
            Font fonte = new Font("Verdana", 1, 45);
            Font fonte2 = new Font("Verdana", 1, 25);

            g.setColor(Color.RED);
            g.setFont(fonte);
            g.drawString("Você perdeu!", 145, 85);

            g.setColor(Color.WHITE);
            g.setFont(fonte2);
            g.drawString("Pontuação: " + hud.getPontos(), 210, 215);

            g.setFont(fonte2);
            g.drawString("Jogar de novo", 215, 275);
            g.drawRect(210, 230, 205, 64);
        }

    }
}
