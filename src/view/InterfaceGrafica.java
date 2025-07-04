package view;

import model.entities.*;
import model.designPatterns.RelatoInstance;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class InterfaceGrafica {
    private static DefaultListModel<Relatos> listModel = new DefaultListModel<>();
    private static JList<Relatos> list = new JList<>(listModel);
    private static DefaultTableModel tableModel = new DefaultTableModel(
        new String[]{"Tipo", "Descrição", "Data", "Endereço", "Cidade", "Nível", "Qtd. Lâmpadas", "Nível Iluminação", "Tipo de Lixo", "Qtd. Lixo", "Tipo de Problema"}, 0
    );
    private static JTable table = new JTable(tableModel) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    // Protótipos padrão para cada tipo de relato (valores válidos para evitar exceção)
    private static final BuracoVia prototipoBuraco = new BuracoVia("Protótipo", "01/01/2000", "Protótipo", "Protótipo", 1);
    private static final IluminacaoRuim prototipoIluminacao = new IluminacaoRuim("Protótipo", "01/01/2000", "Protótipo", "Protótipo", 1, 0, 0);
    private static final LixoIrregular prototipoLixo = new LixoIrregular("Protótipo", "01/01/2000", "Protótipo", "Protótipo", 1, "Protótipo", 1);
    private static final SemaforoProblema prototipoSemaforo = new SemaforoProblema("Protótipo", "01/01/2000", "Protótipo", "Protótipo", 1, "Protótipo");

    private ArrayList<Relatos> relatos;
    private Runnable onRelatoCadastrado;

    public InterfaceGrafica(ArrayList<Relatos> relatos, Runnable onRelatoCadastrado) {
        this.relatos = relatos;
        this.onRelatoCadastrado = onRelatoCadastrado;
    }

    public void atualizarRelatos(ArrayList<Relatos> novosRelatos) {
        this.relatos = novosRelatos;
        atualizarTabelaVisual();
    }

    public void criarInterface() {
        JFrame frame = new JFrame("Sistema de Ocorrências - Smart City");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Cadastrar Relato", criarPainelCadastro());
        tabbedPane.addTab("Relatos Cadastrados", criarPainelListagem());
        frame.add(tabbedPane, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Atualizar a tabela após a interface estar pronta
        atualizarTabelaVisual();
    }

    private JPanel criarPainelCadastro() {
        JPanel panel = new JPanel(new GridLayout(0,2,5,5));
        String[] tipos = {"BuracoVia", "IluminacaoRuim", "LixoIrregular", "SemaforoProblema"};
        JComboBox<String> tipoBox = new JComboBox<>(tipos);
        JTextField descricaoField = new JTextField();
        JTextField dataField = new JTextField();
        JTextField enderecoField = new JTextField();
        JTextField cidadeField = new JTextField();
        JTextField nivelPreocupacaoField = new JTextField();
        JTextField extra1Field = new JTextField();
        JTextField extra2Field = new JTextField();
        JLabel extra1Label = new JLabel();
        JLabel extra2Label = new JLabel();

        tipoBox.addActionListener(e -> {
            String tipo = (String) tipoBox.getSelectedItem();
            switch (tipo) {
                case "BuracoVia":
                    extra1Label.setText(""); extra1Field.setVisible(false);
                    extra2Label.setText(""); extra2Field.setVisible(false);
                    break;
                case "IluminacaoRuim":
                    extra1Label.setText("Qtd. Lâmpadas Queimadas:"); extra1Field.setVisible(true);
                    extra2Label.setText("Nível Iluminação (0-10):"); extra2Field.setVisible(true);
                    break;
                case "LixoIrregular":
                    extra1Label.setText("Tipo de Lixo:"); extra1Field.setVisible(true);
                    extra2Label.setText("Quantidade:"); extra2Field.setVisible(true);
                    break;
                case "SemaforoProblema":
                    extra1Label.setText("Tipo de Problema:"); extra1Field.setVisible(true);
                    extra2Label.setText(""); extra2Field.setVisible(false);
                    break;
            }
            panel.revalidate();
            panel.repaint();
        });
        tipoBox.setSelectedIndex(0);

        panel.add(new JLabel("Tipo de Relato:")); panel.add(tipoBox);
        panel.add(new JLabel("Descrição:")); panel.add(descricaoField);
        panel.add(new JLabel("Data:")); panel.add(dataField);
        panel.add(new JLabel("Endereço:")); panel.add(enderecoField);
        panel.add(new JLabel("Cidade:")); panel.add(cidadeField);
        panel.add(new JLabel("Nível de Preocupação:")); panel.add(nivelPreocupacaoField);
        panel.add(extra1Label); panel.add(extra1Field);
        panel.add(extra2Label); panel.add(extra2Field);

        JButton cadastrarBtn = new JButton("Cadastrar");
        panel.add(new JLabel()); panel.add(cadastrarBtn);

        cadastrarBtn.addActionListener(e -> {
            try {
                String tipo = (String) tipoBox.getSelectedItem();
                String descricao = descricaoField.getText();
                String data = dataField.getText();
                String endereco = enderecoField.getText();
                String cidade = cidadeField.getText();
                int nivelPreocupacao = Integer.parseInt(nivelPreocupacaoField.getText());
                Relatos relato = null;
                switch (tipo) {
                    case "BuracoVia": {
                        BuracoVia clone = prototipoBuraco.Clone();
                        clone.setDescricao(descricao);
                        clone.setData(data);
                        clone.setEndereco(endereco);
                        clone.setCidade(cidade);
                        clone.setNivelPreocupacao(nivelPreocupacao);
                        relato = clone;
                        break;
                    }
                    case "IluminacaoRuim": {
                        int qtdLampadas = Integer.parseInt(extra1Field.getText());
                        int nivelIlum = Integer.parseInt(extra2Field.getText());
                        IluminacaoRuim clone = prototipoIluminacao.Clone();
                        clone.setDescricao(descricao);
                        clone.setData(data);
                        clone.setEndereco(endereco);
                        clone.setCidade(cidade);
                        clone.setNivelPreocupacao(nivelPreocupacao);
                        clone.setQtdLampadasQueimadas(qtdLampadas);
                        clone.setNivelIluminacao(nivelIlum);
                        relato = clone;
                        break;
                    }
                    case "LixoIrregular": {
                        String tipoLixo = extra1Field.getText();
                        int quantidade = Integer.parseInt(extra2Field.getText());
                        LixoIrregular clone = prototipoLixo.Clone();
                        clone.setDescricao(descricao);
                        clone.setData(data);
                        clone.setEndereco(endereco);
                        clone.setCidade(cidade);
                        clone.setNivelPreocupacao(nivelPreocupacao);
                        clone.setTipoLixo(tipoLixo);
                        clone.setQuantidade(quantidade);
                        relato = clone;
                        break;
                    }
                    case "SemaforoProblema": {
                        String tipoProblema = extra1Field.getText();
                        SemaforoProblema clone = prototipoSemaforo.Clone();
                        clone.setDescricao(descricao);
                        clone.setData(data);
                        clone.setEndereco(endereco);
                        clone.setCidade(cidade);
                        clone.setNivelPreocupacao(nivelPreocupacao);
                        clone.TipoProblema = tipoProblema;
                        relato = clone;
                        break;
                    }
                }
                if (relato != null) {
                    relatos.add(relato);
                    onRelatoCadastrado.run();
                    JOptionPane.showMessageDialog(panel, "Relato cadastrado com sucesso!");
                    atualizarTabelaVisual();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Erro ao cadastrar: " + ex.getMessage());
            }
        });
        return panel;
    }

    private JPanel criarPainelListagem() {
        JPanel panel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton atualizarBtn = new JButton("Atualizar");
        JButton contagemBtn = new JButton("Contagem de Relatos");
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnPanel.add(atualizarBtn);
        btnPanel.add(contagemBtn);
        panel.add(btnPanel, BorderLayout.SOUTH);

        atualizarBtn.addActionListener(e -> {
            atualizarTabelaVisual();
        });

        contagemBtn.addActionListener(e -> {
            String msg = String.format(
                "Buraco na Via: %d\nIluminação Ruim: %d\nLixo Irregular: %d\nSemáforo com Problema: %d",
                RelatoInstance.getInstance().getBuracoViaCount(),
                RelatoInstance.getInstance().getIluminacaoRuimCount(),
                RelatoInstance.getInstance().getLixoIrregularCount(),
                RelatoInstance.getInstance().getSemaforoProblemaCount()
            );
            JOptionPane.showMessageDialog(panel, msg, "Contagem de Relatos", JOptionPane.INFORMATION_MESSAGE);
        });

        return panel;
    }

    public void atualizarTabelaVisual() {
        tableModel.setRowCount(0);
        for (Relatos r : relatos) {
            String tipo = r.getClass().getSimpleName();
            String descricao = r.getDescricao();
            String data = r.getData();
            String endereco = r.getEndereco();
            String cidade = r.getCidade();
            String nivel = String.valueOf(r.getNivelPreocupacao());
            String qtdLampadas = "", nivelIlum = "", tipoLixo = "", qtdLixo = "", tipoProblema = "";
            if (r instanceof IluminacaoRuim) {
                qtdLampadas = String.valueOf(((IluminacaoRuim) r).qtdLampadasQueimadas);
                nivelIlum = String.valueOf(((IluminacaoRuim) r).nivelIluminacao);
            } else if (r instanceof LixoIrregular) {
                tipoLixo = ((LixoIrregular) r).TipoLixo;
                qtdLixo = String.valueOf(((LixoIrregular) r).quantidade);
            } else if (r instanceof SemaforoProblema) {
                tipoProblema = ((SemaforoProblema) r).TipoProblema;
            }
            tableModel.addRow(new Object[]{tipo, descricao, data, endereco, cidade, nivel, qtdLampadas, nivelIlum, tipoLixo, qtdLixo, tipoProblema});
        }
    }

    // Classe auxiliar para mostrar resumo na lista
    public static class RelatoResumo extends Relatos {
        public final Relatos relato;
        private final String resumo;
        public RelatoResumo(Relatos relato, String resumo) {
            super(relato.getDescricao(), relato.getData(), relato.getEndereco(), relato.getCidade(), relato.getNivelPreocupacao());
            this.relato = relato;
            this.resumo = resumo;
        }
        @Override
        public String toString() {
            return resumo;
        }
    }
} 