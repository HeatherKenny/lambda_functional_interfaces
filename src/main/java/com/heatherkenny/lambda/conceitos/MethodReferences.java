package com.heatherkenny.lambda.conceitos;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {

    public static void executar() {
        System.out.println("\n== 4. Method references ==");

        Function<String, Integer> paraInteiro = Integer::parseInt;
        System.out.println("Integer::parseInt(\"42\"): " + paraInteiro.apply("42"));

        String prefixo = "Java: ";
        Function<String, String> concatenarComPrefixo = prefixo::concat;
        System.out.println("prefixo::concat -> " + concatenarComPrefixo.apply("lambdas"));

        Function<String, String> paraMaiusculo = String::toUpperCase;
        BiFunction<String, String, Boolean> comparar = String::equalsIgnoreCase;
        System.out.println("String::toUpperCase(\"heather\"): " + paraMaiusculo.apply("heather"));
        System.out.println("\"Java\".equalsIgnoreCase(\"JAVA\"): " + comparar.apply("Java", "JAVA"));

        Supplier<StringBuilder> criarBuilder = StringBuilder::new;
        StringBuilder sb = criarBuilder.get();
        sb.append("construído via method reference");
        System.out.println(sb);
    }
}
