package list.ordenacao.ordenacao_de_numeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OrdenacaoNumeros {
    private List<Integer> numerosList;

    public OrdenacaoNumeros() {
        this.numerosList = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numerosList.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        if (!numerosList.isEmpty()) {
            List<Integer> numerosOrdemAscendente = new ArrayList<>(numerosList);
            Collections.sort(numerosOrdemAscendente);
            return numerosOrdemAscendente;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public List<Integer> ordenarDescendente() {
        if (!numerosList.isEmpty()) {
            List<Integer> numerosOrdemDescendente = new ArrayList<>(numerosList);
            numerosOrdemDescendente.sort(Collections.reverseOrder());
            return numerosOrdemDescendente;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirNumeros() {
        if (!numerosList.isEmpty()) {
            System.out.println(numerosList);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();
        ordenacaoNumeros.adicionarNumero(7);
        ordenacaoNumeros.adicionarNumero(3);
        ordenacaoNumeros.adicionarNumero(1);
        ordenacaoNumeros.adicionarNumero(10);
        ordenacaoNumeros.adicionarNumero(4);

        System.out.println("Lista de números (sem ordenação): ");
        ordenacaoNumeros.exibirNumeros();

        System.out.println();

        System.out.println("Números em ordem ascendente: ");
        System.out.println(ordenacaoNumeros.ordenarAscendente());

        System.out.println();

        System.out.println("Números em ordem descendente: ");
        System.out.println(ordenacaoNumeros.ordenarDescendente());
    }
}
