package EntornoGrafico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora implements ActionListener{
    
    JPanel panel1, panel2;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9; 
    JButton b10, b11, b12, b13, b14, b15, b16;
    JTextField pantalla;
    double num1, num2, total;
    char signo;

    public Calculadora()
    {
        JFrame ventana = new JFrame("CALCULADORA");
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(252,380);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setResizable(false);
     // ventana.getContentPane().setBackground(Color.BLUE);
        
        panel1 = new JPanel();
        panel1.setBounds(0, 0, 235, 100);
        panel1.setBackground(Color.WHITE);
        panel1.setLayout(null);
        
        pantalla = new JTextField();
        pantalla.setBounds(9, 20, 220, 60);
        pantalla.setHorizontalAlignment(pantalla.RIGHT);
        pantalla.setFont(new Font("Times new roman",Font.BOLD,25));
      //pantalla.setFont(new Font("arial",0,25));

        panel1.add(pantalla);
        ventana.add(panel1);
        
        panel2 = new JPanel();
        panel2.setBounds(0, 100, 235, 240);
        panel2.setLayout(new GridLayout(5, 4, 10, 10) );
        panel2.setBackground(Color.WHITE);
        panel2.add(b1=new JButton("1")); b1.addActionListener(this);
        panel2.add(b2=new JButton("2")); b2.addActionListener(this);
        panel2.add(b3=new JButton("3")); b3.addActionListener(this);
        panel2.add(b4=new JButton("4")); b4.addActionListener(this);
        panel2.add(b5=new JButton("5")); b5.addActionListener(this);
        panel2.add(b6=new JButton("6")); b6.addActionListener(this);
        panel2.add(b7=new JButton("7")); b7.addActionListener(this);
        panel2.add(b8=new JButton("8")); b8.addActionListener(this);
        panel2.add(b9=new JButton("9")); b9.addActionListener(this);
        panel2.add(b0=new JButton("0")); b0.addActionListener(this);
        
        panel2.add(b10=new JButton("+")); b10.addActionListener(this);
        panel2.add(b11=new JButton("*")); b11.addActionListener(this);
        panel2.add(b12=new JButton("/")); b12.addActionListener(this);
        panel2.add(b13=new JButton("-")); b13.addActionListener(this);
        panel2.add(b14=new JButton("√")); b14.addActionListener(this);
        panel2.add(b15=new JButton("=")); b15.addActionListener(this);
        panel2.add(b16=new JButton("C")); b16.addActionListener(this);
        
        ventana.add(panel2);   
    }
    
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1){pantalla.setText(pantalla.getText()+"1");}  
        if(e.getSource()==b2){pantalla.setText(pantalla.getText()+"2");}
        if(e.getSource()==b3){pantalla.setText(pantalla.getText()+"3");}
        if(e.getSource()==b4){pantalla.setText(pantalla.getText()+"4");}
        if(e.getSource()==b5){pantalla.setText(pantalla.getText()+"5");}
        if(e.getSource()==b6){pantalla.setText(pantalla.getText()+"6");}
        if(e.getSource()==b7){pantalla.setText(pantalla.getText()+"7");}
        if(e.getSource()==b8){pantalla.setText(pantalla.getText()+"8");}
        if(e.getSource()==b9){pantalla.setText(pantalla.getText()+"9");}
        if(e.getSource()==b0){pantalla.setText(pantalla.getText()+"0");}
        
        if(e.getSource()==b10){
            num1=Double.parseDouble(pantalla.getText());
            signo='+';
            pantalla.setText("");}
        
        if(e.getSource()==b11){
            num1=Double.parseDouble(pantalla.getText());
            signo='*';
            pantalla.setText("");}
        
        if(e.getSource()==b12){
            num1=Double.parseDouble(pantalla.getText()); 
            signo='/';
            pantalla.setText("");}
        
        if(e.getSource()==b13){
            num1=Double.parseDouble(pantalla.getText()); 
            signo='-';
            pantalla.setText("");}
        
        if(e.getSource()==b14){
            num1=Double.parseDouble(pantalla.getText());
            signo='√';
            pantalla.setText("");}
        
        if(e.getSource()==b15){
            if(signo=='√'){total=Math.sqrt(num1);}
            
            else{
                num2=Double.parseDouble(pantalla.getText());
                switch (signo){
                    case '+':total=num1+num2; break;
                    case '*':total=num1*num2; break;                    
                    case '/':total=num1/num2; break;       
                    case '-':total=num1-num2; break;                                             
                }  
            }
            pantalla.setText(decimales(total));
        }
        
        if(e.getSource()==b16){pantalla.setText("");}
    }
    
    public String decimales(double total)
    {
        String decimal="";
        decimal=Double.toString(total);            
        if(total%1==0){decimal=decimal.substring(0, decimal.length()-2);} 
        else{decimal=decimal.substring(0, decimal.length()-2);}
        return decimal;
    }        
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable(){public void run(){new Calculadora();}});   
    } 
}
