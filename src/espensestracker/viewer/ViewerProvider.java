/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.viewer;

/**
 *
 * @author Aravinda
 */
public class ViewerProvider {
    public static ICurrentViewer provideCurrentViewer(String viewType) {
        if("JPanel".equalsIgnoreCase(viewType)){
            return new JPanelSelector();
        }
        
        
        return null;
    }
}
