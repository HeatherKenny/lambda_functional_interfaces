package com.heatherkenny.lambda.conceitos;

import com.heatherkenny.lambda.interfaces.TransformadorTriplo;
import com.heatherkenny.lambda.interfaces.Validador;

public class InterfaceFuncionalPropria {

    public static void executar() {
        System.out.println("\n== 2. Interface funcional própria ==");

        Validador<String> naoVazio = texto -> texto != null && !texto.isBlank();
        Validador<String> tamanhoMinimo = texto -> texto.length() >= 3;

        Validador<String> nomeValido = naoVazio.e(tamanhoMinimo);
        Validador<String> nomeInvalido = nomeValido.negar();

        for (String candidato : new String[]{"", "oi", "Beatriz"}) {
            System.out.println("\"" + candidato + "\" é um nome válido? " + nomeValido.validar(candidato));
        }
        System.out.println("\"oi\" é inválido (negar())? " + nomeInvalido.validar("oi"));

        TransformadorTriplo<Integer, Integer, Integer, Integer> mediaPonderada =
                (nota1, nota2, nota3) -> Math.round((nota1 + nota2 * 2 + nota3 * 3) / 6f);

        System.out.println("Média ponderada (7, 8, 9): " + mediaPonderada.aplicar(7, 8, 9));
    }
}
