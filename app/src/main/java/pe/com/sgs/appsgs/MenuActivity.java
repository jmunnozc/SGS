package pe.com.sgs.appsgs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.oprisnik.navdrawer.entry.NavDrawerEntry;

import pe.com.sgs.appsgs.dao.SQLController;

import pe.com.sgs.appsgs.util.BaseDrawerActivity;

public class MenuActivity extends BaseDrawerActivity {

    SQLController sqlcon;
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        overridePendingTransition(0, 0);

        sqlcon = new SQLController(this);

        settings = getSharedPreferences("ValorLogin", 0);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setTitle(ENTRY1.getTitleResId());
        if (tb != null) {
            setSupportActionBar(tb);
        }

        // we do not want the up arrow (<-) here
        showUpNavigation(false);
    }

    @Override
    public NavDrawerEntry getSelectedNavDrawerItem() {
        return ENTRY1;
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        /*
        sqlcon.open();
        pendientes = sqlcon.buscarRespuestasCabeceraPendientesSincronizacion(settings.getString(Constantes.CODIGO_DISPOSITIVO, null));
        sqlcon.close();

        if(pendientes.size() > 0) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }
        */
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /*
        if (id == R.id.menuScrinonizar) {

            if (Util.isOnline(MenuActivity.this)) {
                startService(new Intent(getBaseContext(), Servicio.class));
            }

            return true;

        }
        */

        return super.onOptionsItemSelected(item);

    }
}
