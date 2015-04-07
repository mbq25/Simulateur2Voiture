package DomaineVoiture;

import java.util.Observable;

public class Voiture extends Observable {

    private int x;
    private int y;
    private int vitesseMetreSeconde;
    private int directionEnDegres;

    public Voiture(int x, int y, int vitesse) {
        this.x = x;
        this.y = y;
        this.vitesseMetreSeconde = vitesse;
        this.directionEnDegres = 0;
    }

    public void miseAJourPosition() {
        //miseAJourPositionX();
        miseAJourPositionXY();
        notificationObservateur();
    }

    private void miseAJourPositionX() {
        if (directionEnDegres == 0)
            x += vitesseMetreSeconde;
        else
            x -= vitesseMetreSeconde;

        if (x > 1000)
            x = 1000;
        else if (x < 0)
            x = 0;
    }

    private void miseAJourPositionXY(){
        switch (directionEnDegres){
            case 0:{
                x += vitesseMetreSeconde;
                break;
            }
            case 90:{
                y += vitesseMetreSeconde;
                break;
            }
            case 180:{
                x -= vitesseMetreSeconde;
                break;
            }
            case 270:{
                y -= vitesseMetreSeconde;
                break;
            }
            default:{

            }
        }
    }

    private void notificationObservateur() {
        this.setChanged();
        this.notifyObservers();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirectionEnDegres() {
        return directionEnDegres;
    }

    public void accelerer() {
        if (vitesseMetreSeconde < 100)
            vitesseMetreSeconde += 10;
    }

    public Object getVitesse() {
        return vitesseMetreSeconde;
    }

    public void setVitesse(int vitesse) {
        vitesseMetreSeconde = vitesse;
    }

    public void setDirection(int angleDirection) {
        this.directionEnDegres = angleDirection;

    }

    public void inverserDirection() {
        directionEnDegres +=180 ;
        directionEnDegres = directionEnDegres % 360;

    }

    public Object getDirection() {
        return directionEnDegres;
    }

    public void tournerDroit() {
        directionEnDegres +=90;
        directionEnDegres = directionEnDegres % 360;
    }

    public void tournerGauche() {
        if (directionEnDegres == 0) {
            directionEnDegres = 360;
        }
        directionEnDegres -=90;
        directionEnDegres = directionEnDegres % 360;
    }
}
