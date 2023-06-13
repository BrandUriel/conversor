package Visual;


public class Convertion {
	
	static double C(char a, double valor) throws Exception {

		if (a == 'K') {

			return valor + 273.15;

		}
		if (a == 'F') {

			return valor * 1.8 + 32;

		}

		throw new Exception();
	}

	static double K(char a, double valor) throws Exception {

		if (a == 'C') {

			return valor - 273.15;

		}
		if (a == 'F') {

			return 1.8 * (valor - 273.15) + 32;

		}

		throw new Exception();

	}

	static double F(char a, double valor) throws Exception {
		
		if (a == 'K') {

			return 5 / 9 * (valor - 32) + 273.15;

		}
		if (a == 'C') {

			return (valor - 32) / 1.8;

		}
		throw new Exception();

	}

}
