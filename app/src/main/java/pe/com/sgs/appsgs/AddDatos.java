package pe.com.sgs.appsgs;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by jomu on 27/11/2017.
 */

public class AddDatos extends ActionBarActivity{
    ConnectionDB db;

    private void addDatos() {
        db = new ConnectionDB(this);
        db.addOrden("OI-1256","ORDEN INSPECCIÓN Nro 1256 - MEDIO AMBIENTE");
        db.addOrden("OI-1266","ORDEN INSPECCIÓN Nro 1266 - HARINA DE PESCADO");
        db.addOrden("OI-1276","ORDEN INSPECCIÓN Nro 1276 - INSPECCIÓN CONTENEDORES");
        db.addOrden("OI-1286","ORDEN INSPECCIÓN Nro 1286 - CERTIFICACIONES");
        db.addOrden("OI-1296","ORDEN INSPECCIÓN Nro 1296 - PRUEBAS DE ENSAYO");
        db.close();

        Intent intent = new Intent(AddDatos.this, ListviewActivity.class);
        startActivity(intent);
    }

}
