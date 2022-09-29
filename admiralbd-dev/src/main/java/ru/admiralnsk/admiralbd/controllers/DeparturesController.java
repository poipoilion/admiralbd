package ru.admiralnsk.admiralbd.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.admiralnsk.admiralbd.models.DepartureWayAndConsignorFormRequest;
import ru.admiralnsk.admiralbd.services.DepartureService;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


@RequiredArgsConstructor
@Controller
@RequestMapping("/departures")
public class DeparturesController {

    private final DepartureService departureService;

    @GetMapping("")
    public String main(Model model) {
        model.addAttribute("formData", new DepartureWayAndConsignorFormRequest());
        model.addAttribute("departureWays", departureService.findDistinctDepartureWays());
        return "main";
    }

    @GetMapping("/consignorView")
    public String show(@RequestParam(name = "departureWay") String departureWay,
                       @RequestParam(name = "consignor") String consignor, Model model) {

        model.addAttribute("departureWay", departureWay);
        model.addAttribute("consignor", consignor);
        model.addAttribute("monthsCount",
                departureService.findDeparturesCountByDepartureWayAnAndConsignorAllMonth(departureWay, consignor));
        model.addAttribute("consigneesCount",
                departureService.findConsigneeCountWithDepartureWayAndConsignor(departureWay, consignor));
        model.addAttribute("CargoTypesCount",
                departureService.findCargoTypeByDepartureWayAndConsignor(departureWay, consignor));
        model.addAttribute("CarriageKindsCount",
                departureService.findCarriageKindByDepartureWayAndConsignor(departureWay, consignor));

        model.addAttribute("departureStationRFTree",
                departureService.findDepartureStationRFCountTreeByDepartureWayAndConsignor(departureWay, consignor));
        model.addAttribute("ownersTree",
                departureService.findOwnersCountTreeByDepartureWayAndConsignor(departureWay, consignor));

        return "consignorView";
    }

    @GetMapping("/uploadExcel")
    public String uploadExcelGET(Model model) {
        return "uploadExcel";
    }

    @PostMapping("/uploadExcel")
    public String submit(@RequestParam("excelFile") MultipartFile file) throws IOException, ExecutionException, InterruptedException {
        departureService.putDepartures(file);
        return "redirect:/departures";
    }


}