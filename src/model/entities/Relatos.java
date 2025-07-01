package model.entities;

import model.util.exception.ExcecoesPersonalizadas;

public abstract class Relatos 
{
    protected String Motivo;
    protected String Descricao;
    protected String Data;
    protected String Endereco;
    protected String Cidade;
    protected int NivelPreocupacao;

    public Relatos(String motivo, String descricao, String data, String endereco, String cidade, int nivelPreocupacao)
    {
        setMotivo(motivo);
        setDescricao(descricao);
        setData(data);
        setEndereco(endereco);
        setCidade(cidade);
        setNivelPreocupacao(nivelPreocupacao);
    }

    //Setters
    public void setMotivo(String motivo)
    {
        if(motivo.isEmpty() || motivo == null || motivo.length() < 3)
        {
            throw new ExcecoesPersonalizadas("Motivo inválido!");
        }

        this.Motivo = motivo;
    }

    public void setDescricao(String descricao) 
    {
        if(descricao.isEmpty() || descricao.length() < 3)
        {
            throw new ExcecoesPersonalizadas("Descrição inválida!");
        }

        this.Descricao = descricao;
    }

    public void setData(String data) 
    {
        if(data.isEmpty() || data == null || data.length() < 10)
        {
            throw new ExcecoesPersonalizadas("Data inválida!");
        }
        this.Data = data;
    }

    public void setEndereco(String endereco) 
    {
        if(endereco.isEmpty() || endereco == null || endereco.length() < 3)
        {
            throw new ExcecoesPersonalizadas("Endereço inválido!");
        }
        this.Endereco = endereco;
    }

    public void setCidade(String cidade)
    {
        if(cidade.isEmpty() || cidade == null || cidade.length() < 3)
        {
            throw new ExcecoesPersonalizadas("Cidade inválida!");
        }
        this.Cidade = cidade;
    }

    public void setNivelPreocupacao(int nivelPreocupacao) 
    {
        if(nivelPreocupacao < 1 || nivelPreocupacao > 10)
        {
            throw new ExcecoesPersonalizadas("Nível de preocupação inválido! Deve ser entre 1 e 10.");
        }
        this.NivelPreocupacao = nivelPreocupacao;
    }

}
