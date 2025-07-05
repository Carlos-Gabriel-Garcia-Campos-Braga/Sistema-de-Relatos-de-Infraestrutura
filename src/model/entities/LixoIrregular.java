package model.entities;

import model.behavior.Verificalixo;
import model.designPatterns.RelatoInstance;
import model.util.exception.ExcecoesPersonalizadas;

public class LixoIrregular extends Relatos implements java.io.Serializable
{
    private String TipoLixo;
    private int quantidade;
    private Verificalixo vL = new Verificalixo();

    public LixoIrregular(String descricao, String data, String endereco, String cidade, int nivelPreocupacao, String tipoLixo, int quantidade)
    {
        super(descricao, data, endereco, cidade, nivelPreocupacao);
        this.TipoLixo = tipoLixo;
        this.quantidade = quantidade;
        RelatoInstance.getInstance().incrementarLixoIrregularCount();
        this.addObserver(vL); // Registrar observer usando método padrão do Java
    }
    //Prototype
    private LixoIrregular(LixoIrregular l)
    {
        super(l.Descricao, l.Data, l.Endereco, l.Cidade, l.NivelPreocupacao);
        this.TipoLixo = l.TipoLixo;
        this.quantidade = l.quantidade;
        this.addObserver(vL); // Registrar observer no clone também
    }
    public LixoIrregular Clone()
    {
        return new LixoIrregular(this);
    }

    // Getters
    public String getTipoLixo() {
        return TipoLixo;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    // Setters
    public void setTipoLixo(String tipoLixo) 
    {
        if(tipoLixo.isEmpty() || tipoLixo == null || tipoLixo.length() < 3)
        {
            throw new ExcecoesPersonalizadas("Tipo de lixo inválido!");
        }
        this.TipoLixo = tipoLixo;
    }

    public void setQuantidade(int quantidade) 
    {
        if(quantidade < 1)
        {
            throw new ExcecoesPersonalizadas("Quantidade inválida!");
        }
        
        this.quantidade = quantidade;
        this.notificarObservers("Quantidade alterada"); // Notificar observer usando padrão Java
    }
    
    @Override
    public String toString()
    {
        return "Lixo Irregular: \n" +
               "Descrição: " + Descricao + "\n" +
               "Data: " + Data + "\n" +
               "Endereço: " + Endereco + "\n" +
               "Cidade: " + Cidade + "\n" +
               "Nível de Preocupação: " + NivelPreocupacao + "\n" +
               "Tipo de Lixo: " + TipoLixo + "\n" +
               "Quantidade: " + quantidade;
    }
}
