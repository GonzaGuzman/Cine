/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cine;

import Cine.CineSc;
import static Cine.Clasificacion.ATP;
import static Cine.Clasificacion.C;
import static Cine.Clasificacion.MAYORES_13;
import static Cine.Clasificacion.MAYORES_16;
import Cine.Espectador;
import Cine.Sala;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rem
 */
public class EspectadorSc {

    /*
    metodo para cargar usuarios del cine
     */
    //public class Espectador {
    //private String nombre;
    //private int edad;
    //private float billetera;
    public static void cargarUsuario(Espectador usuario) {
        usuario.setNombre(JOptionPane.showInputDialog("INGRESE NOMBRE Y APELLIDO "));
        usuario.setEdad(Integer.parseInt(JOptionPane.showInputDialog("INGRESE EDAD ")));
        usuario.setBilletera(0);
    }

    /*
    metodo para cargar saldo
    
     */
    public static void cargarSaldo(Espectador usuario) {
        JOptionPane.showMessageDialog(null, "SU SALDO ACTUAL ES DE $" + usuario.getBilletera());
        if (JOptionPane.showConfirmDialog(null, "DESEA CARGAR SALDO ", "CONTESTA SI O NO ", JOptionPane.YES_NO_OPTION) == 0) {
            Float saldo = Float.parseFloat(JOptionPane.showInputDialog("INGRESE EL MONTO QUE DESEA AGREGAR A LA CUENTA"));
            JOptionPane.showMessageDialog(null, " TRANSACCION EXITOSA !");
            usuario.setBilletera(usuario.getBilletera() + saldo);
        }
    }

    /*
    COMPROBADOR DE EDAD 
     */
    public static boolean autorizarEdad(Sala salaN, Espectador usuario) {
        int edad = usuario.getEdad();
        boolean aux = false;
        if (salaN.getEnCartelera().getClasificacion() == ATP) {
            aux = true;
        } else if (salaN.getEnCartelera().getClasificacion() == MAYORES_13) {
            if (edad >= 13) {
                aux = true;
            }
        } else if (salaN.getEnCartelera().getClasificacion() == MAYORES_16) {
            if (edad >= 16) {
                aux = true;
            }
        } else if (salaN.getEnCartelera().getClasificacion() == C) {
            if (edad >= 18) {
                aux = true;
            }
        }
        return aux;
    }

    /*
     comprobar dinero de entrada 
     */
    public static boolean autorizarPago(Sala salaN, Espectador usuario) {
        return (usuario.getBilletera() >= salaN.getPrecioEntrada());
    }

    /*
    seleccionar pelicula devuelve la sala en que se esta reproduciendo la pelicula
     */
    public static Sala seleccionPelicula(ArrayList<Sala> salas) {
        String[] tituloPelicula = new String[salas.size()];
        for (int i = 0; i < salas.size(); i++) {
            tituloPelicula[i] = salas.get(i).getEnCartelera().getTitulo();
        }
        int opcionPelicula = JOptionPane.showOptionDialog(null, "SELECCIONE", "PELICULAS", 0, JOptionPane.QUESTION_MESSAGE, null, tituloPelicula, null);
        return salas.get(opcionPelicula);
    }

