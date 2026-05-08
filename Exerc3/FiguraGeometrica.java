package Exerc3;

public class FiguraGeometrica {

    public double calcularArea(double lado) {
        return lado * lado;
    }

    public double calcularArea(double base, double altura) {
        return base * altura;
    }

    public double calcularArea(double raio, boolean circulo) {
        return Math.PI * (raio * raio);
    }
    public double calcularPerimetro(double lado) {
        return lado * 4;
    }
    public double calcularPerimetro(double base, double altura) {
        return 2 * (base + altura);
    }

    public double calcularPerimetro(double raio, boolean circulo) {
        return 2 * Math.PI * raio;
    }
}