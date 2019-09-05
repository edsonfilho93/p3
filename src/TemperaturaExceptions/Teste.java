package TemperaturaExceptions;

public class Teste {

	public static void main(String[] args) {

		try {
			double c = Utils.toCelsius(-600);
			System.out.println(c);
			
		} catch (FahrenheitException e) {
			System.out.println(e.getMessage());

		} catch (TemperatureException e) {
			System.out.println(e.getMessage());
		}
	}
}
