package Models;

import DesignPatterns.RelatoInstance;

public class SemafaroProblema extends Relatos
{
    public String TipoProblema;
    
    public SemafaroProblema(String motivo, String descricao, String data, String endereco, String cidade, 
                            int nivelPreocupacao, String tipoProblema)
    {
        super(motivo, descricao, data, endereco, cidade, nivelPreocupacao);
        this.TipoProblema = tipoProblema;
        RelatoInstance.SemafaroProblemaCount++;
    }

    private SemafaroProblema(SemafaroProblema s)
    {
        super(s.Motivo, s.Descricao, s.Data, s.Endereco, s.Cidade, s.NivelPreocupacao);
        this.TipoProblema = s.TipoProblema;
    }

    public SemafaroProblema Clone()
    {
        return new SemafaroProblema(this);
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
