package modelos

class Veterinaria {
    val boxes = mutableListOf<Box>()

    init {
        for (numero in 1..10){
            boxes.add(Box(numero))
        }
    }

    fun buscarBoxLibre(): Box? {

        for (box in boxes){
            if (box.estado == EstadoBox.LIBRE){
                return box
            }
        }
        return null
    }

    fun asignarBox(paciente: Paciente): Box? {

        for (box in boxes) {
            if (box.estado == EstadoBox.LIBRE) {
                box.estado = EstadoBox.EN_ATENCION
                box.paciente = paciente
                return box
            }
        }

        return null
    }

    fun liberarBox(numeroBox: Int): Boolean {

        for(box in boxes) {
            if (box.numero == numeroBox) {
                box.estado = EstadoBox.LIBRE
                box.paciente = null
                return true
            }
        }
        return false
    }
}