from flask import Flask, request, render_template, redirect, url_for
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import or_, and_
from datetime import date
import time

app = Flask(__name__)
# 'postgresql://<usuario>:<contraseña>@<direccion de la db>:<puerto>/<nombre de la db>
app.config['SQLALCHEMY_DATABASE_URI'] = 'postgresql://postgres:root@localhost:5432/consultoriomedico'
#base de datos en heroku
#app.config['SQLALCHEMY_DATABASE_URI'] = 'postgresql://fikotavwnpadwn:73e8a36d01c1c54bfafd28aa6154f051a029dee13f48760935b284769dd8df0d@ec2-3-221-140-141.compute-1.amazonaws.com:5432/dc6kidufoa4g8r'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
app.secret_key = 'some-secret-key'

db = SQLAlchemy(app)

# Importar los modelos
from models import Patient, Functionary, Medicine, MedicalAppointmentHistory, MedicineControl

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

#Ruta de salida de la aplicación de los usuarios
@app.route('/usuariologout')
def usuariologout():
    return redirect(url_for("index"))



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




# Rutas en la interfaz del rol de funcionario o médico

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


@app.route('/perfilfuncionario/<id>')
def perfilfuncionario(id): 
    functionary = Functionary.query.filter_by(id=id).first()
    
    return render_template("perfilFuncionario.html", functionary = functionary)


@app.route('/actualizarperfilfuncionario/<id>')
def actualizarperfilfuncionario(id): 
    functionary = Functionary.query.filter_by(id=id).first()
    
    return render_template("actualizarPerfilFuncionario.html", functionary = functionary) 


@app.route('/guardar_actualizacionperfilFuncionario/<id>', methods=['POST'])
def guardar_actualizacionperfilFuncionario(id): 
    id = int(id)
    functionary = Functionary.query.filter_by(id=id).first()

    
    email = request.form['email']
    password = request.form['password']
    identification = request.form['identification']
    name = request.form['name']
    lastName = request.form['lastName']
    position = request.form['position']
    phone = request.form['phone']

    functionary.email = email
    functionary.password = password
    functionary.identification = identification
    functionary.name = name
    functionary.lastName = lastName
    functionary.position = position
    functionary.phone  = phone 

    db.session.commit()

    return redirect(url_for("perfilfuncionario", id = functionary.id))


@app.route('/citasmedicasprogramadas/<id>')
def citasmedicasprogramadas(id): 
    functionary = Functionary.query.filter_by(id=id).first()
    MedicalAppointment = MedicalAppointmentHistory.query.filter_by(functionary_id=id, state = None).all()

    patientList = []
    for i in MedicalAppointment:
        patient =  Patient.query.filter_by(id=i.patient_id).first()
        patientList.append(patient.name + " " + patient.lastName)

    for i, j in zip(MedicalAppointment, patientList):
        i.patient_id = j 

    return render_template("citasMedicasProgramadas.html", MedicalAppointment = MedicalAppointment, functionary = functionary) 


@app.route('/valoracioncitamedica/<appointment_id>/<functionary_id>')
def valoracioncitamedica(appointment_id, functionary_id): 
    functionary = Functionary.query.filter_by(id=functionary_id).first()
    medicalAppointment = MedicalAppointmentHistory.query.filter_by(id=appointment_id).first()

    return render_template("valoracioncitaMedica.html", medicalAppointment = medicalAppointment, functionary = functionary) 


@app.route('/guardar_valoracioncitamedica/<medicalAppointment_id>/<functionary_id>', methods=['POST'])
def guardar_valoracioncitamedica(medicalAppointment_id, functionary_id): 
    functionary = Functionary.query.filter_by(id=functionary_id).first()
    medicalAppointment = MedicalAppointmentHistory.query.filter_by(id=medicalAppointment_id).first()

    registerType = request.form['registerType']
    observation = request.form['observation']

    medicalAppointment.state = registerType
    medicalAppointment.observation = observation

    db.session.commit()

    return redirect(url_for("historialcitasmedicasrealizadas", id = functionary.id))


