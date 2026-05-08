package Exerc1;
public class CalculadoraEstatistica {

    // Atributo para guardar o vetor, caso queira usar depois
    int[] numeros;

    // Construtor vazio
    public CalculadoraEstatistica() {

    }

    // Construtor recebendo vetor
    public CalculadoraEstatistica(int[] numeros) {
        this.numeros = numeros;
    }

    // Média de 2 números
    public double calcularMedia(int a, int b) {
        return (a + b) / 2.0;
    }

    // Média de 3 números
    public double calcularMedia(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    // Média de todos os números do vetor
    public double calcularMedia(int[] numeros) {

        int soma = 0;

        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }

        return (double) soma / numeros.length;
    }
}