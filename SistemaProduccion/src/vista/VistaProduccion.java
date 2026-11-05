package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaProduccion extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtCodigo;
    private JTextField txtCantidad;
    private JButton btnRegistrar;
    private JButton btnLimpiar;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private JLabel lblRegistros;
    private JLabel lblTotal;

    public VistaProduccion() {

        setTitle("Control de Producción");
        setSize(850, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Color fondo = new Color(235, 241, 248);
        Color azul = new Color(25, 55, 90);
        Color verde = new Color(30, 145, 110);

        JPanel principal = new JPanel(new BorderLayout(15, 15));
        principal.setBackground(fondo);
        principal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(principal);

        // ENCABEZADO
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBackground(azul);
        encabezado.setBorder(BorderFactory.createEmptyBorder(18, 20, 18, 20));

        JLabel titulo = new JLabel("CONTROL DE PRODUCCIÓN");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 23));

        JLabel subtitulo = new JLabel("Registro y seguimiento de productos fabricados");
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 13));

        JPanel textos = new JPanel(new GridLayout(2, 1, 0, 5));
        textos.setBackground(azul);
        textos.add(titulo);
        textos.add(subtitulo);

        encabezado.add(textos, BorderLayout.WEST);
        principal.add(encabezado, BorderLayout.NORTH);

        // PANEL CENTRAL
        JPanel centro = new JPanel(new BorderLayout(15, 0));
        centro.setBackground(fondo);

        // FORMULARIO
        JPanel formulario = new JPanel();
        formulario.setLayout(null);
        formulario.setPreferredSize(new Dimension(250, 300));
        formulario.setBackground(Color.WHITE);
        formulario.setBorder(BorderFactory.createLineBorder(
            new Color(210, 220, 230)
        ));

        JLabel lblFormulario = new JLabel("Nuevo registro");
        lblFormulario.setFont(new Font("Arial", Font.BOLD, 18));
        lblFormulario.setForeground(azul);
        lblFormulario.setBounds(20, 20, 210, 30);
        formulario.add(lblFormulario);

        JLabel lblCodigo = new JLabel("Código del producto");
        lblCodigo.setBounds(20, 75, 200, 25);
        formulario.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(20, 105, 205, 32);
        formulario.add(txtCodigo);

        JLabel lblCantidad = new JLabel("Cantidad producida");
        lblCantidad.setBounds(20, 155, 200, 25);
        formulario.add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(20, 185, 205, 32);
        formulario.add(txtCantidad);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(20, 240, 205, 35);
        btnRegistrar.setBackground(verde);
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        formulario.add(btnRegistrar);

        btnLimpiar = new JButton("Limpiar campos");
        btnLimpiar.setBounds(20, 285, 205, 35);
        btnLimpiar.setBackground(azul);
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.setFocusPainted(false);
        formulario.add(btnLimpiar);

        // TABLA
        JPanel panelTabla = new JPanel(new BorderLayout(5, 10));
        panelTabla.setBackground(Color.WHITE);
        panelTabla.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel tituloTabla = new JLabel("Productos registrados");
        tituloTabla.setFont(new Font("Arial", Font.BOLD, 18));
        tituloTabla.setForeground(azul);

        modeloTabla = new DefaultTableModel(
            new Object[]{"Código del producto", "Cantidad"}, 0
        );

        tabla = new JTable(modeloTabla);
        tabla.setRowHeight(30);
        tabla.setFont(new Font("Arial", Font.PLAIN, 13));
        tabla.getTableHeader().setBackground(azul);
        tabla.getTableHeader().setForeground(Color.WHITE);
        tabla.getTableHeader().setFont(
            new Font("Arial", Font.BOLD, 13)
        );

        JScrollPane scroll = new JScrollPane(tabla);

        panelTabla.add(tituloTabla, BorderLayout.NORTH);
        panelTabla.add(scroll, BorderLayout.CENTER);

        centro.add(formulario, BorderLayout.WEST);
        centro.add(panelTabla, BorderLayout.CENTER);

        principal.add(centro, BorderLayout.CENTER);

        // RESUMEN INFERIOR
        JPanel resumen = new JPanel(new GridLayout(1, 2, 15, 0));
        resumen.setBackground(fondo);

        lblRegistros = new JLabel("  TOTAL DE REGISTROS: 0");
        lblRegistros.setFont(new Font("Arial", Font.BOLD, 16));
        lblRegistros.setForeground(Color.WHITE);
        lblRegistros.setOpaque(true);
        lblRegistros.setBackground(azul);

        lblTotal = new JLabel("  TOTAL DE UNIDADES: 0");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
        lblTotal.setForeground(Color.WHITE);
        lblTotal.setOpaque(true);
        lblTotal.setBackground(verde);

        resumen.add(lblRegistros);
        resumen.add(lblTotal);

        principal.add(resumen, BorderLayout.SOUTH);
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public JTextField getTxtCantidad() {
        return txtCantidad;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void limpiarCampos() {
        txtCodigo.setText("");
        txtCantidad.setText("");
        txtCodigo.requestFocus();
    }

    public void mostrarRegistros(Object[] datos) {
        modeloTabla.addRow(datos);
    }

    public void limpiarTabla() {
        modeloTabla.setRowCount(0);
    }

    public void actualizarTotales(int registros, int total) {
        lblRegistros.setText("  TOTAL DE REGISTROS: " + registros);
        lblTotal.setText("  TOTAL DE UNIDADES: " + total);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}