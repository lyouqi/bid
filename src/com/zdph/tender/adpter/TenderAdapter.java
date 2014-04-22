package com.zdph.tender.adpter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.zdph.tender.R;
import com.zdph.tender.model.Tender;

public class TenderAdapter extends BaseAdapter {
	private Context context;

	private List<Tender> list;
	private LayoutInflater mInflater;

	public TenderAdapter(Context c) {
		super();
		this.context = c;
	}

	public void setList(List<Tender> list) {
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
		convertView = mInflater.inflate(R.layout.gridview_content_single, null);
		 
		TextView prj_textView = (TextView) convertView
				.findViewById(R.id.tender_context);

		Tender info = list.get(index);
		if (info != null) {
			prj_textView.setText(info.getName());
		}
		return convertView;
	}
}