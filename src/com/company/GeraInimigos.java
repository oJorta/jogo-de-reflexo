package com.company;

import java.util.Random;

public class GeraInimigos{
    private Handler handler;
    private HUD hud;
    private int pontosAux = 0;
    private int nivelAux = 1;
    private Random r = new Random();

    public GeraInimigos(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void update(){
        pontosAux++;
        if(pontosAux>=250){
            nivelAux++;
            pontosAux = 0;
            hud.setNivel(nivelAux);
            if(nivelAux == 2){
                handler.addObjeto(new Inimigo(r.nextInt(Jogo.WIDTH), r.nextInt(Jogo.HEIGHT), ID.Inimigo, handler));
            }
            if(nivelAux == 3){
                handler.addObjeto(new Inimigo2(r.nextInt(Jogo.WIDTH), r.nextInt(Jogo.HEIGHT), ID.Inimigo2, handler));
            }
            if(nivelAux == 4){
                handler.addObjeto(new Inimigo3(r.nextInt(Jogo.WIDTH), r.nextInt(Jogo.HEIGHT), ID.Inimigo3, handler));
            }
            if(nivelAux == 5){
                handler.addObjeto(new Inimigo(r.nextInt(Jogo.WIDTH), r.nextInt(Jogo.HEIGHT), ID.Inimigo, handler));
            }
            if(nivelAux == 6){
                handler.addObjeto(new Inimigo2(r.nextInt(Jogo.WIDTH), r.nextInt(Jogo.HEIGHT), ID.Inimigo2, handler));
            }
            if(nivelAux == 7){
                handler.addObjeto(new Inimigo2(r.nextInt(Jogo.WIDTH), r.nextInt(Jogo.HEIGHT), ID.Inimigo2, handler));
            }
            if(nivelAux == 8){
                handler.addObjeto(new Inimigo3(r.nextInt(Jogo.WIDTH), r.nextInt(Jogo.HEIGHT), ID.Inimigo3, handler));
            }
            if(nivelAux == 9){
                handler.addObjeto(new Inimigo(r.nextInt(Jogo.WIDTH), r.nextInt(Jogo.HEIGHT), ID.Inimigo, handler));
            }
            if(nivelAux == 10){
                handler.limpaTela();
                handler.addObjeto(new Chefe((Jogo.WIDTH/2)-48, -120, ID.Chefe, handler));
            }
        }

    }

    public void setNivelAux(int nivelAux) {
        this.nivelAux = nivelAux;
    }

    public void setPontosAux(int pontosAux) {
        this.pontosAux = pontosAux;
    }
}
