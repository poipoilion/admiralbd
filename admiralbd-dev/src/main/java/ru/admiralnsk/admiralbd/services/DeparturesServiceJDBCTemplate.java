package ru.admiralnsk.admiralbd.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.admiralnsk.admiralbd.constants.Constants;
import ru.admiralnsk.admiralbd.dao.DepartureDAO;
import ru.admiralnsk.admiralbd.mappers.Months;
import ru.admiralnsk.admiralbd.models.DeparturesCount;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Deprecated
public class DeparturesServiceJDBCTemplate {

    private final DepartureDAO departureDAO;

    public Integer getDeparturesCountWithDepartureWay(String departureWay) {
        return departureDAO.getDeparturesCountWithDepartureWay(departureWay);
    }

    public List<String> getDistinctDepartureWays() {
        return departureDAO.getDistinctDepartureWays();
    }


    public List<String> getDistinctConsignorsWithDepartureWay(String departureWay) {
        return departureDAO.getDistinctConsignorsWithDepartureWay(departureWay);
    }

    public Integer getDeparturesCountWithDepartureWayAndConsignorByMonth(String departureWay, String consignor,
                                                                         int month) {
        return departureDAO.getDeparturesCountWithDepartureWayAndConsignorByMonth(departureWay, consignor, month);
    }

    public List<DeparturesCount> getDeparturesCountWithDepartureWayAndConsignorByAllMonth(String departureWay,
                                                                                          String consignor) {
        List<DeparturesCount> departuresCountList =
                departureDAO.getDeparturesCountWithDepartureWayAndConsignorByAllMonth(departureWay, consignor);

        int counter = 0;

        List<DeparturesCount> formattedDeparturesCountList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            formattedDeparturesCountList.add(new DeparturesCount(Months.getMonthName(i+1), 0));
        }

        for (DeparturesCount departuresCount : departuresCountList) {
            counter += departuresCount.getValue();
            formattedDeparturesCountList.get(Integer.parseInt(departuresCount.getName()) - 1).setValue(departuresCount.getValue());
        }

        formattedDeparturesCountList.add(new DeparturesCount(Constants.OVERALL, counter));

        return formattedDeparturesCountList;
    }

    public List<DeparturesCount> getConsigneeCountWithDepartureWayAndConsignor(String departureWay, String consignor) {
        return departureDAO.getConsigneeCountWithDepartureWayAndConsignor(departureWay, consignor);
    }

    public List<DeparturesCount> getCargoTypeWithDepartureWayAndConsignor(String departureWay, String consignor) {
        return departureDAO.getCargoTypeWithDepartureWayAndConsignor(departureWay, consignor);
    }

    public List<DeparturesCount> getCarriageKindWithDepartureWayAndConsignor(String departureWay, String consignor) {
        return departureDAO.getCarriageKindWithDepartureWayAndConsignor(departureWay, consignor);
    }


}