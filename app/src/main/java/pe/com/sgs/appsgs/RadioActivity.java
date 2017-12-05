package pe.com.sgs.appsgs;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class RadioActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);

        //Selecionamos metodo OnClick o Touch de los botones
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioButton1:
                getSupportActionBar().setTitle(rb1.getText());
                break;
            case R.id.radioButton2:
                getSupportActionBar().setTitle(rb2.getText());
                break;
            case R.id.radioButton3:
                getSupportActionBar().setTitle(rb3.getText());
                break;
            case R.id.radioButton4:
                getSupportActionBar().setTitle(rb4.getText());
                break;
        }
    }

    public void accesoMenuFunction(View v) {
        Intent intent = new Intent(RadioActivity.this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

}
