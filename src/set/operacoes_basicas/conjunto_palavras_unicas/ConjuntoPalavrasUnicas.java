package set.operacoes_basicas.conjunto_palavras_unicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavrasUnicasSet.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if (!palavrasUnicasSet.isEmpty()) {
            if (palavrasUnicasSet.contains(palavra)) {
                palavrasUnicasSet.remove(palavra);
            } else {
                System.out.println("Palavra não encontrada no conjunto!");
            }
        } else {
            System.out.println("O conjunto de palavras encontra-se vazio!");
        }
    }

    public boolean verificarPalavra(String palavra) {
        return palavrasUnicasSet.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        if (!palavrasUnicasSet.isEmpty()) {
            System.out.println(palavrasUnicasSet);
        } else {
            System.out.println("O conjunto de palavras encontra-se vazio!");
        }
    }

    public static void main(String[] args) {
        var conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();
        // Confirmando o conjunto vazio inicialmente.
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        // Adicionando palavras ao conjunto.
        conjuntoPalavrasUnicas.adicionarPalavra("Java");
        conjuntoPalavrasUnicas.adicionarPalavra("PHP");
        conjuntoPalavrasUnicas.adicionarPalavra("PHP");
        conjuntoPalavrasUnicas.adicionarPalavra("Python");

        // Exibindo as palavras.
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        // Verificando se uma palavra existe no conjunto.
        boolean temPalavra = conjuntoPalavrasUnicas.verificarPalavra("Java");
        System.out.println("Tem a palavra Java ? " + (temPalavra ? "Sim" : "Não"));

        temPalavra = conjuntoPalavrasUnicas.verificarPalavra("C#");
        System.out.println("Tem a palavra C# ? " + (temPalavra ? "Sim" : "Não"));

        // Tentativa de remoção de palavra inexistente no conjunto.
        conjuntoPalavrasUnicas.removerPalavra("C#");

        // Removendo uma palavra do conjunto.
        conjuntoPalavrasUnicas.removerPalavra("PHP");

        // Exibindo o conjunto de palavras atualizadas.
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();
    }
}
