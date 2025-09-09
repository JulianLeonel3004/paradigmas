package rango;

import java.util.Map;

public class Rango {
	private static final String ABIERTO_ABIERTO = "abierto_abierto";
	private static final String ABIERTO_CERRADO = "abierto_cerrado";
	private static final String CERRADO_ABIERTO = "cerrado_abierto";
	private static final String CERRADO_CERRADO = "cerrado_cerrado";
	private static final Map<String, String> PRIMER_SIGNO = Map.of(
			ABIERTO_ABIERTO, "(",
			ABIERTO_CERRADO, "(",
			CERRADO_ABIERTO, "[",
			CERRADO_CERRADO, "["
	);
	private static final Map<String, String> SEGUNDO_SIGNO = Map.of(
			ABIERTO_ABIERTO, ")",
			ABIERTO_CERRADO, "]",
			CERRADO_ABIERTO, ")",
			CERRADO_CERRADO, "]"
	);
	
	private final double desde;
	private final double hasta;
	private final String tipo;
	
	
	private Rango (final double desde, final double hasta, final String tipo) {
		if(desde >= hasta) {
			new Error("Rango incorrecto");
		}
		this.desde = desde;
		this.hasta = hasta;
		this.tipo =  tipo;
	}
	
	public static Rango rangoAbiertoAbierto(final double desde, final double hasta) {
		return new Rango(desde, hasta, ABIERTO_ABIERTO);
	}
	
	public static Rango rangoAbiertoCerrado(final double desde, final double hasta) {
		return new Rango(desde, hasta, ABIERTO_CERRADO);
	}
	
	public static Rango rangoCerradoAbierto(final double desde, final double hasta) {
		return new Rango(desde, hasta, CERRADO_ABIERTO);
	}
	
	public static Rango rangoCerradoCerrado(final double desde, final double hasta) {
		return new Rango(desde, hasta, CERRADO_CERRADO);
	}
	
	public boolean enRango(final double valor) {
		boolean esValido = false;
		
		if(ABIERTO_ABIERTO.equals(tipo) && valor > desde && valor < hasta) {
			esValido = true;
		}
		if(ABIERTO_CERRADO.equals(tipo) && valor > desde && valor <= hasta) {
			esValido = true;
		}
		if(CERRADO_ABIERTO.equals(tipo) && valor >= desde && valor < hasta) {
			esValido = true;
		}
		if(CERRADO_CERRADO.equals(tipo) && valor >= desde && valor <= hasta) {
			esValido = true;
		}
		
		return esValido;
	}
	
	public boolean enRango(final Rango rango) {
		return this.enRango(rango.desde) && this.enRango(rango.hasta);
	}
	
	
	@Override
	public String toString() {
		return  PRIMER_SIGNO.get(tipo) + desde + ", " + hasta + SEGUNDO_SIGNO.get(tipo);
	}
	
}
