package com.example.projet_yams;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFullController {
    @GetMapping("/")
    public String hello() {
        return "HELLO";
    }

    @GetMapping("/home")
    public int[] rollYams() {
        int[] yams = new int[5];
        // Code to roll the dice
        return yams;
    }



//    private RoundService roundService;
//
//    public RestFullController(RoundService roundService) {
//        this.roundService = roundService;
//    }
//
//    @GetMapping("/roll")
//    public Roll getRoll(@ModelAttribute("roll") Roll roll, BindingResult bindingResult) {
//
//        roundService.fetchCurrentValues(roll);
//
//        return roll;
//    }
//
//    @GetMapping("/roll/evaluate/{field}")
//    public Integer evaluateRollForField(@PathVariable String field) {
//
//        Roll roll = new Roll();
//        roundService.fetchCurrentValues(roll);
//
//        return Fields.getForName(field).evaluate(new Integer[]{roll.getDice1(), roll.getDice2(), roll.getDice3(), roll.getDice4(), roll.getDice5()});
//    }
}
