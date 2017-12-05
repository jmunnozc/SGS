package pe.com.sgs.appsgs.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

import pe.com.sgs.appsgs.model.CategoriaDocumento;
import pe.com.sgs.appsgs.model.Orden;
import pe.com.sgs.appsgs.model.Tarea;
import pe.com.sgs.appsgs.model.TipoDocumento;
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

	public void grabarTareas() {

		try{

			List<Tarea> listaTareas = new ArrayList<>();

			Tarea tarea1 = new Tarea();
			tarea1.setCodigoTarea("T-1256");
			tarea1.setDescripcionTarea("MEDIO AMBIENTE");

			Tarea tarea2 = new Tarea();
			tarea2.setCodigoTarea("T-1266");
			tarea2.setDescripcionTarea("HARINA DE PESCADO");

			Tarea tarea3 = new Tarea();
			tarea3.setCodigoTarea("T-1276");
			tarea3.setDescripcionTarea("INSPECCIÓN CONTENEDORES");

			Tarea tarea4 = new Tarea();
			tarea4.setCodigoTarea("T-1286");
			tarea4.setDescripcionTarea("CERTIFICACIONES");

			Tarea tarea5 = new Tarea();
			tarea5.setCodigoTarea("T-1296");
			tarea5.setDescripcionTarea("PRUEBAS DE ENSAYO");

			listaTareas.add(tarea1);
			listaTareas.add(tarea2);
			listaTareas.add(tarea3);
			listaTareas.add(tarea4);
			listaTareas.add(tarea5);

			for(Tarea tarea : listaTareas){

				ContentValues cv = new ContentValues();
				cv.put(MyDbHelper.TAREA_CODIGO, 				tarea.getCodigoTarea());
				cv.put(MyDbHelper.TAREA_DESCRIPCION, 			tarea.getDescripcionTarea());

				database.insert(MyDbHelper.TABLA_TAREAS, null, cv);

			}
		}catch(Exception e){
			LogCustom.error(this.getClass().getName(), "", "", e);
		}

	}

	public void grabarTipoDocumento() {

		try{

			List<TipoDocumento> listaTipoDocumento = new ArrayList<>();

			TipoDocumento tipoDocumento1 = new TipoDocumento();
			tipoDocumento1.setCodigoTipoDocumento("B");
			tipoDocumento1.setDescripcionTipoDocumento("BOLETA");

			TipoDocumento tipoDocumento2 = new TipoDocumento();
			tipoDocumento2.setCodigoTipoDocumento("F");
			tipoDocumento2.setDescripcionTipoDocumento("FACTURA");

			listaTipoDocumento.add(tipoDocumento1);
			listaTipoDocumento.add(tipoDocumento2);

			for(TipoDocumento tipoDocumento : listaTipoDocumento){

				ContentValues cv = new ContentValues();
				cv.put(MyDbHelper.TIPO_DOCUMENTO_CODIGO, 				tipoDocumento.getCodigoTipoDocumento());
				cv.put(MyDbHelper.TIPO_DOCUMENTO_DESCRIPCION, 			tipoDocumento.getDescripcionTipoDocumento());

				database.insert(MyDbHelper.TABLA_TIPO_DOCUMENTO, null, cv);

			}
		}catch(Exception e){
			LogCustom.error(this.getClass().getName(), "", "", e);
		}

	}

	public void grabarCategoriaDocumento() {

		try{

			List<CategoriaDocumento> listaCategoriaDocumento = new ArrayList<>();

			CategoriaDocumento categoriaDocumento1 = new CategoriaDocumento();
			categoriaDocumento1.setCodigoCategoriaDocumento("B1");
			categoriaDocumento1.setDescripcionCategoriaDocumento("BOLETA 1");
			categoriaDocumento1.setCodigoTipoDocumento("B");

			CategoriaDocumento categoriaDocumento2 = new CategoriaDocumento();
			categoriaDocumento2.setCodigoCategoriaDocumento("B2");
			categoriaDocumento2.setDescripcionCategoriaDocumento("BOLETA 2");
			categoriaDocumento2.setCodigoTipoDocumento("B");

			CategoriaDocumento categoriaDocumento3 = new CategoriaDocumento();
			categoriaDocumento3.setCodigoCategoriaDocumento("F1");
			categoriaDocumento3.setDescripcionCategoriaDocumento("FACTURA 1");
			categoriaDocumento3.setCodigoTipoDocumento("F");

			CategoriaDocumento categoriaDocumento4 = new CategoriaDocumento();
			categoriaDocumento4.setCodigoCategoriaDocumento("F2");
			categoriaDocumento4.setDescripcionCategoriaDocumento("FACTURA 2");
			categoriaDocumento4.setCodigoTipoDocumento("F");


			listaCategoriaDocumento.add(categoriaDocumento1);
			listaCategoriaDocumento.add(categoriaDocumento2);
			listaCategoriaDocumento.add(categoriaDocumento3);
			listaCategoriaDocumento.add(categoriaDocumento4);

			for(CategoriaDocumento categoriaDocumento : listaCategoriaDocumento){

				ContentValues cv = new ContentValues();
				cv.put(MyDbHelper.CATEGORIA_DOCUMENTO_CODIGO, 				categoriaDocumento.getCodigoCategoriaDocumento());
				cv.put(MyDbHelper.CATEGORIA_DOCUMENTO_DESCRIPCION, 			categoriaDocumento.getDescripcionCategoriaDocumento());
				cv.put(MyDbHelper.TIPO_DOCUMENTO_CODIGO, 					categoriaDocumento.getCodigoTipoDocumento());

				database.insert(MyDbHelper.TABLA_CATEGORIA_DOCUMENTO, null, cv);

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

	public void eliminarTareas(){

		try{
			database.delete(MyDbHelper.TABLA_TAREAS, null, null);
		}catch(Exception e){
			LogCustom.error(this.getClass().getName(), "", "", e);
		}

	}

	public void eliminarTipoDocumento(){

		try{
			database.delete(MyDbHelper.TABLA_TIPO_DOCUMENTO, null, null);
		}catch(Exception e){
			LogCustom.error(this.getClass().getName(), "", "", e);
		}

	}

	public void eliminarCategoriaDocumento(){

		try{
			database.delete(MyDbHelper.TABLA_CATEGORIA_DOCUMENTO, null, null);
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

	public List<Tarea> listarTareas(){

		List<Tarea> lista = new ArrayList<Tarea>();
		String buildSQL = "SELECT * FROM " + MyDbHelper.TABLA_TAREAS;

		Cursor cursor = database.rawQuery(buildSQL, null);
		if(cursor != null)
		{
			if(cursor.moveToFirst())
			{
				do
				{
					Tarea tarea = new Tarea();
					tarea.setIdTarea(cursor.getInt(0));
					tarea.setCodigoTarea(cursor.getString(1));
					tarea.setDescripcionTarea(cursor.getString(2));

					lista.add(tarea);

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

	public String obtenerCodigoTarea(String descripcionTarea){

		String codigoTarea = "";
		String buildSQL = "SELECT " + MyDbHelper.TAREA_CODIGO + " FROM " + MyDbHelper.TABLA_TAREAS + " WHERE " + MyDbHelper.TAREA_DESCRIPCION + " = '" + descripcionTarea + "'";

		Cursor cursor = database.rawQuery(buildSQL, null);
		if(cursor != null)
		{
			if(cursor.moveToFirst())
			{
				do
				{
					codigoTarea = cursor.getString(0);

				} while(cursor.moveToNext());
			}
		}

		return codigoTarea;

	}

	public List<String> listarTipoDocumento(){

		String valorInicial = "Seleccionar";
		List<String> etiquetas = new ArrayList<String>();
		String buildSQL = "SELECT " + MyDbHelper.TIPO_DOCUMENTO_CODIGO + ", " + MyDbHelper.TIPO_DOCUMENTO_DESCRIPCION + " FROM " + MyDbHelper.TABLA_TIPO_DOCUMENTO;

		Cursor cursor = database.rawQuery(buildSQL, null);
		if(cursor != null)
		{
			if ( cursor.moveToFirst () ) {
				etiquetas.add(valorInicial);
				do{
					etiquetas.add(cursor.getString(1));
				} while (cursor.moveToNext());
			}
		}

		return etiquetas;
	}

	public List<String> listarCategoriaDocumento(String codigoTipoDocumento){

		String valorInicial = "Seleccionar";
		List<String> etiquetas = new ArrayList<String>();
		String buildSQL = "SELECT " + MyDbHelper.CATEGORIA_DOCUMENTO_CODIGO + ", " + MyDbHelper.CATEGORIA_DOCUMENTO_DESCRIPCION + " FROM " + MyDbHelper.TABLA_CATEGORIA_DOCUMENTO + " WHERE " + MyDbHelper.TIPO_DOCUMENTO_CODIGO + " = '" + codigoTipoDocumento + "'";

		Cursor cursor = database.rawQuery(buildSQL, null);
		if(cursor != null)
		{
			if ( cursor.moveToFirst () ) {
				etiquetas.add(valorInicial);
				do{
					etiquetas.add(cursor.getString(1));
				} while (cursor.moveToNext());
			}
		}

		return etiquetas;
	}

	public String obtenerCodigoTipoDocumento(String descripcionTipoDocumento){

		String codigoTarea = "";
		String buildSQL = "SELECT " + MyDbHelper.TIPO_DOCUMENTO_CODIGO + " FROM " + MyDbHelper.TABLA_TIPO_DOCUMENTO + " WHERE " + MyDbHelper.TIPO_DOCUMENTO_DESCRIPCION + " = '" + descripcionTipoDocumento + "'";

		Cursor cursor = database.rawQuery(buildSQL, null);
		if(cursor != null)
		{
			if(cursor.moveToFirst())
			{
				do
				{
					codigoTarea = cursor.getString(0);

				} while(cursor.moveToNext());
			}
		}

		return codigoTarea;

	}
}