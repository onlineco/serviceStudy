package com.example.servicestudy;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class UpdateService extends Service {

	private Handler handler;
	private UpdateService context;

	@Override
	public int onStartCommand(Intent intent, int flags, int startid) {

		super.onStartCommand(intent, flags, startid);

		Log.d("UpdateService", "サービススタート");
		sleep(4000);
		
		String message = "さーびすからのメッセージ";
		sendBroadCast(message); 

		return START_STICKY;
	}

	public void registerHandler(Handler UpdateHandler) {
		handler = UpdateHandler;
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public synchronized void sleep(long msec) {
		try {
			wait(msec);
		} catch (InterruptedException e) {
		}
	}
	
	protected void sendBroadCast(String message) {

		Intent broadcastIntent = new Intent();
		broadcastIntent.putExtra("message", message);
		broadcastIntent.setAction("UPDATE_ACTION");
		getBaseContext().sendBroadcast(broadcastIntent);

	}
}
