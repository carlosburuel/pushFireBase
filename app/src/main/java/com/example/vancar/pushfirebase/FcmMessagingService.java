package com.example.vancar.pushfirebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * @author Carlos Buruel
 */

public class FcmMessagingService extends FirebaseMessagingService
{
	/**
	 * Recepcion de push y aplicacion de custom para la misma
	 * @param remoteMessage Contenedor de Push
	 */
	@Override
	public void onMessageReceived(RemoteMessage remoteMessage)
	{
		//Obtencion de titulo de push
		String title = remoteMessage.getNotification().getTitle();
		//Obtencion de contenido de la push
		String message = remoteMessage.getNotification().getBody();

		//Creacion de intent al precionar la push
		Intent intent = new Intent(this, MainActivity.class);
		//Regla para limpiar toda actividad previa de la aplicacion
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
		//Creacion de notificacion
		NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
		//Se asigna el titulo de la push
		notificationBuilder.setContentTitle(title);
		//Se asigna el contenido de la push leida
		notificationBuilder.setContentText(message);
		//Se asigna un icono a la notificacion
		notificationBuilder.setSmallIcon(R.drawable.ic_eagle);
		//Se asigna la propiedad de ser autocancelable
		notificationBuilder.setAutoCancel(true);
		//Se asigna el intent a ejecutar al ser presionada
		notificationBuilder.setContentIntent(pendingIntent);
		//region Notificacion al sistema de la notificacion
		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(0, notificationBuilder.build());
		//endregion
	}
}