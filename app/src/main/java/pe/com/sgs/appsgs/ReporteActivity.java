package pe.com.sgs.appsgs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oprisnik.navdrawer.entry.NavDrawerEntry;

import java.util.ArrayList;
import java.util.List;

import pe.com.sgs.appsgs.dao.SQLController;
import pe.com.sgs.appsgs.model.Tarea;
import pe.com.sgs.appsgs.util.BaseDrawerActivity;

public class ReporteActivity extends BaseDrawerActivity {

    SQLController sqlcon;
    SharedPreferences settings;
    LocationManager locationManager;
    Intent intent;

    List<Tarea> listarTareas;

    ListView lv_tareas;

    private int[] valores;
    private String[] itemsValor;
    private String[] itemsDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        overridePendingTransition(0, 0);

        sqlcon = new SQLController(this);

        settings = getSharedPreferences("ValorLogin", 0);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setTitle(ENTRY2.getTitleResId());
        if (tb != null) {
            setSupportActionBar(tb);
        }
        // we do not want the up arrow (<-) here
        showUpNavigation(false);

        lv_tareas = (ListView) findViewById(R.id.lv_tareas);

        sqlcon.open();
        sqlcon.eliminarTareas();
        sqlcon.grabarTareas();
        listarTareas = sqlcon.listarTareas();
        sqlcon.close();

        valores = new int[listarTareas.size()];
        itemsValor = new String[listarTareas.size()];
        itemsDescripcion = new String[listarTareas.size()];
        for (int i = 0; i < listarTareas.size(); i++) {
            itemsValor[i] = String.valueOf(listarTareas.get(i).getCodigoTarea());
            itemsDescripcion[i] = listarTareas.get(i).getDescripcionTarea();
        }

        ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.simple_list_item_checked, itemsDescripcion);
        lv_tareas.setAdapter(ad);
        lv_tareas.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        lv_tareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*
                Cursor cursor = (Cursor) parent.getItemAtPosition(position);
                int idOrden = cursor.getInt(cursor.getColumnIndexOrThrow(MyDbHelper.ORDEN_ID));
                String codigoOrden = cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.ORDEN_CODIGO));
                String descripcionOrden = cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.ORDEN_DESCRIPCION));
                */
                String valorSeleccionado = (String)parent.getItemAtPosition(position);

                String codigoTarea = "";
                sqlcon.open();
                codigoTarea = sqlcon.obtenerCodigoTarea(valorSeleccionado);
                sqlcon.close();

                System.out.println("Cod: " + codigoTarea + " - Desc : " + valorSeleccionado);

            }
        });

    }

    @Override
    public NavDrawerEntry getSelectedNavDrawerItem() {
        return ENTRY2;
    }
}
