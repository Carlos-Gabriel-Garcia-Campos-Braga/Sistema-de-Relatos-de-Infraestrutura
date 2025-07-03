package model.entities;

import model.designPatterns.RelatoInstance;

public class BuracoVia extends Relatos
{
    
    public BuracoVia(String motivo, String descricao, String data, String endereco, String cidade, int nivelPreocupacao)
    {
        super(motivo, descricao, data, endereco, cidade, nivelPreocupacao);
        
        RelatoInstance.getInstance().incrementarBuracoViaCount();
    }
    //Observer
    public BuracoVia(String descricao,String data, String endereco, String cidade, int nivelPreocupacao){ 
         
        super("Not defined",descricao, data, endereco, cidade, nivelPreocupacao);
        this.notifyObservers();
        
    }
    //Prototype
    private BuracoVia(BuracoVia b)
    {
        super(b.Motivo, b.Descricao, b.Data, b.Endereco, b.Cidade, b.NivelPreocupacao);
    }

    public BuracoVia Clone()
    {            
        return new BuracoVia(this);
    }

    @Override
    public String toString()
    {
        return "Buraco na via: " + Motivo + "\nDescrição: " + Descricao + "\nData: " + Data + "\nEndereço: " + Endereco + 
               "\nCidade: " + Cidade + "\nNível de Preocupação: " + NivelPreocupacao;
    }

    
}
