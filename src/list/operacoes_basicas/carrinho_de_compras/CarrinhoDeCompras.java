package list.operacoes_basicas.carrinho_de_compras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        if (itens.isEmpty()) {
            System.out.println("Não existem itens no carrinho ainda.");
        } else {
            List<Item> itensParaRemocao = new ArrayList<>();
            for (Item item : itens) {
                if (item.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemocao.add(item);
                }
            }
            itens.removeAll(itensParaRemocao);
        }
    }

    public double calcularValorTotal() {
        if (itens.isEmpty()) {
            throw new RuntimeException("Não existem itens no carrinho ainda.");
        } else {
            double valorTotal = 0.0;
            for (Item item : itens) {
                valorTotal += item.getPreco() * item.getQuantidade();
            }
            return valorTotal;
        }
    }

    public void exibirItens() {
        if (itens.isEmpty()) {
            System.out.println("Não existem itens no carrinho ainda.");
        } else {
            for (Item item : itens) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras.
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.removerItem("Lapiseira");

        // Adicionando itens ao carrinho.
        carrinho.adicionarItem("Caderno", 20.00, 2);
        carrinho.adicionarItem("Livro", 120.00, 1);
        carrinho.adicionarItem("Borracha", 1.00, 3);
        carrinho.adicionarItem("Lápis", 1.50, 6);
        carrinho.adicionarItem("Caderno", 20.00, 1);

        // Removendo itens do carrinho identificados pelo seu nome.
        carrinho.removerItem("Caderno");

        // Exibindo os itens atualizados do carrinho.
        carrinho.exibirItens();

        System.out.println("Valor total: R$" + String.format("%.2f", carrinho.calcularValorTotal()));

    }
}
