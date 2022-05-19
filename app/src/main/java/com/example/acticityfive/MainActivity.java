package com.example.acticityfive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText edtyear;
TextView txtageresult;
Button btncalculate;
int ageresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncalculate = (Button)findViewById(R.id.btncalculate);
        txtageresult = findViewById(R.id.txtageresult);
        if( savedInstanceState!= null){
            ageresult = savedInstanceState.getInt("age");
         txtageresult.setText(""+ageresult);

        }
        edtyear = findViewById(R.id.edityear);
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              ageresult = java.util.Calendar.getInstance().get(Calendar.YEAR)-Integer.parseInt(edtyear.getText().toString());
              txtageresult.setText(""+ageresult);
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState);
        outState.putInt("age",ageresult);
    }
}