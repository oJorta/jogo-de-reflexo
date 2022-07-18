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
        velocidadeY = 6;
        this.handler = handler;
    }

    public Rectangle getLimite(){
        return new Rectangle(x, y, 16, 16);
    }

    @Override
    public void update() {
        x += velocidadeX;
        y += velocidadeY;
        //se o inimigo ultrapassar o limite da tela ele é removido
        if (y >= Jogo.ALTURA)
            handler.removeObjeto(this);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, 16, 16);
    }
}
