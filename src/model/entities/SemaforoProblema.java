package model.entities;

import model.behavior.VerificaSemaforo;
import model.designPatterns.RelatoInstance;
import model.util.exception.ExcecoesPersonalizadas;

public class SemaforoProblema extends Relatos implements java.io.Serializable
{
    public String TipoProblema;
    private VerificaSemaforo vS = new VerificaSemaforo();

    public SemaforoProblema(String descricao, String data, String endereco, String cidade, int nivelPreocupacao, String tipoProblema)
    {
        super(descricao, data, endereco, cidade, nivelPreocupacao);
        this.TipoProblema = tipoProblema;
        RelatoInstance.getInstance().incrementarSemaforoProblemaCount();
        this.addObserver(vS); // Registrar observer usando método padrão do Java
    }
    //Prototype
    private SemaforoProblema(SemaforoProblema s)
    {
        super(s.Descricao, s.Data, s.Endereco, s.Cidade, s.NivelPreocupacao);
        this.TipoProblema = s.TipoProblema;
        this.addObserver(vS); // Registrar observer no clone também
    }

    public SemaforoProblema Clone()
    {
        return new SemaforoProblema(this);
    }

    public void setTipoProblema(String tipoProblema) 
    {
        if(tipoProblema.isEmpty() || tipoProblema == null || tipoProblema.length() < 3)
        {
            throw new ExcecoesPersonalizadas("Tipo de problema inválido!");
        }
        this.TipoProblema = tipoProblema;
        this.notificarObservers("Tipo de problema alterado"); // Notificar observer
    }

    @Override
    public void setNivelPreocupacao(int nivelPreocupacao) 
    {
        super.setNivelPreocupacao(nivelPreocupacao);
        this.notificarObservers("Nível de preocupação alterado"); // Notificar observer
    }

    @Override
    public String toString()
    {
        return "Semáforo com Problema: \n" +
               "Descrição: " + Descricao + "\n" +
               "Data: " + Data + "\n" +
               "Endereço: " + Endereco + "\n" +
               "Cidade: " + Cidade + "\n" +
               "Nível de Preocupação: " + NivelPreocupacao + "\n" +
               "Tipo de Problema: " + TipoProblema;
    }
}
