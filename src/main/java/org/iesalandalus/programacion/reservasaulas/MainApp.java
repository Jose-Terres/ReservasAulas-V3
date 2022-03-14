package org.iesalandalus.programacion.reservasaulas;

import org.iesalandalus.programacion.reservasaulas.mvc.controlador.Controlador;
import org.iesalandalus.programacion.reservasaulas.mvc.controlador.IControlador;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.IModelo;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.Modelo;
import org.iesalandalus.programacion.reservasaulas.mvc.vista.IVista;
import org.iesalandalus.programacion.reservasaulas.mvc.vista.Vista;
import org.iesalandalus.programacion.utilidades.Entrada;

// creamos la main
public class MainApp {

	public static void main(String[] args) {
		System.out.println("INTRODUZCA EL TIPO DATOS QUE DESEA USAR");
		System.out.println("1.- MEMORIA (NO PERSISTENTES)");
		System.out.println("2.- FICHEROS (PERSISTENTES)");
		int opcion = 0;
		do {
			System.out.print("Introduzca la opción elegida:");
			opcion = Entrada.entero();
		} while (opcion != 1 && opcion != 2);
		IModelo modelo = null;
		switch (opcion) {
		case 1:
			modelo = new Modelo(FactoriaFuenteDatos.MEMORIA.crear());
			break;
		case 2:
			modelo = new Modelo(FactoriaFuenteDatos.FICHEROS.crear());
			break;
		default:
			modelo = new Modelo(FactoriaFuenteDatos.FICHEROS.crear());
			break;
		}
		IVista vista = new Vista();
		IControlador controlador = new Controlador(modelo, vista);
		System.out.println();
		controlador.comenzar();
	}

}
