package com.apache.controller;

import com.apache.model.AccountInfo;
import java.io.IOException;
import java.util.ArrayList;
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
    rows.remove(0);
    List<AccountInfo> accounts = new ArrayList<>();

    rows.forEach(row -> {
      List<Cell> cells = IteratorUtils.toList(row.cellIterator());
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setNome(cells.get(0).getStringCellValue());
        accountInfo.setCpf(cells.get(1).getStringCellValue());
        accountInfo.setStatus(cells.get(2).getStringCellValue());

        accounts.add(accountInfo);
    });

    System.out.println("=== "+ accounts);
  }

}
