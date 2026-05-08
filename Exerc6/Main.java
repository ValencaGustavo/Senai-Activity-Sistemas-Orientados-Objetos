package Exerc6;

public class Main {

    public static void main(String[] args) {

        ContaBancaria conta1 = new ContaBancaria("123", "Carlos");

        ContaBancaria conta2 = new ContaBancaria("456", "Ana", "poupanca", 1000);

        conta1.depositar(500);

        conta2.depositar(200, "Salário");

        boolean saque1 = conta1.sacar(100);

        boolean saque2 = conta2.sacar(300, 20);

        System.out.println("Saldo conta 1: R$ " + conta1.saldo);

        System.out.println("Saque conta 1: " + saque1);

        System.out.println();

        System.out.println("Saldo conta 2: R$ " + conta2.saldo);

        System.out.println("Última descrição: " + conta2.ultimaDescricao);

        System.out.println("Saque conta 2: " + saque2);
    }
}