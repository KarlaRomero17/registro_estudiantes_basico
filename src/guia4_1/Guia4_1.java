/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guia4_1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lissette
 */
/*
Desarrolla una aplicación Java Swing para registrar información de estudiantes. Crea una clase
Estudiante con atributos como nombre, edad, género y promedio. Diseña una interfaz gráfica
que permita agregar nuevos estudiantes, mostrar la lista de estudiantes y calcular estadísticas
simples como la edad promedio y el promedio de calificaciones. Asegúrate de reflejar los
cambios en la interfaz de manera dinámica.
Objetivos de Aprendizaje:
• Creación y uso de clases en Java.
• Implementación de métodos y manejo de listas de objetos.
• Diseño de interfaces gráficas interactivas con Java Swing.
• Manipulación de eventos y actualización de la interfaz en tiempo real.
• Práctica de lógica condicional y cálculos estadísticos simples.
*/
public class Guia4_1 extends JFrame {

    /**
     * @param args the command line arguments
     */
    private Estudiante estudiante; 
    //labels
    private JLabel nombreLabel;
    private JLabel edadLabel;
    private JLabel generoLabel;
    private JLabel promedioLabel;
    private JLabel calculoLabel;
    //botones
    private JButton agregarButton;
    private java.util.List<Estudiante> estudiantes = new ArrayList<>();
    //tabla
    private DefaultTableModel tablaEstudiantes;
    private JTable estudiantesTable;

    public Guia4_1() {
        super("Registro de Estudiantes");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        String[] columnNames = {"Nombre", "Edad", "Género", "Promedio"};
        tablaEstudiantes = new DefaultTableModel(columnNames, 0);
        estudiantesTable = new JTable(tablaEstudiantes);
        JScrollPane scrollPane = new JScrollPane(estudiantesTable);
        add(scrollPane, BorderLayout.CENTER);
        calculoLabel = new JLabel("Edad promedio: " + estudiante.getPromedioEdad() + " ----- Promedio: " + estudiante.getPromedioProm());
        add(calculoLabel, BorderLayout.NORTH);
        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(1, 2));

        JButton agregarButton = new JButton("Agregar Estudiante");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEstudiante();
            }
        });
        botonesPanel.add(agregarButton);
        add(botonesPanel, BorderLayout.SOUTH);
        setSize(500,300);
        setLocationRelativeTo(null);
    }

    private void agregarEstudiante() {
        String nombre = JOptionPane.showInputDialog("Nombre:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
        String genero = JOptionPane.showInputDialog("Genero:");
        double promedio = Double.parseDouble(JOptionPane.showInputDialog("Promedio:"));
        
        Estudiante estudiante = new Estudiante(nombre, edad, genero, promedio);
        estudiantes.add(estudiante);
        listarEstudiantes();
        calcularPromedios();
    }
    private void calcularPromedios() {
        double edadPromedio = Estudiante.getPromedioEdad();
        double promedioPromedio = Estudiante.getPromedioProm();
        calculoLabel.setText("Edad promedio: " + edadPromedio + " ----- Promedio: " + promedioPromedio);
    }
    private void listarEstudiantes(){
        tablaEstudiantes.setRowCount(0);
        for (Estudiante estudiante : estudiantes) {
            Object[] rowData = {estudiante.getNombre(), estudiante.getEdad(), estudiante.getGenero(), estudiante.getPromedio()};
            tablaEstudiantes.addRow(rowData);
        } 
        
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Guia4_1 app = new Guia4_1();
                app.setVisible(true);
            }
        });
    }
}
