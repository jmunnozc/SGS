package pe.com.sgs.appsgs.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
	
	//***************************************************************************************************
	//TABLA ORDENES
	//***************************************************************************************************
	public static final String TABLA_ORDENES	 			 		= "ordenes";
	public static final String ORDEN_ID								= "_id";
	public static final String ORDEN_CODIGO							= "codigoOrden";
	public static final String ORDEN_DESCRIPCION					= "descripcionOrden";

	// DATABASE INFORMATION
	static final String DB_NAME = "SGS.DB";
	static final int DB_VERSION = 1;

	private static final String CREATE_TABLE_ORDENES = "create table " + TABLA_ORDENES
			+ "(" + ORDEN_ID		+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ ORDEN_CODIGO			+ " TEXT NOT NULL, "
			+ ORDEN_DESCRIPCION		+ " TEXT NOT NULL );";

	public MyDbHelper(Context context) {
		
		super(context, DB_NAME, null, DB_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(CREATE_TABLE_ORDENES);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		//System.out.println("oldVersion : " + oldVersion); //6

	}
}