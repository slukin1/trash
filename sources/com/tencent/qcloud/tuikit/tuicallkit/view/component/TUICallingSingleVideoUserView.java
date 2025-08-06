package com.tencent.qcloud.tuikit.tuicallkit.view.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.base.CallingUserModel;
import com.tencent.qcloud.tuikit.tuicallkit.utils.ImageLoader;

public class TUICallingSingleVideoUserView extends BaseUserView {
    private Context mContext;
    private String mHintMessage;
    private ImageView mImageAvatar;
    private TextView mTextUserName;
    private TextView mTextVideoHint;

    public TUICallingSingleVideoUserView(Context context, String str) {
        super(context);
        this.mContext = context.getApplicationContext();
        this.mHintMessage = str;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tuicalling_single_video_user_view, this);
        this.mImageAvatar = (ImageView) findViewById(R.id.iv_user_avatar);
        this.mTextUserName = (TextView) findViewById(R.id.tv_user_name);
        TextView textView = (TextView) findViewById(R.id.tv_video_tag);
        this.mTextVideoHint = textView;
        textView.setText(this.mHintMessage);
    }

    public void updateUserInfo(CallingUserModel callingUserModel) {
        super.updateUserInfo(callingUserModel);
        if (callingUserModel != null && !TextUtils.isEmpty(callingUserModel.userId)) {
            ImageLoader.loadImage(this.mContext, this.mImageAvatar, callingUserModel.userAvatar, R.drawable.tuicalling_ic_avatar);
            this.mTextUserName.setText(TextUtils.isEmpty(callingUserModel.userName) ? callingUserModel.userId : callingUserModel.userName);
        }
    }
}
