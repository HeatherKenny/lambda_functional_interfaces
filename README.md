# Lambda & Interfaces Funcionais

Analogia: lambda é dar uma instrução rápida sem precisar escrever um manual inteiro. Em vez de uma classe anônima de 5 linhas pra dizer "ordene por tamanho", uma linha: `(a, b) -> a.length - b.length()`.

Java 17 puro, sem framework — projeto pra demonstrar domínio do tema: lambdas, interfaces funcionais do `java.util.function`, interfaces funcionais próprias, method references, closures e uso com Streams.

## Rodando

```
mvn compile exec:java
```

Sem Maven:

```
javac -d out $(find src -name "*.java") && java -cp out com.heatherkenny.lambda.Main
```

## Estrutura

| Classe | Conceito |
| --- | --- |
| `LambdaBasico` | classe anônima vs lambda, variações de sintaxe |
| `InterfaceFuncionalPropria` | quando vale criar sua própria interface funcional |
| `InterfacesPadrao` | Function, BiFunction, Predicate, Consumer, Supplier, UnaryOperator, BinaryOperator + composição |
| `MethodReferences` | os 4 tipos de `::` |
| `ClosuresEEscopo` | regra do effectively final |
| `LambdaComStreams` | tudo junto num pipeline de Stream |

`interfaces/Validador` e `interfaces/TransformadorTriplo` são as interfaces funcionais próprias usadas nos exemplos.
