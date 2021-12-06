import javax.swing.*;

public class CuentaBancaria {
    String nombreCliente;
    String dniCliente;
    double saldo=0;
    double ultimoMovimiento;
    String input;


    // constructor con parametro nombre y dni

    public CuentaBancaria(String nombreCliente, String dniCliente) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
    }
    // constructor con parametro todos excepto $ultimoMovimiento


    public CuentaBancaria(String nombreCliente, String dniCliente, double saldo) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.saldo = saldo;
    }

    public void depositar(double cantidad){
    saldo+=cantidad;
    ultimoMovimiento=0+cantidad;

    }
    public void retirar(double cantidad){
        saldo-=cantidad;
        ultimoMovimiento=0-cantidad;
    }

   public void consultarUltimoMovimiento(){

        if (ultimoMovimiento>0){
            System.out.println("Cantidad depositada: " + ultimoMovimiento);
        }
        else if (ultimoMovimiento<0){
            System.out.println("Cantidad retirada: " + (ultimoMovimiento*(-1)));
        }
        else{
            System.out.println("No se han realizado transacciones");
        }
    }
    public void mostrarMenu(){
        do  {
            input = JOptionPane.showInputDialog("Bienvenido " + nombreCliente + "\n" + "Ingrese una opción: " + "\n" +
                    "OPCIÓN A: Consultar saldo" + "\n" + "OPCIÓN B: Depositar " + "\n" + "OPCIÓN C: Retirar " + "\n" +
                    "OPCIÓN D: Consultar último movimiento " + "\n" + "OPCIÓN E: Salir ");

            // Convertir la entrada a mayúscula
            input = input.toUpperCase();

            switch (input) {
                case "A":
                    System.out.println("El saldo es de: " + saldo);
                    break;
                case "B":
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuánto quiere ingresar?"));
                    depositar(cantidad);
                    break;
                case "C":
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuánto quiere retirar?"));
                    retirar(cantidad);
                    break;
                case "D":
                    consultarUltimoMovimiento();
                    break;
                case "E":
                    System.out.println("El programa se cerrará");
                    break;
                default:
                    System.out.println("Opción inválida, inténtelo de nuevo");
                    break;
            }
        } while (input.equalsIgnoreCase("E")==false);
    }
}
