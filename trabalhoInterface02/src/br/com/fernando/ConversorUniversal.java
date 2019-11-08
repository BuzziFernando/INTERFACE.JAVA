package br.com.fernando;


import javax.swing.*;
import java.awt.event.*;

public class ConversorUniversal extends JFrame {

    public ConversorUniversal(){
        // Titulo Janela
        setTitle("Conversor Universal");
        // Tamanho Janela
        setSize(545, 400);
        // Configura local inicial
        setLocation(1366/2 - 545/2, 768/2 - 400/2);
        // Não permite modificar o tamanho da tela
        setResizable(false);
        // Configura a tela
        setLayout();
    }

    private void setLayout() {

        criarMenu();

    }

    private void criarMenu(){

        JMenuBar menuBar = new JMenuBar();
        JTabbedPane tabPane = new JTabbedPane();
        Moedas abaMoedas = new Moedas();
        Temperaturas abaTemperaturas = new Temperaturas();
        Comprimentos abaComprimentos = new Comprimentos();

        // Cria o menu Arquivo
        JMenu menuArquivo = new JMenu("Arquivo");
        menuArquivo.setMnemonic(KeyEvent.VK_A);

        // Cria os itens do menu
        JMenuItem itemsair = new JMenuItem("Sair",KeyEvent.VK_I);
        itemsair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fecha a tela
                // frame.setVisible(false);
                // frame.dispose();
                dispatchEvent(new WindowEvent(ConversorUniversal.this, WindowEvent.WINDOW_CLOSING));
            }
        });

        // Adiciona um separador
        menuArquivo.add(itemsair);

        JMenu menuEdit = new JMenu("Editar");

        JMenuItem itemlimpacampos = new JMenuItem("Limpar Campos",KeyEvent.VK_I);
        itemlimpacampos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                abaMoedas.LimparCampos();
                abaTemperaturas.LimparCampos();
                abaComprimentos.LimparCampos();

            }
        });

        JCheckBoxMenuItem checkItemMoedas = new JCheckBoxMenuItem("Exibir Moedas");
        checkItemMoedas.setSelected(true);
        checkItemMoedas.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                // JOptionPane.showMessageDialog(null, "Item selecionado? "+checkItemMoedas.isSelected());

                if (checkItemMoedas.isSelected()){
                    tabPane.addTab("Moedas", abaMoedas);
                } else {
                    tabPane.remove(abaMoedas);
                }

            }
        });

        JCheckBoxMenuItem checkItemTemperatura = new JCheckBoxMenuItem("Exibir Temperaturas");
        checkItemTemperatura.setSelected(true);
        checkItemTemperatura.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                // JOptionPane.showMessageDialog(null, "Item selecionado? "+checkItemTemperatura.isSelected());

                if (checkItemTemperatura.isSelected()){
                    tabPane.addTab("Temperaturas", abaTemperaturas);
                } else {
                    tabPane.remove(abaTemperaturas);
                }

            }
        });

        JCheckBoxMenuItem checkItemComprimentos = new JCheckBoxMenuItem("Exibir Comprimentos");
        checkItemComprimentos.setSelected(true);
        checkItemComprimentos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                // JOptionPane.showMessageDialog(null, "Item selecionado? "+checkItemComprimentos.isSelected());

                if (checkItemComprimentos.isSelected()){
                    tabPane.addTab("Comprimentos", abaComprimentos);
                } else {
                    tabPane.remove(abaComprimentos);
                }

            }
        });

        menuEdit.add(itemlimpacampos);
        menuEdit.addSeparator();
        menuEdit.add(checkItemMoedas);
        menuEdit.add(checkItemTemperatura);
        menuEdit.add(checkItemComprimentos);

        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem itemdesenvolvedores = new JMenuItem("Desenvolvedores",KeyEvent.VK_S);
        JMenuItem itemgithub = new JMenuItem("Repositório do Github",KeyEvent.VK_S);
        JMenuItem itemsobre = new JMenuItem("Sobre",KeyEvent.VK_S);


        menuAjuda.add(itemdesenvolvedores);
        menuAjuda.add(itemgithub);
        menuAjuda.add(itemsobre);

        // Adicina o menu na barra
        menuBar.add(menuArquivo);
        menuBar.add(menuEdit);
        menuBar.add(menuAjuda);

        //Adiciona Menu Bar
        setJMenuBar(menuBar);

        tabPane.setBorder(BorderFactory.createEmptyBorder(35,35,35,35));

        tabPane.addTab("Moedas", abaMoedas);
        tabPane.addTab("Temperaturas", abaTemperaturas);
        tabPane.addTab("Comprimentos", abaComprimentos);


        // Adiciona o painel na janela
        add(tabPane);

        show();


    }

}
