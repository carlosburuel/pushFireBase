package com.example.vancar.pushfirebase;

import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 *
 */

public class FcmMessagingService extends FirebaseMessagingService
{
	@Override
	public void onMessageReceived(RemoteMessage remoteMessage)
	{
		String title = remoteMessage.getNotification().getTitle();
		String message = remoteMessage.getNotification().getBody();

		System.out.println(title + ", "+ message);
	}
}