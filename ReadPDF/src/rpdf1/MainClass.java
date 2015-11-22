package rpdf1;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

public class MainClass {
  public static void main(String[] args) throws Exception {
    Document document = new Document(PageSize.A6);
    PdfWriter.getInstance(document, new FileOutputStream("2.pdf"));
    document.open();
    document.add(new Paragraph("Hello World"));
    document.add(new Paragraph("Hello People"));
    document.close();

    PdfReader reader = new PdfReader("2.pdf");
    byte[] streamBytes = reader.getPageContent(1);
    String contentStream = new String(streamBytes);
    System.out.println(contentStream);
    StringBuffer buf = new StringBuffer();
    int pos = contentStream.indexOf("Hello World") + 11;
    buf.append(contentStream.substring(0, pos));
    buf.append(", Hello ");
    buf.append(contentStream.substring(pos));
    String hackedContentStream = buf.toString();
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("HelloWorldStreamHack.pdf"));
    reader.setPageContent(1, hackedContentStream.getBytes());
    stamper.close();
  }

}