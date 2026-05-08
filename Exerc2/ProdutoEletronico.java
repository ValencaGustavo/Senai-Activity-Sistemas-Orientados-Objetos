package Exerc2;

public class ProdutoEletronico {

    String nome;
    double preco;
    String marca;
    int garantiaMeses;

    public ProdutoEletronico(String nome, double preco, String marca) {

        this.nome = nome;
        this.preco = preco;
        this.marca = marca;

        this.garantiaMeses = 12;
    }

    public ProdutoEletronico(String nome, double preco, String marca, int garantiaMeses) {

        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
        this.garantiaMeses = garantiaMeses;
    }

    public String exibirDetalhes() {

        return "Nome: " + nome +
               "\nPreço: R$ " + preco +
               "\nMarca: " + marca;
    }

    public String exibirDetalhes(boolean incluirGarantia) {

        if (incluirGarantia == true) {

            return "Nome: " + nome +
                   "\nPreço: R$ " + preco +
                   "\nMarca: " + marca +
                   "\nGarantia: " + garantiaMeses + " meses";
        }

        return "Nome: " + nome +
               "\nPreço: R$ " + preco +
               "\nMarca: " + marca;
    }
}