/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Alohandes Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.alohandes.interfazApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.alohandes.negocio.Alohandes;
import uniandes.isis2304.alohandes.negocio.Operador;
import uniandes.isis2304.alohandes.negocio.Propuesta;
import uniandes.isis2304.alohandes.negocio.Usuario;
import uniandes.isis2304.alohandes.negocio.Reserva;
import uniandes.isis2304.alohandes.negocio.VOAlojamiento;
import uniandes.isis2304.alohandes.negocio.VOOperador;
import uniandes.isis2304.alohandes.negocio.VOPropuesta;
import uniandes.isis2304.alohandes.negocio.VOReserva;
import uniandes.isis2304.alohandes.negocio.VOServicio;
import uniandes.isis2304.alohandes.negocio.VOUsuario;
/**
 * Clase principal de la interfaz
 * @author Germán Bravo
 */
@SuppressWarnings("serial")

public class InterfazAlohandesApp extends JFrame implements ActionListener
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazAlohandesApp.class.getName());
	

	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp.json"; 
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;
    
    /**
     * Asociación a la clase principal del negocio.
     */
    private Alohandes alohandes;
    
	/* ****************************************************************
	 * 			Atributos de interfaz
	 *****************************************************************/
    /**
     * Objeto JSON con la configuración de interfaz de la app.
     */
    private JsonObject guiConfig;
    
    /**
     * Panel de despliegue de interacción para los requerimientos
     */
    private PanelDatos panelDatos;
    
    /**
     * Menú de la aplicación
     */
    private JMenuBar menuBar;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
    /**
     * Construye la ventana principal de la aplicación. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
    public InterfazAlohandesApp( )
    {
        // Carga la configuración de la interfaz desde un archivo JSON
        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ);
        
        // Configura la apariencia del frame que contiene la interfaz gráfica
        configurarFrame ( );
        if (guiConfig != null) 	   
        {
     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }
        
        tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
        alohandes = new Alohandes (tableConfig);
        
    	String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos ( );

        setLayout (new BorderLayout());
        add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
        add( panelDatos, BorderLayout.CENTER );        
    }
    
	/* ****************************************************************
	 * 			Métodos de configuración de la interfaz
	 *****************************************************************/
    /**
     * Lee datos de configuración para la aplicació, a partir de un archivo JSON o con valores por defecto si hay errores.
     * @param tipo - El tipo de configuración deseada
     * @param archConfig - Archivo Json que contiene la configuración
     * @return Un objeto JSON con la configuración del tipo especificado
     * 			NULL si hay un error en el archivo.
     */
    private JsonObject openConfig (String tipo, String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Alohandes App", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }
    
    /**
     * Método para configurar el frame principal de la aplicación
     */
    private void configurarFrame(  )
    {
    	int alto = 0;
    	int ancho = 0;
    	String titulo = "";	
    	
    	if ( guiConfig == null )
    	{
    		log.info ( "Se aplica configuración por defecto" );			
			titulo = "Alohandes APP Default";
			alto = 300;
			ancho = 500;
    	}
    	else
    	{
			log.info ( "Se aplica configuración indicada en el archivo de configuración" );
    		titulo = guiConfig.get("title").getAsString();
			alto= guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
    	}
    	
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocation (50,50);
        setResizable( true );
        setBackground( Color.WHITE );

        setTitle( titulo );
		setSize ( ancho, alto);        
    }

    /**
     * Método para crear el menú de la aplicación con base em el objeto JSON leído
     * Genera una barra de menú y los menús con sus respectivas opciones
     * @param jsonMenu - Arreglo Json con los menùs deseados
     */
    private void crearMenu(  JsonArray jsonMenu )
    {    	
    	// Creación de la barra de menús
        menuBar = new JMenuBar();       
        for (JsonElement men : jsonMenu)
        {
        	// Creación de cada uno de los menús
        	JsonObject jom = men.getAsJsonObject(); 

        	String menuTitle = jom.get("menuTitle").getAsString();        	
        	JsonArray opciones = jom.getAsJsonArray("options");
        	
        	JMenu menu = new JMenu( menuTitle);
        	
        	for (JsonElement op : opciones)
        	{       	
        		// Creación de cada una de las opciones del menú
        		JsonObject jo = op.getAsJsonObject(); 
        		String lb =   jo.get("label").getAsString();
        		String event = jo.get("event").getAsString();
        		
        		JMenuItem mItem = new JMenuItem( lb );
        		mItem.addActionListener( this );
        		mItem.setActionCommand(event);
        		
        		menu.add(mItem);
        	}       
        	menuBar.add( menu );
        }        
        setJMenuBar ( menuBar );	
    }
    /* ****************************************************************
	 * 			Métodos Requerimientos Funcionales
	 *****************************************************************/
	public void RF1 (){
		// Registrar Operadores

		try {
	        String idOperadorStr = JOptionPane.showInputDialog(this, "ID del Operador:",
	                "Registrar Operador", JOptionPane.QUESTION_MESSAGE);
	        long idOperador = Long.parseLong(idOperadorStr);
	        String nombre = JOptionPane.showInputDialog(this, "Nombre:",
	                "Registrar Operador", JOptionPane.QUESTION_MESSAGE);
	        
	        String codigoCamaraComercio = JOptionPane.showInputDialog(this, "Código Cámara de Comercio:",
	                "Registrar Operador", JOptionPane.QUESTION_MESSAGE);
	        String registroSuperintendencia = JOptionPane.showInputDialog(this, "Registro Superintendencia:",
	                "Registrar Operador", JOptionPane.QUESTION_MESSAGE);

	        String resultado = "En registrar operador\n\n";
	        Operador operador = alohandes.adicionarOperadorHotel(idOperador, nombre, codigoCamaraComercio, registroSuperintendencia);
	        
	        if (operador != null) {
	            resultado += "Operador Hotel registrado con éxito: " + operador;
	        } else {
	            resultado += "No se pudo registrar el Operador Hotel.";
	        }
	        
	        resultado += "\n Operación terminada";
	        panelDatos.actualizarInterfaz(resultado);

	    } catch (NumberFormatException e) {
	        String resultado = "Error: El ID del Operador debe ser un número entero.";
	        panelDatos.actualizarInterfaz(resultado);
	    } catch (Exception e) {
	        String resultado = generarMensajeError(e);
	        panelDatos.actualizarInterfaz(resultado);
	    }
	}
	public void RF2() {
		// Registrar Propuestas
		// se necesita: long id, String titulo, String descripcion, long idAlojamiento
		try {
			// Pedimos la informacion por medio de dialogos
			String idPropuestaStr = JOptionPane.showInputDialog(this, "ID de la propuesta:",
			"Registrar Propuesta", JOptionPane.QUESTION_MESSAGE);

			long idPropuesta = Long.parseLong(idPropuestaStr);

			String titulo = JOptionPane.showInputDialog(this, "Titulo de la propuesta:",
			"Registrar Propuesta", JOptionPane.QUESTION_MESSAGE);

			String descripcion = JOptionPane.showInputDialog(this, "Descripcion de la propuesta:",
			"Registrar Propuesta", JOptionPane.QUESTION_MESSAGE);

			String idAlojamientoStr = JOptionPane.showInputDialog(this, "ID del Alojamiento:",
			"Registrar Propuesta", JOptionPane.QUESTION_MESSAGE);

			long idAlojamiento = Long.parseLong(idAlojamientoStr);

			// Mandamos a registrar la propuesta a la capa de negocio:
			String resultado = "En registrar Propuesta\n\n";

			Propuesta propuesta = alohandes.adicionarPropuesta(idPropuesta, titulo, descripcion, idAlojamiento);

			// Revisamos que se haya creado correctamente:
			if (propuesta != null) {
	            resultado += "Propuesta registrada con éxito: " + propuesta;
	        } else {
	            resultado += "No se pudo registrar la propuesta.";
	        }
	        
	        resultado += "\n Operación terminada";
	        panelDatos.actualizarInterfaz(resultado);

	    } catch (NumberFormatException e) {
	        String resultado = "Error: El ID de la propuesta o el del Alojamiento deben ser un número entero.";
	        panelDatos.actualizarInterfaz(resultado);
	    } catch (Exception e) {
	        String resultado = generarMensajeError(e);
	        panelDatos.actualizarInterfaz(resultado);
	    }
	}

	public void RF3 (){
		// Registrar Usuarios
		try {
	        String idUsuarioStr = JOptionPane.showInputDialog(this, "ID del Usuario:",
	                "Registrar Usuario", JOptionPane.QUESTION_MESSAGE);
	        int idUsuario = Integer.parseInt(idUsuarioStr);
	        String nombre = JOptionPane.showInputDialog(this, "Nombre:",
	                "Registrar Usuario", JOptionPane.QUESTION_MESSAGE);
	        String apellido = JOptionPane.showInputDialog(this, "Apellido:",
	                "Registrar Usuario", JOptionPane.QUESTION_MESSAGE);
	        String correoElectronico = JOptionPane.showInputDialog(this, "Correo Electrónico:",
	                "Registrar Usuario", JOptionPane.QUESTION_MESSAGE);
	        String telefonoStr = JOptionPane.showInputDialog(this, "Teléfono:",
	                "Registrar Usuario", JOptionPane.QUESTION_MESSAGE);
	        int telefono = Integer.parseInt(telefonoStr);
	        String tipo = JOptionPane.showInputDialog(this, "Tipo:",
	                "Registrar Usuario", JOptionPane.QUESTION_MESSAGE);

	        String resultado = "En registrar usuario\n\n";
	        Usuario usuario = alohandes.adicionarUsuario(idUsuario, nombre, apellido, correoElectronico, telefono, tipo);

	        if (usuario != null) {
	            resultado += "Usuario registrado con éxito: " + usuario;
	        } else {
	            resultado += "No se pudo registrar el Usuario.";
	        }

	        resultado += "\n Operación terminada";
	        panelDatos.actualizarInterfaz(resultado);

	    } catch (NumberFormatException e) {
	        String resultado = "Error: El ID del Usuario y el Teléfono deben ser números enteros.";
	        panelDatos.actualizarInterfaz(resultado);
	    } catch (Exception e) {
	        String resultado = generarMensajeError(e);
	        panelDatos.actualizarInterfaz(resultado);
	    }
	}
	public void RF4() {
		// Registrar Reservas
		try {
			// Pedimos la información por medio de diálogos
			String idReservaStr = JOptionPane.showInputDialog(this, "ID de la reserva:",
			"Registrar Reserva", JOptionPane.QUESTION_MESSAGE);
			long idReserva = Long.parseLong(idReservaStr);
	
			String userIdStr = JOptionPane.showInputDialog(this, "ID del usuario:",
			"Registrar Reserva", JOptionPane.QUESTION_MESSAGE);
			long userId = Long.parseLong(userIdStr);
	
			String alojamientoIdStr = JOptionPane.showInputDialog(this, "ID del alojamiento:",
			"Registrar Reserva", JOptionPane.QUESTION_MESSAGE);
			long alojamientoId = Long.parseLong(alojamientoIdStr);
	
			String fechaInicialStr = JOptionPane.showInputDialog(this, "Fecha inicial (YYYY-MM-DD HH:MM:SS):",
			"Registrar Reserva", JOptionPane.QUESTION_MESSAGE);
			Timestamp fechaInicial = Timestamp.valueOf(fechaInicialStr);
	
			String fechaFinalStr = JOptionPane.showInputDialog(this, "Fecha final (YYYY-MM-DD HH:MM:SS):",
			"Registrar Reserva", JOptionPane.QUESTION_MESSAGE);
			Timestamp fechaFinal = Timestamp.valueOf(fechaFinalStr);
	
			String costoStr = JOptionPane.showInputDialog(this, "Costo de la reserva:",
			"Registrar Reserva", JOptionPane.QUESTION_MESSAGE);
			int costo = Integer.parseInt(costoStr);
	
			// Mandamos a registrar la reserva a la capa de negocio:
			String resultado = "En registrar Reserva\n\n";
	
			Reserva reserva = alohandes.adicionarReserva(idReserva, userId, alojamientoId, fechaInicial, fechaFinal, costo);
	
			// Revisamos que se haya creado correctamente:
			if (reserva != null) {
				resultado += "Reserva registrada con éxito: " + reserva;
			} else {
				resultado += "No se pudo registrar la reserva.";
			}
	
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
	
		} catch (NumberFormatException e) {
			String resultado = "Error: El ID de la reserva, el ID del usuario, el ID del alojamiento o el costo deben ser números enteros.";
			panelDatos.actualizarInterfaz(resultado);
		} catch (IllegalArgumentException e) {
			String resultado = "Error: El formato de fecha es incorrecto, por favor utilice el formato 'YYYY-MM-DD HH:MM:SS'.";
			panelDatos.actualizarInterfaz(resultado);
		} catch (Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	
	public void RF5() {
		// Eliminar Reserva
		try {
			// Pedimos la información por medio de diálogos
			String idReservaStr = JOptionPane.showInputDialog(this, "ID de la reserva a eliminar:",
			"Eliminar Reserva", JOptionPane.QUESTION_MESSAGE);
			long idReserva = Long.parseLong(idReservaStr);
	
			// Mandamos a eliminar la reserva a la capa de negocio:
			String resultado = "En eliminar Reserva\n\n";
	
			long resp = alohandes.eliminarReservaPorId(idReserva);
	
			// Revisamos que se haya eliminado correctamente:
			if (resp != -1) {
				resultado += "Reserva eliminada con éxito. " + resp + " tuplas eliminadas.";
			} else {
				resultado += "No se pudo eliminar la reserva.";
			}
	
			resultado += "\n Operación terminada";
			panelDatos.actualizarInterfaz(resultado);
	
		} catch (NumberFormatException e) {
			String resultado = "Error: El ID de la reserva debe ser un número entero.";
			panelDatos.actualizarInterfaz(resultado);
		} catch (Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	
	public void RF6 (){
		// Metodo para retirar una oferta de alojamiento
		try {
			String idPropuestaStr = JOptionPane.showInputDialog(null, "Ingrese el ID de la propuesta de alojamiento que desea eliminar:", "Eliminar propuesta", JOptionPane.PLAIN_MESSAGE);
			int idPropuesta = Integer.parseInt(idPropuestaStr);
			String resultado = "En registrar usuario\n\n";
			Long propuesta  = alohandes.eliminarPropuestaPorId(idPropuesta);
			// Verificamos que si se borro
			if (propuesta >0 ) {
	            resultado += "Propuesta eliminada con exito";
	        } else {
	            resultado += "No se puedo eliminar la Propuesta con el id:" + idPropuesta;
	        }
			// Terminamos de mandar la informacion del cierre de la operacion
	        resultado += "\n Operación terminada";
	        panelDatos.actualizarInterfaz(resultado);

		} catch (NumberFormatException e) {
			// Error en el to int
			String resultado = "Error: El ID de la propuesta no es valido";
			panelDatos.actualizarInterfaz(resultado);
		} catch (Exception e) {
			// Excepcion en el borrado de la propuesta
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
		}



	// ToDo
	public boolean verificarUsuario(){
	 boolean resp = false;

	 return resp;
	}
	
	
	/* ****************************************************************
	 * 			Métodos administrativos
	 *****************************************************************/
	/**
	 * Muestra el log de Alohandes
	 */

	public void cargarBasedeDatos(){
		// no esta completo
		alohandes.cargarBasedeDatos();
	}
	public void mostrarLogAlohandes ()
	{
		mostrarArchivo ("alohandes.log");
	}
	
	/**
	 * Muestra el log de datanucleus
	 */
	public void mostrarLogDatanuecleus ()
	{
		mostrarArchivo ("datanucleus.log");
	}
	
	/**
	 * Limpia el contenido del log de alohandes
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogAlohandes ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("alohandes.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de alohandes ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia el contenido del log de datanucleus
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogDatanucleus ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("datanucleus.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de datanucleus ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia todas las tuplas de todas las tablas de la base de datos de alohandes
	 * Muestra en el panel de datos el número de tuplas eliminadas de cada tabla
	 */
	public void limpiarBD ()
	{
		try 
		{
    		// Ejecución de la demo y recolección de los resultados
			long eliminados [] = alohandes.limpiarAlohandes();
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "\n\n************ Limpiando la base de datos ************ \n";
			resultado += eliminados [0] + " Operadores eliminados\n";
			resultado += eliminados [1] + " Alojamientos eliminados\n";
			resultado += eliminados [2] + " Usuarios eliminados\n";
			resultado += eliminados [3] + " Propuestas eliminadas\n";
			resultado += eliminados [4] + " Reservas eliminados\n";
			resultado += eliminados [5] + " Servicios eliminados\n";
			resultado += "\nLimpieza terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	
	/**
	 * Muestra la presentación general del proyecto
	 */
	public void mostrarPresentacionGeneral ()
	{
		mostrarArchivo ("data/00-ST-AlohandesJDO.pdf");
	}
	
	/**
	 * Muestra el modelo conceptual de Alohandes
	 */
	public void mostrarModeloConceptual ()
	{
		mostrarArchivo ("data/Modelo Conceptual Alohandes.pdf");
	}
	
	/**
	 * Muestra el esquema de la base de datos de Alohandes
	 */
	public void mostrarEsquemaBD ()
	{
		mostrarArchivo ("data/Esquema BD Alohandes.pdf");
	}
	
	/**
	 * Muestra el script de creación de la base de datos
	 */
	public void mostrarScriptBD ()
	{
		mostrarArchivo ("data/EsquemaAlohandes.sql");
	}
	
	/**
	 * Muestra la arquitectura de referencia para Alohandes
	 */
	public void mostrarArqRef ()
	{
		mostrarArchivo ("data/ArquitecturaReferencia.pdf");
	}
	
	/**
	 * Muestra la documentación Javadoc del proyectp
	 */
	public void mostrarJavadoc ()
	{
		mostrarArchivo ("doc/index.html");
	}
	
	/**
     * Muestra la información acerca del desarrollo de esta apicación
     */
    public void acercaDe ()
    {
		String resultado = "\n\n ************************************\n\n";
		resultado += " * Universidad	de	los	Andes	(Bogotá	- Colombia)\n";
		resultado += " * Departamento	de	Ingeniería	de	Sistemas	y	Computación\n";
		resultado += " * Licenciado	bajo	el	esquema	Academic Free License versión 2.1\n";
		resultado += " * \n";		
		resultado += " * Curso: isis2304 - Sistemas Transaccionales\n";
		resultado += " * Proyecto: Alohandes Uniandes\n";
		resultado += " * @version 1.0\n";
		resultado += " * @author Germán Bravo\n";
		resultado += " * Julio de 2018\n";
		resultado += " * \n";
		resultado += " * Revisado por: Claudia Jiménez, Christian Ariza\n";
		resultado += "\n ************************************\n\n";

		panelDatos.actualizarInterfaz(resultado);		
    }
    

	/* ****************************************************************
	 * 			Métodos privados para la presentación de resultados y otras operaciones
	 *****************************************************************/
    /**

    /**
     * Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
     * @param e - La excepción recibida
     * @return La descripción de la excepción, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
     */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}

	/**
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicación
	 * @param e - La excepción generada
	 * @return La cadena con la información de la excepción y detalles adicionales
	 */
	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y alohandes.log para más detalles";
		return resultado;
	}

	/**
	 * Limpia el contenido de un archivo dado su nombre
	 * @param nombreArchivo - El nombre del archivo que se quiere borrar
	 * @return true si se pudo limpiar
	 */
	private boolean limpiarArchivo(String nombreArchivo) 
	{
		BufferedWriter bw;
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File (nombreArchivo)));
			bw.write ("");
			bw.close ();
			return true;
		} 
		catch (IOException e) 
		{
//			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Abre el archivo dado como parámetro con la aplicación por defecto del sistema
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 */
	private void mostrarArchivo (String nombreArchivo)
	{
		try
		{
			Desktop.getDesktop().open(new File(nombreArchivo));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* ****************************************************************
	 * 			Métodos de la Interacción
	 *****************************************************************/
    /**
     * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
     * Invoca al método correspondiente según el evento recibido
     * @param pEvento - El evento del usuario
     */
    @Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = InterfazAlohandesApp.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
	}
    
	/* ****************************************************************
	 * 			Programa principal
	 *****************************************************************/
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Arreglo de argumentos que se recibe por línea de comandos
     */
    public static void main( String[] args )
    {
        try
        {
        	
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            InterfazAlohandesApp interfaz = new InterfazAlohandesApp( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
