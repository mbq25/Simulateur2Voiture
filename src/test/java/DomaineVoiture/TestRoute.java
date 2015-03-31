package DomaineVoiture;

import junit.framework.TestCase;

public class TestRoute extends TestCase {

    Route routeTest;

    @Override
    public void setUp() throws Exception {
        int largeur = 5;
        int longueur = 6;
        routeTest = new Route(largeur, longueur);
    }

    public void testGetLargeur() throws Exception {
        assertEquals("La largeur retournée est correcte.", 5, routeTest.getLargeur());
    }

    public void testSetLargeur() throws Exception {
        int newLarg = 9;
        routeTest.setLargeur(newLarg);
        assertEquals("La largeur retournée est correcte.", newLarg, routeTest.getLargeur());
    }

    public void testGetLongueur() throws Exception {
        assertEquals("La largeur retournée est correcte.", 6, routeTest.getLongueur());
    }

    public void testSetLongueur() throws Exception {
        int newLong = 8;
        routeTest.setLongueur(newLong);
        assertEquals("La longueur retournée est correcte.", newLong, routeTest.getLongueur());
    }

}