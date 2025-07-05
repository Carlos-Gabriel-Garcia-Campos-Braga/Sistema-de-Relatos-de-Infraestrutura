package model.behavior;
import java.util.Observable;
import java.util.Observer;
import model.entities.*;

public class Verificalixo implements Observer { 
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof LixoIrregular) {
            LixoIrregular lI = (LixoIrregular) o;
            verificarLixo(lI);
        }
    }
    
    private void verificarLixo(LixoIrregular lI) {
        String alerta = "";
        
        if (lI.quantidade >= 3) {
            alerta += "ALERTA: Lixo excessivo detectado (" + lI.quantidade + " unidades)\n";
        }
        
        if (!alerta.isEmpty()) {
            System.out.println("🔍 Observer detectou problema de lixo:");
            System.out.println(alerta);
        }
    }
}

