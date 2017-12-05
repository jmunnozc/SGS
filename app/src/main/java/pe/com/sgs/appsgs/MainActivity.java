package pe.com.sgs.appsgs;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yarolegovich.lovelydialog.LovelyStandardDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TelephonyManager manager;
    //TextView txtmensaje;

    ListView lista;
    List<String> item = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        //grabarOrden();

    }

    private void grabarOrden() {
        /*db = new ConnectionDB(this);
        db.addOrden("OI-1256","ORDEN INSPECCIÓN Nro 1256 - MEDIO AMBIENTE");
        db.addOrden("OI-1266","ORDEN INSPECCIÓN Nro 1266 - HARINA DE PESCADO");
        db.addOrden("OI-1276","ORDEN INSPECCIÓN Nro 1276 - INSPECCIÓN CONTENEDORES");
        db.addOrden("OI-1286","ORDEN INSPECCIÓN Nro 1286 - CERTIFICACIONES");
        db.addOrden("OI-1296","ORDEN INSPECCIÓN Nro 1296 - PRUEBAS DE ENSAYO");*/
    }

    public void informationImeiFunction(View view) {
        String mensaje = "IMEI \r\r\r\r\r\r\r\r\r\r\r: " + manager.getDeviceId().toString() + "\n" +
                "OPERADOR : " + manager.getNetworkOperatorName().toString();

        new LovelyStandardDialog(MainActivity.this)
                .setTopColorRes(R.color.colorPrincipal)
                .setButtonsColorRes(R.color.colorPrincipal)
                .setIcon(R.drawable.i_32x32)
                .setTitle("VERSION")
                .setMessage(mensaje)
                .setPositiveButton(android.R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//Toast.makeText(LoginActivity.this, "positive clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    public void validarAccesoFunction(View v) {
        Intent intent = new Intent(MainActivity.this, ListviewActivity.class);
        startActivity(intent);
        finish();
    }

}
