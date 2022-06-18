package com.company;

import java.awt.*;

public abstract class ObjetosDoJogo {
    protected int x, y;
    protected ID id;
    protected int velocidadeX, velocidadeY;

    public ObjetosDoJogo(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    // esses métodos vão ser escritos pelas classes que herdarão
    // a classe ObjetosDoJogo (jogador e inimigo)
    public abstract void update();
    public abstract void render(Graphics g);
    public abstract Rectangle getLimite();

    public void setX(int x) { this.x = x; }
    public void setY(int y) {
        this.y = y;
    }
    public void setId(ID id) {
        this.id = id;
    }
    public void setVelocidadeX(int velocidadeX) {
        this.velocidadeX = velocidadeX;
    }
    public void setVelocidadeY(int velocidadeY) {
        this.velocidadeY = velocidadeY;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public ID getId() {
        return id;
    }
    public int getVelocidadeX() {
        return velocidadeX;
    }
    public int getVelocidadeY() {
        return velocidadeY;
    }
}
