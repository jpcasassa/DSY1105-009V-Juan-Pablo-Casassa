import modelos.Paciente
import modelos.TipoPaciente
import modelos.TipoDueno
import modelos.Tarifa
import modelos.Veterinaria


fun main () {
    println("Sistema de gestion veterinaria PetCare")
    println("Bienvenido")

    val paciente1 = Paciente(
        nombre = "Firulais",
        edad = 5,
        codigo = "CA12CD",
        tipo = TipoPaciente.CANINO,
        tipoDueno = TipoDueno.PARTICULAR
    )
    val paciente2 = Paciente(
        nombre = "Michi",
        edad = 3,
        codigo = "FE22TO",
        tipo = TipoPaciente.FELINO,
        tipoDueno = TipoDueno.PARTICULAR
    )
    val paciente3 = Paciente(
        nombre = "Luna",
        edad = 4,
        codigo = "EX44RG",
        tipo = TipoPaciente.EXOTICO,
        tipoDueno = TipoDueno.PARTICULAR,
        esSilvestre = true
    )

    println("Nombre: ${paciente1.nombre}")
    println("Edad: ${paciente1.edad}")
    println("Codigo: ${paciente1.codigo}")
    println("Tipo: ${paciente1.tipo}")
    println("Dueno: ${paciente1.tipoDueno}")

    val tarifaCanino = Tarifa(
        tipoPaciente = TipoPaciente.CANINO,
        montoPorHora = 12000
    )
    val tarifaFelino = Tarifa(
        tipoPaciente = TipoPaciente.FELINO,
        montoPorHora = 9000
    )
    val tarifaExotico = Tarifa(
        tipoPaciente = TipoPaciente.EXOTICO,
        montoPorHora = 20000
    )

    println("Tarifa canino: $${tarifaCanino.montoPorHora} por hora")
    println("Tarifa felino: $${tarifaFelino.montoPorHora} por hora")
    println("Tarifa exótico: $${tarifaExotico.montoPorHora} por hora")

    val costo = tarifaCanino.calcularCosto(paciente1,60)

    println("Costo de atención: $$costo")

    val costoMediaHora = tarifaCanino.calcularCosto(paciente1, 30)

    println("Costo de 30 minutos: $$costoMediaHora")

    val costoFelino = tarifaFelino.calcularCosto(paciente2, 15)

    println("Costo de felino por 15 minutos: $$costoFelino")

    val costoExotico = tarifaExotico.calcularCosto(paciente3, 60)

    println("Costo de exótico por 60 minutos: $$costoExotico")

    val veterinaria = Veterinaria()

    println("Cantidad de boxes: ${veterinaria.boxes.size}")

    val boxAsignado = veterinaria.asignarBox(paciente1)

    if (boxAsignado != null) {
        println("Box asignado: ${boxAsignado.numero}")
        println("Paciente asignado: ${boxAsignado.paciente?.nombre}")
        println("Nuevo estado: ${boxAsignado.estado}")
    } else {
        println("No hay boxes disponibles")
    }

    val boxLiberado = veterinaria.liberarBox(1)

    if (boxLiberado) {
        println("El box 1 fue liberado correctamente")
    } else {
        println("No se encontro el box 1")
    }

    val nuevoBoxLibre = veterinaria.buscarBoxLibre()

    if(nuevoBoxLibre != null) {
        println("El primer box libre ahora es el numero ${nuevoBoxLibre.numero}")
    } else {
        println("No hay boxes libres")
    }

}