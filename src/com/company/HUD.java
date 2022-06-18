package com.company;

import java.awt.*;

public class HUD {
    public static int VIDA = 100;


    public void update(){
        VIDA = Jogo.limiteDaTela(VIDA, 100, 0);

    }
    public void render(Graphics g){
        //Fundo da barra de vida
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
        //Barra de vida
        g.setColor(Color.GREEN);
        g.fillRect(15, 15, VIDA*2, 32);

    }
}
