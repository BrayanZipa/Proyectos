#include <iostream>
#include <conio.h>
#include <string.h>
using namespace std;

struct materia{
	long codigo;
	int nom_materia;
	int unidad_credito;
	float calificacion;
};

struct alumno{
	long cedula;
	string nombre;
	int sexo;
	int edad;
	int carrera;
	int semestre;
	float calif_promedio;
	struct materia mta[4];
};
	
void Registro_Datos(alumno estudiante[],int);
void Listado_General(alumno estudiante[],int);
void Alumnos_Materias(alumno estudiante[],int);
void Alumnos_Reprobados(alumno estudiante[],int);
void Materia_Especifica(alumno estudiante[],int);
	
int main(){ 
			
	system("color F0 ");
	
    int m, n;
	
	cout<<"Ingrese el numero de alumnos de los cuales va a ingresar informacion\n";
	cin>>m;

	alumno *estudiante = new alumno[m];		
	
	Registro_Datos(estudiante,m);
	
	do
	{
		cout<<"MENU DE OPCIONES\n"<<endl;
		cout<<"1 = Listado general\n";
		cout<<"2 = Listado de alumnos y materias que cursan\n";
		cout<<"3 = Alumnos reprobados y sus datos\n";
		cout<<"4 = Alumnos por materia especifica\n";
		cout<<"5 = Salir\n";
		cin>>n;
		system("cls");
		
		switch (n)
		{
			case 1: cout<<"LISTADO GENERAL DE TODOS LOS ESTUDIANTES\n"<<endl;
					Listado_General(estudiante,m);
				do{
					cout<<"1 = Desea volver al menu de opciones\n";
					cout<<"2 = Salir\n";
					cout<<endl;
					cin>>n;
					if(n!=1 and n!=2){
						system("cls");
						cout<<"El valor ingresado no es correcto, intente nuevamente\n";
						cout<<endl;}
						system("cls");	
												
				}while((n!=1) and (n!=2));
				if(n==2){n+=3;};				
			break;	
			
			case 2: cout<<"LISTADO DE ESTUDIANTES Y MATERIAS QUE CURSAN\n"<<endl;
					Alumnos_Materias(estudiante, m);			
				do{
					cout<<"1 = Desea volver al menu de opciones\n";
					cout<<"2 = Salir\n";
					cout<<endl;
					cin>>n;
					if(n!=1 and n!=2){
						system("cls");
						cout<<"El valor ingresado no es correcto, intente nuevamente\n";
						cout<<endl;}
						system("cls");	
												
				}while((n!=1) and (n!=2));
				if(n==2){n+=3;};	
			break;
			
			case 3: cout<<"LISTADO DE ALUMNOS REPROBADOS Y SUS DATOS\n"<<endl;
					 Alumnos_Reprobados(estudiante, m);
				do{
					cout<<"1 = Desea volver al menu de opciones\n";
					cout<<"2 = Salir\n";
					cout<<endl;
					cin>>n;
					if(n!=1 and n!=2){
						system("cls");
						cout<<"El valor ingresado no es correcto, intente nuevamente\n";
						cout<<endl;}
						system("cls");	
												
				}while((n!=1) and (n!=2));
				if(n==2){n+=3;};
			break;
			
			case 4: cout<<"LISTADO DE ALUMNOS POR MATERIA ESPECIFICA\n"<<endl;
					Materia_Especifica(estudiante, m);
				do{
					cout<<"1 = Desea volver al menu de opciones\n";
					cout<<"2 = Salir\n";
					cout<<endl;
					cin>>n;
					if(n!=1 and n!=2){
						system("cls");
						cout<<"El valor ingresado no es correcto, intente nuevamente\n";
						cout<<endl;}
						system("cls");	
												
				}while((n!=1) and (n!=2));
				if(n==2){n+=3;};
			break;
			
			case 5: cout<<endl;
			break;
			
			default: cout<<"ERROR: El valor "<<n<<" ingresado no esta en las opciones\n";
		    		 cout<<"Intente nuevamente, selecione una opcion\n"<<endl;
		}
		
	}while(n!=5);	
	cout<<"Ha seleccionado salir del programa\n"<<endl;
	
system("PAUSE");
return 0; 	
}

