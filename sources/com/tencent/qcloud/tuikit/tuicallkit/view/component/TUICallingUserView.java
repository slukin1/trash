package com.tencent.qcloud.tuikit.tuicallkit.view.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.base.CallingUserModel;
import com.tencent.qcloud.tuikit.tuicallkit.utils.ImageLoader;

public class TUICallingUserView extends BaseUserView {
    private Context mContext;
    private ImageView mImageAvatar;
    private TextView mTextUserName;

    public TUICallingUserView(Context context) {
        super(context);
        this.mContext = context.getApplicationContext();
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tuicalling_user_view, this);
        this.mImageAvatar = (ImageView) findViewById(R.id.img_avatar);
        this.mTextUserName = (TextView) findViewById(R.id.tv_name);
    }

    public void updateTextColor(int i11) {
        super.updateTextColor(i11);
        this.mTextUserName.setTextColor(i11);
    }

    public void updateUserInfo(CallingUserModel callingUserModel) {
        super.updateUserInfo(callingUserModel);
        ImageLoader.loadImage(this.mContext, this.mImageAvatar, callingUserModel.userAvatar, R.drawable.tuicalling_ic_avatar);
        this.mTextUserName.setText(TextUtils.isEmpty(callingUserModel.userName) ? callingUserModel.userId : callingUserModel.userName);
    }
}
