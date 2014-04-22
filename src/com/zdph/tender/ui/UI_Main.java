package com.zdph.tender.ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.zdph.tender.R;
import com.zdph.tender.adpter.MainPageAdapter;
import com.zdph.tender.model.MainPageItem;
import com.zdph.tender.view.MyScrollView;

public class UI_Main extends Activity implements OnGestureListener,
		OnTouchListener {
	private GestureDetector mGestureDetector;
	private TextView date_TextView = null;
	private ViewFlipper viewFlipper;
	private GridView gridview;
	private LinearLayout footbar_tenderfile, footbar_myproject, footbar_member,
			footbar_set;
	private ViewPager mViewPager = null;
	private List<View> views = new ArrayList<View>();
	private View view1,view2,view3,view4;

	private PagerAdapter mPagerAdapter = null;
	private int currentPage = 0;
	private boolean showNext = true;
	private boolean isRun = true;
	private final int SHOW_NEXT = 0011;
	private static final int FLING_MIN_DISTANCE = 50;
	private static final int FLING_MIN_VELOCITY = 0;
	private List<MainPageItem> list;

	private MainPageAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);

		mViewPager = (ViewPager) findViewById(R.id.tabpager);
		mGestureDetector = new GestureDetector(this);
		
		initView();
		initComponent1();
		initGridView();
		initPageAdapter();
		initFootBar();
		thread.start();
		mViewPager.setAdapter(mPagerAdapter);
	}

	private void initComponent1() {
		MyScrollView myScrollView = (MyScrollView) view1
				.findViewById(R.id.viewflipper_scrollview);
		myScrollView.setOnTouchListener(onTouchListener);
		myScrollView.setGestureDetector(mGestureDetector);
		date_TextView = (TextView) view1.findViewById(R.id.home_date_tv);
		gridview = (GridView) view1.findViewById(R.id.gridview);
		viewFlipper = (ViewFlipper) view1.findViewById(R.id.mViewFliper_vf);

		date_TextView.setText(getDate());
		viewFlipper.setOnTouchListener(this);
		viewFlipper.setLongClickable(true);
		viewFlipper.setOnClickListener(clickListener);
	}
	
 	private void initView() {
		LayoutInflater mLi = LayoutInflater.from(this);
		view1 = mLi.inflate(R.layout.tenderinfo, null);
		view2 =mLi.inflate(R.layout.myproject, null);
		view3 = mLi.inflate(R.layout.member, null);
		view4 =mLi.inflate(R.layout.setup,null);
		views = new ArrayList<View>();
		views.add(view1);
		views.add(view2);
		views.add(view3);
		views.add(view4);
	}

	private void initPageAdapter() {
		mPagerAdapter = new PagerAdapter() {
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return views.size();
			}

			@Override
			public void destroyItem(View container, int position, Object object) {
				((ViewPager) container).removeView(views.get(position));
			}

			@Override
			public Object instantiateItem(View container, int position) {
				((ViewPager) container).addView(views.get(position));
				return views.get(position);
			}
		};
	}

	private OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			toastInfo("点击事件");
		}
	};

	private OnTouchListener onTouchListener = new OnTouchListener() {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			return mGestureDetector.onTouchEvent(event);
		}
	};

	private String getDate() {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		int w = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		String mDate = c.get(Calendar.YEAR) + "年" + c.get(Calendar.MONTH) + "月"
				+ c.get(Calendar.DATE) + "日  " + weekDays[w];
		return mDate;
	}

	private void toastInfo(String string) {
		Toast.makeText(UI_Main.this, string, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	private void initFootBar() {
		footbar_tenderfile = (LinearLayout) findViewById(R.id.footbar_tenderfile);
		footbar_tenderfile.setOnClickListener(new MyOnClickListener(0));

		footbar_myproject = (LinearLayout) findViewById(R.id.footbar_myproject);
		footbar_myproject.setOnClickListener(new MyOnClickListener(1));

		footbar_member = (LinearLayout) findViewById(R.id.footbar_member);
		footbar_member.setOnClickListener(new MyOnClickListener(2));

		footbar_set = (LinearLayout) findViewById(R.id.footbar_set);
		footbar_set.setOnClickListener(new MyOnClickListener(3));
		// 初始化底部显示界面
		footbar_tenderfile.setSelected(true);
		footbar_myproject.setSelected(false);
		footbar_member.setSelected(false);
		footbar_set.setSelected(false);
	}
	
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;
		public MyOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
//			mViewPager.setCurrentItem(index);
			switch(index){
			case 1:
				Intent it=new Intent(UI_Main.this,UI_MyProject.class);
				UI_Main.this.startActivity(it);
				finish();
			case 2:
				Intent it2=new Intent(UI_Main.this,UI_MyProject.class);
				UI_Main.this.startActivity(it2);
			}
		}
	};

	private void initGridView() {
		// TODO Auto-generated method stub
		loadMenuList();
		adapter = new MainPageAdapter(this);
		adapter.setList(list);
		gridview.setAdapter(adapter);
		// gridview.setOnItemClickListener(new OnItemClickListener() {
		// @Override
		// public void onItemClick(AdapterView<?> parent, View view,
		// int position, long id) {
		// final Intent intent = new Intent();
		// switch (position) {
		// case 0:// 我的联系人
		// intent.setClass(UI_Main.this, ContacterMainActivity.class);
		// startActivity(intent);
		// break;
		// case 1:// 我的消息
		// intent.setClass(context, MyNoticeActivity.class);
		// startActivity(intent);
		// break;
		// case 2:// 企业通讯录
		// break;
		// case 3:// 个人通讯录
		// break;
		// case 4:// 我的邮件
		// break;
		// case 5:// 网络收藏夹
		// break;
		// case 6:// 个人文件夹
		// break;
		// }
		// }
	}

	/**
	 * 
	 * 加载菜单.
	 * 
	 * @author shimiso
	 * @update 2012-5-16 下午7:15:21
	 */
	protected void loadMenuList() {
		list = new ArrayList<MainPageItem>();
		list.add(new MainPageItem("中国大唐", R.drawable.cdt));
		list.add(new MainPageItem("国家电网", R.drawable.sgcc));
		list.add(new MainPageItem("中国移动", R.drawable.cmcc));
		list.add(new MainPageItem("中国能建", R.drawable.ceec));
		list.add(new MainPageItem("中广核", R.drawable.cgn));
		list.add(new MainPageItem("新澳集团", R.drawable.enn));
		list.add(new MainPageItem("国机集团", R.drawable.sinomach));
		list.add(new MainPageItem("", R.drawable.plus));
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		Log.e("view", "onFling");
		if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
				&& Math.abs(velocityX) > FLING_MIN_VELOCITY) {
			Log.e("fling", "left");
			showNextView();
			showNext = true;
		} else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
				&& Math.abs(velocityX) > FLING_MIN_VELOCITY) {
			Log.e("fling", "right");
			showPreviousView();
			showNext = false;
		}
		return false;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	Thread thread = new Thread() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (isRun) {
				try {
					Thread.sleep(1000 * 2);
					Message msg = new Message();
					msg.what = SHOW_NEXT;
					mHandler.sendMessage(msg);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	};

	@SuppressLint("HandlerLeak")
	Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case SHOW_NEXT:
				if (showNext) {
					showNextView();
				} else {
					showPreviousView();
				}
				break;

			default:
				break;
			}
		}

	};

	private void showNextView() {
		viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
				R.anim.push_left_in));
		viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
				R.anim.push_left_out));
		viewFlipper.showNext();
		currentPage++;
		if (currentPage == viewFlipper.getChildCount()) {
			displayRatio_normal(currentPage - 1);
			currentPage = 0;
			displayRatio_selelct(currentPage);
		} else {
			displayRatio_selelct(currentPage);
			displayRatio_normal(currentPage - 1);
		}
		Log.e("currentPage", currentPage + "");
	}

	private void showPreviousView() {
		displayRatio_selelct(currentPage);
		viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
				R.anim.push_right_in));
		viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
				R.anim.push_right_out));
		viewFlipper.showPrevious();
		currentPage--;
		if (currentPage == -1) {
			displayRatio_normal(currentPage + 1);
			currentPage = viewFlipper.getChildCount() - 1;
			displayRatio_selelct(currentPage);
		} else {
			displayRatio_selelct(currentPage);
			displayRatio_normal(currentPage + 1);
		}
		Log.e("currentPage", currentPage + "");
	}

	private void displayRatio_selelct(int id) {
		int[] ratioId = { R.id.home_ratio_img_04, R.id.home_ratio_img_03,
				R.id.home_ratio_img_02, R.id.home_ratio_img_01 };
		ImageView img = (ImageView) findViewById(ratioId[id]);
		img.setSelected(true);
	}

	private void displayRatio_normal(int id) {
		int[] ratioId = { R.id.home_ratio_img_04, R.id.home_ratio_img_03,
				R.id.home_ratio_img_02, R.id.home_ratio_img_01 };
		ImageView img = (ImageView) findViewById(ratioId[id]);
		img.setSelected(false);
	}
}
