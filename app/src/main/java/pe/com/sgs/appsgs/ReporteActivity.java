package pe.com.sgs.appsgs;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oprisnik.navdrawer.entry.NavDrawerEntry;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;

import java.util.ArrayList;
import java.util.List;

import pe.com.sgs.appsgs.dao.SQLController;
import pe.com.sgs.appsgs.model.Tarea;
import pe.com.sgs.appsgs.util.BaseDrawerActivity;
import pe.com.sgs.appsgs.util.Constantes;
import pe.com.sgs.appsgs.util.Util;

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

    String latitudeField;
    String longitudeField;
    String altitudeField;
    String fechaField = "";
    MenuItem menuItemUser;
    MenuItem menuItem;
    Menu menu;

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

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //Activar GPS
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Util.alertaGpsDesactivado(this);
        }

        latitudeField = "0.0";
        longitudeField = "0.0";
        altitudeField = "0.0";

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

    private void obtenerCoordenadas() {

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            LocationListener locListener = new LocationListener() {

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                    // TODO Auto-generated method stub
                    //System.out.println("Status : " + status);
                }

                @Override
                public void onProviderEnabled(String provider) {
                    // TODO Auto-generated method stub
                    //System.out.println("onProviderEnabled : " + provider);
                }

                @Override
                public void onProviderDisabled(String provider) {
                    // TODO Auto-generated method stub
                    //System.out.println("onProviderDisabled : " + provider);
                }

                @Override
                public void onLocationChanged(Location location) {

                    latitudeField = String.valueOf(location.getLatitude());
                    longitudeField = String.valueOf(location.getLongitude());
                    altitudeField = String.valueOf(location.getAltitude());
                    fechaField = Util.fechaHoraGPS(location.getTime());

                    menuItem.setIcon(R.drawable.gps_activo_48x48);

                }
            };

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locListener);
            if(latitudeField.equals("0.0")){
                menuItem.setIcon(R.drawable.gps_inactivo_48x48);
            }
        }else{

            latitudeField = "0.0";
            longitudeField = "0.0";
            altitudeField = "0.0";

            menuItem.setIcon(R.drawable.gps_inactivo_48x48);

        }

    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.rendicion_gastos, menu);
        this.menu = menu;

        menuItem = menu.findItem(R.id.menu_gps);

        obtenerCoordenadas();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.menu_gps) {

            if(!latitudeField.equals("0.0")){

                Util.alertaDialog(this, Constantes.LOCALIZACION_GPS, "\nFecha : " + fechaField + "\n\nLatitude : " + latitudeField + "\n\nLongitude : " + longitudeField + "\n\nAltitude : " + altitudeField + "\n", R.drawable.gps_activo_48x48);

            }else{

                obtenerCoordenadas();

            }

            return true;

        }else if(id == R.id.menu_retornar){

            new LovelyStandardDialog(this)
                    .setTopColorRes(R.color.colorPrincipal)
                    .setButtonsColorRes(R.color.colorPrincipal)
                    .setIcon(R.drawable.info_48x48)
                    .setTitle(Constantes.MENSAJE)
                    .setMessage(Constantes.SALIR_REPORTE)
                    .setPositiveButton(R.string.si, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent = new Intent(ReporteActivity.this, ListviewActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton(R.string.no, null)
                    .show();
        }

        return super.onOptionsItemSelected(item);

    }

}