void Registro_Datos(alumno estudiante[],int m){
	
	int cambioVarible=0;
	bool validacionMateria = true;
	bool validacionCarrera = true; 
	bool validacionSemestre = true; 

	for(int i=0;i<m;i++){
		fflush(stdin);
		cout<<"INGRESE LOS DATOS SOLICITADOS DEL ESTUDIANTE "<<i+1<<endl<<endl;
		cout<<"Ingrese la cedula del estudiante\n";
		cin>>estudiante[i].cedula;
	    cout<<"Ingrese el nombre del estudiante\n";
	    cin>>estudiante[i].nombre;
	    cin.ignore(40,'\n');
		//cin.getline(estudiante[i].nombre,20,'\n');
		
		//getline(cin, estudiante[i].nombre);
		cout<<"Ingrese el el sexo del estudiante como:\n 1 = Masculino\n 2 = Femenino\n";
		cin>>estudiante[i].sexo;
		cout<<"Ingrese la edad del estudiante\n";
		cin>>estudiante[i].edad;
		system("cls");
		
		cout<<"Ingrese la carrera del estudiante teniendo en cuenta lo siguiente:\n"<<endl;
		while(validacionCarrera==true){
			cout<<" 1 = Desarrollo de software\n 2 = Ingenieria industrial\n 3 = Ingenieria de telecomunicaciones\n 4 = Gastronomia\n 5 = Contabilidad\n";
			cin>>estudiante[i].carrera;
			if(estudiante[i].carrera>=1 and estudiante[i].carrera<=5){validacionCarrera=false;}
			else{system("cls"); cout<<"La opcion selecionada no se encuentra entre las opciones, intentelo nuevamente\n\n";}
		}
		validacionCarrera=true;
		
		cout<<"Ingrese el semestre que cursa el estudiante teniendo en cuanta lo siguiente:\n"<<endl;
		while(validacionSemestre==true){
			cout<<" 1 = Primer semestre\n 2 = Segundo semestre\n 3 = Tercer semestre\n 4 = Cuarto semestre\n 5 = Quinto semestre\n 6 = Sexto semestre\n";
			cin>>estudiante[i].semestre;
			if(estudiante[i].semestre>=1 and estudiante[i].semestre<=6){validacionSemestre=false;}
			else{system("cls"); cout<<"La opcion selecionada no se encuentra entre las opciones, intentelo nuevamente\n\n";}
		}
		validacionSemestre=true;
		
		cout<<"Ingrese la calificacion promedio del estudiante\n";
		cin>>estudiante[i].calif_promedio;
		system("cls");
		
		cout<<"INGRESE LA INFORMACION DE LAS MATERIAS CURSADAS POR EL ESTUDIANTE "<<i+1<<endl<<endl;
		for(int j=0;j<4;j++){	
		    while(validacionMateria == true){
			
				cout<<"MATERIA "<<j+1<<endl<<endl;
				cout<<"Ingrese el nombre de la materia teniendo en cuenta lo siguiente:\n";
				cout<<" 1 = Algoritmia y programacion basica\n 2 = Programacion orientada a objetos\n 3 = Calculo diferencial\n 4 = Calculo integral\n"<<
					  " 5 = Quimica de alimentos\n 6 = Panaderia y pasteleria\n 7 = Contabilidad\n 8 = Ingles\n 9 = Estadistica\n 10 = Costos\n"<<endl;
				cin>>estudiante[i].mta[j].nom_materia;
				cambioVarible = estudiante[i].mta[j].nom_materia;
				system("cls");
				if(estudiante[i].mta[j].nom_materia>=1 and estudiante[i].mta[j].nom_materia<=10){
					if((cambioVarible != estudiante[i].mta[1].nom_materia) and (cambioVarible != estudiante[i].mta[2].nom_materia)and (cambioVarible != estudiante[i].mta[3].nom_materia)){validacionMateria = false;}
					else if((cambioVarible != estudiante[i].mta[0].nom_materia) and (cambioVarible != estudiante[i].mta[2].nom_materia)and (cambioVarible != estudiante[i].mta[3].nom_materia)){validacionMateria = false;}
					else if((cambioVarible != estudiante[i].mta[0].nom_materia) and (cambioVarible != estudiante[i].mta[1].nom_materia)and (cambioVarible != estudiante[i].mta[3].nom_materia)){validacionMateria = false;}
					else if((cambioVarible != estudiante[i].mta[0].nom_materia) and (cambioVarible != estudiante[i].mta[1].nom_materia)and (cambioVarible != estudiante[i].mta[2].nom_materia)){validacionMateria = false;}
					else{cout<<"La asignatura selecionada ya habia sido elegida previamente, intententelo nuevamente\n";}
			 	}
				else{ cout<<"La opcion selecionada no se encuentra entre las opciones, intentelo nuevamente\n\n";}
		    }
		    
	  		validacionMateria = true;
			cout<<"Ingrese el codigo de la materia\n";
			cin>>estudiante[i].mta[j].codigo;
			cout<<"Ingrese la unidad de credito de la materia\n";
			cin>>estudiante[i].mta[j].unidad_credito;
			cout<<"Ingrese la calificacion para esta materia\n";
			cin>>estudiante[i].mta[j].calificacion;
			system("cls");
		}	
	}
		
}

