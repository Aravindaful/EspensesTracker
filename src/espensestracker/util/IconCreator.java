/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author RockKhan
 */
public class IconCreator {

    public Image loadApplicationIcon() {
        try {

            try {
                BufferedImage incomImg = ImageIO.read(getClass().getResource("/espensestracker/assets/main-ico.png"));
                Image dimgIncome = incomImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                return dimgIncome;
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
