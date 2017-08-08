/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIS_helper;

import dBConn.Conn;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    Conn conn = new Conn();

    // Declaring Variable
    private String orderNo = "";
    private String status = "";
    private String dataString = "";

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

            float left = 5;
            float right = 5;
            float top = 10;
            float bottom = 10;

            // Getting Data For 
            orderNo = request.getParameter("orderNo");
            status = request.getParameter("status");

            Document document = new Document(PageSize.A8, 20, 20, 20, 20);

            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            // Geting Data For Loop
            ArrayList<ArrayList<String>> data = new ArrayList<>();
            String sql = " SELECT * FROM pis_order_detail WHERE ORDER_NO='" + orderNo + "' AND STATUS='1'; ";
            data = conn.getData(sql);

            for (int i = 0; i < data.size(); i++) {

                document.newPage();

                Rectangle rectBorder = new Rectangle(137, 10, 10, 197);
                rectBorder.setBorder(Rectangle.BOX);
                rectBorder.setBorderWidth(1);

                document.add(rectBorder);

//                Rectangle rectHFC = new Rectangle(135, 15, 15, 190);
//                rectHFC.setBorder(Rectangle.BOX);
//                rectHFC.setBorderWidth(2);

                //document.add(rectHFC);
                document.add(new Paragraph(data.get(i).get(1)));

                Paragraph p = new Paragraph();
                p.add("This is my paragraph 1");
                p.setAlignment(Element.ALIGN_CENTER);

                document.add(p);

                Paragraph p2 = new Paragraph();
                p2.add("This is my paragraph 2"); //no alignment

                document.add(p2);

                Font f = new Font();
                f.setStyle(Font.BOLD);
                f.setSize(8);

                document.add(new Paragraph("This is my paragraph 3", f));

            }

            // step 5
            document.close();

        } catch (Exception de) {
            throw new IOException(de.getMessage());
        }
    }

}

// ================== ================= Library That Can Be Used ================== ================= //

// ----------------------- Setting Page Size ----------------------- //
// Rectangle two = new Rectangle(700, 400);
// document.setPageSize(two);
// ----------------------- Setting Page Size ----------------------- //


// ----------------------- Setting Paragraph Format ----------------------- //
// Paragraph p = new Paragraph();
// p.add("This is my paragraph 1");
// p.setAlignment(Element.ALIGN_CENTER);
//
// document.add(p);
//
// Paragraph p2 = new Paragraph();
// p2.add("This is my paragraph 2"); //no alignment
//
// document.add(p2);
//
// Font f = new Font();
// f.setStyle(Font.BOLD);
// f.setSize(8);
//
// document.add(new Paragraph("This is my paragraph 3", f));
// ----------------------- Setting Paragraph Format ----------------------- //

// ================== ================= Library That Can Be Used ================== ================= //
