/**
 * Java Steam Random Games Picker Package
 */
package org.bohverkill.JSRGP;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Java Steam Random Games Picker View Class
 * 
 * @author BOHverkill
 * @version 1.0
 * @see JSRGPControl
 * @see JSRGPModel
 * @see GameInfo
 */
public class JSRGPView extends JFrame {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -1904283095898395950L;
	private JSRGPControl jControl;
	private JSRGPModel jModel;
	private JButton bpick;
	private JLabel lgame;
	private JButton bstart;

	/**
	 * The constructor
	 * 
	 * @param jControl
	 *            {@link JSRGPControl} object
	 * @param jModel
	 *            {@link JSRGPModel} object
	 * @see JSRGPControl
	 * @see JSRGPView
	 */
	public JSRGPView(JSRGPControl jControl, JSRGPModel jModel) {
		super("JSGP");
		this.jControl = jControl;
		this.jModel = jModel;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250, 150);
		this.setLayout(new GridLayout(3, 0));
		this.bpick = new JButton("Pick Game");
		this.bpick.addActionListener(this.jControl);
		this.lgame = new JLabel(this.jModel.getCurrentRandomGame().getName(), JLabel.CENTER);
		this.bstart = new JButton("Start Game");
		this.bstart.addActionListener(this.jControl);
		this.add(this.bpick);
		this.add(this.lgame);
		this.add(this.bstart);

		this.setVisible(true);
	}

	/**
	 * Checks if the {@link ActionEvent} source is the {@link JButton} Button
	 * "Pick Game"
	 * 
	 * @param e
	 *            the {@link ActionEvent}
	 * @return if ActionEvent e.getSource() it the {@link JButton} "Pick Game"
	 *         return true else false
	 * @see ActionEvent
	 * @see JButton
	 */
	public boolean isButtonBPick(ActionEvent e) {
		return (e.getSource() == this.bpick);
	}

	/**
	 * Checks if the {@link ActionEvent} source is the {@link JButton} Button
	 * "Start Game"
	 * 
	 * @param e
	 *            the {@link ActionEvent}
	 * @return if ActionEvent e.getSource() it the {@link JButton} "Start Game"
	 *         return true else false
	 * @see ActionEvent
	 * @see JButton
	 */
	public boolean isButtonBStart(ActionEvent e) {
		return (e.getSource() == this.bstart);
	}

	/**
	 * Sets the Text of the {@link JLabel} label Game Name
	 * 
	 * @param text
	 *            the text
	 * @see JLabel
	 */
	public void setTextJLableGame(String text) {
		this.lgame.setText(text);
	}

}
