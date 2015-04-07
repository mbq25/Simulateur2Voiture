package AppliSimu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DomaineVoiture.Voiture;

public class CommandeVoiture extends JPanel implements ActionListener{
	
	private JButton boutonAccelerer;
	private JButton boutonInverserDirection;
    private JButton boutonDroit;
    private JButton boutonGauche;
	private Voiture maVoiture;

	public CommandeVoiture (JFrame fenetre, Voiture maVoiture) {
		
		super();
		this.setLayout(new FlowLayout());
 
		boutonAccelerer = new JButton("Accelerer");
		boutonAccelerer.addActionListener(this);
		this.add(boutonAccelerer);

		boutonInverserDirection = new JButton("Changer direction");
		boutonInverserDirection.addActionListener(this);
		this.add(boutonInverserDirection);

        boutonDroit = new JButton("Droite");
        boutonDroit.addActionListener(this);
        this.add(boutonDroit);

        boutonGauche = new JButton("Gauche");
        boutonGauche.addActionListener(this);
        this.add(boutonGauche);
		
		fenetre.add(this);
		this.maVoiture = maVoiture;
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		Object bouton = event.getSource();
		if (bouton == boutonAccelerer){
			maVoiture.accelerer();
        }
		else if (bouton == boutonInverserDirection){
			maVoiture.inverserDirection();
        }
        else if(bouton == boutonDroit){
            maVoiture.tournerDroit();
        }
        else if(bouton == boutonGauche){
            maVoiture.tournerGauche();
        }
	}
	

}
