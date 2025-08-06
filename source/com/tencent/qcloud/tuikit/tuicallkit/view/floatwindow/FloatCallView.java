package com.tencent.qcloud.tuikit.tuicallkit.view.floatwindow;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.TUIVideoView;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.base.CallingUserModel;
import com.tencent.qcloud.tuikit.tuicallkit.base.UserLayout;
import com.tencent.qcloud.tuikit.tuicallkit.base.UserLayoutEntity;
import com.tencent.qcloud.tuikit.tuicallkit.utils.ImageLoader;
import com.tencent.qcloud.tuikit.tuicallkit.view.UserLayoutFactory;
import java.util.Iterator;
import java.util.Objects;

public class FloatCallView extends RelativeLayout {
    private static final int MESSAGE_LAYOUT_EMPTY = 1;
    private static final int MESSAGE_VIEW_EMPTY = 2;
    private static final int UPDATE_COUNT = 3;
    private static final int UPDATE_INTERVAL = 300;
    private final Context mContext;
    /* access modifiers changed from: private */
    public int mCount = 0;
    /* access modifiers changed from: private */
    public String mCurrentUser;
    private ImageView mImageAudio;
    private ImageView mImageFloatAvatar;
    private boolean mIsVideoAvailable;
    private RelativeLayout mLayoutVideoView;
    /* access modifiers changed from: private */
    public OnClickListener mOnClickListener;
    private TextView mTextHint;
    private TextView mTextTime;
    /* access modifiers changed from: private */
    public UserLayoutFactory mUserLayoutFactory;
    /* access modifiers changed from: private */
    public UserLayout mVideoLayout;
    private final Handler mViewHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1 && FloatCallView.this.mVideoLayout == null && FloatCallView.this.mCount <= 3) {
                FloatCallView floatCallView = FloatCallView.this;
                UserLayout unused = floatCallView.mVideoLayout = floatCallView.mUserLayoutFactory.findUserLayout(FloatCallView.this.mCurrentUser);
                sendEmptyMessageDelayed(1, 300);
                FloatCallView.access$208(FloatCallView.this);
            } else if (message.what != 2 || FloatCallView.this.mCount >= 3) {
                FloatCallView.this.reloadVideoView();
                int unused2 = FloatCallView.this.mCount = 0;
            } else {
                sendEmptyMessageDelayed(2, 300);
                FloatCallView.access$208(FloatCallView.this);
            }
        }
    };

    public interface OnClickListener {
        void onClick();
    }

    public FloatCallView(Context context, UserLayoutFactory userLayoutFactory) {
        super(context);
        this.mContext = context;
        this.mUserLayoutFactory = userLayoutFactory;
        initView(context);
    }

    public static /* synthetic */ int access$208(FloatCallView floatCallView) {
        int i11 = floatCallView.mCount;
        floatCallView.mCount = i11 + 1;
        return i11;
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tuicalling_floatwindow_layout, this);
        this.mLayoutVideoView = (RelativeLayout) findViewById(R.id.rl_video_view);
        this.mImageFloatAvatar = (ImageView) findViewById(R.id.img_float_avatar);
        this.mTextHint = (TextView) findViewById(R.id.tv_float_hint);
        this.mImageAudio = (ImageView) findViewById(R.id.float_audioView);
        this.mTextTime = (TextView) findViewById(R.id.tv_float_time);
        setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (FloatCallView.this.mOnClickListener != null) {
                    FloatCallView.this.mOnClickListener.onClick();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public void reloadVideoView() {
        UserLayout userLayout = this.mVideoLayout;
        if (userLayout != null) {
            TUIVideoView videoView = userLayout.getVideoView();
            if (videoView == null) {
                this.mViewHandler.sendEmptyMessageDelayed(2, 300);
                return;
            }
            if (videoView.getParent() != null) {
                ((ViewGroup) videoView.getParent()).removeView(videoView);
            }
            this.mLayoutVideoView.removeAllViews();
            this.mLayoutVideoView.setVisibility(0);
            this.mLayoutVideoView.addView(videoView);
        }
    }

    public void enableCallingHint(boolean z11) {
        this.mTextHint.setVisibility(z11 ? 0 : 8);
    }

    public String getCurrentUser() {
        return this.mCurrentUser;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void updateCallTimeView(String str) {
        if (this.mIsVideoAvailable) {
            this.mTextTime.setVisibility(8);
            return;
        }
        this.mTextTime.setText(str);
        this.mTextTime.setVisibility(TextUtils.isEmpty(str) ? 4 : 0);
    }

    public void updateView(boolean z11, String str) {
        this.mIsVideoAvailable = z11;
        if (!z11) {
            this.mLayoutVideoView.setVisibility(8);
            this.mImageFloatAvatar.setVisibility(8);
            this.mImageAudio.setVisibility(0);
        } else if (this.mUserLayoutFactory != null && !TextUtils.isEmpty(str)) {
            this.mCurrentUser = str;
            this.mImageAudio.setVisibility(8);
            CallingUserModel callingUserModel = new CallingUserModel();
            Iterator it2 = this.mUserLayoutFactory.mLayoutEntityList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    UserLayoutEntity userLayoutEntity = (UserLayoutEntity) it2.next();
                    if (userLayoutEntity != null && Objects.equals(userLayoutEntity.userId, str)) {
                        callingUserModel = userLayoutEntity.userModel;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (callingUserModel == null || callingUserModel.isVideoAvailable) {
                this.mImageFloatAvatar.setVisibility(8);
                UserLayout findUserLayout = this.mUserLayoutFactory.findUserLayout(str);
                this.mVideoLayout = findUserLayout;
                if (findUserLayout == null) {
                    this.mViewHandler.sendEmptyMessageDelayed(1, 300);
                } else {
                    reloadVideoView();
                }
            } else {
                this.mLayoutVideoView.removeAllViews();
                this.mLayoutVideoView.setVisibility(8);
                this.mImageFloatAvatar.setVisibility(0);
                ImageLoader.loadImage(this.mContext, this.mImageFloatAvatar, callingUserModel.userAvatar, R.drawable.tuicalling_ic_avatar);
            }
        }
    }
}
