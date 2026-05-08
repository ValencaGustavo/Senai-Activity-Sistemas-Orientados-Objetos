package Exerc7;

public class ConversorTemperatura {

    char escalaPadrao = 'C';

    public double converter(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double converter(double valor, char escalaOrigem) {
        return converter(valor, escalaOrigem, escalaPadrao);
    }

    public double converter(double valor, char escalaOrigem, char escalaDestino) {

        double celsius = valor;

        if (escalaOrigem == 'F') {

            celsius = (valor - 32) * 5 / 9;
        }

        else if (escalaOrigem == 'K') {

            celsius = valor - 273.15;
        }

        if (escalaDestino == 'C') {

            return celsius;
        }

        else if (escalaDestino == 'F') {

            return (celsius * 9 / 5) + 32;
        }

        else if (escalaDestino == 'K') {

            return celsius + 273.15;
        }

        return 0;
    }
}