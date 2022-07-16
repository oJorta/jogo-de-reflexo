package com.company;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    //Lista encadeada que reune todos os objetos do jogo
    LinkedList<ObjetosDoJogo> objetos = new LinkedList<ObjetosDoJogo>();

    public void update(){
        for(int i=0; i<objetos.size(); i++){
            ObjetosDoJogo objetoTemp = objetos.get(i);
            objetoTemp.update();
        }
    }
    //Renderiza todos os objetos presentes na lista
    public void render(Graphics g){
        for(int i=0; i<objetos.size(); i++){
            ObjetosDoJogo objetoTemp = objetos.get(i);
            objetoTemp.render(g);
        }
    }

    //Adiciona um objeto na lista de objetos
    public void addObjeto(ObjetosDoJogo objeto){
        objetos.add(objeto);
    }
    //Remove um objeto da lista de objetos
    public void removeObjeto(ObjetosDoJogo objeto){
        objetos.remove(objeto);
    }
    //Limpa todos os inimigos da tela
    public void limpaTela(){
        for(int i=0; i<objetos.size(); i++){
            ObjetosDoJogo objetoTemp = objetos.get(i);
            if(objetoTemp.getId()!= ID.Jogador){
                removeObjeto(objetoTemp);
                i--;
            }
        }
    }
    public void removeJogador(){
        for(int i=0; i<objetos.size(); i++){
            ObjetosDoJogo objetoTemp = objetos.get(i);
            if(objetoTemp.getId() == ID.Jogador){
                removeObjeto(objetoTemp);
                i--;
            }
        }
    }

}