    /*
    seleccionar butaca, si esta disponible y tiene saldo se reserva caso de no tener saldo vuelve al menu, 
    o caso de no estar disponible o reservar con exito permite buscar otra butaca o reservar una segunda butaca
     */
    public static void seleccionarButacas(Sala salaN, Espectador usuario) {
        boolean salir = true;
        String letras = "ZYXWVUTSRQPONMLKFIHGFEDCBA";
        int numCol = salaN.getLugares()[0].length;
        int numFilas = salaN.getLugares().length;
        String auxLetras = letras.substring(letras.length() - numCol, letras.length());
        String[] columna = new String[numCol];
        String[] fila = new String[numFilas];
        for (int i = 0; i < numFilas; i++) {
            fila[i] = String.valueOf(i + 1);
        }
        for (int i = 0; i < numCol; i++) {
            columna[i] = auxLetras.substring(i, i + 1);
        }
        do {
            CineSc.mostrarSala(salaN);
            int opcionFila = (JOptionPane.showOptionDialog(null, "FILA", "ELIGE...", 0,
                    JOptionPane.QUESTION_MESSAGE, null, fila, null));
            int opcionColumna = (JOptionPane.showOptionDialog(null, "FILA", "ELIGE...", 0,
                    JOptionPane.QUESTION_MESSAGE, null, columna, null));
            if (salaN.getLugares()[opcionFila][opcionColumna].isEstado()) {
                if (!EspectadorSc.autorizarPago(salaN, usuario)) {
                    JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE");
                    salir = false;
                } else {
                    if (!EspectadorSc.autorizarEdad(salaN, usuario)) {
                        JOptionPane.showMessageDialog(null, "ES MENOR DE EDAD PARA ESTA PELICULA");
                        salir = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "ASIENTO RESERVADO CON EXITO");
                        salaN.getLugares()[opcionFila][opcionColumna].setEstado(false);
                        salaN.getLugares()[opcionFila][opcionColumna].setReserva(usuario);
                        salaN.setButacasReservadas(salaN.getButacasReservadas() + 1);
                        usuario.setBilletera(usuario.getBilletera() - salaN.getPrecioEntrada());
                        
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "ASIENTO NO DISPONIBLE");
            }
            if (JOptionPane.showConfirmDialog(null, "DESEA RESERVAR OTRO ASIENTO ", "CONTESTA SI O NO ", JOptionPane.YES_NO_OPTION) == 1) {
                salir = false;
            }
        } while (salir);
    }

    /*
    comprobar si ya esta registrado
     */
    public static Espectador comprobarRegistro(ArrayList<Espectador> usuarios) {
        String nombre = JOptionPane.showInputDialog("INGRESE SU NOMBRE Y APELLIDO");
        Espectador aux = null;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombre().equalsIgnoreCase(nombre)) {
                aux = usuarios.get(i);
                break;
            }
        }
        return aux;
    }
public static void mostarReservas(ArrayList<Sala> salas, Espectador usuario){
        for (Sala aux : salas) {
            if (aux.getLugares().equals(usuario))
                JOptionPane.showMessageDialog(null, "SALA: "+ aux.getNumeroSala()+"\n PELICULA: "+ aux.getEnCartelera().getTitulo());
        }
}
    
    
    /*
    menu
    
     */
    public static void menuUsuario(ArrayList<Sala> salas, ArrayList<Espectador> usuarios) {
        boolean entrar = true, salir = true;
        String[] menu1 = {"INGRESAR", "REGISTRAR NUEVO USUARIO", "SALIR"};
        String[] menu2 = {"CARGAR SALDO", "RESERVAR ASIENTO", "VER ESTADO", "MOSTRAR RESERVAS","SALIR"};
        Sala aux = new Sala();
        Espectador user = new Espectador();
        do {
            int opcion = JOptionPane.showOptionDialog(null, "PARA", "SELECCIONA", 0, JOptionPane.QUESTION_MESSAGE, null, menu1, null);
            switch (opcion) {
                case 0:
                    user = EspectadorSc.comprobarRegistro(usuarios);
                    if (user == null) {
                        JOptionPane.showMessageDialog(null, "USUARIO NO REGISTRADO, POR FAVOR REGISTRESE PARA PODER ACCEDER AL SISTEMA");
                    } else {
                        entrar = false;
                    }
                    break;
                case 1:
                    EspectadorSc.cargarUsuario(user);
                    usuarios.add(user);
                    entrar = false;
                    break;
                case 2:
                    salir = false;
                    break;
            }
        } while (salir && entrar);
        if (!entrar) {
            salir = true;
            do {
                int opcion = JOptionPane.showOptionDialog(null, "PARA", "SELECCIONA", 0, JOptionPane.QUESTION_MESSAGE, null, menu2, null);
                switch (opcion) {
                    case 0:
                        EspectadorSc.cargarSaldo(user);
                        break;
                    case 1:
                        aux = EspectadorSc.seleccionPelicula(salas);
                        EspectadorSc.seleccionarButacas(aux, user);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, user);
                        break;
                    case 3:
                        EspectadorSc.mostarReservas(salas, user);
                    case 4:
                        salir = false;
                        break;
                }
            } while (salir);

        }

    }
}
