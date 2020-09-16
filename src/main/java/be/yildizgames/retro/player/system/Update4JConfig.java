/*
 * Copyright (C) Grégory Van den Borre - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Grégory Van den Borre <vandenborre.gregory@hotmail.com> 2019
 */

package be.yildizgames.retro.player.system;

import org.update4j.Configuration;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Entry point and updater for the play50hz player, this application will download the config.xml and compare with the existing data to
 * define if an update is required of not.
 *
 * This application should not have to be updated by itself for now to prevent user to have to do it manually.
 * This application must have the least possible dependencies as it will have the manager in the classpath, so every dependency used by this app
 * could hide the ones in the manager.
 *
 * @author Grégory Van den Borre
 */
public class Update4JConfig {


    public static void main(String[] args)  {
        try {
            String url = "http://files.yildiz-games.be/updater/play50hz-player-lib.xml";
            if(Files.exists(Path.of("test-env"))) {
                url = "http://files.yildiz-games.be/updater/play50hz-player-test-lib.xml";
            }
            Configuration config = Configuration.read(new HttpRequest().getReader(url));
            config.update();
            config.launch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
