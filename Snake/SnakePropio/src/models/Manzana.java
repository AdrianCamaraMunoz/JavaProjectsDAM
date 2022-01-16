package models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Manzana {
	// Constantes. No hay

	// ****** Atributos. Estado

	private Cuadrado manzana;

	// ****** Métodos -- Comportamientos

	// Creación
	public Manzana(int lado) {
		boolean noCreado = true;

		do {
			noCreado = true;
			int x = (int) ( Math.random() * lado ) + 1;
			int y = (int) ( Math.random() * lado ) + 1;

			if (x % 20 == 0 && y % 20 == 0) {
				// creamos la manzana
				manzana = new Cuadrado(x, y, 20, 1);
				noCreado = false;
			}

		} while (noCreado);
	}
	
	public Cuadrado getManzana() {
		return manzana;
	}

	// la manzana también sabe pintarse
	public void pintarse(Graphics2D g) {
		manzana.pintarse(g);
	}


}