package cl.duoc.dsy1105.lab

fun main() {
    val modelo = "Galaxy A55"
    val bateria = 18
    val ahorroEnergia = false
    val propietario: String? = null
    val cargando = true

    println("=== TELEFONO ===")
    println("Modelo: $modelo")
    println("Bateria: $bateria%")
    println("Estado: ${obtenerEstadoBateria(bateria)}")
    println("Ahorro de energia: $ahorroEnergia")
    println("Propietario: ${propietario ?: "Sin propietario"}")

    if (cargando) {
        println("El telefono esta conectado al cargador")
    }
}

fun obtenerEstadoBateria(bateria: Int): String {
    return if (bateria < 20) {
        "Bateria baja"
    } else if (bateria < 80) {
        "Bateria suficiente"
    } else {
        "Bateria alta"
    }
}
