package main;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * Created by Kazi Mainul Islam on 3/18/2017.
 */
public class PDFCreator {
    static Document doc = new Document(PageSize.A4.rotate());
    static PdfPTable table;


    public static void createPdf(){
        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("file.pdf"));
            doc.setMargins(50,50,150,150);
            PDFTemplate template = new PDFTemplate();
            writer.setPageEvent(template);
            doc.open();
            doc.add(table);
        }catch (Exception e){
            e.printStackTrace();
        }
        doc.close();

    }
    public static void createTable(int n){
        table = new PdfPTable(n);
    }
    public  static void addAttribure(String[] attrubute, int n){
        table.addCell("Registration No");
        for (int i = 0; i < n; i++)
            table.addCell(attrubute[i] +" (" +WindowInputData.credit[i]+")");
        table.setHeaderRows(1);
    }
    public static void addValue(String cell){
        table.addCell(cell);
    }

}
