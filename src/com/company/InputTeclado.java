package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputTeclado extends KeyAdapter {
    private Handler handler;

    public InputTeclado(Handler handler){
        this.handler = handler;
    }

    //método da classe KeyAdapter
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(int i=0; i<handler.objetos.size(); i++){
            ObjetosDoJogo objetoTemp = handler.objetos.get(i);

            if(objetoTemp.getId() == ID.Jogador){
                if(key == KeyEvent.VK_UP)
                    objetoTemp.setVelocidadeY(-5);
                if(key == KeyEvent.VK_DOWN)
                    objetoTemp.setVelocidadeY(+5);
                if(key == KeyEvent.VK_RIGHT)
                    objetoTemp.setVelocidadeX(+5);
                if(key == KeyEvent.VK_LEFT)
                    objetoTemp.setVelocidadeX(-5);
            }
        }
    }
    //método da classe KeyAdapter
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(int i=0; i<handler.objetos.size(); i++){
            ObjetosDoJogo objetoTemp = handler.objetos.get(i);

            if(objetoTemp.getId() == ID.Jogador){
                if(key == KeyEvent.VK_UP)
                    objetoTemp.setVelocidadeY(0);
                if(key == KeyEvent.VK_DOWN)
                    objetoTemp.setVelocidadeY(0);
                if(key == KeyEvent.VK_RIGHT)
                    objetoTemp.setVelocidadeX(0);
                if(key == KeyEvent.VK_LEFT)
                    objetoTemp.setVelocidadeX(0);
            }
        }


    }
}
