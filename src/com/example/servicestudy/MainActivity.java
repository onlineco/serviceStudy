package com.example.servicestudy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private UpdateReceiver upReceiver;
	private IntentFilter intentFilter;
	private TextView message_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Context context = this;
		Intent update_service = new Intent(context , UpdateService.class);
		startService(update_service);
		
		upReceiver = new UpdateReceiver();
		intentFilter = new IntentFilter();
		intentFilter.addAction("UPDATE_ACTION");
		registerReceiver(upReceiver, intentFilter);

		upReceiver.registerHandler(updateHandler);
		message_tv = (TextView)findViewById(R.id.message_tv);

	}
	
	// サービスから値を受け取ったら動かしたい内容を書く
	private Handler updateHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			Bundle bundle = msg.getData();
			String message = bundle.getString("message");

			Log.d("Activityの名前", "はんどらーだよ" + message);
			message_tv.setText(message);

		}
	};



}
