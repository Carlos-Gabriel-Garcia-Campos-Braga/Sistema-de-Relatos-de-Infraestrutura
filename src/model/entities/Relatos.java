package model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import model.util.exception.ExcecoesPersonalizadas;

public abstract class Relatos extends Observable implements Serializable
{
    protected String Descricao;
    protected String Data;
    protected String Endereco;
    protected String Cidade;
    protected int NivelPreocupacao;
    protected List <Observer> observers = new ArrayList();
    public Relatos(String descricao, String data, String endereco, String cidade, int nivelPreocupacao)
    {
        setDescricao(descricao);
        setData(data);
        setEndereco(endereco);
        setCidade(cidade);
        setNivelPreocupacao(nivelPreocupacao);
    }
    /* Observer */
    public void registerObserver(Observer observer) {
        observers.add(observer) ;
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    // Método para notificar observers usando o padrão Java
    protected void notificarObservers(Object arg) {
        setChanged();
        notifyObservers(arg);
    }
    
    //Setters
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

    // Getters públicos para acesso seguro
    public String getDescricao() { return Descricao; }
    public String getData() { return Data; }
    public String getEndereco() { return Endereco; }
    public String getCidade() { return Cidade; }
    public int getNivelPreocupacao() { return NivelPreocupacao; }
}
