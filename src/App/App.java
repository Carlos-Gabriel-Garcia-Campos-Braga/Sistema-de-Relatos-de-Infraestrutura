package App;

import DesignPatterns.RelatoInstance;
import Models.BuracoVia;
import Models.IlumincaoRuim;
import Models.LixoIrregular;
import Models.SemafaroProblema;

public class App {
    public static void main(String[] args) throws Exception 
    {
        try
        {
            BuracoVia b = new BuracoVia("Buraco na Via", "Grande cratera", "20/07/2025", "Rua das camelias", "Goiania", 8);
            b.setDescricao("Buraco grande na via");
            b.setEndereco("Av LesteOeste");   
            b.setCidade("Goiania");
            b.setData("25/06/2025");                      
            System.out.println(b);
            System.out.println("Quantidade de buracos na via: " + RelatoInstance.BuracoViaCount);

            System.out.println("------------------");

            IlumincaoRuim i = new IlumincaoRuim("Iluminação Ruim", "Grande cratera", "20/07/2025", "Rua das camelias", "Goiania", 1,10, 2);
            i.setDescricao("Iluminação insuficiente na praça");
            i.setEndereco("Praça Central");
            i.setCidade("Goiania");
            i.setNivelIluminacao(4);
            i.setQtdLampadasQueimadas(2);
            i.setData("25/06/2025");
            System.out.println("Quantidade de postes queimados: " + RelatoInstance.IluminacaoRuimCount);
            System.out.println(i);

            System.out.println("------------------");
            LixoIrregular l = new LixoIrregular("Lixo Irregular", "Grande cratera", "20/07/2025", "Rua das camelias", "Goiania", 3, "Organico", 10);
            l.setDescricao("Lixo acumulado na esquina");
            l.setEndereco("Rua das Flores");
            l.setCidade("Goiania");
            l.setNivelPreocupacao(3);
            l.setData("25/06/2025");
            System.out.println("Quantidade de lixo na cidade ate entao: " + RelatoInstance.LixoIrregularCount);
            System.out.println(l);

            System.out.println("------------------");
            SemafaroProblema s = new SemafaroProblema("Semáforo com problema", "Semáforo piscando", "20/07/2025", "Rua das camelias", "Goiania", 5, "Verde intermitente");
            s.setDescricao("Semáforo com falha no sinal verde");
            System.out.println(s);
            System.out.println("Quantidade de semáforos com problemas: " + RelatoInstance.SemafaroProblemaCount);
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
