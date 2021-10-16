package parcial_final;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Parcial_final3 extends JFrame implements ActionListener  {
    
    JPanel panel;
    JLabel imagen1; 
    JMenuBar barraMenu;
    JMenu sem1, sem2, sem3, sem4, sem5, sem6, herramienta, salir;
    JMenuItem sem1M1, sem1M2, sem1M3, sem1M4, sem1M5, sem1M6;
    JMenuItem sem2M1, sem2M2, sem2M3, sem2M4, sem2M5, sem2M6;
    JMenuItem sem3M1, sem3M2, sem3M3, sem3M4, sem3M5, sem3M6;
    JMenuItem sem4M1, sem4M2, sem4M3, sem4M4, sem4M5, sem4M6;
    JMenuItem sem5M1, sem5M2, sem5M3, sem5M4, sem5M5, sem5M6;
    JMenuItem sem6M1, sem6M2, sem6M3, sem6M4, sem6M5, sem6M6;
    JMenuItem opcion1, opcion2; 
    JToolBar barraBotones;
    JButton b1, b2, b3, b4, b5, b6;  

    public Parcial_final3()
    {
        //Contruyendo ventana
        setTitle("UNIVERSITARIA UNIAGUSTINIANA - TECNOLOGIA EN DESARROLLO DE SOFTWARE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(830,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);  
        
        //Agregando panel
        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        
        //Agregando imagen al panel
        imagen1 = new JLabel(new ImageIcon("imagen1.png"));
        imagen1.setBounds(0, 25, 815, 436);
        imagen1.setLayout(new BorderLayout());

        //Agregando barra de menus
        barraMenu = new JMenuBar();
        barraMenu.setBounds(0, 0, 815, 25);
        barraMenu.setBackground(Color.ORANGE);
        
        sem1 = new JMenu("Primer Semestre");
        sem1.setFont(new Font("Times new roman",Font.BOLD,14));
         sem1M1 = new JMenuItem("Algoritmia y programación básica"); 
         sem1M1.setBackground(Color.YELLOW);
         sem1M1.addActionListener(this);
         sem1M2 = new JMenuItem("Catedra Agustiniana");
         sem1M2.setBackground(Color.YELLOW);
         sem1M2.addActionListener(this);
         sem1M3 = new JMenuItem("Cálculo Diferencial");
         sem1M3.setBackground(Color.YELLOW);
         sem1M3.addActionListener(this);
         sem1M4 = new JMenuItem("Álgebra Lineal");
         sem1M4.setBackground(Color.YELLOW);
         sem1M4.addActionListener(this);
         sem1M5 = new JMenuItem("Introducción al Desarrollo de Software");
         sem1M5.setBackground(Color.YELLOW);
         sem1M5.addActionListener(this);
         sem1M6 = new JMenuItem("Métodos de estudio");
         sem1M6.setBackground(Color.YELLOW);
         sem1M6.addActionListener(this);
          sem1.add(sem1M1);
          sem1.addSeparator();
          sem1.add(sem1M2);
          sem1.addSeparator();
          sem1.add(sem1M3);
          sem1.addSeparator();
          sem1.add(sem1M4);
          sem1.addSeparator();
          sem1.add(sem1M5);
          sem1.addSeparator();
          sem1.add(sem1M6);
        barraMenu.add(sem1);
        
        sem2 = new JMenu("Segundo Semestre");
        sem2.setFont(new Font("Times new roman",Font.BOLD,14));
         sem2M1 = new JMenuItem("Cálculo Integral");
         sem2M1.setBackground(Color.YELLOW);
         sem2M1.addActionListener(this);
         sem2M2 = new JMenuItem("Programación Orientada a Objetos");
         sem2M2.setBackground(Color.YELLOW);
         sem2M2.addActionListener(this);
         sem2M3 = new JMenuItem("Estructuras de datos");
         sem2M3.setBackground(Color.YELLOW);
         sem2M3.addActionListener(this);
         sem2M4 = new JMenuItem("Introducción al Emprendimiento");
         sem2M4.setBackground(Color.YELLOW);
         sem2M4.addActionListener(this);
         sem2M5 = new JMenuItem("Humanidades I");
         sem2M5.setBackground(Color.YELLOW);
         sem2M5.addActionListener(this);
         sem2M6 = new JMenuItem("Inglés I");
         sem2M6.setBackground(Color.YELLOW);
         sem2M6.addActionListener(this);
          sem2.add(sem2M1);
          sem2.addSeparator();
          sem2.add(sem2M2);
          sem2.addSeparator();
          sem2.add(sem2M3);
          sem2.addSeparator();
          sem2.add(sem2M4);
          sem2.addSeparator();
          sem2.add(sem2M5);
          sem2.addSeparator();
          sem2.add(sem2M6);
        barraMenu.add(sem2);
        
        sem3 = new JMenu("Tercer Semestre");
        sem3.setFont(new Font("Times new roman",Font.BOLD,14));
         sem3M1 = new JMenuItem("Estadística");
         sem3M1.setBackground(Color.YELLOW);
         sem3M1.addActionListener(this);
         sem3M2 = new JMenuItem("Análisis y Diseño de Software");
         sem3M2.setBackground(Color.YELLOW);
         sem3M2.addActionListener(this);
         sem3M3 = new JMenuItem("Modelado de Base de Datos");
         sem3M3.setBackground(Color.YELLOW);
         sem3M3.addActionListener(this);
         sem3M4 = new JMenuItem("Fundamentos de Desarrollo Web");
         sem3M4.setBackground(Color.YELLOW);
         sem3M4.addActionListener(this);
         sem3M5 = new JMenuItem("Contabilidad");
         sem3M5.setBackground(Color.YELLOW);
         sem3M5.addActionListener(this);
         sem3M6 = new JMenuItem("Inglés II");
         sem3M6.setBackground(Color.YELLOW);
         sem3M6.addActionListener(this);
          sem3.add(sem3M1);
          sem3.addSeparator();
          sem3.add(sem3M2);
          sem3.addSeparator();
          sem3.add(sem3M3);
          sem3.addSeparator();
          sem3.add(sem3M4);
          sem3.addSeparator();
          sem3.add(sem3M5);
          sem3.addSeparator();
          sem3.add(sem3M6);
        barraMenu.add(sem3);
        
        sem4 = new JMenu("Cuarto Semestre");
        sem4.setFont(new Font("Times new roman",Font.BOLD,14));
         sem4M1 = new JMenuItem("Estructuras de Datos Avanzada");
         sem4M1.setBackground(Color.YELLOW);
         sem4M1.addActionListener(this);
         sem4M2 = new JMenuItem("Gestión de Base de Datos");
         sem4M2.setBackground(Color.YELLOW);
         sem4M2.addActionListener(this);
         sem4M3 = new JMenuItem("Construcción de Aplicaciones Web");
         sem4M3.setBackground(Color.YELLOW);
         sem4M3.addActionListener(this);
         sem4M4 = new JMenuItem("Tecnologías para Aplicaciones Móviles");
         sem4M4.setBackground(Color.YELLOW);
         sem4M4.addActionListener(this);
         sem4M5 = new JMenuItem("Emprendimiento I");
         sem4M5.setBackground(Color.YELLOW);
         sem4M5.addActionListener(this);
         sem4M6 = new JMenuItem("Inglés III");
         sem4M6.setBackground(Color.YELLOW);
         sem4M6.addActionListener(this);
          sem4.add(sem4M1);
          sem4.addSeparator();
          sem4.add(sem4M2);
          sem4.addSeparator();
          sem4.add(sem4M3);
          sem4.addSeparator();
          sem4.add(sem4M4);
          sem4.addSeparator();
          sem4.add(sem4M5);
          sem4.addSeparator();
          sem4.add(sem4M6);
        barraMenu.add(sem4);
        
        sem5 = new JMenu("Quinto Semestre");
        sem5.setFont(new Font("Times new roman",Font.BOLD,14));
         sem5M1 = new JMenuItem("Arquitectura de Software");
         sem5M1.setBackground(Color.YELLOW);
         sem5M1.addActionListener(this);
         sem5M2 = new JMenuItem("Sistemas Operativos y Arquitectura de Hardware");
         sem5M2.setBackground(Color.YELLOW);
         sem5M2.addActionListener(this);
         sem5M3 = new JMenuItem("Técnicas Avanzadas de Programación para Móviles");
         sem5M3.setBackground(Color.YELLOW);
         sem5M3.addActionListener(this);
         sem5M4 = new JMenuItem("Investigación Formativa");
         sem5M4.setBackground(Color.YELLOW);
         sem5M4.addActionListener(this);
         sem5M5 = new JMenuItem("Ética");
         sem5M5.setBackground(Color.YELLOW);
         sem5M5.addActionListener(this);
         sem5M6 = new JMenuItem("Inglés IV");
         sem5M6.setBackground(Color.YELLOW);
         sem5M6.addActionListener(this);
          sem5.add(sem5M1);
          sem5.addSeparator();
          sem5.add(sem5M2);
          sem5.addSeparator();
          sem5.add(sem5M3);
          sem5.addSeparator();
          sem5.add(sem5M4);
          sem5.addSeparator();
          sem5.add(sem5M5);
          sem5.addSeparator();
          sem5.add(sem5M6);
        barraMenu.add(sem5);
        
        sem6 = new JMenu("Sexto Semestre");
        sem6.setFont(new Font("Times new roman",Font.BOLD,14));
         sem6M1 = new JMenuItem("Legislación Tecnológica");
         sem6M1.setBackground(Color.YELLOW);
         sem6M1.addActionListener(this);
         sem6M2 = new JMenuItem("Desarrollo y Refinamiento de Software");
         sem6M2.setBackground(Color.YELLOW);
         sem6M2.addActionListener(this);
         sem6M3 = new JMenuItem("Electiva Profesional I");
         sem6M3.setBackground(Color.YELLOW);
         sem6M3.addActionListener(this);
         sem6M4 = new JMenuItem("Electiva Profesional II");
         sem6M4.setBackground(Color.YELLOW);
         sem6M4.addActionListener(this);
         sem6M5 = new JMenuItem("Electiva Profesional III");
         sem6M5.setBackground(Color.YELLOW);
         sem6M5.addActionListener(this);
         sem6M6 = new JMenuItem("Opción de Grado");
         sem6M6.setBackground(Color.YELLOW);
         sem6M6.addActionListener(this);
          sem6.add(sem6M1);
          sem6.addSeparator();
          sem6.add(sem6M2);
          sem6.addSeparator();
          sem6.add(sem6M3);
          sem6.addSeparator();
          sem6.add(sem6M4);
          sem6.addSeparator();
          sem6.add(sem6M5);
          sem6.addSeparator();
          sem6.add(sem6M6);
        barraMenu.add(sem6);
        
        herramienta = new JMenu("Herramientas");
        herramienta.setFont(new Font("Times new roman",Font.BOLD,14));       
         salir = new JMenu("Salir");
         salir.setOpaque(true);
         salir.setBackground(Color.YELLOW);
          opcion1 = new JMenuItem("SI"); opcion1.addActionListener(this);
          opcion1.setBackground(Color.YELLOW);
          opcion2 = new JMenuItem("NO"); opcion1.addActionListener(this);
          opcion2.setBackground(Color.YELLOW);
          salir.add(opcion1);
          salir.addSeparator();
          salir.add(opcion2);
         herramienta.add(salir);
        barraMenu.add(herramienta);
        
        //construyendo la barra de herramientas
        barraBotones = new JToolBar();
        barraBotones.setBackground(Color.ORANGE);
        ImageIcon imagenb1 = new ImageIcon("b1.png");
        ImageIcon imagenb2 = new ImageIcon("b2.jpg");
        ImageIcon imagenb3 = new ImageIcon("b3.jpg");
        ImageIcon imagenb4 = new ImageIcon("b4.png");
        ImageIcon imagenb5 = new ImageIcon("b5.png");
        ImageIcon imagenb6 = new ImageIcon("b6.png");
        b1 = new JButton((new ImageIcon(imagenb1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH))));
        b1.setBackground(Color.YELLOW);
        b1.addActionListener(this);
        b2 = new JButton((new ImageIcon(imagenb2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH))));
        b2.setBackground(Color.YELLOW);
        b2.addActionListener(this);
        b3 = new JButton((new ImageIcon(imagenb3.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH))));
        b3.setBackground(Color.YELLOW);
        b3.addActionListener(this);
        b4 = new JButton((new ImageIcon(imagenb4.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH))));
        b4.setBackground(Color.YELLOW);
        b4.addActionListener(this);
        b5 = new JButton((new ImageIcon(imagenb5.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH))));
        b5.setBackground(Color.YELLOW);
        b5.addActionListener(this);
        b6 = new JButton((new ImageIcon(imagenb6.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH))));
        b6.setBackground(Color.YELLOW);
        b6.addActionListener(this);
        
        barraBotones.add(b1);
        barraBotones.add(b2);
        barraBotones.add(b3);
        barraBotones.add(b4);
        barraBotones.add(b5);
        barraBotones.add(b6);
          
        imagen1.add(barraBotones, BorderLayout.NORTH);
        panel.add(barraMenu);
        panel.add(imagen1);
        add(panel);  
    }
    
    public void actionPerformed(ActionEvent e) {
        
        Parcial_final3_ventanaDos abrirventana = new Parcial_final3_ventanaDos();
        
        if(e.getSource()==sem1M1 || e.getSource()==b1){abrirventana.Materia1();}
        if(e.getSource()==sem1M2){abrirventana.Materia2();}
        if(e.getSource()==sem1M3){abrirventana.Materia3();}
        if(e.getSource()==sem1M4){abrirventana.Materia4();} 
        if(e.getSource()==sem1M5){abrirventana.Materia5();} 
        if(e.getSource()==sem1M6){abrirventana.Materia6();}                   
 
        if(e.getSource()==sem2M1){abrirventana.Materia7();}
        if(e.getSource()==sem2M2 || e.getSource()==b2){abrirventana.Materia8();}                    
        if(e.getSource()==sem2M3){abrirventana.Materia9();}                  
        if(e.getSource()==sem2M4){abrirventana.Materia10();}                    
        if(e.getSource()==sem2M5){abrirventana.Materia11();}                    
        if(e.getSource()==sem2M6){abrirventana.Materia12();}
        
        if(e.getSource()==sem3M1){abrirventana.Materia13();}
        if(e.getSource()==sem3M2){abrirventana.Materia14();}                    
        if(e.getSource()==sem3M3 || e.getSource()==b3){abrirventana.Materia15();}                  
        if(e.getSource()==sem3M4){abrirventana.Materia16();}                    
        if(e.getSource()==sem3M5){abrirventana.Materia17();}                    
        if(e.getSource()==sem3M6){abrirventana.Materia18();}
        
        if(e.getSource()==sem4M1){abrirventana.Materia19();}
        if(e.getSource()==sem4M2){abrirventana.Materia20();}                    
        if(e.getSource()==sem4M3){abrirventana.Materia21();}                  
        if(e.getSource()==sem4M4 || e.getSource()==b4){abrirventana.Materia22();}                    
        if(e.getSource()==sem4M5){abrirventana.Materia23();}                    
        if(e.getSource()==sem4M6){abrirventana.Materia24();}
        
        if(e.getSource()==sem5M1){abrirventana.Materia25();}
        if(e.getSource()==sem5M2){abrirventana.Materia26();}                    
        if(e.getSource()==sem5M3){abrirventana.Materia27();}                  
        if(e.getSource()==sem5M4){abrirventana.Materia28();}                    
        if(e.getSource()==sem5M5){abrirventana.Materia29();}                    
        if(e.getSource()==sem5M6 || e.getSource()==b5){abrirventana.Materia30();}
        
        if(e.getSource()==sem6M1){abrirventana.Materia31();}
        if(e.getSource()==sem6M2){abrirventana.Materia32();}                    
        if(e.getSource()==sem6M3){abrirventana.Materia33();}                  
        if(e.getSource()==sem6M4){abrirventana.Materia34();}                    
        if(e.getSource()==sem6M5){abrirventana.Materia35();}                    
        if(e.getSource()==sem6M6 || e.getSource()==b6){abrirventana.Materia36();}
        
        if(e.getSource()==opcion1){System.exit(0);}        
    }
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable(){public void run(){new Parcial_final3();}});   
    }   
}











