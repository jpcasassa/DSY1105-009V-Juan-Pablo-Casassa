# Laboratorio 1

Este laboratorio muestra el desarrollo de un mismo programa usando Java y Kotlin.

El ejemplo representa un telefono con datos simples como modelo, bateria, ahorro de energia, propietario y estado de carga.

## Objetivo

Comparar como se escribe una solucion sencilla en Java y en Kotlin, observando que Kotlin permite escribir menos codigo y manejar algunas situaciones de forma mas directa.

## Archivos principales

- `LaboratorioJava.java`: version desarrollada en Java.
- `LaboratorioKotlin.kt`: version desarrollada en Kotlin.

## Desarrollo en Java

En Java el programa se escribe dentro de una clase:

```java
public class LaboratorioJava
```

El punto de inicio es el metodo `main`:

```java
public static void main(String[] args)
```

Java requiere escribir mas estructura para iniciar el programa. Tambien se debe revisar manualmente si una variable puede ser `null`, como ocurre con el propietario:

```java
if (propietario == null) {
    System.out.println("Propietario: Sin propietario");
} else {
    System.out.println("Propietario: " + propietario);
}
```

Esto funciona correctamente, pero ocupa mas lineas de codigo.

## Desarrollo en Kotlin

En Kotlin el programa puede iniciar directamente con:

```kotlin
fun main()
```

No es necesario crear una clase para este caso simple. Las variables tambien se escriben de forma mas corta:

```kotlin
val modelo = "Galaxy A55"
val bateria = 18
val ahorroEnergia = false
```

Kotlin tambien hace mas simple el manejo de valores nulos. En vez de usar un `if` completo, se puede usar el operador `?:`:

```kotlin
println("Propietario: ${propietario ?: "Sin propietario"}")
```

Esto significa que si `propietario` tiene un valor, se muestra ese valor. Si es `null`, se muestra `"Sin propietario"`.

## Comparacion

Java es claro y estructurado, pero necesita mas codigo para tareas simples.

Kotlin permite escribir el mismo programa de una forma mas breve y directa. Para este ejemplo, Kotlin resulta mas sencillo porque:

- No necesita declarar una clase para el `main`.
- Usa menos lineas de codigo.
- Permite insertar variables dentro del texto con `$`.
- Maneja valores nulos de forma mas simple con `?:`.
- Las funciones pueden escribirse de forma mas compacta.

## Funcion principal del ejemplo

Ambas versiones usan una funcion llamada `obtenerEstadoBateria`.

Esta funcion recibe el porcentaje de bateria y devuelve un mensaje:

- `Bateria baja` si es menor a 20%.
- `Bateria suficiente` si es menor a 80%.
- `Bateria alta` si es 80% o mas.

## Salida esperada

```text
=== TELEFONO ===
Modelo: Galaxy A55
Bateria: 18%
Estado: Bateria baja
Ahorro de energia: false
Propietario: Sin propietario
El telefono esta conectado al cargador
```

## Conclusion

Java y Kotlin permiten resolver el mismo problema, pero Kotlin hace que el codigo sea mas corto y facil de leer en programas simples como este.
