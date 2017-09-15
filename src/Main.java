import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        TelematicService telematicService = new TelematicService();
        VehicleInfo vehicleInfo = new VehicleInfo();

        System.out.println("Write VIN");
        vehicleInfo.setVIN(Integer.parseInt(scanner.nextLine()));
        System.out.println(vehicleInfo.getVIN());

        System.out.println("Write Odometer Number");
        vehicleInfo.setOdmeter(Integer.parseInt(scanner.nextLine()));
        System.out.println(vehicleInfo.getOdmeter());

        System.out.println("Write Odometer Reader Number");
        vehicleInfo.setOdomReader(Integer.parseInt(scanner.nextLine()));
        System.out.println(vehicleInfo.getOdomReader());

        System.out.println("Write Liters Number");
        vehicleInfo.setLiters(Integer.parseInt(scanner.nextLine()));
        System.out.println(vehicleInfo.getLiters());

        System.out.println("Write Consumption Number");
        vehicleInfo.setConsumption(Integer.parseInt(scanner.nextLine()));
        System.out.println(vehicleInfo.getConsumption());

        telematicService.report(vehicleInfo);
    }
}
