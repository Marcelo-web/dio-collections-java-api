package set.operacoes_basicas.conjunto_de_convidados;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        if (!convidadoSet.isEmpty()) {
             Convidado convidadoParaRemover = null;
             for(Convidado convidado : convidadoSet) {
                 if(convidado.getCodigoConvite() == codigoConvite) {
                     convidadoParaRemover = convidado;
                     break;
                 }
             }
             convidadoSet.remove(convidadoParaRemover);
        } else {
            throw new RuntimeException("O conjunto de convidados encontra-se vazio!");
        }
    }

    public int contarConvidados() {
       return convidadoSet.size();
    }

    public void exibirConvidados() {
        if(!convidadoSet.isEmpty()) {
            System.out.println(convidadoSet);
        } else {
            System.out.println("O conjunto de convidados encontra-se vazio!");
        }
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        conjuntoConvidados.adicionarConvidado("Convidado1", 1234);
        conjuntoConvidados.adicionarConvidado("Convidado2", 1235);
        conjuntoConvidados.adicionarConvidado("Convidado3", 1235);
        conjuntoConvidados.adicionarConvidado("Convidado4", 1236);

        System.out.println("Total de convidados inicialmente: ");
        System.out.println("Existe(m) " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set.");
        System.out.println();

        System.out.println("Removendo um convidado pelo código do convite: ");
        conjuntoConvidados.removerConvidadoPorCodigoConvite(1234);
        System.out.println("Existe(m) " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set.");
        System.out.println();

        System.out.println("Exibindo a lista de convidados atualizada: ");
        conjuntoConvidados.exibirConvidados();
    }
}
