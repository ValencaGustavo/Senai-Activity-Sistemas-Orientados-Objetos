import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

public class Exercicio1 {
    public static void main(String[] args) {

        ArrayList<Produto> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Realizar venda");
            System.out.println("4 - Alterar preco");
            System.out.println("5 - Mostrar todos produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Preco: ");
                    double preco = sc.nextDouble();

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();

                    lista.add(new Produto(nome, preco, quantidade));
                    System.out.println("Produto adicionado!");
                    break;

                case 2:
                    System.out.print("Codigo do produto (posicao): ");
                    int codigo = sc.nextInt();

                    if (codigo >= 0 && codigo < lista.size()) {
                        Produto p = lista.get(codigo);
                        System.out.println("Nome: " + p.getNome());
                        System.out.println("Preco: " + p.getPreco());
                        System.out.println("Quantidade: " + p.getQuantidade());
                    } else {
                        System.out.println("Produto nao encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Codigo do produto: ");
                    int codVenda = sc.nextInt();

                    if (codVenda >= 0 && codVenda < lista.size()) {
                        Produto p = lista.get(codVenda);

                        System.out.print("Quantidade para vender: ");
                        int qtdVenda = sc.nextInt();

                        if (p.getQuantidade() >= qtdVenda) {
                            p.setQuantidade(p.getQuantidade() - qtdVenda);
                            System.out.println("Venda realizada!");
                        } else {
                            System.out.println("Estoque insuficiente!");
                        }
                    } else {
                        System.out.println("Produto nao encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Codigo do produto: ");
                    int codPreco = sc.nextInt();

                    if (codPreco >= 0 && codPreco < lista.size()) {
                        Produto p = lista.get(codPreco);

                        System.out.print("Novo preco: ");
                        double novoPreco = sc.nextDouble();

                        p.setPreco(novoPreco);
                        System.out.println("Preco atualizado!");
                    } else {
                        System.out.println("Produto nao encontrado.");
                    }
                    break;

                case 5:
                    for (int i = 0; i < lista.size(); i++) {
                        Produto p = lista.get(i);
                        System.out.println("Codigo: " + i);
                        System.out.println("Nome: " + p.getNome());
                        System.out.println("Preco: " + p.getPreco());
                        System.out.println("Quantidade: " + p.getQuantidade());
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao inexistente!");
            }

        } while (opcao != 0);

        sc.close();
    }
}