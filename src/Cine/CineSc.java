/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

import static Cine.Clasificacion.ATP;
import static Cine.Clasificacion.C;
import static Cine.Clasificacion.MAYORES_13;
import static Cine.Clasificacion.MAYORES_16;
import static Cine.Genero.ACCION;
import static Cine.Genero.AVENTURA;
import static Cine.Genero.CIENCIA_FICCION;
import static Cine.Genero.COMEDIA;
import static Cine.Genero.DRAMA;
import static Cine.Genero.SUSPENSO;
import static Cine.Genero.TERROR;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rem
 */
public class CineSc {

    /*
    metodo para crear una nueva sala con cantidad de filas y columnas elegidas por el usauario
     */
    public static void crearSala(ArrayList<Sala> salas) {
        String numSalaAux, filaAux, columnaAux;
        Integer numeroSala = null;
        boolean validar;
        do {
            validar = true;
            numSalaAux = JOptionPane.showInputDialog("INGRESE NUMERO DE SALA");
            if (!(numSalaAux == null)) {
                numeroSala = Integer.parseInt(numSalaAux);
                if (CineSc.comprobarNumero(salas, numeroSala)) {
                    JOptionPane.showMessageDialog(null, "SALA EXISTENTE");
                    validar = false;
                }
            }
        } while (validar == false);
        filaAux = JOptionPane.showInputDialog("INGRESE NUMERO DE FILAS");
        columnaAux = JOptionPane.showInputDialog("INGRESE NUMERO DE COLUMNAS");
        if (numSalaAux == null || filaAux == null || columnaAux == null) {
            JOptionPane.showMessageDialog(null, "DATOS IMCOMPLETOS NO SE PUEDE CREAR SALA");
        } else {
            int fila = Integer.parseInt(filaAux);
            int columna = Integer.parseInt(columnaAux);
            Butaca[][] lugares = CineSc.crearButacas(fila, columna);
            int cantDeButacas = fila * columna;
            salas.add(new Sala(numeroSala, lugares, null, cantDeButacas, 0, null));
        }
    }

    public static boolean comprobarNumero(ArrayList<Sala> salas, int numero) {
        return salas.stream().anyMatch(x -> x.getNumeroSala() == numero);
    }

    /*
  metodo que retorna una matriz de objeto Butaca de n filas por n columnas cargada con numero, letra y valor disponible de Butaca = true  
     */
    public static Butaca[][] crearButacas(int fila, int columna) {
        String letras = "ZYXWVUTSRQPONMLKFIHGFEDCBA";
        Butaca[][] aux = new Butaca[fila][columna];
        letras = letras.substring(letras.length() - columna, letras.length());
        for (int i = fila - 1; i >= 0; i--) {
            for (int j = columna - 1; j >= 0; j--) {
                char letra = letras.substring(j, j + 1).charAt(0);
                aux[i][j] = new Butaca((i + 1), letra, true);
            }
        }
        return aux;
    }

    /*
    mostrar butacas
     */
    public static void mostrarSala(Sala salaN) {
        int numCol = salaN.getLugares()[0].length;
        int numFilas = salaN.getLugares().length;
        String resultado = "";
        for (int i = numFilas - 1; i >= 0; i--) {
            for (int j = numCol - 1; j >= 0; j--) {
                resultado += salaN.getLugares()[i][j].toString();
                resultado += "  ";
            }
            resultado += "\n";
        }
        JOptionPane.showMessageDialog(null, "<<<<< SALA N: " + salaN.getNumeroSala() + " >>>>>\n" + resultado
                + "\n" + salaN.toString());
    }

    /*
    este metodo carga las peliculas
     */
    public static void cargarPelicula(ArrayList<Pelicula> peliculas) {
        String titulo = JOptionPane.showInputDialog(" INGRESE EL TITULO DE LA PELICULA ");
        String director = JOptionPane.showInputDialog(" INGRESE NOMBRE DEL DIRECTOR ");
        String duracion = JOptionPane.showInputDialog("INGRESE DURACION EN MINUTOS");
        if (titulo == null || director == null || duracion == null) {
            JOptionPane.showMessageDialog(null, "DATOS INCOMPLETOS NO ES POSIBLE CARGAR PELICULA");
        } else {
            Pelicula aux = new Pelicula();
            aux.setTitulo(titulo);
            aux.setDirector(director);
            aux.setDuracion(Integer.parseInt(duracion));
            String[] clase = {"ATP", "+13", "+16", "C"};
            int opcion = (JOptionPane.showOptionDialog(null, "CLASIFICACION ", "ELIGE...", 0,
                    JOptionPane.QUESTION_MESSAGE, null, clase, null));
            switch (opcion) {
                case 0:
                    aux.setClasificacion(ATP);
                    break;
                case 1:
                    aux.setClasificacion(MAYORES_13);
                    break;
                case 2:
                    aux.setClasificacion(MAYORES_16);
                    break;
                case 3:
                    aux.setClasificacion(C);
                    break;
            }
            String[] genero = {"ACCION", "COMEDIA", "DRAMA", "SUSPENSO", "TERROR", "AVENTURA", "CIENCIA_FICCION"};
            opcion = (JOptionPane.showOptionDialog(null, "GENERO", "ELIGE...", 0,
                    JOptionPane.QUESTION_MESSAGE, null, genero, null));
            switch (opcion) {
                case 0:
                    aux.setGenero(ACCION);
                    break;
                case 1:
                    aux.setGenero(COMEDIA);
                    break;
                case 2:
                    aux.setGenero(DRAMA);
                    break;
                case 3:
                    aux.setGenero(SUSPENSO);
                    break;
                case 4:
                    aux.setGenero(TERROR);
                    break;
                case 5:
                    aux.setGenero(AVENTURA);
                    break;
                case 6:
                    aux.setGenero(CIENCIA_FICCION);
                    break;
            }
            peliculas.add(aux);
        }
    }

