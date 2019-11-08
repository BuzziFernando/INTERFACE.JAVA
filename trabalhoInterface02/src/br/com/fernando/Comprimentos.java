package br.com.fernando;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Comprimentos extends JPanel {

    private JTextField txtorigem;
    private JTextField txtdestino;
    private JComboBox<String> opcoesOrigem;
    private JComboBox<String> opcoesDestino;
    private JLabel lblorigem;
    private JLabel lbldestino;
    private JButton bttninverter;
    private JButton bttnconverter;
    // private String comprimentosorigem;
    // private String comprimentosdestino;

    public Comprimentos() {

        setLayout();

    }

    private void setLayout() {

        // Início Bloco JComboBox Comprimento Origem
        setLayout(null);

        String comprimentosorigem [] = {"quilômetro","metro","centímetro","milímetro"};

        opcoesOrigem = new JComboBox<String>(comprimentosorigem);
        opcoesOrigem.setBounds(80, 65, 100, 30);
        // comboBoxOrigem.setSelectedIndex(-1);

        // Fim Bloco JComboBox Comprimento Origem

        // Início Bloco JComboBox Comprimento Destino

        String comprimentosdestino [] = {"quilômetro","metro","centímetro","milímetro"};

        opcoesDestino = new JComboBox<String>(comprimentosdestino);
        opcoesDestino.setBounds(320, 65, 100, 30);
        // comboBoxDestino.setSelectedIndex(-1);

        // Fim Bloco JComboBox Comprimento Destino

        lblorigem = new JLabel("De: ");
        lblorigem.setForeground(Color.BLACK);
        lblorigem.setBounds(35, 65, 80, 30);

        txtorigem = new JTextField(200);
        txtorigem.setBounds(80, 125, 100, 30);

        lbldestino = new JLabel("Para: ");
        lbldestino.setForeground(Color.BLACK);
        lbldestino.setBounds(265, 65, 80, 30);

        txtdestino = new JTextField(200);
        txtdestino.setBounds(320, 125, 100, 30);
        txtdestino.setEditable(false);

        bttninverter = new JButton("<=>");
        bttninverter.setBounds(195, 65, 55, 30);

        // Ação do Botão Inverter

        bttninverter.addActionListener(e -> inverterOpcoes());

        // Fim Ação Botão Inverter

        bttnconverter = new JButton("Converter!!");
        bttnconverter.setBounds(320, 185, 100, 30);

        // Ação do Botão Converter

        bttnconverter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String comprimentode = (String) opcoesOrigem.getSelectedItem();
                String comprimentopara = (String) opcoesDestino.getSelectedItem();

                double valorde = Double.parseDouble(txtorigem.getText());
                double valorpara = 0;

                if(comprimentode.equals("quilômetro")&& comprimentopara.equals("metro")) {
                    valorpara = valorde * 1000;
                }

                if(comprimentode.equals("metro")&& comprimentopara.equals("quilômetro")) {
                    valorpara = valorde / 1000;
                }

                if(comprimentode.equals("quilômetro")&& comprimentopara.equals("centímetro")) {
                    valorpara = valorde * 100000;
                }

                if(comprimentode.equals("centímetro")&& comprimentopara.equals("quilômetro")) {
                    valorpara = valorde / 100000;
                }

                if(comprimentode.equals("quilômetro")&& comprimentopara.equals("milímetro")) {
                    valorpara = valorde * 1000000;
                }

                if(comprimentode.equals("milímetro")&& comprimentopara.equals("quilômetro")) {
                    valorpara = valorde / 1000000;
                }

                if(comprimentode.equals("metro")&& comprimentopara.equals("centímetro")) {
                    valorpara = valorde * 100;
                }

                if(comprimentode.equals("centímetro")&& comprimentopara.equals("metro")) {
                    valorpara = valorde / 100;
                }

                if(comprimentode.equals("metro")&& comprimentopara.equals("milímetro")) {
                    valorpara = valorde * 1000;
                }

                if(comprimentode.equals("milímetro")&& comprimentopara.equals("metro")) {
                    valorpara = valorde / 1000;
                }

                if(comprimentode.equals("centímetro")&& comprimentopara.equals("milímetro")) {
                    valorpara = valorde * 10;
                }

                if(comprimentode.equals("milímetro")&& comprimentopara.equals("centímetro")) {
                    valorpara = valorde / 10;
                }

                txtdestino.setText(String.format("%.2f", valorpara));

            }
        });

        // Fim Ação Botão Converter

        // Adiciona os itens no frame
        add(lblorigem);
        add(lbldestino);
        add(opcoesOrigem);
        add(opcoesDestino);
        add(txtorigem);
        add(txtdestino);
        add(bttninverter);
        add(bttnconverter);

    }

    private void inverterOpcoes() {

        int de = opcoesOrigem.getSelectedIndex();
        opcoesOrigem.setSelectedIndex(opcoesDestino.getSelectedIndex());
        opcoesDestino.setSelectedIndex(de);

    }

    public void LimparCampos() {
        txtorigem.setText("");
        txtdestino.setText("");
    }

}