package com.condadofx.condado.model.entities;

import java.time.LocalDate;

public class Pedido {
    private int id_pedido;
    private String id_cliente;
    private LocalDate data_pedido;
    private String forma_pagamento;
    private double preco_pedido;

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDate getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(LocalDate data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public double getPreco_pedido() {
        return preco_pedido;
    }

    public void setPreco_pedido(double preco_pedido) {
        this.preco_pedido = preco_pedido;
    }
}
