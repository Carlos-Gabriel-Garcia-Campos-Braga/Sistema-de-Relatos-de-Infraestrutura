package model.entities;

import model.behavior.Verificalixo;
import model.designPatterns.RelatoInstance;
import model.util.exception.ExcecoesPersonalizadas;

public class LixoIrregular extends Relatos
{
    public String TipoLixo;
    public int quantidade;
    public Verificalixo vL = new Verificalixo();

    public LixoIrregular(String motivo, String descricao, String data, String endereco, String cidade, 
                         int nivelPreocupacao, String tipoLixo, int quantidade)
    {
        super(motivo, descricao, data, endereco, cidade, nivelPreocupacao);
        this.TipoLixo = tipoLixo;
        this.quantidade = quantidade;
        
        RelatoInstance.getInstance().incrementarLixoIrregularCount();
    }
    //Observer
    public LixoIrregular( String descricao, String data, String endereco, String cidade, 
                         int nivelPreocupacao, String tipoLixo, int quantidade)
    {
        super("Not defined", descricao, data, endereco, cidade, nivelPreocupacao);
        this.TipoLixo = tipoLixo;
        this.quantidade = quantidade;
        this.notifyObservers();
        RelatoInstance.getInstance().incrementarLixoIrregularCount();
    }

    // Construtor de cópia para o padrão Prototype
    private LixoIrregular(LixoIrregular l)
    {
        super(l.Motivo, l.Descricao, l.Data, l.Endereco, l.Cidade, l.NivelPreocupacao);
        this.TipoLixo = l.TipoLixo;
        this.quantidade = l.quantidade;
    }

    // Método Clone para o padrão Prototype
    public LixoIrregular Clone()
    {
        return new LixoIrregular(this);
    }

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
        this.notifyObservers();
    }
    public void notifyObservers(){
        
       
        vL.update( this);
        
    }
    
    @Override
    public String toString()
    {
        return "Lixo Irregular: \n" +
               "Motivo: " + Motivo + "\n" +
               "Descrição: " + Descricao + "\n" +
               "Data: " + Data + "\n" +
               "Endereço: " + Endereco + "\n" +
               "Cidade: " + Cidade + "\n" +
               "Nível de Preocupação: " + NivelPreocupacao + "\n" +
               "Tipo de Lixo: " + TipoLixo + "\n" +
               "Quantidade: " + quantidade;
    }
}
