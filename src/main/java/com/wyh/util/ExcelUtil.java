package com.wyh.util;


import com.wyh.entity.Link;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.sql.ResultSet;
import java.util.List;

public class ExcelUtil {

    public static void fillExcelData(ResultSet rs, Workbook wb, String[] headers)throws Exception{
        int rowIndex=0;
        Sheet sheet=wb.createSheet();
        Row row=sheet.createRow(rowIndex++);
        for(int i=0;i<headers.length;i++){
            row.createCell(i).setCellValue(headers[i]);
        }
        while(rs.next()){
            row=sheet.createRow(rowIndex++);
            for(int i=0;i<headers.length;i++){
                row.createCell(i).setCellValue(rs.getObject(i+1).toString());
            }
        }
    }

    public static Workbook fillExcelDataWithTemplate(List<Link> Links, String templateFileName)throws Exception{
        InputStream inp=ExcelUtil.class.getResourceAsStream("/templates/" + templateFileName);
        POIFSFileSystem fs=new POIFSFileSystem(inp);//读取流
        Workbook wb=new HSSFWorkbook(fs);
    //    Workbook wb=new HSSFWorkbook(inp);
        Sheet sheet=wb.getSheetAt(0);

        int rowIndex=1;
        for (Link link : Links) {
            Row row=sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(link.getId());
            row.createCell(1).setCellValue(link.getLinkName());
            row.createCell(2).setCellValue(link.getLinkUrl());
            row.createCell(3).setCellValue(link.getOrderNo());
        }
        return wb;
    }
}
