package Exerc2;

public class Main {

    public static void main(String[] args) {

        ProdutoEletronico produto1 = new ProdutoEletronico("Notebook", 3500, "Dell");

        ProdutoEletronico produto2 = new ProdutoEletronico("Celular", 2500, "Samsung", 24);

        System.out.println(produto1.exibirDetalhes());

        System.out.println();

        System.out.println(produto2.exibirDetalhes(true));
    }
}