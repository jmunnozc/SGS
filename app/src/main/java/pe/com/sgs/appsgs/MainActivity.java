package pe.com.sgs.appsgs;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.yarolegovich.lovelydialog.LovelyStandardDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.com.sgs.appsgs.util.Constantes;
import pe.com.sgs.appsgs.util.LogCustom;
import pe.com.sgs.appsgs.util.ServiceRequest;
import pe.com.sgs.appsgs.util.Util;

public class MainActivity extends AppCompatActivity {

    TelephonyManager manager;
    //TextView txtmensaje;

    ListView lista;
    List<String> item = null;
    ServiceRequest service_request;
    JSONObject jsonObject;
    Button btn_iniciar;
    String[] valoresAutenticacion = new String[2];
    EditText tv_usuario, tv_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        manager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        btn_iniciar = (Button) findViewById(R.id.btn_iniciar);
        tv_usuario = (EditText) findViewById(R.id.tv_usuario);
        tv_password = (EditText) findViewById(R.id.tv_password);

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valoresAutenticacion[0] = tv_usuario.getText() != null ? tv_usuario.getText().toString() : "";
                valoresAutenticacion[1] = tv_password.getText() != null ? tv_password.getText().toString() : "";

                new taskAutenticacionUsuario().execute(valoresAutenticacion);
            }
        });

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

                    }
                })
                .show();
    }
    /*
    public void validarAccesoFunction(View v) {
        Intent intent = new Intent(MainActivity.this, ListviewActivity.class);
        startActivity(intent);
        finish();
    }
    */
    //Realizar autenticacion de usuario
    class taskAutenticacionUsuario extends AsyncTask<String, String, String> {

        String retorno = "Error";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... arg0) {

            if (Util.isOnline(MainActivity.this)) {

                service_request = new ServiceRequest(Constantes.REST_VALIDAR_USUARIO, null);
                int codigoUsuario = 0;
                try {

                    jsonObject = new JSONObject();
                    jsonObject.accumulate("usuario",    arg0[0]);
                    jsonObject.accumulate("password",   arg0[1]);
                    String jsonDataUsuario = jsonObject.toString();

                    String webdataUsuario = service_request.MakePostRequest(jsonDataUsuario);
                    JSONObject jsonUsuario = new JSONObject(webdataUsuario);

                    boolean usuarioValido   = jsonUsuario.optBoolean("userValido");
                    if(usuarioValido){
                        String nombre           = jsonUsuario.optString("nombre");
                        String usuario          = jsonUsuario.optString("usuario");

                        retorno = "Ok";

                    }

                } catch (JSONException e) {
                    LogCustom.error(this.getClass().getName(), "", "", e);
                }

            }

            return retorno;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if(result.equals("Error")) {

                new LovelyStandardDialog(MainActivity.this)
                        .setTopColorRes(R.color.colorPrincipal)
                        .setButtonsColorRes(R.color.colorPrincipal)
                        .setIcon(R.drawable.info_48x48)
                        .setTitle(Constantes.MENSAJE)
                        .setMessage(Constantes.USUARIO_INCORRECTO)
                        .setPositiveButton(R.string.si, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .show();
            }else{

                Intent intent = new Intent(MainActivity.this, ListviewActivity.class);
                startActivity(intent);
                finish();

            }

        }
    }
}
