import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager  {
    public static void writeData(String fileName, String data) throws MyFileException {
        List<String> lines = null;
        try (BufferedReader tempReader = new BufferedReader(new FileReader(fileName))){
            lines = (tempReader.lines().toList());
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            throw new MyFileException("Чтение, нет доступа к файлу " + fileName);
        }
        
        try (BufferedWriter fileStream = new BufferedWriter(new FileWriter(fileName))){
            if (lines != null) {
                for (String line : lines) {
                    fileStream.append(line);
                    fileStream.newLine();
                }
            }
            fileStream.write(data);
            fileStream.newLine();
            fileStream.flush();
        } catch (IOException e) {
            throw new MyFileException("Запись, нет доступа к файлу " + fileName);
        }

    }    
}
