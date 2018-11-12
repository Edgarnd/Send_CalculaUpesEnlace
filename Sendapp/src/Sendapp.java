
/*importamos las librerias para conectarnos al email*/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*classe del formulario*/
public class Sendapp extends JFrame {
	protected JLabel cerrar;
	protected JLabel label1, label2, label_name, label_nd_name, label_mayor, label_logo, label_advises, label_thanks;
	protected JLabel label_icon;
	protected JLabel label_img0_error, label_img1_error, label_img2_error, label_img3_error, label_img4_error;
	protected JLabel label_img0_suc, label_img1_suc, label_img2_suc, label_img3_suc, label_img4_suc;
	protected JTextArea txtarea_ads;
	protected JScrollPane scroll;
	protected JTextField correo0, correo1, correo2, correo3, correo4;
	protected JTextField name0, name1, name2, name3, name4;
	protected JTextField nd_name0, nd_name1, nd_name2, nd_name3, nd_name4;
	protected JComboBox box0, box1, box2, box3, box4;
	protected JMenuBar menubar;
	protected JMenu menu;
	protected JMenuItem mitem_format, mitem_salir;
	protected JButton limpiar, enviar;
	protected Font font_gotham;
	protected String email_server = "ra201701@upes.edu.sv";
	protected String txt_subject = "Calculadora de Notas UPES";
	protected String notifies = "";
	String letter_format;
	public int pX, pY;

