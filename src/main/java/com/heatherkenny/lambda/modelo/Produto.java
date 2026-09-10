package com.heatherkenny.lambda.modelo;

public record Produto(String nome, String categoria, double preco) {

    @Override
    public String toString() {
        return "%-18s | %-12s | R$ %7.2f".formatted(nome, categoria, preco);
    }
}
