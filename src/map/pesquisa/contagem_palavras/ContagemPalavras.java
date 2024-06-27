package map.pesquisa.contagem_palavras;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> palavrasMap;

    public ContagemPalavras() {
        this.palavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        palavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        palavrasMap.remove(palavra);
    }

    public int exibirContagemPalavras() {
        int contagemTotal = 0;
        for (int contagem : palavrasMap.values()) {
            contagemTotal += contagem;
        }
        return contagemTotal;
    }

    public String encontrarPalavraMaisFrequente() {
        if (!palavrasMap.isEmpty()) {
            int maiorContagem = 0;
            String palavraMaiorFrequencia = null;
            for (Map.Entry<String, Integer> entry : palavrasMap.entrySet()) {
                if (entry.getValue() > maiorContagem) {
                    maiorContagem = entry.getValue();
                    palavraMaiorFrequencia = entry.getKey();
                }
            }
            return palavraMaiorFrequencia;
        }
        return "O map encontra-se vazio";
    }


    public static void main(String[] args) {

        ContagemPalavras contagemPalavras = new ContagemPalavras();
        System.out.println("Palavra mais frequente: " + contagemPalavras.encontrarPalavraMaisFrequente());

        contagemPalavras.adicionarPalavra("PHP", 5);
        contagemPalavras.adicionarPalavra("Java", 20);
        contagemPalavras.adicionarPalavra("Python", 17);
        contagemPalavras.adicionarPalavra("C#", 15);

        System.out.println("Contagem de palavras: " + contagemPalavras.exibirContagemPalavras());
        System.out.println("Palavra mais frequente: " + contagemPalavras.encontrarPalavraMaisFrequente());

        System.out.println();
        System.out.println("Removendo " + contagemPalavras.palavrasMap.get("PHP") + " palavras com o nome PHP.");
        contagemPalavras.removerPalavra("PHP");

        System.out.println("Contagem de palavras: " + contagemPalavras.exibirContagemPalavras());
    }
}
