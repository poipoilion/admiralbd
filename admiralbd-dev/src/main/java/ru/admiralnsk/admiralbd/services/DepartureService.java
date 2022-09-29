package ru.admiralnsk.admiralbd.services;

import org.springframework.web.multipart.MultipartFile;
import ru.admiralnsk.admiralbd.models.DeparturesCount;
import ru.admiralnsk.admiralbd.models.Node;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface DepartureService {

    List<String> findDistinctDepartureWays();

    List<DeparturesCount> findConsigneeCountWithDepartureWayAndConsignor(String departureWay, String consignor);

    List<String> findDistinctConsignorsByDepartureWay(String departureWay);

    Integer findDeparturesCountByDepartureWayAnAndConsignorAndMonth(String departureWay, String consignor, int month);

    List<DeparturesCount> findDeparturesCountByDepartureWayAnAndConsignorAllMonth(String departureWay, String consignor);

    List<DeparturesCount> findCargoTypeByDepartureWayAndConsignor(String departureWay, String consignor);

    List<DeparturesCount> findCarriageKindByDepartureWayAndConsignor(String departureWay, String consignor);

    List<Node> findDepartureStationRFCountTreeByDepartureWayAndConsignor(String departureWay, String consignor);

    List<Node> findOwnersCountTreeByDepartureWayAndConsignor(String departureWay, String consignor);

    void putDepartures(MultipartFile file) throws IOException, ExecutionException, InterruptedException;
}
