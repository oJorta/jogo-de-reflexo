package com.company;

import java.awt.*;

public class Rastro extends ObjetosDoJogo{

    private float tamRastro = 1;
    private float distanciaRastro;
    private Handler handler;
    private Color cor;
    private int width, height;

    public Rastro(int x, int y, ID id, Color cor, float distanciaRastro, int width, int height, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.cor = cor;
        this.distanciaRastro = distanciaRastro;
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {
        if(tamRastro > distanciaRastro){
            tamRastro -= distanciaRastro - 0.001f;
        }
        else{
            handler.removeObjeto(this);
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(transparencia(tamRastro));
        g.setColor(cor);
        g.fillRect(x, y, 16, 16);
        g2d.setComposite(transparencia(1));
    }

    private AlphaComposite transparencia(float a){
        int tipo = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(tipo, a);

    }

    @Override
    public Rectangle getLimite() {
        return null;
    }
}
