package model.fabrica.factories;

import model.entities.LixoIrregular;
import model.entities.Relatos;
import model.fabrica.AbstractRelatoFactory;

public class LixoIrregularFactory extends AbstractRelatoFactory {
    
    @Override
    public Relatos criarRelato(String tipo, String descricao, String data, String endereco, String cidade, int nivelPreocupacao, Object... parametrosAdicionais) {
        if (parametrosAdicionais.length >= 2) {
            String tipoLixo = (String) parametrosAdicionais[0];
            int quantidade = (Integer) parametrosAdicionais[1];
            return new LixoIrregular(descricao, data, endereco, cidade, nivelPreocupacao, tipoLixo, quantidade);
        }
        throw new IllegalArgumentException("Parâmetros adicionais necessários para LixoIrregular");
    }
    
    // Método específico para criar LixoIrregular
    public LixoIrregular criarLixoIrregular(String descricao, String data, String endereco, String cidade, int nivelPreocupacao, String tipoLixo, int quantidade) {
        return new LixoIrregular(descricao, data, endereco, cidade, nivelPreocupacao, tipoLixo, quantidade);
    }
} 