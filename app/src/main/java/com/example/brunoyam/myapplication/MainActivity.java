package com.example.brunoyam.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    EditText et1;
    EditText et2;
    TextView tv;
    Button btn;


    SharedPreferences sPref;
    static int i = 0;
    final String SAVED_TEXT = "saved_text";

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.login);
        et2 = (EditText) findViewById(R.id.password);
        btn = (Button) findViewById(R.id.send);
        tv = (TextView) findViewById(R.id.information);
        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*String result = "login:" + et1.getText().toString() + "\n";
                result += "password:" + Objects.hashCode(et2.getText().toString()) + "\n";
                tv.setText(result + tv.getText().toString());
                Intent intention = new Intent(v.getContext(), SecondActivity.class);
                intention.putExtra(MainActivity.EXTRA_MESSAGE, result);
                startActivity(intention);
                System.out.println(v.getId()==R.id.send);*/
                String result = "login:" + et1.getText().toString() + "\n";
                result += "password:" + Objects.hashCode(et2.getText().toString()) + "\n";
                ((MainActivity) v.getContext()).saveText(result);
            }
        };

        btn.setOnClickListener(listener);

    }

    public void delete(View v) {
        /*Toast toast = Toast.makeText(this, et1.getText().toString()+  " " + et2.getText().toString(),Toast.LENGTH_LONG);
        toast.show();*/
        Intent intention = new Intent(this, SecondActivity.class);
        intention.putExtra(this.EXTRA_MESSAGE, tv.getText());
        startActivity(intention);
        tv.setText("");
        et1.setText("");
        et2.setText("");
        loadText();

    }


    void saveText(String value) {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT + String.valueOf(i), value);
        ed.commit();
        i++;
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String result = "";
        for (int j = i - 1; j > -1; j--) {
            String temp = sPref.getString(SAVED_TEXT + String.valueOf(j), "no value found");
            result += temp;
        }
        tv.setText(result);
        //Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }


    /*public void sendMessage(View view) {
     *//*Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);*//*

    }*/
    class ProgressTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            for (int j = 0; j < 4; j++) {
                SystemClock.sleep(2000);
                publishProgress(j);
            }
            return null;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
