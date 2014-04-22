package com.zdph.tender.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.zdph.tender.R;
import com.zdph.tender.activity.MainActivity;

public class UI_Login extends Activity {

	private Button loginbtn = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// »°œ˚»Ìº¸≈Ã
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.login);
		loginbtn = (Button) super.findViewById(R.id.login_button);
		loginbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(UI_Login.this, MainActivity.class);
				UI_Login.this.startActivity(it);
			}
		});
	}
}
