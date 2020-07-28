package com.jskj.audiotransform5.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jskj.audiotransform5.R;
import com.jskj.audiotransform5.activity.AboutusDetailActivity;
import com.jskj.audiotransform5.activity.SplashActivity;
import com.jskj.audiotransform5.constants.PreferencesConstants;
import com.jskj.audiotransform5.richtext.NoUnderlineClickSpan;
import com.jskj.audiotransform5.richtext.TextSpanBuilder;
import com.jskj.audiotransform5.util.CommonUtil;

import androidx.annotation.NonNull;

/**
 * Created by Administrator on 2016/12/20.
 */

//自定义dialog
public class SelfDialogprivateagreement extends Dialog {
    //确定文本和取消文本的显示内容
    private String yesStr, noStr;
    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器

    private TextView selfMSG,selfTtile;
    private Button yes, no;
    private String titleMSG;
    CharSequence label;
    private CharSequence versonMSG;
    public SelfDialogprivateagreement(Context context) {
        super(context);
    }

    public SelfDialogprivateagreement(Context context, int themeResId) {
        super(context, themeResId);
    }
    public SelfDialogprivateagreement(final Activity context, int themeResId , String titleMSG) {
        super(context, themeResId);
        label = TextSpanBuilder.create("请务必认真阅读并充分理解“服务协议”和“隐私政策”各条款，包括但不限于：" +
                "为了向您提供语音翻译服务，我们需要您开启手机麦克风录音蓝牙等权限。您可以在“设置”中查看变更您的授权。"+
                 "\n您可阅读")
                .append("《隐私政策》")
                .foregroundColor(0xFF3fbded)
                .backgroundColor(Color.WHITE)
                .span(new NoUnderlineClickSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        //TODO 需要增加隐私政策
                        Toast.makeText(context,"隐私政策",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, AboutusDetailActivity.class);
                        intent.putExtra(PreferencesConstants.aboutusParamsTitle_KEY,"隐私政策");
                        intent.putExtra(PreferencesConstants.aboutusParamsUrl_KEY,"about");
                        if(!CommonUtil.isDoubleClick()) {
                            context.startActivity(intent);
                        }
                    }
                })
                .append("和")
                .append("《用户协议》")
                .foregroundColor(0xFF3fbded)
                .backgroundColor(Color.WHITE)
                .span(new NoUnderlineClickSpan() {
                    @Override
                    public void onClick(@NonNull View widget) {
                        Toast.makeText(context,"用户协议",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context,AboutusDetailActivity.class);
                        intent.putExtra(PreferencesConstants.aboutusParamsTitle_KEY,"使用协议");
                        intent.putExtra(PreferencesConstants.aboutusParamsUrl_KEY,"terms_conditions");
                        if(!CommonUtil.isDoubleClick()) {
                            context.startActivity(intent);
                        }
                    }
                })
                .append("了解详细信息。如您同意，请点击“同意”开始接受我们的服务。")
                .build();
        this.titleMSG = titleMSG;
        this.versonMSG=label;
    }


    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param str
     * @param onNoOnclickListener
     */
    public void setNoOnclickListener(String str, onNoOnclickListener onNoOnclickListener) {
        no.setText(str);
        if (str != null) {
            noStr = str;
        }
        this.noOnclickListener = onNoOnclickListener;
    }

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param str
     * @param onYesOnclickListener
     */
    public void setYesOnclickListener(String str, onYesOnclickListener onYesOnclickListener) {
        yes.setText(str);
        if (str != null) {
            yesStr = str;
        }
        this.yesOnclickListener = onYesOnclickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selfdialog_privateagreement);
        initView();
        setCancelable(false);
        //初始化界面控件的事件
        initEvent();
    }

    private void initEvent() {
        //设置确定按钮被点击后，向外界提供监听
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesClick();
                }
            }
        });
        //设置取消按钮被点击后，向外界提供监听
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noOnclickListener != null) {
                    noOnclickListener.onNoClick();
                }
            }
        });
    }

    private void initView() {
        selfMSG = ((TextView) findViewById(R.id.selfdg_mesg));
        selfTtile = findViewById(R.id.selfdg_title);
        yes = (Button) findViewById(R.id.selfdg_yes);
        no = (Button) findViewById(R.id.selfdg_no);
        selfMSG.setMovementMethod(LinkMovementMethod.getInstance());
        selfMSG.setText(versonMSG);
        selfTtile.setText(titleMSG);
    }


    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface onYesOnclickListener {
        public void onYesClick();
    }

    public interface onNoOnclickListener {
        public void onNoClick();
    }

}