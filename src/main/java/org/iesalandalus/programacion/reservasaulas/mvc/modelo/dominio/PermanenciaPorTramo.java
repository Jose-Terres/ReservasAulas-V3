package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.time.LocalDate;

import com.google.common.base.Objects;

public class PermanenciaPorTramo extends Permanencia{
	
	private static final int PUNTOS = 10;
	private Tramo tramo;
	
	public PermanenciaPorTramo(LocalDate dia, Tramo tramo) {
		//Llamamos al constructos de la clase padre, en este caso permanencia
		super (dia);
		//asignamos el atributo de esta clase
		setTramo(tramo);
		
	}
	// permanenciPorTramo
	public PermanenciaPorTramo(PermanenciaPorTramo permanenciaPorTramo) {
		super (permanenciaPorTramo);
		setTramo(permanenciaPorTramo.getTramo());
	}
//getTramo
	public Tramo getTramo() {
		return tramo;
	}
//setTramo
	private void setTramo(Tramo tramo) {
		if (tramo == null) {
			throw new NullPointerException("ERROR: El tramo de una permanencia no puede ser nulo.");
		}
		this.tramo = tramo;
	}
	
	@Override
	public int getPuntos() {
		return PUNTOS;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getDia(), tramo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermanenciaPorTramo other = (PermanenciaPorTramo) obj;
		return Objects.equal(getDia(), other.getDia()) && tramo == other.tramo;
	}

	@Override
	public String toString() {
		return super.toString() + ", tramo=" + tramo;
	}
}
