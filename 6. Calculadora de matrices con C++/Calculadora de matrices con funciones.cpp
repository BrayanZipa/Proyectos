#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;

void sumaMatrices(int x,int y);
void restaMatrices(int x,int y);
void multiplicacionMatrices(int x,int y, int w, int z);
void divisionMatrices(int x,int y);

int m, i, j, k;

int main(int argc, char *argv[]){
	
	system("color F0 ");
	int n, fila, columna, fila2, columna2;

	
	
	cout<<"CALCULADORA DE MATRICES\n";
	cout<<endl;
	do
	{
		cout<<"Menu de opciones\n";
		cout<<endl;
		cout<<"1 = Suma de matrices\n";
		cout<<"2 = Resta de matrices\n";
		cout<<"3 = Multiplicacion de matrices\n";
		cout<<"4 = Division de matrices (hipotética)\n";
		cout<<"5 = Salir";
		cout<<endl;
		
		cin>>n;
	
		switch(n)
		{
			case 1: cout<<"Ha seleccionado la opcion Suma de matrices\n";
					cout<<endl;
				do{		
					cout<<"Ingrese dos matrices con las mismas dimensiones\n";
					cout<<"Ingrese el numero de filas que van a tener las matrices\n";
					cin>>fila;
					cout<<"Ingrese el numero de columnas que van a tener las matrices\n";
					cin>>columna;
					sumaMatrices(fila,columna);
					
					do{
						cout<<"1 = Desea realizar otra suma de matrices\n";
						cout<<"2 = Desea volver al menu de opciones\n";
						cout<<"5 = Salir\n";
						cout<<endl;
						cin>>n;
						if(n!=1 and n!=2 and n!=5){
							system("cls");
							cout<<"El valor ingresado no es correcto, intente nuevamente\n";
							cout<<endl;}
						system("cls");
						
					}while((n!=1) and (n!=2) and (n!=5));
		     	}while(n==1);
			break;
			
			case 2: cout<<"Ha seleccionado la opcion Resta de matrices\n";
					cout<<endl;
				do{		
					cout<<"Ingrese dos matrices con las mismas dimensiones\n";
					cout<<"Ingrese el numero de filas que van a tener las matrices\n";
					cin>>fila;
					cout<<"Ingrese el numero de columnas que van a tener las matrices\n";
					cin>>columna;
					restaMatrices(fila,columna);
					
					do{
						cout<<"1 = Desea realizar otra resta de matrices\n";
						cout<<"2 = Desea volver al menu de opciones\n";
						cout<<"5 = Salir\n";
						cout<<endl;
						cin>>n;
						if(n!=1 and n!=2 and n!=5){
							system("cls");
							cout<<"El valor ingresado no es correcto, intente nuevamente\n";
							cout<<endl;}
						system("cls");
						
					}while((n!=1) and (n!=2) and (n!=5));
		     	}while(n==1);	
			break;
			
			case 3: cout<<"Ha seleccionado la opcion Multiplicacion de matrices\n";
					cout<<endl;
				do{		
					cout<<"Para multiplicar matrices las columnas de la primera matriz deben ser iguales a las filas de la segunda matriz\n";
					cout<<endl;
					cout<<"Ingrese el numero de filas de la primera matriz\n";
					cin>>fila;
					cout<<"Ingrese el numero de columnas de la primera matriz\n";
					cin>>columna;
					cout<<"Ingrese el numero de filas de la segunda matriz\n";
					cin>>fila2;
					cout<<"Ingrese el numero de columnas de la segunda matriz\n";
					cin>>columna2;
					if(columna==fila2){
					
						multiplicacionMatrices(fila,columna,fila2,columna2);
						
						do{
							cout<<"1 = Desea realizar otra multiplicacion de matrices\n";
							cout<<"2 = Desea volver al menu de opciones\n";
							cout<<"5 = Salir\n";
							cout<<endl;
							cin>>n;
							if(n!=1 and n!=2 and n!=5){
								system("cls");
								cout<<"El valor ingresado no es correcto, intente nuevamente\n";
								cout<<endl;}
							system("cls");
										
					    }while((n!=1) and (n!=2) and (n!=5));
					}
					else{system("cls");
						 cout<<"Los valores ingresados no cumplen las condiciones para mutliplicar matrices\n";
						 cout<<"Vuelva a ingresar los valores\n";
						 n=1;
						 cout<<endl;}		
			    }while(n==1);
			break;
			
			case 4: cout<<"Ha seleccionado la opcion Division de matrices (hipotética)\n";
			cout<<endl;
				do{		
					cout<<"Ingrese dos matrices con las mismas dimensiones\n";
					cout<<"Ingrese el numero de filas que van a tener las matrices\n";
					cin>>fila;
					cout<<"Ingrese el numero de columnas que van a tener las matrices\n";
					cin>>columna;
					divisionMatrices(fila,columna);
					
					do{
						cout<<"1 = Desea realizar otra division de matrices\n";
						cout<<"2 = Desea volver al menu de opciones\n";
						cout<<"5 = Salir\n";
						cout<<endl;
						cin>>n;
						if(n!=1 and n!=2 and n!=5){
							system("cls");
							cout<<"El valor ingresado no es correcto, intente nuevamente\n";
							cout<<endl;}
						system("cls");
									
					}while((n!=1) and (n!=2) and (n!=5));	
			    }while(n==1);
			break;
			
			case 5: cout<<endl;
			break;	
			
		    default: cout<<"ERROR: El valor "<<n<<" ingresado no esta en las opciones\n";
		    		 cout<<"Intente nuevamente, selecione una opcion\n";
		    		 cout<<endl;
		}
			
    }while(n!=5);
    cout<<"Ha seleccionado salir del programa\n";
	cout<<endl; 
			
system("PAUSE");
return 0; 
}

