package com.apache.controller;

import java.io.IOException;
import java.util.List;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileUpload {

  @PostMapping
  public void upload(@RequestParam MultipartFile arquivo) throws IOException {
    XSSFWorkbook workbook = new XSSFWorkbook(arquivo.getInputStream());
    Sheet sheet = workbook.getSheetAt(0);

    List<Row> rows = IteratorUtils.toList(sheet.iterator());

    rows.forEach(row -> {
      List<Cell> cells = IteratorUtils.toList(row.cellIterator());
      cells.forEach(System.out::println);
    });

    System.out.println("chegou a requisição"+sheet);
  }

  @PostMapping("/teste")
  public void upload2(){
    System.out.println("chegou a requisição2");
  }

}
