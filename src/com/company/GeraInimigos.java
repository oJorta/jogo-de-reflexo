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
                handler.addObjeto(new Inimigo(r.nextInt(Jogo.WIDTH), r.nextInt(Jogo.HEIGHT), ID.Inimigo, handler));
                handler.addObjeto(new Inimigo2(r.nextInt(Jogo.WIDTH), r.nextInt(Jogo.HEIGHT), ID.Inimigo2, handler));
            }
        }

    }
}