void Listado_General(alumno estudiante[],int m){
	
	for(int i=0;i<m;i++){
		
		cout<<"Estudiante: "<<estudiante[i].nombre<<endl;
		cout<<"Cedula: "<<estudiante[i].cedula<<endl;
		
		if(estudiante[i].sexo==1){cout<<"Sexo: Masculino\n";}
		else{cout<<"Sexo: Femenino\n";}
		
		cout<<"Edad: "<<estudiante[i].edad<<endl;
		
	    if(estudiante[i].carrera==1){cout<<"Carrera: Desarrollo de software\n";}
		else if(estudiante[i].carrera==2){cout<<"Carrera: Ingenieria industrial\n";}
		else if(estudiante[i].carrera==3){cout<<"Ingenieria de telecomunicaciones\n";}
		else if(estudiante[i].carrera==4){cout<<"Carrera: Gastronomia\n";}
		else if(estudiante[i].carrera==5){cout<<"Carrera: Contabilidad\n";}
		
		if(estudiante[i].semestre==1){cout<<"Cursando: Primer semestre\n";}
		if(estudiante[i].semestre==2){cout<<"Cursando: Segundo semestre\n";}
		if(estudiante[i].semestre==3){cout<<"Cursando: Tercer semestre\n";}
		if(estudiante[i].semestre==4){cout<<"Cursando: Cuarto semestre\n";}
		if(estudiante[i].semestre==5){cout<<"Cursando: Quinto semestre\n";}
		if(estudiante[i].semestre==6){cout<<"Cursando: Sexto semestre\n";}

		cout<<"Calificacion promedio: "<<estudiante[i].calif_promedio<<endl<<endl;	
	}	
}

