/**
 * Java Steam Random Games Picker Package
 */
package org.bohverkill.JSRGP;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Java Steam Random Games Picker Model Class
 *
 * @author BOHverkill
 * @version 1.0
 * @see JSRGPControl
 * @see JSRGPView
 * @see GameInfo
 */
public class JSRGPModel {

    private static final Logger logger = LogManager.getLogger(JSRGPModel.class.getName());
    private static final String path = System.getProperty("user.home") + "/.local/share/Steam/SteamApps/";
    private ArrayList<GameInfo> installedGames;
    private GameInfo randGame;
    private Random r;


    /**
     * The default constructor
     */
    public JSRGPModel() {
        r = new Random();
        File dir = new File(JSRGPModel.path);
        String[] files = dir.list((dir1, name) -> name.startsWith("appmanifest_") && name.endsWith(".acf"));
        // Arrays.sort(files); // for list sorting
        this.installedGames = new ArrayList<>();
        for (String file : files) {
            try {
                List<String> fileContent = Files.readAllLines(Paths.get(path, file));
                int appID = Integer.parseInt("" + fileContent.get(2).substring(11, fileContent.get(2).length() - 1));
                // Fix that steamVR is not in the List
                if (appID == 250820)
                    continue;
                String name = fileContent.get(4).substring(10, fileContent.get(4).length() - 1);
                this.installedGames.add(new GameInfo(appID, name));
            } catch (Exception e) {
                logger.error(e);
                System.exit(1);
            }
        }
        this.randGame = this.installedGames.get(r.nextInt(this.installedGames.size()));
        logger.info("Game: " + this.randGame.getName() + " AppID: " + this.randGame.getAppID());
    }

    /**
     * Generates a new Random Game
     *
     * @return new random Game
     * @see GameInfo
     */
    public GameInfo getNewRandomGame() {
        this.randGame = this.installedGames.get(r.nextInt(this.installedGames.size()));
        logger.info("Game: " + this.randGame.getName() + " AppID: " + this.randGame.getAppID());
        return this.randGame;
    }

    /**
     * Returns the current Random Game
     *
     * @return current Game
     * @see GameInfo
     */
    public GameInfo getCurrentRandomGame() {
        return this.randGame;
    }
}
