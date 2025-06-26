package App;

import DesignPatterns.RelatoInstance;
import Models.BuracoVia;
import Models.IlumincaoRuim;
import Models.LixoIrregular;

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

            System.out.println("------------------");

            IlumincaoRuim i = RelatoInstance.getIluminacaoRuimInstance();
            i.setDescricao("Iluminação insuficiente na praça");
            i.setEndereco("Praça Central");
            i.setCidade("Goiania");
            i.setNivelIluminacao(4);
            i.setQtdLampadasQueimadas(2);
            i.setData("25/06/2025");
            System.out.println(i);

            System.out.println("------------------");
            LixoIrregular l = RelatoInstance.getLixoIrregularInstance();
            l.setDescricao("Lixo acumulado na esquina");
            l.setEndereco("Rua das Flores");
            l.setCidade("Goiania");
            l.setNivelPreocupacao(3);
            l.setData("25/06/2025");
            System.out.println(l);
        }
        catch(Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
        }
        finally
        {
            System.out.println("------------------");
            System.out.println("Programa finalizado.");
            System.out.println("Obrigado por usar nosso sistema de relatos!");
            System.out.println("------------------");
        }
        
    }
}
