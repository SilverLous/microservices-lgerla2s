package com.services.dice.dice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
//@RequestMapping(path = "api/v1/dice")
@RequestMapping(value = "/dice/{dthrow}", method = RequestMethod.GET)

public class diceController {
    private diceService DiceService;

    @Autowired
    public diceController() {
        DiceService = new diceService();
    }
    @GetMapping
    public String diceTest(@PathVariable String dthrow){
        return Arrays.toString(DiceService.diceList(dthrow))+" geworfen von EUREKA-DICE-THROWER";
//        return (DiceService.diceList(dthrow));
    }
}
