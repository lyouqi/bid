package com.zdph.tender.adpter;

import java.util.ArrayList;
import java.util.List;

import com.zdph.tender.R;
import com.zdph.tender.model.MainPageItem;
import com.zdph.tender.model.TenderInformation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyProjectAdapter extends BaseAdapter {
	private Context context;

	private List<TenderInformation> list;
	private LayoutInflater mInflater;

	public MyProjectAdapter(Context c) {
		super();
		this.context = c;
	}

	public void setList(List<TenderInformation> list) {
		this.list = list;
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int index) {

		return list.get(index);
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	@Override
	public View getView(int index, View convertView, ViewGroup parent) {
		convertView = mInflater.inflate(R.layout.myproject_content_single, null);
		ImageView prj_img = (ImageView) convertView.findViewById(R.id.prj_img);
		TextView prj_textView = (TextView) convertView
				.findViewById(R.id.prj_textView);

		TenderInformation info = list.get(index);
		if (info != null) {
			prj_textView.setText(info.getEcpName());
			prj_img.setImageResource(R.drawable.cmcc);
		}
		return convertView;
	}
}