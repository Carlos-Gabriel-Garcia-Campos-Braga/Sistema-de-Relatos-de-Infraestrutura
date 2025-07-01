package model.entities;

import model.designPatterns.RelatoInstance;

public class SemaforoProblema extends Relatos
{
    public String TipoProblema;
    
    public SemaforoProblema(String motivo, String descricao, String data, String endereco, String cidade, 
                            int nivelPreocupacao, String tipoProblema)
    {
        super(motivo, descricao, data, endereco, cidade, nivelPreocupacao);
        this.TipoProblema = tipoProblema;
        RelatoInstance.getInstance().incrementarSemaforoProblemaCount();
    }

    private SemaforoProblema(SemaforoProblema s)
    {
        super(s.Motivo, s.Descricao, s.Data, s.Endereco, s.Cidade, s.NivelPreocupacao);
        this.TipoProblema = s.TipoProblema;
    }

    public SemaforoProblema Clone()
    {
        return new SemaforoProblema(this);
    }

    @Override
    public String toString()
    {
        return "Semáforo com Problema: \n" +
               "Motivo: " + Motivo + "\n" +
               "Descrição: " + Descricao + "\n" +
               "Data: " + Data + "\n" +
               "Endereço: " + Endereco + "\n" +
               "Cidade: " + Cidade + "\n" +
               "Nível de Preocupação: " + NivelPreocupacao + "\n" +
               "Tipo de Problema: " + TipoProblema;
    }
}
