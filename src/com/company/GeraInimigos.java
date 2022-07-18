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
    //gera inimigos diferentes na tela a cada passagem de nível.
    //a cada 250 pontos -> nivel++
    public void update(){
        pontosAux++;
        if(pontosAux>=250){
            nivelAux++;
            pontosAux = 0;
            hud.setNivel(nivelAux);
            if(nivelAux == 2){
                handler.addObjeto(new Inimigo(r.nextInt(Jogo.LARGURA - 50), r.nextInt(Jogo.ALTURA - 50), ID.Inimigo, handler));
            }
            if(nivelAux == 3){
                handler.addObjeto(new Inimigo2(r.nextInt(Jogo.LARGURA - 50), r.nextInt(Jogo.ALTURA - 50), ID.Inimigo2, handler));
            }
            if(nivelAux == 4){
                handler.addObjeto(new Inimigo3(r.nextInt(Jogo.LARGURA - 50), r.nextInt(Jogo.ALTURA - 50), ID.Inimigo3, handler));
            }
            if(nivelAux == 5){
                handler.addObjeto(new Inimigo(r.nextInt(Jogo.LARGURA - 50), r.nextInt(Jogo.ALTURA - 50), ID.Inimigo, handler));
            }
            if(nivelAux == 6){
                handler.addObjeto(new Inimigo2(r.nextInt(Jogo.LARGURA - 50), r.nextInt(Jogo.ALTURA - 50), ID.Inimigo2, handler));
            }
            if(nivelAux == 7){
                handler.addObjeto(new Inimigo2(r.nextInt(Jogo.LARGURA - 50), r.nextInt(Jogo.ALTURA - 50), ID.Inimigo2, handler));
            }
            if(nivelAux == 8){
                handler.addObjeto(new Inimigo3(r.nextInt(Jogo.LARGURA - 50), r.nextInt(Jogo.ALTURA - 50), ID.Inimigo3, handler));
            }
            if(nivelAux == 9){
                handler.addObjeto(new Inimigo(r.nextInt(Jogo.LARGURA - 50), r.nextInt(Jogo.ALTURA - 50), ID.Inimigo, handler));
            }
            if(nivelAux == 10){
                handler.limpaTela();
                handler.addObjeto(new Chefe((Jogo.LARGURA /2)-48, -120, ID.Chefe, handler));
            }
            if(nivelAux == 16){
                handler.limpaTela();
                hud.setVIDA(100);
                for(int i=0; i<=10; i++){
                    handler.addObjeto(new Inimigo2(r.nextInt(Jogo.LARGURA - 50), r.nextInt(Jogo.ALTURA - 50), ID.Inimigo2, handler));
                }
            }
            if(nivelAux == 20){
                handler.limpaTela();
                for(int j=0; j<=10; j++){
                    handler.addObjeto(new Inimigo3(r.nextInt(Jogo.LARGURA - 50), r.nextInt(Jogo.ALTURA - 50), ID.Inimigo3, handler));
                }
            }
            if(nivelAux == 24){
                handler.limpaTela();
                handler.addObjeto(new Chefe((Jogo.LARGURA /2)-48, -120, ID.Chefe, handler));
            }
            if(nivelAux > 29){
                handler.limpaTela();
                for(int k=0; k<10; k++){
                    int aux = r.nextInt(3);
                    if(aux == 0)
                        handler.addObjeto(new Inimigo(r.nextInt(Jogo.LARGURA - 50), r.nextInt(Jogo.ALTURA - 50), ID.Inimigo, handler));
                    if(aux == 1)
                        handler.addObjeto(new Inimigo2(r.nextInt(Jogo.LARGURA - 50), r.nextInt(Jogo.ALTURA - 50), ID.Inimigo2, handler));
                    if(aux == 2)
                        handler.addObjeto(new Inimigo3(r.nextInt(Jogo.LARGURA - 50), r.nextInt(Jogo.ALTURA - 50), ID.Inimigo3, handler));
                }
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
