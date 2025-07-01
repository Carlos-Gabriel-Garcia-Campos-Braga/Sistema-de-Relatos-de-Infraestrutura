package model.entities;

import model.designPatterns.RelatoInstance;
import model.util.exception.ExcecoesPersonalizadas;

public class IluminacaoRuim extends Relatos
{
    public int QtdLampadasQueimadas;
    public int NivelIluminacao;

    public IluminacaoRuim(String motivo, String descricao, String data, String endereco, String cidade, 
                         int nivelPreocupacao, int qtdLampadasQueimadas, int nivelIluminacao)
    {
        super(motivo, descricao, data, endereco, cidade, nivelPreocupacao);
        this.QtdLampadasQueimadas = qtdLampadasQueimadas;
        this.NivelIluminacao = nivelIluminacao;
        RelatoInstance.getInstance().incrementarIluminacaoRuimCount();
    }

    private IluminacaoRuim(IluminacaoRuim i)
    {
        super(i.Motivo, i.Descricao, i.Data, i.Endereco, i.Cidade, i.NivelPreocupacao);
        this.QtdLampadasQueimadas = i.QtdLampadasQueimadas;
        this.NivelIluminacao = i.NivelIluminacao;
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

        this.QtdLampadasQueimadas = qtdLampadasQueimadas;
    }

    public void setNivelIluminacao(int nivelIluminacao) 
    {
        if(nivelIluminacao < 0 || nivelIluminacao > 10)
        {
            throw new ExcecoesPersonalizadas("Nível de iluminação inválido! Deve ser entre 0 e 10.");
        }

        this.NivelIluminacao = nivelIluminacao;
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
               "Quantidade de Lâmpadas Queimadas: " + QtdLampadasQueimadas + "\n" +
               "Nível de Iluminação: " + NivelIluminacao;
    }
}
