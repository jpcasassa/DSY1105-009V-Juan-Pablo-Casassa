package cl.duoc.dsy1105.lab;

public class LaboratorioJava {
    public static void main(String[] args) {
        String modelo = "Galaxy A55";
        int bateria = 18;
        boolean ahorroEnergia = false;
        String propietario = null;
        boolean cargando = true;

        System.out.println("=== TELEFONO ===");
        System.out.println("Modelo: " + modelo);
        System.out.println("Bateria: " + bateria + "%");
        System.out.println("Estado: " + obtenerEstadoBateria(bateria));
        System.out.println("Ahorro de energia: " + ahorroEnergia);

        if (propietario == null) {
            System.out.println("Propietario: Sin propietario");
        } else {
            System.out.println("Propietario: " + propietario);
        }

        if (cargando) {
            System.out.println("El telefono esta conectado al cargador");
        }
    }

    public static String obtenerEstadoBateria(int bateria) {
        if (bateria < 20) {
            return "Bateria baja";
        } else if (bateria < 80) {
            return "Bateria suficiente";
        } else {
            return "Bateria alta";
        }
    }
}
