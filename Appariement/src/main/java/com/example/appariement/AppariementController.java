package com.example.appariement;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class AppariementController {
    private Map<Integer, Hebergeur> hebergeurs = new HashMap<>();
    private final ProbaService probaService;

    public AppariementController(ProbaService probaService) {
        this.probaService = probaService;
    }

    @PostMapping("/game/appariement/{joueurNom}")
    public String demanderPartie(@PathVariable String joueurNom) {
        int id = trouverHebergeurMoinsCharge();
        if (id != -1) {
            Hebergeur hebergeur = hebergeurs.getOrDefault(id, null);
            if (hebergeur != null) {
                hebergeur.addJoueur(joueurNom);
                return "Partie créée avec succès sur l'hebergeur " + id;
            } else {
                throw new RuntimeException("Hebergeur non trouvé");
            }
        } else {
            throw new RuntimeException("Aucun hebergeur disponible");
        }
    }

    private int trouverHebergeurMoinsCharge() {
        return hebergeurs.entrySet().stream()
                .min(Comparator.comparingInt(e -> e.getValue().getJoueurs().size()))
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    private static class Hebergeur {
        private int id;
        private List<String> joueurs;

        public Hebergeur(int id) {
            this.id = id;
            this.joueurs = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public List<String> getJoueurs() {
            return joueurs;
        }

        public void addJoueur(String joueurNom) {
            joueurs.add(joueurNom);
        }
    }

    private static class ProbaService {
        // a remplir
        public double getProba(String coup) {
            return new Random().nextDouble();
        }
    }
}
