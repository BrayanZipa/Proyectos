package parcial_final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Parcial_final3_ventanaDos extends JFrame implements ActionListener  {
    
    JPanel panel;
    JLabel imagen2;
    JLabel salon, profe, estudiante, numero, nombre;
    JLabel nota1, nota2, nota3, definitiva, total;
    JTextField n1, n2, n3, nombre2;
    JButton calcular, validar, cerrar;
    double num1=0, num2=0, num3=0,resultado=0;
    
    public Parcial_final3_ventanaDos (){
        
        setSize(600,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        
        imagen2 = new JLabel(new ImageIcon("imagen2.jpg"));
        imagen2.setBounds(0, 0, 585, 362);
        
        salon = new JLabel("SALON DE CLASES");
        profe = new JLabel("PROFESOR");
        estudiante = new JLabel("ESTUDIANTE"); 
        numero = new JLabel();
        nombre = new JLabel(); 
        salon.setBounds(20, 20, 150, 15);
        salon.setFont(new Font("Times new roman",Font.BOLD,16));
        salon.setOpaque(true);
        salon.setBackground(Color.ORANGE);
        profe.setBounds(20, 60, 90, 15);
        profe.setFont(new Font("Times new roman",Font.BOLD,16));
        profe.setOpaque(true);
        profe.setBackground(Color.ORANGE);
        estudiante.setBounds(20, 100, 105, 15);
        estudiante.setFont(new Font("Times new roman",Font.BOLD,16));
        estudiante.setOpaque(true);
        estudiante.setBackground(Color.ORANGE);
        numero.setBounds(220, 20, 40, 15);
        numero.setFont(new Font("Times new roman",Font.BOLD,16));
        numero.setOpaque(true);
        numero.setBackground(Color.ORANGE);
        nombre.setBounds(220, 60, 290, 15);
        nombre.setFont(new Font("Times new roman",Font.BOLD,16));
        nombre.setOpaque(true);
        nombre.setBackground(Color.ORANGE);

        nota1 = new JLabel("NOTA 1");
        nota2 = new JLabel("NOTA 2");
        nota3 = new JLabel("NOTA 3");
        definitiva = new JLabel("DEFINITIVA");
        total = new JLabel();
        nota1.setBounds(20, 155, 100, 15);
        nota1.setFont(new Font("Times new roman",Font.BOLD,16));
        nota1.setHorizontalAlignment(nota1.CENTER);
        nota1.setOpaque(true);
        nota1.setBackground(Color.ORANGE);
        nota2.setBounds(20, 195, 100, 15);
        nota2.setFont(new Font("Times new roman",Font.BOLD,16));
        nota2.setHorizontalAlignment(nota2.CENTER);
        nota2.setOpaque(true);
        nota2.setBackground(Color.ORANGE);
        nota3.setBounds(20, 235, 100, 15);
        nota3.setFont(new Font("Times new roman",Font.BOLD,16));
        nota3.setHorizontalAlignment(nota3.CENTER);
        nota3.setOpaque(true);
        nota3.setBackground(Color.ORANGE);
        definitiva.setBounds(20, 275, 100, 20);
        definitiva.setFont(new Font("Times new roman",Font.BOLD,16));
        definitiva.setOpaque(true);
        definitiva.setBackground(Color.ORANGE);
        total.setBounds(220, 275, 38, 20);
        total.setFont(new Font("Times new roman",Font.BOLD,16)); 
        total.setHorizontalAlignment(total.CENTER);
        total.setOpaque(true);
        total.setBackground(Color.white);
        
        nombre2 = new JTextField();
        n1 = new JTextField(); 
        n2 = new JTextField(); 
        n3 = new JTextField(); 
        nombre2.setBounds(220, 100, 290, 20);
        nombre2.setFont(new Font("Times new roman",Font.BOLD,16));
        nombre2.setOpaque(true);
        nombre2.setBackground(Color.WHITE);
        n1.setBounds(220, 155, 38, 20);
        n1.setFont(new Font("Times new roman",Font.BOLD,16));
        n1.setHorizontalAlignment(n1.CENTER);
        n2.setBounds(220, 195, 38, 20);
        n2.setFont(new Font("Times new roman",Font.BOLD,16));
        n2.setHorizontalAlignment(n2.CENTER);
        n3.setBounds(220, 235, 38, 20);
        n3.setFont(new Font("Times new roman",Font.BOLD,16));
        n3.setHorizontalAlignment(n3.CENTER);
        
        calcular = new JButton("CALCULAR"); calcular.addActionListener(this);
        validar = new JButton("VALIDAR"); validar.addActionListener(this);
        cerrar = new JButton("CERRAR"); cerrar.addActionListener(this);
        calcular.setBounds(150, 330, 90, 25);
        calcular.setBackground(Color.orange);
        calcular.setForeground(Color.red);
        calcular.setFont(new Font("Times new roman",Font.BOLD,10));
        validar.setBounds(250, 330, 90, 25);
        validar.setBackground(Color.orange);
        validar.setForeground(Color.red);
        validar.setFont(new Font("Times new roman",Font.BOLD,10));
        cerrar.setBounds(350, 330, 90, 25);
        cerrar.setBackground(Color.orange);
        cerrar.setForeground(Color.red);
        cerrar.setFont(new Font("Times new roman",Font.BOLD,10));
        
        panel.add(salon);
        panel.add(profe);
        panel.add(estudiante);
        panel.add(numero);
        panel.add(nombre);
        panel.add(nombre2);
        panel.add(nota1);
        panel.add(nota2);
        panel.add(nota3);
        panel.add(definitiva);
        panel.add(total);
        panel.add(n1);
        panel.add(n2);
        panel.add(n3);
        panel.add(calcular);
        panel.add(validar);
        panel.add(cerrar);
        panel.add(imagen2);
        add(panel);
    }
    
    public void Materia1(){
    setTitle("Algoritmia y programación básica");
    nombre.setText("Malonso Julian Diaz Jaramillo");
    numero.setText("102");}

    public void Materia2(){
        setTitle("Catedra Agustiniana");
        nombre.setText("Benito Antonio Ramirez Guerrero");
        numero.setText("103");}
    
    public void Materia3(){
        setTitle("Cálculo Diferencial");
        nombre.setText("Sandra Maria Valencia Rodriguez");
        numero.setText("104");}
    
    public void Materia4(){
        setTitle("Álgebra Lineal");
        nombre.setText("Juan Alejandro Florez Castro");
        numero.setText("105");}
    
    public void Materia5(){
        setTitle("Introducción al Desarrollo de Software");
        nombre.setText("Malonso Julian Diaz Jaramillo");
        numero.setText("106");}
    
    public void Materia6(){
        setTitle("Métodos de estudio");
        nombre.setText("Martha Cecilia Botero Nuñez");
        numero.setText("107");}
 
    public void Materia7(){
        setTitle("Cálculo Integral");
        nombre.setText("Luis Antonio Salazar Ramirez");
        numero.setText("115");}
    
    public void Materia8(){
        setTitle("Programación Orientada a Objetos");
        nombre.setText("Malonso Julian Diaz Jaramillo");
        numero.setText("117");}
    
    public void Materia9(){
        setTitle("Estructuras de datos");
        nombre.setText("Juliana Milena Contreras Valle");
        numero.setText("108");}
    
    public void Materia10(){
        setTitle("Introducción al Emprendimiento");
        nombre.setText("Jhon Freddy Ardila Escobar");
        numero.setText("110");}
    
    public void Materia11(){
        setTitle("Humanidades I");
        nombre.setText("Mario Humberto Castañeda Ruiz");
        numero.setText("112");}

    public void Materia12(){
        setTitle("Inglés I");
        nombre.setText("Johan Alejandro Arenas Fonseca");
        numero.setText("120");}
    
    public void Materia13(){
        setTitle("Estadística");
        nombre.setText("Luis Antonio Salazar Ramirez");
        numero.setText("201");}
    
    public void Materia14(){
        setTitle("Análisis y Diseño de Software");
        nombre.setText("Juliana Milena Contreras Valle");
        numero.setText("105");}
    
    public void Materia15(){
        setTitle("Modelado de Base de Datos");
        nombre.setText("Malonso Julian Diaz Jaramillo");
        numero.setText("210");}
    
    public void Materia16(){
        setTitle("Fundamentos de Desarrollo Web");
        nombre.setText("Cristian David Muñoz Garcia");
        numero.setText("217");}
    
    public void Materia17(){
        setTitle("Contabilidad");
        nombre.setText("Camila Andrea Pedraza Herrera");
        numero.setText("213");}
    
    public void Materia18(){
        setTitle("Inglés II");
        nombre.setText("Johan Alejandro Arenas Fonseca");
        numero.setText("218");}
    
    public void Materia19(){
        setTitle("Estructuras de Datos Avanzada");
        nombre.setText("Juliana Milena Contreras Valle");
        numero.setText("219");}
    
    public void Materia20(){
        setTitle("Gestión de Base de Datos");
        nombre.setText("Malonso Julian Diaz Jaramillo");
        numero.setText("107");}
    
    public void Materia21(){
        setTitle("Construcción de Aplicaciones Web");
        nombre.setText("Rosa Aura Jaramillo Valencia");
        numero.setText("117");}
    
    public void Materia22(){
        setTitle("Tecnologías para Aplicaciones Móviles");
        nombre.setText("Cristian David Muñoz Garcia");
        numero.setText("119");}
    
    public void Materia23(){
        setTitle("Emprendimiento I");
        nombre.setText("Jhon Freddy Ardila Escobar");
        numero.setText("120");}
    
    public void Materia24(){
        setTitle("Inglés III");
        nombre.setText("Johan Alejandro Arenas Fonseca");
        numero.setText("211");}

    public void Materia25(){
        setTitle("Arquitectura de Software");
        nombre.setText("Malonso Julian Diaz Jaramillo");
        numero.setText("300");}
    
    public void Materia26(){
        setTitle("Sistemas Operativos y Arquitectura de Hardware");
        nombre.setText("Rosa Aura Jaramillo Valencia");
        numero.setText("302");}
    
    public void Materia27(){
        setTitle("Técnicas Avanzadas de Programación para Móviles");
        nombre.setText("Cristian David Muñoz Garcia");
        numero.setText("308");}
    
    public void Materia28(){
        setTitle("Investigación Formativa");
        nombre.setText("Julian Alfonso Ballesteros Restrepo");
        numero.setText("310");}
    
    public void Materia29(){
        setTitle("Ética");
        nombre.setText("Benito Antonio Ramirez Guerrero");
        numero.setText("312");}
    
    public void Materia30(){
        setTitle("Inglés IV");
        nombre.setText("Johan Alejandro Arenas Fonseca");
        numero.setText("315");}
  
    public void Materia31(){
        setTitle("Legislación Tecnológica");
        nombre.setText("Juliana Milena Contreras Valle");
        numero.setText("118");}
    
    public void Materia32(){
        setTitle("Desarrollo y Refinamiento de Software");
        nombre.setText("Rosa Aura Jaramillo Valencia");
        numero.setText("313");}
    
    public void Materia33(){
        setTitle("Electiva Profesional I");
        nombre.setText("Julian Alfonso Ballesteros Restrepo");
        numero.setText("316");}
    
    public void Materia34(){
        setTitle("Electiva Profesional II");
        nombre.setText("Cristian David Muñoz Garcia");
        numero.setText("301");}
    
    public void Materia35(){
        setTitle("Electiva Profesional III");
        nombre.setText("Malonso Julian Diaz Jaramillo");
        numero.setText("305");}
    
    public void Materia36(){
        setTitle("Opción de Grado");
        nombre.setText("Malonso Julian Diaz Jaramillo");
        numero.setText("308");}
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==calcular){
            num1=Double.parseDouble(n1.getText());
            num2=Double.parseDouble(n2.getText()); 
            num3=Double.parseDouble(n3.getText());
                
            if(((num1>=0 && num2>=0 &&  num3>=0) && (num1<=5 && num2<=5 &&  num3<=5))||(((num1>=10 || num1==0) && (num2>=10 || num2==0) && (num3>=10 || num3==0)) && (num1<=50 && num2<=50 &&  num3<=50))){
                
                resultado=+((num1+num2+num3)/3);
                if(resultado%1==0){ 
                    String resultado2;
                    resultado2=(Double.toString(resultado));
                    resultado2=resultado2.substring(0, resultado2.length()-2);
                    total.setText(resultado2);     
                }
                else{
                    //DecimalFormat decimal = new DecimalFormat("#.00");
                    //total.setText(String.format("%.2f", resultado)); 
                    resultado=(double)Math.round(resultado * 100d)/100;
                    total.setText(Double.toString(resultado));
                }
            }
            
            else{JOptionPane.showMessageDialog(null, "Para calcular las notas debe usar valores entre 10 a 50, en caso de que utilize decimales "
                 + "deben ser valores entre 0 a 5");}    
        } 
        
        if(e.getSource()==validar){
            
            Parcial_final3_ventanaTres abrirventana = new Parcial_final3_ventanaTres();
            setVisible(false);
            abrirventana.setTitle(getTitle());
            Parcial_final3_ventanaTres.nombreEstudiante.setText(nombre2.getText());
            Parcial_final3_ventanaTres.total2.setText(total.getText());
        }
       
        if(e.getSource()==cerrar){dispose();}     
    }
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable(){public void run(){new Parcial_final3_ventanaDos();}});      
    }   
}