void sumaMatrices(int x,int y){
	
	float matriz[2][x][y];
	cout<<endl;
	cout<<"Ingrese las matrices "<<x<<"x"<<y<<endl;
	
	for(m=0;m<2;m++){	
		for( i=0;i<x;i++){
			for(j=0;j<y;j++){
			
				cout<<"Ingrese en la matriz "<<m+1<<" el valor correspondiente a la fila "
				<<i+1<<" y columna "<<j+1<<": ";	
				cin>>matriz[m][i][j];	
			}
		}
	}
	system("cls");
	
	cout<<"Matrices ingresadas\n";
	for(m=0;m<2;m++){
		for(i=0;i<x;i++){
	    	for(j=0;j<y;j++){
	    	
	    		cout<<matriz[m][i][j]<<" ";
	    	}
	    	cout<<endl;
		}
		cout<<endl;
	}
	
	cout<<"La suma de las matrices ingresadas es:\n";
	for( i=0;i<x;i++){
		for(j=0;j<y;j++){
		
			cout<<matriz[0][i][j]+matriz[1][i][j]<<" ";		
		}
		cout<<endl;
	}
	cout<<endl;	
}

void restaMatrices(int x,int y){
	
	float matriz[2][x][y];
	cout<<endl;
	cout<<"Ingrese las matrices "<<x<<"x"<<y<<endl;
	
	for(m=0;m<2;m++){	
		for( i=0;i<x;i++){
			for(j=0;j<y;j++){
			
				cout<<"Ingrese en la matriz "<<m+1<<" el valor correspondiente a la fila "
				<<i+1<<" y columna "<<j+1<<": ";	
				cin>>matriz[m][i][j];	
			}
		}
	}
	system("cls");
	
	cout<<"Matrices ingresadas\n";
	for(m=0;m<2;m++){
		for(i=0;i<x;i++){
	    	for(j=0;j<y;j++){
	    	
	    		cout<<matriz[m][i][j]<<" ";
	    	}
	    	cout<<endl;
		}
		cout<<endl;
	}
	
	cout<<"La resta de las matrices ingresadas es:\n";
	for( i=0;i<x;i++){
		for(j=0;j<y;j++){
		
			cout<<matriz[0][i][j]-matriz[1][i][j]<<" ";		
		}
		cout<<endl;
	}
	cout<<endl;		
}

void multiplicacionMatrices(int x,int y, int w, int z){
	
	float matriz[x][y];
	float matriz2[w][z];
	float resultado[x][z];
	cout<<endl;
	
	cout<<"Ingrese la matriz "<<x<<"x"<<y<<endl;
	for( i=0;i<x;i++){
			for(j=0;j<y;j++){
			
				cout<<"Ingrese en la matriz "<<x<<"x"<<y<<" el valor correspondiente a la fila "
				<<i+1<<" y columna "<<j+1<<": ";	
				cin>>matriz[i][j];	
			}
	}
	cout<<endl;
	
	cout<<"Ingrese la matriz "<<w<<"x"<<z<<endl;
	for( i=0;i<w;i++){
			for(j=0;j<z;j++){
			
				cout<<"Ingrese en la matriz "<<w<<"x"<<z<<" el valor correspondiente a la fila "
				<<i+1<<" y columna "<<j+1<<": ";	
				cin>>matriz2[i][j];	
			}
	}
	system("cls");
	
	cout<<"Matriz "<<x<<"x"<<y<<" ingresada\n";
	for(i=0;i<x;i++){
	    for(j=0;j<y;j++){
	    	
	    	cout<<matriz[i][j]<<" ";
	    }
	   	cout<<endl;
	}
	cout<<endl;
	
	cout<<"Matriz "<<w<<"x"<<z<<" ingresada\n";
	for(i=0;i<w;i++){
	    for(j=0;j<z;j++){
	    	
	    	cout<<matriz2[i][j]<<" ";
	    }
	   	cout<<endl;
	}
	cout<<endl;
	
	cout<<"La multiplicacion de las matrices ingresadas es:\n";
	for( i=0;i<x;i++){
		for(j=0;j<z;j++){
			for(k=0;k<y;k++){
				
				resultado[i][j]+=matriz[i][k]*matriz2[k][j];	
			}
			cout<<resultado[i][j]<<" ";
		} 
		cout<<endl;
	}
	cout<<endl;		
}

void divisionMatrices(int x,int y){
	
	float matriz[2][x][y];
	cout<<endl;
	cout<<"Ingrese las matrices "<<x<<"x"<<y<<endl;	
	
	for(m=0;m<2;m++){	
		for( i=0;i<x;i++){
			for(j=0;j<y;j++){
			
				cout<<"Ingrese en la matriz "<<m+1<<" el valor correspondiente a la fila "
				<<i+1<<" y columna "<<j+1<<": ";	
				cin>>matriz[m][i][j];	
			}
		}
	}
	system("cls");
	
	cout<<"Matrices ingresadas\n";
	for(m=0;m<2;m++){
		for(i=0;i<x;i++){
	    	for(j=0;j<y;j++){
	    	
	    		cout<<matriz[m][i][j]<<" ";
	    	}
	    	cout<<endl;
		}
		cout<<endl;
	}
	
	cout<<"La division de las matrices ingresadas es:\n";
	for( i=0;i<x;i++){
		for(j=0;j<y;j++){
		
			cout<<matriz[0][i][j]/matriz[1][i][j]<<" ";		
		}
		cout<<endl;
	}
	cout<<endl;			
}
