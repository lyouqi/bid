package com.zdph.tender.fragment;

import com.zdph.tender.R;
import com.zdph.tender.fragmentactivity.BaseFragmentActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public  class BaseFragment extends Fragment {

	private ProgressDialog progressDialog;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 
	}

	public BaseFragmentActivity getBaseActivity() {
		return (BaseFragmentActivity) super.getActivity();
	}

	public void showProgressDialog() {
		if (progressDialog == null) {

			progressDialog = ProgressDialog.show(super.getActivity(),
					"Loading...", "���ڴ���...", true, false);
		}

		progressDialog.show();

	}

	public void hideProgressDialog() {

		progressDialog.dismiss();

	}


	public void showToask(String hint) {

		View toaskView = LayoutInflater.from(super.getActivity()).inflate(
				R.layout.toask_view, null);
		Toast toast = Toast.makeText(super.getActivity(), null, 1000);
		toast.setView(toaskView);
		((TextView) toaskView.findViewById(R.id.toaskMessage)).setText(hint);
		toast.show();
	}

}
