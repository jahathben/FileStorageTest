package com.example.android1.filestoragetest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class SecondActivity extends ActionBarActivity {

    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
    }


    public void load(View view){

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("Jay.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int read = -1;
        StringBuffer buffer = new StringBuffer();
        String text1 = null;
        String text2 = null;
        try {
            while ((read = fileInputStream.read()) != -1){
                buffer.append((char)read);
            }
            text1 = buffer.substring(0, buffer.indexOf(" "));
            text2 = buffer.substring(buffer.indexOf(" ") + 1);
            username.setText(text1);
            password.setText(text2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Nothing to load", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Load Successful", Toast.LENGTH_SHORT).show();

        /*if (text1 != null && text2 != null){
            Toast.makeText(this, "Load Successful", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Nothing to load", Toast.LENGTH_SHORT).show();
        }*/
    }

    public void previous(View view){

        Toast.makeText(this, "Previous", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
}
