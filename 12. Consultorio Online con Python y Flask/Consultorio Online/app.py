from flask import Flask, request, render_template, redirect, url_for
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import or_, and_
from datetime import date
import time

app = Flask(__name__)
# 'postgresql://<usuario>:<contraseña>@<direccion de la db>:<puerto>/<nombre de la db>
app.config['SQLALCHEMY_DATABASE_URI'] = 'postgresql://postgres:root@localhost:5432/consultorionline'
#base de datos en heroku
#app.config['SQLALCHEMY_DATABASE_URI'] = 'postgresql://eagmwdhdcsejuj:e5e637b464c34058e57f956ea81b03a99e2da2c3ccf91a190398dedea04c3d0d@ec2-3-209-65-193.compute-1.amazonaws.com:5432/d9f84tefsoiohq'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
app.secret_key = 'some-secret-key'

db = SQLAlchemy(app)

# Importar los modelos
from models import Patient, Functionary, Medicine, MedicalAppointmentHistory, FormulatedMedicine, MedicineControl

# Crear el esquema de la DB
db.create_all()
db.session.commit()

#Pagina principal seleccion de usuario
@app.route('/')
def index():
    return render_template("index.html")


#Ruta de ingreso a la plataforma con correo y contraseña del paciente
@app.route('/pacientesignup')
def pacientesignup():
    return render_template("signUpPaciente.html")

#Ruta de ingreso a la plataforma con correo y contraseña del funcionario
@app.route('/funcionariosignup')
def funcionariosignup():
    return render_template("signUpFuncionario.html")


@app.route('/ingresousuariopaciente', methods=['POST'])
def ingresousuariopaciente():  
    email = request.form['email']
    password = request.form['key']
   
    usuariodb = Patient.query.filter_by(email=email).first()
    #passworddb = Patient.query.filter_by(password=password).first()

    if((usuariodb is not None) and (email == usuariodb.email) and (password == usuariodb.password)): 
        return redirect(url_for("interfazpaciente", id = usuariodb.id))
    else:
        return "Error usuario o contraseña no validos"


@app.route('/ingresousuariofuncionario', methods=['POST'])
def ingresousuariofuncionario():  
    email = request.form['email']
    password = request.form['key']
   
    usuariodb = Functionary.query.filter_by(email=email).first() 

    if((usuariodb is not None) and (email == usuariodb.email) and (password == usuariodb.password)): 
        return redirect(url_for("interfazfuncionario", id = usuariodb.id))
    else:
        return "Error usuario o contraseña no validos"


#Interfaz grafica del usuario paciente
@app.route('/interfazpaciente/<id>')
def interfazpaciente(id):
    patient = Patient.query.filter_by(id=id).first()

    return render_template("interfazPaciente.html", patient = patient)

#Interfaz grafica del usuario funcionario
@app.route('/interfazfuncionario/<id>')
def interfazfuncionario(id):
    functionary = Functionary.query.filter_by(id=id).first()

    return render_template("interfazFuncionario.html", functionary = functionary)


#Ruta de regitro de pacientes nuevos
@app.route('/registropacientes')
def registropacientes():

    return render_template("registroPacientes.html")


@app.route('/crear_registropacientes', methods=['POST'])
def crear_registropacientes():
    name = request.form['name']
    lastName = request.form['lastName']
    identification = request.form['identification']
    birthdate = request.form['birthdate']

    genre = ""
    if(request.form["genre"] == 'masculino'):
        genre = "Masculino"
    elif(request.form["genre"] == 'femenino'):
        genre = "Femenino"
    elif(request.form["genre"] == 'otro'):
        genre = "Otro"

    phone = request.form['phone']
    district = request.form['district']
    address = request.form['address']

    bloodType = ""
    if(request.form["bloodType"] == '1'):
        bloodType = "O-"
    elif(request.form["bloodType"] == '2'):
        bloodType = "O+"
    elif(request.form["bloodType"] == '3'):
        bloodType = "A-"
    elif(request.form["bloodType"] == '4'):
        bloodType = "A+"
    elif(request.form["bloodType"] == '5'):
        bloodType = "B-"
    elif(request.form["bloodType"] == '6'):
        bloodType = "B+"
    elif(request.form["bloodType"] == '7'):
        bloodType = "AB-"
    elif(request.form["bloodType"] == '8'):
        bloodType = "AB+"

    email = request.form['email']
    password = request.form['password']
 
    # Objeto de tipo Patient
    patient = Patient(name, lastName, identification, birthdate, genre, phone, district, address, bloodType, email, password)
    db.session.add(patient)
    db.session.commit()

    return redirect(url_for("pacientesignup")) 


