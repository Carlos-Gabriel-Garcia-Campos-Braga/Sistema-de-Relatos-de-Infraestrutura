package model.util.persistencia;

import model.entities.*;
import java.io.*;
import java.util.ArrayList;

public class GerenciadorArquivos {
    private static final String FILE_NAME = "relatos.csv";

    public static void salvarRelatos(ArrayList<Relatos> relatos) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Relatos r : relatos) {
                String tipo = r.getClass().getSimpleName();
                if (r instanceof BuracoVia) {
                    pw.printf("BuracoVia;%s;%s;%s;%s;%d\n",
                        r.getDescricao(), r.getData(), r.getEndereco(), r.getCidade(), r.getNivelPreocupacao()
                    );
                } else if (r instanceof IluminacaoRuim) {
                    IluminacaoRuim ir = (IluminacaoRuim) r;
                    pw.printf("IluminacaoRuim;%s;%s;%s;%s;%d;%d;%d\n",
                        ir.getDescricao(), ir.getData(), ir.getEndereco(), ir.getCidade(), ir.getNivelPreocupacao(), ir.qtdLampadasQueimadas, ir.nivelIluminacao
                    );
                } else if (r instanceof LixoIrregular) {
                    LixoIrregular li = (LixoIrregular) r;
                    pw.printf("LixoIrregular;%s;%s;%s;%s;%d;%s;%d\n",
                        li.getDescricao(), li.getData(), li.getEndereco(), li.getCidade(), li.getNivelPreocupacao(), li.TipoLixo, li.quantidade
                    );
                } else if (r instanceof SemaforoProblema) {
                    SemaforoProblema sp = (SemaforoProblema) r;
                    pw.printf("SemaforoProblema;%s;%s;%s;%s;%d;%s\n",
                        sp.getDescricao(), sp.getData(), sp.getEndereco(), sp.getCidade(), sp.getNivelPreocupacao(), sp.TipoProblema
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Relatos> carregarRelatos() {
        ArrayList<Relatos> relatos = new ArrayList<>();
        
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
        
        return relatos;
    }

    public static void resetarContadores() {
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
    }
} 