package set.ordenacao.cadastro_produtos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
        produtoSet.add(new Produto(codigo, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        if (!produtoSet.isEmpty()) {
            // permite organizar nomes em ordem ascendente pelo uso de TreeSet e da interface Comparable em Produto.
            Set<Produto> produtosPorNomeOrdemAscendente = new TreeSet<>(produtoSet);
            return produtosPorNomeOrdemAscendente;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Produto> exibirProdutosPorPreco() {
        if (!produtoSet.isEmpty()) {
            Set<Produto> produtosPorPrecoOrdemAscendente = new TreeSet<>(new PrecoComparator());
            produtosPorPrecoOrdemAscendente.addAll(produtoSet);
            return produtosPorPrecoOrdemAscendente;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância do CadastroProdutos
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        // Adicionando produtos ao cadastro
        cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
        cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
        cadastroProdutos.adicionarProduto(1L, "Mouse", 30d, 20);
        cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);

        // Exibindo todos os produtos no cadastro
        System.out.println(cadastroProdutos.produtoSet);

        // Exibindo produtos ordenados por nome
        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        // Exibindo produtos ordenados por preço
        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }
}