@app.route('/perfilpaciente/<id>')
def perfilpaciente(id): 
    patient = Patient.query.filter_by(id=id).first()
    
    return render_template("perfilPaciente.html", patient = patient) 


@app.route('/actualizarperfilpaciente/<id>')
def actualizarperfilpaciente(id): 
    patient = Patient.query.filter_by(id=id).first()
    
    return render_template("actualizarPerfilPaciente.html", patient = patient) 


@app.route('/guardar_actualizacionperfilpaciente/<id>', methods=['POST'])
def guardar_actualizacionperfilpaciente(id): 
    id = int(id)
    patient = Patient.query.filter_by(id=id).first()

    name = request.form['name']
    lastName = request.form['lastName']
    identification = request.form['identification']
    birthdate = request.form['birthdate']

    genre = ""
    if(request.form["genre"] == 'masculino'):
        genre = "Masculino"
    elif(request.form["genre"] == 'femenino'):
        genre = "Femenino"
    elif(request.form["genre"] == 'otro'):
        genre = "Otro"

    phone = request.form['phone']
    district = request.form['district']
    address = request.form['address']

    bloodType = ""
    if(request.form["bloodType"] == '1'):
        bloodType = "O-"
    elif(request.form["bloodType"] == '2'):
        bloodType = "O+"
    elif(request.form["bloodType"] == '3'):
        bloodType = "A-"
    elif(request.form["bloodType"] == '4'):
        bloodType = "A+"
    elif(request.form["bloodType"] == '5'):
        bloodType = "B-"
    elif(request.form["bloodType"] == '6'):
        bloodType = "B+"
    elif(request.form["bloodType"] == '7'):
        bloodType = "AB-"
    elif(request.form["bloodType"] == '8'):
        bloodType = "AB+"

    email = request.form['email']
    password = request.form['password']

    patient.name = name
    patient.lastName = lastName
    patient.identification = identification
    patient.birthdate = birthdate
    patient.genre = genre
    patient.phone = phone
    patient.district = district
    patient.address = address
    patient.bloodType = bloodType
    patient.email = email
    patient.password  = password 

    #Para actulizar la edad se hace un objeto para que se pueda acceder a la funcion calcularEdad
    objetoPaciente = Patient(name, lastName, identification, birthdate, genre, phone, district, address, bloodType, email, password)
    patient.age = objetoPaciente.age

    db.session.commit()

    return redirect(url_for("perfilpaciente", id = patient.id))

    
@app.route('/registrocitasmedicas/<id>')
def registrocitasmedicas(id):
    patient = Patient.query.filter_by(id=id).first()
    functionary = Functionary.query.all()
    return render_template("registroCitasMedicas.html", id = id, patient = patient, functionary = functionary)


@app.route('/crear_registrocitasmedicas/<id>', methods=['POST'])
def crear_registrocitasmedicas(id):
    patient = Patient.query.filter_by(id=id).first()

    functionary = request.form['medico']
    functionary = int(functionary)
    functionary2 = Functionary.query.filter_by(id=functionary).first()
    
    if(patient is not None):
        if(functionary2 is not None and functionary == functionary2.id):
            patient_id = patient.id
            functionary_id = functionary2.id

            requestDate = date.today()

            applicationDate = request.form['applicationDate']
            applicationHour = request.form['applicationHour']

            medicalaAppointment = MedicalAppointmentHistory(patient_id, functionary_id, requestDate, applicationDate, applicationHour)

            db.session.add(medicalaAppointment)
            db.session.commit()

            return redirect(url_for("registrocitasmedicas", id = patient.id)) 
        else: 
            return redirect(url_for("registrocitasmedicas", id = patient.id)) 
    else:
        return redirect(url_for("registrocitasmedicas", id = patient.id))


