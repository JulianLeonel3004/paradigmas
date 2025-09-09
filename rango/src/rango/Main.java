package rango;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rango rango1 = Rango.rangoAbiertoAbierto(1, 3);
		Rango rango2 = Rango.rangoAbiertoCerrado(1, 4);
		Rango rango3 = Rango.rangoCerradoAbierto(1, 3);
		Rango rango4 = Rango.rangoCerradoCerrado(1, 3);
	
		System.out.println(rango1.toString());
		System.out.println(rango2.toString());
		System.out.println(rango3.toString());
		System.out.println(rango4.toString());
		
		
		System.out.println("1 en rango abierto abierto? " + rango1.enRango(1)); //FALSE
		System.out.println("1 en rango abierto cerrado? " + rango2.enRango(1)); //FALSE
		System.out.println("1 en rango cerrado abierto? " + rango3.enRango(1)); //TRUE
		System.out.println("1 en rango cerrado cerrado? " + rango3.enRango(1)); //TRUE
		
		System.out.println("rango 1 dentro de rango 4? " + rango4.enRango(rango1)); //TRUE
		System.out.println("rango 4 dentro de rango 1? " + rango1.enRango(rango4)); //FALSE
		System.out.println("rango 1 dentro de rango 4? " + rango4.enRango(rango1)); //TRUE
		
	}

}
