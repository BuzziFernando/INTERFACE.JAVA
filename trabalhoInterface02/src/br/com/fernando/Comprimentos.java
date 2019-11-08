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

        // In�cio Bloco JComboBox Comprimento Origem
        setLayout(null);

        String comprimentosorigem [] = {"quil�metro","metro","cent�metro","mil�metro"};

        opcoesOrigem = new JComboBox<String>(comprimentosorigem);
        opcoesOrigem.setBounds(80, 65, 100, 30);
        // comboBoxOrigem.setSelectedIndex(-1);

        // Fim Bloco JComboBox Comprimento Origem

        // In�cio Bloco JComboBox Comprimento Destino

        String comprimentosdestino [] = {"quil�metro","metro","cent�metro","mil�metro"};

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

        // A��o do Bot�o Inverter

        bttninverter.addActionListener(e -> inverterOpcoes());

        // Fim A��o Bot�o Inverter

        bttnconverter = new JButton("Converter!!");
        bttnconverter.setBounds(320, 185, 100, 30);

        // A��o do Bot�o Converter

        bttnconverter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String comprimentode = (String) opcoesOrigem.getSelectedItem();
                String comprimentopara = (String) opcoesDestino.getSelectedItem();

                double valorde = Double.parseDouble(txtorigem.getText());
                double valorpara = 0;

                if(comprimentode.equals("quil�metro")&& comprimentopara.equals("metro")) {
                    valorpara = valorde * 1000;
                }

                if(comprimentode.equals("metro")&& comprimentopara.equals("quil�metro")) {
                    valorpara = valorde / 1000;
                }

                if(comprimentode.equals("quil�metro")&& comprimentopara.equals("cent�metro")) {
                    valorpara = valorde * 100000;
                }

                if(comprimentode.equals("cent�metro")&& comprimentopara.equals("quil�metro")) {
                    valorpara = valorde / 100000;
                }

                if(comprimentode.equals("quil�metro")&& comprimentopara.equals("mil�metro")) {
                    valorpara = valorde * 1000000;
                }

                if(comprimentode.equals("mil�metro")&& comprimentopara.equals("quil�metro")) {
                    valorpara = valorde / 1000000;
                }

                if(comprimentode.equals("metro")&& comprimentopara.equals("cent�metro")) {
                    valorpara = valorde * 100;
                }

                if(comprimentode.equals("cent�metro")&& comprimentopara.equals("metro")) {
                    valorpara = valorde / 100;
                }

                if(comprimentode.equals("metro")&& comprimentopara.equals("mil�metro")) {
                    valorpara = valorde * 1000;
                }

                if(comprimentode.equals("mil�metro")&& comprimentopara.equals("metro")) {
                    valorpara = valorde / 1000;
                }

                if(comprimentode.equals("cent�metro")&& comprimentopara.equals("mil�metro")) {
                    valorpara = valorde * 10;
                }

                if(comprimentode.equals("mil�metro")&& comprimentopara.equals("cent�metro")) {
                    valorpara = valorde / 10;
                }

                txtdestino.setText(String.format("%.2f", valorpara));

            }
        });

        // Fim A��o Bot�o Converter

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