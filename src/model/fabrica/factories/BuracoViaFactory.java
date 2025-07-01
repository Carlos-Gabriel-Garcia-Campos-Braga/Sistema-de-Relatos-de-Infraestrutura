package model.fabrica.factories;

import model.entities.BuracoVia;
import model.entities.Relatos;
import model.fabrica.AbstractRelatoFactory;

public class BuracoViaFactory extends AbstractRelatoFactory {
    
    @Override
    public Relatos criarRelato(String tipo, String motivo, String descricao, 
                              String data, String endereco, String cidade, 
                              int nivelPreocupacao, Object... parametrosAdicionais) {
        return new BuracoVia(motivo, descricao, data, endereco, cidade, nivelPreocupacao);
    }
    
    // Método específico para criar BuracoVia
    public BuracoVia criarBuracoVia(String motivo, String descricao, String data, 
                                   String endereco, String cidade, int nivelPreocupacao) {
        return new BuracoVia(motivo, descricao, data, endereco, cidade, nivelPreocupacao);
    }
} 