/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.FontSelector;
import static com.itextpdf.text.pdf.PdfDictionary.FONT;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.omg.CORBA.Environment;

/**
 *
 * @author Golden Darkness
 */
public class ExportPDF {
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho ExportPDF ">
    private static ExportPDF instance = new ExportPDF();

    //private contructor
    private ExportPDF() {
    }

    public static ExportPDF getInstance() {
        return instance;
    }
    // </editor-fold>
      
    // <editor-fold defaultstate="collapsed" desc="ExportPDF PhieuNhap">
    public boolean ExportPN(ArrayList<String[]> al) throws BadElementException, IOException, DocumentException {

        // Tạo đối tượng tài liệu
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        
        File fontFile = new File("src\\Helper\\arialuni.ttf");
        BaseFont unicode = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font f = new Font(unicode, 12);
       
        try {
            // Tạo đối tượng PdfWriter
            Date d = new Date();
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy_MM_dd_hh_mm_ss");
            
            String s = "PhieuNhap_"+ft.format(d)+".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(s));

            // Mở file để thực hiện ghi
            document.open();
            
            
            Paragraph title1 = new Paragraph("CÀO's BAKERY",
                FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));   
            document.add(title1);
            
            //Logo Group
            Image image1 = Image.getInstance("src\\Library\\cao.png");
            document.add(new Paragraph());
            document.add(image1);
            
            //Data
            
            
            PdfPTable t = new PdfPTable(7);
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);
 

