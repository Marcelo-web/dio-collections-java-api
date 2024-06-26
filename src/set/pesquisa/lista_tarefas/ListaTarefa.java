package set.pesquisa.lista_tarefas;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefa {
    private Set<Tarefa> tarefaSet;

    public ListaTarefa() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        if (!tarefaSet.isEmpty()) {
            Tarefa tarefaParaSerRemovida = null;
            for (Tarefa tarefa : tarefaSet) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaSerRemovida = tarefa;
                    break;
                }
            }
            tarefaSet.remove(tarefaParaSerRemovida);
        } else {
            System.out.println("A lista de tarefas encontra-se vazia!");
        }
    }

    public void exibirTarefas() {
        if (!tarefaSet.isEmpty()) {
            System.out.println(tarefaSet);
        } else {
            System.out.println("A lista de tarefas encontra-se vazia!");
        }
    }

    public int contarTarefas() {
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        if (!tarefaSet.isEmpty()) {
            Set<Tarefa> tarefasConcluidas = new HashSet<>();
            for (Tarefa tarefa : tarefaSet) {
                if (tarefa.isConcluida()) {
                    tarefasConcluidas.add(tarefa);
                }
            }
            return tarefasConcluidas;
        }
        throw new RuntimeException("A lista de tarefas encontra-se vazia!");
    }

    public Set<Tarefa> obterTarefasPendentes() {
        if (!tarefaSet.isEmpty()) {
            Set<Tarefa> tarefasPendentes = new HashSet<>();
            for (Tarefa tarefa : tarefaSet) {
                if (!tarefa.isConcluida()) {
                    tarefasPendentes.add(tarefa);
                }
            }
            return tarefasPendentes;
        }
        throw new RuntimeException("A lista de tarefas encontra-se vazia!");
    }

    public void marcarTarefaConcluida(String descricao) {
        if (!tarefaSet.isEmpty()) {
            for (Tarefa tarefa : tarefaSet) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                    if (!tarefa.isConcluida()) {
                        tarefa.setConcluida(true);
                        break;
                    }
                }
            }
        } else {
            throw new RuntimeException("A lista de tarefas encontra-se vazia!");
        }
    }

    public void marcarTarefaPendente(String descricao) {
        if (!tarefaSet.isEmpty()) {
            for (Tarefa tarefa : tarefaSet) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                    if (tarefa.isConcluida()) {
                        tarefa.setConcluida(false);
                        break;
                    }
                }
            }
        } else {
            throw new RuntimeException("A lista de tarefas encontra-se vazia!");
        }
    }

    public void limparListaTarefas() {
        if (!tarefaSet.isEmpty()) {
            tarefaSet.clear();
        } else {
            System.out.println("A lista de tarefas encontra-se vazia!");
        }
    }

    public static void main(String[] args) {
        var listaTarefas = new ListaTarefa();
        listaTarefas.exibirTarefas();

        listaTarefas.adicionarTarefa("Ir na academia");
        listaTarefas.adicionarTarefa("Terminar atividade da DIO");
        listaTarefas.adicionarTarefa("Fazer compras");
        listaTarefas.adicionarTarefa("Fazer caminhada");
        listaTarefas.adicionarTarefa("Estudar Java");

        listaTarefas.exibirTarefas();
        System.out.println("Existe(m) " + listaTarefas.contarTarefas() + " tarefa(s).");

        System.out.println();
        System.out.println("Tornando as atividades, ir na academia, terminar atividade da DIO e fazer compras como concluídas.");
        listaTarefas.marcarTarefaConcluida("Ir na academia");
        listaTarefas.marcarTarefaConcluida("Terminar atividade da DIO");
        listaTarefas.marcarTarefaConcluida("Fazer compras");

        System.out.println("Exibir tarefas concluídas: ");
        System.out.println(listaTarefas.obterTarefasConcluidas());

        System.out.println();
        System.out.println("Exibir tarefas pendentes: ");
        System.out.println(listaTarefas.obterTarefasPendentes());

        System.out.println();
        System.out.println("Tornando fazer compras pendente.");
        listaTarefas.marcarTarefaPendente("Fazer compras");

        System.out.println("Tornando estudar Java concluído.");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        System.out.println();
        System.out.println("Removendo a tarefa ir na academia.");
        listaTarefas.removerTarefa("Ir na academia");

        System.out.println("Listando todas as tarefas.");
        listaTarefas.exibirTarefas();

        System.out.println();
        System.out.println("Removendo todas as tarefas.");
        listaTarefas.limparListaTarefas();

        listaTarefas.exibirTarefas();
        System.out.println("Total de tarefas: " + listaTarefas.contarTarefas());
    }
}
