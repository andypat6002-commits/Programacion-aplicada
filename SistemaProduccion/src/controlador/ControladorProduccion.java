package controlador;

import modelo.Produccion;
import modelo.ModeloProduccion;
import vista.VistaProduccion;


public class ControladorProduccion {

    private ModeloProduccion modelo;
    private VistaProduccion vista;

    public ControladorProduccion(
            ModeloProduccion modelo,
            VistaProduccion vista) {

        this.modelo = modelo;
        this.vista = vista;

        vista.getBtnRegistrar().addActionListener(e -> registrarProduccion());

        vista.getBtnLimpiar().addActionListener(e -> vista.limpiarCampos());

        mostrarRegistros();
    }

    private void registrarProduccion() {

        String codigo = vista.getTxtCodigo().getText().trim();
        String cantidadTexto = vista.getTxtCantidad().getText().trim();

        if (codigo.isEmpty() || cantidadTexto.isEmpty()) {
            vista.mostrarMensaje("Complete todos los campos.");
            return;
        }

        if (codigo.contains(";")) {
            vista.mostrarMensaje("El código no puede contener punto y coma.");
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadTexto);

            if (cantidad <= 0) {
                vista.mostrarMensaje("La cantidad debe ser mayor que cero.");
                return;
            }

            Produccion p = new Produccion(codigo, cantidad);

            modelo.registrar(p);
            modelo.guardarArchivo();

            mostrarRegistros();
            vista.limpiarCampos();

            vista.mostrarMensaje("Producción registrada correctamente.");

        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Ingrese una cantidad numérica válida.");
        }
    }

    private void mostrarRegistros() {

        vista.limpiarTabla();

        for (Produccion p : modelo.getRegistros()) {
            vista.mostrarRegistros(new Object[]{
                p.getCodigoProducto(),
                p.getCantidad()
            });
        }

        vista.actualizarTotales(
            modelo.contarRegistros(),
            modelo.calcularTotal()
        );
    }
}