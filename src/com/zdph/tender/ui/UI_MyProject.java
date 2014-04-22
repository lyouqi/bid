package com.zdph.tender.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.zdph.tender.R;
import com.zdph.tender.adpter.MyProjectAdapter;
import com.zdph.tender.model.TenderInformation;

public class UI_MyProject extends Activity {
	private ViewPager mViewPager = null;
	private List<TenderInformation> list;
	private ListView listView=null;
	private LinearLayout footbar_tenderfile, footbar_myproject, footbar_member, footbar_set;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// 取消软键盘
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		
		mViewPager = (ViewPager) findViewById(R.id.tabpager);
		
		listView = (ListView)findViewById(R.id.list_myproject);
		initFootBar();
		loadMenuList();
		initListView();
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
        
        //初始化底部显示界面
        footbar_tenderfile.setSelected(false);
		footbar_myproject.setSelected(true);
		footbar_member.setSelected(false);
		footbar_set.setSelected(false);	
}
	 private OnClickListener clickListener_tenderfile=new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UI_MyProject.this,UI_Main.class);
				startActivity(it);
				finish();
				}
		};
		
		private OnClickListener clickListener_myproject=new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		};
		private OnClickListener clickListener_member=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UI_MyProject.this,UI_Member.class);
				startActivity(it);
				finish();
			}
		};
		private OnClickListener clickListener_set=new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(UI_MyProject.this,UI_Setup.class);
				startActivity(it);
				finish();
			}
		};

	protected void loadMenuList() {
		list = new ArrayList<TenderInformation>();
		list.add(initTenderInformation1());
		list.add(initTenderInformation2());
		list.add(initTenderInformation3());
		list.add(initTenderInformation4());
	}
	private void initListView(){
		MyProjectAdapter myAdapter = new MyProjectAdapter(getApplicationContext());
		myAdapter.setList(list);
		listView.setAdapter(myAdapter);
		myAdapter.notifyDataSetChanged();
	}

	// 测试数据1
	private TenderInformation initTenderInformation1() {
		TenderInformation info = new TenderInformation();
		info.setEcpName("2014年度安徽省电力公司第三批次废旧物资处置竞价公告");
		info.setEcpContent("本次拟竞价处置废旧物资主要包括变压器、导线、电力电缆、断路器、电能表、开关柜等");
		info.setEcpId("1");
		return info;
	}

	// 测试数据2
	private TenderInformation initTenderInformation2() {
		TenderInformation info = new TenderInformation();
		info.setEcpName("2014年机房防雷地网工程项目");
		info.setEcpContent("2014年度中国移动通信集团公司广东分公司(以下简称”省公司“)下达的相关机房配套建设项目等对机房专业防雷工作，以及其他2014年省公司下达的"
				+ "相关机房配套建设项目的机房专业防雷地网工作");
		info.setEcpId("2");
		return info;
	}

	// 测试数据3
	private TenderInformation initTenderInformation3() {
		TenderInformation info = new TenderInformation();
		info.setEcpName("大唐黄岛发电有限公司输煤工具间改造招标公告");
		info.setEcpContent("工程名称：大唐黄岛发电有限公司改造资金来源：已经落实施地点：青岛开发区");
		info.setEcpId("1");
		return info;
	}

	// 测试数据4
	private TenderInformation initTenderInformation4() {
		TenderInformation info = new TenderInformation();
		info.setEcpName("云南省签署三条高速公路");
		info.setEcpContent("本次签约的新昆嵩、曲宣、蒙 文砚三条高速公路均为国高网高速公路，涉及投资总额约为321亿元"
				+ "建设里程约为294公里，采用合作建设的方式，按照“整体打包”的原则，以”BOT+ECP+地方政府补贴模式投资建设");
		info.setEcpId("1");
		return info;
	}
}
