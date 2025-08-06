package com.tencent.qcloud.tuikit.tuicallkit.view.root;

import android.content.Context;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.base.CallingUserModel;
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingStatusManager;
import com.tencent.qcloud.tuikit.tuicallkit.base.UserLayout;
import com.tencent.qcloud.tuikit.tuicallkit.base.UserLayoutEntity;
import com.tencent.qcloud.tuikit.tuicallkit.utils.DisplayUtils;
import com.tencent.qcloud.tuikit.tuicallkit.utils.ImageLoader;
import com.tencent.qcloud.tuikit.tuicallkit.view.UserLayoutFactory;
import com.tencent.qcloud.tuikit.tuicallkit.view.common.RoundCornerImageView;
import java.util.ArrayList;
import java.util.Iterator;

public class TUICallingSingleView extends BaseCallView {
    private Context mContext;
    private int mCount = 0;
    private ArrayList<RelativeLayout.LayoutParams> mFloatParamList;
    private RelativeLayout mLayoutFloatView;
    private RelativeLayout mLayoutFunction;
    private RelativeLayout mLayoutSwitchAudio;
    private RelativeLayout mLayoutUserContainer;
    private RelativeLayout mLayoutUserWaitView;
    private TextView mTextTime;
    private UserLayoutFactory mUserLayoutFactory;

    public TUICallingSingleView(Context context, UserLayoutFactory userLayoutFactory) {
        super(context);
        this.mContext = context.getApplicationContext();
        this.mUserLayoutFactory = userLayoutFactory;
        initView();
    }

    private void addFloatViewClickListener(UserLayoutEntity userLayoutEntity) {
        final String str = userLayoutEntity.userId;
        userLayoutEntity.layout.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (!TextUtils.isEmpty(str)) {
                    TUICallingSingleView.this.makeFullVideoView(str);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private UserLayout allocUserLayout(CallingUserModel callingUserModel) {
        if (callingUserModel == null || TextUtils.isEmpty(callingUserModel.userId)) {
            return null;
        }
        UserLayout allocUserLayout = this.mUserLayoutFactory.allocUserLayout(callingUserModel);
        if (allocUserLayout.getParent() != null) {
            ((ViewGroup) allocUserLayout.getParent()).removeView(allocUserLayout);
        }
        initGestureListener(allocUserLayout);
        allocUserLayout.setVisibility(0);
        allocUserLayout.disableAudioImage(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(180, 180);
        layoutParams.addRule(13);
        ((RoundCornerImageView) allocUserLayout.getAvatarImage()).setRadius(15);
        allocUserLayout.getAvatarImage().setLayoutParams(layoutParams);
        this.mLayoutUserContainer.addView(allocUserLayout);
        this.mCount++;
        post(new Runnable() {
            public void run() {
                TUICallingSingleView.this.makeFloatLayout();
            }
        });
        return allocUserLayout;
    }

    private UserLayoutEntity findEntity(String str) {
        Iterator it2 = this.mUserLayoutFactory.mLayoutEntityList.iterator();
        while (it2.hasNext()) {
            UserLayoutEntity userLayoutEntity = (UserLayoutEntity) it2.next();
            if (userLayoutEntity.userId.equals(str)) {
                return userLayoutEntity;
            }
        }
        return null;
    }

    private UserLayout findUserLayout(String str) {
        UserLayoutFactory userLayoutFactory;
        if (!TextUtils.isEmpty(str) && (userLayoutFactory = this.mUserLayoutFactory) != null) {
            return userLayoutFactory.findUserLayout(str);
        }
        return null;
    }

    private void initData() {
        UserLayout allocUserLayout;
        Iterator it2 = this.mUserLayoutFactory.mLayoutEntityList.iterator();
        while (it2.hasNext()) {
            UserLayoutEntity userLayoutEntity = (UserLayoutEntity) it2.next();
            if (userLayoutEntity != null && !TextUtils.isEmpty(userLayoutEntity.userId) && userLayoutEntity.userId.equals(TUILogin.getLoginUser()) && (allocUserLayout = allocUserLayout(userLayoutEntity.userModel)) != null) {
                allocUserLayout.setVideoAvailable(true);
                if (!TUICallingStatusManager.sharedInstance(this.mContext).isCameraOpen()) {
                    this.mCallingAction.openCamera(TUICallingStatusManager.sharedInstance(this.mContext).getFrontCamera(), allocUserLayout.getVideoView(), (TUICommonDefine.Callback) null);
                }
            }
        }
    }

    private void initGestureListener(final UserLayout userLayout) {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
                if (!userLayout.isMoveAble()) {
                    return false;
                }
                if (!(userLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                    return true;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) userLayout.getLayoutParams();
                int x11 = (int) (((float) layoutParams.leftMargin) + (motionEvent2.getX() - motionEvent.getX()));
                int y11 = (int) (((float) layoutParams.topMargin) + (motionEvent2.getY() - motionEvent.getY()));
                if (x11 < 0 || x11 > TUICallingSingleView.this.getWidth() - userLayout.getWidth() || y11 < 0 || y11 > TUICallingSingleView.this.getHeight() - userLayout.getHeight()) {
                    return true;
                }
                layoutParams.leftMargin = x11;
                layoutParams.topMargin = y11;
                userLayout.setLayoutParams(layoutParams);
                return true;
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                userLayout.performClick();
                return false;
            }
        });
        userLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    /* access modifiers changed from: private */
    public void makeFloatLayout() {
        ArrayList<RelativeLayout.LayoutParams> arrayList = this.mFloatParamList;
        if (arrayList == null || arrayList.size() == 0) {
            this.mFloatParamList = DisplayUtils.initFloatParamList(getContext(), getWidth(), getHeight());
        }
        int size = this.mUserLayoutFactory.mLayoutEntityList.size();
        for (int i11 = 0; i11 < size; i11++) {
            boolean z11 = true;
            UserLayoutEntity userLayoutEntity = this.mUserLayoutFactory.mLayoutEntityList.get((size - i11) - 1);
            userLayoutEntity.layout.setLayoutParams(this.mFloatParamList.get(i11));
            UserLayout userLayout = userLayoutEntity.layout;
            if (i11 == 0) {
                z11 = false;
            }
            userLayout.setMoveAble(z11);
            addFloatViewClickListener(userLayoutEntity);
            userLayoutEntity.layout.bringToFront();
        }
    }

    /* access modifiers changed from: private */
    public void makeFullVideoView(String str) {
        UserLayoutEntity findEntity = findEntity(str);
        this.mUserLayoutFactory.mLayoutEntityList.remove(findEntity);
        this.mUserLayoutFactory.mLayoutEntityList.addLast(findEntity);
        makeFloatLayout();
    }

    private void recyclerAllUserLayout() {
        UserLayoutFactory userLayoutFactory = this.mUserLayoutFactory;
        if (userLayoutFactory != null && this.mLayoutUserContainer != null) {
            Iterator it2 = userLayoutFactory.mLayoutEntityList.iterator();
            while (it2.hasNext()) {
                this.mLayoutUserContainer.removeView(((UserLayoutEntity) it2.next()).layout);
                it2.remove();
            }
            this.mCount = 0;
        }
    }

    public void enableFloatView(View view) {
        this.mLayoutFloatView.removeAllViews();
        if (view != null) {
            this.mLayoutFloatView.addView(view);
        }
    }

    public void finish() {
        recyclerAllUserLayout();
        super.finish();
    }

    public void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tuicalling_background_single_view, this);
        this.mLayoutUserContainer = (RelativeLayout) findViewById(R.id.rl_video_container);
        this.mLayoutFloatView = (RelativeLayout) findViewById(R.id.rl_float_view);
        this.mLayoutUserWaitView = (RelativeLayout) findViewById(R.id.rl_single_video_user);
        this.mLayoutSwitchAudio = (RelativeLayout) findViewById(R.id.rl_switch_audio);
        this.mTextTime = (TextView) findViewById(R.id.tv_single_time);
        this.mLayoutFunction = (RelativeLayout) findViewById(R.id.rl_single_function);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        initData();
    }

