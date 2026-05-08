package Exerc7;

public class Main {

    public static void main(String[] args) {

        ConversorTemperatura conversor = new ConversorTemperatura();

        System.out.println(conversor.converter(30)
        );

        System.out.println(conversor.converter(86, 'F')
        );

        System.out.println(conversor.converter(25, 'C', 'K')
        );

        System.out.println(conversor.converter(300, 'K', 'F')
        );
    }
}