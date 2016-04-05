package com.example.popupwindowexercise;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity implements OnClickListener{

	private Button bt_showPopuwindow;
	private Button bt_showPopuwindow2;
	private PopupWindow mPopupWindow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		bt_showPopuwindow = (Button) findViewById(R.id.showPopuwindow);
		bt_showPopuwindow2 = (Button) findViewById(R.id.showPopuwindow2);
		bt_showPopuwindow.setOnClickListener(this);
		bt_showPopuwindow2.setOnClickListener(this);
		initPopupWindow();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.showPopuwindow:
			//initPopupWindow1(v);
			showPopupWindow1(v);
			break;
		case R.id.showPopuwindow2:
			//initPopupWindow1(v);
			showPopupWindow2(v);
			break;
		default:
			break;
		}
	}

	private void showPopupWindow2(View v) {
		// TODO Auto-generated method stub
		mPopupWindow.setAnimationStyle(R.style.PopuwindowAnimStyle2);
		int[] location = new int[2];//注意这个方法，获得控件的宽和高
		v.getLocationOnScreen(location);
		mPopupWindow.showAtLocation(v,Gravity.TOP|Gravity.RIGHT,0,location[1]+v.getHeight());
	}

	private void showPopupWindow1(View v) {
		// TODO Auto-generated method stub
		//动画
		mPopupWindow.setAnimationStyle(R.style.PopuwindowAnimStyle);
		//位置
		mPopupWindow.showAtLocation(v,Gravity.BOTTOM,0,0);
	}

	private void initPopupWindow() {
		// TODO Auto-generated method stub
		mPopupWindow = new PopupWindow(this);
		mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
		mPopupWindow.setWidth(LayoutParams.WRAP_CONTENT);
		mPopupWindow.setHeight(LayoutParams.WRAP_CONTENT);
		mPopupWindow.setOutsideTouchable(false);
		mPopupWindow.setFocusable(true);
		View content = this.getLayoutInflater().inflate(R.layout.popuwindow_layout, null);
		mPopupWindow.setContentView(content);
		//mPopupWindow.setAnimationStyle(R.style.PopuwindowAnimStyle);
	}
}
