import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    public static void writeCSV(String filePath, List<String> records) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String record : records) {
                bw.write(record);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}
