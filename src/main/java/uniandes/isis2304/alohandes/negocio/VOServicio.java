package uniandes.isis2304.alohandes.negocio;

public interface VOServicio {
    
    /* ****************************************************************
     * 			Métodos 
     *****************************************************************/
     
    /**
     * @return el id del alojamiento al que está asociado el servicio
     */
    public long getId();

    /**
     * @return el nombre del servicio
     */
    public String getNombreServicio();

}
