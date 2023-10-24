package com.okane.service;

import com.okane.common.helpers.GlobalFunction;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Date;

public class ExcelTempalte extends GlobalFunction {
    public void headerMDApprovalMatrix(XSSFSheet sheet, XSSFWorkbook workbook) {
        String today = dateToString(new Date(), "dd MMM yyyy HH:mm");

        CellStyle headerStyle = createHeaderStyle(workbook);
        CellStyle italicStyle = createItalicStyle(workbook);

        sheet.setDisplayGridlines(false);

        Row headerRow = sheet.createRow(0);
        headerRow.setHeightInPoints((short) 20);
        createHeaderCell(headerRow, headerStyle, "DOWNLOAD DATA");

        Row secondRow = sheet.createRow(1);
        secondRow.createCell(0).setCellValue("MASTER DATA - APPROVAL MATRIX");

        Row thirdRow = sheet.createRow(2);
        createItalicCell(thirdRow, italicStyle, "Data per " + today);

        createBackgroundStyle(workbook, headerStyle);

        Row lastRow = sheet.createRow(3);

        createBackgroundCell(lastRow, headerStyle, "Approval Type", 0);
        createBackgroundCell(lastRow, headerStyle, "Order", 1);
        createBackgroundCell(lastRow, headerStyle, "Approver Name", 2);
        createBackgroundCell(lastRow, headerStyle, "Operator", 3);
        createBackgroundCell(lastRow, headerStyle, "Valid From", 4);
        createBackgroundCell(lastRow, headerStyle, "Valid To", 5);
        createBackgroundCell(lastRow, headerStyle, "Status", 6);
    }

    private void createHeaderCell(Row row, CellStyle style, String value) {
        Cell cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue(value);
    }

    private void createItalicCell(Row row, CellStyle style, String value) {
        Cell cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue(value);
    }

    private void createBackgroundCell(Row row, CellStyle style, String value, int columnIndex) {
        Cell cell = row.createCell(columnIndex);
        cell.setCellStyle(style);
        cell.setCellValue(value);
    }

    private CellStyle createHeaderStyle(XSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 14);
        font.setFontName("Arial");
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBold(true);
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        return style;
    }

    private void createBackgroundStyle(XSSFWorkbook workbook, CellStyle style) {
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Arial");
        font.setColor(IndexedColors.BLACK.getIndex());
        style.setFont(font);
    }

    private CellStyle createItalicStyle(XSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Arial");
        font.setColor(IndexedColors.BLACK.getIndex());
        font.setItalic(true);
        style.setFont(font);
        return style;
    }
}
