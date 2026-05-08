package Exerc4;

public class Funcionario {

    String nome;
    String cargo;
    double salario;

    public Funcionario(String nome, String cargo) {

        this.nome = nome;
        this.cargo = cargo;

        this.salario = 1500.0;
    }

    public Funcionario(String nome, String cargo, double salario) {

        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void aumentarSalario(double percentual) {

        salario += salario * (percentual / 100);
    }

    public void aumentarSalario(double valorFixo, boolean aumentoFixo) {

        salario += valorFixo;
    }

    public String exibirDetalhes() {

        return "Nome: " + nome +
               "\nCargo: " + cargo +
               "\nSalário: R$ " + salario;
    }
}