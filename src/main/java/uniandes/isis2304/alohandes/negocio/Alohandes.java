package uniandes.isis2304.alohandes.negocio;

 import java.sql.Timestamp;
 import java.util.LinkedList;
 import java.util.List;
 
 import org.apache.log4j.Logger;
 import com.google.gson.JsonObject;
 import uniandes.isis2304.alohandes.persistencia.PersistenciaAlohandes;
 
public class Alohandes {
     private static Logger log = Logger.getLogger(Alohandes.class.getName());
     
     private PersistenciaAlohandes pp;

     public Alohandes ()
     {
         pp = PersistenciaAlohandes.getInstance ();
     }
     
     public Alohandes (JsonObject tableConfig)
     {
         pp = PersistenciaAlohandes.getInstance (tableConfig);
     }
     
     public void cerrarUnidadPersistencia ()
     {
         pp.cerrarUnidadPersistencia ();
     }
     
     public boolean cargarBasedeDatos(){
        // Todavia no esta implementada
        return false;
     }
     public Usuario adicionarUsuario (String nombre, String apellido, String correoElectronico, int telefono, String tipo)
     {
         log.info ("Adicionando Usuario con nombre, apellido, correo, telefono y tupo: " + nombre + "," + apellido + "," + correoElectronico + "," + telefono + "," + tipo);
         Usuario usuario = pp.adicionarUsuario(nombre, apellido, correoElectronico, telefono, tipo);		
         log.info ("Adicionando Usuario: " + usuario);
         return usuario;
     }

     public Usuario adicionarUsuario (int idUsuario, String nombre, String apellido, String correoElectronico, int telefono, String tipo)
     {
         log.info ("Adicionando Usuario con nombre, apellido, correo, telefono y tupo: "+ idUsuario+"," + nombre + "," + apellido + "," + correoElectronico + "," + telefono + "," + tipo);
         Usuario usuario = pp.adicionarUsuario(idUsuario, nombre, apellido, correoElectronico, telefono, tipo);		
         log.info ("Adicionando Usuario: " + usuario);
         return usuario;
     }
     
     public long eliminarUsuarioPorId (long idUsuario)
     {
         log.info ("Eliminando usuario con id: " + idUsuario);
         long resp = pp.eliminarUsuarioPorId (idUsuario);		
         log.info ("Eliminando usuarios: " + resp + " tuplas eliminadas");
         return resp;
     }

     public List<Usuario> darUsuarios ()
     {
         log.info ("Consultando Usuarios");
         List<Usuario> usuarios = pp.darUsuarios();	
         log.info ("Consultando usuarios: " + usuarios.size() + " existentes");
         return usuarios;
     }

     public List<VOUsuario> darVOTUsuarios ()
     {
         log.info ("Generando los VO de los Usuarios");        
         List<VOUsuario> voUsuarios = new LinkedList<VOUsuario>();
         for (Usuario usuario : pp.darUsuarios())
         {
             voUsuarios.add (usuario);
         }
         log.info ("Generando los VO de los usuarios: " + voUsuarios.size() + " existentes");
         return voUsuarios;
     }
     public long actualizarNombreUsuario(long idUsuario, String nuevoNombre) {
        log.info("Actualizando nombre de usuario con id: " + idUsuario + " a " + nuevoNombre);
        long resp = pp.actualizarNombreUsuario(idUsuario, nuevoNombre);
        log.info("Actualizando nombre de usuario: " + resp + " tuplas actualizadas");
        return resp;
    }
    
    public long actualizarApellidoUsuario(long idUsuario, String nuevoApellido) {
        log.info("Actualizando apellido de usuario con id: " + idUsuario + " a " + nuevoApellido);
        long resp = pp.actualizarApellidoUsuario(idUsuario, nuevoApellido);
        log.info("Actualizando apellido de usuario: " + resp + " tuplas actualizadas");
        return resp;
    }
    
    public long actualizarCorreoElectronicoUsuario(long idUsuario, String nuevoCorreoElectronico) {
        log.info("Actualizando correo electrónico de usuario con id: " + idUsuario + " a " + nuevoCorreoElectronico);
        long resp = pp.actualizarCorreoElectronicoUsuario(idUsuario, nuevoCorreoElectronico);
        log.info("Actualizando correo electrónico de usuario: " + resp + " tuplas actualizadas");
        return resp;
    }
    
