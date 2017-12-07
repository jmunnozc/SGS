package pe.com.sgs.appsgs.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.Log;
import android.widget.Spinner;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import pe.com.sgs.appsgs.R;

public class Util {
	
	private static final String LOG_TAG = "ConnectionDetector";
	private static String urlToPing = "http://www.google.com";
	
	private static final String USER_AGENT_HEADER = "User-Agent";
    private static final String USER_AGENT_HEADER_VALUE = System.getProperty("http.agent");
    private static final String CONNECTION_HEADER = "Connection";
    private static final String CONNECTION_HEADER_VALUE = "Close";
    private static final int TIMEOUT = 1500;
    
	//Verifica si el dispositivo cuenta con internet 1
	public static boolean isOnline(Context context)
	{
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
		NetworkInfo netinfo = cm.getActiveNetworkInfo();
		if(netinfo != null && netinfo.isConnected())
		{
			return true;
		}
		
		return false;
	}
	
	//Verifica si el dispositivo cuenta con internet 2
	public static boolean isConnected(Context context) {
		boolean conectado = false;
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    	/*
                        if (ping) {
                            return pingServer();
                        } else {
                            return true;
                        }
                        */
                    	if(pingServer()){
                    		conectado = true;
                    		break;
                    	}
                    }
 
        }
        return false;
    }
 
    private static boolean pingServer() {
    	
        try {           
            HttpURLConnection urlConnection = (HttpURLConnection) (new URL(urlToPing).openConnection());
            urlConnection.setRequestProperty(USER_AGENT_HEADER, USER_AGENT_HEADER_VALUE);
            urlConnection.setRequestProperty(CONNECTION_HEADER, CONNECTION_HEADER_VALUE);
            urlConnection.setConnectTimeout(TIMEOUT);
            urlConnection.connect();
            return (urlConnection.getResponseCode() == 200);
            
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error checking internet connection", e);
        	
        }
        
        return false;
    }
    
	public static void alertaDialog(Context context, String titulo, String mensaje, int restId){
		
		final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		alertDialog.setTitle(titulo);
		alertDialog.setMessage(mensaje);
		alertDialog.setIcon(restId);
		alertDialog.setButton("Aceptar", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				alertDialog.dismiss();
			}
		});
			
		alertDialog.show();
		
	}
	
	public static AlertDialog alertaDialogo(Context context, String titulo, String mensaje, int restId){
		
		final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		alertDialog.setTitle(titulo);
		alertDialog.setMessage(mensaje);
		alertDialog.setIcon(restId);
		
		return alertDialog;
	}
	
	public static String obtenerFechaHora(){
		
		Date date = new Date();
		//Caso 1: obtener la hora y salida por pantalla con formato:
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		//System.out.println("Hora: "+hourFormat.format(date));
		//Caso 2: obtener la fecha y salida por pantalla con formato:
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//System.out.println("Fecha: "+dateFormat.format(date));
		//Caso 3: obtenerhora y fecha y salida por pantalla con formato:
		DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		//System.out.println("Fecha y Hora : " + hourdateFormat.format(date));
		
		return hourdateFormat.format(date);
	}
	
	public static String obtenerFecha(){
		
		Date date = new Date();
		//Caso 1: obtener la hora y salida por pantalla con formato:
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		//System.out.println("Hora: "+hourFormat.format(date));
		//Caso 2: obtener la fecha y salida por pantalla con formato:
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//System.out.println("Fecha: "+dateFormat.format(date));
		//Caso 3: obtenerhora y fecha y salida por pantalla con formato:
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println("Fecha y Hora : " + hourdateFormat.format(date));
		
		return hourdateFormat.format(date);
	}
	
	public static String ExportToCSV(Cursor c, String fileName) {
		
        int rowCount = 0;  
        int colCount = 0;  
        FileWriter fw;
        BufferedWriter bfw;
        //File sdCardDir = Environment.getExternalStorageDirectory();  
        //File saveFile = new File(sdCardDir, fileName);
        
        String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        
        File crear = new File(baseDir + File.separator + "Pension65" + File.separator);
        crear.mkdir();
        
        // Not sure if the / is on the path or not
        File sdCardDir = new File(baseDir + File.separator + "Pension65");
        File saveFile = new File(sdCardDir, fileName);
        
        try {  
  
            rowCount = c.getCount();  
            colCount = c.getColumnCount();  
            fw = new FileWriter(saveFile);
            bfw = new BufferedWriter(fw);
            if (rowCount > 0) {  
                c.moveToFirst();  
                //   
                for (int i = 0; i < colCount; i++) {  
                    if (i != colCount - 1)  
                       bfw.write(c.getColumnName(i) + ',');  
                    else  
                       bfw.write(c.getColumnName(i));  
                }  
                //   
                bfw.newLine();  
                //   
                for (int i = 0; i < rowCount; i++) {  
                    c.moveToPosition(i);  
                    // Toast.makeText(mContext, ""+(i+1)+"",  
                    // Toast.LENGTH_SHORT).show();  
                    //Log.v("", "" + (i + 1) + "");  
                    for (int j = 0; j < colCount; j++) {  
                        if (j != colCount - 1)  
                            bfw.write(c.getString(j) + ',');  
                        else  
                           bfw.write(c.getString(j));  
                    }  
                    //   
                    bfw.newLine();  
                }  
            }  
            //   
            bfw.flush();  
            //   
            bfw.close();  
            // Toast.makeText(mContext, "?", Toast.LENGTH_SHORT).show();  
            //Log.v("", "?");  
        } catch (IOException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } finally {  
            c.close();
            return sdCardDir + "/" + fileName;
        }  
    }
	
	public static String fechaHoraGPS(Long time)
	{
		String fechaHora = "";
		GregorianCalendar gcal = new
		//GregorianCalendar(TimeZone.getTimeZone("UTC"));
                GregorianCalendar(TimeZone.getTimeZone("America/Lima"));
    	gcal.setTimeInMillis(time);
    	
    	String dia = StringUtils.leftPad(String.valueOf(gcal.get(GregorianCalendar.DAY_OF_MONTH)), 2, "0");
    	String mes = StringUtils.leftPad(String.valueOf(gcal.get(GregorianCalendar.MONTH) + 1), 2, "0");
    	String anio = String.valueOf(gcal.get(GregorianCalendar.YEAR));
    	String hora = StringUtils.leftPad(String.valueOf(gcal.get(GregorianCalendar.HOUR_OF_DAY)), 2, "0");
    	String minuto = StringUtils.leftPad(String.valueOf(gcal.get(GregorianCalendar.MINUTE)), 2, "0");
    	String segundo = StringUtils.leftPad(String.valueOf(gcal.get(GregorianCalendar.SECOND)), 2, "0");
    	
    	fechaHora = dia + "/" + mes + "/" + anio + " " + hora + ":" + minuto + ":" + segundo;
    	
    	return fechaHora;
	}
	
	public static int obtenerPosicion(Spinner spinner, String valor)
	{
		int index = 0;
		for (int i = 0; i < spinner.getCount(); i++)
		{
			if(spinner.getItemAtPosition(i).equals(valor))
			{
				index = i;
			}
		}
		return index;
	}
	
	public static String reemplazarCarateresEspeciales(String cadena){

		//String cadena1 = "Sé te n°ota que est|as eno'jado N° 1234";
		String valor = cadena != null ? cadena : "";
		valor = valor.replaceAll("[á|à|Á|À]", "A");
		valor = valor.replaceAll("[é|è|É|È]", "E");
		valor = valor.replaceAll("[í|ì|Í|Ì]", "I");
		valor = valor.replaceAll("[ó|ò|Ó|Ò]", "O");
		valor = valor.replaceAll("[ú|ù|Ú|Ù]", "U");
		valor = valor.replaceAll("[ñ|Ñ]", "N");
		//valor = valor.replaceAll("['|||°]", "");
		valor = valor.replaceAll("[^-a-zA-Z0-9$ ]+","");
		//System.out.println("cadena : " + cadena2);

		return valor;
	}
	
	public static String[] espacioMovil(){
		
		String[] espacio = new String[2];
		StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
		long available = ((long) stat.getAvailableBlocks() * (long) stat.getBlockSize()); 
		long total = ((long) stat.getBlockCount() * (long) stat.getBlockSize()); 

		float totalMB = (float)total/1024/1024;
		float availableMB = (float)available/1024/1024;
		
		String free = null;
		if (total > 0)
		{
			//free = Float.toString(availableMB) + " (" + availableMB/totalMB * 100 + "%)";
			free = Float.toString(availableMB);
		}
		else
		{
			free = "0.0";
		}
		
		espacio[0] = Float.toString(totalMB);
		espacio[1] = free;
		
		return espacio;
	}
	
	public static void alertaGpsDesactivado(final Context context){
		
		final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		alertDialog.setTitle(Constantes.MENSAJE);
		alertDialog.setMessage(Constantes.MENSAJE_GPS_DESACTIVADO);
		alertDialog.setIcon(R.drawable.info_48x48);
		alertDialog.setButton("Aceptar", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				
				context.startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
				alertDialog.dismiss();
			}
		});
			
		alertDialog.show();
		
	}

	public static String bitmapToBase64(Bitmap bitmap) {
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
	    byte[] byteArray = byteArrayOutputStream .toByteArray();
	    return Base64.encodeToString(byteArray, Base64.DEFAULT);
	}
	
	public static Bitmap base64ToBitmap(String b64) {
	    byte[] imageAsBytes = Base64.decode(b64.getBytes(), Base64.DEFAULT);
	    return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {  
        //double radioTierra = 3958.75;//en millas  
        //double radioTierra = 6371;//en kilometros
		double radioTierra = 6371000;//en metros
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;  
   
        return round(distancia, 8);  
    }
	
	public static File createTemporaryFile(String part, String ext, Context myContext){
        
		File archivo = null;
        try {
        	File tempDir = myContext.getExternalCacheDir();
            tempDir = new File(tempDir.getAbsolutePath() + "/temp/");
            if (!tempDir.exists()) {
                tempDir.mkdir();
            }
            
			archivo = File.createTempFile(part, ext, tempDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return archivo;
    }
	
	public static String formatearMiles(String numero){
		
		NumberFormat nf = NumberFormat.getInstance();
		
		nf = NumberFormat.getInstance(Locale.ENGLISH);
		//System.out.println(nf.format(76543210.1234));
		
		return nf.format(Double.parseDouble(numero));
		
	}
}