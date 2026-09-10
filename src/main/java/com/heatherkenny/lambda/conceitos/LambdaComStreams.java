package com.heatherkenny.lambda.conceitos;

import com.heatherkenny.lambda.modelo.Produto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaComStreams {

    public static void executar() {
        System.out.println("\n== 6. Lambdas + Streams ==");

        List<Produto> produtos = List.of(
                new Produto("Mouse sem fio", "Periféricos", 79.90),
                new Produto("Teclado mecânico", "Periféricos", 249.90),
                new Produto("Monitor 27\"", "Monitores", 1199.00),
                new Produto("Cabo HDMI", "Acessórios", 29.90),
                new Produto("Webcam Full HD", "Periféricos", 189.90),
                new Produto("Suporte para monitor", "Acessórios", 89.00)
        );

        System.out.println("-- Periféricos, mais barato primeiro --");
        produtos.stream()
                .filter(p -> p.categoria().equals("Periféricos"))
                .sorted(Comparator.comparingDouble(Produto::preco))
                .forEach(System.out::println);

        double totalAcimaDeCem = produtos.stream()
                .map(Produto::preco)
                .filter(preco -> preco > 100)
                .reduce(0.0, Double::sum);
        System.out.println("\nSoma acima de R$100: R$ " + "%.2f".formatted(totalAcimaDeCem));

        Map<String, List<String>> nomesPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(
                        Produto::categoria,
                        Collectors.mapping(Produto::nome, Collectors.toList())));
        System.out.println("\nPor categoria:");
        nomesPorCategoria.forEach((categoria, nomes) -> System.out.println("  " + categoria + " -> " + nomes));

        Function<Produto, String> etiqueta = p -> "%s (R$ %.2f)".formatted(p.nome(), p.preco());
        String maisCaro = produtos.stream()
                .max(Comparator.comparingDouble(Produto::preco))
                .map(etiqueta)
                .orElse("nenhum produto");
        System.out.println("\nMais caro: " + maisCaro);
    }
}
