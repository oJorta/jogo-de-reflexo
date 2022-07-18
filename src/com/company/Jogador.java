package com.company;

import java.awt.*;

public class Jogador extends ObjetosDoJogo{
    Handler handler;

    public Jogador(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getLimite(){
        return new Rectangle(x, y, 32, 32);
    }

    public void update() {
        x += velocidadeX;
        y += velocidadeY;
        //Limita a posição do jogador usando o método estático "limiteDaTela"
        x = Jogo.limiteDaTela(x, Jogo.LARGURA -48, 0);
        y = Jogo.limiteDaTela(y, Jogo.ALTURA -68, 0);

        //verifica a posição e se colidir com algum inimigo remove -2 da VIDA
        colisao();
    }

    public void colisao(){
        for(int i=0; i<handler.objetos.size(); i++){
            ObjetosDoJogo objetoTemp = handler.objetos.get(i);
            if(objetoTemp.getId() == ID.Inimigo || objetoTemp.getId() == ID.Inimigo2 || objetoTemp.getId() == ID.Inimigo3
            || objetoTemp.getId() == ID.Chefe){
                if(getLimite().intersects(objetoTemp.getLimite())){
                    HUD.VIDA -= 1;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y,32, 32);
    }
}
