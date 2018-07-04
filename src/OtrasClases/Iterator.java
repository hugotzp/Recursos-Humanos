/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtrasClases;

import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public interface Iterator {
    public boolean hasMore();
    public Object getNext();
    public void reset();
}
