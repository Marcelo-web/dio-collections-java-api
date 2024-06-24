package list.pesquisa.soma_de_numeros;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    List<Integer> numerosList;

    public SomaNumeros() {
        this.numerosList = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numerosList.add(numero);
    }

    public int calcularSoma() {
        int soma = 0;
        if (!numerosList.isEmpty()) {
            for (Integer numero : numerosList) {
                soma += numero;
            }
        } else {
            throw new RuntimeException("A lista está vazia");
        }
        return soma;
    }

    public int encontrarMaiorNumero() {
        if (!numerosList.isEmpty()) {
            int maiorNumero = Integer.MIN_VALUE;
            for (Integer numero : numerosList) {
                if (numero >= maiorNumero) {
                    maiorNumero = numero;
                }
            }
            return maiorNumero;
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public int encontrarMenorNumero() {
        if (!numerosList.isEmpty()) {
            int menorNumero = Integer.MAX_VALUE;
            for (Integer numero : numerosList) {
                if (numero <= menorNumero) {
                    menorNumero = numero;
                }
            }
            return menorNumero;
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public void exibirNumeros() {
        if (!numerosList.isEmpty()) {
            System.out.println(numerosList);
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe SomaNumeros.
        SomaNumeros somaNumeros = new SomaNumeros();

        // Adicionando números à lista.
        somaNumeros.adicionarNumero(2);
        somaNumeros.adicionarNumero(3);
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(1);
        somaNumeros.adicionarNumero(4);

        // Exibindo a lista de números adicionados.
        System.out.print("Números adicionados: ");
        somaNumeros.exibirNumeros();

        // Exibindo a soma dos números da lista.
        System.out.println("A soma dos números é " + somaNumeros.calcularSoma());

        // Encontrando o maior número da lista.
        System.out.println("O maior número da lista é " + somaNumeros.encontrarMaiorNumero());

        // Encontrando o menor número da lista.
        System.out.println("O menor número da lista é " + somaNumeros.encontrarMenorNumero());
    }
}
