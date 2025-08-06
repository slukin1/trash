package com.tencent.qcloud.tuikit.tuicallkit.view.root;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.base.CallingUserModel;
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingStatusManager;
import com.tencent.qcloud.tuikit.tuicallkit.base.UserLayout;
import com.tencent.qcloud.tuikit.tuicallkit.base.UserLayoutEntity;
import com.tencent.qcloud.tuikit.tuicallkit.utils.DeviceUtils;
import com.tencent.qcloud.tuikit.tuicallkit.utils.DisplayUtils;
import com.tencent.qcloud.tuikit.tuicallkit.utils.ImageLoader;
import com.tencent.qcloud.tuikit.tuicallkit.view.UserLayoutFactory;
import java.util.ArrayList;
import java.util.Iterator;

public class TUICallingGroupView extends BaseCallView {
    private int mCount = 0;
    private ArrayList<RelativeLayout.LayoutParams> mGrid1ParamList;
    private ArrayList<RelativeLayout.LayoutParams> mGrid2ParamList;
    private ArrayList<RelativeLayout.LayoutParams> mGrid3ParamList;
    private ArrayList<RelativeLayout.LayoutParams> mGrid4ParamList;
    private ArrayList<RelativeLayout.LayoutParams> mGrid9ParamList;
    private boolean mInitParam = false;
    private RelativeLayout mLayoutAddUserView;
    private RelativeLayout mLayoutFloatView;
    private RelativeLayout mLayoutFunction;
    private RelativeLayout mLayoutGroupManager;
    private View mRootView;
    private TextView mTextCallHint;
    private TextView mTextTime;
    private UserLayoutFactory mUserLayoutFactory;

    public TUICallingGroupView(Context context, UserLayoutFactory userLayoutFactory) {
        super(context);
        this.mUserLayoutFactory = userLayoutFactory;
        initView();
        initData();
    }

    private UserLayout allocUserLayout(CallingUserModel callingUserModel) {
        if (callingUserModel == null || TextUtils.isEmpty(callingUserModel.userId) || this.mCount > 9) {
            return null;
        }
        UserLayout allocUserLayout = this.mUserLayoutFactory.allocUserLayout(callingUserModel);
        if (allocUserLayout.getParent() != null) {
            ((ViewGroup) allocUserLayout.getParent()).removeView(allocUserLayout);
        }
        this.mLayoutGroupManager.addView(allocUserLayout);
        this.mCount++;
        post(new Runnable() {
            public void run() {
                TUICallingGroupView.this.makeGirdLayout(true);
            }
        });
        return allocUserLayout;
    }

