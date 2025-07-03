package model.entities;

import model.designPatterns.RelatoInstance;

public class BuracoVia extends Relatos implements java.io.Serializable
{
    
    public BuracoVia(String descricao, String data, String endereco, String cidade, int nivelPreocupacao)
    {
        super(descricao, data, endereco, cidade, nivelPreocupacao);
        
        RelatoInstance.getInstance().incrementarBuracoViaCount();
    }
    //Prototype
    private BuracoVia(BuracoVia b)
    {
        super(b.Descricao, b.Data, b.Endereco, b.Cidade, b.NivelPreocupacao);
    }

    public BuracoVia Clone()
    {            
        return new BuracoVia(this);
    }

    @Override
    public String toString()
    {
        return "Buraco na via\nDescrição: " + Descricao + "\nData: " + Data + "\nEndereço: " + Endereco + 
               "\nCidade: " + Cidade + "\nNível de Preocupação: " + NivelPreocupacao;
    }

    
}
