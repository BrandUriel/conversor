package Visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.JTextArea;
import java.awt.Point;

public class Visual extends JFrame {
	
	Visual frame;
	private JPanel panel;

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visual frame = new Visual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// @throws IOException

	public Visual() {
		getContentPane().setBackground(Color.WHITE);

		setSize(920, 500);
		setLocationRelativeTo(null);
		// aqui poner el bloqueo de la pantalla
		contenedor();
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void contenedor() {
		getContentPane().setLayout(null);
		panel = new JPanel();
		panel.setBounds(0, 23, 904, 415);
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Conversor de Divisas");
		btnNewButton.setBounds(0, 0, 452, 23);
		btnNewButton.setPreferredSize(new Dimension(226, 23));
		btnNewButton.setMaximumSize(new Dimension(226, 23));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setAlignmentY(1.0f);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Conversor de Temperatura");
		btnNewButton_1.setBounds(new Rectangle(0, 0, 452, 0));
		btnNewButton_1.setBounds(452, 0, 452, 23);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setAlignmentY(1.0f);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.removeAll();
				new VisualMoneda(panel).VisualMoneda();
				panel.repaint();
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				panel.removeAll();
				new VisualTemperatura(panel).visualTemperatura();
				panel.repaint();
				
			}
		});
	}
}
