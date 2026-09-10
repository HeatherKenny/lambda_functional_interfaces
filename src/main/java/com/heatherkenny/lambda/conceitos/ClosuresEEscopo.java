package com.heatherkenny.lambda.conceitos;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class ClosuresEEscopo {

    public static void executar() {
        System.out.println("\n== 5. Closures e effectively final ==");

        int limite = 10;
        Supplier<String> mensagem = () -> "limite capturado: " + limite;
        System.out.println(mensagem.get());

        // int contador = 0;
        // Runnable incrementa = () -> contador++; // não compila
        // contador = 5;

        AtomicInteger contador = new AtomicInteger(0);
        IntSupplier proximo = contador::incrementAndGet;
        System.out.println(proximo.getAsInt() + ", " + proximo.getAsInt() + ", " + proximo.getAsInt());
    }
}
