package model.entities;

import model.behavior.VerificaBuraco;
import model.designPatterns.RelatoInstance;

public class BuracoVia extends Relatos implements java.io.Serializable
{
    private VerificaBuraco vB = new VerificaBuraco();
    
    public BuracoVia(String descricao, String data, String endereco, String cidade, int nivelPreocupacao)
    {
        super(descricao, data, endereco, cidade, nivelPreocupacao);
        RelatoInstance.getInstance().incrementarBuracoViaCount();
        this.addObserver(vB); // Registrar observer usando método padrão do Java
    }
    //Prototype
    private BuracoVia(BuracoVia b)
    {
        super(b.Descricao, b.Data, b.Endereco, b.Cidade, b.NivelPreocupacao);
        this.addObserver(vB); // Registrar observer no clone também
    }

    public BuracoVia Clone()
    {            
        return new BuracoVia(this);
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
        return "Buraco na via\nDescrição: " + Descricao + "\nData: " + Data + "\nEndereço: " + Endereco + 
               "\nCidade: " + Cidade + "\nNível de Preocupação: " + NivelPreocupacao;
    }
}