@app.route('/citasmedicasreservadas/<id>')
def citasmedicasreservadas(id): 
    patient = Patient.query.filter_by(id=id).first()
    MedicalAppointment = MedicalAppointmentHistory.query.filter_by(patient_id=id, state = None).all()

    doctorsList = []
    for i in MedicalAppointment:
        doctor =  Functionary.query.filter_by(id=i.functionary_id).first()
        doctorsList.append(doctor.name + " " + doctor.lastName)

    for i, j in zip(MedicalAppointment, doctorsList):
        i.functionary_id = j

    return render_template("citasMedicasReservadas.html", MedicalAppointment = MedicalAppointment, patient = patient) 


@app.route('/editarcitamedica/<appointment_id>/<patient_id>')
def editarcitamedica(appointment_id, patient_id): 
    patient = Patient.query.filter_by(id=patient_id).first()
    medicalAppointment = MedicalAppointmentHistory.query.filter_by(id=appointment_id).first()
    functionary = Functionary.query.all()

    return render_template("editarCitaMedica.html", appointment = medicalAppointment, patient = patient, functionary = functionary)


@app.route('/guardar_editarcitamedica/<id>', methods=['POST'])
def guardar_editarcitamedica(id): 
    medicalAppointment = MedicalAppointmentHistory.query.filter_by(id=id).first()
    patient = Patient.query.filter_by(id=medicalAppointment.patient_id).first()

    functionary = request.form['medico']
    functionary = int(functionary)
    functionary2 = Functionary.query.filter_by(id=functionary).first()
    
    if(medicalAppointment is not None):
        if(functionary2 is not None):
            functionary_id = functionary2.id
            requestDate = date.today()
            applicationDate = request.form['applicationDate']
            applicationHour = request.form['applicationHour']
 
            medicalAppointment.functionary_id = functionary_id 
            medicalAppointment.requestDate  = requestDate
            medicalAppointment.applicationDate = applicationDate
            medicalAppointment.applicationHour = applicationHour

            db.session.commit()

            return redirect(url_for("citasmedicasreservadas", id = patient.id)) 
        else: 
            return redirect(url_for("citasmedicasreservadas", id = patient.id)) 
    else:
        return redirect(url_for("citasmedicasreservadas", id = patient.id))


@app.route('/eliminarcitamedica/<id>')
def eliminarcitamedica(id): 
    medicalAppointment = MedicalAppointmentHistory.query.filter_by(id=id).first() 
    patient = Patient.query.filter_by(id=medicalAppointment.patient_id).first()

    db.session.delete(medicalAppointment)
    db.session.commit()

    return redirect(url_for("citasmedicasreservadas", id = patient.id)) 


@app.route('/historialcitasmedicas/<id>')
def historialcitasmedicas(id): 
    patient = Patient.query.filter_by(id=id).first()
    #MedicalAppointment = MedicalAppointmentHistory.query.filter_by(patient_id=id, state="Asistio" ).all()
    MedicalAppointment = MedicalAppointmentHistory.query.filter(or_(MedicalAppointmentHistory.state == 'Asistio', MedicalAppointmentHistory.state == 'No Asistio'))

    id = int(id)
    appointments = []
    doctorsList = []
    for i in MedicalAppointment:
        if(i.patient_id == id):
            appointments.append(i)
            doctor =  Functionary.query.filter_by(id=i.functionary_id).first()
            doctorsList.append(doctor.name + " " + doctor.lastName)

    for i, j in zip(appointments, doctorsList):
        i.functionary_id = j 

    return render_template("historialCitasMedicas.html", MedicalAppointment = appointments, patient = patient)










'''
A partir de este punto, las siguiente rutas estan funcionales para ingresar valores a las diferentes tablas creadas 
en la base de datos, pero son rutas que no estan funcionales en la interfaz gráfica y tampoco tienen un menú de 
desplazamiento para navegar entre páginas. 

'''


#Ruta de regitro de funcionarios nuevos
@app.route('/registrofuncionarios')
def registrofuncionarios():
    return render_template("registroFuncionarios.html")


@app.route('/crear_registrofuncionarios', methods=['POST'])
def crear_registrofuncionarios():
        identification = request.form['identification']
        email = request.form['email']
        password = request.form['password']
        name = request.form['name']
        lastName = request.form['lastName']
        position = request.form['position']
        phone = request.form['phone']

        functionary = Functionary(identification, email, password, name, lastName, position, phone)
        db.session.add(functionary)
        db.session.commit()

        return 'Registro de funcionario exitoso'


