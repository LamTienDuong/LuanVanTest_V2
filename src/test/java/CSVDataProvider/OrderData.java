package CSVDataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class OrderData {
    @DataProvider(name = "orderData")
    public Object[][] orderData() {
        String csvFile = "src/test/resources/test_data/data_dathang3.csv";
        List<Object[]> testData = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // Bỏ qua dòng tiêu đề
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String phone = data[2];
                String province = data[3];
                String district = data[4];
                String ward = data[5];
                String address = data[6];
                String expectMsg = data[7];
                testData.add(new Object[]{id, name, phone, province, district, ward, address, expectMsg});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return testData.toArray(new Object[0][]);
    }
}
