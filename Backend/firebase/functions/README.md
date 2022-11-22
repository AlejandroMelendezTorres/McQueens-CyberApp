# functions
Contiene la implementación de las Firebase Functions usadas por la aplicación.
Para usar todas las funciones un usuario con privilegios de administrador debe estar autenticado.

## `/createUser`
Crea un usuario (normal o administrador).
Metodo: `POST`
Parametros del body:
```
{
    "admin": Booleano; especifica si el usuario a crearse tendrá privilegios de administrador,
    "user": {
        "username": String; nombre de usuario,
        "email": String; correo electrónico,
        "password": String; contraseña,
    },
    "users": User[]; se usa cuando se quieren crear multiples usuarios. Mismos atributos que el
    objeto usuario.
}
```

Respuesta:
````
{
    "result": {
        "status: "ok"
    }
}
```

## `/queryStats`
Se usa para obtener estadísticas de la base de datos.
Metodo: `POST`

Ver más información en `src/stat/index.ts`

Ejemplo de solicitud:
```
{
    "data": {
       "measures": [
           {
               "field": "correct",
               "op": "count"
           }
       ],
       "dimensions": ["quizName"],
       "collection": "events",
       "filter": {
           "a": "type",
           "op": "==",
           "b": "quizStarted"
       },
       "groupBy": "timestamp"
    }
}
```

Ejemplo de respuesta:
```
{
    "result": {
        "status": "ok",
        "data": {
            'Fri Nov 18 2022': {
              'Quizz Lugares': { count: 2 },
              'Quizz Cuerpo': { count: 1 },
              'Quizz Verduras': { count: 3 },
              'Quizz DiasDeLaSemana': { count: 1 },
              'Quizz Hogar': { count: 4 },
              'Quizz Colores': { count: 1 },
              'Quizz Frutas': { count: 1 },
              'Quizz Preguntas': { count: 1 }
            },
            'Tue Nov 22 2022': { 'Quizz Hogar': { count: 2 } }
          }
    }
}
```