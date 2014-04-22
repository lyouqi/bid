package com.zdph.tender.fragmentactivity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

import com.zdph.tender.R;
import com.zdph.tender.adpter.MyProjectAdapter;
import com.zdph.tender.model.TenderInformation;

public class MyProjectActivity extends BaseFragmentActivity implements
		OnClickListener {
	private List<TenderInformation> list;
	private ListView listView = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// ȡ�������
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		//ȡ��������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.myproject);
		listView = (ListView) findViewById(R.id.list_myproject);
		loadMenuList();
		initListView();
	}

	protected void loadMenuList() {
		list = new ArrayList<TenderInformation>();
		list.add(initTenderInformation1());
		list.add(initTenderInformation2());
		list.add(initTenderInformation3());
		list.add(initTenderInformation4());
	}

	private void initListView() {
		MyProjectAdapter myAdapter = new MyProjectAdapter(
				getApplicationContext());
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
