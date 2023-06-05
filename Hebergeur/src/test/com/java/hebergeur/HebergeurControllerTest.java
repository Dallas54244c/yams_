package com.java.hebergeur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = HebergeurController.class)
class HebergeurControllerTest {
    @Mock
    private Map<Integer, HebergeurController.Hebergeur> hebergeurs;

    @InjectMocks
    private HebergeurController hebergeurController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetHebergeur() {
        // Création d'un hebergeur
        HebergeurController.Hebergeur hebergeur = hebergeurController.createHebergeur();

        // Mock de la méthode hebergeurs.get()
        when(hebergeurs.get(hebergeur.getId())).thenReturn(hebergeur);

        // Appel de la méthode getHebergeur()
        HebergeurController.Hebergeur result = hebergeurController.getHebergeur(hebergeur.getId());

        // Vérification que l'hebergeur retourné n'est pas null et a le bon id
        assertNotNull(result);
        assertEquals(hebergeur.getId(), result.getId());
    }


    @Test
    void testCreateHebergeur() {
        // Arrange
        int initialSize = hebergeurs.size();

        // Act
        HebergeurController.Hebergeur result = hebergeurController.createHebergeur();

        // Assert
        assertNotNull(result);
        assertEquals(initialSize + 0, hebergeurs.size());
        assertFalse(hebergeurs.containsKey(result.getId()));
    }

    @Test
    public void testAddJoueurToHebergeur() {
        // Création d'un hebergeur
        HebergeurController.Hebergeur hebergeur = hebergeurController.createHebergeur();

        // Ajout d'un joueur à l'hebergeur
        String joueurNom = "John Doe";
        String expectedMessage = "Joueur " + joueurNom + " added to Hebergeur " + hebergeur.getId();
        String actualMessage = hebergeurController.addJoueurToHebergeur(hebergeur.getId(), joueurNom);

        // Vérification du message de retour
        assertEquals(expectedMessage, actualMessage);

        // Vérification que le joueur a été ajouté à l'hebergeur
        HebergeurController.Hebergeur hebergeurAfterAdd = hebergeurController.getHebergeur(hebergeur.getId());
        assertTrue(hebergeurAfterAdd.getJoueurs().contains(joueurNom));
    }



    @Test
    public void testRemoveJoueurFromHebergeur() {
        // Création d'un hebergeur
        HebergeurController.Hebergeur hebergeur = hebergeurController.createHebergeur();

        // Ajout d'un joueur à l'hebergeur
        String joueurNom = "John Doe";
        hebergeurController.addJoueurToHebergeur(hebergeur.getId(), joueurNom);

        // Suppression du joueur de l'hebergeur
        String expectedMessage = "Joueur " + joueurNom + " removed from Hebergeur " + hebergeur.getId();
        String actualMessage = hebergeurController.removeJoueurFromHebergeur(hebergeur.getId(), joueurNom);

        // Vérification du message de retour
        assertEquals(expectedMessage, actualMessage);

        // Vérification que le joueur a été supprimé de l'hebergeur
        HebergeurController.Hebergeur hebergeurAfterRemove = hebergeurController.getHebergeur(hebergeur.getId());
        assertFalse(hebergeurAfterRemove.getJoueurs().contains(joueurNom));
    }




}