#Ruta de registro de medicamentos nuevos
@app.route('/registromedicamentos')
def registromedicamentos():
    return render_template("registroMedicamentos.html")


@app.route('/crear_registromedicamentos', methods=['POST'])
def crear_registromedicamentos():
    uniqueCode = request.form['uniqueCode']
    name = request.form['name']
    supplier = request.form['supplier']
    price = request.form['price']

    medicine = Medicine(uniqueCode, name, supplier, price)

    db.session.add(medicine)
    db.session.commit()

    return 'Registro del medicamento exitoso'


#Ruta donde el medico ingresa si el paciente asistio o no a la cita medica y da una valoracion del paciente
@app.route('/valoracioncitamedica')
def valoracioncitamedica():
    return render_template("valoracionCitaMedica.html")


@app.route('/crear_valoracioncitamedica', methods=['POST'])
def crear_valoracioncitamedica():
    id_medicalAppointment = int(request.form['id'])
    medicalAppointment = MedicalAppointmentHistory.query.filter_by(id=id_medicalAppointment).first()

    if(medicalAppointment is not None and id_medicalAppointment == medicalAppointment.id):

            registerType = ""
            if(request.form["registerType"] == '1'):
                registerType  = "Asistio"
                medicalAppointment.state = registerType
            elif(request.form["registerType"] == '2'):
                registerType  = "No Asistio"
                medicalAppointment.state = registerType

            observation = request.form['observation']
            medicalAppointment.observation= observation

            db.session.commit()

            return 'Registro de la valoración de cita médica exitoso'
    else:  
        return 'Error datos no válidos'  


#Ruta para alamacenar los medicamentos que un paciente adquiere
@app.route('/registroformulacionmedicinas')
def registroformulacionmedicinas():
    return render_template("registroFormulacionMedicinas.html")


@app.route('/crear_registroformulacionmedicinas', methods=['POST'])
def crear_registroformulacionmedicinas():
    patient = request.form['documento']
    patient2 = Patient.query.filter_by(identification=patient).first()

    medicine = request.form['codigoMedicina']
    medicine2 = Medicine.query.filter_by(uniqueCode=medicine).first()

    if(patient2 is not None and patient == patient2.identification):
        if(medicine2 is not None and medicine == medicine2.uniqueCode):
            patient_id = patient2.id
            medicine_id = medicine2.id

            formulatedMedicine = FormulatedMedicine(patient_id, medicine_id)

            db.session.add(formulatedMedicine)
            db.session.commit()

            return 'Registro formulación de medicina exitoso'
        else:  
            return 'Error datos no válidos'  
    else:  
      return 'Error datos no válidos' 


#Ruta para mantener el control del inventario de las medicinas que entran y salen 
@app.route('/registrocontrolmedicinas')
def registrocontrolmedicinas():
    return render_template("registroControlMedicinas.html")


@app.route('/crear_registrocontrolmedicinas', methods=['POST'])
def crear_registrocontrolmedicinas():
    medicine = request.form['codigoMedicina']
    medicine2 = Medicine.query.filter_by(uniqueCode=medicine).first()

    functionary = request.form['identificacion']
    functionary2 = Functionary.query.filter_by(identification=functionary).first()

    if(medicine2 is not None and medicine == medicine2.uniqueCode):
        if(functionary2 is not None and functionary == functionary2.identification):  
            medicine_id = medicine2.id
            functionary_id = functionary2.id

            quantity = request.form["quantity"]  

            registerType = ""
            if(request.form["registerType"] == '1'):
                registerType  = "Entrada"
                medicine2.quantity += int(quantity)

            elif(request.form["registerType"] == '2'):
                registerType  = "Salida"
                medicine2.quantity -= int(quantity)
 
            registerDate = date.today()
            hour = time.strftime("%H:%M:%S")

            medicineControl = MedicineControl(medicine_id, functionary_id, registerType, quantity, registerDate, hour)

            db.session.add(medicineControl)
            db.session.commit()

            return 'Registro formulación de medicina exitoso'
        else:  
            return 'Error datos no válidos'  
    else:  
      return 'Error datos no válidos' 


if __name__ == "__main__":
    app.run()