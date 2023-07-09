package open.code.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


@Service
public class CBRParser {
    private final RestTemplate restTemplate;
    private final String FILE_URL = "http://www.cbr.ru/s/newbik";
    private final String PATH_STORAGE_DATA = "C:\\Users\\Maxim\\Desktop\\opencode-practice\\src\\main\\resources\\xml_data\\";

    @Autowired
    public CBRParser(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public File download() {
        File file = restTemplate.execute(FILE_URL, HttpMethod.GET, null, clientHttpResponse -> {
            File ret = File.createTempFile("download", ".zip");
            FileOutputStream fileOutputStream = new FileOutputStream(ret);
            StreamUtils.copy(clientHttpResponse.getBody(), fileOutputStream);
            fileOutputStream.close();
            return ret;
        });

        String fileName = unzip(file);
        return new File(fileName);
    }

    public String unzip(File file) {
        String fileName = null;
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(file))) {
            ZipEntry entry;
            String originalName;
            while ((entry = zin.getNextEntry()) != null) {
                originalName = entry.getName();
                System.out.printf("File name: %s \n", originalName);
                fileName = PATH_STORAGE_DATA + originalName;
                FileOutputStream fout = new FileOutputStream(PATH_STORAGE_DATA + originalName);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return fileName;
    }

}
