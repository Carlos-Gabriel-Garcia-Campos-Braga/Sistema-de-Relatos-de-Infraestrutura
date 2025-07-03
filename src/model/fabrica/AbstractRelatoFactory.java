package model.fabrica;

import model.entities.Relatos;
import model.fabrica.factories.*;

public abstract class AbstractRelatoFactory {
    
    // Método abstrato para criar relatos
    public abstract Relatos criarRelato(String tipo, String descricao, String data, String endereco, String cidade, int nivelPreocupacao, Object... parametrosAdicionais);
    
    // Método factory para obter a fábrica específica
    public static AbstractRelatoFactory getFactory(String tipo) {
        switch (tipo.toUpperCase()) {
            case "BURACO":
                return new BuracoViaFactory();
            case "ILUMINACAO":
                return new IluminacaoRuimFactory();
            case "LIXO":
                return new LixoIrregularFactory();
            case "SEMAFORO":
                return new SemaforoProblemaFactory();
            default:
                throw new IllegalArgumentException("Tipo de relato não suportado: " + tipo);
        }
    }
} 