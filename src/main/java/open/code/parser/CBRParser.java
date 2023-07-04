package open.code.parser;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import open.code.service.bnk_msg.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

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
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                System.out.printf("File name: %s \n", name);
                fileName = PATH_STORAGE_DATA + name;
                FileOutputStream fout = new FileOutputStream(PATH_STORAGE_DATA + name);
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

    /*public void unzipXml(URL fileURL, Path destDir) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(
                    Channels.newInputStream(Channels.newChannel(fileURL.openStream())));
            for (ZipEntry ze; (ze = zipInputStream.getNextEntry()) != null; ) {
                Path resolvedPath = destDir.resolve(ze.getName()).normalize();
                if (ze.isDirectory()) {
                    Files.createDirectories(resolvedPath);
                } else try (FileChannel fileChannel = FileChannel.open(resolvedPath, WRITE, CREATE)) {
                    fileChannel.transferFrom(Channels.newChannel(zipInputStream), 0, Long.MAX_VALUE);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

/*public void downloadXmlFromCBR() throws IOException {
        URL url = new URL(FILE_URL);
        Path path = Path.of(PATH_STORAGE_DATA);
        unzipXml(url, path);
    }*/


}
