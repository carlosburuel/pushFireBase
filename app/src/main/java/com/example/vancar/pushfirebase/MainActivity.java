package com.example.vancar.pushfirebase;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//https://www.youtube.com/watch?v=jh9Yqfq5CSg&index=2&list=WL&t=73s
public class MainActivity extends AppCompatActivity
{
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v)
      {
	      //Obtencion de preferencias compartidas
        SharedPreferences sharedPreferences =
	        getApplicationContext().getSharedPreferences(getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
	      //Lectura del token generado por Firebase
        String token = sharedPreferences.getString(getString(R.string.FCM_TOKEN), "");
      }
    });
  }
}