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
}