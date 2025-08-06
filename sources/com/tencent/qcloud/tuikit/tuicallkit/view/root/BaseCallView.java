package com.tencent.qcloud.tuikit.tuicallkit.view.root;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.qcloud.tuikit.tuicallkit.base.CallingUserModel;
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingAction;

public abstract class BaseCallView extends RelativeLayout {
    public TUICallingAction mCallingAction;
    public Context mContext;

    public BaseCallView(Context context) {
        super(context);
        this.mContext = context;
        this.mCallingAction = new TUICallingAction(context);
    }

    public void addOtherUserView(View view) {
    }

    public void clearAllViews() {
        updateCallingHint("");
        updateCallTimeView((String) null);
        updateUserView((View) null);
        updateFunctionView((View) null);
        updateSwitchAudioView((View) null);
        addOtherUserView((View) null);
    }

    public void enableAddUserView(View view) {
    }

    public void enableFloatView(View view) {
    }

    public void finish() {
        clearAllViews();
        removeAllViews();
        detachAllViewsFromParent();
        onDetachedFromWindow();
    }

    public void updateBackgroundColor(int i11) {
    }

    public void updateCallTimeView(String str) {
    }

    public void updateCallingHint(String str) {
    }

    public void updateFunctionView(View view) {
    }

    public void updateSwitchAudioView(View view) {
    }

    public void updateTextColor(int i11) {
    }

    public void updateUserInfo(CallingUserModel callingUserModel) {
    }

    public void updateUserView(View view) {
    }

    public void userAdd(CallingUserModel callingUserModel) {
    }

    public void userEnter(CallingUserModel callingUserModel) {
    }

    public void userLeave(CallingUserModel callingUserModel) {
    }
}
