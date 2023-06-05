package com.example;

import com.example.joueur.JoueurController;
import com.example.projet_yams.ProjetYamsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class JoueurControllerTest {

    @InjectMocks
    private JoueurController joueurController;

    @Mock
    private ProjetYamsApplication projetYamsApplication;

    @Test
    public void testRollDice() {
        // Arrange
        int[] dice = {1, 2, 3, 4, 5};
        ResponseEntity<int[]> expectedResponse = new ResponseEntity<>(dice, HttpStatus.OK);
        JoueurController joueurController = new JoueurController();

        // Act
        ResponseEntity<int[]> response = joueurController.rollDice();

        // Assert
        assertEquals(expectedResponse.getStatusCode(), response.getStatusCode());

    }

    @Test
    public void testRerollDice() {
        // Arrange
        int[] dice = {1, 2, 3, 4, 5};
        int[] keep = {1, 3, 5};
        int[] newDice = {2, 4};
        ResponseEntity<int[]> expectedResponse = new ResponseEntity<>(newDice, HttpStatus.OK);
        JoueurController joueurController = new JoueurController();

        // Act
        ResponseEntity<int[]> response = joueurController.rerollDice(dice, keep);

        // Assert
        assertEquals(expectedResponse.getStatusCode(), response.getStatusCode());

    }


    @Test
    public void testChooseDiceToKeep() {
        // Arrange
        int[] dice = {1, 2, 3, 4, 5};
        int[] keep = {1, 3, 5};
        ResponseEntity<int[]> expectedResponse = new ResponseEntity<>(keep, HttpStatus.OK);
        JoueurController joueurController = new JoueurController();

        // Act
        ResponseEntity<int[]> response = joueurController.chooseDiceToKeep(dice);

        // Assert
        assertEquals(expectedResponse.getStatusCode(), response.getStatusCode());
        int[] responseBody = response.getBody();
        assertNotNull(responseBody);

    }






    @Test
    public void testChooseCategory() {
        // Arrange
        int[] dice = {1, 2, 3, 4, 5};
        int category = 3;
        ResponseEntity<Integer> expectedResponse = new ResponseEntity<>(category, HttpStatus.OK);
        JoueurController joueurController = new JoueurController();

        // Act
        ResponseEntity<Integer> response = joueurController.chooseCategory(dice);

        // Assert
        assertEquals(expectedResponse.getStatusCode(), response.getStatusCode());

    }

}
