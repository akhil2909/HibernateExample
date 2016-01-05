package com.he;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportData {

	public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SampleDB","root","");
            con.setAutoCommit(false);
            PreparedStatement pstm = null ;
            FileInputStream input = new FileInputStream("C:\\Users\\Akhil Bhai\\Documents\\memberkey.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(input);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            for(int i=1; i<=sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);   
                String s1 = row.getCell(0).getStringCellValue().trim();
                String s2 = row.getCell(1).getStringCellValue().trim();
                String s3 = row.getCell(2).getStringCellValue().trim();
                String s4 = row.getCell(3).getStringCellValue().trim();
                String s5 = row.getCell(4).getStringCellValue().trim();                
                
                String sql = "INSERT INTO `memberkey` ( `email`, `password`, `apiKey`, `city`, memShipNo) VALUES("
                				+ "'"+row.getCell(0).getStringCellValue().trim()+"',"
                				+ "'"+row.getCell(1).getStringCellValue().trim()+"',"
                				+ "'"+row.getCell(2).getStringCellValue().trim()+"',"
                				+ "'"+row.getCell(3).getStringCellValue().trim()+"',"
                				+ "'"+row.getCell(4).getStringCellValue().trim()+"')";

                pstm = (PreparedStatement) con.prepareStatement(sql);
                pstm.execute();
                System.out.println("Import rows "+i);
            }
            con.commit();
            pstm.close();
            con.close();
            input.close();
            System.out.println("Success import excel to mysql table");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(IOException ioe){
            System.out.println(ioe);
        }

    }
}
