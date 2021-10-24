package br.com.rd;

public class Calcular {
	
	private int valor1;
	private int valor2;
	

	public Calcular(int valor1, int valor2){
	    this.valor1 = valor1;
	    this.valor2 = valor2;
	  
	  }

	
	public int somar() {
		return this.valor1 + valor2;
		
	}
	
	public int sub() {
		return this.valor1 - valor2;
		
	}
	
	public int dividir() {
		return this.valor1 / valor2;
	
	}
	
	public int multiplicar() {
		return this.valor1 * valor2;
	
	}
	 

}