    private void initData() {
        Iterator it2 = this.mUserLayoutFactory.mLayoutEntityList.iterator();
        while (it2.hasNext()) {
            UserLayoutEntity userLayoutEntity = (UserLayoutEntity) it2.next();
            if (userLayoutEntity != null && !TextUtils.isEmpty(userLayoutEntity.userId)) {
                UserLayout allocUserLayout = allocUserLayout(userLayoutEntity.userModel);
                TUICallDefine.MediaType mediaType = TUICallingStatusManager.sharedInstance(this.mContext).getMediaType();
                if (userLayoutEntity.userId.equals(TUILogin.getLoginUser())) {
                    if (TUICallDefine.MediaType.Video.equals(mediaType)) {
                        allocUserLayout.setVideoAvailable(true);
                        this.mCallingAction.openCamera(TUICallingStatusManager.sharedInstance(this.mContext).getFrontCamera(), allocUserLayout.getVideoView(), (TUICommonDefine.Callback) null);
                    } else {
                        ImageLoader.loadImage(this.mContext, userLayoutEntity.layout.getAvatarImage(), TUILogin.getFaceUrl(), R.drawable.tuicalling_ic_avatar);
                        userLayoutEntity.layout.setUserName(TUILogin.getNickName());
                    }
                } else if (userLayoutEntity.userModel != null) {
                    if (TUICallDefine.MediaType.Video.equals(mediaType) && userLayoutEntity.userModel.isVideoAvailable) {
                        allocUserLayout.setVideoAvailable(true);
                        this.mCallingAction.startRemoteView(userLayoutEntity.userId, allocUserLayout.getVideoView(), (TUICommonDefine.PlayCallback) null);
                    }
                    ImageLoader.loadImage(this.mContext, userLayoutEntity.layout.getAvatarImage(), userLayoutEntity.userModel.userAvatar, R.drawable.tuicalling_ic_avatar);
                    userLayoutEntity.layout.setUserName(userLayoutEntity.userModel.userName);
                    if (userLayoutEntity.userModel.isEnter) {
                        userLayoutEntity.layout.stopLoading();
                    } else {
                        userLayoutEntity.layout.startLoading();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void makeGirdLayout(boolean z11) {
        ArrayList<RelativeLayout.LayoutParams> arrayList;
        if (!this.mInitParam) {
            int min = Math.min(DeviceUtils.getScreenWidth(this.mContext), DeviceUtils.getScreenHeight(this.mContext));
            this.mGrid1ParamList = DisplayUtils.initGrid1Param(getContext(), min, min);
            this.mGrid2ParamList = DisplayUtils.initGrid2Param(getContext(), min, min);
            this.mGrid3ParamList = DisplayUtils.initGrid3Param(getContext(), min, min);
            this.mGrid4ParamList = DisplayUtils.initGrid4Param(getContext(), min, min);
            this.mGrid9ParamList = DisplayUtils.initGrid9Param(getContext(), min, min);
            this.mInitParam = true;
        }
        UserLayoutFactory userLayoutFactory = this.mUserLayoutFactory;
        if (userLayoutFactory != null && !userLayoutFactory.mLayoutEntityList.isEmpty() && z11) {
            int i11 = this.mCount;
            if (i11 <= 1) {
                this.mUserLayoutFactory.mLayoutEntityList.get(0).layout.setLayoutParams(this.mGrid1ParamList.get(0));
                return;
            }
            if (i11 == 2) {
                arrayList = this.mGrid2ParamList;
            } else if (i11 == 3) {
                arrayList = this.mGrid3ParamList;
            } else if (i11 == 4) {
                arrayList = this.mGrid4ParamList;
            } else {
                arrayList = this.mGrid9ParamList;
            }
            int isEmpty = true ^ TextUtils.isEmpty(TUILogin.getLoginUser());
            for (int i12 = 0; i12 < this.mUserLayoutFactory.mLayoutEntityList.size(); i12++) {
                UserLayoutEntity userLayoutEntity = this.mUserLayoutFactory.mLayoutEntityList.get(i12);
                if (userLayoutEntity.userId.equals(TUILogin.getLoginUser())) {
                    userLayoutEntity.layout.setLayoutParams(arrayList.get(0));
                } else if (isEmpty < arrayList.size()) {
                    userLayoutEntity.layout.setLayoutParams(arrayList.get(isEmpty));
                    isEmpty++;
                }
            }
        }
    }

    private void recyclerAllUserLayout() {
        UserLayoutFactory userLayoutFactory = this.mUserLayoutFactory;
        if (userLayoutFactory != null) {
            Iterator it2 = userLayoutFactory.mLayoutEntityList.iterator();
            while (it2.hasNext()) {
                this.mLayoutGroupManager.removeView(((UserLayoutEntity) it2.next()).layout);
                it2.remove();
            }
            this.mCount = 0;
        }
    }

    private void recyclerUserLayout(String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator it2 = this.mUserLayoutFactory.mLayoutEntityList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                UserLayoutEntity userLayoutEntity = (UserLayoutEntity) it2.next();
                if (str.equals(userLayoutEntity.userId)) {
                    this.mLayoutGroupManager.removeView(userLayoutEntity.layout);
                    it2.remove();
                    this.mCount--;
                    break;
                }
            }
            post(new Runnable() {
                public void run() {
                    TUICallingGroupView.this.makeGirdLayout(true);
                }
            });
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

    public void finish() {
        if (this.mLayoutGroupManager != null) {
            recyclerAllUserLayout();
        }
        super.finish();
    }

    public void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.tuicalling_background_group_view, this);
        this.mLayoutGroupManager = (RelativeLayout) findViewById(R.id.group_layout_manager);
        this.mLayoutFloatView = (RelativeLayout) findViewById(R.id.rl_float_view);
        this.mLayoutAddUserView = (RelativeLayout) findViewById(R.id.rl_add_user_view);
        this.mTextCallHint = (TextView) findViewById(R.id.tv_group_call_hint);
        this.mTextTime = (TextView) findViewById(R.id.tv_group_time);
        this.mLayoutFunction = (RelativeLayout) findViewById(R.id.rl_group_function);
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

    public void updateUserInfo(CallingUserModel callingUserModel) {
        super.updateUserInfo(callingUserModel);
        UserLayout findUserLayout = this.mUserLayoutFactory.findUserLayout(callingUserModel.userId);
        if (findUserLayout != null) {
            findUserLayout.setVideoAvailable(callingUserModel.isVideoAvailable);
            ImageLoader.loadImage(this.mContext, findUserLayout.getAvatarImage(), callingUserModel.userAvatar, R.drawable.tuicalling_ic_avatar);
        }
    }

    public void userAdd(CallingUserModel callingUserModel) {
        super.userAdd(callingUserModel);
        UserLayout findUserLayout = this.mUserLayoutFactory.findUserLayout(callingUserModel.userId);
        if (findUserLayout == null) {
            findUserLayout = allocUserLayout(callingUserModel);
        }
        if (findUserLayout != null) {
            findUserLayout.startLoading();
            TUICallDefine.MediaType mediaType = TUICallingStatusManager.sharedInstance(this.mContext).getMediaType();
            TUICallDefine.MediaType mediaType2 = TUICallDefine.MediaType.Video;
            findUserLayout.setVideoAvailable(mediaType2.equals(mediaType));
            if (mediaType2.equals(mediaType)) {
                this.mCallingAction.startRemoteView(callingUserModel.userId, findUserLayout.getVideoView(), (TUICommonDefine.PlayCallback) null);
            } else {
                ImageLoader.loadImage(this.mContext, findUserLayout.getAvatarImage(), callingUserModel.userAvatar, R.drawable.tuicalling_ic_avatar);
            }
        }
    }

    public void userEnter(CallingUserModel callingUserModel) {
        super.userEnter(callingUserModel);
        UserLayout findUserLayout = this.mUserLayoutFactory.findUserLayout(callingUserModel.userId);
        if (findUserLayout == null) {
            findUserLayout = allocUserLayout(callingUserModel);
        }
        if (findUserLayout != null) {
            findUserLayout.stopLoading();
            TUICallDefine.MediaType mediaType = TUICallingStatusManager.sharedInstance(this.mContext).getMediaType();
            TUICallDefine.MediaType mediaType2 = TUICallDefine.MediaType.Video;
            findUserLayout.setVideoAvailable(mediaType2.equals(mediaType));
            if (mediaType2.equals(mediaType)) {
                this.mCallingAction.startRemoteView(callingUserModel.userId, findUserLayout.getVideoView(), (TUICommonDefine.PlayCallback) null);
            } else {
                ImageLoader.loadImage(this.mContext, findUserLayout.getAvatarImage(), callingUserModel.userAvatar, R.drawable.tuicalling_ic_avatar);
            }
        }
    }

    public void userLeave(CallingUserModel callingUserModel) {
        super.userLeave(callingUserModel);
        if (callingUserModel != null) {
            recyclerUserLayout(callingUserModel.userId);
            this.mCallingAction.stopRemoteView(callingUserModel.userId);
        }
    }
}
