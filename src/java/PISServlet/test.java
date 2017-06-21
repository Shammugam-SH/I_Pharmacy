/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PISServlet;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shammugam
 */
@WebServlet(name = "test", urlPatterns = {"/test"})

public class test extends HttpServlet {

    /**
     * A simple Hello World Servlet.
     *
     * @see HttpServlet#doGet( HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        try {
            // step 1

            float left = 30;
            float right = 30;
            float top = 60;
            float bottom = 0;

            Document document = new Document(PageSize.A8, left, right, top, bottom);
            // step 2
            PdfWriter.getInstance(document, response.getOutputStream());
            // step 3
            document.open();
            // step 4
            document.add(new Paragraph("Hello World"));
            document.add(new Paragraph(new Date().toString()));
            Rectangle rect = new Rectangle(left, right, top, bottom);
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(2);
            document.add(rect);

            // step 4
            document.add(new Paragraph("Hello Wasasdsadorld"));
            document.add(new Paragraph(new Date().toString()));
            Rectangle rect2 = new Rectangle(left, right, top, bottom);
            rect2.setBorder(Rectangle.BOX);
            rect2.setBorderWidth(2);
            document.add(rect2);
            // step 5
            document.close();

        } catch (Exception de) {
            throw new IOException(de.getMessage());
        }
    }
}
