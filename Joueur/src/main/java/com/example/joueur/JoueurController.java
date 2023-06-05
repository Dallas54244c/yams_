package com.example.joueur;

import com.example.projet_yams.ProjetYamsApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/yams")
public class JoueurController {

    @GetMapping("/roll-dice")
    public ResponseEntity<int[]> rollDice() {
        int[] dice = ProjetYamsApplication.rollDice();
        return new ResponseEntity<>(dice, HttpStatus.OK);
    }

    @PostMapping("/reroll-dice")
    public ResponseEntity<int[]> rerollDice(@RequestBody int[] dice, @RequestBody int[] keep) {
        int[] newDice = ProjetYamsApplication.rerollDice(dice, keep);
        return new ResponseEntity<>(newDice, HttpStatus.OK);
    }

    @GetMapping("/choose-dice-to-keep")
    public ResponseEntity<int[]> chooseDiceToKeep(@RequestBody int[] dice) {
        int[] keep = ProjetYamsApplication.chooseDiceToKeep(dice);
        return new ResponseEntity<>(keep, HttpStatus.OK);
    }

    @GetMapping("/choose-category")
    public ResponseEntity<Integer> chooseCategory(@RequestBody int[] dice) {
        int category = ProjetYamsApplication.chooseCategory(dice);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}