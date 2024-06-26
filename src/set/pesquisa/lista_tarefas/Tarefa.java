package set.pesquisa.lista_tarefas;

import java.util.Objects;

public class Tarefa {
    private String descricao;
    private Boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }

    public Boolean isConcluida() {
        return concluida;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa tarefa)) return false;
        return Objects.equals(getDescricao(), tarefa.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDescricao());
    }

    @Override
    public String toString() {
        String conclusao = concluida ? "Sim" : "Não";
        return "{Descrição=" + descricao + ", Concluída=" + conclusao + "}";
    }
}