            PdfPCell c1 = new PdfPCell(new Phrase("STT"));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Mã phiếu nhập",f));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Mã Nhân Viên",f));
            t.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase("Tên Nhân Viên",f));
            t.addCell(c4);
            PdfPCell c5 = new PdfPCell(new Phrase("Ngày lập",f));
            t.addCell(c5);
            PdfPCell c6 = new PdfPCell(new Phrase("Nhà cung cấp",f));
            t.addCell(c6);
            PdfPCell c7 = new PdfPCell(new Phrase("Tổng tiền",f));
            t.addCell(c7);

            for(int i = 0; i< al.size(); i++)
            {
                Object ob = i + 1;
                t.addCell(ob.toString());
                t.addCell(al.get(i)[0]);
                t.addCell(al.get(i)[1]);
                t.addCell(new Phrase(al.get(i)[2],f));
                t.addCell(al.get(i)[3]);
                t.addCell(new Phrase(al.get(i)[4],f));
                t.addCell(al.get(i)[5]);     
            }
            document.add(t);
            // Đóng File
            document.close();
        } catch (FileNotFoundException | DocumentException e) {
            return false;
        }
        return true;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="ExportPDF PhieuXuat">
    public boolean ExportPX(ArrayList<String[]> al) throws BadElementException, IOException, DocumentException {

        // Tạo đối tượng tài liệu
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        
        File fontFile = new File("src\\Helper\\arialuni.ttf");
        BaseFont unicode = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font f = new Font(unicode, 12);

        try {
            // Tạo đối tượng PdfWriter
            Date d = new Date();
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy_MM_dd_hh_mm_ss");
            
            String s = "PhieuXuat_"+ft.format(d)+".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(s));

            // Mở file để thực hiện ghi
            document.open();
            
            
            Paragraph title1 = new Paragraph("CÀO's BAKERY",
                FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));   
            document.add(title1);
            
            //Logo Group
            Image image1 = Image.getInstance("src\\Library\\cao.png");
            document.add(new Paragraph());
            document.add(image1);
            
            //Data
            PdfPTable t = new PdfPTable(5);
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);

            PdfPCell c1 = new PdfPCell(new Phrase("STT"));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Mã phiếu xuất",f));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Mã Nhân Viên",f));
            t.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase("Tên Nhân Viên",f));
            t.addCell(c4);
            PdfPCell c5 = new PdfPCell(new Phrase("Ngày lập",f));
            t.addCell(c5);

            for(int i = 0; i< al.size(); i++)
            {
                Object ob = i + 1;
                t.addCell(ob.toString());
                t.addCell(al.get(i)[0]);
                t.addCell(al.get(i)[1]);
                t.addCell(new Phrase(al.get(i)[2],f));
                t.addCell(al.get(i)[3]);  
            }
            document.add(t);
            
            // Đóng File
            document.close();
        } catch (FileNotFoundException | DocumentException e) {
            return false;
        }
        return true;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="ExportPDF Hoadon">
    public boolean ExportHD(ArrayList<String[]> al) throws BadElementException, IOException, DocumentException {

        // Tạo đối tượng tài liệu
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        
        File fontFile = new File("src\\Helper\\arialuni.ttf");
        BaseFont unicode = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font f = new Font(unicode, 12);

        try {
            // Tạo đối tượng PdfWriter
            Date d = new Date();
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy_MM_dd_hh_mm_ss");
            
            String s = "Hoadon_"+ft.format(d)+".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(s));

            // Mở file để thực hiện ghi
            document.open();
            
            
            Paragraph title1 = new Paragraph("CÀO's BAKERY",
                FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));   
            document.add(title1);
            
            //Logo Group
            Image image1 = Image.getInstance("src\\Library\\cao.png");
            document.add(new Paragraph());
            document.add(image1);
            
            //Data
            PdfPTable t = new PdfPTable(6);
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);

            PdfPCell c1 = new PdfPCell(new Phrase("STT"));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Mã hóa đơn",f));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Tên khách hàng",f));
            t.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase("Tên Nhân Viên",f));
            t.addCell(c4);
            PdfPCell c5 = new PdfPCell(new Phrase("Ngày lập",f));
            t.addCell(c5);
            PdfPCell c6 = new PdfPCell(new Phrase("Tổng tiền",f));
            t.addCell(c6);

            for(int i = 0; i< al.size(); i++)
            {
                Object ob = i + 1;
                t.addCell(ob.toString());
                t.addCell(al.get(i)[0]);
                t.addCell(new Phrase(al.get(i)[1],f));
                t.addCell(new Phrase(al.get(i)[2],f));
                t.addCell(al.get(i)[3]);
                t.addCell(al.get(i)[4]);  
            }
            document.add(t);
            
            // Đóng File
            document.close();
            System.out.println("Write file succes!");
        } catch (FileNotFoundException | DocumentException e) {
            return false;
        }
        return true;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="ExportPDF Thongke doanhthu">
    public boolean ExportTKDT(ArrayList<String[]> al, String year) throws BadElementException, IOException, DocumentException {

        // Tạo đối tượng tài liệu
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        
        File fontFile = new File("src\\Helper\\arialuni.ttf");
        BaseFont unicode = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font f = new Font(unicode, 12);

        try {
            // Tạo đối tượng PdfWriter
            Date d = new Date();
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy_MM_dd_hh_mm_ss");
            
            String s = "ThongKeDoanhThu_"+ft.format(d)+".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(s));

            // Mở file để thực hiện ghi
            document.open();
            
            
            Paragraph title1 = new Paragraph("CÀO's BAKERY",
                FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));   
            document.add(title1);
            
            //Logo Group
            Image image1 = Image.getInstance("src\\Library\\cao.png");
            document.add(new Paragraph());
            document.add(image1);
            
            //Nam can bao cao
            Paragraph title2 = new Paragraph(year,
                FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));   
            document.add(title2);
            
            //Chart
            Image image = Image.getInstance("src\\Library\\barChart3D.jpeg");
            image.scaleToFit(500, 400);
            document.add(new Paragraph());
            document.add(image);
            
            //Data
            PdfPTable t = new PdfPTable(4);
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);

            PdfPCell c1 = new PdfPCell(new Phrase("Tháng",f));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Doanh thu",f));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Tiền nợ",f));
            t.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase("Lãi",f));
            t.addCell(c4);
            
            for(int i = 0; i< al.size(); i++)
            {
                Object ob = i + 1;
                t.addCell(ob.toString());
                t.addCell(al.get(i)[0]);
                t.addCell(al.get(i)[1]);
                t.addCell(al.get(i)[2]);
            }
            document.add(t);
                
            // Đóng File
            document.close();
            System.out.println("Write file succes!");
        } catch (FileNotFoundException | DocumentException e) {
            return false;
        }
        return true;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="ExportPDF ThongKeSanPham">
    public boolean ExportTKSP(ArrayList<String[]> al,String year) throws BadElementException, IOException, DocumentException {

        // Tạo đối tượng tài liệu
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        
        File fontFile = new File("src\\Helper\\arialuni.ttf");
        BaseFont unicode = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font f = new Font(unicode, 12);

        try {
            // Tạo đối tượng PdfWriter
            Date d = new Date();
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy_MM_dd_hh_mm_ss");
            
            String s = "ThongKeSanPham_"+ft.format(d)+".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(s));

            // Mở file để thực hiện ghi
            document.open();
            
            
            Paragraph title1 = new Paragraph("CÀO's BAKERY",
                FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));   
            document.add(title1);
            
            //Logo Group
            Image image1 = Image.getInstance("src\\Library\\cao.png");
            document.add(new Paragraph());
            document.add(image1);
            
            //Năm được báo cáo
            Paragraph title2 = new Paragraph(year,
                FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));   
            document.add(title2);
            
            
            //Chart
            Image image = Image.getInstance("src\\Library\\pie_Chart3D.jpeg");
            image.scaleToFit(500, 400);
            document.add(new Paragraph());
            document.add(image);
            
            //Data
            PdfPTable t = new PdfPTable(5);
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);

            PdfPCell c1 = new PdfPCell(new Phrase("STT"));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Mã sản phẩm",f));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Tên sản phẩm",f));
            t.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase("Tổng số lượng",f));
            t.addCell(c4);
            PdfPCell c5 = new PdfPCell(new Phrase("Tổng tiền",f));
            t.addCell(c5);

            for(int i = 0; i< al.size(); i++)
            {
                Object ob = i + 1;
                t.addCell(ob.toString());
                t.addCell(al.get(i)[0]);
                t.addCell(new Phrase(al.get(i)[1],f));
                t.addCell(al.get(i)[2]);
                t.addCell(al.get(i)[3]); 
            }
            document.add(t);
            
            // Đóng File
            document.close();
            System.out.println("Write file succes!");
        } catch (FileNotFoundException | DocumentException e) {
           return false;
        }
        return true;
    }
    // </editor-fold>
}
