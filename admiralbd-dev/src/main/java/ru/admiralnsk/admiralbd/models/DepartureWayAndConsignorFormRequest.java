package ru.admiralnsk.admiralbd.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartureWayAndConsignorFormRequest {
    private String departureWay;
    private String consignor;
}
