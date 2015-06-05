/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p20150605;

import java.io.File;

/**
 *
 * @author josei_000
 */
public abstract class AudioPista {
    protected static final int valorMax = 120;
    protected File archivo; // manejador para el archivo que contiene el audio (.mp3)
    protected int duracion; // duración del audio, en segundos
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

    public AudioPista() {
    }

    /**
     *
     * setMetadatos--- introduce el nombre del producto y el nombre del anunciante.
     *
     * @param producto
     *
     * @param anunciante
     */
    public abstract void setMetaDatos(String producto, String anunciante);

    /**
     * setDuracion--- introduce la duracion del archivo en cuestión, comprueba si la duración
     *                es inferior a 0 o superior a 120.
     *
     * @param duracion
     * @throws IllegalArgumentException
     */
    public void setDuracion(int duracion) throws IllegalArgumentException {
        if (duracion < 0) {
            duracion = 0;
        } else if (duracion > valorMax) {
            throw new IllegalArgumentException("Duración demasiado larga");
        }
        this.duracion = duracion;
    }

    /**
     *setArchivo--- introduce el nombre del archivo en cuestion y comprueba si existe.
     *
     * @param nombre_archivo
     * @return archivo si existe. Devuelve true en ese caso.
     */
    public Boolean setArchivo(String nombre_archivo) {
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
    public int ProgramaEnCola(Object cola_reproduccion, Object par1) {
        int resultado = comprobación();
        if (resultado == 0) {
            try {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            } catch (Exception ex) {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        } else {
            return resultado;
        }
    }

    protected abstract int comprobación();

    /**
     * ExportaAFormatoDAW--- comprueba que no falta nada en las variables, si todo va bien exportamos,
     *                       falta la implementación para exportar el audio.
     * @param objeto_daw
     * @return
     */
    public abstract int ExportaAFormatoDAW(Object objeto_daw);
    
}
