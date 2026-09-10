package com.heatherkenny.lambda;

import com.heatherkenny.lambda.conceitos.ClosuresEEscopo;
import com.heatherkenny.lambda.conceitos.InterfaceFuncionalPropria;
import com.heatherkenny.lambda.conceitos.InterfacesPadrao;
import com.heatherkenny.lambda.conceitos.LambdaBasico;
import com.heatherkenny.lambda.conceitos.LambdaComStreams;
import com.heatherkenny.lambda.conceitos.MethodReferences;

/**
 * Ponto de entrada: roda, em ordem, cada demonstração sobre lambdas e
 * interfaces funcionais em Java.
 */
public class Main {

    public static void main(String[] args) {
        LambdaBasico.executar();
        InterfaceFuncionalPropria.executar();
        InterfacesPadrao.executar();
        MethodReferences.executar();
        ClosuresEEscopo.executar();
        LambdaComStreams.executar();
    }
}
