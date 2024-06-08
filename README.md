
<h1 align="center"> jwt-spring-boot-3.3.0 </h1>
Proyecto básico para la implementación de Autenticación y Autorización con Spring Boot + Spring Security + JWT + MySql.
 PROYECTO->REGISTRO ASISTENCIA DOCENTE - UAGRM

## Acceso Base Datos
* Crear su base de datos antes de ejecutar el proyecto y actualizar el nombre de la misma en el archivo **configuration.properties**. 
* El proyecto esta configurado para conectarse a una base de datos MYSQL pero puede cambiar en el **configuration.properties** las propiedades de conexión que se ajusten a su base de datos. 

## Tablas

Al ejecutar el proyecto por primera vez se crearan tablas en la base de datos
 

## Rutas Sin Proteccion
* Las unicas rutas sin protección:


* POST http://localhost:8080/auth/register

* **JSON ENTRADA**
```json
{
  "username":"alejo",
  "lastname":"lopez",
  "firstname":"abel",
  "country":"sc",
  "password":"1234"
}
```

* POST http://localhost:8080/auth/login  
  **Cada vez que se ejecute el método login se genera un token que tendrá una validez de 1 dia**
* **JSON ENTRADA**
```json
{
  "username":"alejo",
  "password":"1234"
}
```
* **JSON SALIDA**
```json
{
    "token": "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbmlzdHJhZG9yIiwiZXhwIjoxNjc1NTcwOTkzfQ.TdjXBEVgSxsPvScrQwhs3Fuwj-bTo_KO3LYckXJ0Fsoi_rDfA9KHPf9w0wdFEA7a"
}
```

## EndPoint o URL
* NOTA FECHA 08/06/24:
* El token generado es un JWT que se debe enviar en la cabecera de las peticiones que requieran autenticación.
  Pero esta deshabilitado el filtro de seguridad por lo que no es necesario enviar el token en la cabecera para probar las rutas protegidas.

* POST http://127.0.0.1:8080/api/v1/demo ruta para probar acceso con jwt(colocar Authorization - Bearer "token" en cabecera) 

*ACCESO A RUTAS PROTEGIDAS* 
* GET http://127.0.0.1:8080/api/materias
* GET http://127.0.0.1:8080/api/carreras
* GET http://127.0.0.1:8080/api/grupos
* GET http://127.0.0.1:8080/api/facultades
* GET http://127.0.0.1:8080/api/aulas
* GET http://127.0.0.1:8080/api/programacion



## CRUD materias 


* POST http://127.0.0.1:8080/api/materias/create
* **JSON ENTRADA**
```json
{
  "nombre":"fisica2",
  "sigla":"fis200",
  "carrera":
  {
    "id":"1"
  }
}
```
* **JSON SALIDA**
```json
{
  "id": 1,
  "nombre": "fisica2",
  "sigla": "fis200",
  "programaciones": null
}
```
* PUT http://127.0.0.1:8080/api/materias/update/1 
* **JSON ENTRADA**
```json
{
  "nombre":"ensamblador"
}
```
* **JSON SALIDA**
```json
{
  "id": 1,
  "nombre": "ensamblador",
  "sigla": "fis200",
  "programaciones": []
}
```
* DELETE http://127.0.0.1:8080/api/materias/1
* GET http://127.0.0.1:8080/api/materias/1
* **JSON SALIDA**
```json
{
  "id": 1,
  "nombre": "fisica2",
  "sigla": "fis200",
  "programaciones": []
}
```
* GET http://127.0.0.1:8080/api/materias
* **JSON SALIDA**
```json
[
  {
    "id": 1,
    "nombre": "fisica2",
    "sigla": "fis200",
    "programaciones": []
  },
  {
    "id": 2,
    "nombre": "fisica2",
    "sigla": "fis200",
    "programaciones": []
  },
  {
    "id": 3,
    "nombre": "ingles1",
    "sigla": "ling100",
    "programaciones": []
  },
  {
    "id": 4,
    "nombre": "program1",
    "sigla": "inf110",
    "programaciones": []
  }
]
```
POSIBLE PROBLEMA: serialización de objetos que pueden tener referencias cíclicas o recursivas.
## Observaciones

* FUNCIONALIDAD EXTRA = calculo de carga horaria

  * por ejemplo -> si un docente pasa clases martes y jueves entonces asiste 8 veces al mes a una materia en un grupo en un aula en un horario de inicio y fin
  * 8 x 2hrs = 16hrs al mes, su carga horaria mensual es de 16hrs.
  
  * Realizar un programa que me permita calcular la carga horaria acumulada por el horario que se le asigna a un docente
  * 
   
