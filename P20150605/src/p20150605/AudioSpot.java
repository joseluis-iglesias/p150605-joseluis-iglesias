package p20150605;

import java.io.File;
/** 
 * 
 * @author José Luis Iglesias Fernández
 * 
 * @version 1.0.1
 * 
 */

/**
 * 
 * Declaración de las variables privadas.
 * 
 *archivo: manejador para el archivo que contiene el audio (.mp3).
 * 
 * duración: duración del audio, en segundos.
 * 
 * producto: nombre del producto anunciado.
 * 
 * anunciante: nombre de la empresa anunciante.
 * 
 * Declaración de la variable publica.
 * 
 * lasterrormsg: contiene la descripción del error relacionado con el código negativo devuelto.
 * 
 */


public class AudioSpot
{
    private File archivo;       // manejador para el archivo que contiene el audio (.mp3)
    private int duracion;       // duración del audio, en segundos
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    public String lasterrormsg;
    /**
     * 
     * AudioSpot--- almacena metadatos de las diferentes cuñas de los anuncios publicitarios y los datos del 
     * archivo que los contiene, permite programar la cuña dentro de una secuencia de audio clips y exportar 
     * la cuña completa.
     * 
     * inicializa las variables.
     * 
     */
    
    public AudioSpot ()
    {
        this.archivo = null;
        this.duracion = 0;
        this.producto = "";
        this.anunciante = "";
        this.lasterrormsg = "";
    }
    /**
     * 
     * setMetadatos--- introduce el nombre del producto y el nombre del anunciante.
     * 
     * @param producto
     * 
     * @param anunciante
     */
    public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }
    /**
     * setDuracion--- introduce la duracion del archivo en cuestión, comprueba si la duración
     *                es inferior a 0 o superior a 120.
     * 
     * @param duracion 
     * @throws IllegalArgumentException 
     */
    public void setDuracion(int duracion) throws IllegalArgumentException
    {
        if (duracion<0)
            duracion=0;
        else if (duracion>120)
            throw new IllegalArgumentException ("Duración demasiado larga");
        this.duracion = duracion;
    }
    /**
     *setArchivo--- introduce el nombre del archivo en cuestion y comprueba si existe.
     * 
     * @param nombre_archivo
     * @return archivo si existe. Devuelve true en ese caso.
     */
    public Boolean setArchivo(String nombre_archivo)
    {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }
    /**
     * ProgramaEnCola--- primero comprueba que no falte nada por introducir, tras ello  si todo ha ido bien comenzamos
     *                   con la programación de la cola, la cual aún no esta implementada.
     *                   
     * 
     * @param cola_reproduccion
     * @return 
     */
    public int ProgramaEnCola(Object cola_reproduccion)
    {
        
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        
       
        if (resultado==0)
        {
            try
            {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }     
        }
        else
            return resultado;
    }
    /**
     * ExportaAFormatoDAW--- comprueba que no falta nada en las variables, si todo va bien exportamos,
     *                       falta la implementación para exportar el audio. 
     * @param objeto_daw
     * @return 
     */
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        
       
        if (resultado==0)
        {
            try
            {
                // falta por implementar la exportación del audio
                
                lasterrormsg = "";
                return 0;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        }
        else
            return resultado;
    }
    
}
