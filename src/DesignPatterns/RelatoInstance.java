package DesignPatterns;

import Models.BuracoVia;
import Models.IlumincaoRuim;
import Models.LixoIrregular;

public class RelatoInstance 
{
    //Implemento o padrão Singleton e do Prototype
    private static BuracoVia buracoViaInstance = new BuracoVia(
            "Buraco na via",
            "Grande buraco na via",
            "20/06/2025",
            "Rua das camelias",
            "Goiania",
            7
        );
    
    public static BuracoVia getBuracoViaInstance() 
    {
        return buracoViaInstance.Clone();
    }

    private static IlumincaoRuim ilumincaoRuimInstance = new IlumincaoRuim(
        "Iluminação ruim",
        "Descrição padrão de iluminação ruim",
        "20/06/2025",
        "Rua das Flores",
        "Goiania",
        7, 0, 0
    );

    public static IlumincaoRuim getIluminacaoRuimInstance() 
    {
        return ilumincaoRuimInstance.Clone();
    }

    private static LixoIrregular lixoIrregularInstance = new LixoIrregular(
            "Lixo irregular",
            "Descrição padrão de lixo irregular",
            "20/06/2025",
            "Rua das Flores",
            "Goiania",
            7, "Organico", 2
        );

    public static LixoIrregular getLixoIrregularInstance() 
    {
        return lixoIrregularInstance.Clone();
    }
}
