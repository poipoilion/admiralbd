package ru.admiralnsk.admiralbd.parser;


import com.monitorjbl.xlsx.StreamingReader;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.admiralnsk.admiralbd.mappers.DepartureFieldsMapper;
import ru.admiralnsk.admiralbd.models.Departure;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Component
public class ExcelParser {

    private final DepartureFieldsMapper departureFieldsMapper;

    public List<Departure> readFromExcel(MultipartFile excelFile) throws IOException {

        InputStream is = excelFile.getInputStream();
        List<Departure> departureList = new ArrayList<>();

        try (Workbook workbook = StreamingReader.builder().rowCacheSize(30).open(is)) {
            for (Sheet sheet : workbook) {
                StreamSupport.stream(sheet.spliterator(), false).skip(1).forEach(row -> {
                    if (this.isDepartureEmpty(row)) return;

                    Departure departure = new Departure();
                    departureFieldsMapper.map(row, departure);
                    departureList.add(departure);
                });
            }
        }

        return departureList;
    }

    private boolean isDepartureEmpty(Row row) {
        return row.getCell(7).getStringCellValue().startsWith("ВАГ");
    }



}