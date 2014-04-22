package com.zdph.tender.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.zdph.tender.R;
import com.zdph.tender.fragmentactivity.MemberActivity;
import com.zdph.tender.fragmentactivity.MyProjectActivity;
import com.zdph.tender.fragmentactivity.SetActivity;
import com.zdph.tender.fragmentactivity.TenderFileActivity;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity implements OnClickListener {

	private TabHost mTabHost = null;
	private LinearLayout footbar_tenderfile, footbar_myproject, footbar_member,
			footbar_set;
	private RelativeLayout titlebar=null;
	private TextView titlebar_text;
	private ImageView titlebar_img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// 取消软键盘
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		mTabHost = this.getTabHost();
		mTabHost.addTab(mTabHost.newTabSpec("ONE").setIndicator("ONE")
				.setContent(new Intent(this, TenderFileActivity.class)));
		mTabHost.addTab(mTabHost.newTabSpec("TWO").setIndicator("TWO")
				.setContent(new Intent(this, MyProjectActivity.class)));
		mTabHost.addTab(mTabHost.newTabSpec("THREE").setIndicator("THREE")
				.setContent(new Intent(this, MemberActivity.class)));
		mTabHost.addTab(mTabHost.newTabSpec("FOUR").setIndicator("FOUR")
				.setContent(new Intent(this, SetActivity.class)));
		//初始化界面底部
		initFootBar();
		//初始化界面顶部
		initTitleBar();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.footbar_tenderfile:
			mTabHost.setCurrentTabByTag("ONE");
			footbar_tenderfile.setSelected(true);
			footbar_myproject.setSelected(false);
			footbar_member.setSelected(false);
			footbar_set.setSelected(false);
			titlebar_img.setVisibility(View.VISIBLE);
			titlebar_img.setBackgroundResource(R.drawable.icon_mail);
			titlebar_text.setText("我的频道");
			break;
		case R.id.footbar_myproject:
			mTabHost.setCurrentTabByTag("TWO");
			footbar_tenderfile.setSelected(false);
			footbar_myproject.setSelected(true);
			footbar_member.setSelected(false);
			footbar_set.setSelected(false);
			titlebar_text.setText("关注的项目");
			titlebar_img.setBackgroundResource(R.drawable.icon_myproject);
			titlebar_img.setVisibility(View.VISIBLE);
			break;
		case R.id.footbar_member:
			mTabHost.setCurrentTabByTag("THREE");
			footbar_tenderfile.setSelected(false);
			footbar_myproject.setSelected(false);
			footbar_member.setSelected(true);
			footbar_set.setSelected(false);
			titlebar_text.setText("详细资料");
			titlebar_img.setVisibility(View.INVISIBLE);
			break;
		case R.id.footbar_set:
			mTabHost.setCurrentTabByTag("FOUR");
			footbar_tenderfile.setSelected(false);
			footbar_myproject.setSelected(false);
			footbar_member.setSelected(false);
			footbar_set.setSelected(true);
			titlebar_text.setText("设置");
			titlebar_img.setVisibility(View.INVISIBLE);
			break;
		}
	}
	private void initTitleBar(){
		titlebar=(RelativeLayout)findViewById(R.id.titlebar);
		titlebar_text=(TextView)findViewById(R.id.titlebar_text);
		titlebar_img=(ImageView)findViewById(R.id.titlebar_img);
		
	}

	private void initFootBar() {
		footbar_tenderfile = (LinearLayout) findViewById(R.id.footbar_tenderfile);
		footbar_tenderfile.setOnClickListener(this);

		footbar_myproject = (LinearLayout) findViewById(R.id.footbar_myproject);
		footbar_myproject.setOnClickListener(this);

		footbar_member = (LinearLayout) findViewById(R.id.footbar_member);
		footbar_member.setOnClickListener(this);

		footbar_set = (LinearLayout) findViewById(R.id.footbar_set);
		footbar_set.setOnClickListener(this);
		// 初始化底部显示界面
		footbar_tenderfile.setSelected(true);
		footbar_myproject.setSelected(false);
		footbar_member.setSelected(false);
		footbar_set.setSelected(false);
	}
}
