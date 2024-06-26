package map.operacoes_basicas.agenda_contatos;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        // O método put adiciona um par chave/valor, mas atualiza um valor se já existir uma chave idêntica.
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        } else {
            System.out.println("A agenda de contatos está vazia!");
        }
    }

    public void exibirContatos() {
        if (!agendaContatoMap.isEmpty()) {
            System.out.println(agendaContatoMap);
        } else {
            System.out.println("A agenda de contatos está vazia!");
        }
    }

    public Integer pesquisarPorNome(String nome) {
        Integer telefone = null;
        if (!agendaContatoMap.isEmpty()) {
            telefone = agendaContatoMap.get(nome);
            if (telefone == null) {
                System.out.println("Contato não encontrado na agenda!");
            }
        } else {
            System.out.println("A agenda de contatos está vazia!");
        }
        return telefone;
    }

    public static void main(String[] args) {

        var agenda = new AgendaContatos();
        agenda.exibirContatos();
        System.out.println();

        agenda.adicionarContato("Camila", 123456);
        agenda.adicionarContato("Camila", 5665);
        agenda.adicionarContato("Camila Cavalcante", 111111);
        agenda.adicionarContato("Camila DIO", 654987);
        agenda.adicionarContato("Maria Silva", 111111);

        System.out.println("Exibindo contatos após adicionar dados: ");
        agenda.exibirContatos();

        System.out.println();
        System.out.println("Atualizando o telefone de Camila: ");
        agenda.adicionarContato("Camila", 44444);
        agenda.exibirContatos();

        System.out.println();
        System.out.println("Removendo o contato Maria Silva.");
        agenda.removerContato("Maria Silva");
        agenda.exibirContatos();

        System.out.println("Exibindo telefone de Camila DIO: " + agenda.pesquisarPorNome("Camila DIO"));

        System.out.println();
        System.out.println("Tentando exibir telefone de contato inexistente: ");
        System.out.println(agenda.pesquisarPorNome("Carolina"));
    }
}
