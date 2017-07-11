/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PISServlet;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import dBConn.Conn;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.RMIConnector;

/**
 *
 * @author Shammugam
 */
@WebServlet(name = "PharmacyLabel", urlPatterns = {"/PharmacyLabel"})

public class PharmacyLabel extends HttpServlet {

    private String action = "";
    private String orderNo = "";
    private String status = "";
    private String userID = "";
    
    RMIConnector rmic = new RMIConnector();
    Conn conn = new Conn();

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            action = request.getParameter("action");
            orderNo = request.getParameter("orderNo");
            status = request.getParameter("status");

            userID = request.getSession().getAttribute("USER_ID").toString();

            generatePharmacyLabel(response);

        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    private void generatePharmacyLabel(HttpServletResponse response) {

        float left = 20;
        float right = 20;
        float top = 20;
        float bottom = 20;
        String sql
                = "SELECT "
                + "pb.pmi_no, pb.patient_name, pb.new_ic_no, pb.id_no, pb.home_address, pb.mobile_phone, pb.email_address, "
                //credit of month
                + "IFNULL(cl.cr_amt_1, 0), IFNULL(cl.cr_amt_2, 0), IFNULL(cl.cr_amt_3, 0), IFNULL(cl.cr_amt_4, 0), "
                + "IFNULL(cl.cr_amt_5, 0), IFNULL(cl.cr_amt_6, 0), IFNULL(cl.cr_amt_7, 0), IFNULL(cl.cr_amt_8, 0), "
                + "IFNULL(cl.cr_amt_9, 0), IFNULL(cl.cr_amt_10, 0), IFNULL(cl.cr_amt_11, 0), IFNULL(cl.cr_amt_12, 0), "
                //debit of month
                + "IFNULL(cl.dr_amt_1, 0), IFNULL(cl.dr_amt_2, 0), IFNULL(cl.dr_amt_3, 0), IFNULL(cl.dr_amt_4, 0), "
                + "IFNULL(cl.dr_amt_5, 0), IFNULL(cl.dr_amt_6, 0), IFNULL(cl.dr_amt_7, 0), IFNULL(cl.dr_amt_8, 0), "
                + "IFNULL(cl.dr_amt_9, 0), IFNULL(cl.dr_amt_10, 0), IFNULL(cl.dr_amt_11, 0), IFNULL(cl.dr_amt_12, 0), "
                //total credit of a year
                + "IFNULL(cl.cr_amt_1, 0)+IFNULL(cl.cr_amt_2, 0)+IFNULL(cl.cr_amt_3, 0)+IFNULL(cl.cr_amt_4, 0)+"
                + "IFNULL(cl.cr_amt_5, 0)+IFNULL(cl.cr_amt_6, 0)+IFNULL(cl.cr_amt_7, 0)+IFNULL(cl.cr_amt_8, 0)+"
                + "IFNULL(cl.cr_amt_9, 0)+IFNULL(cl.cr_amt_10, 0)+IFNULL(cl.cr_amt_11, 0)+IFNULL(cl.cr_amt_12, 0), "
                //total debit of a year
                + "IFNULL(cl.dr_amt_1, 0)+IFNULL(cl.dr_amt_2, 0)+IFNULL(cl.dr_amt_3, 0)+IFNULL(cl.dr_amt_4, 0)+"
                + "IFNULL(cl.dr_amt_5, 0)+IFNULL(cl.dr_amt_6, 0)+IFNULL(cl.dr_amt_7, 0)+IFNULL(cl.dr_amt_8, 0)+"
                + "IFNULL(cl.dr_amt_9, 0)+IFNULL(cl.dr_amt_10, 0)+IFNULL(cl.dr_amt_11, 0)+IFNULL(cl.dr_amt_12, 0), "
                + "IFNULL(cl.cr_amt_13, 0), IFNULL(cl.dr_amt_13, 0) "
                + "FROM far_customer_ledger cl, pms_patient_biodata pb "
                + "WHERE cl.customer_id = pb.pmi_no "
                + "AND pb.new_ic_no = '941124035841'";
        ArrayList<ArrayList<String>> data = conn.getData(sql);

        for (int i = 0; i < data.size(); i++) {
            String pmiNo = data.get(i).get(0);
            String name = data.get(i).get(1);
            String idNo = data.get(i).get(3);
            String address = data.get(i).get(4);
            String phone = data.get(i).get(5);
            String email = data.get(i).get(6);
            String cr1 = data.get(i).get(7);
            String cr2 = data.get(i).get(8);
            String cr3 = data.get(i).get(9);
            String cr4 = data.get(i).get(10);
            String cr5 = data.get(i).get(11);
            String cr6 = data.get(i).get(12);
            String cr7 = data.get(i).get(13);
            String cr8 = data.get(i).get(14);
            String cr9 = data.get(i).get(15);
            String cr10 = data.get(i).get(16);
            String cr11 = data.get(i).get(17);
            String cr12 = data.get(i).get(18);
            String dr1 = data.get(i).get(19);
            String dr2 = data.get(i).get(20);
            String dr3 = data.get(i).get(21);
            String dr4 = data.get(i).get(22);
            String dr5 = data.get(i).get(23);
            String dr6 = data.get(i).get(24);
            String dr7 = data.get(i).get(25);
            String dr8 = data.get(i).get(26);
            String dr9 = data.get(i).get(27);
            String dr10 = data.get(i).get(28);
            String dr11 = data.get(i).get(29);
            String dr12 = data.get(i).get(30);
            String yearCredit = data.get(i).get(31);
            String yearDebit = data.get(i).get(32);
            String lastYearCredit = data.get(i).get(33);
            String lastYearDebit = data.get(i).get(34);

            //create new document
            Document document = new Document(PageSize.A4, 36, 36, 64, 36) {
            };
            document.setMargins(40, 30, 50, 50);

            double deficient = 0;
            double totalYearCredit = 0;
            double totalYearDebit = 0;

//        String sql
//                = " SELECT * FROM pis_order_master INNER JOIN pis_order_detail ON (pis_order_master.ORDER_NO = pis_order_detail.ORDER_NO) "
//                + " WHERE pis_order_detail.ORDER_NO = '" + orderNo + "' AND pis_order_detail.STATUS = '" + status + "' ";
//
//        ArrayList<ArrayList<String>> data = conn.getData(sql);
            document.setMargins(40, 30, 50, 50);

            try {

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PdfWriter writer = PdfWriter.getInstance(document, baos);
                document.open();

                //initialize pdf
                Font recti = new Font(Font.HELVETICA, 16, Font.BOLD);
                Font rectem = new Font(Font.HELVETICA, 12, Font.BOLD);
                Font rectemja = new Font(Font.COURIER, 12);


                PdfPTable tableStatement = new PdfPTable(3);
                tableStatement.setWidths(new float[]{10.5f, 2f, 2f});
                tableStatement.setLockedWidth(true);
                tableStatement.setTotalWidth(document.right() - document.left());

                PdfPCell cell41 = new PdfPCell(new Phrase("Month:", rectem));
                cell41.setHorizontalAlignment(Element.ALIGN_LEFT);
                PdfPCell cell42 = new PdfPCell(new Phrase("Debit (RM)", rectem));
                cell42.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell cell43 = new PdfPCell(new Phrase("Credit (RM)", rectem));
                cell43.setHorizontalAlignment(Element.ALIGN_CENTER);

                tableStatement.addCell(cell41);
                tableStatement.addCell(cell42);
                tableStatement.addCell(cell43);

                PdfPCell cell51 = new PdfPCell(new Phrase("January", rectemja));
                cell51.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell51.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell52 = new PdfPCell(new Phrase(dr1, rectemja));
                cell52.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell52.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell53 = new PdfPCell(new Phrase(cr1, rectemja));
                cell53.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell53.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

                tableStatement.addCell(cell51);
                tableStatement.addCell(cell52);
                tableStatement.addCell(cell53);

                PdfPCell cell61 = new PdfPCell(new Phrase("February", rectemja));
                cell61.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell61.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell62 = new PdfPCell(new Phrase(dr2, rectemja));
                cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell62.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell63 = new PdfPCell(new Phrase(cr2, rectemja));
                cell63.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell63.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

                tableStatement.addCell(cell61);
                tableStatement.addCell(cell62);
                tableStatement.addCell(cell63);

                PdfPCell cell71 = new PdfPCell(new Phrase("March", rectemja));
                cell71.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell71.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell72 = new PdfPCell(new Phrase(dr3, rectemja));
                cell72.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell72.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell73 = new PdfPCell(new Phrase(cr3, rectemja));
                cell73.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell73.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

                tableStatement.addCell(cell71);
                tableStatement.addCell(cell72);
                tableStatement.addCell(cell73);

                PdfPCell cell81 = new PdfPCell(new Phrase("April", rectemja));
                cell81.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell81.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell82 = new PdfPCell(new Phrase(dr4, rectemja));
                cell82.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell82.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell83 = new PdfPCell(new Phrase(cr4, rectemja));
                cell83.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell83.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

                tableStatement.addCell(cell81);
                tableStatement.addCell(cell82);
                tableStatement.addCell(cell83);

                PdfPCell cell91 = new PdfPCell(new Phrase("May", rectemja));
                cell91.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell91.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell92 = new PdfPCell(new Phrase(dr5, rectemja));
                cell92.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell92.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell93 = new PdfPCell(new Phrase(cr5, rectemja));
                cell93.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell93.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

                tableStatement.addCell(cell91);
                tableStatement.addCell(cell92);
                tableStatement.addCell(cell93);

                PdfPCell cell101 = new PdfPCell(new Phrase("June", rectemja));
                cell101.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell101.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell102 = new PdfPCell(new Phrase(dr6, rectemja));
                cell102.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell102.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell103 = new PdfPCell(new Phrase(cr6, rectemja));
                cell103.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell103.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

                tableStatement.addCell(cell101);
                tableStatement.addCell(cell102);
                tableStatement.addCell(cell103);

                PdfPCell cell111 = new PdfPCell(new Phrase("July", rectemja));
                cell111.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell111.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell112 = new PdfPCell(new Phrase(dr7, rectemja));
                cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell112.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell113 = new PdfPCell(new Phrase(cr7, rectemja));
                cell113.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell113.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

                tableStatement.addCell(cell111);
                tableStatement.addCell(cell112);
                tableStatement.addCell(cell113);

                PdfPCell cell121 = new PdfPCell(new Phrase("August", rectemja));
                cell121.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell121.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell122 = new PdfPCell(new Phrase(dr8, rectemja));
                cell122.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell122.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell123 = new PdfPCell(new Phrase(cr8, rectemja));
                cell123.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell123.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

                tableStatement.addCell(cell121);
                tableStatement.addCell(cell122);
                tableStatement.addCell(cell123);

                PdfPCell cell131 = new PdfPCell(new Phrase("September", rectemja));
                cell131.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell131.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell132 = new PdfPCell(new Phrase(dr9, rectemja));
                cell132.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell132.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell133 = new PdfPCell(new Phrase(cr9, rectemja));
                cell133.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell133.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

                tableStatement.addCell(cell131);
                tableStatement.addCell(cell132);
                tableStatement.addCell(cell133);

                PdfPCell cell141 = new PdfPCell(new Phrase("October", rectemja));
                cell141.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell141.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell142 = new PdfPCell(new Phrase(dr10, rectemja));
                cell142.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell142.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell143 = new PdfPCell(new Phrase(cr10, rectemja));
                cell143.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell143.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

                tableStatement.addCell(cell141);
                tableStatement.addCell(cell142);
                tableStatement.addCell(cell143);

                PdfPCell cell151 = new PdfPCell(new Phrase("November", rectemja));
                cell151.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell151.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell152 = new PdfPCell(new Phrase(dr11, rectemja));
                cell152.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell152.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell153 = new PdfPCell(new Phrase(cr11, rectemja));
                cell153.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell153.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

                tableStatement.addCell(cell151);
                tableStatement.addCell(cell152);
                tableStatement.addCell(cell153);

                PdfPCell cell161 = new PdfPCell(new Phrase("December", rectemja));
                cell161.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell161.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell162 = new PdfPCell(new Phrase(dr12, rectemja));
                cell162.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell162.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                PdfPCell cell163 = new PdfPCell(new Phrase(cr12, rectemja));
                cell163.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell163.setBorder(Rectangle.LEFT | Rectangle.RIGHT);

                tableStatement.addCell(cell161);
                tableStatement.addCell(cell162);
                tableStatement.addCell(cell163);

                PdfPCell cell171 = new PdfPCell(new Phrase("Total", rectem));
                cell171.setHorizontalAlignment(Element.ALIGN_LEFT);
                PdfPCell cell172 = new PdfPCell(new Phrase(yearDebit, rectemja));
                cell172.setHorizontalAlignment(Element.ALIGN_CENTER);
                PdfPCell cell173 = new PdfPCell(new Phrase(yearCredit, rectemja));
                cell173.setHorizontalAlignment(Element.ALIGN_CENTER);

                tableStatement.addCell(cell171);
                tableStatement.addCell(cell172);
                tableStatement.addCell(cell173);

                //Summary
                PdfPTable tableSummary = new PdfPTable(2);
                tableSummary.setWidths(new float[]{10.5f, 4f});
                tableSummary.setLockedWidth(true);
                tableSummary.setTotalWidth(document.right() - document.left());

                PdfPCell cell181 = new PdfPCell(new Phrase("\nDebit of last year (RM)", rectem));
                cell181.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell181.setBorder(Rectangle.NO_BORDER);
                PdfPCell cell182 = new PdfPCell(new Phrase("\n" + lastYearDebit, rectemja));
                cell182.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell182.setBorder(Rectangle.NO_BORDER);
                PdfPCell cell191 = new PdfPCell(new Phrase("Credit of last year (RM)", rectem));
                cell191.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell191.setBorder(Rectangle.NO_BORDER);
                PdfPCell cell192 = new PdfPCell(new Phrase("" + lastYearCredit, rectemja));
                cell192.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell192.setBorder(Rectangle.NO_BORDER);

                tableSummary.addCell(cell181);
                tableSummary.addCell(cell182);
                tableSummary.addCell(cell191);
                tableSummary.addCell(cell192);

                totalYearCredit = Double.parseDouble(yearCredit) + Double.parseDouble(lastYearCredit);
                totalYearDebit = Double.parseDouble(yearDebit) + Double.parseDouble(lastYearDebit);
                deficient = totalYearDebit - totalYearCredit;

                

                //footer
                PdfPTable tableFooter = new PdfPTable(1);
                tableFooter.setWidths(new float[]{10.5f});
                tableFooter.setLockedWidth(true);
                tableFooter.setTotalWidth(document.right() - document.left());

                String message1 = "****End of Report****";
                PdfPCell cellFooter1 = new PdfPCell(new Phrase(message1, rectemja));
                cellFooter1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellFooter1.setBorder(Rectangle.TOP);

                tableFooter.addCell(cellFooter1);

                document.add(tableStatement);
                document.add(tableSummary);
                document.add(tableFooter);
                document.close();
                writer.close();

                // setting some response headers
                response.setHeader("Expires", "0");
                response.setHeader("Cache-Control",
                        "must-revalidate, post-check=0, pre-check=0");
                response.setHeader("Pragma", "public");
                // setting the content type
                response.setContentType("application/pdf");
                // the contentlength
                response.setContentLength(baos.size());
                // write ByteArrayOutputStream to the ServletOutputStream
                OutputStream os = response.getOutputStream();
                baos.writeTo(os);
                os.flush();
                os.close();

            } catch (Exception e) {
            }

        }

    }
}
//        String sql
//                = " SELECT * FROM pis_order_master "
//                + " INNER JOIN pis_order_detail ON (pis_order_master.ORDER_NO = pis_order_detail.ORDER_NO) "
//                + " WHERE pis_order_detail.ORDER_NO = '" + orderNo + "' "
//                + " AND pis_order_detail.STATUS = '" + status + "' ";
//
//        ArrayList<ArrayList<String>> data = conn.getData(sql);
//
//        for (int i = 0; i < data.size(); i++) {
//            String data2 = String.join("|", data.get(i));
//            //create new document
//            Document document = new Document(PageSize.A4, 36, 36, 64, 36) {
//            };
//            document.setMargins(40, 30, 50, 50);
//
//            try {
//                
//            // step 2
//            PdfWriter.getInstance(document, response.getOutputStream());
//            // step 3
//            document.open();
//            // step 4
//            document.add(new Paragraph("Hello World"));
//
//            } catch (Exception e) {
//            }
//        }

