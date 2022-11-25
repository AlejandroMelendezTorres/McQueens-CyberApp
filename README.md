# Ademanos

**Ademanos es una aplicación que le permite a sus usuarios aprender Lenguaje de Señas Mexicano.**

_TC2007B: Integración de seguridad informática en redes y sistemas de software_
_Equipo: McQueens_

Miguel Arriaga Velasco - A01028570

Francisco José Joven Sánchez - A00830564

Alejandro Melendez Torres - A00832494

Abiel Lozano Herrejón - A01284213

Jacobo Soffer Levy - A01028653

1. [ Video de funcionalidad del sistema ](#vid)
2. [ Descarga Ademanos ](#down)
3. [ Manual de Usuario ](#usermanu)
4. [ Manual de Instalación ](#instmanu)

<a name="vid"></a>

## 1. Video de funcionalidad del sistema

<a name="down"></a>

## 2. Descarga Ademanos

[Descarga Ademanos para Android](https://github.com/AlejandroMelendezTorres/McQueens-CyberApp/releases/tag/v1.0)

[Página Web de Administración](https://github.com/sofferjacob/McQueens-Web)

<a name="usermanu"></a>

## 3. Manual de Usuario

### Android

Para el uso de la aplicación se recomienda utilizar este manual para tener la mejor experiencia utilizando la aplicación.

#### Inicio de sesión

Iniciar sesión en Ademanos, le permite almacenar sus estadísticas al usuario así como a su organización. Sin embargo, no es necesario haber iniciado sesión para tener acceso al diccionario y quizzes de la aplicación.

Para iniciar sesión sesión en Ademanos se deben de seguir los siguientes pasos:

1. Contar con un correo y contraseña de Ademanos, proporcionados por tu organización.
2. Navegar a la pestaña de perfil, tocando el icono de perfil en la barra de navegación de la aplicación.
3. Llenar los campos con el email y contraseña proporcionados por tu organización.
4. Tocar en “iniciar sesión”.
5. Para cerrar sesión, tocar en “cerrar sesión”.

#### Diccionario

Desde esta pantalla, el usuario puede consultar diferentes palabras en lenguaje de señas mexicano. Para utilizarlo adecuadamente, estos son los pasos:

1. Navegar a la pestaña de diccionario, tocando el icono de diccionario en la barra de navegación de la aplicación.
2. Seleccionar la categoría de palabras deseada.
3. Seleccionar la palabra deseada.
4. Visualizar el video o imagen correspondiente.

#### Quizzes

Desde esta pantalla el usuario puede poner a práctica sus conocimientos de LSM, así como aprender a través de preguntas interactivas. Para utilizarlos adecuadamente, estos son los pasos:

1. Navegar a la pestaña de quizzes, tocando el icono de quizzes en la barra de navegación de la aplicación.
2. Seleccionar el quiz que se desea realizar.
3. Visualizar el video o imagen correspondiente y leer la pregunta del quiz.
4. Seleccionar la opción que se considere correcta.
    1. En caso de seleccionar la opción incorrecta.
        1. Se le presentará un mensaje diciendo que la opción no es correcta.
        2. Hacer click en “Intentar de nuevo”
        3. Intentar de nuevo.
    2. En caso de seleccionar la opción correcta.
        4. Se le presentará un mensaje diciendo que la opción es correcta.
        5. Hacer click en “Continuar”
        6. Continuar con la siguiente pregunta del quiz.
5. Al terminar de contestar todas las preguntas correctamente, se le presentará un mensaje diciendo que el quiz ha sido terminado.

#### Estadísticas

Desde esta pantalla, el usuario puede visualizar sus estadísticas en caso de haber iniciado sesión. Para utilizarla, los pasos son:

1. Navegar a la pestaña de perfil, tocando el icono de perfil en la barra de navegación de la aplicación.
2. En caso de no tener una sesión iniciada, iniciar sesión.
3. Visualizar el número de palabras consultadas y quizzes completados.

### Página web

Para el uso de la aplicación se recomienda utilizar este manual para tener la mejor experiencia utilizando la aplicación.

#### Inicio de sesión

Lo primero que se tiene que hacer al ingresar a la página web es iniciar sesión con credenciales de administrador. Una vez dentro de la página web se pueden crear más usuarios administradores, pero para la primera vez que se ingrese, se les otorgará un correo y contraseña con las credenciales necesarias.

#### Usuarios

Para crear usuarios de Ademanos, ya sea administradores o para el uso de la aplicación Android, los pasos que se deben de seguir son los siguientes:

1. Navegar a la pestaña “Crear Usuarios” utilizando la barra de navegación superior.
2. Seleccionar si se quiere añadir un solo usuario o múltiples usuarios, a través de los botones en la esquina superior izquierda.
    1. En caso de seleccionar un solo usuario
        1. Indicar nombre, email y contraseña del usuario.
        2. Seleccionar si el usuario va o no a ser administrador.
        3. Hacer click en “crear usuario”.
    2. En caso de seleccionar múltiples usuarios
        4. Construir un archivo .csv basándose en el ejemplo proporcionado en la página web (en el hipervínculo “ejemplo”).
        5. Hacer click en “seleccionar archivo” y seleccionar el archivo con los usuarios de su computadora.
        6. Seleccionar si los usuarios van o no a ser administradores.
        7. Hacer click en “crear usuarios”.

#### Visualizar estadísticas

Para visualizar las estadísticas generales de los usuarios de Ademanos, los pasos que se deben de seguir son los siguientes:

1. Navegar a la pestaña “Estadísticas” utilizando la barra de navegación superior.
2. Visualizar gráficas y tablas con las estadísticas generales de los usuarios.

Para visualizar las estadísticas individuales de los usuarios de Ademanos:

1. Navegar a la pestaña “Usuarios” utilizando la barra de navegación superior.
2. Seleccionar el usuario deseado.
3. Visualizar gráficas y tablas.

<a name="instmanu"></a>

## 4. Manual de Instalación

### Android

Para instalar la aplicación se requiere tener un dispositivo que esté corriendo Android (versión android tiramisú o más reciente), además se requiere tener el APK de la aplicación en el dispositivo. Teniendo el APK en el dispositivo tendrás que correr el APK para que se realice la instalación a tu dispositivo, cuando corras la aplicación por primera vez te pedirá que le des permiso para acceso al internet, este permiso se debe otorgar.

Para instalar el APK se deben de seguir los siguientes pasos:

1. Abra la aplicación del explorador de archivos de su dispositivo Android.
2. Localice su archivo APK en su aplicación de explorador de archivos y selecciónelo.
3. Aparecerá el menú del instalador de APK: seleccionar “Instalar”. 
4. Deje tiempo para que la aplicación se instale.
5. Toque “Listo” o “Abrir” una vez que se complete la instalación.

### Base de datos

La base de datos está hospedada en Firebase y no es necesario realizar ninguna instalación. Esta ya se encuentra integrada en las interfaces gráficas desarrolladas.

### Página web

La página web de administración está hospedada en Vercel en la siguiente liga: [https://mc-queens-web.vercel.app/](https://mc-queens-web.vercel.app/). Para acceder a ella solo es necesario hacer click en la liga.

Adicionalmente, si se quisiera descargar la aplicación web y correrla de manera local para hacer cambios o actualizaciones, estos son los pasos que se deben de seguir:

1. Descargar Node.js en tu computadora desde la siguiente liga: [https://nodejs.org/en/](https://nodejs.org/en/) 
2. Acceder al repositorio web de la aplicación en la siguiente liga: [https://github.com/sofferjacob/McQueens-Web](https://github.com/sofferjacob/McQueens-Web)
3. Clonar el repositorio en tu computadora local, haciendo click en el el botón verde que dice “code” y seleccionando la opción de descarga deseada.
4. Navegar a la carpeta local en donde se clonó el proyecto.
5. Desde la terminal, dentro de la carpeta del proyecto, correr los siguientes comandos:
    1. _npm install_
    2. _npm run build_
6. Esto correrá la página web de manera local en tu computadora, en el puerto _localhost _que se indicará en la terminal después de correr los comandos.