void Alumnos_Materias(alumno estudiante[],int m){
	
	for(int i=0;i<m;i++){
		
		cout<<"Estudiante: "<<estudiante[i].nombre<<endl;
		
		if(estudiante[i].carrera==1){cout<<"Carrera: Desarrollo de software\n";}
		else if(estudiante[i].carrera==2){cout<<"Carrera: Ingenieria industrial\n";}
		else if(estudiante[i].carrera==3){cout<<"Carrera: Ingenieria de telecomunicaciones\n";}
		else if(estudiante[i].carrera==4){cout<<"Carrera: Gastronomia\n";}
		else if(estudiante[i].carrera==5){cout<<"Carrera: Contabilidad\n";}
		cout<<endl;
		
		cout<<"\tCodigo\t\t\tMateria\t\t\tU. credito\tNota\n"<<endl;
		
		for(int j=0;j<4;j++){
			
			if(estudiante[i].mta[j].nom_materia==1){cout<<"\t "<<estudiante[i].mta[j].codigo<<"\t   Algoritmia y programacion basica"<<"\t     "<<
			estudiante[i].mta[j].unidad_credito<<"\t\t "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
			
			else if(estudiante[i].mta[j].nom_materia==2){cout<<"\t "<<estudiante[i].mta[j].codigo<<"\t   Programacion orientada a objetos"<<"\t     "<<
			estudiante[i].mta[j].unidad_credito<<"\t\t "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
			
			else if(estudiante[i].mta[j].nom_materia==3){cout<<"\t "<<estudiante[i].mta[j].codigo<<"\t          Calculo diferencial      "<<"\t     "<<
			estudiante[i].mta[j].unidad_credito<<"\t\t "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
			
			else if(estudiante[i].mta[j].nom_materia==4){cout<<"\t "<<estudiante[i].mta[j].codigo<<"\t            Calculo integral       "<<"\t     "<<
			estudiante[i].mta[j].unidad_credito<<"\t\t "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
			
			else if(estudiante[i].mta[j].nom_materia==5){cout<<"\t "<<estudiante[i].mta[j].codigo<<"\t          Quimica de alimentos     "<<"\t     "<<
			estudiante[i].mta[j].unidad_credito<<"\t\t "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
			
			else if(estudiante[i].mta[j].nom_materia==6){cout<<"\t "<<estudiante[i].mta[j].codigo<<"\t         Panaderia y pasteleria    "<<"\t     "<<
			estudiante[i].mta[j].unidad_credito<<"\t\t "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
			
			else if(estudiante[i].mta[j].nom_materia==7){cout<<"\t "<<estudiante[i].mta[j].codigo<<"\t             Contabilidad          "<<"\t     "<<
			estudiante[i].mta[j].unidad_credito<<"\t\t "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
			
			else if(estudiante[i].mta[j].nom_materia==8){cout<<"\t "<<estudiante[i].mta[j].codigo<<"\t                Ingles             "<<"\t     "<<
			estudiante[i].mta[j].unidad_credito<<"\t\t "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
			
			else if(estudiante[i].mta[j].nom_materia==9){cout<<"\t "<<estudiante[i].mta[j].codigo<<"\t              Estadistica          "<<"\t     "<<
			estudiante[i].mta[j].unidad_credito<<"\t\t "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
			
			else if(estudiante[i].mta[j].nom_materia==10){cout<<"\t "<<estudiante[i].mta[j].codigo<<"\t                 Costos           "<<"\t     "<<
			estudiante[i].mta[j].unidad_credito<<"\t\t "<<estudiante[i].mta[j].calificacion<<endl<<endl;}		
		}
		cout<<endl; 
	}	
}

void Alumnos_Reprobados(alumno estudiante[],int m){
	
	float promedio=0;
	
	for(int i=0;i<m;i++){
		
		if(estudiante[i].mta[0].calificacion<30||estudiante[i].mta[1].calificacion<30||estudiante[i].mta[2].calificacion<30||estudiante[i].mta[3].calificacion<30){
			
			cout<<"Estudiante: "<<estudiante[i].nombre<<endl;
			cout<<"Cedula: "<<estudiante[i].cedula<<endl;
			
			if(estudiante[i].sexo==1){cout<<"Sexo: Masculino\n";}
			else{cout<<"Sexo: Femenino\n";}
			
			cout<<"Edad: "<<estudiante[i].edad<<endl;
			
		    if(estudiante[i].carrera==1){cout<<"Carrera: Desarrollo de software\n";}
			else if(estudiante[i].carrera==2){cout<<"Carrera: Ingenieria industrial\n";}
			else if(estudiante[i].carrera==3){cout<<"Carrera: Ingenieria de telecomunicaciones\n";}
			else if(estudiante[i].carrera==4){cout<<"Carrera: Gastronomia\n";}
			else if(estudiante[i].carrera==5){cout<<"Carrera: Contabilidad\n";}
			cout<<endl;
			cout<<"ASIGNATURAS REPROBADAS\n"<<endl;
			
			for(int j=0;j<4;j++){
				
				if(estudiante[i].mta[j].calificacion<30){
					
				  if(estudiante[i].mta[j].nom_materia==1){cout<<"Materia:  Algoritmia y programacion basica       Nota:  "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
				  else if(estudiante[i].mta[j].nom_materia==2){cout<<"Materia:  Programacion orientada a objetos       Nota:  "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
				  else if(estudiante[i].mta[j].nom_materia==3){cout<<"Materia:  Calculo diferencial                    Nota:  "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
				  else if(estudiante[i].mta[j].nom_materia==4){cout<<"Materia:  Calculo integral                       Nota:  "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
				  else if(estudiante[i].mta[j].nom_materia==5){cout<<"Materia:  Quimica de alimentos                   Nota:  "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
				  else if(estudiante[i].mta[j].nom_materia==6){cout<<"Materia:  Panaderia y pasteleria                 Nota:  "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
				  else if(estudiante[i].mta[j].nom_materia==7){cout<<"Materia:  Contabilidad                           Nota:  "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
				  else if(estudiante[i].mta[j].nom_materia==8){cout<<"Materia:  Ingles                                 Nota:  "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
				  else if(estudiante[i].mta[j].nom_materia==9){cout<<"Materia:  Estadistica                            Nota:  "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
				  else if(estudiante[i].mta[j].nom_materia==10){cout<<"Materia:  Costos                                 Nota:  "<<estudiante[i].mta[j].calificacion<<endl<<endl;}
				   
				}
				
			}
			
			promedio=((estudiante[i].mta[0].calificacion+estudiante[i].mta[1].calificacion+estudiante[i].mta[2].calificacion+estudiante[i].mta[3].calificacion)/4);
			cout<<"Promedio total de totas las asignaturas del estudiante:  "<<promedio<<endl<<endl;	
	    }
		cout<<endl;			
	}		
}

void Materia_Especifica(alumno estudiante[],int m){
	
	bool validacionMateria2 = true;
	int materia;
	string asignatura, carrera;
	
	while(validacionMateria2 == true){
	
		cout<<"Seleccione la asiganatura que desea buscar teniendo en cuenta lo siguiente:\n"<<endl;
		cout<<" 1 = Algoritmia y programacion basica\n 2 = Programacion orientada a objetos\n 3 = Calculo diferencial\n 4 = Calculo integral\n"<<
			  " 5 = Quimica de alimentos\n 6 = Panaderia y pasteleria\n 7 = Contabilidad\n 8 = Ingles\n 9 = Estadistica\n 10 = Costos\n"<<endl;
		cin>>materia;
		system("cls");
		
		if(materia>=1 and materia<=10){validacionMateria2 = false;}
		else{cout<<"La opcion selecionada no se encuentra entre las opciones, intentelo nuevamente\n\n";}
	}
	validacionMateria2 = true;
	
	if(materia==1){ asignatura="Algoritmia y programacion basica";}
	if(materia==2){ asignatura="Programacion orientada a objetos";}
	if(materia==3){ asignatura="Calculo diferencial";}
	if(materia==4){ asignatura="Calculo integral";}
	if(materia==5){ asignatura="Quimica de alimentos";}
	if(materia==6){ asignatura="Panaderia y pasteleria";}
	if(materia==7){ asignatura="Contabilidad";}
	if(materia==8){ asignatura="Ingles";}
	if(materia==9){ asignatura="Estadistica";}
	if(materia==10){ asignatura="Costos";}
	
	cout<<"Estudiantes que tienen la asignatura "<<asignatura<<" inscrita\n"<<endl;
	
	for(int i=0;i<m;i++){
		for(int j=0;j<4;j++){
		
			if(estudiante[i].mta[j].nom_materia==materia){
		
				cout<<"Estudiante  "<<estudiante[i].nombre<<endl;
				cout<<"Cedula  "<<estudiante[i].cedula<<endl;
				
				if(estudiante[i].carrera==1){cout<<"Carrera:  Desarrollo de software\n";}
				else if(estudiante[i].carrera==2){cout<<"Carrera:  Ingenieria industrial\n";}
				else if(estudiante[i].carrera==3){cout<<"Carrera:  Ingenieria de telecomunicaciones\n";}
				else if(estudiante[i].carrera==4){cout<<"Carrera:  Gastronomia\n";}
				else if(estudiante[i].carrera==5){cout<<"Carrera:  Contabilidad\n";}
				cout<<endl;
			}
		}
	}	
}
