package ru.admiralnsk.admiralbd.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.admiralnsk.admiralbd.mappers.DeparturesCountMapper;
import ru.admiralnsk.admiralbd.models.DeparturesCount;

import java.util.List;

@RequiredArgsConstructor
@Component
@Deprecated
public class DepartureDAO {

    private final JdbcTemplate jdbcTemplate;

    @Deprecated
    public Integer getDeparturesCountWithDepartureWay(String departureWay) {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM departures WHERE DepartureWay = ?",
                new Object[]{departureWay}, Integer.class);
    }

    @Deprecated
    public List<String> getDistinctDepartureWays() {
        return jdbcTemplate.queryForList("SELECT DISTINCT DepartureWay FROM departures ORDER BY 1", String.class);
    }
//TODO: обработка null
    @Deprecated
    public List<String> getDistinctConsignorsWithDepartureWay(String departureWay) {
        return jdbcTemplate.queryForList("SELECT DISTINCT Consignor FROM departures " +
                        "WHERE DepartureWay = ? ORDER BY 1",
                new Object[]{departureWay},String.class);
    }

    @Deprecated
    public Integer getDeparturesCountWithDepartureWayAndConsignorByMonth(String departureWay,
                                                                         String consignor, int month) {
        return jdbcTemplate.queryForObject("SELECT count(id) FROM departures " +
                "WHERE departureWay = ? AND Consignor = ? AND MONTH(DepartureDate) = ?",
                new Object[]{departureWay, consignor, month}, Integer.class);
    }

    @Deprecated
    public List<DeparturesCount> getDeparturesCountWithDepartureWayAndConsignorByAllMonth(String departureWay,
                                                                                          String consignor) {
        return jdbcTemplate.query("SELECT MONTH(departureDate), count(id) FROM departures " +
                        "WHERE departureWay = ? AND Consignor = ? GROUP BY 1",
                new Object[]{departureWay, consignor}, new DeparturesCountMapper());
    }

    @Deprecated
    public List<DeparturesCount> getConsigneeCountWithDepartureWayAndConsignor(String departureWay, String consignor) {
        return jdbcTemplate.query("SELECT Consignee, count(id) FROM departures " +
                        "WHERE DepartureWay = ? AND Consignor = ? GROUP BY Consignee ORDER BY 2 DESC",
                new Object[]{departureWay, consignor}, new DeparturesCountMapper());
    }

    @Deprecated
    public List<DeparturesCount> getCargoTypeWithDepartureWayAndConsignor(String departureWay, String consignor) {
        return jdbcTemplate.query("SELECT CargoType, count(id) FROM departures " +
                        "WHERE DepartureWay = ? AND Consignor = ? GROUP BY CargoType ORDER BY 2 DESC",
                new Object[]{departureWay, consignor}, new DeparturesCountMapper());
    }

    @Deprecated
    public List<DeparturesCount> getCarriageKindWithDepartureWayAndConsignor(String departureWay, String consignor) {
        return jdbcTemplate.query("SELECT CarriageKind, count(id) FROM departures " +
                        "WHERE DepartureWay = ? AND Consignor = ? GROUP BY CarriageKind ORDER BY 2 DESC",
                new Object[]{departureWay, consignor}, new DeparturesCountMapper());
    }

}
