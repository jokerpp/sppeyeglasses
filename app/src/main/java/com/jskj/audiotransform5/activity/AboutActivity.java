package com.jskj.audiotransform5.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jskj.audiotransform5.R;
import com.jskj.audiotransform5.base.BaseActivity;
import com.jskj.audiotransform5.constants.PreferencesConstants;
import com.jskj.audiotransform5.util.CommonUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//import butterknife.BindView;
//import butterknife.ButterKnife;

public class AboutActivity extends BaseActivity {

//    @BindView(R.id.mimagebutton)
    ImageView mBack;
    RelativeLayout mAboutusRl;
    RelativeLayout mAgreementRl;
    TextView mTitleTv;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_aboutus);
        super.onCreate(savedInstanceState);
//        ButterKnife.bind(this);
    }

    @Override
    public void initViews() {
        mBack = this.findViewById(R.id.backbutton);
        mAboutusRl = this.findViewById(R.id.policy_rl);
        mAgreementRl = this.findViewById(R.id.agreement_rl);
        mTitleTv = this.findViewById(R.id.title_text);
    }

    @Override
    public void initDatas() {
        mTitleTv.setText("关于见声看见App");
    }

    @Override
    public void installListeners() {
        mAboutusRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this,AboutusDetailActivity.class);
                intent.putExtra(PreferencesConstants.aboutusParamsTitle_KEY,"关于我们");
                intent.putExtra(PreferencesConstants.aboutusParamsUrl_KEY,"about");
                if(!CommonUtil.isDoubleClick()) {
                    startActivity(intent);
                }
            }
        });
        mAgreementRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this,AboutusDetailActivity.class);
                intent.putExtra(PreferencesConstants.aboutusParamsTitle_KEY,"使用协议");
                intent.putExtra(PreferencesConstants.aboutusParamsUrl_KEY,"terms_conditions");
                if(!CommonUtil.isDoubleClick()) {
                    startActivity(intent);
                }
            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void processHandlerMessage(Message msg) {

    }
}
