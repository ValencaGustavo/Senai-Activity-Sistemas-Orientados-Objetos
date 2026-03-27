import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    String nome;
    double preco;
    int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}

public class Exercicio1 {
    public static void main(String[] args) {

        ArrayList<Produto> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Realizar venda");
            System.out.println("4 - Alterar preço");
            System.out.println("5 - Mostrar todos produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();

                    lista.add(new Produto(nome, preco, quantidade));
                    System.out.println("Produto adicionado!");
                    break;

                case 2:
                    System.out.print("Código do produto (posição): ");
                    int codigo = sc.nextInt();

                    if (codigo >= 0 && codigo < lista.size()) {
                        Produto p = lista.get(codigo);
                        System.out.println("Nome: " + p.nome);
                        System.out.println("Preço: " + p.preco);
                        System.out.println("Quantidade: " + p.quantidade);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Código do produto: ");
                    int codVenda = sc.nextInt();

                    if (codVenda >= 0 && codVenda < lista.size()) {
                        Produto p = lista.get(codVenda);

                        System.out.print("Quantidade para vender: ");
                        int qtdVenda = sc.nextInt();

                        if (p.quantidade >= qtdVenda) {
                            p.quantidade -= qtdVenda;
                            System.out.println("Venda realizada!");
                        } else {
                            System.out.println("Estoque insuficiente!");
                        }
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Código do produto: ");
                    int codPreco = sc.nextInt();

                    if (codPreco >= 0 && codPreco < lista.size()) {
                        Produto p = lista.get(codPreco);

                        System.out.print("Novo preço: ");
                        double novoPreco = sc.nextDouble();

                        p.preco = novoPreco;
                        System.out.println("Preço atualizado!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 5:
                    for (int i = 0; i < lista.size(); i++) {
                        Produto p = lista.get(i);
                        System.out.println("Código: " + i);
                        System.out.println("Nome: " + p.nome);
                        System.out.println("Preço: " + p.preco);
                        System.out.println("Quantidade: " + p.quantidade);
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inexistente!");
            }

        } while (opcao != 0);

        sc.close();
    }
}