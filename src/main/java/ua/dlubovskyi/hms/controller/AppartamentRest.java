package ua.dlubovskyi.hms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dlubovskyi.hms.service.AppartamentService;

@RestController
public class AppartamentRest {


    @GetMapping("/apartaments")
    private void getAllApartaments(){

    }
}
