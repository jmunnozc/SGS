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

	//***************************************************************************************************
	//TABLA TAREA
	//***************************************************************************************************
	public static final String TABLA_TAREAS		 			 		= "tareas";
	public static final String TAREA_ID								= "_id";
	public static final String TAREA_CODIGO							= "codigoTarea";
	public static final String TAREA_DESCRIPCION					= "descripcionTarea";

	//***************************************************************************************************
	//TABLA TIPO DE DOCUMENTO
	//***************************************************************************************************
	public static final String TABLA_TIPO_DOCUMENTO			 		= "tipoDocumento";
	public static final String TIPO_DOCUMENTO_ID					= "_id";
	public static final String TIPO_DOCUMENTO_CODIGO				= "codigoTipoDocumento";
	public static final String TIPO_DOCUMENTO_DESCRIPCION			= "descripcionTipoDocumento";

	//***************************************************************************************************
	//TABLA CATEGORIA DOCUMENTO
	//***************************************************************************************************
	public static final String TABLA_CATEGORIA_DOCUMENTO	 		= "categoriaDocumento";
	public static final String CATEGORIA_DOCUMENTO_ID				= "_id";
	public static final String CATEGORIA_DOCUMENTO_CODIGO			= "codigoCategoriaDocumento";
	public static final String CATEGORIA_DOCUMENTO_DESCRIPCION		= "descripcionCategoriaDocumento";

	// DATABASE INFORMATION
	static final String DB_NAME = "SGS.DB";
	static final int DB_VERSION = 1;

	private static final String CREATE_TABLE_ORDENES = "create table " + TABLA_ORDENES
			+ "(" + ORDEN_ID		+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ ORDEN_CODIGO			+ " TEXT NOT NULL, "
			+ ORDEN_DESCRIPCION		+ " TEXT NOT NULL );";

	private static final String CREATE_TABLE_TAREAS = "create table " + TABLA_TAREAS
			+ "(" + TAREA_ID		+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ TAREA_CODIGO			+ " TEXT NOT NULL, "
			+ TAREA_DESCRIPCION		+ " TEXT NOT NULL );";

	private static final String CREATE_TABLE_TIPO_DOCUMENTO = "create table " + TABLA_TIPO_DOCUMENTO
			+ "(" + TIPO_DOCUMENTO_ID		+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ TIPO_DOCUMENTO_CODIGO			+ " TEXT NOT NULL, "
			+ TIPO_DOCUMENTO_DESCRIPCION	+ " TEXT NOT NULL );";

	private static final String CREATE_TABLE_CATEGORIA_DOCUMENTO = "create table " + TABLA_CATEGORIA_DOCUMENTO
			+ "(" + CATEGORIA_DOCUMENTO_ID		+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ CATEGORIA_DOCUMENTO_CODIGO		+ " TEXT NOT NULL, "
			+ CATEGORIA_DOCUMENTO_DESCRIPCION	+ " TEXT NOT NULL, "
			+ TIPO_DOCUMENTO_CODIGO				+ " TEXT NOT NULL );";

	public MyDbHelper(Context context) {
		
		super(context, DB_NAME, null, DB_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(CREATE_TABLE_ORDENES);
		db.execSQL(CREATE_TABLE_TAREAS);
		db.execSQL(CREATE_TABLE_TIPO_DOCUMENTO);
		db.execSQL(CREATE_TABLE_CATEGORIA_DOCUMENTO);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		//System.out.println("oldVersion : " + oldVersion); //6

	}
}