from app import db
from datetime import date
import time

# Tabla Patient
class Patient(db.Model):
    __tablename__ = 'Patient'

    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    name = db.Column(db.String(50))
    lastName = db.Column(db.String(50))  
    identification = db.Column(db.String(20), unique=True)
    birthdate = db.Column(db.Date) 
    age = db.Column(db.String(3))
    genre = db.Column(db.String)
    phone = db.Column(db.String(10), unique=True)
    district = db.Column(db.String(30))
    address = db.Column(db.String(30))   
    bloodType = db.Column(db.String)
    email = db.Column(db.String(100), unique=True)
    password = db.Column(db.String(30))   
    state = db.Column(db.Boolean)

    def __init__(self, name, lastName, identification, birthdate, genre, phone, district, address,  bloodType,  email, password):
        self.name = name
        self.lastName = lastName
        self.identification = identification
        self.birthdate = birthdate
        self.genre = genre
        self.phone = phone
        self.district = district
        self.address = address
        self.bloodType = bloodType
        self.email = email
        self.password = password
        self.age = self.calcularEdad(birthdate)
        self.state = True
     
    def calcularEdad(self, birthdate):
        fecha_String = birthdate.split("-")
        year = int(fecha_String[0]) 
        month = int(fecha_String[1]) 
        day = int(fecha_String[2]) 

        fecha_nacimiento = date(year, month, day)
        fecha_actual = date.today()

        if(fecha_nacimiento.month > fecha_actual.month):
                edad = fecha_actual.year - fecha_nacimiento.year - 1
        elif(fecha_nacimiento.month < fecha_actual.month):
                edad = fecha_actual.year - fecha_nacimiento.year
        elif(fecha_nacimiento.month == fecha_actual.month):
            if(fecha_nacimiento.day > fecha_actual.day):
                edad = fecha_actual.year - fecha_nacimiento.year - 1
            elif(fecha_nacimiento.day <= fecha_actual.day):
                edad = fecha_actual.year - fecha_nacimiento.year

        return str(edad)          


# Tabla Functionary
class Functionary(db.Model):
    __tablename__ = 'Functionary'

    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    identification = db.Column(db.String(20), unique=True)
    email = db.Column(db.String(100), unique=True)
    password = db.Column(db.String(30))
    name = db.Column(db.String(50))
    lastName = db.Column(db.String(50))
    position = db.Column(db.String(25))
    phone = db.Column(db.String(10), unique=True)

    def __init__(self, identification, email, password, name, lastName, position, phone):
        self.identification = identification
        self.email = email
        self.password = password
        self.name = name
        self.lastName = lastName
        self.position = position
        self.phone = phone


# Tabla Medicine
class Medicine(db.Model):
    __tablename__ = 'Medicine'

    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    uniqueCode = db.Column(db.String(30), unique=True)
    name = db.Column(db.String(30))
    supplier = db.Column(db.String(30))
    price = db.Column(db.Float)
    quantity = db.Column(db.Integer)

    def __init__(self, uniqueCode, name, supplier, price):
        self.uniqueCode = uniqueCode
        self.name = name
        self.supplier = supplier
        self.price = price
        self.quantity = 0 #funcion con parametro


# Tabla MedicalAppointmentHistory
class MedicalAppointmentHistory(db.Model):
    __tablename__ = 'MedicalAppointmentHistory'

    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    patient_id = db.Column(db.ForeignKey("Patient.id"))
    functionary_id = db.Column(db.ForeignKey("Functionary.id"))
    requestDate = db.Column(db.Date)
    applicationDate = db.Column(db.Date)
    applicationHour = db.Column(db.Time)
    observation = db.Column(db.String) #Lo ingresa el medico que atiende
    state = db.Column(db.String(10)) #Lo ingresa el medico que atiende

    def __init__(self, patient_id, functionary_id, requestDate, applicationDate, applicationHour):
        self.patient_id = patient_id
        self.functionary_id = functionary_id
        self.requestDate = requestDate
        self.applicationDate = applicationDate
        self.applicationHour = applicationHour

# Tabla MedicineControl
class MedicineControl(db.Model):
    __tablename__ = 'MedicineControl'    

    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    medicine_id = db.Column(db.ForeignKey("Medicine.id", ondelete='cascade', onupdate='cascade'))
    functionary_id = db.Column(db.ForeignKey("Functionary.id"))
    registerType = db.Column(db.String)
    quantity = db.Column(db.Integer)
    date = db.Column(db.Date)
    hour = db.Column(db.Time)

    def __init__(self, medicine_id, functionary_id, registerType, quantity, date, hour):
        self.medicine_id = medicine_id
        self.functionary_id = functionary_id
        self.registerType = registerType
        self.quantity = quantity
        self.date = date
        self.hour = hour