    public long actualizarTelefonoUsuario(long idUsuario, int nuevoTelefono) {
        log.info("Actualizando teléfono de usuario con id: " + idUsuario + " a " + nuevoTelefono);
        long resp = pp.actualizarTelefonoUsuario(idUsuario, nuevoTelefono);
        log.info("Actualizando teléfono de usuario: " + resp + " tuplas actualizadas");
        return resp;
    }
    
    public long actualizarTipoUsuario(long idUsuario, String nuevoTipo) {
        log.info("Actualizando tipo de usuario con id: " + idUsuario + " a " + nuevoTipo);
        long resp = pp.actualizarTipoUsuario(idUsuario, nuevoTipo);
        log.info("Actualizando tipo de usuario: " + resp + " tuplas actualizadas");
        return resp;
    }
    
    public Operador adicionarOperadorHotel(long idOperador, String nombre, String codigoCamaraComercio, String registroSuperintendencia) {
        log.info("Adicionando Operador Hotel con id: " + idOperador);
        Operador resp = pp.adicionarOperadorHotel(idOperador, nombre, codigoCamaraComercio, registroSuperintendencia);
        log.info("Adicionado Operador Hotel: " + resp);
        return resp;
    }
    
    public Operador adicionarOperadorHostal(long idOperador, String nombre, String codigoCamaraComercio, String registroSuperintendencia) {
        log.info("Adicionando Operador Hostal con id: " + idOperador);
        Operador resp = pp.adicionarOperadorHostal(idOperador, nombre, codigoCamaraComercio, registroSuperintendencia);
        log.info("Adicionado Operador Hostal: " + resp);
        return resp;
    }
    
    public Operador adicionarOperadorAloha(long idOperador, String nombre, String cedula) {
        log.info("Adicionando Operador Aloha con id: " + idOperador);
        Operador resp = pp.adicionarOperadorAloha(idOperador, nombre, cedula);
        log.info("Adicionado Operador Aloha: " + resp);
        return resp;
    }
    
    public long eliminarOperadorPorId(long idOperador) {
        log.info("Eliminando Operador con id: " + idOperador);
        long resp = pp.eliminarOperadorPorId(idOperador);
        log.info("Eliminado Operador: " + resp + " tuplas eliminadas");
        return resp;
    }
    
    public Reserva adicionarReserva(long id, long userId, long alojamientoId, Timestamp fechaInicial, Timestamp fechaFinal, int costo) {
        log.info("Adicionando Reserva con id: " + id);
        Reserva resp = pp.adicionarReserva(id, userId, alojamientoId, fechaInicial, fechaFinal, costo);
        log.info("Adicionada Reserva: " + resp);
        return resp;
    }
    
    public long eliminarReservaPorId(long id) {
        log.info("Eliminando Reserva con id: " + id);
        long resp = pp.eliminarReservaPorId(id);
        log.info("Eliminada Reserva: " + resp + " tuplas eliminadas");
        return resp;
    }
    
    public List<Reserva> darReservas() {
        log.info("Consultando Reservas");
        List<Reserva> resp = pp.darReservas();
        log.info("Consultadas Reservas");
        return resp;
    }
    
    public List<Propuesta> darPropuestas() {
        log.info("Consultando Propuestas");
        List<Propuesta> resp = pp.darPropuestas();
        log.info("Consultadas Propuestas");
        return resp;
    }
    
    public Propuesta adicionarPropuesta(long id, String titulo, String descripcion, long idAlojamiento) {
        log.info("Adicionando Propuesta con id: " + id);
        Propuesta resp = pp.adicionarPropuesta(id, titulo, descripcion, idAlojamiento);
        log.info("Adicionada Propuesta: " + resp);
        return resp;
    }
    
    public long eliminarPropuestaPorId(long id) {
        log.info("Eliminando Propuesta con id: " +id);
        long resp = pp.eliminarPropuestaPorId(id);
        log.info("Eliminada Propuesta: " + resp + " tuplas eliminadas");
        return resp;
    }
    
    public long[] limpiarAlohandes() {
        log.info("Limpiando la base de datos de Alohandes");
        long[] resp = pp.limpiarAlohandes();
        log.info ("Limpiando la base de datos de Alohandes: Listo!");
        return resp;
    }

}