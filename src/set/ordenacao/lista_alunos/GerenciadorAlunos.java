package set.ordenacao.lista_alunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        if (!alunoSet.isEmpty()) {
            Aluno alunoParaSerRemovido = null;
            for (Aluno aluno : alunoSet) {
                if (aluno.getMatricula() == matricula) {
                    alunoParaSerRemovido = aluno;
                    break;
                }
            }

            if (alunoParaSerRemovido == null) {
                System.out.println("Matrícula não encontrada!");
            } else {
                alunoSet.remove(alunoParaSerRemovido);
            }
        } else {
            System.out.println("A lista de alunos está vazia!");
        }
    }

    public void exibirAlunosPorNome() {
        if (!alunoSet.isEmpty()) {
            Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
            System.out.println(alunosPorNome);
        } else {
            System.out.println("A lista de alunos está vazia!");
        }
    }

    public void exibirAlunosPorMedia() {
        if (!alunoSet.isEmpty()) {
            Set<Aluno> alunosPorMedia = new TreeSet<>(new ComparatorPorMedia());
            alunosPorMedia.addAll(alunoSet);
            System.out.println(alunosPorMedia);
        } else {
            System.out.println("A lista de alunos está vazia!");
        }
    }

    public void exibirAlunos() {
        if (!alunoSet.isEmpty()) {
            System.out.println(alunoSet);
        } else {
            System.out.println("A lista de alunos está vazia!");
        }
    }

    public static void main(String[] args) {
        // Criação da instância GerenciadorAlunos.
        var gerenciadorAlunos = new GerenciadorAlunos();

        // Inclusão de alunos ao gerenciador.
        gerenciadorAlunos.adicionarAluno("João", 123456L, 6.2);
        gerenciadorAlunos.adicionarAluno("Rui", 123457L, 8.5);
        gerenciadorAlunos.adicionarAluno("Maria", 123458L, 9.7);
        gerenciadorAlunos.adicionarAluno("Isabel", 123459L, 5.0);

        System.out.println("Exibindo alunos ordenados por nome:");
        gerenciadorAlunos.exibirAlunosPorNome();

        System.out.println();
        System.out.println("Exibindo alunos ordenados por média:");
        gerenciadorAlunos.exibirAlunosPorMedia();

        System.out.println();
        System.out.println("Tentativa de remoção de aluno inexistente:");
        gerenciadorAlunos.removerAluno(123452L);

        System.out.println();
        System.out.println("Remoção do aluno João de matrícula: 123456L.");
        gerenciadorAlunos.removerAluno(123456L);

        System.out.println("Exibindo lista de alunos atualizada (sem ordenação):");
        gerenciadorAlunos.exibirAlunos();
    }
}
