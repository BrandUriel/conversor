package Visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Visual.Visual;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import okhttp3.OkHttpClient;

public class VisualTemperatura {

	private JPanel panel;

	public VisualTemperatura(JPanel panel) {
		this.panel = panel;
	}

	public void visualTemperatura() {

		JLabel lblNewLabelT = new JLabel("Cantidad:");
		lblNewLabelT.setForeground(new Color(0, 0, 0));
		lblNewLabelT.setFont(new Font("Nirmala UI", Font.BOLD, 25));
		lblNewLabelT.setIconTextGap(12);
		lblNewLabelT.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabelT.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelT.setBounds(85, 43, 122, 28);
		panel.add(lblNewLabelT);

		JLabel lblDeT = new JLabel("De:");
		lblDeT.setIconTextGap(12);
		lblDeT.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDeT.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeT.setForeground(Color.BLACK);
		lblDeT.setFont(new Font("Nirmala UI", Font.BOLD, 25));
		lblDeT.setBounds(392, 43, 64, 28);
		panel.add(lblDeT);

		JLabel lblAT = new JLabel("A:");
		lblAT.setIconTextGap(12);
		lblAT.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAT.setHorizontalAlignment(SwingConstants.CENTER);
		lblAT.setForeground(Color.BLACK);
		lblAT.setFont(new Font("Nirmala UI", Font.BOLD, 25));
		lblAT.setBounds(712, 43, 46, 28);
		panel.add(lblAT);

		JTextArea amountT = new JTextArea();
		amountT.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		amountT.setBounds(85, 80, 125, 28);
		panel.add(amountT);
		amountT.setColumns(1);

		JComboBox toT = new JComboBox();
		toT.setBorder(null);
		toT.setBackground(SystemColor.control);
		toT.setOpaque(false);
		toT.setModel(new DefaultComboBoxModel(new String[] { "Celcius", "Kelvin", "Fahrenheit" }));
		toT.setBounds(318, 80, 200, 28);
		panel.add(toT);

		JComboBox fromT = new JComboBox();
		fromT.setLocation(new Point(0, 100));
		fromT.setBorder(null);
		fromT.setBackground(SystemColor.control);
		fromT.setModel(new DefaultComboBoxModel(new String[] { "Celcius", "Kelvin", "Fahrenheit" }));
		fromT.setBounds(642, 80, 200, 28);
		panel.add(fromT);

		JTextPane ResultadoT = new JTextPane();
		ResultadoT.setEditable(false);
		ResultadoT.setBackground(SystemColor.activeCaption);
		ResultadoT.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		ResultadoT.setBounds(85, 179, 496, 263);
		panel.add(ResultadoT);

		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.setBorder(null);
		btnConvertir.setForeground(new Color(0, 0, 0));
		btnConvertir.setBackground(new Color(0, 139, 139));
		btnConvertir.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		btnConvertir.setBounds(720, 277, 122, 41);
		panel.add(btnConvertir);

		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				char to = toT.getSelectedItem().toString().charAt(0);
				char from = fromT.getSelectedItem().toString().charAt(0);

				double amount = Double.parseDouble(amountT.getText());

				double result;

				try {

					if (from == 'C') {
						
						result = Convertion.C(to, amount);
						ResultadoT.setText(String.valueOf(result));

					}
					if (from == 'F') {

						result = Convertion.F(to, amount);
						ResultadoT.setText(String.valueOf(result));

					}
					if (from == 'K') {

						result = Convertion.K(to, amount);
						ResultadoT.setText(String.valueOf(result));

					}

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				
			}

		});

	}

}
