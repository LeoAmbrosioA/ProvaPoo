import categoria.Categoria;
import pedido.Pedido;
import pedidoItem.PedidoItem;
import poduto.Produto;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criar objetos de Categoria
        Categoria categoria1 = new Categoria("Liquidos");
        Categoria categoria2 = new Categoria("Comidas");

        // Criar objetos de Produto
        Produto produto1 = new Produto("Bebida", 4.5, "Bebida Nomal", 100, categoria1);
        Produto produto2 = new Produto("Macarrao", 6.0, "Comidas ", 50, categoria2);
        Produto produto3 = new Produto("chocolate", 3.0, "Comidas ", 30, categoria2);
        Produto produto4 = new Produto("Água ", 1.0, "Água Mineral", 80, categoria1);
        Produto produto5 = new Produto("bala", 4.5, "Doce", 40, categoria2);

        // Criar objetos de PedidoItem
        PedidoItem item1 = new PedidoItem("Liquidos", 1, produto1.getPrecoProduto());
        PedidoItem item2 = new PedidoItem("Liquidos", 2, produto2.getPrecoProduto());
        PedidoItem item3 = new PedidoItem("Liquidos", 1, produto3.getPrecoProduto());
        PedidoItem item4 = new PedidoItem("Água ", 5, produto4.getPrecoProduto());

        // Criar objetos de Pedido
        Pedido pedido1 = new Pedido(1, 0, 1);
        Pedido pedido2 = new Pedido(2, 0, 1);

        // Adicionar produtos a um ArrayList de Produtos
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(produto1);
        listaProdutos.add(produto2);
        listaProdutos.add(produto3);
        listaProdutos.add(produto4);
        listaProdutos.add(produto5);

        // Adicionar pedidos a um ArrayList de Pedidos
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        // Inserir itens nos pedidos
        pedido1.inserirItensPedido(item1);
        pedido1.inserirItensPedido(item2);
        pedido1.inserirItensPedido(item3);

        pedido2.inserirItensPedido(item2);
        pedido2.inserirItensPedido(item4);

        // Imprimir informações no terminal
        System.out.println("Lista de Produtos:");
        for (Produto produto : listaProdutos) {
            System.out.println("Nome do produto: " + produto.getNomeProduto());
            System.out.println("Valor: " + produto.getPrecoProduto());
            System.out.println("Numeração: " + produto.getDescProduto());
            System.out.println("Estoque : " + produto.getEstoqueAtual());
            System.out.println("Categoria: " + produto.getCategoria().getDescCategoria());
            System.out.println("---------------------------");
        }

        System.out.println("\nLista de Pedidos:");
        for (Pedido pedido : listaPedidos) {
            System.out.println("Número de Pedido: " + pedido.getNumeroPedido());
            System.out.println("Data e Hora : " + pedido.getDataHoraPedido());
            System.out.println("Preço Completo: " + pedido.getPrecoTotal());
            System.out.println("Status : " + pedido.getStatusPedido());
            System.out.println("Itens Pedido:");
            for (PedidoItem item : pedido.getItensPedido()) {
                System.out.println("  Nome  Item: " + item.getNomeItem());
                System.out.println("  Quantidade: " + item.getQuantidadeItem());
                System.out.println("  Preço Unico: " + item.getPrecoItem());
                System.out.println("---------------------------");
            }
            System.out.println("---------------------------");
        }
    }
}
