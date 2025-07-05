package model.behavior;
import java.util.Observable;
import java.util.Observer;
import model.entities.SemaforoProblema;

public class VerificaSemaforo implements Observer {
    
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof SemaforoProblema) {
            SemaforoProblema sP = (SemaforoProblema) o;
            verificarSemaforo(sP);
        }
    }
    
    private void verificarSemaforo(SemaforoProblema sP) {
        String alerta = "";
        
        if (sP.getNivelPreocupacao() >= 7) {
            alerta += "ALERTA: Semáforo com alto nível de preocupação (" + sP.getNivelPreocupacao() + "/10)\n";
        }
        
        if (sP.TipoProblema.toLowerCase().contains("pane") || sP.TipoProblema.toLowerCase().contains("quebrado")) {
            alerta += "ALERTA: Semáforo com problema crítico (" + sP.TipoProblema + ")\n";
        }
        
        if (!alerta.isEmpty()) {
            System.out.println("🔍 Observer detectou problema de semáforo:");
            System.out.println(alerta);
        }
    }
} 