@app.route('/historialcitasmedicasrealizadas/<id>')
def historialcitasmedicasrealizadas(id): 
    functionary = Functionary.query.filter_by(id=id).first()
    #MedicalAppointment = MedicalAppointmentHistory.query.filter_by(patient_id=id, state="Asistio" ).all()
    MedicalAppointment = MedicalAppointmentHistory.query.filter(or_(MedicalAppointmentHistory.state == 'Asistio', MedicalAppointmentHistory.state == 'No Asistio'))

    id = int(id)
    appointments = []
    patientList = []
    for i in MedicalAppointment:
        if(i.functionary_id == id):
            appointments.append(i)
            patient =  Patient.query.filter_by(id=i.patient_id).first()
            patientList.append(patient.name + " " + patient.lastName)

    for i, j in zip(appointments, patientList):
        i.patient_id = j 

    return render_template("historialCitasMedicasRealizadas.html", MedicalAppointment = appointments, functionary = functionary)


#Ruta de registro de medicamentos nuevos
@app.route('/registromedicamentos/<id>')
def registromedicamentos(id):
    functionary = Functionary.query.filter_by(id=id).first()

    return render_template("registroMedicamentos.html", functionary = functionary)


@app.route('/crear_registromedicamentos/<functionary_id>', methods=['POST'])
def crear_registromedicamentos(functionary_id):
    functionary = Functionary.query.filter_by(id=functionary_id).first()

    uniqueCode = request.form['uniqueCode']
    name = request.form['name']
    supplier = request.form['supplier']
    price = request.form['price']

    medicine = Medicine(uniqueCode, name, supplier, price)
    db.session.add(medicine)
    db.session.commit()

    return redirect(url_for("registromedicamentos", id = functionary.id))


@app.route('/medicamentosalmacenados/<id>')
def medicamentosalmacenados(id): 
    functionary = Functionary.query.filter_by(id=id).first()
    medicines = Medicine.query.all()

    return render_template("medicamentosAlmacenados.html", medicines = medicines, functionary = functionary) 


@app.route('/editarmedicamento/<medicine_id>/<functionary_id>')
def editarmedicamento(medicine_id, functionary_id): 
    medicine = Medicine.query.filter_by(id=medicine_id).first()
    functionary = Functionary.query.filter_by(id=functionary_id).first()

    return render_template("editarMedicamento.html", medicine = medicine, functionary = functionary)


@app.route('/guardar_editarmedicamento/<medicine_id>/<functionary_id>', methods=['POST'])
def guardar_editarmedicamento(medicine_id, functionary_id): 
    medicine = Medicine.query.filter_by(id=medicine_id).first()
    functionary = Functionary.query.filter_by(id=functionary_id).first()
    
    if(medicine is not None):
        if(functionary is not None):

            uniqueCode = request.form['uniqueCode']
            name = request.form['name']
            supplier = request.form['supplier']
            price = request.form['price']
 
            medicine.uniqueCode  = uniqueCode
            medicine.name  = name
            medicine.supplier= supplier
            medicine.price  = price

            db.session.commit()

            return redirect(url_for("medicamentosalmacenados", id = functionary.id)) 
        else: 
            return redirect(url_for("medicamentosalmacenados", id = functionary.id)) 
    else:
        return redirect(url_for("medicamentosalmacenados", id = functionary.id))


@app.route('/eliminarmedicamento/<medicine_id>/<functionary_id>')
def eliminarmedicamento(medicine_id, functionary_id): 
    medicine = Medicine.query.filter_by(id=medicine_id).first()
    functionary = Functionary.query.filter_by(id=functionary_id).first()
    
    db.session.delete(medicine)
    db.session.commit()

    return redirect(url_for("medicamentosalmacenados", id = functionary.id))


#Ruta para mantener el control del inventario de las medicinas que entran y salen 
@app.route('/registrocontrolmedicinas/<id>')
def registrocontrolmedicinas(id):
    functionary = Functionary.query.filter_by(id=id).first()

    return render_template("registroControlMedicinas.html", functionary = functionary)


@app.route('/crear_registrocontrolmedicinas/<functionary_id>', methods=['POST'])
def crear_registrocontrolmedicinas(functionary_id):
    functionary = Functionary.query.filter_by(id=functionary_id).first()

    medicine = request.form['codigoMedicina']
    medicine2 = Medicine.query.filter_by(uniqueCode=medicine).first()

    if(medicine2 is not None and medicine == medicine2.uniqueCode): 
            medicine_id = medicine2.id
            functionary_id = functionary.id

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

            return redirect(url_for("registrocontrolmedicinas", id = functionary.id))
    else:  
      return redirect(url_for("registrocontrolmedicinas", id = functionary.id))



if __name__ == "__main__":
    app.run()