package pedido;

import pedidoItem.PedidoItem;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private int numeroPedido;
    private Date dataHoraPedido;
    private double precoTotal;
    private int statusPedido;
    private ArrayList<PedidoItem> itensPedido;

    public Pedido(int numeroPedido, double precoTotal, int statusPedido) {
        this.numeroPedido = numeroPedido;
        this.dataHoraPedido = new Date();
        this.precoTotal = precoTotal;
        this.statusPedido = statusPedido;
        this.itensPedido = new ArrayList<>();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(Date dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(int statusPedido) {
        this.statusPedido = statusPedido;
    }

    public ArrayList<PedidoItem> getItensPedido() {
        return itensPedido;
    }

    public void inserirItensPedido(PedidoItem item) {
        if (item != null && item.atualizaEstoqueItem()) {
            this.itensPedido.add(item);
            this.statusPedido = 2;
            this.calcularTotalPagar();
        }
    }

    public void excluirItensPedido(PedidoItem item) {
        this.itensPedido.remove(item);
        this.calcularTotalPagar();
    }

    public double calcularTotalPagar() {
        double total = 0;
        for (PedidoItem item : this.itensPedido) {
            total += item.getPrecoItem() * item.getQuantidadeItem();
        }
        this.precoTotal = total;
        return total;
    }

    public boolean consultarPedido(Pedido pedido) {
        return this.numeroPedido == pedido.getNumeroPedido();
    }
}