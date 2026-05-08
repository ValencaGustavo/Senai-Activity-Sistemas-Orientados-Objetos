package Exerc5;

public class Main {

        public static void main(String[] args) {
    
            ReservaHotel reserva1 = new ReservaHotel("Carlos", 101, 5, true, 200, 4);
    
            ReservaHotel reserva2 = new ReservaHotel("Ana", 202, 3, 150,2);
    
            ReservaHotel reserva3 = new ReservaHotel("João", 303, 180);
    
            System.out.println("Reserva 1: R$ " + reserva1.calcularValorTotal());
    
            System.out.println();
    
            System.out.println("Reserva 2 com taxa extra: R$ " + reserva2.calcularValorTotal(100));
    
            System.out.println();
    
            System.out.println("Reserva 3: R$ " + reserva3.calcularValorTotal());
        }
    }