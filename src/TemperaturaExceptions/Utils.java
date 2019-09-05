package TemperaturaExceptions;

public final class Utils {

	private static final double ZERO_ABSOLUTO = -459.67;

	private Utils() {
	}

	public static double toCelsius(double temperaturaF) throws TemperatureException {
		if (temperaturaF < ZERO_ABSOLUTO)
			throw new FahrenheitException("Temperatura inválida, o valor informado é menor que o zero absoluto");

		double temperaturaC = ((5.0 / 9.0) * (temperaturaF - 32));
		return temperaturaC;
	}
}
