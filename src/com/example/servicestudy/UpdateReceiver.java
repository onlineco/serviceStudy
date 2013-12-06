package com.example.servicestudy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


public class UpdateReceiver extends BroadcastReceiver {

	public static Handler handler;

	@Override
	public void onReceive(Context context, Intent intent) {

		Bundle bundle = intent.getExtras();
		String message = bundle.getString("message");
		
		if(handler !=null){
			Message msg = new Message();
			
			Bundle data = new Bundle();
			data.putString("message", message);
			msg.setData(data);
			handler.sendMessage(msg);
		}
	}
	
	/**
	 * ���j���[��ʂ̏Z���\�����X�V
	 * @param serviceHandler
	 */
	public void registerHandler(Handler locationUpdateHandler) {
	    handler = locationUpdateHandler;
	}
	


}