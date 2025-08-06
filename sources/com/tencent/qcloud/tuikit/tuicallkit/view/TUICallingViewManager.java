package com.tencent.qcloud.tuikit.tuicallkit.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.TUIVideoView;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.qcloud.tuikit.tuicallengine.utils.PermissionUtils;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.base.BaseCallActivity;
import com.tencent.qcloud.tuikit.tuicallkit.base.CallingUserModel;
import com.tencent.qcloud.tuikit.tuicallkit.base.Constants;
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingAction;
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingStatusManager;
import com.tencent.qcloud.tuikit.tuicallkit.base.UserLayout;
import com.tencent.qcloud.tuikit.tuicallkit.base.UserLayoutEntity;
import com.tencent.qcloud.tuikit.tuicallkit.extensions.inviteuser.SelectGroupMemberActivity;
import com.tencent.qcloud.tuikit.tuicallkit.utils.ImageLoader;
import com.tencent.qcloud.tuikit.tuicallkit.utils.PermissionRequest;
import com.tencent.qcloud.tuikit.tuicallkit.utils.UserInfoUtils;
import com.tencent.qcloud.tuikit.tuicallkit.view.common.RoundCornerImageView;
import com.tencent.qcloud.tuikit.tuicallkit.view.component.BaseUserView;
import com.tencent.qcloud.tuikit.tuicallkit.view.component.TUICallingSingleVideoUserView;
import com.tencent.qcloud.tuikit.tuicallkit.view.component.TUICallingUserView;
import com.tencent.qcloud.tuikit.tuicallkit.view.floatwindow.FloatCallView;
import com.tencent.qcloud.tuikit.tuicallkit.view.floatwindow.FloatWindowService;
import com.tencent.qcloud.tuikit.tuicallkit.view.floatwindow.HomeWatcher;
import com.tencent.qcloud.tuikit.tuicallkit.view.function.BaseFunctionView;
import com.tencent.qcloud.tuikit.tuicallkit.view.function.TUICallingAudioFunctionView;
import com.tencent.qcloud.tuikit.tuicallkit.view.function.TUICallingSwitchAudioView;
import com.tencent.qcloud.tuikit.tuicallkit.view.function.TUICallingVideoFunctionView;
import com.tencent.qcloud.tuikit.tuicallkit.view.function.TUICallingVideoInviteFunctionView;
import com.tencent.qcloud.tuikit.tuicallkit.view.function.TUICallingWaitFunctionView;
import com.tencent.qcloud.tuikit.tuicallkit.view.root.BaseCallView;
import com.tencent.qcloud.tuikit.tuicallkit.view.root.TUICallingGroupView;
import com.tencent.qcloud.tuikit.tuicallkit.view.root.TUICallingImageView;
import com.tencent.qcloud.tuikit.tuicallkit.view.root.TUICallingSingleView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TUICallingViewManager implements ITUINotification {
    private static final String TAG = "TUICallingViewManager";
    /* access modifiers changed from: private */
    public BaseCallView mBaseCallView;
    private final TUICallingAction mCallingAction;
    /* access modifiers changed from: private */
    public final Context mContext;
    private boolean mEnableFloatView = false;
    /* access modifiers changed from: private */
    public FloatCallView mFloatCallView;
    private BaseFunctionView mFunctionView;
    private HomeWatcher mHomeWatcher;
    /* access modifiers changed from: private */
    public ImageView mImageFloatFunction;
    /* access modifiers changed from: private */
    public List<CallingUserModel> mInviteeList = new ArrayList();
    /* access modifiers changed from: private */
    public CallingUserModel mInviter;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private LinearLayout mOtherUserLayout;
    /* access modifiers changed from: private */
    public CallingUserModel mSelfUserModel;
    private UserInfoUtils mUserInfoUtils;
    private final UserLayoutFactory mUserLayoutFactory;
    private BaseUserView mUserView;

    public TUICallingViewManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mUserLayoutFactory = new UserLayoutFactory(applicationContext);
        this.mCallingAction = new TUICallingAction(context);
        this.mUserInfoUtils = new UserInfoUtils();
        registerCallingEvent();
    }

    /* access modifiers changed from: private */
    public void addUser(CallingUserModel callingUserModel) {
        if (!this.mInviteeList.contains(callingUserModel)) {
            this.mInviteeList.add(callingUserModel);
        }
        BaseCallView baseCallView = this.mBaseCallView;
        if (baseCallView != null) {
            baseCallView.userAdd(callingUserModel);
        }
        loadUserInfo(callingUserModel);
    }

    private FloatCallView createFloatView() {
        FloatCallView floatCallView = new FloatCallView(this.mContext, this.mUserLayoutFactory);
        floatCallView.setOnClickListener(new FloatCallView.OnClickListener() {
            public void onClick() {
                FloatWindowService.stopService(TUICallingViewManager.this.mContext);
                FloatCallView unused = TUICallingViewManager.this.mFloatCallView = null;
                ImageView unused2 = TUICallingViewManager.this.mImageFloatFunction = null;
                TUICallDefine.MediaType mediaType = TUICallingStatusManager.sharedInstance(TUICallingViewManager.this.mContext).getMediaType();
                TUICallDefine.Scene callScene = TUICallingStatusManager.sharedInstance(TUICallingViewManager.this.mContext).getCallScene();
                if (TUICallDefine.MediaType.Video.equals(mediaType) && TUICallDefine.Scene.SINGLE_CALL.equals(callScene)) {
                    CallingUserModel access$500 = TUICallDefine.Role.Called.equals(TUICallingStatusManager.sharedInstance(TUICallingViewManager.this.mContext).getCallRole()) ? TUICallingViewManager.this.mInviter : (CallingUserModel) TUICallingViewManager.this.mInviteeList.get(0);
                    if (TUICallDefine.Status.Accept.equals(TUICallingStatusManager.sharedInstance(TUICallingViewManager.this.mContext).getCallStatus())) {
                        TUICallingViewManager tUICallingViewManager = TUICallingViewManager.this;
                        tUICallingViewManager.resetVideoCloudView(tUICallingViewManager.mSelfUserModel);
                        TUICallingViewManager.this.resetVideoCloudView(access$500);
                    } else {
                        TUICallingViewManager tUICallingViewManager2 = TUICallingViewManager.this;
                        tUICallingViewManager2.resetVideoCloudView(tUICallingViewManager2.mSelfUserModel);
                    }
                }
                TUICallingViewManager.this.showCallingView();
            }
        });
        return floatCallView;
    }

    private CallingUserModel findCallingUserModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator it2 = this.mUserLayoutFactory.mLayoutEntityList.iterator();
        while (it2.hasNext()) {
            UserLayoutEntity userLayoutEntity = (UserLayoutEntity) it2.next();
            if (userLayoutEntity != null && str.equals(userLayoutEntity.userId)) {
                return userLayoutEntity.userModel;
            }
        }
        return null;
    }

    private void initAudioPlayDevice() {
        TUICallingStatusManager.sharedInstance(this.mContext).updateAudioPlaybackDevice(TUICallDefine.MediaType.Audio.equals(TUICallingStatusManager.sharedInstance(this.mContext).getMediaType()) ? TUICommonDefine.AudioPlaybackDevice.Earpiece : TUICommonDefine.AudioPlaybackDevice.Speakerphone);
    }

    private void initFloatingWindowBtn() {
        if (this.mBaseCallView != null) {
            if (this.mEnableFloatView) {
                this.mImageFloatFunction = new ImageView(this.mContext);
                this.mImageFloatFunction.setBackgroundResource(TUICallDefine.MediaType.Video.equals(TUICallingStatusManager.sharedInstance(this.mContext).getMediaType()) ? R.drawable.tuicalling_ic_move_back_white : R.drawable.tuicalling_ic_move_back_black);
                this.mImageFloatFunction.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.mImageFloatFunction.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        TUICallingViewManager.this.startFloatService();
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
            }
            ImageView imageView = this.mImageFloatFunction;
            if (!(imageView == null || imageView.getParent() == null)) {
                ((ViewGroup) this.mImageFloatFunction.getParent()).removeView(this.mImageFloatFunction);
            }
            this.mBaseCallView.enableFloatView(this.mImageFloatFunction);
        }
    }

    private void initGroupAcceptCallView() {
        BaseFunctionView baseFunctionView;
        TUICallDefine.MediaType mediaType = TUICallingStatusManager.sharedInstance(this.mContext).getMediaType();
        if (TUICallDefine.Role.Caller.equals(TUICallingStatusManager.sharedInstance(this.mContext).getCallRole())) {
            if (this.mBaseCallView == null) {
                this.mBaseCallView = new TUICallingGroupView(this.mContext, this.mUserLayoutFactory);
            }
            if (TUICallDefine.MediaType.Video.equals(mediaType)) {
                TUICallingVideoFunctionView tUICallingVideoFunctionView = new TUICallingVideoFunctionView(this.mContext);
                this.mFunctionView = tUICallingVideoFunctionView;
                this.mBaseCallView.updateFunctionView(tUICallingVideoFunctionView);
            }
        } else {
            BaseCallView baseCallView = this.mBaseCallView;
            if (baseCallView != null) {
                baseCallView.finish();
            }
            this.mUserLayoutFactory.allocUserLayout(this.mInviter);
            for (CallingUserModel next : this.mInviteeList) {
                if (next != null && !TextUtils.isEmpty(next.userId)) {
                    this.mUserLayoutFactory.allocUserLayout(next);
                }
            }
            this.mBaseCallView = new TUICallingGroupView(this.mContext, this.mUserLayoutFactory);
            if (TUICallDefine.MediaType.Video.equals(mediaType)) {
                baseFunctionView = new TUICallingVideoFunctionView(this.mContext);
            } else {
                baseFunctionView = new TUICallingAudioFunctionView(this.mContext);
            }
            this.mFunctionView = baseFunctionView;
            this.mBaseCallView.updateFunctionView(baseFunctionView);
        }
        this.mFunctionView.setLocalUserLayout(this.mUserLayoutFactory.findUserLayout(TUILogin.getLoginUser()));
        this.mBaseCallView.updateCallingHint("");
        updateViewColor();
        updateFunctionStatus();
        initInviteUserFunction();
        initFloatingWindowBtn();
        BaseCallActivity.updateBaseView(this.mBaseCallView);
    }

    private void initGroupWaitingView() {
        String str;
        String str2;
        BaseFunctionView baseFunctionView;
        initSelfModel();
        initAudioPlayDevice();
        TUICallDefine.MediaType mediaType = TUICallingStatusManager.sharedInstance(this.mContext).getMediaType();
        if (TUICallDefine.Role.Caller.equals(TUICallingStatusManager.sharedInstance(this.mContext).getCallRole())) {
            this.mUserLayoutFactory.allocUserLayout(this.mSelfUserModel);
            for (CallingUserModel next : this.mInviteeList) {
                if (next != null && !TextUtils.isEmpty(next.userId)) {
                    this.mUserLayoutFactory.allocUserLayout(next);
                }
            }
            this.mBaseCallView = new TUICallingGroupView(this.mContext, this.mUserLayoutFactory);
            str = this.mContext.getString(R.string.tuicalling_waiting_accept);
            if (TUICallDefine.MediaType.Video.equals(mediaType)) {
                baseFunctionView = new TUICallingVideoFunctionView(this.mContext);
            } else {
                baseFunctionView = new TUICallingAudioFunctionView(this.mContext);
            }
            this.mFunctionView = baseFunctionView;
            initInviteUserFunction();
        } else {
            this.mBaseCallView = new TUICallingImageView(this.mContext);
            this.mUserView = new TUICallingUserView(this.mContext);
            this.mFunctionView = new TUICallingWaitFunctionView(this.mContext);
            if (TUICallDefine.MediaType.Audio.equals(mediaType)) {
                str2 = this.mContext.getString(R.string.tuicalling_invite_audio_call);
            } else {
                str2 = this.mContext.getString(R.string.tuicalling_invite_video_call);
            }
            str = str2;
            this.mBaseCallView.updateUserView(this.mUserView);
            this.mBaseCallView.addOtherUserView(initOtherInviteeView());
        }
        this.mFunctionView.setLocalUserLayout(this.mUserLayoutFactory.findUserLayout(TUILogin.getLoginUser()));
        this.mBaseCallView.updateCallingHint(str);
        this.mBaseCallView.updateFunctionView(this.mFunctionView);
        updateViewColor();
        updateFunctionStatus();
        initFloatingWindowBtn();
    }

    private void initHomeWatcher() {
        if (this.mHomeWatcher == null) {
            this.mHomeWatcher = new HomeWatcher(this.mContext);
        }
        this.mHomeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {
            public void onHomePressed() {
                if (PermissionUtils.hasPermission(TUICallingViewManager.this.mContext)) {
                    TUICallingViewManager.this.startFloatService();
                }
            }

            public void onRecentAppsPressed() {
                if (PermissionUtils.hasPermission(TUICallingViewManager.this.mContext)) {
                    TUICallingViewManager.this.startFloatService();
                }
            }
        });
        this.mHomeWatcher.startWatch();
    }

    private void initInviteUserFunction() {
        if (this.mBaseCallView != null) {
            Button button = new Button(this.mContext);
            button.setBackgroundResource(TUICallDefine.MediaType.Video.equals(TUICallingStatusManager.sharedInstance(this.mContext).getMediaType()) ? R.drawable.tuicalling_ic_add_user_white : R.drawable.tuicalling_ic_add_user_black);
            button.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    String groupId = TUICallingStatusManager.sharedInstance(TUICallingViewManager.this.mContext).getGroupId();
                    if (TextUtils.isEmpty(groupId)) {
                        ToastUtil.toastShortMessage(TUICallingViewManager.this.mContext.getString(R.string.tuicalling_groupid_is_empty));
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        return;
                    }
                    TUICallDefine.Status callStatus = TUICallingStatusManager.sharedInstance(TUICallingViewManager.this.mContext).getCallStatus();
                    if (!TUICallDefine.Role.Called.equals(TUICallingStatusManager.sharedInstance(TUICallingViewManager.this.mContext).getCallRole()) || TUICallDefine.Status.Accept.equals(callStatus)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(TUICallingViewManager.this.mInviter.userId);
                        for (CallingUserModel callingUserModel : TUICallingViewManager.this.mInviteeList) {
                            if (callingUserModel != null && !TextUtils.isEmpty(callingUserModel.userId) && !arrayList.contains(callingUserModel.userId)) {
                                arrayList.add(callingUserModel.userId);
                            }
                        }
                        if (!arrayList.contains(TUILogin.getLoginUser())) {
                            arrayList.add(TUILogin.getLoginUser());
                        }
                        TUILog.i(TUICallingViewManager.TAG, "initInviteUserFunction, groupId: " + groupId + " ,list: " + arrayList);
                        Bundle bundle = new Bundle();
                        bundle.putString("groupId", groupId);
                        bundle.putStringArrayList(Constants.SELECT_MEMBER_LIST, arrayList);
                        TUICore.startActivity("SelectGroupMemberActivity", bundle);
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        return;
                    }
                    ToastUtil.toastShortMessage(TUICallingViewManager.this.mContext.getString(R.string.tuicalling_status_is_not_accept));
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            this.mBaseCallView.enableAddUserView(button);
        }
    }

    private View initOtherInviteeView() {
        LinearLayout linearLayout = this.mOtherUserLayout;
        if (linearLayout == null) {
            this.mOtherUserLayout = new LinearLayout(this.mContext);
        } else {
            linearLayout.removeAllViews();
        }
        List<CallingUserModel> list = this.mInviteeList;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tuicalling_small_image_size);
        int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tuicalling_small_image_left_margin);
        for (int i11 = 0; i11 < list.size(); i11++) {
            CallingUserModel callingUserModel = list.get(i11);
            ImageView imageView = new ImageView(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelOffset, dimensionPixelOffset);
            if (i11 != 0) {
                layoutParams.leftMargin = dimensionPixelOffset2;
            }
            imageView.setLayoutParams(layoutParams);
            ImageLoader.loadImage(this.mContext, imageView, callingUserModel.userAvatar, R.drawable.tuicalling_ic_avatar);
            this.mOtherUserLayout.addView(imageView);
        }
        return this.mOtherUserLayout;
    }

    private void initSelfModel() {
        if (this.mSelfUserModel == null) {
            CallingUserModel callingUserModel = new CallingUserModel();
            this.mSelfUserModel = callingUserModel;
            callingUserModel.userId = TUILogin.getLoginUser();
            this.mSelfUserModel.userAvatar = TUILogin.getFaceUrl();
            this.mSelfUserModel.userName = TUILogin.getNickName();
        }
    }

    private void initSingleAcceptCallView() {
        if (TUICallDefine.MediaType.Audio.equals(TUICallingStatusManager.sharedInstance(this.mContext).getMediaType())) {
            initSingleAudioAcceptCallView();
        } else {
            initSingleVideoAcceptCallView();
        }
    }

    private void initSingleAudioAcceptCallView() {
        BaseCallView baseCallView = this.mBaseCallView;
        if (baseCallView != null) {
            baseCallView.finish();
            this.mBaseCallView = null;
        }
        this.mBaseCallView = new TUICallingImageView(this.mContext);
        this.mFunctionView = new TUICallingAudioFunctionView(this.mContext);
        this.mUserView = new TUICallingUserView(this.mContext);
        if (!TUICallDefine.Role.Caller.equals(TUICallingStatusManager.sharedInstance(this.mContext).getCallRole()) || this.mInviteeList.isEmpty()) {
            this.mUserView.updateUserInfo(this.mInviter);
        } else {
            this.mUserView.updateUserInfo(this.mInviteeList.get(0));
        }
        this.mBaseCallView.updateFunctionView(this.mFunctionView);
        this.mBaseCallView.updateUserView(this.mUserView);
        this.mBaseCallView.updateCallingHint("");
        updateViewColor();
        updateFunctionStatus();
        initFloatingWindowBtn();
        BaseCallActivity.updateBaseView(this.mBaseCallView);
    }

    private void initSingleAudioWaitingView() {
        String str;
        this.mBaseCallView = new TUICallingImageView(this.mContext);
        TUICallDefine.Role callRole = TUICallingStatusManager.sharedInstance(this.mContext).getCallRole();
        TUICallDefine.Role role = TUICallDefine.Role.Caller;
        if (role.equals(callRole)) {
            str = this.mContext.getString(R.string.tuicalling_waiting_accept);
            this.mFunctionView = new TUICallingAudioFunctionView(this.mContext);
        } else {
            str = this.mContext.getString(R.string.tuicalling_invite_audio_call);
            this.mFunctionView = new TUICallingWaitFunctionView(this.mContext);
        }
        this.mUserView = new TUICallingUserView(this.mContext);
        if (!role.equals(callRole) || this.mInviteeList.isEmpty()) {
            this.mUserView.updateUserInfo(this.mInviter);
        } else {
            this.mUserView.updateUserInfo(this.mInviteeList.get(0));
        }
        this.mBaseCallView.updateUserView(this.mUserView);
        this.mBaseCallView.updateCallingHint(str);
        this.mBaseCallView.updateFunctionView(this.mFunctionView);
        updateViewColor();
        initFloatingWindowBtn();
        BaseCallActivity.updateBaseView(this.mBaseCallView);
    }

    private void initSingleVideoAcceptCallView() {
        if (this.mBaseCallView == null) {
            TUICallingSingleView tUICallingSingleView = new TUICallingSingleView(this.mContext, this.mUserLayoutFactory);
            this.mBaseCallView = tUICallingSingleView;
            tUICallingSingleView.updateSwitchAudioView(new TUICallingSwitchAudioView(this.mContext));
        }
        TUICallingVideoFunctionView tUICallingVideoFunctionView = new TUICallingVideoFunctionView(this.mContext);
        this.mFunctionView = tUICallingVideoFunctionView;
        tUICallingVideoFunctionView.setLocalUserLayout(this.mUserLayoutFactory.findUserLayout(TUILogin.getLoginUser()));
        this.mBaseCallView.updateUserView((View) null);
        this.mBaseCallView.updateFunctionView(this.mFunctionView);
        updateViewColor();
        updateFunctionStatus();
        initFloatingWindowBtn();
        BaseCallActivity.updateBaseView(this.mBaseCallView);
    }

    private void initSingleVideoWaitingView() {
        String str;
        this.mUserLayoutFactory.allocUserLayout(this.mSelfUserModel);
        this.mBaseCallView = new TUICallingSingleView(this.mContext, this.mUserLayoutFactory);
        if (TUICallDefine.Role.Caller.equals(TUICallingStatusManager.sharedInstance(this.mContext).getCallRole())) {
            str = this.mContext.getString(R.string.tuicalling_waiting_accept);
            this.mFunctionView = new TUICallingVideoInviteFunctionView(this.mContext);
        } else {
            str = this.mContext.getString(R.string.tuicalling_invite_video_call);
            this.mFunctionView = new TUICallingWaitFunctionView(this.mContext);
        }
        TUICallingSingleVideoUserView tUICallingSingleVideoUserView = new TUICallingSingleVideoUserView(this.mContext, str);
        this.mUserView = tUICallingSingleVideoUserView;
        this.mBaseCallView.updateUserView(tUICallingSingleVideoUserView);
        this.mBaseCallView.updateSwitchAudioView(new TUICallingSwitchAudioView(this.mContext));
        this.mFunctionView.setLocalUserLayout(this.mUserLayoutFactory.findUserLayout(TUILogin.getLoginUser()));
        this.mBaseCallView.updateFunctionView(this.mFunctionView);
        updateViewColor();
        initFloatingWindowBtn();
        BaseCallActivity.updateBaseView(this.mBaseCallView);
    }

    private void initSingleWaitingView() {
        initSelfModel();
        initAudioPlayDevice();
        if (TUICallDefine.MediaType.Video.equals(TUICallingStatusManager.sharedInstance(this.mContext).getMediaType())) {
            initSingleVideoWaitingView();
        } else {
            initSingleAudioWaitingView();
        }
    }

    private void inviteUsersToGroupCall(List<String> list) {
        if (list == null || list.isEmpty()) {
            TUILog.e(TAG, "inviteUsersToGroupCall, userIdList is empty: " + list);
            return;
        }
        this.mCallingAction.inviteUser(list, new TUICommonDefine.ValueCallback() {
            public void onError(int i11, String str) {
            }

            public void onSuccess(Object obj) {
                if (obj instanceof List) {
                    List<String> list = (List) obj;
                    TUILog.i(TUICallingViewManager.TAG, "inviteUsersToGroupCall success, list:" + list);
                    for (String str : list) {
                        if (!TextUtils.isEmpty(str)) {
                            CallingUserModel callingUserModel = new CallingUserModel();
                            callingUserModel.userId = str;
                            TUICallingViewManager.this.addUser(callingUserModel);
                        }
                    }
                }
            }
        });
    }

    private void loadUserInfo(final CallingUserModel callingUserModel) {
        final UserLayout allocUserLayout = this.mUserLayoutFactory.allocUserLayout(callingUserModel);
        if (allocUserLayout != null) {
            this.mUserInfoUtils.getUserInfo(callingUserModel.userId, (UserInfoUtils.UserCallback) new UserInfoUtils.UserCallback() {
                public void onFailed(int i11, String str) {
                }

                public void onSuccess(List<CallingUserModel> list) {
                    CallingUserModel callingUserModel;
                    if (list != null && !list.isEmpty() && (callingUserModel = list.get(0)) != null && callingUserModel.userId.equals(callingUserModel.userId)) {
                        CallingUserModel callingUserModel2 = callingUserModel;
                        callingUserModel2.userAvatar = callingUserModel.userAvatar;
                        callingUserModel2.userName = callingUserModel.userName;
                    }
                    allocUserLayout.setUserName(callingUserModel.userName);
                    allocUserLayout.setVideoAvailable(callingUserModel.isVideoAvailable);
                    ImageLoader.loadImage(TUICallingViewManager.this.mContext, allocUserLayout.getAvatarImage(), callingUserModel.userAvatar, R.drawable.tuicalling_ic_avatar);
                }
            });
        }
    }

    private void registerCallingEvent() {
        TUICore.registerEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_CAMERA_OPEN, this);
        TUICore.registerEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_MIC_STATUS_CHANGED, this);
        TUICore.registerEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_CALL_STATUS_CHANGED, this);
        TUICore.registerEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_CALL_TYPE_CHANGED, this);
        TUICore.registerEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_GROUP_MEMBER_SELECTED, this);
    }

    private void reloadUserModel(CallingUserModel callingUserModel) {
        UserLayout findUserLayout;
        if (callingUserModel != null && !TextUtils.isEmpty(callingUserModel.userId) && (findUserLayout = this.mUserLayoutFactory.findUserLayout(callingUserModel.userId)) != null) {
            findUserLayout.setUserName(callingUserModel.userName);
            ImageLoader.loadImage(this.mContext, findUserLayout.getAvatarImage(), callingUserModel.userAvatar, R.drawable.tuicalling_ic_avatar);
        }
    }

    /* access modifiers changed from: private */
    public void resetVideoCloudView(CallingUserModel callingUserModel) {
        UserLayout findUserLayout = this.mUserLayoutFactory.findUserLayout(callingUserModel.userId);
        if (findUserLayout == null) {
            findUserLayout = this.mUserLayoutFactory.allocUserLayout(callingUserModel);
        }
        TUIVideoView videoView = findUserLayout.getVideoView();
        if (videoView != null) {
            if (videoView.getParent() != null) {
                ((ViewGroup) videoView.getParent()).removeView(videoView);
            }
            findUserLayout.addVideoView(videoView);
        }
    }

    /* access modifiers changed from: private */
    public void startFloatService() {
        if (!this.mEnableFloatView || this.mFloatCallView != null) {
            return;
        }
        if (PermissionUtils.hasPermission(this.mContext)) {
            this.mFloatCallView = createFloatView();
            updateFloatView(TUICallingStatusManager.sharedInstance(this.mContext).getCallStatus());
            FloatWindowService.startFloatService(this.mContext, this.mFloatCallView);
            BaseCallActivity.finishActivity();
            return;
        }
        PermissionRequest.requestFloatPermission(this.mContext);
    }

    private void updateCallStatus(TUICallDefine.Status status) {
        if (TUICallDefine.Status.None.equals(status)) {
            closeCallingView();
        } else if (TUICallDefine.Status.Accept.equals(status)) {
            if (this.mBaseCallView != null) {
                if (TUICallDefine.Scene.SINGLE_CALL.equals(TUICallingStatusManager.sharedInstance(this.mContext).getCallScene())) {
                    initSingleAcceptCallView();
                } else {
                    initGroupAcceptCallView();
                }
            }
            if (this.mFloatCallView != null) {
                updateFloatView(TUICallingStatusManager.sharedInstance(this.mContext).getCallStatus());
            }
        }
    }

    private void updateCallType(TUICallDefine.MediaType mediaType) {
        BaseCallView baseCallView;
        if (!TUICallDefine.MediaType.Unknown.equals(mediaType) && (baseCallView = this.mBaseCallView) != null) {
            baseCallView.finish();
            this.mBaseCallView = null;
            if (TUICallDefine.Status.Waiting.equals(TUICallingStatusManager.sharedInstance(this.mContext).getCallStatus())) {
                initSingleWaitingView();
            } else {
                initAudioPlayDevice();
                initSingleAcceptCallView();
            }
            if (this.mFloatCallView != null) {
                updateFloatView(TUICallingStatusManager.sharedInstance(this.mContext).getCallStatus());
            }
        }
    }

    private void updateFloatView(TUICallDefine.Status status) {
        String str;
        if (this.mFloatCallView != null) {
            TUICallDefine.MediaType mediaType = TUICallingStatusManager.sharedInstance(this.mContext).getMediaType();
            TUICallDefine.Scene callScene = TUICallingStatusManager.sharedInstance(this.mContext).getCallScene();
            if (!TUICallDefine.MediaType.Video.equals(mediaType) || !TUICallDefine.Scene.SINGLE_CALL.equals(callScene)) {
                this.mFloatCallView.enableCallingHint(TUICallDefine.Status.Waiting.equals(status));
                this.mFloatCallView.updateView(false, (String) null);
                return;
            }
            this.mFloatCallView.enableCallingHint(false);
            if (TUICallDefine.Status.Waiting.equals(status)) {
                str = TUILogin.getLoginUser();
            } else {
                str = (TUICallDefine.Role.Caller.equals(TUICallingStatusManager.sharedInstance(this.mContext).getCallRole()) ? this.mInviteeList.get(0) : this.mInviter).userId;
            }
            this.mFloatCallView.updateView(true, str);
        }
    }

    private void updateFunctionStatus() {
        TUICallingStatusManager sharedInstance = TUICallingStatusManager.sharedInstance(this.mContext);
        sharedInstance.updateCameraOpenStatus(sharedInstance.isCameraOpen(), sharedInstance.getFrontCamera());
        this.mCallingAction.selectAudioPlaybackDevice(sharedInstance.getAudioPlaybackDevice());
        if (sharedInstance.isMicMute()) {
            this.mCallingAction.closeMicrophone();
        } else {
            this.mCallingAction.openMicrophone((TUICommonDefine.Callback) null);
        }
    }

    private void updateViewColor() {
        int i11;
        int i12;
        TUICallDefine.MediaType mediaType = TUICallingStatusManager.sharedInstance(this.mContext).getMediaType();
        TUICallDefine.MediaType mediaType2 = TUICallDefine.MediaType.Video;
        if (mediaType2.equals(mediaType)) {
            i11 = this.mContext.getResources().getColor(R.color.tuicalling_color_video_background);
        } else {
            i11 = this.mContext.getResources().getColor(R.color.tuicalling_color_audio_background);
        }
        if (mediaType2.equals(mediaType)) {
            i12 = this.mContext.getResources().getColor(R.color.tuicalling_color_white);
        } else {
            i12 = this.mContext.getResources().getColor(R.color.tuicalling_color_black);
        }
        BaseCallView baseCallView = this.mBaseCallView;
        if (baseCallView != null) {
            baseCallView.updateBackgroundColor(i11);
            this.mBaseCallView.updateTextColor(i12);
        }
        BaseUserView baseUserView = this.mUserView;
        if (baseUserView != null) {
            baseUserView.updateTextColor(i12);
        }
        BaseFunctionView baseFunctionView = this.mFunctionView;
        if (baseFunctionView != null) {
            baseFunctionView.updateTextColor(i12);
        }
    }

    public void closeCallingView() {
        BaseCallView baseCallView = this.mBaseCallView;
        if (baseCallView != null) {
            baseCallView.finish();
        }
        this.mBaseCallView = null;
        BaseCallActivity.finishActivity();
        SelectGroupMemberActivity.finishActivity();
        this.mSelfUserModel = null;
        this.mInviteeList.clear();
        this.mInviter = new CallingUserModel();
        TUICallingStatusManager.sharedInstance(this.mContext).clear();
        this.mFunctionView = null;
        this.mFloatCallView = null;
        this.mUserView = null;
        this.mImageFloatFunction = null;
        this.mOtherUserLayout = null;
        HomeWatcher homeWatcher = this.mHomeWatcher;
        if (homeWatcher != null) {
            homeWatcher.stopWatch();
            this.mHomeWatcher = null;
        }
        FloatWindowService.stopService(this.mContext);
    }

    public void createCallingView(List<CallingUserModel> list, CallingUserModel callingUserModel) {
        this.mInviter = callingUserModel;
        this.mInviteeList = list;
        initHomeWatcher();
        TUILog.i(TAG, "createCallingView mInviter: " + this.mInviter + " ,mInviteeList: " + this.mInviteeList);
        if (TUICallDefine.Scene.SINGLE_CALL.equals(TUICallingStatusManager.sharedInstance(this.mContext).getCallScene())) {
            initSingleWaitingView();
        } else {
            initGroupWaitingView();
        }
    }

    public void createGroupCallingAcceptView() {
        initSelfModel();
        this.mUserLayoutFactory.allocUserLayout(this.mSelfUserModel);
        initGroupAcceptCallView();
    }

    public void enableFloatWindow(boolean z11) {
        this.mEnableFloatView = z11;
    }

    public void onNotifyEvent(String str, String str2, Map<String, Object> map) {
        if (map != null && Constants.EVENT_TUICALLING_CHANGED.equals(str)) {
            str2.hashCode();
            char c11 = 65535;
            switch (str2.hashCode()) {
                case -2042145547:
                    if (str2.equals(Constants.EVENT_SUB_CAMERA_OPEN)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -2029694834:
                    if (str2.equals(Constants.EVENT_SUB_GROUP_MEMBER_SELECTED)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 549704702:
                    if (str2.equals(Constants.EVENT_SUB_CALL_STATUS_CHANGED)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1836742849:
                    if (str2.equals(Constants.EVENT_SUB_MIC_STATUS_CHANGED)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 1999201532:
                    if (str2.equals(Constants.EVENT_SUB_CALL_TYPE_CHANGED)) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    CallingUserModel callingUserModel = this.mSelfUserModel;
                    if (callingUserModel != null) {
                        callingUserModel.isVideoAvailable = ((Boolean) map.get(Constants.OPEN_CAMERA)).booleanValue();
                        UserLayout findUserLayout = this.mUserLayoutFactory.findUserLayout(this.mSelfUserModel.userId);
                        if (findUserLayout != null) {
                            findUserLayout.setVideoAvailable(this.mSelfUserModel.isVideoAvailable);
                            if (TUICallDefine.Scene.SINGLE_CALL.equals(TUICallingStatusManager.sharedInstance(this.mContext).getCallScene())) {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(180, 180);
                                layoutParams.addRule(13);
                                ((RoundCornerImageView) findUserLayout.getAvatarImage()).setRadius(15);
                                findUserLayout.getAvatarImage().setLayoutParams(layoutParams);
                            }
                            ImageLoader.loadImage(this.mContext, findUserLayout.getAvatarImage(), (Object) this.mSelfUserModel.userAvatar);
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    inviteUsersToGroupCall((List) map.get(Constants.SELECT_MEMBER_LIST));
                    return;
                case 2:
                    updateCallStatus((TUICallDefine.Status) map.get(Constants.CALL_STATUS));
                    return;
                case 3:
                    CallingUserModel callingUserModel2 = this.mSelfUserModel;
                    if (callingUserModel2 != null) {
                        callingUserModel2.isAudioAvailable = ((Boolean) map.get(Constants.MUTE_MIC)).booleanValue();
                    }
                    UserLayout findUserLayout2 = this.mUserLayoutFactory.findUserLayout(TUILogin.getLoginUser());
                    if (findUserLayout2 != null) {
                        findUserLayout2.muteMic(this.mSelfUserModel.isAudioAvailable);
                        return;
                    }
                    return;
                case 4:
                    updateCallType((TUICallDefine.MediaType) map.get(Constants.CALL_MEDIA_TYPE));
                    return;
                default:
                    return;
            }
        }
    }

    public void showCallingView() {
        TUILog.i(TAG, "showCallingView: mBaseCallView: " + this.mBaseCallView);
        BaseCallActivity.updateBaseView(this.mBaseCallView);
        Intent intent = new Intent(this.mContext, BaseCallActivity.class);
        intent.setFlags(268435456);
        this.mContext.startActivity(intent);
    }

    public void updateCallingUserView(List<CallingUserModel> list, CallingUserModel callingUserModel) {
        this.mInviter = callingUserModel;
        this.mInviteeList = list;
        if (TUICallDefine.Role.Caller.equals(TUICallingStatusManager.sharedInstance(this.mContext).getCallRole())) {
            callingUserModel = list.get(0);
            for (CallingUserModel reloadUserModel : list) {
                reloadUserModel(reloadUserModel);
            }
        } else {
            reloadUserModel(callingUserModel);
        }
        BaseUserView baseUserView = this.mUserView;
        if (baseUserView != null) {
            baseUserView.updateUserInfo(callingUserModel);
        }
        initOtherInviteeView();
    }

    public void updateUser(CallingUserModel callingUserModel) {
        if (callingUserModel != null && !TextUtils.isEmpty(callingUserModel.userId)) {
            initSelfModel();
            CallingUserModel callingUserModel2 = this.mSelfUserModel;
            if (callingUserModel2 != null && callingUserModel.userId.equals(callingUserModel2.userId)) {
                CallingUserModel callingUserModel3 = this.mSelfUserModel;
                callingUserModel.isVideoAvailable = callingUserModel3.isVideoAvailable;
                callingUserModel.isAudioAvailable = callingUserModel3.isAudioAvailable;
            }
            BaseCallView baseCallView = this.mBaseCallView;
            if (baseCallView != null) {
                baseCallView.updateUserInfo(callingUserModel);
            }
            FloatCallView floatCallView = this.mFloatCallView;
            if (floatCallView != null) {
                CallingUserModel findCallingUserModel = findCallingUserModel(floatCallView.getCurrentUser());
                if (findCallingUserModel != null && callingUserModel.userId.equals(findCallingUserModel.userId)) {
                    updateFloatView(TUICallingStatusManager.sharedInstance(this.mContext).getCallStatus());
                    return;
                }
                return;
            }
            UserLayout findUserLayout = this.mUserLayoutFactory.findUserLayout(callingUserModel.userId);
            if (findUserLayout != null) {
                findUserLayout.setAudioVolume(callingUserModel.volume, callingUserModel.isAudioAvailable);
            }
        }
    }

    public void userCallingTimeStr(final String str) {
        if (this.mBaseCallView != null) {
            this.mMainHandler.post(new Runnable() {
                public void run() {
                    if (TUICallingViewManager.this.mFloatCallView != null) {
                        TUICallingViewManager.this.mFloatCallView.updateCallTimeView(str);
                    }
                    if (TUICallingViewManager.this.mBaseCallView != null) {
                        TUICallingViewManager.this.mBaseCallView.updateCallTimeView(str);
                    }
                }
            });
        }
    }

    public void userEnter(CallingUserModel callingUserModel) {
        if (callingUserModel != null && !TextUtils.isEmpty(callingUserModel.userId)) {
            callingUserModel.isEnter = true;
            if (!this.mInviteeList.contains(callingUserModel)) {
                this.mInviteeList.add(callingUserModel);
            }
            BaseCallView baseCallView = this.mBaseCallView;
            if (baseCallView != null) {
                baseCallView.userEnter(callingUserModel);
            }
            if (TextUtils.isEmpty(callingUserModel.userName) || TextUtils.isEmpty(callingUserModel.userAvatar)) {
                loadUserInfo(callingUserModel);
            }
        }
    }

    public void userLeave(CallingUserModel callingUserModel) {
        if (callingUserModel != null && !TextUtils.isEmpty(callingUserModel.userId)) {
            CallingUserModel callingUserModel2 = this.mInviter;
            if (callingUserModel2 != null && callingUserModel.userId.equals(callingUserModel2.userId)) {
                this.mInviter = new CallingUserModel();
            }
            this.mInviteeList.remove(callingUserModel);
            initOtherInviteeView();
            BaseCallView baseCallView = this.mBaseCallView;
            if (baseCallView != null) {
                baseCallView.userLeave(callingUserModel);
            }
        }
    }
}
