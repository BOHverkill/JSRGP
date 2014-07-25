/**
 * Java Steam Random Games Picker Package
 */
package org.bohverkill.JSRGP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Java Steam Random Games Picker Control Class
 * 
 * @author BOHverkill
 * @version 1.0
 * @see JSRGPModel
 * @see JSRGPView
 * @see GameInfo
 */
public class JSRGPControl implements ActionListener {

	private JSRGPModel jModel;
	private JSRGPView jView;

	/**
	 * The default contractor
	 */
	public JSRGPControl() {
		this.jModel = new JSRGPModel();
		this.jView = new JSRGPView(this, jModel);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (jView.isButtonBPick(ae))
			this.jView.setTextJLableGame(this.jModel.getNewRandomGame().getName());
		if (jView.isButtonBStart(ae)) {
			try {
				System.out.println("Starting Game:" + this.jModel.getCurrentRandomGame().getName() + " AppID:" + this.jModel.getCurrentRandomGame().getAppID());
				System.out.println("steam -applaunch " + this.jModel.getCurrentRandomGame().getAppID());
				Process p = Runtime.getRuntime().exec("steam -applaunch " + this.jModel.getCurrentRandomGame().getAppID());
				System.out.println("" + p.waitFor());
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	/**
	 * The main method
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		new JSRGPControl();

	}

}
