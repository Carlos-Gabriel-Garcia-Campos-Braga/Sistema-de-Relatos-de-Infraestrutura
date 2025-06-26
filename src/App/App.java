package App;

import Models.BuracoVia;
import SingletonRelato.RelatoInstance;

public class App {
    public static void main(String[] args) throws Exception 
    {
        try
        {
            BuracoVia b = RelatoInstance.getBuracoViaInstance();
            b.setDescricao("Buraco grande na via");
            b.setEndereco("Av LesteOeste");   
            b.setCidade("Goiania");
            b.setData("25/06/2025");                      
            System.out.println(b);
        }
        catch(Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
        finally
        {
            System.out.println("Programa finalizado.");
        }
        
    }
}
