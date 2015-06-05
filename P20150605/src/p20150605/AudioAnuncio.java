package p20150605;

import java.io.File;
import java.util.Date;
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


public class AudioAnuncio extends AudioPista
{
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante

    
    public AudioAnuncio ()
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

    protected int comprobación() {
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
        
        int resultado = comprobación();
        
       
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
