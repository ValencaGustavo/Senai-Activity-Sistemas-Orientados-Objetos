package Exerc4;

public class Main {

        public static void main(String[] args) {
    
            Funcionario funcionario1 =
                    new Funcionario("Kairoshi", "Killer");
    
            Funcionario funcionario2 =
                    new Funcionario("HenryChan", "Jew", 5000);

            funcionario1.aumentarSalario(10);

            funcionario2.aumentarSalario(500, true);
    
            System.out.println(funcionario1.exibirDetalhes());
    
            System.out.println();
    
            System.out.println(funcionario2.exibirDetalhes());
        }
    }