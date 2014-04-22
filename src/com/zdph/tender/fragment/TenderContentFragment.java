package com.zdph.tender.fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zdph.tender.R;
import com.zdph.tender.model.Tender;

public class TenderContentFragment extends BaseFragment implements OnClickListener{

	private View root;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		root = inflater.inflate(R.layout.tenderdetail, container, false);
		((TextView) root.findViewById(R.id.titlebar_text)).setText("œÍœ∏–≈œ¢");
		((ImageView) root.findViewById(R.id.titlebar_img))
				.setVisibility(View.INVISIBLE);
		root.findViewById(R.id.imgViewBack).setVisibility(View.VISIBLE);
		root.findViewById(R.id.imgViewBack).setOnClickListener(this);
		return root;
	}

	public void initView(Tender tender) {
		((TextView) root.findViewById(R.id.tender_name)).setText(tender
				.getName());
		((TextView) root.findViewById(R.id.tender_station)).setText(tender
				.getStation());
		((TextView) root.findViewById(R.id.tender_number)).setText(tender
				.getNumber());
		((TextView) root.findViewById(R.id.tender_signTime))
				.setText(getDate(tender.getSignTime()));
		((TextView) root.findViewById(R.id.tender_startTime))
				.setText(getDate(tender.getStartTime()));
		((TextView) root.findViewById(R.id.tender_endTime))
				.setText(getDate(tender.getEndTime()));
		((TextView) root.findViewById(R.id.tender_type)).setText(tender
				.getType());
		((TextView) root.findViewById(R.id.tender_feeType)).setText(tender
				.getFeeType());
		((TextView) root.findViewById(R.id.tender_purchaseTime))
				.setText(getDate(tender.getPurchaseTime()));
		((TextView) root.findViewById(R.id.tender_introduction)).setText(tender
				.getIntroduction());
		((TextView) root.findViewById(R.id.tender_file)).setText(tender
				.getFile());
		((TextView) root.findViewById(R.id.tender_owner)).setText(tender
				.getOwner());
		((TextView) root.findViewById(R.id.tender_agency)).setText(tender
				.getAgency());
		((TextView) root.findViewById(R.id.tender_contact)).setText(tender
				.getContact());
		((TextView) root.findViewById(R.id.tender_tel)).setText(tender
				.getTelephone());
		((TextView) root.findViewById(R.id.tender_fax))
				.setText(tender.getFax());
		((TextView) root.findViewById(R.id.tender_email)).setText(tender
				.getEmail());
	}

	@SuppressLint("SimpleDateFormat")
	private String getDate(long time) {
		String str = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(str);
		return format.format(new Date(time));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 getFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right).hide(this).commit();
	}
}
