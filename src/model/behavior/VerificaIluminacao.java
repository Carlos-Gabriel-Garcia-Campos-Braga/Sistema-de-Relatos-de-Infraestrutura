package model.behavior; 
import java.util.Observable;
import java.util.Observer;
import model.entities.IluminacaoRuim;


public class VerificaIluminacao implements   Observer {
    
    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    public void update(IluminacaoRuim iR) {
        if (iR.qtdLampadasQueimadas >= 5) {
            // iR.setMotivo("Lampadas queimadas");
        }
        if(iR.nivelIluminacao <=5){
            // iR.setMotivo("Baixa iluminação");
        }
    }
}