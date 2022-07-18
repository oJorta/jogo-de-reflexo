package com.company;

import java.awt.*;

import static java.lang.Math.pow;

public class Inimigo3 extends ObjetosDoJogo{

    private Handler handler;
    private ObjetosDoJogo objetoJogador;

    public Inimigo3(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for(int i=0; i<handler.objetos.size(); i++){
            if(handler.objetos.get(i).getId() == ID.Jogador)
                objetoJogador = handler.objetos.get(i);
        }
    }

    public Rectangle getLimite(){
        return new Rectangle(x, y, 16, 16);
    }

    @Override
    public void update() {
        x += velocidadeX;
        y += velocidadeY;

        //distancia entre o jogador e o inimigo
        float distanciaX = x - objetoJogador.getX();
        float distanciaY = y - objetoJogador.getY();
        float distancia = (float) Math.sqrt(pow(distanciaX, 2) + pow(distanciaY, 2));

        //iguala pouco a pouco velocidade X e Y do inimigo com a posição do jogador, para que a cada update
        //o inimigo tente igualar sua posição com a do jogador criando uma sensação de perseguição.
        velocidadeX =  (int)((-1.0/distancia) * distanciaX * 3);
        velocidadeY = (int)((-1.0/distancia) * distanciaY * 3);


        //Caso o inimigo colida com os limites da janela do jogo, a sua velocidade (sentido do movimento)
        //vai ser invertida para que ele continue percorrendo dentro dos limites da janela
        if(y<=0 || y>= Jogo.ALTURA - 56){
            velocidadeY *= -1;
        }
        if(x<=0 || x>= Jogo.LARGURA - 32){
            velocidadeX *= -1;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 16, 16);

    }
}