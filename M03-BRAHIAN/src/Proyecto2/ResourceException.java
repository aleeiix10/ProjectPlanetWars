package Proyecto2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.Border;

public class ResourceException extends Exception{
	
	public ResourceException(String msg){
		new PopUpPers(msg, "iconoRecursos.png",50,50);
	}
	
}
class PopUpPers extends JOptionPane{
	private JFrame a = new JFrame();
	private JButton boton=new JButton();
    private UIManager UI=new UIManager();
   
    Toolkit pantalla= Toolkit.getDefaultToolkit();
    Image imagen= pantalla.getImage("iconoTotal.png");
    PopUpPers(String msg,String ruta,int anchura,int altura){
		Image img = new ImageIcon(ruta).getImage();
		Image newimg = img.getScaledInstance(anchura, altura,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(newimg);
	    boton.setFocusable(false);
	    boton.setBackground(new Color(237, 52, 71));
	    boton.setText("OK");
	    boton.setForeground(Color.white);
	    boton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			a.dispose();
		}
	});
    a.setIconImage(imagen);
    UI.put("OptionPane.background", Color.black);
    UI.put("OptionPane.messageForeground", Color.white);
    UI.put("Panel.background", Color.black);
    JButton[] botones= {boton};
    JOptionPane.showOptionDialog(a, msg,"ERROR",JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,imageIcon,botones,botones[0]);
    }
    PopUpPers(String msg,String titulo,String ruta,int anchura,int altura){
		Image img = new ImageIcon(ruta).getImage();
		Image newimg = img.getScaledInstance(anchura, altura,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(newimg);
	    boton.setFocusable(false);
	    boton.setBackground(new Color(237, 52, 71));
	    boton.setText("OK");
	    boton.setForeground(Color.white);
	    boton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			a.dispose();
		}
	});
    a.setIconImage(imagen);
    UI.put("OptionPane.background", Color.black);
    UI.put("OptionPane.messageForeground", Color.white);
    UI.put("Panel.background", Color.black);
    JButton[] botones= {boton};
    JOptionPane.showOptionDialog(a, msg,titulo,JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,imageIcon,botones,botones[0]);
    } 
}