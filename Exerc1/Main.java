package Exerc1;
public class Main {

    public static void main(String[] args) {

        CalculadoraEstatistica calc = new CalculadoraEstatistica();

        System.out.println(calc.calcularMedia(10, 20));

        System.out.println(calc.calcularMedia(10, 20, 30));

        int[] numeros = {10, 20, 30, 40};

        System.out.println(calc.calcularMedia(numeros));
    }
}