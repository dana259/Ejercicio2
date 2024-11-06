import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoGUI {
    private JPanel panelPrincipal;
    private JTextArea resultadoTxt;
    private JTextField nombreClienteTxt;
    private JButton agregarClienteBtn;
    private JButton atenderClienteBtn;
    private JTextArea clientesAtendidosTxt;
    private ColaBanco colaBanco;

    public BancoGUI() {
        colaBanco = new ColaBanco();

        agregarClienteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCliente = nombreClienteTxt.getText().trim();
                if (!nombreCliente.isEmpty()) {
                    colaBanco.agregarCliente(nombreCliente);
                    nombreClienteTxt.setText("");
                    actualizarResultado();
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre válido para el cliente.");
                }
            }
        });

        atenderClienteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String clienteAtendido = colaBanco.atenderCliente();
                if (clienteAtendido != null) {
                    actualizarClientesAtendidos(clienteAtendido);
                }
                actualizarResultado();
            }
        });
    }

    private void actualizarResultado() {
        resultadoTxt.setText(colaBanco.obtenerClientesEnCola());
    }

    private void actualizarClientesAtendidos(String clienteAtendido) {
        String textoActual = clientesAtendidosTxt.getText();
        textoActual += clienteAtendido + " ha sido atendido.\n";
        clientesAtendidosTxt.setText(textoActual);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BancoGUI");
        frame.setContentPane(new BancoGUI().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}