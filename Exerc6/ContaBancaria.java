package Exerc6;

public class ContaBancaria {

    String numeroConta;
    String titular;
    double saldo;
    String tipoConta;
    String ultimaDescricao;

    public ContaBancaria(String numeroConta, String titular) {

        this.numeroConta = numeroConta;
        this.titular = titular;

        this.saldo = 0;
        this.tipoConta = "corrente";
    }

    public ContaBancaria(String numeroConta, String titular, String tipoConta) {

        this.numeroConta = numeroConta;
        this.titular = titular;
        this.tipoConta = tipoConta;

        this.saldo = 0;
    }

    public ContaBancaria(String numeroConta, String titular, String tipoConta, double saldo) {

        this.numeroConta = numeroConta;
        this.titular = titular;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    public void depositar(double valor) {

        if (valor > 0) {
            saldo += valor;
        }
    }

    public void depositar(double valor, String descricao) {

        if (valor > 0) {

            saldo += valor;

            ultimaDescricao = descricao;
        }
    }

    public boolean sacar(double valor) {

        if (valor <= 0) {
            return false;
        }

        double valorFinal = valor;

        if (tipoConta.equals("poupanca")) {

            valorFinal += valor * 0.005;
        }

        if (saldo >= valorFinal) {

            saldo -= valorFinal;

            return true;
        }

        return false;
    }

    public boolean sacar(double valor, double taxaExtra) {

        if (valor <= 0 || taxaExtra < 0) {
            return false;
        }

        double valorFinal = valor + taxaExtra;

        if (tipoConta.equals("poupanca")) {

            valorFinal += valor * 0.005;
        }

        if (saldo >= valorFinal) {

            saldo -= valorFinal;

            return true;
        }

        return false;
    }
}