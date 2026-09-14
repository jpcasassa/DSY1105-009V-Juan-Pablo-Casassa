package modelos

class Box (
    val numero: Int,
    var estado: EstadoBox = EstadoBox.LIBRE,
    var paciente: Paciente? = null
)