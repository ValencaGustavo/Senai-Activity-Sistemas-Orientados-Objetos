import java.util.ArrayList;
import java.util.Scanner;

class Disciplina {
    String nome;
    ArrayList<Double> notas;

    Disciplina(String nome) {
        this.nome = nome;
        this.notas = new ArrayList<>();
    }

    void adicionarNota(double nota) {
        notas.add(nota);
    }

    double calcularMedia() {
        if (notas.isEmpty()) return 0;
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }
}

class Aluno {
    String nomeCompleto;
    String matricula;
    ArrayList<Disciplina> disciplinas;

    Aluno(String nomeCompleto, String matricula) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.disciplinas = new ArrayList<>();
    }

    void adicionarDisciplina(String nomeDisciplina) {
        if (disciplinas.size() >= 4) {
            System.out.println("Aluno já está matriculado em 4 disciplinas (limite máximo).");
            return;
        }
        disciplinas.add(new Disciplina(nomeDisciplina));
        System.out.println("Disciplina '" + nomeDisciplina + "' adicionada com sucesso!");
    }

    Disciplina buscarDisciplina(String nomeDisciplina) {
        for (Disciplina d : disciplinas) {
            if (d.nome.equalsIgnoreCase(nomeDisciplina)) {
                return d;
            }
        }
        return null;
    }
}

public class SistemaEscola {
    static ArrayList<Aluno> alunos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Adicionar disciplina a um aluno");
            System.out.println("3. Inserir nota em uma disciplina");
            System.out.println("4. Consultar aluno por matrícula");
            System.out.println("5. Listar todos os alunos");
            System.out.println("6. Relatório final");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: cadastrarAluno(); break;
                case 2: adicionarDisciplina(); break;
                case 3: inserirNota(); break;
                case 4: consultarAluno(); break;
                case 5: listarAlunos(); break;
                case 6: relatorioFinal(); break;
                case 0: System.out.println("Encerrando o sistema. Até logo!"); break;
                default: System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    static void cadastrarAluno() {
        System.out.print("Nome completo do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Número de matrícula: ");
        String matricula = scanner.nextLine();

        for (Aluno a : alunos) {
            if (a.matricula.equals(matricula)) {
                System.out.println("Já existe um aluno com essa matrícula!");
                return;
            }
        }

        alunos.add(new Aluno(nome, matricula));
        System.out.println("Aluno '" + nome + "' cadastrado com sucesso!");
    }

    static void adicionarDisciplina() {
        Aluno aluno = buscarAlunoPorMatricula();
        if (aluno == null) return;

        System.out.print("Nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine();

        aluno.adicionarDisciplina(nomeDisciplina);
    }

    static void inserirNota() {
        Aluno aluno = buscarAlunoPorMatricula();
        if (aluno == null) return;

        if (aluno.disciplinas.isEmpty()) {
            System.out.println("Este aluno não possui disciplinas cadastradas.");
            return;
        }

        System.out.println("Disciplinas do aluno:");
        for (Disciplina d : aluno.disciplinas) {
            System.out.println("  - " + d.nome);
        }

        System.out.print("Nome da disciplina para inserir nota: ");
        String nomeDisciplina = scanner.nextLine();

        Disciplina disciplina = aluno.buscarDisciplina(nomeDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada para este aluno.");
            return;
        }

        System.out.print("Digite a nota: ");
        double nota = scanner.nextDouble();
        scanner.nextLine();

        if (nota < 0 || nota > 10) {
            System.out.println("Nota inválida! Deve ser entre 0 e 10.");
            return;
        }

        disciplina.adicionarNota(nota);
        System.out.println("Nota " + nota + " inserida na disciplina '" + disciplina.nome + "'.");
    }

    static void consultarAluno() {
        Aluno aluno = buscarAlunoPorMatricula();
        if (aluno == null) return;

        System.out.println("\nDados do Aluno");
        System.out.println("Nome: " + aluno.nomeCompleto);
        System.out.println("Matrícula: " + aluno.matricula);

        if (aluno.disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
        } else {
            System.out.println("Disciplinas e notas:");
            for (Disciplina d : aluno.disciplinas) {
                System.out.print("  " + d.nome + " -> Notas: ");
                if (d.notas.isEmpty()) {
                    System.out.print("nenhuma nota cadastrada");
                } else {
                    for (int i = 0; i < d.notas.size(); i++) {
                        System.out.print(d.notas.get(i));
                        if (i < d.notas.size() - 1) System.out.print(", ");
                    }
                    System.out.printf(" | Média: %.2f", d.calcularMedia());
                }
                System.out.println();
            }
        }
    }

    static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("\nLISTA DE ALUNOS");
        for (Aluno a : alunos) {
            System.out.println("Nome: " + a.nomeCompleto + " | Matrícula: " + a.matricula + " | Disciplinas: " + a.disciplinas.size());
        }
    }

    static void relatorioFinal() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("\nRELATÓRIO FINAL");
        for (Aluno a : alunos) {
            System.out.println("\nAluno: " + a.nomeCompleto + " | Matrícula: " + a.matricula);

            if (a.disciplinas.isEmpty()) {
                System.out.println("  Nenhuma disciplina cadastrada.");
                continue;
            }

            boolean reprovadoEmAlguma = false;
            for (Disciplina d : a.disciplinas) {
                double media = d.calcularMedia();
                String situacao;

                if (d.notas.isEmpty()) {
                    situacao = "SEM NOTAS";
                    reprovadoEmAlguma = true;
                } else if (media > 7) {
                    situacao = "APROVADO";
                } else {
                    situacao = "REPROVADO / RECUPERAÇÃO";
                    reprovadoEmAlguma = true;
                }

                System.out.println("  Disciplina: " + d.nome + " | Média: " + media + " | " + situacao);
            }

            if (reprovadoEmAlguma) {
                System.out.println("PRECISA DE RECUPERAÇÃO EM ALGUMA DISCIPLINA");
            } else {
                System.out.println("APROVADO EM TODAS AS DISCIPLINAS");
            }
        }
    }

    static Aluno buscarAlunoPorMatricula() {
        System.out.print("Digite o número de matrícula: ");
        String matricula = scanner.nextLine();

        for (Aluno a : alunos) {
            if (a.matricula.equals(matricula)) {
                return a;
            }
        }

        System.out.println("Aluno com matrícula '" + matricula + "' não encontrado.");
        return null;
    }
}