    /*
    cambiar precio de entrada
    
     */
    public static void cambiarPrecio(ArrayList<Sala> salas) {
        JOptionPane.showMessageDialog(null, "PRECIO ACTUAL: $" + salas.get(0).getPrecioEntrada());
        String precioAux = JOptionPane.showInputDialog("INGRESE NUEVO PRECIO");
        if (precioAux != null) {
            float precio = Float.parseFloat(precioAux);
            salas.stream().forEach((x) -> x.setPrecioEntrada(precio));
            JOptionPane.showMessageDialog(null, "PRECIO ACTUALIZADO: $" + salas.get(0).getPrecioEntrada());
        }
    }

    /*
    cambiar cartelera
     */
    public static void cambiarCartelera(ArrayList<Sala> salas, ArrayList<Pelicula> peliculas) {
        int cant = salas.size();
        String[] numeroSalas = new String[cant];
        for (int i = 0; i < numeroSalas.length; i++) {
            numeroSalas[i] = String.valueOf(salas.get(i).getNumeroSala());
        }
        String[] tituloPelicula = new String[peliculas.size()];
        for (int i = 0; i < peliculas.size(); i++) {
            tituloPelicula[i] = peliculas.get(i).getTitulo();
        }

        int opcion = JOptionPane.showOptionDialog(null, "SELECCIONE", "SALAS", 0, JOptionPane.QUESTION_MESSAGE, null, numeroSalas, null);
        int opcionPelicula = JOptionPane.showOptionDialog(null, "SELECCIONE", "PELICULAS", 0, JOptionPane.QUESTION_MESSAGE, null, tituloPelicula, null);
        salas.get(opcion).setEnCartelera(peliculas.get(opcionPelicula));
    }

    /*
    interfaz empresa
     */
    public static void menuEmpresa(ArrayList<Sala> salas, ArrayList<Pelicula> peliculas, ArrayList<Espectador> usurarios) {
        String[] menu1 = {"VER PELICULAS", "CARGAR PELICULA NUEVA", "CONFIGURACION SALAS",
            "ACTUALIZAR PRECIO ENTRADA", "INGRESAR A SISTEMA DE USUARIOS", "SALIR"};
        String[] menu2 = {"VER SALAS", "MOFIFICAR CARTELERA SALA ", "CREAR NUEVA SALA", "SALIR"};
        boolean salirMenu1 = true, salirMenu2 = true;

        do {
            int opcion = JOptionPane.showOptionDialog(null, "SELECIONE", "CINEMATIC", 0, JOptionPane.QUESTION_MESSAGE, null, menu1, null);
            switch (opcion) {
                case 0:
                    if (peliculas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "AUN NO HAY PELICULAS CARGADAS");
                    } else {
                        peliculas.stream().forEachOrdered((x) -> JOptionPane.showMessageDialog(null, x));
                    }
                    break;
                case 1:
                    CineSc.cargarPelicula(peliculas);
                    break;
                case 2:
                    do {
                        int opcion2 = JOptionPane.showOptionDialog(null, "SELECIONE", "CINEMATIC", 0, JOptionPane.QUESTION_MESSAGE, null, menu2, null);
                        switch (opcion2) {
                            case 0:
                                if (salas.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "AUN NO HAY SALAS CARGADAS");
                                } else {
                                    salas.stream().forEachOrdered((x) -> CineSc.mostrarSala(x));
                                }
                                break;
                            case 1:
                                if (peliculas.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "AUN NO HAY PELICULAS CARGADAS");
                                } else {
                                    cambiarCartelera(salas, peliculas);
                                }
                                break;
                            case 2:
                                CineSc.crearSala(salas);
                                if (!salas.isEmpty()) {
                                    CineSc.cambiarPrecio(salas);
                                }
                                break;
                            case 3:
                                salirMenu2 = false;
                                break;
                        }
                    } while (salirMenu2);
                    break;
                case 3:
                    if (!salas.isEmpty()) {
                        CineSc.cambiarPrecio(salas);
                    } else {
                        JOptionPane.showMessageDialog(null, "AUN NO HAY SALAS CARGADAS");
                    }
                    break;
                case 4:
                    EspectadorSc.menuUsuario(salas, usurarios);
                    break;
                case 5:
                    salirMenu1 = false;
                    break;
            }

        } while (salirMenu1);
    }

}
