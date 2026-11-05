package modelo;

import java.util.ArrayList;
import java.io.*;

public class ModeloProduccion {

    private ArrayList<Produccion> registros;
    private final String archivo = "produccion.txt";

    public ModeloProduccion() {
        registros = new ArrayList<>();
        cargarDatos();
    }

    public void registrar(Produccion p) {
        registros.add(p);
    }

    public ArrayList<Produccion> getRegistros() {
        return registros;
    }

    public int contarRegistros() {
        return registros.size();
    }

    public int calcularTotal() {
        int total = 0;

        for (Produccion p : registros) {
            total += p.getCantidad();
        }

        return total;
    }

    public void guardarArchivo() {
        try (PrintWriter escritor =
                new PrintWriter(new FileWriter(archivo))) {

            for (Produccion p : registros) {
                escritor.println(
                    p.getCodigoProducto() + ";" + p.getCantidad()
                );
            }

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void cargarDatos() {
        File f = new File(archivo);

        if (!f.exists()) {
            return;
        }

        try (BufferedReader lector =
                new BufferedReader(new FileReader(f))) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");

                if (datos.length == 2) {
                    try {
                        String codigo = datos[0];
                        int cantidad = Integer.parseInt(datos[1]);

                        registros.add(new Produccion(codigo, cantidad));
                    } catch (NumberFormatException e) {
                        System.out.println("Registro inválido en el archivo.");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}