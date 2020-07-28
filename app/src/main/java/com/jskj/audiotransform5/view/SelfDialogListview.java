package com.jskj.audiotransform5.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jskj.audiotransform5.R;
import com.jskj.audiotransform5.adapter.BluetoothDeviceListItemAdapter;

/**
 * Created by Administrator on 2016/12/20.
 */

//自定义dialog
public class SelfDialogListview extends Dialog {
    private final Context mContext;
    private ListView mListView;
//    LinearLayout mLinearlayout;

    public SelfDialogListview(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    private void initView() {
        View contentView = View.inflate(mContext, R.layout.selfdialoglistview, null);
        mListView = (ListView) contentView.findViewById(R.id.lv);
//        mLinearlayout = contentView.findViewById(R.id.container_ll);
//        mLinearlayout.setBackgroundResource(R.drawable.shape_dialog);
        setContentView(contentView);
    }

    public void initListView(BluetoothDeviceListItemAdapter mAdapter) {

        mListView.setAdapter(mAdapter);
    }

    public ListView getListView(){
        return mListView;
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (!hasFocus) {
            return;
        }
        setHeight();
    }

    private void setHeight() {
        Window window = getWindow();
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (window.getDecorView().getHeight() >= (int) (displayMetrics.heightPixels * 0.6)) {
            attributes.height = (int) (displayMetrics.heightPixels * 0.6);
        }
        window.setAttributes(attributes);
    }
}