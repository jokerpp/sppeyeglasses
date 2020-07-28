package com.jskj.audiotransform5.activity;

import android.os.Bundle;
import android.os.Message;
import android.widget.ImageView;

import com.jskj.audiotransform5.R;
import com.jskj.audiotransform5.base.BaseActivity;
import com.jskj.audiotransform5.base.BaseWebActivity;
import com.jskj.audiotransform5.constants.PreferencesConstants;

import androidx.annotation.Nullable;
//import butterknife.BindView;
//import butterknife.ButterKnife;

public class AboutusDetailActivity extends BaseWebActivity {


    private String title;
    private String urlAppend;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        title = extras.getString(PreferencesConstants.aboutusParamsTitle_KEY);
        urlAppend = extras.getString(PreferencesConstants.aboutusParamsUrl_KEY);
        super.onCreate(savedInstanceState);
        mTitleTextView.setText(title);

    }
    @Override
    public String getUrl() {
        return super.getUrl()+urlAppend;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
