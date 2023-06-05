package com.java.hebergeur;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class HebergeurController {
    private final Map<Integer, Hebergeur> hebergeurs = new HashMap<>();

    @GetMapping("/game-hebergeur/{id}")
    public Hebergeur getHebergeur(@PathVariable int id) {
        return findHebergeur(id);
    }

    @PostMapping("/game-hebergeur")
    public Hebergeur createHebergeur() {
        int newId = hebergeurs.size() + 1;
        Hebergeur hebergeur = new Hebergeur(newId);
        hebergeurs.put(newId, hebergeur);
        return hebergeur;
    }

    @PostMapping("/game-hebergeur/{id}/joueur/{joueurNom}")
    public String addJoueurToHebergeur(@PathVariable int id, @PathVariable String joueurNom) {
        Hebergeur hebergeur = findHebergeur(id);
        if (hebergeur != null) {
            hebergeur.addJoueur(joueurNom);
            return "Joueur " + joueurNom + " added to Hebergeur " + id;
        } else {
            throw new IllegalArgumentException("Hebergeur not found");
        }
    }

    @DeleteMapping("/game-host/{id}/joueur/{joueurNom}")
    public String removeJoueurFromHebergeur(@PathVariable int id, @PathVariable String joueurNom) {
        Hebergeur hebergeur = findHebergeur(id);
        hebergeur.removeJoueur(joueurNom);
        return "Joueur " + joueurNom + " removed from Hebergeur " + id;
    }

    private Hebergeur findHebergeur(int id) {
        Hebergeur hebergeur = hebergeurs.getOrDefault(id, null);
        if (hebergeur == null) {
            throw new IllegalArgumentException("Hebergeur not found");
        }
        return hebergeur;
    }

    static class Hebergeur {
        private final int id;
        private final List<String> joueurs;

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

        public void removeJoueur(String joueurNom) {
            joueurs.remove(joueurNom);
        }
    }
}
