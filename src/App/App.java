package App;

import model.designPatterns.RelatoInstance;
import model.entities.*;
import model.fabrica.*;
import model.util.persistencia.GerenciadorArquivos;
import view.InterfaceGrafica;
import javax.swing.*;
import java.util.ArrayList;

public class App {
    private static ArrayList<Relatos> relatos = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            carregarRelatos();
            InterfaceGrafica interfaceGrafica = new InterfaceGrafica(relatos, () -> {
                salvarRelatos();
                carregarRelatos();
            });
            interfaceGrafica.criarInterface();
        });
    }

    private static void salvarRelatos() {
        GerenciadorArquivos.salvarRelatos(relatos);
    }

    private static void carregarRelatos() {
        GerenciadorArquivos.resetarContadores();
        relatos = GerenciadorArquivos.carregarRelatos();
    }
}
