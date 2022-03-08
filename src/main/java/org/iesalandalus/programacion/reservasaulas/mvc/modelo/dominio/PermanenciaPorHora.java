package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.google.common.base.Objects;

public class PermanenciaPorHora extends Permanencia {
	// atributos
	private static final int PUNTOS = 3;
	private static final LocalTime HORA_INICIO = LocalTime.of(8, 0);
	private static final LocalTime HORA_FIN= LocalTime.of(22, 0);
	protected static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("hh:mm");
	private LocalTime hora;
	// contructor
	public PermanenciaPorHora(LocalDate dia, LocalTime hora) {
		super (dia);
		setHora(hora);
	}
	// contructor
	public PermanenciaPorHora(PermanenciaPorHora permaPorHora) {
		super(permaPorHora);
		setHora(permaPorHora.getHora());
	}
	
	// getHora
	public LocalTime getHora() {
		return hora;
	}

//setHora
	private void setHora(LocalTime hora) {
		if (hora == null) {
			throw new NullPointerException("ERROR: La hora de una permanencia no puede ser nula.");
		}
		if (hora.isBefore(HORA_INICIO) || hora.isAfter(HORA_FIN)) {
			throw new IllegalArgumentException("ERROR: La hora de una permanencia no es válida.");
		}
		if (hora.getMinute() != 0) {
			throw new IllegalArgumentException("ERROR: La hora de una permanencia debe ser una hora en punto.");
		}
		this.hora = hora;
	}

//hasCode y equals
	@Override
	public int getPuntos() {
		return PUNTOS;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getDia(), hora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermanenciaPorHora other = (PermanenciaPorHora) obj;
		return Objects.equal(getDia(), other.getDia()) && Objects.equal(hora, other.hora);
	}


	@Override
	public String toString() {
		return super.toString() + ", hora=" + hora;
	}
	
	

}
;