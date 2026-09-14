import modelos.Paciente
import modelos.TipoPaciente
import modelos.TipoDueno
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

    val veterinaria = Veterinaria()

    val pacientes = mutableListOf<Paciente>()

    pacientes.add(paciente1)
    pacientes.add(paciente2)
    pacientes.add(paciente3)

    var opcion = 0

    while (opcion != 5) {
        println()
        println("**** MENU PETCARE ****")
        println("1. Mostrar Estado de los boxes")
        println("2. Registrar paciente")
        println("3. Asignar paciente")
        println("4. Liberar box")
        println("5. Salir")
        print("Seleccione una opcion: ")

        opcion = readLine()!!.toInt()

        if (opcion == 1) {
            for (box in veterinaria.boxes) {
                println("Box ${box.numero} - Estado: ${box.estado}")
            }
        }

        if (opcion == 2) {
            println("Ingrese el nombre del paciente: ")
            val nombre = readLine()!!

            println("Ingrese la edad del paciente: ")
            val edad = readLine()!!.toInt()

            println("Ingrese el codigo del paciente: ")
            val codigo = readLine()!!

            println("Seleccione el tipo de paciente: ")
            println("1. Canino")
            println("2. Felino")
            println("3. Exotico")

            val opcionTipo = readLine()!!.toInt()

            var tipoSeleccionado: TipoPaciente? = null

            if (opcionTipo == 1) {
                tipoSeleccionado = TipoPaciente.CANINO
            }

            if (opcionTipo == 2) {
                tipoSeleccionado = TipoPaciente.FELINO
            }

            if (opcionTipo == 3) {
                tipoSeleccionado = TipoPaciente.EXOTICO
            }

            println("Selecciona el tipo de dueño: ")
            println("1. Particular")
            println("2. Convenio")
            println("3. Municipal")

            val opcionDueno = readLine()!!.toInt()

            var tipoDuenoSeleccionado: TipoDueno? = null

            if (opcionDueno == 1) {
                tipoDuenoSeleccionado = TipoDueno.PARTICULAR
            }

            if (opcionDueno == 2) {
                tipoDuenoSeleccionado = TipoDueno.CONVENIO
            }

            if (opcionDueno == 3) {
                tipoDuenoSeleccionado = TipoDueno.MUNICIPAL
            }
            if (tipoSeleccionado != null && tipoDuenoSeleccionado != null) {
                val nuevoPaciente = Paciente(
                    nombre = nombre,
                    edad = edad,
                    codigo = codigo,
                    tipo = tipoSeleccionado,
                    tipoDueno = tipoDuenoSeleccionado
                )

                pacientes.add(nuevoPaciente)

                println("Paciente registrado correctamente")
            } else {
                println("Tipo de paciente o tipo de dueño no valido")
            }
        }

        if (opcion == 3) {
            println("Seleccione el paciente:")

            var numeroPaciente = 1

            for (paciente in pacientes) {
                println("$numeroPaciente. ${paciente.nombre}")
                numeroPaciente = numeroPaciente + 1
            }

            print("Ingrese una opcion: ")

            val opcionPaciente = readLine()!!.toInt()

            var pacienteSeleccionado: Paciente? = null

            var posicion = 1

            for (paciente in pacientes) {
                if (opcionPaciente == posicion) {
                    pacienteSeleccionado = paciente
                }

                posicion = posicion + 1
            }

            if (pacienteSeleccionado != null) {
                val boxAsignadoMenu = veterinaria.asignarBox(pacienteSeleccionado)

                if (boxAsignadoMenu != null) {
                    println("Box asignado: ${boxAsignadoMenu.numero}")
                    println("Paciente asignado: ${boxAsignadoMenu.paciente?.nombre}")
                    println("Estado del box: ${boxAsignadoMenu.estado}")
                } else {
                    println("No hay boxes disponibles")
                }
            } else {
                println("Opcion de paciente no valida")
            }
        }

        if (opcion == 4) {
            println("Ingrese el numero del box que desea liberar: ")

            val numeroBox = readLine()!!.toInt()

            val boxLiberadoMenu = veterinaria.liberarBox(numeroBox)

            if (boxLiberadoMenu) {
                println("El box $numeroBox fue liberado correctamente")
            } else {
                println("No se encontro el box $numeroBox")
            }
        }

        if (opcion == 5) {
            println("Saliendo del sistema...")
        }
    }
}