    public void updateCallTimeView(String str) {
        this.mTextTime.setText(str);
        this.mTextTime.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    public void updateFunctionView(View view) {
        this.mLayoutFunction.removeAllViews();
        if (view != null) {
            this.mLayoutFunction.addView(view);
        }
    }

    public void updateSwitchAudioView(View view) {
        this.mLayoutSwitchAudio.removeAllViews();
        if (view != null) {
            this.mLayoutSwitchAudio.addView(view);
        }
    }

    public void updateTextColor(int i11) {
        super.updateTextColor(i11);
        this.mTextTime.setTextColor(i11);
    }

    public void updateUserInfo(CallingUserModel callingUserModel) {
        super.updateUserInfo(callingUserModel);
        UserLayout findUserLayout = findUserLayout(callingUserModel.userId);
        if (findUserLayout != null) {
            findUserLayout.setVideoAvailable(callingUserModel.isVideoAvailable);
            ImageLoader.loadImage(this.mContext, findUserLayout.getAvatarImage(), callingUserModel.userAvatar, R.drawable.tuicalling_ic_avatar);
        }
    }

    public void updateUserView(View view) {
        super.updateUserView(view);
        this.mLayoutUserWaitView.removeAllViews();
        if (view != null) {
            this.mLayoutUserWaitView.addView(view);
        }
    }

    public void userEnter(CallingUserModel callingUserModel) {
        super.userEnter(callingUserModel);
        UserLayout findUserLayout = findUserLayout(callingUserModel.userId);
        if (findUserLayout == null) {
            findUserLayout = allocUserLayout(callingUserModel);
        }
        findUserLayout.setVideoAvailable(callingUserModel.isVideoAvailable);
        this.mCallingAction.startRemoteView(callingUserModel.userId, findUserLayout.getVideoView(), (TUICommonDefine.PlayCallback) null);
    }
}
