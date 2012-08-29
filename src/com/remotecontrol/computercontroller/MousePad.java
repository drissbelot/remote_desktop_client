package com.remotecontrol.computercontroller;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MousePad extends LinearLayout {

	private float X_offset;
	private float Y_offset;

	public MousePad(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public boolean onTouchEvent(MotionEvent event){

		int size;
		Log.e("offsets", "x: " + X_offset + " y: " + Y_offset );
		switch(event.getAction()){
		case MotionEvent.ACTION_MOVE:
			float initialTouchX = event.getX();
			float initialTouchY = event.getY();
			Log.e("offsets", "initx: " + initialTouchX + " inity: " + initialTouchY );
			size = event.getHistorySize()-1;
			if (size == -1){
				size = 0;
			}
			float endTouchX = event.getHistoricalX(size);
			float endTouchY = event.getHistoricalY(size);

			X_offset -= 10*event.getHistorySize()*(endTouchX - initialTouchX);
			Y_offset -= 10*event.getHistorySize()*(endTouchY- initialTouchY);
			Log.e("offsets", "x: " + X_offset + " y: " + Y_offset );
			if(X_offset > 0){
				X_offset = 0;
			}
			if(Y_offset > 0){
				Y_offset = 0;
			}

			if(X_offset < -250){
				X_offset = -250;
			}
			if(Y_offset < -250){
				Y_offset = -250;
			}
			break;
		}
		return true;
	}

}
