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
		// ȡ�������
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
        
        //��ʼ���ײ���ʾ����
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

	// ��������1
	private TenderInformation initTenderInformation1() {
		TenderInformation info = new TenderInformation();
		info.setEcpName("2014��Ȱ���ʡ������˾�������ηϾ����ʴ��þ��۹���");
		info.setEcpContent("�����⾺�۴��÷Ͼ�������Ҫ������ѹ�������ߡ��������¡���·�������ܱ����ع��");
		info.setEcpId("1");
		return info;
	}

	// ��������2
	private TenderInformation initTenderInformation2() {
		TenderInformation info = new TenderInformation();
		info.setEcpName("2014��������׵���������Ŀ");
		info.setEcpContent("2014����й��ƶ�ͨ�ż��Ź�˾�㶫�ֹ�˾(���¼�ơ�ʡ��˾��)�´����ػ������׽�����Ŀ�ȶԻ���רҵ���׹������Լ�����2014��ʡ��˾�´��"
				+ "��ػ������׽�����Ŀ�Ļ���רҵ���׵�������");
		info.setEcpId("2");
		return info;
	}

	// ��������3
	private TenderInformation initTenderInformation3() {
		TenderInformation info = new TenderInformation();
		info.setEcpName("���ƻƵ��������޹�˾��ú���߼�����б깫��");
		info.setEcpContent("�������ƣ����ƻƵ��������޹�˾�����ʽ���Դ���Ѿ���ʵʩ�ص㣺�ൺ������");
		info.setEcpId("1");
		return info;
	}

	// ��������4
	private TenderInformation initTenderInformation4() {
		TenderInformation info = new TenderInformation();
		info.setEcpName("����ʡǩ���������ٹ�·");
		info.setEcpContent("����ǩԼ�������ԡ��������� �����������ٹ�·��Ϊ���������ٹ�·���漰Ͷ���ܶ�ԼΪ321��Ԫ"
				+ "�������ԼΪ294������ú�������ķ�ʽ�����ա�����������ԭ���ԡ�BOT+ECP+�ط���������ģʽͶ�ʽ���");
		info.setEcpId("1");
		return info;
	}
}
