package com.heatherkenny.lambda.interfaces;

// java.util.function só vai até BiFunction (2 parâmetros)
@FunctionalInterface
public interface TransformadorTriplo<A, B, C, R> {
    R aplicar(A a, B b, C c);
}
