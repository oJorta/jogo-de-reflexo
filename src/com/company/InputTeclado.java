package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputTeclado extends KeyAdapter {
    private Handler handler;
    private boolean teclaPressionada[] = new boolean[4];

    public InputTeclado(Handler handler){
        this.handler = handler;
        for(int i=0 ; i<4; i++){
            teclaPressionada[i] = false;
        }
    }

    //método da classe KeyAdapter
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(int i=0; i<handler.objetos.size(); i++){
            ObjetosDoJogo objetoTemp = handler.objetos.get(i);

            if(objetoTemp.getId() == ID.Jogador){
                if(key == KeyEvent.VK_UP){
                    objetoTemp.setVelocidadeY(-5);
                    teclaPressionada[0] = true;
                }
                if(key == KeyEvent.VK_DOWN) {
                    objetoTemp.setVelocidadeY(+5);
                    teclaPressionada[1] = true;
                }
                if(key == KeyEvent.VK_RIGHT){
                    objetoTemp.setVelocidadeX(+5);
                    teclaPressionada[2] = true;
                }
                if(key == KeyEvent.VK_LEFT){
                    objetoTemp.setVelocidadeX(-5);
                    teclaPressionada[3] = true;
                }
            }
        }
        if(key == KeyEvent.VK_P){
            if(Jogo.pausa == true)
                Jogo.pausa = false;
            else if(Jogo.pausa == false)
                Jogo.pausa = true;
        }
    }
    //método da classe KeyAdapter
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i=0; i<handler.objetos.size(); i++){
            ObjetosDoJogo objetoTemp = handler.objetos.get(i);

            if(objetoTemp.getId() == ID.Jogador){
                if(key == KeyEvent.VK_UP)
                    teclaPressionada[0] = false;
                if(key == KeyEvent.VK_DOWN)
                    teclaPressionada[1] = false;
                if(key == KeyEvent.VK_RIGHT)
                    teclaPressionada[2] = false;
                if(key == KeyEvent.VK_LEFT)
                    teclaPressionada[3] = false;

                //impede o movimento do personagem de "travar" caso duas teclas
                //sejam pressionadas ao mesmo tempo
                if(!teclaPressionada[0] && !teclaPressionada[1]){
                    objetoTemp.setVelocidadeY(0);
                }
                if(!teclaPressionada[2] && !teclaPressionada[3]){
                    objetoTemp.setVelocidadeX(0);
                }
            }
        }
    }
}
