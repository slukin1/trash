package com.tencent.qcloud.tuikit.tuicallkit.view.floatwindow;

import android.animation.ValueAnimator;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.qcloud.tuikit.tuicallkit.R;

public class FloatWindowService extends Service {
    /* access modifiers changed from: private */
    public static FloatCallView mCallView;
    private static Context mContext;
    private static Intent mStartIntent;
    /* access modifiers changed from: private */
    public boolean mIsMove;
    /* access modifiers changed from: private */
    public int mScreenWidth;
    /* access modifiers changed from: private */
    public int mStartX;
    /* access modifiers changed from: private */
    public int mStartY;
    /* access modifiers changed from: private */
    public int mStopX;
    /* access modifiers changed from: private */
    public int mStopY;
    /* access modifiers changed from: private */
    public int mTouchCurrentX;
    /* access modifiers changed from: private */
    public int mTouchCurrentY;
    /* access modifiers changed from: private */
    public int mTouchStartX;
    /* access modifiers changed from: private */
    public int mTouchStartY;
    /* access modifiers changed from: private */
    public int mWidth;
    /* access modifiers changed from: private */
    public WindowManager.LayoutParams mWindowLayoutParams;
    /* access modifiers changed from: private */
    public WindowManager mWindowManager;

    public class FloatBinder extends Binder {
        public FloatBinder() {
        }

        public FloatWindowService getService() {
            return FloatWindowService.this;
        }
    }

