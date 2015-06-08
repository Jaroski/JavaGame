package net.jaroski.game.util;

/**
 * Klasa odpowiedzialna za tworzenie Wektora dwuwymiarowego liczb ca³kowitych.
 * @author Jaroski
 *
 */
public class Vector2i {
	
	private int x, y;
	
	/**
	 * Konstruktor domyœlny, tworzy Wektor o parametrach (0,0)
	 */
	public Vector2i() {
		set(0, 0);
	}
	/**
	 * Konstruktor tworz¹cy Wektor i ustawiaj¹cy jego parametry na (X,Y)
	 * @param x parametr X Wektora
	 * @param y parametr Y Wektora
	 */
	public Vector2i(int x, int y) {
		set(x, y);
	}
	/**
	 * Konstruktor tworz¹cy Wektor i zmieniaj¹cy parametry typu double na int (X, Y)
	 * @param x Parametr X Wektora
	 * @param y Parametr Y Wektora
	 */
	public Vector2i(double x, double y) {
		set((int)x, (int)y);
	}
	
	/**
	 * Konstruktor kopiuj¹cy paremetry Wektora podanego w argumencie, do nowego Wektora.
	 * @param vector Istniej¹cy Wektor
	 */
	public Vector2i(Vector2i vector) {
		set(vector.x, vector.y);
	}
	
	/**
	 * Metoda ustawiaj¹ca argumenty (X, Y), jako parametry Wektora
	 * @param x Parametr X Wektora
	 * @param y Parametr Y Wektora
	 */
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Metoda pobieraj¹ca parametr X Wektora
	 * @return Zwraca parametr X Wektora.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Metoda ustawiaj¹ca parametr X Wektora na podany w argumencie.
	 * @param x Parametr X Wektora do ustawienia
	 * @return Zwraca Wektor z nowym parametrem X.
	 */
	public Vector2i setX(int x) {
		this.x = x;
		return this;
	}
	
	/**
	 * Metoda pobieraj¹ca parametr Y Wektora
	 * @return Zwraca parametr Y Wektora.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Metoda ustawiaj¹ca parametr Y Wektora na podany w argumencie.
	 * @param y Parametr Y Wektora do ustawienia
	 * @return Zwraca Wektor z nowym parametrem Y.
	 */
	public Vector2i setY(int y) {
		this.y = y;
		return this;
	}
	
	/**
	 * Metoda dodaj¹ca Wektor z argumentu do Wektora na którym wywo³aliœmy metodê.
	 * @param vector Parametrem jest Wektor który chcemy dodaæ
	 * @return Zwraca Wektor z parametrami zwiêkszonymi o wartoœci Wektora podanego jako argument.
	 */
	public Vector2i add(Vector2i vector) {
		this.x += vector.x;
		this.y += vector.y;
		return this;
	}
	
	/**
	 * Metoda odejmuj¹ca Wektor z argumentu do Wektora na którym wywo³aliœmy metodê.
	 * @param vector Parametrem jest Wektor który chcemy odj¹æ
	 * @return Zwraca Wektor z parametrami zmniejszonymi o wartoœci Wektora podanego jako argument.
	 */
	public Vector2i subtract(Vector2i vector) {
		this.x -= vector.x;
		this.y -= vector.y;
		return this;
	}
	
	/**
	 * Metoda zwraca odleg³oœæ pomiêdzy Wektorem v0, a Wektorem v1.
	 * @param v0 Wektor
	 * @param v1 Wektor
	 * @return Odleg³oœæ pomiêdzy podanymi wektorami
	 */
	public static double getDistance(Vector2i v0, Vector2i v1) {
		double x = (double)v0.getX() - (double)v1.getX();
		double y = (double)v0.getY() - (double)v1.getY();
		return Math.sqrt(x*x + y*y);
	}
	
	/**
	 * Porównanie czy Obiekt jest Wektorem, który jest równy Wektorowi dla którego wywo³aliœmy metodê.
	 */
	public boolean equals(Object object) {
		if(!(object instanceof Vector2i)) return false;
		Vector2i vec = (Vector2i) object;
		if(vec.getX() == this.getX() && vec.getY() == this.getY()) return true;
		return false;
	}
}
