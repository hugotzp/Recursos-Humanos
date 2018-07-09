/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

/**
 *
 * @author Hugo
 */
public class ComboBoxCellEditor extends DefaultCellEditor{
    
  public ComboBoxCellEditor(String[] items) {
    super(new JComboBox(items));
  }

}
