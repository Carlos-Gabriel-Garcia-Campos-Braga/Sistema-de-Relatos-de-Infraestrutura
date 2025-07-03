package model.fabrica;

import model.entities.BuracoVia;
import model.entities.IluminacaoRuim;
import model.entities.LixoIrregular;
import model.entities.Relatos;
import model.entities.SemaforoProblema;
import model.fabrica.factories.*;

public class Fabrica {
    
    // Método principal para criar relatos usando Abstract Factory
    public static Relatos criarRelato(String tipo, String descricao, String data, String endereco, String cidade, int nivelPreocupacao, Object... parametrosAdicionais) {
        AbstractRelatoFactory factory = AbstractRelatoFactory.getFactory(tipo);
        return factory.criarRelato(tipo, descricao, data, endereco, cidade, nivelPreocupacao, parametrosAdicionais);
    }
    
    // Métodos específicos para cada tipo de relato
    public static BuracoVia criarBuracoVia(String descricao, String data, String endereco, String cidade, int nivelPreocupacao) {
        BuracoViaFactory factory = new BuracoViaFactory();
        return factory.criarBuracoVia(descricao, data, endereco, cidade, nivelPreocupacao);
    }

    public static IluminacaoRuim criarIluminacaoRuim(String descricao, String data, String endereco, String cidade, int nivelPreocupacao, int qtdLampadasQueimadas, int nivelIluminacao) {
        IluminacaoRuimFactory factory = new IluminacaoRuimFactory();
        return factory.criarIluminacaoRuim(descricao, data, endereco, cidade, nivelPreocupacao, qtdLampadasQueimadas, nivelIluminacao);
    }

    public static LixoIrregular criarLixoIrregular(String descricao, String data, String endereco, String cidade, int nivelPreocupacao, String tipoLixo, int quantidade) {
        LixoIrregularFactory factory = new LixoIrregularFactory();
        return factory.criarLixoIrregular(descricao, data, endereco, cidade, nivelPreocupacao, tipoLixo, quantidade);
    }

    public static SemaforoProblema criarSemaforoProblema(String descricao, String data, String endereco, String cidade, int nivelPreocupacao, String tipoProblema) {
        SemaforoProblemaFactory factory = new SemaforoProblemaFactory();
        return factory.criarSemaforoProblema(descricao, data, endereco, cidade, nivelPreocupacao, tipoProblema);
    }
}