    public class FloatingListener implements View.OnTouchListener {
        private FloatingListener() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                boolean unused = FloatWindowService.this.mIsMove = false;
                int unused2 = FloatWindowService.this.mTouchStartX = (int) motionEvent.getRawX();
                int unused3 = FloatWindowService.this.mTouchStartY = (int) motionEvent.getRawY();
                int unused4 = FloatWindowService.this.mStartX = (int) motionEvent.getRawX();
                int unused5 = FloatWindowService.this.mStartY = (int) motionEvent.getRawY();
            } else if (action == 1) {
                int unused6 = FloatWindowService.this.mStopX = (int) motionEvent.getRawX();
                int unused7 = FloatWindowService.this.mStopY = (int) motionEvent.getRawY();
                if (Math.abs(FloatWindowService.this.mStartX - FloatWindowService.this.mStopX) >= 5 || Math.abs(FloatWindowService.this.mStartY - FloatWindowService.this.mStopY) >= 5) {
                    boolean unused8 = FloatWindowService.this.mIsMove = true;
                    if (FloatWindowService.mCallView != null) {
                        int unused9 = FloatWindowService.this.mWidth = FloatWindowService.mCallView.getWidth();
                        if (FloatWindowService.this.mTouchCurrentX > FloatWindowService.this.mScreenWidth / 2) {
                            FloatWindowService floatWindowService = FloatWindowService.this;
                            floatWindowService.startScroll(floatWindowService.mStopX, FloatWindowService.this.mScreenWidth - FloatWindowService.this.mWidth, false);
                        } else {
                            FloatWindowService floatWindowService2 = FloatWindowService.this;
                            floatWindowService2.startScroll(floatWindowService2.mStopX, 0, true);
                        }
                    }
                }
            } else if (action == 2) {
                int unused10 = FloatWindowService.this.mTouchCurrentX = (int) motionEvent.getRawX();
                int unused11 = FloatWindowService.this.mTouchCurrentY = (int) motionEvent.getRawY();
                if (!(FloatWindowService.this.mWindowLayoutParams == null || FloatWindowService.mCallView == null)) {
                    FloatWindowService.this.mWindowLayoutParams.x += FloatWindowService.this.mTouchCurrentX - FloatWindowService.this.mTouchStartX;
                    FloatWindowService.this.mWindowLayoutParams.y += FloatWindowService.this.mTouchCurrentY - FloatWindowService.this.mTouchStartY;
                    FloatWindowService.this.mWindowManager.updateViewLayout(FloatWindowService.mCallView, FloatWindowService.this.mWindowLayoutParams);
                }
                FloatWindowService floatWindowService3 = FloatWindowService.this;
                int unused12 = floatWindowService3.mTouchStartX = floatWindowService3.mTouchCurrentX;
                FloatWindowService floatWindowService4 = FloatWindowService.this;
                int unused13 = floatWindowService4.mTouchStartY = floatWindowService4.mTouchCurrentY;
            }
            return FloatWindowService.this.mIsMove;
        }
    }

    /* access modifiers changed from: private */
    public void calculateHeight() {
        if (this.mWindowLayoutParams != null) {
            int height = mCallView.getHeight();
            int height2 = this.mWindowManager.getDefaultDisplay().getHeight();
            int dimensionPixelSize = mContext.getResources().getDimensionPixelSize(mContext.getResources().getIdentifier("status_bar_height", "dimen", "android"));
            WindowManager.LayoutParams layoutParams = this.mWindowLayoutParams;
            int i11 = layoutParams.y;
            if (i11 < 0) {
                layoutParams.y = 0;
                return;
            }
            int i12 = (height2 - height) - dimensionPixelSize;
            if (i11 > i12) {
                layoutParams.y = i12;
            }
        }
    }

    private WindowManager.LayoutParams getViewParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.mWindowLayoutParams = layoutParams;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
        layoutParams.flags = 552;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = this.mWindowManager.getDefaultDisplay().getHeight() / 2;
        WindowManager.LayoutParams layoutParams2 = this.mWindowLayoutParams;
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.format = -2;
        return layoutParams2;
    }

    private void initWindow() {
        this.mWindowManager = (WindowManager) getApplicationContext().getSystemService("window");
        this.mWindowLayoutParams = getViewParams();
        this.mScreenWidth = this.mWindowManager.getDefaultDisplay().getWidth();
        FloatCallView floatCallView = mCallView;
        if (floatCallView != null) {
            floatCallView.setBackgroundResource(R.drawable.tuicalling_bg_floatwindow_left);
            this.mWindowManager.addView(mCallView, this.mWindowLayoutParams);
            mCallView.setOnTouchListener(new FloatingListener());
        }
    }

    public static void startFloatService(Context context, FloatCallView floatCallView) {
        mContext = context;
        mCallView = floatCallView;
        Intent intent = new Intent(context, FloatWindowService.class);
        mStartIntent = intent;
        context.startService(intent);
    }

    /* access modifiers changed from: private */
    public void startScroll(final int i11, int i12, final boolean z11) {
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{(float) i11, (float) i12}).setDuration(300);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (FloatWindowService.this.mWindowLayoutParams != null && FloatWindowService.mCallView != null) {
                    int unused = FloatWindowService.this.mWidth = FloatWindowService.mCallView.getWidth();
                    if (z11) {
                        FloatWindowService.this.mWindowLayoutParams.x = (int) (((float) i11) * (1.0f - valueAnimator.getAnimatedFraction()));
                        FloatWindowService.mCallView.setBackgroundResource(R.drawable.tuicalling_bg_floatwindow_left);
                    } else {
                        float access$1400 = ((float) ((FloatWindowService.this.mScreenWidth - i11) - FloatWindowService.this.mWidth)) * valueAnimator.getAnimatedFraction();
                        FloatWindowService.this.mWindowLayoutParams.x = (int) (((float) i11) + access$1400);
                        FloatWindowService.mCallView.setBackgroundResource(R.drawable.tuicalling_bg_floatwindow_right);
                    }
                    FloatWindowService.this.calculateHeight();
                    FloatWindowService.this.mWindowManager.updateViewLayout(FloatWindowService.mCallView, FloatWindowService.this.mWindowLayoutParams);
                }
            }
        });
        duration.start();
    }

    public static void stopService(Context context) {
        Intent intent = mStartIntent;
        if (intent != null) {
            context.stopService(intent);
        }
    }

    public IBinder onBind(Intent intent) {
        return new FloatBinder();
    }

    public void onCreate() {
        super.onCreate();
        initWindow();
    }

    public void onDestroy() {
        super.onDestroy();
        FloatCallView floatCallView = mCallView;
        if (floatCallView != null) {
            this.mWindowManager.removeView(floatCallView);
            mCallView = null;
        }
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        return super.onStartCommand(intent, i11, i12);
    }
}
