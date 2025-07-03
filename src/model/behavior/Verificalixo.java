package model.behavior;
import java.util.Observable;
import java.util.Observer;
import model.entities.*;

public class Verificalixo implements  Observer {
    


    
    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    public void update(LixoIrregular lI) {
        if (lI.quantidade >= 3) {
            lI.setMotivo("Lixo Excessivo");
        }
        
    }
}

