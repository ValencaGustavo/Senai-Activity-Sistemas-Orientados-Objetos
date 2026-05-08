package Exerc3;

public class Main {

        public static void main(String[] args) {
    
            FiguraGeometrica figura = new FiguraGeometrica();

            System.out.println("Área do quadrado: "
                    + figura.calcularArea(5));
    
            System.out.println("Perímetro do quadrado: "
                    + figura.calcularPerimetro(5));
    
            System.out.println();

            System.out.println("Área do retângulo: "
                    + figura.calcularArea(10, 5));
    
            System.out.println("Perímetro do retângulo: "
                    + figura.calcularPerimetro(10, 5));
    
            System.out.println();

            System.out.println("Área do círculo: "
                    + figura.calcularArea(7, true));
    
            System.out.println("Circunferência do círculo: "
                    + figura.calcularPerimetro(7, true));
        }
    }