package modelos

class Paciente(
    val nombre: String,
    val edad: Int,
    val codigo: String,
    val tipo: TipoPaciente,
    val tipoDueno: TipoDueno,
    val esSilvestre: Boolean = false
)