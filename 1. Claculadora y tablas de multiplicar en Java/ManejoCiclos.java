package ManejoCiclos;

import java.util.Scanner;

public class ManejoCiclos{
    
    public static void main(String[] args) {
        
        Scanner valores = new Scanner(System.in);
        
        int opcion,n;
        boolean a=true, b=true, c=true;
        
        while(a==true){
            
            System.out.println("MENU DE OPCIONES");
            System.out.println("Seleccione:");
            System.out.println("");
            System.out.println("1 para calculadora");
            System.out.println("2 para tablas de multiplicar");
            opcion = valores.nextInt();
            System.out.println("");
            
            if(opcion>0 && opcion<=2){
                a= false;

                switch(opcion){
                    case 1:
                        while(b==true){
                            System.out.println("Usted ha seleccionado calculadora"); 
                            System.out.println("Menu de opciones");
                            System.out.println("Seleccione:");
                            System.out.println("");
                            System.out.println("1 para suma");
                            System.out.println("2 para resta");
                            System.out.println("3 para multiplicacion");
                            System.out.println("4 para division");
                            System.out.println("5 para porcentaje");
                            System.out.println("6 para calcular el seno de un numero");
                            n = valores.nextInt();
                            System.out.println(""); 

                            if(n>0 && n<=6){
                                b=false;
                                double p,q,resultado;

                                switch(n){
                                    case 1:
                                        System.out.println("Ha seleccionado suma");
                                        System.out.println("Introduzca dos numeros par ser sumados");
                                        p = valores.nextDouble();
                                        q = valores.nextDouble();
                                        resultado = p+q;
                                        System.out.println("La suma de los valores ingresados es "+resultado);
                                    break;
                                    
                                    case 2:
                                        System.out.println("Ha seleccionado resta");
                                        System.out.println("Introduzca dos numeros para ser restados");
                                        p = valores.nextDouble();
                                        q = valores.nextDouble();
                                        resultado = p-q;
                                        System.out.println("La resta de los valores ingresados es "+resultado);
                                    break;
                                    
                                    case 3:
                                        System.out.println("Ha seleccionado multiplicacion");
                                        System.out.println("Introduzca dos numeros para ser multiplicados");
                                        p = valores.nextDouble();
                                        q = valores.nextDouble();
                                        resultado = p*q;
                                        System.out.println("La multiplicacion de los valores ingresados es "+resultado);
                                    break;
                                    
                                    case 4:
                                        System.out.println("Ha seleccionado division");
                                        System.out.println("Introduzca dos numeros para ser divididos");
                                        p = valores.nextDouble();
                                        q = valores.nextDouble();
                                        resultado = p/q;
                                        System.out.println("La divison de los valores ingresados es "+resultado);
                                    break;
                                    
                                    case 5:
                                        System.out.println("Ha seleccionado porcentaje");
                                        System.out.println("Introduzca el numero del cual desea saber el porcentaje");
                                        p = valores.nextDouble();
                                        System.out.println("Introduzca el valor del porcentaje que desea conocer, sin el signo %");
                                        q = valores.nextDouble();
                                        resultado = (p*q)/100;
                                        System.out.println("El "+q+" % de "+p+" es igual a "+resultado+" %");
                                    break;
                                    
                                    case 6: 
                                        System.out.println("Ha seleccionado calcular seno");              
                                        System.out.println("Introduzca el angulo del cual quiere calcular el seno, sin el signo°");
                                        p = valores.nextDouble();
                                        
                                        q = Math.toRadians(p);
                                        resultado = Math.sin(q);
                                        System.out.println("El seno de "+p+"° es "+resultado+"°");         
                                    break;  
                                }   
                            }
                            else{System.out.println("ESA OPCION NO ESTA DISPONIBLE, INTENTELO NUEVAMENTE");
                                 System.out.println("");}
                        }
                    break;
  
                    case 2:
                        while(b==true){
                            System.out.println("Usted ha seleccionado tablas de multiplicar");
                            System.out.println("Menu de opciones");
                            System.out.println("Seleccione:");
                            System.out.println("");
                            System.out.println("1 para tablas de multiplicar por el ciclo FOR");
                            System.out.println("2 para tablas de multiplicar por el ciclo WHILE");
                            System.out.println("3 para tablas de multiplicar por el ciclo DO WHILE");
                            n = valores.nextInt();
                            System.out.println("");
                            
                            if(n>0 && n<=3){
                                b=false;
                                int num1,num2,f=1,tabla;
                                
                                switch(n){
                                    case 1:
                                        System.out.println("Ha seleccionado tablas de multiplicar por el ciclo FOR");
                                        
                                        while(c==true){
                                            System.out.println("Ingrese numeros positivos");
                                            System.out.println("Ingrese el numero del cual desea saber la tabla de multiplicar");
                                            num1= valores.nextInt();
                                            System.out.println("Ingrese hasta que numero desea saber el valor de tabla de multiplicar");
                                            num2= valores.nextInt();

                                            if (num1>=0 && num2>=0){ 
                                                c=false;
                                                System.out.println("La tabla de multiplicar del numero "+num1+" hasta el valor "+num2+" es:");

                                                    for(f=1;f<=num2;f++){
                                                        tabla= num1*f;
                                                        System.out.println(num1+" * "+f+" = "+tabla);
                                                    }   
                                            }
                                            else{System.out.println("UNO O AMBOS NUMEROS INGRSADOS SON INCORRECTOS, INTENTELO NUEVAMENTE");
                                                 System.out.println("");}
                                        }
                                    break;
                                        
                                    case 2:
                                        System.out.println("Ha seleccionado tablas de multiplicar por el ciclo WHILE");
                                        
                                        while(c==true){
                                            System.out.println("Ingrese numeros positivos");
                                            System.out.println("Ingrese el numero del cual desea saber la tabla de multiplicar");
                                            num1= valores.nextInt();
                                            System.out.println("Ingrese hasta que numero desea saber el valor de tabla de multiplicar");
                                            num2= valores.nextInt();

                                            if (num1>=0 && num2>=0){ 
                                                c=false;
                                                System.out.println("La tabla de multiplicar del numero "+num1+" hasta el valor "+num2+" es:");

                                                    while(f<=num2){
                                                        tabla= num1*f;           
                                                        System.out.println(num1+" * "+f+" = "+tabla);
                                                        f++;
                                                    }   
                                            }
                                            else{System.out.println("UNO O AMBOS NUMEROS INGRSADOS SON INCORRECTOS, INTENTELO NUEVAMENTE");
                                                 System.out.println("");}
                                        }
                                    break;
                                        
                                    case 3:
                                        System.out.println("Ha seleccionado tablas de multiplicar por el ciclo DO WHILE");
                                        
                                        while(c==true){
                                            System.out.println("Ingrese numeros positivos");
                                            System.out.println("Ingrese el numero del cual desea saber la tabla de multiplicar");
                                            num1= valores.nextInt();
                                            System.out.println("Ingrese hasta que numero desea saber el valor de tabla de multiplicar");
                                            num2= valores.nextInt(); 

                                            if (num1>=0 && num2>=0){ 
                                                c=false;
                                                System.out.println("La tabla de multiplicar del numero "+num1+" hasta el valor "+num2+" es:");

                                                    do{
                                                        tabla= num1*f;           
                                                        System.out.println(num1+" * "+f+" = "+tabla);
                                                        f++;
                                                    }while(f<=num2);  
                                            }
                                            else{System.out.println("UNO O AMBOS NUMEROS INGRSADOS SON INCORRECTOS, INTENTELO NUEVAMENTE");
                                                 System.out.println("");}
                                        }
                                    break;     
                                }
                            }
                            else{System.out.println("ESA OPCION NO ESTA DISPONIBLE, INTENTELO NUEVAMENTE");
                                 System.out.println("");}
                        }
                    break;
                }                       
            } 
            else{System.out.println("ESA OPCION NO ESTA DISPONIBLE, INTENTELO NUEVAMENTE");
                 System.out.println("");} 
        } 
    } 
}
