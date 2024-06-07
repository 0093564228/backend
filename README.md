
<h1 align="center"> jwt-spring-boot-3.3.0 </h1>
Proyecto básico para la implementación de Autenticación y Autorización con Spring Boot + Spring Security + JWT + MySql

## Acceso Base Datos
* Recuerde crear su base de datos antes de ejecutar el proyecto y actualizar el nombre de la misma en el archivo **configuration.properties**. 
* El proyecto esta configurado para conectarse a una base de datos MYSQL pero puede cambiar en el **configuration.properties** las propiedades de conexión que se ajusten a su base de datos. 

## Tablas

Al ejecutar el proyecto por primera vez se crearan una tabla en la base de datos
* user - En esta tabla el sistema guardara el nuevo usuario con una referencia al ROL al que pertenece el usuario. 

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

* POST http://127.0.0.1:8080/api/v1/demo ruta para probar acceso con jwt(colocar Authorization - Bearer "token" en cabecera) 


* POST http://127.0.0.1:8080/api/maestro
* POST http://127.0.0.1:8080/api/carrera
* POST http://127.0.0.1:8080/api/grupo
* etc...



## Observaciones

* FUNCIONALIDAD EXTRA = calculo de carga horaria

  * por ejemplo -> si un docente pasa clases martes y jueves entonces asiste 8 veces al mes a una materia en un grupo en un aula en un horario de inicio y fin
  * 8 x 2hrs = 16hrs al mes, su carga horaria mensual es de 16hrs.
  
  * Realizar un programa que me permita calcular la carga horaria acumulada por el horario que se le asigna a un docente
  * 
   
