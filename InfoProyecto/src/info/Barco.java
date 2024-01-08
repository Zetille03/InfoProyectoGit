package info;

import java.io.Serializable;
import java.util.ArrayList;

public class Barco implements Serializable{
	ArrayList<Boton> botonesBarco;
	boolean hundido;
	
	public Barco(ArrayList<Boton> arrayBotones) {
		this.botonesBarco = arrayBotones;
	}
	
	public ArrayList<Boton> getBotonesBarco() {
		return botonesBarco;
	}

	public void setBotonesBarco(ArrayList<Boton> botonesBarco) {
		this.botonesBarco = botonesBarco;
	}

	public boolean isHundido() {
		return hundido;
	}

	public void setHundido(boolean hundido) {
		this.hundido = hundido;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String barco = "";
		for(int i = 0; i < botonesBarco.size(); i++) {
			barco += botonesBarco.get(i).getPosicionTablero();
			if(i!=botonesBarco.size()-1) {
				barco += ",";
			}
		}
		return barco;
	}
	
	public static String pasarArrayBarcosAString(ArrayList<Barco> arrayBarcos) {
		String arrayBarcosString = "";
		for(int i = 0; i < arrayBarcos.size(); i++) {
			arrayBarcosString += arrayBarcos.get(i).toString();
			if(i!=arrayBarcos.size()-1) {
				arrayBarcosString += ";";
			}
		}
		return arrayBarcosString;
		
	}
	
	public static ArrayList<Barco> pasarStringABarcos(String stringBarcos){
		ArrayList<Barco> arrayBarcos = new ArrayList<Barco>();
		String[] barcos = stringBarcos.split(";");
		for(String barco: barcos) {
			ArrayList<Boton> arrayBotones = new ArrayList<Boton>();
			String[] botones = barco.split(",");
			for(String boton : botones) {
				int posicionBoton = Integer.valueOf(boton);
				Boton b = new Boton("");
				b.setAgua(false);
				b.setPosicionTablero(posicionBoton);
				arrayBotones.add(b);
			}
			arrayBarcos.add(new Barco(arrayBotones));
		}
		return arrayBarcos;
	}
	
}
