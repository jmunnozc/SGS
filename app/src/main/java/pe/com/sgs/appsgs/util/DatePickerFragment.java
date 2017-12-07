package pe.com.sgs.appsgs.util;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

	EditText cajaFechaLocal;
	int sinDia;
	public DatePickerFragment(EditText cajaFecha, int sinDia){
		this.cajaFechaLocal = cajaFecha;
		this.sinDia = sinDia;
	}
	
	 @Override
     public Dialog onCreateDialog(Bundle savedInstanceState) {
         // Usar del defecto la fecha actual
         final Calendar c = Calendar.getInstance();
         try {
             // Si en algun momento se ha informado la fecha se recupera
             String format = "dd/MM/yyyy";
             SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
             c.setTime(sdf.parse(String.valueOf(cajaFechaLocal.getText())));
         } catch (ParseException e) {
             // Si falla utilizaremos la fecha actual
         }

         int year = c.get(Calendar.YEAR);
         int month = c.get(Calendar.MONTH);
         int day = c.get(Calendar.DAY_OF_MONTH);

         // Create a new instance of TimePickerDialog and return it
         return new DatePickerDialog(getActivity(), this, year, month, day);
     }

     /**
      * Recupera el valor seleccionado en el componente DatePicker e inserta el valor en el
      * TextView tvDate
      *
      * @param view
      * @param year
      * @param month
      * @param day
      */
     public void onDateSet(DatePicker view, int year, int month, int day) {
         try{
             final Calendar c = Calendar.getInstance();
             c.set(year, month, day);
             String format = "dd/MM/yyyy";
             if(sinDia == 1)
            	 format = "MM/yyyy";
             
             SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
             cajaFechaLocal.setText(sdf.format(c.getTime()));
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
}