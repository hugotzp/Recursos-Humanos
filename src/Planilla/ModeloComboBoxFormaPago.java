/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planilla;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hugo
 */
public class ModeloComboBoxFormaPago extends JComboBox implements TableCellRenderer{
    String[]items;
    public ModeloComboBoxFormaPago(String[] items) {
        super(items);
        this.items = items;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
        if (isSelected) {
          setForeground(table.getSelectionForeground());
          super.setBackground(table.getSelectionBackground());
        } else {
          setForeground(table.getForeground());
          setBackground(table.getBackground());
        }
        System.out.println(value);
        setSelectedItem(value);
        return this;
    }
    



    
}
