package AppliSimu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import DomaineVoiture.Route;
import DomaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer{

	private double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
    private Route maRoute;
	private CommandeVoiture maCommandeVoiture;
	
	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);

		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

		this.setVisible(true);
	}

    /*
	public IHMVoiture(Voiture maVoiture) {
		super();
		this.maVoiture = maVoiture;
		maVoiture.addObserver(this);
		initGraphique();
	}
	*/

    public IHMVoiture(Voiture maVoiture,Route maRoute) {
        super();
        this.maVoiture = maVoiture;
        this.maRoute = maRoute;
        maVoiture.addObserver(this);
        initGraphique();
    }

	public IHMVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
	}
	
	public int calculerPositionPixels(int xMetres) {
		return (int) (paramatreConversionMetresPixels * xMetres);	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);
		//contexteGraphique.setColor(Color.red);
        dessinerRoute1(contexteGraphique);
        dessinerRoute2(contexteGraphique);
		dessinerVoiture(contexteGraphique);
	}


	private void dessinerVoiture(Graphics contexteGraphique) {
		int xMetres = maVoiture.getX();
		int xPixel = calculerPositionPixels(xMetres);
        contexteGraphique.setColor(Color.red);
		contexteGraphique.fillRect(xPixel, 300, 30, 15);
	}

    private void dessinerRoute1(Graphics contexteGraphique) {
        int largeur = maRoute.getLargeur();
        int longueur = maRoute.getLongueur();
        contexteGraphique.setColor(Color.gray);
        contexteGraphique.fillRect(0, 250, largeur+100, longueur);
    }

    private void dessinerRoute2(Graphics contexteGraphique) {
        int largeur = maRoute.getLargeur();
        int longueur = maRoute.getLongueur();
        contexteGraphique.setColor(Color.gray);
        contexteGraphique.fillRect(50, 0, longueur, largeur+100);
    }
	
}
