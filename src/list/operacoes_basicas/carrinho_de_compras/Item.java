package list.operacoes_basicas.carrinho_de_compras;

public class Item {
    private String nome;
    private double preco;
    private int quantidade;

    public Item(String nome, double preco, int quantidade) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return nome + "\nPreco:" + preco + "\nQuantidade: " + quantidade + "\n";
    }
}
