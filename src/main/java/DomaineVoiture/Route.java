package DomaineVoiture;

import java.util.Observable;

/**
 * Created by Morgane on 31/03/2015.
 */

public class Route extends Observable {

    private int largeur;
    private int longueur;


    public Route(int largeur, int longueur) {
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
}

