package pe.com.sgs.appsgs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.List;

import pe.com.sgs.appsgs.dao.MyDbHelper;
import pe.com.sgs.appsgs.dao.SQLController;
import pe.com.sgs.appsgs.model.Orden;

public class ListviewActivity extends AppCompatActivity {

    SQLController sqlcon;
    SharedPreferences settings;
    LocationManager locationManager;
    Intent intent;

    List<Orden> listarOrdenes;

    ListView lv_ordenes;

    private int[] valores;
    private String[] itemsValor;
    private String[] itemsDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lv_ordenes = (ListView) findViewById(R.id.lv_ordenes);

        sqlcon = new SQLController(this);
        settings = getSharedPreferences("ValorLogin", 0);

        sqlcon.open();
        sqlcon.eliminarOrdenes();
        sqlcon.grabarOrdenes();
        listarOrdenes = sqlcon.listarOrdenes();
        sqlcon.close();

        valores = new int[listarOrdenes.size()];
        itemsValor = new String[listarOrdenes.size()];
        itemsDescripcion = new String[listarOrdenes.size()];
        for (int i = 0; i < listarOrdenes.size(); i++) {
            itemsValor[i] = String.valueOf(listarOrdenes.get(i).getCodigoOrden());
            itemsDescripcion[i] = listarOrdenes.get(i).getDescripcionOrden();
        }

        ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.simple_list_item_1, itemsDescripcion);
        lv_ordenes.setAdapter(ad);

        lv_ordenes.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*
                Cursor cursor = (Cursor) parent.getItemAtPosition(position);
                int idOrden = cursor.getInt(cursor.getColumnIndexOrThrow(MyDbHelper.ORDEN_ID));
                String codigoOrden = cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.ORDEN_CODIGO));
                String descripcionOrden = cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.ORDEN_DESCRIPCION));
                */
                String valorSeleccionado = (String)parent.getItemAtPosition(position);

                String codigoOrden = "";
                sqlcon.open();
                codigoOrden = sqlcon.obtenerCodigoOrden(valorSeleccionado);
                sqlcon.close();

                //System.out.println("Cod: " + codigoOrden + " - Desc : " + valorSeleccionado);

                SharedPreferences.Editor editor = settings.edit();
                editor.putString("codigoOrden", codigoOrden);
                editor.putString("descripcionOrden", valorSeleccionado);
                editor.commit();

                intent = new Intent(ListviewActivity.this, MenuActivity.class);
                startActivity(intent);

            }
        });
    }
}
