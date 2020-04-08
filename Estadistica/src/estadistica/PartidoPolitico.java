/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadistica;

/**
 * Representa un partido político y sus votos
 *
 * @author Alex Clemente < DAW >
 */
public class PartidoPolitico implements Comparable<PartidoPolitico> {

    private String nombre;
    private int numVotos = 0;
    static private int numVotosTotales;

    /**
     * Método constructor con el nombre del partido
     *
     * @param nombre del partido político
     */
    public PartidoPolitico(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }

    public static int getNumVotosTotales() {
        return numVotosTotales;
    }

    public static void setNumVotosTotales(int numVotosTotales) {
        PartidoPolitico.numVotosTotales = numVotosTotales;
    }

    /**
     * Suma un voto al partido político y a los votos totales
     */
    public void anyadirVoto() {
        numVotos++;
        numVotosTotales++;
    }

    /**
     * Méotod toString
     *
     * @return
     */
    @Override
    public String toString() {
        System.out.println(numVotosTotales);
        double porcentaje = 100/numVotosTotales * numVotos;
        return nombre + " " + numVotos + " votos / " + porcentaje + "%";
    }

    /**
     * Metodo para odenar los partidos según votos
     *
     * @param p
     * @return
     */
    @Override
    public int compareTo(PartidoPolitico p) {
        if (numVotos > p.numVotos) {
            return -1;
        }
        if (numVotos < p.numVotos) {
            return 1;
        }
        return 0;
    }

}
