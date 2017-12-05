package pe.com.sgs.appsgs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jomu on 27/11/2017.
 */

public class ConnectionDB extends SQLiteOpenHelper {

    //String que contienen las Órdenes de Servicio / Inspección de lo que se guardará en la BD
    public static final String TABLE_ID = "_idOrdenes";
    public static final String ORDENES = "codigo";
    public static final String TITLE = "descripcion";
    //Nombre de la BD, de la tabla de la BD a utilizar
    public static final String DATABASE = "SGS";
    public static final String TABLE = "ordenes";

    private SQLiteDatabase database;

    //public ConnectionDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    public ConnectionDB(Context context) {
        super(context, DATABASE, null, 1);
    }

    //Aqui se inicializa la BD, esto se realiza siempre que se crea la clase
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + " (" + TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ORDENES + " TEXT," + TITLE + " TEXT)");
    }

    //Verifica si ya existe una versión de la BD con la tabla creada
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public void close() {
        this.close();
    }

    //Método para agregar las órdenes
    public void addOrden(String codigo, String descripcion) {
        ContentValues valores = new ContentValues();
        valores.put(ORDENES,codigo);
        valores.put(TITLE,descripcion);
        this.getWritableDatabase().insert(TABLE,null,valores);
    }

    //Método para listar todas las órdenes
    public Cursor getOrden() {
        List<Ordenes> lstOrdenes = new ArrayList<Ordenes>();
        String columnas[]={TABLE_ID, ORDENES, TITLE};
        Cursor cursor = this.getReadableDatabase().query(TABLE, columnas, null, null, null, null, null);

        if(cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Ordenes ord = new Ordenes();
                    ord.setId(Integer.parseInt(cursor.getString(0)));
                    ord.setCodigo(cursor.getString(1));
                    ord.setDescripcion(cursor.getString(2));
                    lstOrdenes.add(ord);
                } while (cursor.moveToNext());
            }
        }
        /*List<Ordenes> lstOrdenes = new ArrayList<Ordenes>();
        String buildSQL = "SELECT _idOrdenes, codigo, descripcion FROM " + TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(buildSQL, null);
        if(cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Ordenes ord = new Ordenes();
                    ord.setId(Integer.parseInt(cursor.getString(0)));
                    ord.setCodigo(cursor.getString(1));
                    ord.setDescripcion(cursor.getString(2));
                    lstOrdenes.add(ord);
                } while (cursor.moveToNext());
            }
        } else {
            Log.i("ConnectionDB","No Trajo nada el cursor");
        }*/

        return cursor;
    }
}
