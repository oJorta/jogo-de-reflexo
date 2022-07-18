package com.company;

import java.awt.*;
import java.util.Random;

public class Chefe extends ObjetosDoJogo{

    private Handler handler;
    private boolean movimentoX = false;
    private int movimentoY = 80;
    Random r = new Random();


    public Chefe(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        setVelocidadeX(0);
        setVelocidadeY(2);
        this.handler = handler;
    }

    public Rectangle getLimite(){
        return new Rectangle(x, y, 96, 96);
    }

    @Override
    public void update() {
        x += velocidadeX;
        y += velocidadeY;

        //decrementa a variável movimentoY até que chegue a 0 e, então, cessa o movimento do inimigo
        //(animação de entrada do chefe, funciona como um temporizador)
        movimentoY--;
        if(movimentoY <= 0){
            velocidadeY = 0;
            movimentoX = true;
        }
        if(movimentoX == true) {
            //evita o conflito com a condição de inversão de movimento caso aja colisão com a janela
            if(velocidadeX == 0)
                velocidadeX = 4;
            //gera inimigos em quantidade aleatória
            int gerarAtaque = r.nextInt(10);
            if(gerarAtaque == 0)
                handler.addObjeto(new ChefeAtaque(x+48, y+96, ID.Inimigo, handler));
        }

        //inverte o sentido caso haja colisao com os limites da janela
        if(x<=0 || x>= Jogo.LARGURA - 96){
            velocidadeX *= -1;
        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 96, 96);

    }
}