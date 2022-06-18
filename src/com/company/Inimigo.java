package com.company;

import java.awt.*;

public class Inimigo extends ObjetosDoJogo{

    private Handler handler;

    public Inimigo(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        velocidadeX = 5;
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

        //Caso o inimigo colida com os limites da janela do jogo, a sua posição vai
        //ser invertida para que ele continue percorrendo dentro dos limites da janela
        if(y<=0 || y>= Jogo.HEIGHT - 56){
            velocidadeY *= -1;
        }
        if(x<=0 || x>= Jogo.WIDTH - 32){
            velocidadeX *= -1;
        }

        handler.addObjeto(new Rastro(x, y, ID.Rastro, Color.RED, 0.03f,16, 16, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 16, 16);

    }
}
