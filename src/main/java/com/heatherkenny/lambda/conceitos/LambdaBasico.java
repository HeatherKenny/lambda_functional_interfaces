package com.heatherkenny.lambda.conceitos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class LambdaBasico {

    public static void executar() {
        System.out.println("== 1. Lambda básico: classe anônima vs lambda ==");

        List<String> palavras = new ArrayList<>(
                List.of("abacaxi", "uva", "melancia", "kiwi", "banana"));

        Comparator<String> porTamanhoAntigo = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        };

        Comparator<String> porTamanhoLambda = (a, b) -> a.length() - b.length();

        List<String> copia1 = new ArrayList<>(palavras);
        List<String> copia2 = new ArrayList<>(palavras);
        copia1.sort(porTamanhoAntigo);
        copia2.sort(porTamanhoLambda);
        System.out.println("Ordenado (classe anônima): " + copia1);
        System.out.println("Ordenado (lambda):          " + copia2);
        System.out.println("Resultado é idêntico: " + copia1.equals(copia2));

        Runnable semParametro = () -> System.out.println("lambda sem parâmetro");
        Function<Integer, Integer> quadrado = n -> n * n;
        Comparator<Integer> comBloco = (a, b) -> {
            int diferenca = a - b;
            return diferenca;
        };

        semParametro.run();
        System.out.println("quadrado.apply(6): " + quadrado.apply(6));
        System.out.println("comBloco.compare(10, 3): " + comBloco.compare(10, 3));
    }
}
