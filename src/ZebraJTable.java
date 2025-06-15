import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel; // if you use a constructor with TableModel

public class ZebraJTable extends JTable {

    public ZebraJTable() {
        super();
    }

    public ZebraJTable(TableModel dm) {
        super(dm);
    }

    // Add other constructors you might need, e.g., (Object[][] rowData, Object[] columnNames)

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (!isRowSelected(row)) {
            c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240));
        }
        // If you want to make sure the selected row's background isn't overridden by your logic
        // else {
        //     c.setBackground(getSelectionBackground());
        // }
        return c;
    }
}