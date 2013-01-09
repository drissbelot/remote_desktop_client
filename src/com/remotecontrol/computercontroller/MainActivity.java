package com.remotecontrol.computercontroller;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class MainActivity extends Activity {

	private SeekBar volumeSeekBar;
	private Button rightClickButton;
	private Button leftClickButton;
	private HttpController httpController;
	
	private LinearLayout mousePad;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		httpController = new HttpController();

		initializeLeftClickButton();
		initializeRightClickButton();
		initializeVolumeSeekBar();
	}

	private void initializeVolumeSeekBar() {
		volumeSeekBar = (SeekBar)findViewById(R.id.seekbar);
		volumeSeekBar.setMax(100);
		volumeSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

				Integer progressInt = (Integer) progress;
				httpController.postNewVolume(progressInt.toString());
			}
		});
	}

	private void initializeRightClickButton() {
		rightClickButton = (Button) findViewById(R.id.right_click);
		rightClickButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				//postData();
			}
		});
	}

	private void initializeLeftClickButton() {
		leftClickButton = (Button) findViewById(R.id.left_click);
		leftClickButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// Perform action on click
				//postData();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	


}
