package com.company;

import java.awt.*;

public class HUD {
    public static int VIDA = 100;
    private int pontos = 0;
    private int nivel = 1;


    public void update(){
        VIDA = Jogo.limiteDaTela(VIDA, 100, 0);
        pontos++;
    }
    public void render(Graphics g){
        //Fundo da barra de vida
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
        //Barra de vida
        g.setColor(Color.GREEN);
        g.fillRect(15, 15, VIDA*2, 32);
        //Pontuação e nível
        g.setColor(Color.white);
        g.drawString("Pontuação: "+pontos, 15, 65);
        g.drawString("Nível: "+nivel, 15, 80);
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setVIDA(int VIDA) {
        HUD.VIDA = VIDA;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPontos() {
        return pontos;
    }

    public int getVIDA() {
        return VIDA;
    }
}
