package pe.com.sgs.appsgs.util;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.oprisnik.navdrawer.NavDrawerActivity;
import com.oprisnik.navdrawer.entry.NavDrawerDivider;
import com.oprisnik.navdrawer.entry.NavDrawerEntry;

import java.util.ArrayList;
import java.util.List;

import pe.com.sgs.appsgs.ActividadesActivity;
import pe.com.sgs.appsgs.ListviewActivity;
import pe.com.sgs.appsgs.MainActivity;
import pe.com.sgs.appsgs.R;
import pe.com.sgs.appsgs.RendicionGastosActivity;
import pe.com.sgs.appsgs.ReporteActivity;

/**
 * Base drawer activity that defines the drawer structure
 */
public abstract class BaseDrawerActivity extends NavDrawerActivity {

    SharedPreferences settings;
    // Simple entry
    public static final NavDrawerEntry ENTRY1 = new NavDrawerEntry.Builder()
            .setTitleResId(R.string.title_entry_1)
            .setIconResId(R.drawable.ic_alarm_on_black_24dp)
            .build();

    // Using Builder
    public static final NavDrawerEntry ENTRY2 = new NavDrawerEntry.Builder()
            .setTitleResId(R.string.title_entry_2)
            .setIconResId(R.drawable.ic_insert_chart_black_24dp)
            .build();

    // Custom highlight color
    public static final NavDrawerEntry ENTRY3 = new NavDrawerEntry.Builder()
            .setTitleResId(R.string.title_entry_3)
            .setIconResId(R.drawable.ic_attach_money_black_24dp)
            .build();

    public static final NavDrawerEntry ENTRY_CLOSE = new NavDrawerEntry.Builder()
            .setTitleResId(R.string.cerrarSesion)
            .setIconResId(R.drawable.ic_power_settings_new_black_48dp)
            .build();

    public static final List<NavDrawerEntry> NAV_ITEMS = new ArrayList<NavDrawerEntry>();

    static {

        // Our navigation drawer does not change -> we can use a static list

        // First section
        //NAV_ITEMS.add(new NavDrawerSubheader(R.string.title_section1));
        NAV_ITEMS.add(ENTRY1);
        NAV_ITEMS.add(ENTRY2);
        NAV_ITEMS.add(ENTRY3);

        NAV_ITEMS.add(new NavDrawerDivider());

        NAV_ITEMS.add(ENTRY_CLOSE);

    }

    @Override
    public List<NavDrawerEntry> getNavDrawerItems() {
        return NAV_ITEMS;
    }

    @Override
    public void onHeaderClicked() {
        Toast.makeText(this, "Header clicked!", Toast.LENGTH_SHORT).show();
    }

    protected void updateHeaderInfo() {

        settings = getSharedPreferences("ValorLogin", 0);

        String usuario      = settings.getString("codigoOrden", null);
        String institucion  = settings.getString("descripcionOrden", null);

        getDrawerLayout().setHeaderTitle(usuario);
        getDrawerLayout().setHeaderSubtitle(institucion);
        getDrawerLayout().setHeaderBackgroundColor(getResources().getColor(R.color.colorPrincipal));

    }

    @Override
    public void onEntrySelected(NavDrawerEntry entry) {

        settings = getSharedPreferences("ValorLogin", 0);

        if (ENTRY1.equals(entry)) {
            Intent intent = new Intent(this, ActividadesActivity.class);
            startActivity(intent);
            finish();
        }else if (ENTRY2.equals(entry)) {
            Intent intent = new Intent(this, ReporteActivity.class);
            startActivity(intent);
            finish();
        }else if (ENTRY3.equals(entry)) {
            Intent intent = new Intent(this, RendicionGastosActivity.class);
            startActivity(intent);
            finish();
        } else if (ENTRY_CLOSE.equals(entry)) {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateHeaderInfo();
    }
}
