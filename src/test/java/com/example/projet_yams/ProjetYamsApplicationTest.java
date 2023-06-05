package com.example.projet_yams;

import com.example.projet_yams.ProjetYamsApplication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjetYamsApplicationTest {

    @Test
    void testRollDice() {
        int[] dice = ProjetYamsApplication.rollDice();
        assertNotNull(dice);
        assertEquals(5, dice.length);
        for (int value : dice) {
            assertTrue(value >= 1 && value <= 6);
        }
    }

    @Test
    void testRerollDice() {
        int[] dice = {1, 2, 3, 4, 5};
        int[] keep = {1, 0, 1, 0, 1};
        int[] rerolledDice = ProjetYamsApplication.rerollDice(dice, keep);
        assertNotNull(rerolledDice);
        assertEquals(5, rerolledDice.length);
        for (int i = 0; i < 5; i++) {
            if (keep[i] == 1) {
                assertEquals(dice[i], rerolledDice[i]);
            } else {
                assertTrue(rerolledDice[i] >= 1 && rerolledDice[i] <= 6);
            }
        }
    }

    @Test
    void testContains() {
        int[] arr = {1, 2, 3, 4, 5};
        assertTrue(ProjetYamsApplication.contains(arr, 3));
        assertFalse(ProjetYamsApplication.contains(arr, 6));
    }

    @Test
    void testChooseDiceToKeep() {
        int[] dice = {1, 2, 3, 4, 5};
        int[] keep = ProjetYamsApplication.chooseDiceToKeep(dice);
        assertNotNull(keep);
        assertEquals(5, keep.length);
        for (int value : keep) {
            assertTrue(value == 0 || value == 1);
        }
    }

    @Test
    void testChooseCategory() {
        int[] dice = {1, 2, 3, 4, 5};
        int category = ProjetYamsApplication.chooseCategory(dice);
        assertTrue(category >= 0 && category <= 12);
    }
}
