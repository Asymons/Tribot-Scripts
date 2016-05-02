package scripts.WaterFiller.nodes;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JRadioButton BucketButton,JugButton,BowlButton;
	public JButton btnStart;

	/**
	 * Launch the application.
	 */
	public static void runGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblXeroxeroWaterFiller = new JLabel("XeroXero Water Filler");
		lblXeroxeroWaterFiller.setBounds(17, 10, 399, 34);
		lblXeroxeroWaterFiller.setFont(new Font("OCR A Extended", Font.PLAIN, 32));
		contentPane.add(lblXeroxeroWaterFiller);
		
		BucketButton = new JRadioButton("Bucket");
		BucketButton.setBounds(17, 68, 109, 23);
		buttonGroup.add(BucketButton);
		contentPane.add(BucketButton);
		
		
		JugButton = new JRadioButton("Jug");
		JugButton.setBounds(17, 94, 109, 23);
		buttonGroup.add(JugButton);
		contentPane.add(JugButton);
		
		BowlButton = new JRadioButton("Bowl");
		buttonGroup.add(BowlButton);
		BowlButton.setBounds(17, 120, 109, 23);
		contentPane.add(BowlButton);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(198, 226, 89, 23);
		contentPane.add(btnStart);
		
	}
	
	
	public boolean getButton(JRadioButton bt){
		return bt.isSelected();
	}
	
	public boolean getButton(JButton bt){
		return bt.getModel().isPressed();
	}
}
