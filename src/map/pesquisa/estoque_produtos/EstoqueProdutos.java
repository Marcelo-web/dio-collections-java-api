package map.pesquisa.estoque_produtos;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos() {
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotal = 0d;
        for (Produto produto : estoqueProdutosMap.values()) {
            valorTotal += produto.getPreco() * produto.getQuantidade();
        }
        return valorTotal;
    }

    // Aqui, considera-se que todos os produtos tem valores diferentes.
    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        for (Produto produto : estoqueProdutosMap.values()) {
            if (produto.getPreco() > maiorPreco) {
                maiorPreco = produto.getPreco();
                produtoMaisCaro = produto;
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        for (Produto produto : estoqueProdutosMap.values()) {
            if (produto.getPreco() < menorPreco) {
                menorPreco = produto.getPreco();
                produtoMaisBarato = produto;
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorValorTotalNoEstoque() {
        Produto produtoMaiorValorTotalNoEstoque = null;
        double maiorValorTotal = 0d;
        for (Produto p : estoqueProdutosMap.values()) {
            double valorTotal = p.getPreco() * p.getQuantidade();
            if (valorTotal > maiorValorTotal) {
                maiorValorTotal = valorTotal;
                produtoMaiorValorTotalNoEstoque = p;
            }
        }
        return produtoMaiorValorTotalNoEstoque;
    }


    public static void main(String[] args) {

        var estoque = new EstoqueProdutos();
        System.out.println("Valor total no estoque: R$ " + String.format("%.2f", estoque.calcularValorTotalEstoque()));

        System.out.println();
        System.out.println("Adicionando produtos ao estoque.");
        estoque.adicionarProduto(1L, "Smartphone", 1, 1500d);
        estoque.adicionarProduto(2L, "Pen Drive", 30, 120d);
        estoque.adicionarProduto(3L, "TV", 1, 2400d);

        System.out.println("Exibe todos os produtos: ");
        estoque.exibirProdutos();

        System.out.println();
        System.out.println("Exibe o produto mais caro: ");
        System.out.println(estoque.obterProdutoMaisCaro());

        System.out.println();
        System.out.println("Exibe o produto mais barato:");
        System.out.println(estoque.obterProdutoMaisBarato());

        System.out.println();
        System.out.println("Exibe o produto com maior valor total considerando a quantidade no estoque:");
        System.out.println(estoque.obterProdutoMaiorValorTotalNoEstoque());

        System.out.println();
        System.out.println("Valor total no estoque: R$ " + String.format("%.2f", estoque.calcularValorTotalEstoque()));
    }
}
