package ru.admiralnsk.admiralbd.mappers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;
import ru.admiralnsk.admiralbd.models.Departure;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.StreamSupport;

@Component
public class DepartureFieldsMapper {
    static Map<Integer, BiConsumer<Cell, Departure>> MAPPERS = new HashMap<>();

    public static final Integer DEPARTURE_DATE = 0;
    public static final Integer CARRIAGE_NUMBER = 1;
    public static final Integer DOCUMENT_NUMBER = 2;
    public static final Integer ARRIVAL_DATE = 3;
    public static final Integer LENDING_DATE = 4;
    public static final Integer TRANSPORTATION_TYPE = 5;
    public static final Integer CARGO = 6;
    public static final Integer CARGO_TYPE = 7;
    public static final Integer DEPARTURE_COUNTRY = 8;
    public static final Integer DEPARTURE_STATION_CIS = 9;
    public static final Integer DEPARTURE_STATION_CIS_CODE = 10;
    public static final Integer DEPARTURE_REGION = 11;
    public static final Integer DEPARTURE_WAY = 12;
    public static final Integer DEPARTURE_STATION_RF = 13;
    public static final Integer DEPARTURE_STATION_RF_CODE = 14;
    public static final Integer CONSIGNOR = 15;
    public static final Integer CONSIGNOR_ACEO = 16;
    public static final Integer DESTINATION_COUNTRY = 17;
    public static final Integer DESTINATION_REGION = 18;
    public static final Integer DESTINATION_WAY = 19;
    public static final Integer DESTINATION_STATION_RF = 20;
    public static final Integer DESTINATION_STATION_RF_CODE = 21;
    public static final Integer DESTINATION_STATION_CIS = 22;
    public static final Integer DESTINATION_STATION_CIS_CODE = 23;
    public static final Integer CONSIGNEE = 24;
    public static final Integer CONSIGNEE_ACEO = 25;
    public static final Integer CARRIAGE_KIND = 26;
    public static final Integer CARRIAGE_TYPE = 27;
    public static final Integer PAYER = 28;
    public static final Integer OWNER = 29;
    public static final Integer RENTER = 30;
    public static final Integer OPERATOR = 31;
    public static final Integer CARRIAGE_KM = 32;
    public static final Integer VOLUME = 33;
    public static final Integer RATE = 34;


    {
        MAPPERS.put(DEPARTURE_DATE, (cell, departure) -> departure.setDepartureDate(
                this.getDateCellValue(cell)
        ));

        MAPPERS.put(CARRIAGE_NUMBER, (cell, departure) -> departure.setCarriageNumber(
                this.getNumericCellValue(cell)
        ));

        MAPPERS.put(DOCUMENT_NUMBER, (cell, departure) -> departure.setDocumentNumber(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(ARRIVAL_DATE, (cell, departure) -> departure.setArrivalDate(
                this.getDateCellValue(cell)
        ));

        MAPPERS.put(LENDING_DATE, (cell, departure) -> departure.setLendingDate(
                this.getDateCellValue(cell)
        ));

        MAPPERS.put(TRANSPORTATION_TYPE, (cell, departure) -> departure.setTransportationType(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(CARGO, (cell, departure) -> departure.setCargo(
                this.getNumericCellValue(cell)
        ));

        MAPPERS.put(CARGO_TYPE, (cell, departure) -> departure.setCargoType(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(DEPARTURE_COUNTRY, (cell, departure) -> departure.setDepartureCountry(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(DEPARTURE_STATION_CIS, (cell, departure) -> departure.setDepartureStationCIS(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(DEPARTURE_STATION_CIS_CODE, (cell, departure) -> departure.setDepartureStationCISCode(
                this.getNumericCellValue(cell)
        ));

        MAPPERS.put(DEPARTURE_REGION, (cell, departure) -> departure.setDepartureRegion(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(DEPARTURE_WAY, (cell, departure) -> departure.setDepartureWay(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(DEPARTURE_STATION_RF, (cell, departure) -> departure.setDepartureStationRF(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(DEPARTURE_STATION_RF_CODE, (cell, departure) -> departure.setDepartureStationRFCode(
                this.getNumericCellValue(cell)
        ));

        MAPPERS.put(CONSIGNOR, (cell, departure) -> departure.setConsignor(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(CONSIGNOR_ACEO, (cell, departure) -> departure.setConsignorACEO(
                this.getNumericCellValue(cell)
        ));

        MAPPERS.put(DESTINATION_COUNTRY, (cell, departure) -> departure.setDestinationCountry(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(DESTINATION_REGION, (cell, departure) -> departure.setDestinationRegion(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(DESTINATION_WAY, (cell, departure) -> departure.setDestinationWay(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(DESTINATION_STATION_RF, (cell, departure) -> departure.setDestinationStationRF(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(DESTINATION_STATION_RF_CODE, (cell, departure) -> departure.setDestinationStationRFCode(
                this.getNumericCellValue(cell)
        ));

        MAPPERS.put(DESTINATION_STATION_CIS, (cell, departure) -> departure.setDestinationStationCIS(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(DESTINATION_STATION_CIS_CODE, (cell, departure) -> departure.setDestinationStationCISCode(
                this.getNumericCellValue(cell)
        ));

        MAPPERS.put(CONSIGNEE, (cell, departure) -> departure.setConsignee(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(CONSIGNEE_ACEO, (cell, departure) -> departure.setConsigneeACEO(
                this.getNumericCellValue(cell)
        ));

        MAPPERS.put(CARRIAGE_KIND, (cell, departure) -> departure.setCarriageKind(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(CARRIAGE_TYPE, (cell, departure) -> departure.setCarriageType(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(PAYER, (cell, departure) -> departure.setPayer(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(OWNER, (cell, departure) -> departure.setOwner(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(RENTER, (cell, departure) -> departure.setRenter(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(OPERATOR, (cell, departure) -> departure.setOperator(
                this.getStringCellValue(cell)
        ));

        MAPPERS.put(CARRIAGE_KM, (cell, departure) -> departure.setCarriageKm(
                this.getNumericCellValue(cell)
        ));

        MAPPERS.put(VOLUME, (cell, departure) -> departure.setVolume(
                this.getNumericCellValue(cell)
        ));

        MAPPERS.put(RATE, (cell, departure) -> departure.setRate(
                this.getNumericCellValue(cell)
        ));
    }

    private Integer getNumericCellValue(Cell cell) {
        return cell.getCellType() == CellType.BLANK ? null : (int) cell.getNumericCellValue();
    }

    private String getStringCellValue(Cell cell) {
        if (cell.getCellType() == CellType.BLANK || cell.getStringCellValue().equals("0")) {
            return null;
        } else
            return cell.getStringCellValue();
    }

    private Date getDateCellValue(Cell cell) {
        if (cell.getCellType() == CellType.BLANK || cell.getStringCellValue().equals("0")) {
            return null;
        } else
            return cell.getDateCellValue();
    }

    public void map(Row row, Departure departure) {
        StreamSupport.stream(row.spliterator(), false).forEach(
                cell -> MAPPERS.get(cell.getColumnIndex()).accept(cell, departure)
        );
    }
}
