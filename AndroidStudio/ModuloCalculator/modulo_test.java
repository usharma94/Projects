package com.example.upmasharma.modulo_test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button Btn1 = findViewById(R.id.modulo);
        Btn1.setOnClickListener(mod);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener mod = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText Num1 = findViewById(R.id.num1);
            EditText Num2 = findViewById(R.id.num2);

            int Result = Integer.parseInt(Num1.getText().toString()) % Integer.parseInt(Num2.getText().toString());

            TextView result = findViewById(R.id.result);

            result.setText(Integer.toString(Result));

            if (Result == 0){
                TextView result2 = findViewById(R.id.result2);
                result2.setText("The two are divisible by one another");

            } else{
                TextView result2 = findViewById(R.id.result2);
                result2.setText("The two are not divisible by each other");

            }

        }
    };
}



