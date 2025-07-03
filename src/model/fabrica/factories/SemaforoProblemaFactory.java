package model.fabrica.factories;

import model.entities.SemaforoProblema;
import model.entities.Relatos;
import model.fabrica.AbstractRelatoFactory;

public class SemaforoProblemaFactory extends AbstractRelatoFactory {
    
    @Override
    public Relatos criarRelato(String tipo, String descricao, String data, String endereco, String cidade, int nivelPreocupacao, Object... parametrosAdicionais) {
        if (parametrosAdicionais.length >= 1) {
            String tipoProblema = (String) parametrosAdicionais[0];
            return new SemaforoProblema(descricao, data, endereco, cidade, nivelPreocupacao, tipoProblema);
        }
        throw new IllegalArgumentException("Parâmetros adicionais necessários para SemaforoProblema");
    }
    
    // Método específico para criar SemaforoProblema
    public SemaforoProblema criarSemaforoProblema(String descricao, String data, String endereco, String cidade, int nivelPreocupacao, String tipoProblema) {
        return new SemaforoProblema(descricao, data, endereco, cidade, nivelPreocupacao, tipoProblema);
    }
} 