package Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class VisualMoneda {

	private JPanel panel;

	public VisualMoneda(JPanel panel) {
		this.panel = panel;
	}

	public void VisualMoneda() {

		JLabel lblNewLabel = new JLabel("Importe.");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 25));
		lblNewLabel.setIconTextGap(12);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(85, 43, 122, 28);
		panel.add(lblNewLabel);

		JLabel lblDe = new JLabel("De:");
		lblDe.setIconTextGap(12);
		lblDe.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDe.setForeground(Color.BLACK);
		lblDe.setFont(new Font("Nirmala UI", Font.BOLD, 25));
		lblDe.setBounds(392, 43, 64, 28);
		panel.add(lblDe);

		JLabel lblA = new JLabel("A:");
		lblA.setIconTextGap(12);
		lblA.setHorizontalTextPosition(SwingConstants.CENTER);
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setForeground(Color.BLACK);
		lblA.setFont(new Font("Nirmala UI", Font.BOLD, 25));
		lblA.setBounds(712, 43, 46, 28);
		panel.add(lblA);

		JTextArea amount = new JTextArea();
		amount.setFont(new Font("Dubai Medium", Font.BOLD, 15));
		amount.setBounds(85, 80, 125, 28);
		panel.add(amount);
		amount.setColumns(1);

		JComboBox to = new JComboBox();
		to.setBorder(null);
		to.setBackground(SystemColor.control);
		to.setModel(new DefaultComboBoxModel(new String[] { "MXN - Peso Mexicano", "USD - Dolar Estadunidense",
				"EUR - Euro", "GBP - Libras Esterlinas", "JPY - Yen Japonés", "KRW - Won Sur-Coreano" }));
		to.setBounds(642, 80, 200, 28);
		panel.add(to);

		JComboBox from = new JComboBox();
		from.setBorder(null);
		from.setBackground(SystemColor.control);
		from.setOpaque(false);
		from.setModel(new DefaultComboBoxModel(new String[] { "MXN - Peso Mexicano", "USD - Dolar Estadunidense",
				"EUR - Euro", "GBP - Libras Esterlinas", "JPY - Yen Japonés", "KRW - Won Sur-Coreano" }));
		from.setBounds(318, 80, 200, 28);
		panel.add(from);

		JTextPane Resultado = new JTextPane();
		Resultado.setEditable(false);
		Resultado.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		Resultado.setBackground(SystemColor.activeCaption);
		Resultado.setBounds(85, 179, 496, 263);
		panel.add(Resultado);

		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.setBorder(null);
		btnConvertir.setForeground(new Color(0, 0, 0));
		btnConvertir.setBackground(new Color(0, 139, 139));
		btnConvertir.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		btnConvertir.setBounds(720, 277, 122, 41);
		panel.add(btnConvertir);

		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OkHttpClient client = new OkHttpClient().newBuilder().build();

				String a = to.getSelectedItem().toString().substring(0, 3);
				String de = from.getSelectedItem().toString().substring(0, 3);
				String cantidad = amount.getText().toString();

				Request request = new Request.Builder().url("https://api.apilayer.com/currency_data/convert?to=" + a
						+ "&from=" + de + "&amount=" + cantidad).addHeader("apikey", "hYC8j4yCMObhNxfR4SSQNAXgPM5HLRfx")
						.build();
				Response response = null;
				JSONObject json;
				try {

					response = client.newCall(request).execute();

				} catch (IOException e1) {
					e1.printStackTrace();
				}

				try {

					json = new JSONObject(response.body().string());
					Resultado.setText("\n" + amount.getText().toString() + " "
							+ from.getSelectedItem().toString().substring(0, 3) + " = " + json.get("result").toString()
							+ " " + to.getSelectedItem().toString().substring(0, 3) + ". \n \n" +
							"El tipo de cambio actual es de: "
							+ json.getJSONObject("info").get("quote").toString() + " "
							+ from.getSelectedItem().toString().substring(0, 3) + " por cada "
							+ to.getSelectedItem().toString().substring(0, 3) + ".");

				} catch (JSONException | IOException e1) {
					e1.printStackTrace();
				}
				// Resultado.setText(json.toString());

			}
		});

	}

}
