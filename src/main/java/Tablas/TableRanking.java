package Tablas;

import javax.swing.table.AbstractTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * Tabla de datos que mostrara el ranking de las peliculas de la aplicacion.
 *
 * @author Carlos
 */
public class TableRanking extends AbstractTableModel {

    //Atributos
    private JSONArray data;
    private String[] columnNames;

    //Constructor.
    public TableRanking(JSONArray data, String[] columnames) {
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
