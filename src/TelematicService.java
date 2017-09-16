import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//
public class TelematicService {

    public void report(VehicleInfo vehicleInfo) {

        javaJson(vehicleInfo);
        html();
    }

    public void javaJson(VehicleInfo vehicleInfo){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vehicleInfo);

            File file = new File(vehicleInfo.getVIN() + ".json");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json);
            fileWriter.close();


        } catch(IOException ex){
            System.out.println("IO Exception was caught" + ex );
        }

    }



    public void html(){
        try {
            String htmlVehicleInfo = "";
            VehicleInfo averages = new VehicleInfo();
            int dividend = 0;

            ObjectMapper mapper = new ObjectMapper();
            File file = new File(".");
            for (File f : file.listFiles()) {
                if (f.getName().endsWith(".json")) {
                    dividend++;
                    VehicleInfo vehicleInfo = mapper.readValue(f, VehicleInfo.class);

                    averages.setOdmeter(averages.getOdmeter() + vehicleInfo.getOdmeter());
                    averages.setConsumption(averages.getConsumption() + vehicleInfo.getConsumption());
                    averages.setOdomReader(averages.getOdomReader() + vehicleInfo.getOdomReader());
                    averages.setLiters(averages.getLiters() + vehicleInfo.getLiters());

                    htmlVehicleInfo +=
                            "        <tr>\n" +
                            "            <td align=\"center\">" +  vehicleInfo.getVIN() + "</td><td align=\"center\">"+ vehicleInfo.getConsumption() + "</td><td align=\"center\">"+ vehicleInfo.getOdomReader() + "</td><td align=\"center\">"+ vehicleInfo.getOdmeter() + "</td align=\"center\"><td align=\"center\">"+ vehicleInfo.getLiters() + "</td>\n" +
                            "        </tr>\n";

                    // Now you have a File object named "f".
                    // You can use this to create a new instance of Scanner
                }
            }

            averages.setOdmeter(averages.getOdmeter() / dividend);
            averages.setConsumption(averages.getConsumption() / dividend);
            averages.setOdomReader(averages.getOdomReader() / dividend);
            averages.setLiters(averages.getLiters() / dividend);

            // int avg[] = { vehilc.getOdom, ,3,4,5}

            File htmlFile = new File("dashboard.html");

            FileWriter fileWriter = new FileWriter(htmlFile);
            String htmlContent = "<html>\n" +
                    "  <title>Vehicle Telematics Dashboard</title>\n" +
                    "  <body>\n" +
                    "    <h1 align=\"center\">Averages for " + dividend + " vehicles</h1>\n" +
                    "    <table align=\"center\">\n" +
                    "        <tr>\n" +
                    "            <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td align=\"center\">" + averages.getOdmeter() + "</td><td align=\"center\">" + averages.getConsumption()+ "</td><td align=\"center\">"+ averages.getOdomReader() + "</td align=\"center\"><td align=\"center\">"+ averages.getLiters() +"</td>\n" +
                    "        </tr>\n" +
                    "    </table>\n" +
                    "    <h1 align=\"center\">History</h1>\n" +
                    "    <table align=\"center\" border=\"1\">\n" +
                    "        <tr>\n" +
                    "            <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
                    "        </tr>\n" +
                    htmlVehicleInfo +
                    "        <tr>\n" +
                    "            <td align=\"center\">45435</td><td align=\"center\">123</td><td align=\"center\">234</td><td align=\"center\">345</td align=\"center\"><td align=\"center\">4.5</td>\n" +
                    "        </tr>\n" +
                    "    </table>\n" +
                    "  </body>\n" +
                    "</html>\n";

            fileWriter.write(htmlContent);
            fileWriter.close();
        } catch (IOException ex){
            System.out.println("VehicleInfo JSON file could not be made! " + ex);
        }



    }

}





