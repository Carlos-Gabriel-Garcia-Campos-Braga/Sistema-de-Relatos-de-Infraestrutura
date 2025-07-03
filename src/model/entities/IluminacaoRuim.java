package model.entities;

import model.behavior.VerificaIluminacao;
import model.designPatterns.RelatoInstance;
import model.util.exception.ExcecoesPersonalizadas;

public class IluminacaoRuim extends Relatos
{
    public int qtdLampadasQueimadas;
    public int nivelIluminacao;
    private VerificaIluminacao vI = new  VerificaIluminacao();
    public IluminacaoRuim(String motivo, String descricao, String data, String endereco, String cidade, 
                         int nivelPreocupacao, int qtdLampadasQueimadas, int nivelIluminacao)
    {
        super(motivo, descricao, data, endereco, cidade, nivelPreocupacao);
        
        this.qtdLampadasQueimadas = qtdLampadasQueimadas;
        this.nivelIluminacao = nivelIluminacao;
        RelatoInstance.getInstance().incrementarIluminacaoRuimCount();
    }
    //Observer
    public IluminacaoRuim(String descricao, String data, String endereco, String cidade, 
                         int nivelPreocupacao, int qtdLampadasQueimadas, int nivelIluminacao)
    {
        super("Not defined", descricao, data, endereco, cidade, nivelPreocupacao);
        
        this.qtdLampadasQueimadas = qtdLampadasQueimadas;
        this.nivelIluminacao = nivelIluminacao;
        
        RelatoInstance.getInstance().incrementarIluminacaoRuimCount();
    }
    //Prototype
    private IluminacaoRuim(IluminacaoRuim i)
    {
        super(i.Motivo, i.Descricao, i.Data, i.Endereco, i.Cidade, i.NivelPreocupacao);
        this.qtdLampadasQueimadas = i.qtdLampadasQueimadas;
        this.nivelIluminacao = i.nivelIluminacao;
    }

    public IluminacaoRuim Clone()
    {
        return new IluminacaoRuim(this);
    }

    public void setQtdLampadasQueimadas(int qtdLampadasQueimadas) 
    {
        if(qtdLampadasQueimadas < 0)
        {
            throw new ExcecoesPersonalizadas("Quantidade de lâmpadas queimadas inválida!");
        }
        
        this.qtdLampadasQueimadas = qtdLampadasQueimadas;
        
    }

    public void setNivelIluminacao(int nivelIluminacao) 
    {
        if(nivelIluminacao < 0 || nivelIluminacao > 10)
        {
            throw new ExcecoesPersonalizadas("Nível de iluminação inválido! Deve ser entre 0 e 10.");
        }
        
        this.nivelIluminacao = nivelIluminacao;
        this.notifyObservers();
    }   
    
    public void notifyObservers(){
        
       
        vI.update( this);
        
    }
    
    @Override
    public String toString()
    {
        return "Iluminação Ruim: \n" +
               "Motivo: " + Motivo + "\n" +
               "Descrição: " + Descricao + "\n" +
               "Data: " + Data + "\n" +
               "Endereço: " + Endereco + "\n" +
               "Cidade: " + Cidade + "\n" +
               "Nível de Preocupação: " + NivelPreocupacao + "\n" +
               "Quantidade de Lâmpadas Queimadas: " + qtdLampadasQueimadas + "\n" +
               "Nível de Iluminação: " + nivelIluminacao;
    }
}
