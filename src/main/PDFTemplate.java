package main;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;

/**
 * Created by tonmoy on 16-Mar-17.
 */
public class PDFTemplate extends PdfPageEventHelper {

    public void onEndPage(PdfWriter writer, Document document) {
        float xCenter =(document.getPageSize().getWidth()/2) -20;
        float yTop=document.getPageSize().getHeight()-7;
        PdfContentByte canvas = writer.getDirectContentUnder();

        try {
            Image img =Image.getInstance("logo.png");
            img.scaleToFit(80,80);
            img.setAbsolutePosition(70,505);
            canvas.addImage(img);

        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }


        ColumnText.showTextAligned(
                canvas, Element.ALIGN_CENTER, new Phrase("SHAHJALAL UNIVERSITY OF SCIENCE & TECHNOLOGY SYLHET, BANGLADESH"),xCenter, yTop-15, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_CENTER, new Phrase("TABULATION SHEET"), xCenter, yTop-30, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_CENTER, new Phrase("Department of CSE"), xCenter, yTop-45, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_CENTER, new Phrase("B Sc. (2nd Major) 5th SEMESTER EXAMINATION 2017"), xCenter, yTop-60, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_CENTER, new Phrase("SESSION 2013-14 EXAMINATION HELD IN: JANUARY 2017"), xCenter, yTop-75, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_RIGHT, new Phrase("Result Published on:___________"), document.getPageSize().getWidth()-7, yTop-45, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("Signature of Chairman:"), 50, yTop-460, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("__________________"), 200, yTop-460, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("Signature of the controller of the examination:"), 400, yTop-460, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("__________________"), 650, yTop-460, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("Name of Chairman:"), 50, yTop-475, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("__________________"), 200, yTop-475, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("Name of the controller of the examination:"), 400, yTop-475, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("__________________"), 650, yTop-475, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("Signature of Members:"), 50, yTop-490, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("__________________"), 200, yTop-490, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("__________________"), 400, yTop-490, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("__________________"), 650, yTop-490, 0);
        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("Name of Members:"), 50, yTop-505, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("__________________"), 200, yTop-505, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("__________________"), 400, yTop-505, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("__________________"), 650, yTop-505, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("Signature of tabulators:"), 50, yTop-520, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("__________________"), 200, yTop-520, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("__________________"), 400, yTop-520, 0);

        ColumnText.showTextAligned(
                canvas, Element.ALIGN_LEFT, new Phrase("__________________"), 650, yTop-520, 0);


    }

}