	public Sendapp(String letra_format) {
		/* configuraciones por default del JFrame */
		getContentPane().setBackground(Color.BLACK);
		setTitle("ENVIO - Calcula UPES");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		/* personalizamos icono, mouse y ventana */
		setIconImage(new ImageIcon(getClass().getClassLoader().getResource("icono.png")).getImage());
		font_gotham = new Font("Gotham", 1, 20);

		/* accionamos el boton cerrar */
		cerrar = new JLabel();
		cerrar.setForeground(Color.GRAY);
		add(cerrar);
		cerrar.setBounds(465, 6, 16, 16);
		cerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(0);
			}
		});
		/* accionamos el puntero para mover ventana */
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				pX = me.getX();
				pY = me.getY();
			}
		});
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent me) {
				setLocation(getLocation().x + me.getX() - pX, getLocation().y + me.getY() - pY);
			}
		});

		/**************************************************
		 * inicio del contenido del formulario
		 **************************************************/
		this.letter_format = letra_format;
		String root_images = letter_format.toUpperCase();
		ImageIcon imagen_error = new ImageIcon(root_images + ":/imgs_calcula_upes/error.png");
		ImageIcon imagen_success = new ImageIcon(root_images + ":/imgs_calcula_upes/check_success.png");

		// LABELS
		label1 = new JLabel("Correo Electronico");
		label1.setForeground(Color.LIGHT_GRAY);
		add(label1);
		label1.setBounds(50, 30, 300, 50);
		label1.setFont(font_gotham);

		label_advises = new JLabel("Avisos");
		label_advises.setFont(font_gotham);
		label_advises.setForeground(Color.LIGHT_GRAY);
		label_advises.setBounds(410, 30, 300, 50);
		add(label_advises);

		label_thanks = new JLabel("¡Gracias por el apoyo!");
		label_thanks.setFont(new Font("Gotham", 1, 24));
		label_thanks.setForeground(Color.LIGHT_GRAY);
		label_thanks.setBounds(270, 480, 500, 50);
		add(label_thanks);

		// Images for notify

		label_img0_error = new JLabel(imagen_error);
		label_img0_error.setBounds(10, 70, 40, 40);
		label_img0_error.setVisible(false);
		add(label_img0_error);

		label_img1_error = new JLabel(imagen_error);
		label_img1_error.setBounds(10, 130, 40, 40);
		label_img1_error.setVisible(false);
		add(label_img1_error);

		label_img2_error = new JLabel(imagen_error);
		label_img2_error.setBounds(10, 190, 40, 40);
		label_img2_error.setVisible(false);
		add(label_img2_error);

		label_img3_error = new JLabel(imagen_error);
		label_img3_error.setBounds(10, 250, 40, 40);
		label_img3_error.setVisible(false);
		add(label_img3_error);

		label_img4_error = new JLabel(imagen_error);
		label_img4_error.setBounds(10, 310, 40, 40);
		label_img4_error.setVisible(false);
		add(label_img4_error);

		label_img0_suc = new JLabel(imagen_success);
		label_img0_suc.setBounds(10, 70, 40, 40);
		label_img0_suc.setVisible(false);
		add(label_img0_suc);

		label_img1_suc = new JLabel(imagen_success);
		label_img1_suc.setBounds(10, 130, 40, 40);
		label_img1_suc.setVisible(false);
		add(label_img1_suc);

		label_img2_suc = new JLabel(imagen_success);
		label_img2_suc.setBounds(10, 190, 40, 40);
		label_img2_suc.setVisible(false);
		add(label_img2_suc);

		label_img3_suc = new JLabel(imagen_success);
		label_img3_suc.setBounds(10, 250, 40, 40);
		label_img3_suc.setVisible(false);
		add(label_img3_suc);

		label_img4_suc = new JLabel(imagen_success);
		label_img4_suc.setBounds(10, 310, 40, 40);
		label_img4_suc.setVisible(false);
		add(label_img4_suc);

		// Image for decorate

		ImageIcon icono_app = new ImageIcon(root_images + ":/imgs_calcula_upes/calculaupes_icon_modified.png");
		label_icon = new JLabel(icono_app);
		label_icon.setBounds(130, 450, 200, 100);
		add(label_icon);

		// TextArea

		txtarea_ads = new JTextArea();
		txtarea_ads.setEditable(false);
		txtarea_ads.setBackground(Color.DARK_GRAY);
		txtarea_ads.setForeground(Color.WHITE);
		txtarea_ads.setFont(new Font("Courier New", 1, 20));
		txtarea_ads.setSize(250, 1200);

		// ScrollBar
		scroll = new JScrollPane(txtarea_ads);
		scroll.setBounds(400, 70, 250, 300);
		add(scroll);

		// TextFields
		correo0 = new JTextField();
		correo0.setBounds(50, 70, 300, 40);
		correo0.setFont(new Font("Courier New", 1, 20));
		add(correo0);

		correo1 = new JTextField();
		correo1.setBounds(50, 130, 300, 40);
		correo1.setFont(new Font("Courier New", 1, 20));
		add(correo1);

		correo2 = new JTextField();
		correo2.setBounds(50, 190, 300, 40);
		correo2.setFont(new Font("Courier New", 1, 20));
		add(correo2);

		correo3 = new JTextField();
		correo3.setBounds(50, 250, 300, 40);
		correo3.setFont(new Font("Courier New", 1, 20));
		add(correo3);

		correo4 = new JTextField();
		correo4.setBounds(50, 310, 300, 40);
		correo4.setFont(new Font("Courier New", 1, 20));
		add(correo4);

		// Buttons
		limpiar = new JButton("Limpiar todo");
		limpiar.setBackground(Color.LIGHT_GRAY);
		add(limpiar);
		limpiar.setBounds(180, 400, 150, 40);
		limpiar.setFont(new Font("Andale Mono", 1, 14));
		limpiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int option_selected = JOptionPane.showConfirmDialog(null,
						"¿Estas seguro/a de borrar todos los campos?");
				if (option_selected == 0) {
					correo0.setText("");
					correo1.setText("");
					correo2.setText("");
					correo3.setText("");
					correo4.setText("");

					txtarea_ads.setText("");
					label_img0_error.setVisible(false);
					label_img1_error.setVisible(false);
					label_img2_error.setVisible(false);
					label_img3_error.setVisible(false);
					label_img4_error.setVisible(false);
					label_img0_suc.setVisible(false);
					label_img0_suc.setVisible(false);
					label_img1_suc.setVisible(false);
					label_img2_suc.setVisible(false);
					label_img3_suc.setVisible(false);
					label_img4_suc.setVisible(false);
				}

			}
		});

		enviar = new JButton("Enviar aplicación");
		enviar.setBackground(Color.LIGHT_GRAY);
		add(enviar);
		enviar.setBounds(350, 400, 200, 40);
		enviar.setFont(new Font("Andale Mono", 1, 14));
		enviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/* configuracion de correo */
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");
				/* cuenta que recive para enviar */
				final String usuario = "ra201701@upes.edu.sv";
				final String password = "Edrawfit8";
				Session sesion = Session.getInstance(props, new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(usuario, password);
					}
				});

				/******* Validaciones *********/

				// Correo 0
				if (!correo0.getText().isEmpty()) {
					try {
						Message mail0 = new MimeMessage(sesion);
						mail0.setFrom(new InternetAddress(email_server));
						mail0.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo0.getText()));
						mail0.setSubject(txt_subject);

						Multipart contenido = new MimeMultipart();
						BodyPart cuerpo = new MimeBodyPart();
						// MimeBodyPart adjunto_cuerpo = new MimeBodyPart();
						cuerpo.setText(
								"Muchas gracias por brindarnos tu correo, toca el siguiente enlace para que descargues y continues con la instalacion.\n\nhttps://docs.google.com/uc?export=download&id=1aUWtxmf2T5lCD6xbr1W8GFrbr8zUxEcU");
						contenido.addBodyPart(cuerpo);
						// contenido.addBodyPart(adjunto_cuerpo);
						mail0.setContent(contenido);
						Transport.send(mail0);
						label_img0_error.setVisible(false);
						label_img0_suc.setVisible(true);
						// JOptionPane.showMessageDialog(null, "Aplicacion enviada con exito");
					} catch (MessagingException ex) {
						JOptionPane.showMessageDialog(null, "Error al enviar a correo 1, revisar avisos");
						label_img0_suc.setVisible(false);
						label_img0_error.setVisible(true);
						String error0 = "Correo 1 no escrito\nCorrectamente o no\nexiste\n";
						notifies = notifies + error0;
						txtarea_ads.setText(notifies);
					}
				}

				// Correo 1
				if (!correo1.getText().isEmpty()) {
					try {
						Message mail1 = new MimeMessage(sesion);
						mail1.setFrom(new InternetAddress(email_server));
						mail1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo1.getText()));
						mail1.setSubject(txt_subject);

						Multipart contenido = new MimeMultipart();
						BodyPart cuerpo = new MimeBodyPart();
						// MimeBodyPart adjunto_cuerpo = new MimeBodyPart();
						cuerpo.setText(
								"Muchas gracias por brindarnos tu correo, toca el siguiente enlace para que descargues y continues con la instalacion.\n\nhttps://docs.google.com/uc?export=download&id=1aUWtxmf2T5lCD6xbr1W8GFrbr8zUxEcU");
						contenido.addBodyPart(cuerpo);
						// contenido.addBodyPart(adjunto_cuerpo);
						mail1.setContent(contenido);
						Transport.send(mail1);
						// JOptionPane.showMessageDialog(null, "Aplicacion enviada con exito");
						label_img1_error.setVisible(false);
						label_img1_suc.setVisible(true);
					} catch (MessagingException ex) {
						JOptionPane.showMessageDialog(null, "Error al enviar a correo 2, revisar avisos");
						label_img1_suc.setVisible(false);
						label_img1_error.setVisible(true);
						String error1 = "Correo 2 no escrito\nCorrectamente o no\nexiste\n";
						notifies = notifies + error1;
						txtarea_ads.setText(notifies);
					}
				}

				// Correo 2
				if (!correo2.getText().isEmpty()) {
					try {
						Message mail2 = new MimeMessage(sesion);
						mail2.setFrom(new InternetAddress(email_server));
						mail2.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo2.getText()));
						mail2.setSubject(txt_subject);

						Multipart contenido = new MimeMultipart();
						BodyPart cuerpo = new MimeBodyPart();
						// MimeBodyPart adjunto_cuerpo = new MimeBodyPart();
						cuerpo.setText(
								"Muchas gracias por brindarnos tu correo, toca el siguiente enlace para que descargues y continues con la instalacion.\\n\\nhttps://docs.google.com/uc?export=download&id=1aUWtxmf2T5lCD6xbr1W8GFrbr8zUxEcU");
						contenido.addBodyPart(cuerpo);
						// contenido.addBodyPart(adjunto_cuerpo);
						mail2.setContent(contenido);
						Transport.send(mail2);
						// JOptionPane.showMessageDialog(null, "Aplicacion enviada con exito");
						label_img2_error.setVisible(false);
						label_img2_suc.setVisible(true);
					} catch (MessagingException ex) {
						JOptionPane.showMessageDialog(null, "Error al enviar a correo 3, revisar avisos");
						label_img2_suc.setVisible(false);
						label_img2_error.setVisible(true);
						String error2 = "Correo 3 no escrito\nCorrectamente o no\nexiste\n";
						notifies = notifies + error2;
						txtarea_ads.setText(notifies);
					}
				}

				// Correo 3
				if (!correo3.getText().isEmpty()) {
					try {
						Message mail3 = new MimeMessage(sesion);
						mail3.setFrom(new InternetAddress(email_server));
						mail3.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo3.getText()));
						mail3.setSubject(txt_subject);

						Multipart contenido = new MimeMultipart();
						BodyPart cuerpo = new MimeBodyPart();
						// MimeBodyPart adjunto_cuerpo = new MimeBodyPart();
						cuerpo.setText(
								"Muchas gracias por brindarnos tu correo, toca el siguiente enlace para que descargues y continues con la instalacion.\n\nhttps://docs.google.com/uc?export=download&id=1aUWtxmf2T5lCD6xbr1W8GFrbr8zUxEcU");
						contenido.addBodyPart(cuerpo);
						// contenido.addBodyPart(adjunto_cuerpo);
						mail3.setContent(contenido);
						Transport.send(mail3);
						// JOptionPane.showMessageDialog(null, "Aplicacion enviada con exito");
						label_img3_error.setVisible(false);
						label_img3_suc.setVisible(true);
					} catch (MessagingException ex) {
						JOptionPane.showMessageDialog(null, "Error al enviar a correo 4, revisar avisos");
						label_img3_suc.setVisible(false);
						label_img3_error.setVisible(true);
						String error3 = "Correo 4 no escrito\nCorrectamente o no\nexiste\n";
						notifies = notifies + error3;
						txtarea_ads.setText(notifies);
					}
				}

				// Correo 4
				if (!correo4.getText().isEmpty()) {
					try {
						Message mail4 = new MimeMessage(sesion);
						mail4.setFrom(new InternetAddress(email_server));
						mail4.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo4.getText()));
						mail4.setSubject(txt_subject);

						Multipart contenido = new MimeMultipart();
						BodyPart cuerpo = new MimeBodyPart();
						// MimeBodyPart adjunto_cuerpo = new MimeBodyPart();
						cuerpo.setText(
								"Muchas gracias por brindarnos tu correo, toca el siguiente enlace para que descargues y continues con la instalacion.\n\nhttps://docs.google.com/uc?export=download&id=1aUWtxmf2T5lCD6xbr1W8GFrbr8zUxEcU");
						contenido.addBodyPart(cuerpo);
						/*
						 * Adjuntar el archivo al correo FileDataSource source = new FileDataSource(
						 * "C:/Users/Edgar/eclipse-workspace/Sendapp/src/resource/Calcula_Upes[v1.2].apk"
						 * ); adjunto_cuerpo.setDataHandler(new DataHandler(source));
						 * adjunto_cuerpo.setFileName(source.getName());
						 */
						// contenido.addBodyPart(adjunto_cuerpo);
						mail4.setContent(contenido);
						Transport.send(mail4);
						// JOptionPane.showMessageDialog(null, "Aplicacion enviada con exito");
						label_img4_error.setVisible(false);
						label_img4_suc.setVisible(true);
					} catch (MessagingException ex) {
						JOptionPane.showMessageDialog(null, "Error al enviar a correo 5, revisar avisos");
						label_img4_suc.setVisible(false);
						label_img4_error.setVisible(true);
						String error4 = "Correo 5 no escrito\nCorrectamente o no\nexiste\n";
						notifies = notifies + error4;
						txtarea_ads.setText(notifies);
					}
				}

			}
		});
		/**************************************************
		 * fin del contenido del formulario
		 **************************************************/
		setSize(720, 580);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	/* metodo principal cargando tema y formulario */
	public static void main(String args[]) {
		String letter_format = JOptionPane.showInputDialog(null, "Escriba la letra de su disco duro");
		new Sendapp(letter_format);
	}
}

/* classe del limitador de caracteres */
