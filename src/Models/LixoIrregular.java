package Models;

import Exceptions.ExcecoesPersonalizadas;

public class LixoIrregular extends Relatos
{
    public String TipoLixo;
    public int Quantidade;

    public LixoIrregular(String motivo, String descricao, String data, String endereco, String cidade, 
                         int nivelPreocupacao, String tipoLixo, int quantidade)
    {
        super(motivo, descricao, data, endereco, cidade, nivelPreocupacao);
        this.TipoLixo = tipoLixo;
        this.Quantidade = quantidade;
    }

    // Construtor de cópia para o padrão Prototype
    private LixoIrregular(LixoIrregular l)
    {
        super(l.Motivo, l.Descricao, l.Data, l.Endereco, l.Cidade, l.NivelPreocupacao);
        this.TipoLixo = l.TipoLixo;
        this.Quantidade = l.Quantidade;
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
        this.Quantidade = quantidade;
    }
    
}
