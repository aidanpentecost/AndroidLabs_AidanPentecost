package com.cst2335.pent0028;
/*
Assignment: Lab 2
Class: CST7335 Mobile Graphical Interface Programming
Lab section: 300
Student: Aidan Pentecost 41077552
Professor: Amandeep Kahlon
* */

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Toast message for onClick attribute of the button object
                Toast.makeText(MainActivity.this, getResources().getString(R.string.toast_message), Toast.LENGTH_LONG).show();

            }//end onClick()

        });//end onClickListener declaration

        Switch s = findViewById(R.id.Switch);

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton button, boolean isChecked) {
                Snackbar snackbar = (isChecked) //condition
                        //This line if true
                        ? Snackbar.make(MainActivity.this, s, getResources().getString(R.string.SnackbarOn), Snackbar.LENGTH_LONG).setAction("Undo", click-> button.setChecked(!isChecked))
                        //This line if false
                        : Snackbar.make(MainActivity.this, s, getResources().getString(R.string.SnackbarOff), Snackbar.LENGTH_LONG).setAction("Undo", click-> button.setChecked(!isChecked));

                snackbar.show();

                //I realize the previous line looks very suspicious. I have fallen in love with the () ? : format for assignments
                //In the first draft of the code, it was a normal if - else structure

            }//end onCheckedChanged

        });//End OnCheckedListener declaration

    }//end onCreate()

}//end class