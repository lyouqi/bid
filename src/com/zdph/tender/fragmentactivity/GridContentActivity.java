package com.zdph.tender.fragmentactivity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zdph.tender.R;
import com.zdph.tender.adpter.TenderAdapter;
import com.zdph.tender.fragment.TenderContentFragment;
import com.zdph.tender.model.Tender;

public class GridContentActivity extends BaseFragmentActivity implements
		 OnItemClickListener,OnClickListener{
	private ListView listView = null;
	private List<Tender> list = null;
	private TenderContentFragment tenderContentFragment; 

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// ȡ�������
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview_content);
		
		findViewById(R.id.imgViewBack).setVisibility(View.VISIBLE);
		findViewById(R.id.imgViewBack).setOnClickListener(this);
		
		tenderContentFragment = (TenderContentFragment)GridContentActivity.this.getSupportFragmentManager().findFragmentById(R.id.gridcontentfragment);
		GridContentActivity.this.getSupportFragmentManager().beginTransaction().hide(tenderContentFragment).commit();
		
		((TextView) findViewById(R.id.titlebar_text)).setText("���ҵ���");
		findViewById(R.id.titlebar_img).setVisibility(View.INVISIBLE);
		listView = (ListView) super.findViewById(R.id.grid_list);
		listView.setOnItemClickListener(this);
		
		loadList();
		initListView();
	}
	
	private void loadList() {
		list = new ArrayList<Tender>();
		for (int i = 0; i <= 5; i++) {
			Tender tender = initTender();
			tender.setId(i);
			list.add(tender);
		}
	}



	private void initListView() {
		TenderAdapter tenderAdapter = new TenderAdapter(getApplicationContext());
		tenderAdapter.setList(list);
		listView.setAdapter(tenderAdapter);
		tenderAdapter.notifyDataSetChanged();
	}

	// ��������1
	private Tender initTender() {
		Tender tender = new Tender();
		tender.setName("��������ʡ������˾2014���һ����������Э�����б�ɹ���Ŀ");
		tender.setStation("�����б�");
		tender.setNumber("HNXY-1401");
		tender.setSignTime(getCurrentDate());
		tender.setStartTime(getCurrentDate());
		tender.setEndTime(getCurrentDate());
		tender.setType("������");
		tender.setFeeType("����ǰ֧��");
		tender.setPurchaseTime(getCurrentDate());
		tender.setIntroduction("");
		tender.setFile("�����б��ļ�����");
		tender.setOwner("���ҵ�����˾");
		tender.setAgency("�������ܴ�ҵ�б�������޹�˾");
		tender.setContact("Ф��");
		tender.setTelephone("0731-85337505");
		tender.setFax("0731-84905267");
		tender.setEmail("dingl3@hn.sgcc.com.cn");
		return tender;
	}

	private long getCurrentDate() {
		return System.currentTimeMillis();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "hello world!"+position, Toast.LENGTH_SHORT).show();
			tenderContentFragment.initView(initTender());
			GridContentActivity.this.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right).show(tenderContentFragment).commit();
	}
	

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(!tenderContentFragment.isHidden())
            {
           	 getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right).hide(tenderContentFragment).commit();
           	 return true;
            }
       }
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}
}
