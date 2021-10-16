package parcial_final;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Parcial_final3_ventanaTres extends JFrame implements ActionListener  {
    
    JPanel panel;
    JLabel imagen3;
    public static JLabel nombreEstudiante, total2;
    JLabel estudiante, definitiva, proceso, resultado, observacion, resultado2;
    JButton registro, permanencia, cerrar;
    double nota=0;
    
    public Parcial_final3_ventanaTres()
    {
        setSize(600,350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        
        imagen3 = new JLabel(new ImageIcon("imagen3.jpg"));
        imagen3.setBounds(0, 0, 585, 312);
        
        estudiante = new JLabel("ESTUDIANTE");
        definitiva = new JLabel("DEFINITIVA");
        proceso = new JLabel("PROCESO");
        observacion = new JLabel("OBSERVACIONES");
        nombreEstudiante = new JLabel();
        total2 = new JLabel();
        resultado = new JLabel();
        resultado2 = new JLabel();
        
        estudiante.setBounds(20, 30, 140, 20);
        estudiante.setFont(new Font("Times new roman",Font.BOLD,16));
        estudiante.setHorizontalAlignment(estudiante.CENTER);
        estudiante.setOpaque(true);
        estudiante.setBackground(Color.ORANGE);
        definitiva.setBounds(20, 85, 140, 20);
        definitiva.setFont(new Font("Times new roman",Font.BOLD,16));
        definitiva.setHorizontalAlignment(definitiva.CENTER);
        definitiva.setOpaque(true);
        definitiva.setBackground(Color.ORANGE);
        proceso.setBounds(20, 140, 140, 20);
        proceso.setFont(new Font("Times new roman",Font.BOLD,16));
        proceso.setHorizontalAlignment(proceso.CENTER);
        proceso.setOpaque(true);
        proceso.setBackground(Color.ORANGE);
        observacion.setBounds(20, 195, 140, 20);
        observacion.setFont(new Font("Times new roman",Font.BOLD,16));
        observacion.setHorizontalAlignment(observacion.CENTER);
        observacion.setOpaque(true);
        observacion.setBackground(Color.ORANGE);
 
        nombreEstudiante.setBounds(220, 30, 290, 20);
        nombreEstudiante.setFont(new Font("Times new roman",Font.BOLD,16));
        nombreEstudiante.setOpaque(true);
        nombreEstudiante.setBackground(Color.ORANGE);
        total2.setBounds(220, 85, 38, 20);
        total2.setFont(new Font("Times new roman",Font.BOLD,16)); 
        total2.setHorizontalAlignment(total2.CENTER);
        total2.setOpaque(true);
        total2.setBackground(Color.ORANGE);
        resultado.setBounds(220, 140, 120, 20);
        resultado.setFont(new Font("Times new roman",Font.BOLD,16));
        resultado.setHorizontalAlignment(resultado.CENTER);
        resultado.setOpaque(true);
        resultado.setBackground(Color.ORANGE);  
        resultado2.setBounds(220, 195, 120, 20);
        resultado2.setFont(new Font("Times new roman",Font.BOLD,16));
        resultado2.setHorizontalAlignment(resultado2.CENTER);
        resultado2.setOpaque(true);
        resultado2.setBackground(Color.ORANGE);
        
        registro = new JButton("REGISTRO"); registro.addActionListener(this);
        permanencia = new JButton("PERMANENCIA"); permanencia .addActionListener(this);
        cerrar = new JButton("CERRAR"); cerrar.addActionListener(this);
        registro.setBounds(130, 275, 90, 25);
        registro.setBackground(Color.orange);
        registro.setForeground(Color.red);
        registro.setFont(new Font("Times new roman",Font.BOLD,10));
        permanencia.setBounds(230, 275, 110, 25);
        permanencia.setBackground(Color.orange);
        permanencia.setForeground(Color.red);
        permanencia.setFont(new Font("Times new roman",Font.BOLD,10));
        cerrar.setBounds(350, 275, 90, 25);
        cerrar.setBackground(Color.orange);
        cerrar.setForeground(Color.red);
        cerrar.setFont(new Font("Times new roman",Font.BOLD,10));
        
        panel.add(estudiante);
        panel.add(definitiva);
        panel.add(proceso);
        panel.add(observacion);
        panel.add(nombreEstudiante);
        panel.add(total2);
        panel.add(resultado);
        panel.add(resultado2);
        panel.add(registro);
        panel.add(permanencia);
        panel.add(cerrar);
        panel.add(imagen3);
        add(panel);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==registro){
            nota=Double.parseDouble(total2.getText());
            if((nota>=10 && nota<30)||(nota<=5 && nota<3)){resultado.setText("No Aprobo");}
            else if((nota>=10 && nota>=30)||(nota<=5 && nota>=3)){resultado.setText("Aprobo");}
        }
        
        if(e.getSource()==permanencia){ 
            nota=Double.parseDouble(total2.getText());
            if((nota>=10 && nota<30)||(nota<=5 && nota<3)){resultado2.setText("Caso Academico");}
            else if((nota>=10 && nota>=30)||(nota<=5 && nota>=3)){resultado2.setText("Al Dia");}
        }
        
        if(e.getSource()==cerrar){dispose();}     
    }
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable(){public void run(){new Parcial_final3_ventanaTres ();}});      
    }    
}
  
