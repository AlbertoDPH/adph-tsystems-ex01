## adph-tsystems-ex01
# EX01-Prueba técnica

La aplicación esta basada en **Spring Boot**, y muestran sistema de gestión de videojuegos, partidas, mensajes perfiles de usuario y usuarios. 

Contiene el paquete principal **com.delpozo** en el cual encontramos los paquetes correspondientes, para la creación de una API.

**controller en el encontramos las entidades encargadas de controlar cada una de las funciones, las cuales hace que podamos hacer operaciones **CRUP** en cada entidad

Los controladores:
**MensajeController**
Gestiona la entidad Mensaje que representa los mensajes enviados por los usuarios en una partida, los mensajes tienen contenido, fecha y hora, remitente
y partida a la que pertenecen.
**PartidaController**
Gestiona la entidad Partida que representa partidas de un videojuego en particular
**PerfilUsuarioController**
Gestiona la entidad PerfilUsuario, que representa perfiles de los usuarios en la aplicación. Los perfiles tienen un nombre de jugador y una relación con la entidad Usuario.
**UsuarioController**
Gestiona la entidad Usuario, que representa usuarios registrados en la aplicación. Los usuarios tienen un nombre de usuario, correo electrónico y contraseña.
**VideoJuegoConroller**
Gestiona la entidad VideoJuego, que representa los videojuegos disponibles en la aplicación. Los videojuegos tienen un nombre, género y una lista de partidas relacionadas.
  
**dao** en este paquete pondremos todo lo relacionado a la lógica de la BBDD, las interfaces de este paquete serán Interfaces que heredarán todas las funciones de JpaRepository
de esta forma podremos realizar todas las operaciones **CRUD** de una forma sencilla y sin tener que escribir código **JDBC**.

Los interfaces dao:
o **IMensajeDAO**
Controla las operaciones de la base de datos para la entidad Mensaje.
**IPartidaDAO**
Controla las operaciones de la base de datos para la entidad Partida
**IPerfilUsuarioDAO**
Controla las operaciones de la base de datos para la entidad PerfilUsuario
**IUsuarioDAO**
Controla las operaciones de la base de datos para la entidad Usuario
**IVideoJuegoDAO**
Controla las operaciones de la base de datos para la entidad PerfilUsuario.

Las rutas de la API siguen un patrón similar en cada controlador
GET /api/entidad: 		    Lista todas las instancias de la entidad.
POST /api/entidad: 		    Crea una nueva instancia de la entidad.
GET /api/entidad/{id}: 		Obtiene una instancia específica de la entidad por su ID.
PUT /api/entidad/{id}: 		Actualiza una instancia específica de la entidad por su ID.
DELETE /api/entidad/{id}: 	Elimina una instancia específica de la entidad por su ID.
  
**dto** en este paquete encontraremos todas las entidades que usa la app, en la cual se definen los atributos que tiene cada una de ellas y se crean objetos para poderlos instanciar a en las clases que se necesiten. Esto nos permite separar los datos de la lógica y de esta forma mejora el mantenimiento del sistema.
Las entidades dto: 
**Mensaje**
Sus atributos incluyen id, contenido y fecha_hora. Tiene una relación de muchos a uno con Usuario (remitente) y Partida. 
**Partida**
Sus atributos incluyen id, y tiene una relación de muchos a uno con VideoJuego. Además, tiene una relación de muchos a muchos con Usuario y una relación de uno a muchos con Mensaje. 
**PerfilUsuario**
Sus atributos incluyen id y nombre_jugador. Tiene una relación uno a uno con Usuario.
**Usuario**
Sus atributos incluyen id, nombre_usuario, email y password. Tiene una relación uno a uno con PerfilUsuario y una relación de muchos a muchos con Partida.
**VideoJuego**
Sus atributos incluyen id, nombre y género. Tiene una relación de uno a muchos con Partida.

service:
la usaremos para separar las distintas funcionalidades de la app. En ella encontraremos una intefice encarga de declarar las funciones para listar, guardar(CREATE), leer por ID(READ), actualizar(UPDATE) y eliminar(DELETE) un CRUD completo.
Estas funciones se desarrollarán en el mismo paquete, en clases diferentes y estarán preparadas para ser llamadas los controladores con la anotación @Autowired

Las interfaces service:
**ImensajeService**
**IpartidaService**
**IperfilUsuarioService**
**IusuarioService**
**IvideoJuegoService**

  Las entidades service:
**MensajeService**
**PartidaService**
**PerfilUsuarioService**
**UsuarioService**
**VideoJuegoService**
  
Además, en el mismo paquete principal **com.delpozo** deben estar la clase principal del proyecto en este caso: Ex01PruebaTecnicaApplication y la clase ServletInitializer utiliza en aplicaciones Spring Boot para el inicio de la app.

En el paquete data.sql, encontraremos applicatiom.properties que contiene la información de la app, como la conexión con la pagina web y en este mismo paquete contendrá el fichero de BBDD data.sql ya que como motor de BBDD se ha usado H2

En la raíz principal del proyecto, tenemos el fichero pom.xml en el cual se encuentran toda la configuración de Maven que se utilizara para gestionar las dependencias que hayan sido seleccionadas para la creación del proyecto.

El Módelo ER y Módelo Relacional se encuentra el fichero **EX01_PruebaTecnica.jpg**  adjuntado en este repositorio.








  



  
  
