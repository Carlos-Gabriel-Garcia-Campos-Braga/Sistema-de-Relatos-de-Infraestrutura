package model.designPatterns;

public class RelatoInstance 
{
    // Implementação correta do padrão Singleton
    private static RelatoInstance instance;
    
    // Contadores privados
    private int buracoViaCount = 0;
    private int iluminacaoRuimCount = 0;
    private int lixoIrregularCount = 0;
    private int semaforoProblemaCount = 0;
    
    // Construtor privado para Singleton
    private RelatoInstance() {}
    
    // Método para obter a instância única
    public static RelatoInstance getInstance() {
        if (instance == null) {
            instance = new RelatoInstance();
        }
        return instance;
    }
    
    // Métodos para incrementar contadores
    public void incrementarBuracoViaCount() {
        buracoViaCount++;
    }
    
    public void incrementarIluminacaoRuimCount() {
        iluminacaoRuimCount++;
    }
    
    public void incrementarLixoIrregularCount() {
        lixoIrregularCount++;
    }
    
    public void incrementarSemaforoProblemaCount() {
        semaforoProblemaCount++;
    }
    
    // Métodos para obter contadores
    public int getBuracoViaCount() {
        return buracoViaCount;
    }
    
    public int getIluminacaoRuimCount() {
        return iluminacaoRuimCount;
    }
    
    public int getLixoIrregularCount() {
        return lixoIrregularCount;
    }
    
    public int getSemaforoProblemaCount() {
        return semaforoProblemaCount;
    }
}
