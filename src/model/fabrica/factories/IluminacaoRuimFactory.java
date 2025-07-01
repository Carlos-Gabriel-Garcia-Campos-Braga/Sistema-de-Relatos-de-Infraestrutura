package model.fabrica.factories;

import model.entities.IluminacaoRuim;
import model.entities.Relatos;
import model.fabrica.AbstractRelatoFactory;

public class IluminacaoRuimFactory extends AbstractRelatoFactory {
    
    @Override
    public Relatos criarRelato(String tipo, String motivo, String descricao, 
                              String data, String endereco, String cidade, 
                              int nivelPreocupacao, Object... parametrosAdicionais) {
        if (parametrosAdicionais.length >= 2) {
            int qtdLampadasQueimadas = (Integer) parametrosAdicionais[0];
            int nivelIluminacao = (Integer) parametrosAdicionais[1];
            return new IluminacaoRuim(motivo, descricao, data, endereco, cidade, 
                                     nivelPreocupacao, qtdLampadasQueimadas, nivelIluminacao);
        }
        throw new IllegalArgumentException("Parâmetros adicionais necessários para IluminacaoRuim");
    }
    
    // Método específico para criar IluminacaoRuim
    public IluminacaoRuim criarIluminacaoRuim(String motivo, String descricao, String data, 
                                             String endereco, String cidade, int nivelPreocupacao, 
                                             int qtdLampadasQueimadas, int nivelIluminacao) {
        return new IluminacaoRuim(motivo, descricao, data, endereco, cidade, 
                                 nivelPreocupacao, qtdLampadasQueimadas, nivelIluminacao);
    }
} 