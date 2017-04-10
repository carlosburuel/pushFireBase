package com.example.vancar.pushfirebase;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * @author Carlos Buruel
 */

public class FcmInstanceIdService extends FirebaseInstanceIdService
{
	//Obtencion de token para el uso de firebase
  @Override
  public void onTokenRefresh()
  {
	  //Lectura de token para el uso de firebase
    String recent_token = FirebaseInstanceId.getInstance().getToken();
	  //Obtener instancia de preferencias compartidas
    SharedPreferences sharedPreferences =
	    getApplicationContext().getSharedPreferences(getString(R.string.FCM_PREF), Context.MODE_PRIVATE);
	  //Modo edicion de preferencias compartidas
    SharedPreferences.Editor editor = sharedPreferences.edit();
	  //Guardar token generado en preferencias compartidas
    editor.putString(getString(R.string.FCM_TOKEN), recent_token);
	  //Aplicar los campos sobre las preferencias compartidas
    editor.apply();
  }
}