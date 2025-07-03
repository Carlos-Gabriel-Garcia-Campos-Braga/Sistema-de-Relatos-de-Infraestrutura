package App;

import model.designPatterns.RelatoInstance;
import model.entities.*;
import model.fabrica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class App {
    private static ArrayList<Relatos> relatos = new ArrayList<>();
    private static final String FILE_NAME = "relatos.csv";

    // Protótipos padrão para cada tipo de relato (valores válidos para evitar exceção)
    private static final BuracoVia prototipoBuraco = new BuracoVia("Protótipo", "01/01/2000", "Protótipo", "Protótipo", 1);
    private static final IluminacaoRuim prototipoIluminacao = new IluminacaoRuim("Protótipo", "01/01/2000", "Protótipo", "Protótipo", 1, 0, 0);
    private static final LixoIrregular prototipoLixo = new LixoIrregular("Protótipo", "01/01/2000", "Protótipo", "Protótipo", 1, "Protótipo", 1);
    private static final SemaforoProblema prototipoSemaforo = new SemaforoProblema("Protótipo", "01/01/2000", "Protótipo", "Protótipo", 1, "Protótipo");

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            carregarRelatos();
            criarInterface();
        });
    }

    private static void criarInterface() {
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

    private static JPanel criarPainelCadastro() {
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
                    salvarRelatos();
                    JOptionPane.showMessageDialog(panel, "Relato cadastrado com sucesso!");
                    carregarRelatos();
                    atualizarTabelaVisual();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Erro ao cadastrar: " + ex.getMessage());
            }
        });
        return panel;
    }

    private static JPanel criarPainelListagem() {
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
            carregarRelatos();
            atualizarTabelaVisual();
        });

        contagemBtn.addActionListener(e -> {
            String msg = String.format(
                "Buraco na Via: %d\nIluminação Ruim: %d\nLixo Irregular: %d\nSemáforo com Problema: %d",
                model.designPatterns.RelatoInstance.getInstance().getBuracoViaCount(),
                model.designPatterns.RelatoInstance.getInstance().getIluminacaoRuimCount(),
                model.designPatterns.RelatoInstance.getInstance().getLixoIrregularCount(),
                model.designPatterns.RelatoInstance.getInstance().getSemaforoProblemaCount()
            );
            JOptionPane.showMessageDialog(panel, msg, "Contagem de Relatos", JOptionPane.INFORMATION_MESSAGE);
        });

        return panel;
    }

    private static void atualizarTabelaVisual() {
        tableModel.setRowCount(0);
        for (Relatos r : relatos) {
            String tipo = r.getClass().getSimpleName();
            String descricao = r.getDescricao();
            String data = r.getData();
            String endereco = r.getEndereco();
            String cidade = r.getCidade();
            String nivel = String.valueOf(r.getNivelPreocupacao());
            String qtdLampadas = "", nivelIlum = "", tipoLixo = "", qtdLixo = "", tipoProblema = "";
            if (r instanceof model.entities.IluminacaoRuim) {
                qtdLampadas = String.valueOf(((model.entities.IluminacaoRuim) r).qtdLampadasQueimadas);
                nivelIlum = String.valueOf(((model.entities.IluminacaoRuim) r).nivelIluminacao);
            } else if (r instanceof model.entities.LixoIrregular) {
                tipoLixo = ((model.entities.LixoIrregular) r).TipoLixo;
                qtdLixo = String.valueOf(((model.entities.LixoIrregular) r).quantidade);
            } else if (r instanceof model.entities.SemaforoProblema) {
                tipoProblema = ((model.entities.SemaforoProblema) r).TipoProblema;
            }
            tableModel.addRow(new Object[]{tipo, descricao, data, endereco, cidade, nivel, qtdLampadas, nivelIlum, tipoLixo, qtdLixo, tipoProblema});
        }
    }

    // Classe auxiliar para mostrar resumo na lista
    private static class RelatoResumo extends Relatos {
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

    private static void salvarRelatos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Relatos r : relatos) {
                String tipo = r.getClass().getSimpleName();
                if (r instanceof model.entities.BuracoVia) {
                    pw.printf("BuracoVia;%s;%s;%s;%s;%d\n",
                        r.getDescricao(), r.getData(), r.getEndereco(), r.getCidade(), r.getNivelPreocupacao()
                    );
                } else if (r instanceof model.entities.IluminacaoRuim) {
                    model.entities.IluminacaoRuim ir = (model.entities.IluminacaoRuim) r;
                    pw.printf("IluminacaoRuim;%s;%s;%s;%s;%d;%d;%d\n",
                        ir.getDescricao(), ir.getData(), ir.getEndereco(), ir.getCidade(), ir.getNivelPreocupacao(), ir.qtdLampadasQueimadas, ir.nivelIluminacao
                    );
                } else if (r instanceof model.entities.LixoIrregular) {
                    model.entities.LixoIrregular li = (model.entities.LixoIrregular) r;
                    pw.printf("LixoIrregular;%s;%s;%s;%s;%d;%s;%d\n",
                        li.getDescricao(), li.getData(), li.getEndereco(), li.getCidade(), li.getNivelPreocupacao(), li.TipoLixo, li.quantidade
                    );
                } else if (r instanceof model.entities.SemaforoProblema) {
                    model.entities.SemaforoProblema sp = (model.entities.SemaforoProblema) r;
                    pw.printf("SemaforoProblema;%s;%s;%s;%s;%d;%s\n",
                        sp.getDescricao(), sp.getData(), sp.getEndereco(), sp.getCidade(), sp.getNivelPreocupacao(), sp.TipoProblema
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void carregarRelatos() {
        relatos = new ArrayList<>();
        // Resetar contadores do Singleton
        try {
            java.lang.reflect.Field f1 = model.designPatterns.RelatoInstance.class.getDeclaredField("buracoViaCount");
            java.lang.reflect.Field f2 = model.designPatterns.RelatoInstance.class.getDeclaredField("iluminacaoRuimCount");
            java.lang.reflect.Field f3 = model.designPatterns.RelatoInstance.class.getDeclaredField("lixoIrregularCount");
            java.lang.reflect.Field f4 = model.designPatterns.RelatoInstance.class.getDeclaredField("semaforoProblemaCount");
            f1.setAccessible(true); f2.setAccessible(true); f3.setAccessible(true); f4.setAccessible(true);
            f1.setInt(model.designPatterns.RelatoInstance.getInstance(), 0);
            f2.setInt(model.designPatterns.RelatoInstance.getInstance(), 0);
            f3.setInt(model.designPatterns.RelatoInstance.getInstance(), 0);
            f4.setInt(model.designPatterns.RelatoInstance.getInstance(), 0);
        } catch (Exception e) { }
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                String tipo = campos[0];
                try {
                    if (tipo.equals("BuracoVia") && campos.length == 6) {
                        BuracoVia b = new BuracoVia(campos[1], campos[2], campos[3], campos[4], Integer.parseInt(campos[5]));
                        relatos.add(b);
                    } else if (tipo.equals("IluminacaoRuim") && campos.length == 8) {
                        IluminacaoRuim i = new IluminacaoRuim(campos[1], campos[2], campos[3], campos[4], Integer.parseInt(campos[5]), Integer.parseInt(campos[6]), Integer.parseInt(campos[7]));
                        relatos.add(i);
                    } else if (tipo.equals("LixoIrregular") && campos.length == 8) {
                        LixoIrregular l = new LixoIrregular(campos[1], campos[2], campos[3], campos[4], Integer.parseInt(campos[5]), campos[6], Integer.parseInt(campos[7]));
                        relatos.add(l);
                    } else if (tipo.equals("SemaforoProblema") && campos.length == 7) {
                        SemaforoProblema s = new SemaforoProblema(campos[1], campos[2], campos[3], campos[4], Integer.parseInt(campos[5]), campos[6]);
                        relatos.add(s);
                    }
                } catch (Exception ex) {
                    // Ignora linhas mal formatadas
                }
            }
        } catch (IOException e) {
            // Se não existir, apenas ignora
        }
    }
}
