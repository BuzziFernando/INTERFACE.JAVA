package br.com.fernando;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Instancia a nova Janela
                ConversorUniversal conversor = new ConversorUniversal();
                // Finaliza o programa quando fechar a janela
                conversor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // Exibe a Janela
                conversor.show();

            }
        });

    }

}