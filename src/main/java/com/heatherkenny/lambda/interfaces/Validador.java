package com.heatherkenny.lambda.interfaces;

@FunctionalInterface
public interface Validador<T> {

    boolean validar(T valor);

    default Validador<T> e(Validador<T> outro) {
        return valor -> this.validar(valor) && outro.validar(valor);
    }

    default Validador<T> negar() {
        return valor -> !this.validar(valor);
    }

    static <T> Validador<T> de(Validador<T> validador) {
        return validador;
    }
}
