package Tablas;

import javax.swing.table.AbstractTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * Tabla de datos que mostrara los alquileres actuales.
 *
 * @author Carlos
 */
public class TableAlquileres extends AbstractTableModel {

    //Atributos
    private JSONArray data;
    private String[] columnNames;

    //Constructor.
    public TableAlquileres(JSONArray data, String[] columnames) {
        this.data = data;
        this.columnNames = columnames;
    }

    @Override
    public int getRowCount() {
        return data.length();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        JSONObject jsonObject = data.getJSONObject(rowIndex);
        String columname = columnNames[columnIndex];
        return jsonObject.get(columname);

    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}
