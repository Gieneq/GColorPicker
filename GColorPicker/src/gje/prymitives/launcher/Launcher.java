package gje.prymitives.launcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Launcher extends JFrame {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 100;
	
	@SuppressWarnings("unused")
	private JLabel tlabel;
	@SuppressWarnings("unused")
	private ButtonGroup bgTypeSelect;
	@SuppressWarnings("unused")
	private JRadioButton radioCube, radioSphere, radioCylinder, radioCone, radioTorus;
	
	private JPanel colorPanel;
	@SuppressWarnings("unused")
	private Color color;
	private JTextField tfColor;
	private JColorChooser colorPicker;
	private ColorSelectionModel colorModel;
	
	public Launcher(){
		setSize(WIDTH, HEIGHT);
		setTitle("Generator prostych bry� 3D - 2015");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10, 10));
		
//		tlabel = new JLabel("xxx:");
//		add(tlabel, BorderLayout.CENTER);
		
		bgTypeSelect = new ButtonGroup();
		radioCube = new JRadioButton("Kostka");
		radioSphere = new JRadioButton("Kula");
		radioCylinder = new JRadioButton("Walec");
		radioCone = new JRadioButton("Sto�ek");
		radioTorus = new JRadioButton("Pier�cie�");
		
		
		/*
		 * PANEL KOLOROW
		 */
		colorPanel = new JPanel();
		colorPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new TitledBorder("Paleta kolor�w")));
		colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.Y_AXIS));
		
		tfColor = new JTextField("#00FFFF");
		tfColor.setMaximumSize(new Dimension(Integer.MAX_VALUE, tfColor.getMinimumSize().height));
		
		colorPicker = new JColorChooser(new Color(0x00FFFF));
		AbstractColorChooserPanel panelSwatches = colorPicker.getChooserPanels()[0];
		colorPicker.removeChooserPanel(panelSwatches);
		colorPicker.addChooserPanel(panelSwatches);
		colorPicker.addChooserPanel(new MyChooserPanel());
		
		colorModel = colorPicker.getSelectionModel();
		
		colorPanel.add(tfColor);
		colorPanel.add(colorPicker);
		add(colorPanel, BorderLayout.CENTER);
		
		colorModel.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				Color c = colorPicker.getColor();
				String hex = String.format("#%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue()).toUpperCase();
				tfColor.setText(hex);
			}
		});
		
	}
	
	public static void main(String[] args) {
		Launcher launcher = new Launcher();
		launcher.setVisible(true);
	}

}
