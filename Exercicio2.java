import java.util.ArrayList;
import java.util.Scanner;

class ContaBancaria {
    private String titular;
    private int numeroConta;
    private double saldo;

    public ContaBancaria(String titular, int numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito realizado com sucesso!");
        } else {
            System.out.println("Valor invalido para deposito");
        }
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor invalido para saque");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        }
    }

    public void exibirDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Numero da conta: " + numeroConta);
        System.out.println("Saldo: R$ " + saldo);
    }
}

public class Exercicio2 {
    static ArrayList<ContaBancaria> contas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void criarConta() {
        System.out.print("Digite o nome do titular: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o numero da conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(nome, numero);
        contas.add(conta);

        System.out.println("Conta criada com sucesso!");
    }

    public static ContaBancaria buscarConta(int numero) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numero) {
                return conta;
            }
        }
        return null;
    }

    public static void fazerDeposito() {
        System.out.print("Digite o numero da conta: ");
        int numero = scanner.nextInt();

        ContaBancaria conta = buscarConta(numero);

        if (conta != null) {
            System.out.print("Digite o valor para deposito: ");
            double valor = scanner.nextDouble();
            conta.depositar(valor);
        } else {
            System.out.println("Conta nao encontrada.");
        }
    }

    public static void fazerSaque() {
        System.out.print("Digite o numero da conta: ");
        int numero = scanner.nextInt();

        ContaBancaria conta = buscarConta(numero);

        if (conta != null) {
            System.out.print("Digite o valor para saque: ");
            double valor = scanner.nextDouble();
            conta.sacar(valor);
        } else {
            System.out.println("Conta nao encontrada.");
        }
    }

    public static void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (ContaBancaria conta : contas) {
                conta.exibirDados();
            }
        }
    }

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Listar contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    fazerDeposito();
                    break;
                case 3:
                    fazerSaque();
                    break;
                case 4:
                    listarContas();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opcao inexistente");
            }

        } while (opcao != 0);
    }
}