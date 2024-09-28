
# Reto Sermaluc

Proyecto de autenticación utilizando Java 21, Spring Boot, Spring Web, Spring Security, MyBatis y H2 (base de datos embebida).



## API Reference

#### CREATE USER:

```http
  POST /api/reto/user/v1.0.0/createUser
```

##### body:
```
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `string` | Nombre del usuario |
| `email` | `string` | Correo del usuario (Irrepetible y con formato de correo. ex: usuario@gmail.com) |
| `password` | `string` | Contraseña del usuario (Debe contener almenos 1 numero) |
| `phones` | `array` |Lista de teléfonos |
| `number` | `string` | Número de teléfono |
| `citycode` | `string` | Código de la ciudad del teléfono |
| `contrycode` | `string` | Código del pais del teléfono |

#### LOGIN

```http
  POST /api/reto/auth/v1.0.0/login
```

##### body:
```
{
    "username": "juan@rodriguez.org",
    "password": "hunter2"
}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username`      | `string` | Correo con el que se registro el usuario|
| `password`      | `string` | Contraseña del usuario |

#### LIST USERS

```http
  GET /api/reto/user/v1.0.0/listUsers
```

## Deployment

Clonar el proyecto

```
  git clone https://github.com/johnvalverde/retosermaluc.git
```

Entra en el directorio del proyecto:

```
  cd retosermaluc
```

Compila y ejecuta la aplicación:

```
  mvn spring-boot:run
```
Abre el navegador y ve a http://localhost:8080/h2-console para acceder a la consola de H2.