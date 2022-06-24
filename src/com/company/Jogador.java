package com.company;

import java.awt.*;

public class Jogador extends ObjetosDoJogo{
    Handler handler;

    public Jogador(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        //velocidadeX = 1;
        //velocidadeY = 1;
    }

    public Rectangle getLimite(){
        return new Rectangle(x, y, 32, 32);
    }

    public void update() {
        x += velocidadeX;
        y += velocidadeY;
        //Limita a posição do jogador usando o método estático "limiteDaTela"
        x = Jogo.limiteDaTela(x, Jogo.WIDTH-48, 0);
        y = Jogo.limiteDaTela(y, Jogo.HEIGHT-68, 0);

        colisao();
    }

    public void colisao(){
        for(int i=0; i<handler.objetos.size(); i++){
            ObjetosDoJogo objetoTemp = handler.objetos.get(i);
            if(objetoTemp.getId() == ID.Inimigo || objetoTemp.getId() == ID.Inimigo2){
                if(getLimite().intersects(objetoTemp.getLimite())){
                    HUD.VIDA -= 2;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y,32, 32);


    }
}
