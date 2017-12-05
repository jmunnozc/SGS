package pe.com.sgs.appsgs.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import pe.com.sgs.appsgs.model.Orden;
import pe.com.sgs.appsgs.util.LogCustom;

public class SQLController {

	private MyDbHelper dbhelper;
	private Context ourcontext;
	private SQLiteDatabase database;
	
	public SQLController(Context c) {
		ourcontext = c;
	}

	public SQLController open() throws SQLException {
		dbhelper = new MyDbHelper(ourcontext);
		database = dbhelper.getWritableDatabase();
		return this;

	}

	public void close() {
		dbhelper.close();
	}

	public void grabarOrdenes() {

		try{

			List<Orden> listaOrdenes = new ArrayList<>();

			Orden orden1 = new Orden();
			orden1.setCodigoOrden("OI-1256");
			orden1.setDescripcionOrden("MEDIO AMBIENTE");

			Orden orden2 = new Orden();
			orden2.setCodigoOrden("OI-1266");
			orden2.setDescripcionOrden("HARINA DE PESCADO");

			Orden orden3 = new Orden();
			orden3.setCodigoOrden("OI-1276");
			orden3.setDescripcionOrden("INSPECCIÓN CONTENEDORES");

			Orden orden4 = new Orden();
			orden4.setCodigoOrden("OI-1286");
			orden4.setDescripcionOrden("CERTIFICACIONES");

			Orden orden5 = new Orden();
			orden5.setCodigoOrden("OI-1296");
			orden5.setDescripcionOrden("PRUEBAS DE ENSAYO");

			listaOrdenes.add(orden1);
			listaOrdenes.add(orden2);
			listaOrdenes.add(orden3);
			listaOrdenes.add(orden4);
			listaOrdenes.add(orden5);

			for(Orden orden : listaOrdenes){

				ContentValues cv = new ContentValues();
				cv.put(MyDbHelper.ORDEN_CODIGO, 				orden.getCodigoOrden());
				cv.put(MyDbHelper.ORDEN_DESCRIPCION, 			orden.getDescripcionOrden());

				database.insert(MyDbHelper.TABLA_ORDENES, null, cv);

			}
		}catch(Exception e){
			LogCustom.error(this.getClass().getName(), "", "", e);
		}

	}

	public void eliminarOrdenes(){

		try{
			database.delete(MyDbHelper.TABLA_ORDENES, null, null);
		}catch(Exception e){
			LogCustom.error(this.getClass().getName(), "", "", e);
		}

	}

	public List<Orden> listarOrdenes(){
		
		List<Orden> lista = new ArrayList<Orden>();
		String buildSQL = "SELECT * FROM " + MyDbHelper.TABLA_ORDENES;
		
		Cursor cursor = database.rawQuery(buildSQL, null);
		if(cursor != null)
		{
			if(cursor.moveToFirst())
			{
				do
				{
					Orden orden = new Orden();
					orden.setIdOrden(cursor.getInt(0));
					orden.setCodigoOrden(cursor.getString(1));
					orden.setDescripcionOrden(cursor.getString(2));
					
					lista.add(orden);
                    
				} while(cursor.moveToNext());
			}
		}
		
		return lista;
		  
	}

	public String obtenerCodigoOrden(String descripcionOrden){

		String codigoOrden = "";
		String buildSQL = "SELECT " + MyDbHelper.ORDEN_CODIGO + " FROM " + MyDbHelper.TABLA_ORDENES + " WHERE " + MyDbHelper.ORDEN_DESCRIPCION + " = '" + descripcionOrden + "'";

		Cursor cursor = database.rawQuery(buildSQL, null);
		if(cursor != null)
		{
			if(cursor.moveToFirst())
			{
				do
				{
					codigoOrden = cursor.getString(0);

				} while(cursor.moveToNext());
			}
		}

		return codigoOrden;

	}

}