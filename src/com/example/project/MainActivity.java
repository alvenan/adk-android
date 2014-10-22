package com.example.project;

import com.example.androidadkanalogled.R;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends AbsAdkActivity {

    TextView textIn;
    SeekBar seekBarBrightness;

    @Override
    protected void doOnCreate(Bundle savedInstanceState) {
	setContentView(R.layout.activity_main);
	initialize();
	seekBarBrightness
		.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

		    @Override
		    public void onProgressChanged(SeekBar seekBar,
			    int progress, boolean fromUser) {
			WriteByteAdk((byte) (progress & 0xFF));
		    }

		    @Override
		    public void onStartTrackingTouch(SeekBar arg0) {
		    }

		    @Override
		    public void onStopTrackingTouch(SeekBar arg0) {
		    }
		});
    }

    private void initialize() {
	textIn = (TextView) findViewById(R.id.textin);
	seekBarBrightness = (SeekBar) findViewById(R.id.seekbarbrightness);
    }

    @Override
    protected void doAdkRead(String stringIn) {
	// textIn.setText(stringIn);
    }

}
