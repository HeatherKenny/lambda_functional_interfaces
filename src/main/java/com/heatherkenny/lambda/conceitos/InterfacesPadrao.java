package com.heatherkenny.lambda.conceitos;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class InterfacesPadrao {

    public static void executar() {
        System.out.println("\n== 3. Interfaces prontas do java.util.function ==");

        Function<String, Integer> tamanho = String::length;
        System.out.println("Function -> tamanho de \"lambda\": " + tamanho.apply("lambda"));

        BiFunction<Integer, Integer, Integer> somar = Integer::sum;
        System.out.println("BiFunction -> somar(4, 5): " + somar.apply(4, 5));

        Predicate<Integer> ehPar = n -> n % 2 == 0;
        System.out.println("Predicate -> 10 é par? " + ehPar.test(10));

        Consumer<String> imprimirEmMaiusculo = texto -> System.out.println("Consumer -> " + texto.toUpperCase());
        imprimirEmMaiusculo.accept("interfaces funcionais");

        Supplier<Double> numeroAleatorio = Math::random;
        System.out.println("Supplier -> gerou um double: " + (numeroAleatorio.get() >= 0));

        UnaryOperator<Integer> dobro = n -> n * 2;
        BinaryOperator<Integer> maior = BinaryOperator.maxBy(Integer::compareTo);
        System.out.println("UnaryOperator -> dobro de 21: " + dobro.apply(21));
        System.out.println("BinaryOperator -> maior entre 3 e 9: " + maior.apply(3, 9));

        Predicate<Integer> maiorQueDez = n -> n > 10;
        Predicate<Integer> parEMaiorQueDez = ehPar.and(maiorQueDez);
        Predicate<Integer> imparOuMenorIgualDez = ehPar.negate().or(maiorQueDez.negate());
        System.out.println("and() -> 12 é par e > 10? " + parEMaiorQueDez.test(12));
        System.out.println("negate() -> 12 é ímpar ou <= 10? " + imparOuMenorIgualDez.test(12));

        Function<Integer, Integer> maisUm = n -> n + 1;
        Function<Integer, Integer> vezesDois = n -> n * 2;
        System.out.println("andThen() -> " + maisUm.andThen(vezesDois).apply(5));
        System.out.println("compose() -> " + maisUm.compose(vezesDois).apply(5));
    }
}
