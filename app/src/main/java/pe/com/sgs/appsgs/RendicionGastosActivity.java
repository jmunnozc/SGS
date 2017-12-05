package pe.com.sgs.appsgs;

import android.content.SharedPreferences;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.oprisnik.navdrawer.entry.NavDrawerEntry;

import java.util.ArrayList;
import java.util.List;

import pe.com.sgs.appsgs.dao.SQLController;
import pe.com.sgs.appsgs.util.BaseDrawerActivity;

public class RendicionGastosActivity extends BaseDrawerActivity {

    SQLController sqlcon;
    SharedPreferences settings;
    Spinner spTipoDocumento, spCategoriaDocumento;
    List<String> listaTipoDocumento;
    List<String> listaCategoriaDocumento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendicion_gastos);

        overridePendingTransition(0, 0);

        sqlcon = new SQLController(this);

        settings = getSharedPreferences("ValorLogin", 0);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setTitle(ENTRY3.getTitleResId());
        if (tb != null) {
            setSupportActionBar(tb);
        }
        // we do not want the up arrow (<-) here
        showUpNavigation(false);

        spTipoDocumento = (Spinner) findViewById(R.id.spTipoDocumento);
        spCategoriaDocumento = (Spinner) findViewById(R.id.spCategoriaDocumento);

        final ArrayAdapter<String> dataAdapterTipoDocumento;
        listaTipoDocumento = new ArrayList<>();
        listaCategoriaDocumento = new ArrayList<>();

        sqlcon.open();
        sqlcon.eliminarTipoDocumento();
        sqlcon.grabarTipoDocumento();
        sqlcon.eliminarCategoriaDocumento();
        sqlcon.grabarCategoriaDocumento();
        listaTipoDocumento = sqlcon.listarTipoDocumento();
        sqlcon.close();

        dataAdapterTipoDocumento = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaTipoDocumento);
        dataAdapterTipoDocumento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoDocumento.setAdapter(dataAdapterTipoDocumento);

        spTipoDocumento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String valorSeleccionado = (String)parent.getItemAtPosition(position);
                String codigoValorSeleccionado = "";

                sqlcon.open();
                codigoValorSeleccionado = sqlcon.obtenerCodigoTipoDocumento(valorSeleccionado);
                listaCategoriaDocumento = sqlcon.listarCategoriaDocumento(codigoValorSeleccionado);
                sqlcon.close();

                ArrayAdapter<String> dataAdapterCategoriaDocumento = new ArrayAdapter<String>(RendicionGastosActivity.this, android.R.layout.simple_spinner_item, listaCategoriaDocumento);
                dataAdapterCategoriaDocumento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spCategoriaDocumento.setAdapter(dataAdapterCategoriaDocumento);

                //System.out.println("Valor : " + valorSeleccionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public NavDrawerEntry getSelectedNavDrawerItem() {
        return ENTRY3;
    }
}
