package com.tencent.qcloud.tuikit.tuicallkit.view.root;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.tuicallkit.R;

public class TUICallingImageView extends BaseCallView {
    private Context mContext;
    private RelativeLayout mLayoutAddUserView;
    private RelativeLayout mLayoutFloatView;
    private RelativeLayout mLayoutFunction;
    private LinearLayout mLayoutOtherUserContainer;
    private RelativeLayout mLayoutUserView;
    private View mRootView;
    private TextView mTextCallHint;
    private TextView mTextTime;

    public TUICallingImageView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public void addOtherUserView(View view) {
        super.addOtherUserView(view);
        this.mLayoutOtherUserContainer.removeAllViews();
        if (view != null) {
            this.mLayoutOtherUserContainer.addView(view);
        }
    }

    public void enableAddUserView(View view) {
        this.mLayoutAddUserView.removeAllViews();
        if (view != null) {
            this.mLayoutAddUserView.addView(view);
        }
    }

    public void enableFloatView(View view) {
        this.mLayoutFloatView.removeAllViews();
        if (view != null) {
            this.mLayoutFloatView.addView(view);
        }
    }

    public void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.tuicalling_background_image_view, this);
        this.mLayoutFloatView = (RelativeLayout) findViewById(R.id.rl_float_view);
        this.mLayoutAddUserView = (RelativeLayout) findViewById(R.id.rl_add_user_view);
        this.mLayoutUserView = (RelativeLayout) findViewById(R.id.rl_single_audio_view);
        this.mTextCallHint = (TextView) findViewById(R.id.tv_call_hint);
        this.mLayoutOtherUserContainer = (LinearLayout) findViewById(R.id.ll_other_user_container);
        this.mTextTime = (TextView) findViewById(R.id.tv_image_time);
        this.mLayoutFunction = (RelativeLayout) findViewById(R.id.rl_image_function);
    }

    public void updateBackgroundColor(int i11) {
        this.mRootView.setBackgroundColor(i11);
    }

    public void updateCallTimeView(String str) {
        this.mTextTime.setText(str);
        this.mTextTime.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    public void updateCallingHint(String str) {
        super.updateCallingHint(str);
        this.mTextCallHint.setText(str);
        this.mTextCallHint.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    public void updateFunctionView(View view) {
        this.mLayoutFunction.removeAllViews();
        if (view != null) {
            this.mLayoutFunction.addView(view);
        }
    }

    public void updateTextColor(int i11) {
        super.updateTextColor(i11);
        this.mTextCallHint.setTextColor(i11);
        this.mTextTime.setTextColor(i11);
    }

    public void updateUserView(View view) {
        super.updateUserView(view);
        this.mLayoutUserView.removeAllViews();
        if (view != null) {
            this.mLayoutUserView.addView(view);
        }
    }
}
