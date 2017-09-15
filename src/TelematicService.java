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
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(".");
            for (File f : file.listFiles()) {
                if (f.getName().endsWith(".json")) {

                    file.write =
                            " \"<tr>\\n\" +\n" +
                            " \"<td align=\\\"center\\\">\" + /* vehicleInfo.getVIN() + */ \"</td><td align=\\\"center\\\">\"+ " +
                            "/* vehicleInfo.getConsumption() + */ \"</td><td align=\\\"center\\\">\"+ /* vehicleInfo.getOdomReader() + */ " +
                            "\"</td><td align=\\\"center\\\">\"+ /* vehicleInfo.getOdmeter() + */ \"</td align=\\\"center\\\"><td align=\\\"center" +
                            "\\\">\"+ /* vehicleInfo.getLiters() + */\"</td>\\n\" +\n" +
                            " \" </tr>\\n\" +\n"

                    // Now you have a File object named "f".
                    // You can use this to create a new instance of Scanner
                    VehicleInfo vi = mapper.readValue(f, VehicleInfo.class);
                    System.out.println(vi.getVIN());
                }
            }

            // int avg[] = { vehilc.getOdom, ,3,4,5}

            File htmlFile = new File("dashboard.html");

            FileWriter fileWriter = new FileWriter(htmlFile);
            String htmlContent = "<html>\n" +
                    "  <title>Vehicle Telematics Dashboard</title>\n" +
                    "  <body>\n" +
                    "    <h1 align=\"center\">Averages for # vehicles</h1>\n" +
                    "    <table align=\"center\">\n" +
                    "        <tr>\n" +
                    "            <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td align=\"center\"><td align=\"center\">#</td>\n" +
                    "        </tr>\n" +
                    "    </table>\n" +
                    "    <h1 align=\"center\">History</h1>\n" +
                    "    <table align=\"center\" border=\"1\">\n" +
                    "        <tr>\n" +
                    "            <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td align=\"center\">" + /* vehicleInfo.getVIN() + */ "</td><td align=\"center\">"+ /* vehicleInfo.getConsumption() + */ "</td><td align=\"center\">"+ /* vehicleInfo.getOdomReader() + */ "</td><td align=\"center\">"+ /* vehicleInfo.getOdmeter() + */ "</td align=\"center\"><td align=\"center\">"+ /* vehicleInfo.getLiters() + */"</td>\n" +
                    "        </tr>\n" +
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




