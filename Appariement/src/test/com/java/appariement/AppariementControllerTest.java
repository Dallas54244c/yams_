package com.java.appariement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class AppariementControllerTest {

    private AppariementController appariementController;

    @Mock
    private AppariementController.ProbaService probaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        appariementController = new AppariementController(probaService);
    }

    @Test
    void demanderPartie_HebergeurExistant_PartieCreeeAvecSucces() {
        int hebergeurId = 1;
        String joueurNom = "Alice";
        AppariementController.Hebergeur hebergeur = new AppariementController.Hebergeur(hebergeurId);
        hebergeur.addJoueur("Bob");
        appariementController.getHebergeurs().put(hebergeurId, hebergeur);

        String result = appariementController.demanderPartie(joueurNom);

        assertEquals("Partie créée avec succès sur l'hebergeur " + hebergeurId, result);
        assertEquals(2, hebergeur.getJoueurs().size());
        assertTrue(hebergeur.getJoueurs().contains(joueurNom));
    }

    @Test
    void demanderPartie_HebergeurInexistant_RuntimeException() {
        String joueurNom = "Alice";

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                appariementController.demanderPartie(joueurNom));

        assertEquals("Aucun hebergeur disponible", exception.getMessage());
    }

    @Test
    void demanderPartie_AucunHebergeurDisponible_RuntimeException() {
        String joueurNom = "Alice";
        appariementController.getHebergeurs().clear();

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                appariementController.demanderPartie(joueurNom));

        assertEquals("Aucun hebergeur disponible", exception.getMessage());
    }

    @Test
    void trouverHebergeurMoinsCharge_HebergeurExistant_HebergeurId() {
        int hebergeurId = 1;
        AppariementController.Hebergeur hebergeur = new AppariementController.Hebergeur(hebergeurId);
        appariementController.getHebergeurs().put(hebergeurId, hebergeur);

        int result = appariementController.trouverHebergeurMoinsCharge();

        assertEquals(hebergeurId, result);
    }

    @Test
    void trouverHebergeurMoinsCharge_AucunHebergeur_HebergeurIdMoinsUn() {
        appariementController.getHebergeurs().clear();

        int result = appariementController.trouverHebergeurMoinsCharge();

        assertEquals(-1, result);
    }

}
