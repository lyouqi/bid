package com.zdph.tender.ui;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.zdph.tender.R;

public class UI_Member extends Activity {
	private LinearLayout footbar_tenderfile, footbar_myproject, footbar_member, footbar_set;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// ȡ�������
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.member);
		
		initFootBar();
	}
	private void initFootBar(){
		footbar_tenderfile= (LinearLayout) findViewById(R.id.footbar_tenderfile);
		footbar_tenderfile.setOnClickListener(clickListener_tenderfile);

        footbar_myproject = (LinearLayout) findViewById(R.id.footbar_myproject);
        footbar_myproject.setOnClickListener(clickListener_myproject);
        
        footbar_member = (LinearLayout) findViewById(R.id.footbar_member);
        footbar_member.setOnClickListener(clickListener_member);
        
        footbar_set = (LinearLayout) findViewById(R.id.footbar_set);
        footbar_set.setOnClickListener(clickListener_set);
        
        //��ʼ���ײ���ʾ����
    	footbar_tenderfile.setSelected(false);
		footbar_myproject.setSelected(false);
		footbar_member.setSelected(true);
		footbar_set.setSelected(false);	
}
	 private OnClickListener clickListener_tenderfile=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UI_Member.this,UI_Main.class);
				startActivity(it);
				finish();
				}
		};
		private OnClickListener clickListener_myproject=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UI_Member.this,UI_MyProject.class);
				startActivity(it);
				finish();
			}
		};
		private OnClickListener clickListener_member=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
			}
		};
		private OnClickListener clickListener_set=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UI_Member.this,UI_Setup.class);
				startActivity(it);
				finish();
			}
		};

}
