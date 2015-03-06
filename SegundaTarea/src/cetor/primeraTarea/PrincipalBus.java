package cetor.primeraTarea;

import cetor.primeraTarea.dao.PasajeroDAO;
import cetor.primeraTarea.dao.AutoBusImplementsVehiculoDAO;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ana
 */
public class PrincipalBus {

    private static boolean registroPersonal(List<Pasajero> pasajeroList, boolean bandera, Scanner scan, int indice) {
        Pasajero pasajero = new Pasajero();
        PasajeroDAO pasajeroDao = new PasajeroDAO();
        pasajero.setDni(indice);
        System.out.println("Introduce tu nombre");
        pasajero.setNombre(scan.next().toUpperCase());
        System.out.println("Introduce tu Apellido Paterno");
        pasajero.setApPat(scan.next().toUpperCase());
        System.out.println("Introduce tu Apellido Materno");
        pasajero.setApMat(scan.next().toUpperCase());

        System.out.println(pasajero);
        System.out.println("Se actualizo el archivo " + pasajeroDao.rePoblarTXT(pasajero));
        pasajeroList.add(pasajero);

        System.out.println("Introduce tu [D]DNI para abordar ó [S]Salir");
        char opcion = scan.next().toUpperCase().charAt(0);
        switch (opcion) {
            case 'S':
                System.exit(0);
                break;
            case 'D':
                System.out.println("Escribe tu DNI");
                int dni = scan.nextInt();
                AutoBusImplementsVehiculoDAO busDAO = new AutoBusImplementsVehiculoDAO();
                AutoBus vehivulo = busDAO.crearVehiculo();
                System.out.println("Vehiuclo ->" + vehivulo);
                bandera = true;
                break;
        }
        return bandera;

    }

    static public AutoBusImplementsVehiculoDAO elegirOpcion(Scanner scan, List<Pasajero> pasajerosRegistrados, PasajeroDAO pasajeroDAO, int indice) {
        System.out.println("Que desea hacer, [R]egistar ó [A]bordar");
        char opc = scan.next().toUpperCase().charAt(0);
        boolean bandera = false;
        AutoBusImplementsVehiculoDAO busDAO =null;
        do {
            switch (opc) {
                case 'R':
                    System.out.println("Para poder transportarte debes ingresar tus datos");
                    do {

                    } while (!registroPersonal(pasajerosRegistrados, bandera, scan, indice));
                    break;
                case 'A':
                    System.out.println("Escribe tu DNI");
                    int dni = scan.nextInt();
                    Pasajero pasajero = pasajeroDAO.findPasajero(dni);
                    if (pasajero != null) {
                        busDAO = new AutoBusImplementsVehiculoDAO();
                        AutoBus bus = busDAO.crearVehiculo();

                        System.out.println("Se aparto el boleto -> " + busDAO.apartarAsiento(bus, pasajero));
                       
                        bandera = true;
                    }
                    break;

                default:
                    break;
            }
        } while (!bandera);
        return busDAO;
    }

    public static void main(String[] args) {
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        List<Pasajero> pasajerosRegistrados = pasajeroDAO.obtenerPasajerosTXT("");;
        System.out.println(pasajerosRegistrados);

        int indice = pasajerosRegistrados.size() + 1;
        Scanner scan = new Scanner(System.in);
        AutoBusImplementsVehiculoDAO busDAO = elegirOpcion(scan, pasajerosRegistrados, pasajeroDAO, indice);
        List <AutoBus> buses = busDAO.getLisVehiculo();
        for(AutoBus itemBus : buses){
            System.out.println("Personas en el Autobus " + 
                    itemBus.getIdVehiculo() +" -> " +
                    busDAO.personaXBus(itemBus.getIdVehiculo()) );
        }
        System.out.println("Introduce el DNI a buscar? para localizar a la persona");
        int dni = scan.nextInt();
        AutoBus busito = busDAO.buscarPersonaEnBus(dni);
        System.out.println("La persona con DNI: " + dni +
                "se encuentra en asiento " + busito.getIdVehiculo() + "en el asiento " );
    }
}
