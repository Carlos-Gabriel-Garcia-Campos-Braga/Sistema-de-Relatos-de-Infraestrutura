package model.behavior; 
import java.util.Observable;
import java.util.Observer;
import model.entities.IluminacaoRuim;


public class VerificaIluminacao implements Observer {
    
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof IluminacaoRuim) {
            IluminacaoRuim iR = (IluminacaoRuim) o;
            verificarIluminacao(iR);
        }
    }
    
    private void verificarIluminacao(IluminacaoRuim iR) {
        String alerta = "";
        
        if (iR.getQtdLampadasQueimadas() >= 5) {
            alerta += "ALERTA: Muitas lâmpadas queimadas (" + iR.getQtdLampadasQueimadas() + ")\n";
        }
        if(iR.getNivelIluminacao() <= 5){
            alerta += "ALERTA: Baixa iluminação (nível " + iR.getNivelIluminacao() + ")\n";
        }
        
        if (!alerta.isEmpty()) {
            System.out.println("🔍 Observer detectou problema de iluminação:");
            System.out.println(alerta);
        }
    }
}