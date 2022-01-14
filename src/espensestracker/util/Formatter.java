/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.util;

import java.text.NumberFormat;

/**
 *
 * @author Aravinda
 */
public class Formatter {
    
    public static String currencyFormat(double number) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(number);
    }
}
