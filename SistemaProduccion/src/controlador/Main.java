package controlador;

import javax.swing.SwingUtilities;

import modelo.ModeloProduccion;
import vista.VistaProduccion;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ModeloProduccion modelo = new ModeloProduccion();

            VistaProduccion vista = new VistaProduccion();

            new ControladorProduccion(modelo, vista);

            vista.setVisible(true);
        });
    }
}