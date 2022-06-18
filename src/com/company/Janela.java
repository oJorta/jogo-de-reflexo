package com.company;

import javax.swing.*;
import java.awt.*;

public class Janela extends Canvas {

    public Janela(int width, int height, String titulo, Jogo jogo){
        JFrame frame = new JFrame(titulo);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(jogo);
        frame.setVisible(true);
        jogo.start();

        //frame.setPreferredSize(new Dimension(width, height));

    }
}
