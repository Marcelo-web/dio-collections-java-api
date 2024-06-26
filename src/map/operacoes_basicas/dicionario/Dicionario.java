package map.operacoes_basicas.dicionario;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            String valor = dicionarioMap.remove(palavra);
            if (valor == null) {
                System.out.println("Palavra não encontrada para remoção no dicionário!");
            }
        } else {
            System.out.println("O dicionário está vazio!");
        }
    }

    public void exibirPalavras() {
        if (!dicionarioMap.isEmpty()) {
            System.out.println(dicionarioMap);
        } else {
            System.out.println("O dicionário está vazio!");
        }
    }

    public String pesquisarPorPalavra(String palavra) {
        String palavraDicionario = null;
        if (!dicionarioMap.isEmpty()) {
            palavraDicionario = dicionarioMap.get(palavra);
            if (palavraDicionario == null) {
                return "Palavra não encontrada no dicionário!";
            }
        } else {
            return "O dicionário está vazio!";
        }
        return palavraDicionario;
    }

    public static void main(String[] args) {
        // Cria uma instância de Dicionário
        Dicionario dicionario = new Dicionario();
        dicionario.exibirPalavras();

        // Adiciona palavras ao Dicionário.
        dicionario.adicionarPalavra("Classe", "coleção de dados constituídos por seus atributos e métodos");
        dicionario.adicionarPalavra("Atributo", "define as características de uma classe");
        dicionario.adicionarPalavra("Método", "componente responsável por executar alguma ação dentro de uma classe.");

        // Exibe todas as palavras com suas definições contidas no dicionário.
        dicionario.exibirPalavras();

        System.out.println();
        System.out.println("Busca definição da palavra 'atributo' em orientação a objetos: ");
        System.out.println(dicionario.pesquisarPorPalavra("Atributo"));

        System.out.println();
        System.out.println("Tentativa de busca por uma palavra inexistente no dicionário: ");
        System.out.println(dicionario.pesquisarPorPalavra("Objeto"));

        System.out.println();
        System.out.println("Tentativa de remoção por palavra inexistente no dicionário: ");
        dicionario.removerPalavra("Construtor");

        System.out.println();
        System.out.println("Atualização da definição de método no dicionário.");
        dicionario.adicionarPalavra("Método", "representa um evento de ação dentro de uma classe.");

        System.out.println("Exibindo todo o dicionário: ");
        dicionario.exibirPalavras();
    }
}
