package GUI;

// 
import javax.swing.*;
// invocacion de gestores de diseño java
import java.awt.BorderLayout;
import java.awt.GridLayout;
// invocacion de eventos java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
// invocacion para las listas java
import java.util.ArrayList;
// invocacion para logica de programa
import logica.*;

/**
 * @author daniel
 *
 */

public class Interfaz extends JFrame implements ActionListener, KeyListener{

	// 
	JTextField numero = new JTextField();
	// contenedores dede los botones
	JPanel panelNumero = new JPanel();
	JPanel panelBotones = new JPanel();
	// creando objeto boton
	JButton b;
	// etiquetas para los botones
	String[] numeroBtn = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "0" };
	String[] textoBtn = { "Borrar", "Saber derivacion estandar", "Abrir archivo", "Nuevo numero", "Promedio"};
	// objeto para seleccionar el archivo
	JFileChooser archivo = new JFileChooser();
	// lista para almacenar los datos
	ArrayList<Double> datos = new ArrayList<Double>();
	// creando objeto para calcular el objeto
	Calcular cal = new Calcular();
	// crear objeto para leer archivo
	LeerArchivo leer = new LeerArchivo();
	
	public Interfaz(){

		super( "desviacion");
		// asignando gestor para el panel numerico
		panelNumero.setLayout( new GridLayout( 4, 3, 1, 1));
		// creando botones numericos
		for( String x: numeroBtn){
			// crear objeto boton
			b = new JButton(x);
			// asignar evento para el boton
			b.addActionListener(this);
			// agregando boton al panel numerico 
			panelNumero.add( b);
		}
		// asignando gestor para panel de botones de accion
		panelBotones.setLayout( new GridLayout( textoBtn.length, 1, 1, 1));
		// crear botones de accion
		for( String x: textoBtn){
			// crear objeto boton
			b = new JButton( x);
			// asignar evento para el boton
			b.addActionListener(this);
			// agregar boton para el panel de acciones
			panelBotones.add( b);
		}
		
		// asignar evento al jTextField
		numero.addKeyListener( this);
		
		// asignando gestor de diseño al JFrame
		setLayout( new BorderLayout());
		// asignar posicion al JTextField
		add( numero, BorderLayout.NORTH);
		// asignar posicion al panel numerico
		add( panelNumero, BorderLayout.CENTER);
		// asignar posicion al panel de accion
		add( panelBotones, BorderLayout.EAST);
		// asignar tamaño el JFrame
		pack();
		// JFrame visible
		setVisible( true);
		// JFrame no sea redimenciones
		setResizable(false);
		// asignar ubicacion en la pantalla
		setLocationRelativeTo( null);
		// evento para cerrar JFrame
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		// crear objeto para realizar operancion en el juego
		Calcular cal = new Calcular();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// obtener la etiqueta del boton
		String[] parametrosBtn = e.paramString().split(",");
		String txt =  parametrosBtn[1].replaceAll( "cmd=", "");
		// seleccion de accion en el programa segun el boton
		switch( txt){
			case "Borrar":
				// borrar texto en el JtextField
				numero.setText("");
			break;
			case "Saber derivacion estandar":
				// calcular la derivacion estandar
				numero.setText( "derivacion estandar: " + cal.desviacionEstandar(datos));
				datos.clear();
				break;
			case "Abrir archivo":
				// seleccionar archivo a leer
				archivo.showOpenDialog( this);
				// almacendado datos al programa desde archivo
				datos = leer.leer( archivo.getSelectedFile());
				break;
			case "Nuevo numero":
				// almacenar datos desde el JTextField
				datos.add( Double.parseDouble( numero.getText()));
				numero.setText("");
				break;
			case "Promedio":
				// almacenar datos desde el JTextFields
				numero.setText( cal.promedio( datos) + " ");
				break;
			default:
				// agregar numero al JTextField
				numero.setText( numero.getText() + txt);
				break;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// en caso si preciona la tecla enter
		if( e.getKeyCode() == 10){
			// almacenda datos del JTextField al programa
			datos.add( Double.parseDouble( numero.getText()));
			numero.setText("");
		}
		// calcular desviacion de prescionala tebla espacio
		if( e.getKeyCode() == 32){
			numero.setText( "derivacion estandar: " + cal.desviacionEstandar(datos));
			datos.clear();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

