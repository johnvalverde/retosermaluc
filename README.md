# retosermaluc

1. Clonar el proyecto:

git clone https://github.com/johnvalverde/retosermaluc
cd retosermaluc

2. Maven:

mvn clean install

3. Ejecutar

mvn spring-boot:run

4. Servicios: usar el postman adjunto

- Crear Usuario: registra el usuario validando que el correo sea valido y no se repita, y que la contraseña tenga almenos un numero
  y devuelve los datos registrados y un token de sesion.
- Login: logeo usando el correo como username
- Listar Usuarios: listado de usuario registrados, requiere token
