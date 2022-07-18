package com.company;

import javax.swing.*;
import java.awt.*;

public class Janela extends Canvas {

    public Janela(int largura, int altura, String titulo, Jogo jogo){
        JFrame frame = new JFrame(titulo);
        //padronizando o tamanho da janela para que não ajam erros
        frame.setPreferredSize(new Dimension(largura, altura));
        frame.setMaximumSize(new Dimension(largura, altura));
        frame.setMinimumSize(new Dimension(largura, altura));

        //ao fechar a janela a execução é parada
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        //método para informar qual conteúdo vai ser exibido no JFrame (janela)
        frame.add(jogo);
        frame.setVisible(true);

        //inicia a thread do jogo
        jogo.start();
    }
}
