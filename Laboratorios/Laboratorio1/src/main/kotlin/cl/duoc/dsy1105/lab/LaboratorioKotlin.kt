
package cl.duoc.dsy1105.lab

fun main() {
    val modelo = "Galaxy A55"
    val bateria = 18
    val ahorroEnergia = false
    val propietario: String? = null
    val cargando = true

    println("=== TELÉFONO ===")
    println("Modelo: $modelo")
    println("Batería: $bateria%")
    println("Estado: ${obtenerEstadoBateria(bateria)}")
    println("Ahorro de energía: $ahorroEnergia")
    println("Propietario: ${propietario ?: "Sin propietario"}")

    if (cargando) {
        println("El teléfono está conectado al cargador")
    }
}

fun obtenerEstadoBateria(bateria: Int): String {
    return if (bateria < 20) {
        "Batería baja"
    } else if (bateria < 80) {
        "Batería suficiente"
    } else {
        "Batería alta"
    }
}
