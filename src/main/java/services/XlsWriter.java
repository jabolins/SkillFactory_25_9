package services;

import models.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class XlsWriter {

    private static FileOutputStream fileOutputStream;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static int numberOfRow;

    public XlsWriter() {
    }

    public static void createStatisticReport(ArrayList<Statistics> statisticsList, String filePath) {

        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Statistic");
        numberOfRow = 0;

        createHeader(numberOfRow);
        fillDataCells(statisticsList, numberOfRow);

        try {
            fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createHeader(int numberOfRow) {
        Row header = getRow(numberOfRow);
        header.setHeight((short) 1300);

        String[] columnHeads = {
                "Study Profile",
                "Average exam score",
                "Number of students in profile",
                "Number of universities in profile",
                "Name of university"
        };

        for (int i = 0; i < columnHeads.length; i++) {
            Cell cell = getCell(numberOfRow, i);
            cell.setCellStyle(stileOfHeader(i, 5000));
            cell.setCellValue(columnHeads[i]);
        }
    }

    private static void fillDataCells(ArrayList<Statistics> statisticsList, int numberOfRow) {
        for (Statistics statistics : statisticsList) {
            numberOfRow++;

            Cell studyProfile = getCell(numberOfRow, 0);
            studyProfile.setCellStyle(stileDefault());
            studyProfile.setCellValue(statistics.getStudyProfile().getProfileName());

            Cell averageExamScore = getCell(numberOfRow, 1);
            studyProfile.setCellStyle(stileDefault());
            averageExamScore.setCellValue(statistics.getAvgExamScore());

            Cell numberOfStudents = getCell(numberOfRow, 2);
            studyProfile.setCellStyle(stileDefault());
            numberOfStudents.setCellValue(statistics.getNumberOfStudentsProfile());

            Cell numberOfUniversities = getCell(numberOfRow, 3);
            studyProfile.setCellStyle(stileDefault());
            numberOfUniversities.setCellValue(statistics.getNumberOfUniversitiesProfile());

            Cell nameOfUniversity = getCell(numberOfRow, 4);
            studyProfile.setCellStyle(stileDefault());
            nameOfUniversity.setCellValue(statistics.getUniversityName());
        }
    }

    private static CellStyle stileOfHeader(int columnNr, int columnWidth) {

        CellStyle cellstyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 15);
        font.setBold(true);
        cellstyle.setFont(font);
        cellstyle.setAlignment(HorizontalAlignment.CENTER);
        cellstyle.setWrapText(true);
        sheet.setColumnWidth(columnNr, columnWidth);
        return cellstyle;
    }

    private static CellStyle stileDefault() {

        CellStyle cellstyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        cellstyle.setFont(font);
        cellstyle.setAlignment(HorizontalAlignment.RIGHT);
        cellstyle.setWrapText(true);
        return cellstyle;
    }

    private static Row getRow(int rowNr) {
        Row row = sheet.getRow(rowNr);
        if (row == null) {
            row = sheet.createRow(rowNr);
        }
        return row;
    }

    private static Cell getCell(int rowNr, int colonNr) {
        Cell cell;
        Row row = sheet.getRow(rowNr);
        if (row == null) {
            row = sheet.createRow(rowNr);
        }
        cell = row.getCell(colonNr);
        if (cell == null) {
            cell = row.createCell(colonNr);
        }
        return cell;
    }
}
