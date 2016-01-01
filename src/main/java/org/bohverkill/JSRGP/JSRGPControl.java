/**
 * Java Steam Random Games Picker Package
 */
package org.bohverkill.JSRGP;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
 * @see ActionListener
 */
public class JSRGPControl implements ActionListener {

    private static final Logger logger = LogManager.getLogger(JSRGPControl.class.getName());
    private JSRGPModel jModel;
    private JSRGPView jView;

    /**
     * The default contractor
     */
    public JSRGPControl() {
        this.jModel = new JSRGPModel();
        this.jView = new JSRGPView(this, jModel);
    }

    /**
     * The main method
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        try {
            new JSRGPControl();
        } catch (Throwable t) {
            logger.error(t);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (jView.isButtonBPick(ae))
            this.jView.setTextJLabelGame(this.jModel.getNewRandomGame().getName());
        if (jView.isButtonBStart(ae)) {
            try {
                logger.info("Starting Game:" + this.jModel.getCurrentRandomGame().getName() + " AppID:" + this.jModel.getCurrentRandomGame().getAppID());
                logger.info("steam -applaunch " + this.jModel.getCurrentRandomGame().getAppID());
                Process p = Runtime.getRuntime().exec("steam -applaunch " + this.jModel.getCurrentRandomGame().getAppID());
                System.out.println("" + p.waitFor());
            } catch (Exception e) {
                logger.error(e);
                System.exit(1);
            }
        }
    }

}
