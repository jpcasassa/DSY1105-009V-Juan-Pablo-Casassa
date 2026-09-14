package modelos

data class Tarifa(
    val tipoPaciente: TipoPaciente,
    val montoPorHora: Int
) {
    fun calcularCosto(paciente: Paciente, minutos: Int): Int {
        if (paciente.tipo == TipoPaciente.FELINO && minutos < 20) {
            return 0
        }

        var costo = montoPorHora * minutos / 60

        if (paciente.tipo == TipoPaciente.EXOTICO && paciente.esSilvestre) {
            costo = costo * 130 / 100
        }

        return costo
    }
}