/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.viewer;

import espensestracker.util.ViewIndex;

/**
 *
 * @author Aravinda
 */
public interface ICurrentViewer<T> {
    T select(ViewIndex viewIndex, int month);
}
