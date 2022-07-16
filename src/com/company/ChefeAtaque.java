package com.company;

import java.awt.*;
import java.util.Random;

public class ChefeAtaque extends ObjetosDoJogo{

    private Handler handler;
    Random r = new Random();

    public ChefeAtaque(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        //numero entre -5 e 5 para que os ataques sejam gerados tanto na esquerda quanto na direita
        velocidadeX = r.nextInt((5-(-5)+1)+(-5));
        velocidadeY = 5;
        this.handler = handler;
    }

    public Rectangle getLimite(){
        return new Rectangle(x, y, 16, 16);
    }

    @Override
    public void update() {
        x += velocidadeX;
        y += velocidadeY;

        //Caso o inimigo colida com os limites da janela do jogo, a sua velocidade (sentido do movimento)
        //vai ser invertida para que ele continue percorrendo dentro dos limites da janela
        /*
        if(y<=0 || y>= Jogo.HEIGHT - 56){
            velocidadeY *= -1;
        }
        if(x<=0 || x>= Jogo.WIDTH - 32){
            velocidadeX *= -1;
        }
         */

        //era x
        if (y >= Jogo.HEIGHT)
            handler.removeObjeto(this);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, 16, 16);

    }
}
