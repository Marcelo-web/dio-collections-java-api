package set.pesquisa.agenda_contatos;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        if (!contatoSet.isEmpty()) {
            System.out.println(contatoSet);
        } else {
            System.out.println("O conjunto de contatos está vazio!");
        }
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        if (!contatoSet.isEmpty()) {
            Set<Contato> contatosPorNome = new HashSet<>();
            for (Contato contato : contatoSet) {
                if (contato.getNome().startsWith(nome)) {
                    contatosPorNome.add(contato);
                }
            }
            return contatosPorNome;
        } else {
            throw new RuntimeException("O conjunto de contatos está vazio!");
        }
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        if (!contatoSet.isEmpty()) {
            Contato contatoAtualizado = null;
            for (Contato contato : contatoSet) {
                if (contato.getNome().equalsIgnoreCase(nome)) {
                    contato.setNumeroTelefone(novoNumero);
                    contatoAtualizado = contato;
                    break;
                }
            }
            return contatoAtualizado;
        } else {
            throw new RuntimeException("O conjunto de contatos está vazio!");
        }
    }

    public static void main(String[] args) {

        var agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Camila", 123456);
        agendaContatos.adicionarContato("Camila", 5665);
        agendaContatos.adicionarContato("Camila Cavalcante", 1111111);
        agendaContatos.adicionarContato("Camila DIO", 654987);
        agendaContatos.adicionarContato("Maria Silva", 1111111);

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Camila"));

        Contato contatoAtualizado = agendaContatos.atualizarNumeroContato("Maria Silva", 5555555);
        System.out.println("Contato atualizado: " + contatoAtualizado);

        agendaContatos.exibirContatos();

    }
}
