package model.behavior; 
import java.util.Observable;
import java.util.Observer;
import model.entities.BuracoVia;

public class VerificaBuraco implements Observer {
    
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof BuracoVia) {
            BuracoVia bV = (BuracoVia) o;
            verificarBuraco(bV);
        }
    }
    
    private void verificarBuraco(BuracoVia bV) {
        String alerta = "";
        
        if (bV.getNivelPreocupacao() >= 8) {
            alerta += "ALERTA: Buraco com alto nível de preocupação (" + bV.getNivelPreocupacao() + "/10)\n";
        }
        
        if (!alerta.isEmpty()) {
            System.out.println("🔍 Observer detectou problema de buraco na via:");
            System.out.println(alerta);
        }
    }
} 