package covid.project.Print;



import com.itextpdf.html2pdf.HtmlConverter;
import covid.project.model.Booking;
import covid.project.model.BookingDate;
import covid.project.model.ClientInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;



public class GeneratePdf {

    public static void generatePDF (String fullName,
                                    long cpr, String type, boolean result, String date) throws
        IOException {
            String fileName = "src/main/resources/templates/SwabResult.html";
            Path path = Path.of(fileName);
            String content = Files.readString(path);
           content = content.replace("{{FULL NAME:}}", fullName);
         content =   content.replace("{{CPR-number:}}", String.valueOf(cpr));
        content =    content.replace("{{TYPE: }}", type);
        content =    content.replace("{{RESULT:}}", String.valueOf(result));
        content =    content.replace("{{DATE:}}", date);

            HtmlConverter.convertToPdf(content, new FileOutputStream("SwabResult.pdf"));
        }


    }