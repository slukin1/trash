package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.CaptureListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.ClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.ReturnListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.TypeListener;

public class CaptureLayout extends FrameLayout {
    /* access modifiers changed from: private */
    public TypeButton btn_cancel;
    private CaptureButton btn_capture;
    /* access modifiers changed from: private */
    public TypeButton btn_confirm;
    private ReturnButton btn_return;
    private int button_size;
    /* access modifiers changed from: private */
    public CaptureListener captureLisenter;
    private int iconLeft;
    private int iconRight;
    private boolean isFirst;
    private ImageView iv_custom_left;
    private ImageView iv_custom_right;
    private int layout_height;
    private int layout_width;
    /* access modifiers changed from: private */
    public ClickListener leftClickListener;
    private ReturnListener returnListener;
    /* access modifiers changed from: private */
    public ClickListener rightClickListener;
    private TextView txt_tip;
    /* access modifiers changed from: private */
    public TypeListener typeLisenter;

    public CaptureLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initView() {
        setWillNotDraw(false);
        this.btn_capture = new CaptureButton(getContext(), this.button_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.btn_capture.setLayoutParams(layoutParams);
        this.btn_capture.setCaptureLisenter(new CaptureListener() {
            public void recordEnd(long j11) {
                if (CaptureLayout.this.captureLisenter != null) {
                    CaptureLayout.this.captureLisenter.recordEnd(j11);
                }
                CaptureLayout.this.startAlphaAnimation();
                CaptureLayout.this.startTypeBtnAnimator();
            }

            public void recordError() {
                if (CaptureLayout.this.captureLisenter != null) {
                    CaptureLayout.this.captureLisenter.recordError();
                }
            }

            public void recordShort(long j11) {
                if (CaptureLayout.this.captureLisenter != null) {
                    CaptureLayout.this.captureLisenter.recordShort(j11);
                }
                CaptureLayout.this.startAlphaAnimation();
            }

            public void recordStart() {
                if (CaptureLayout.this.captureLisenter != null) {
                    CaptureLayout.this.captureLisenter.recordStart();
                }
                CaptureLayout.this.startAlphaAnimation();
            }

            public void recordZoom(float f11) {
                if (CaptureLayout.this.captureLisenter != null) {
                    CaptureLayout.this.captureLisenter.recordZoom(f11);
                }
            }

            public void takePictures() {
                if (CaptureLayout.this.captureLisenter != null) {
                    CaptureLayout.this.captureLisenter.takePictures();
                }
            }
        });
        this.btn_cancel = new TypeButton(getContext(), 1, this.button_size);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 16;
        layoutParams2.setMargins((this.layout_width / 4) - (this.button_size / 2), 0, 0, 0);
        this.btn_cancel.setLayoutParams(layoutParams2);
        this.btn_cancel.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (CaptureLayout.this.typeLisenter != null) {
                    CaptureLayout.this.typeLisenter.cancel();
                }
                CaptureLayout.this.startAlphaAnimation();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.btn_confirm = new TypeButton(getContext(), 2, this.button_size);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 21;
        layoutParams3.setMargins(0, 0, (this.layout_width / 4) - (this.button_size / 2), 0);
        this.btn_confirm.setLayoutParams(layoutParams3);
        this.btn_confirm.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (CaptureLayout.this.typeLisenter != null) {
                    CaptureLayout.this.typeLisenter.confirm();
                }
                CaptureLayout.this.startAlphaAnimation();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.btn_return = new ReturnButton(getContext(), (int) (((float) this.button_size) / 2.5f));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.setMargins(this.layout_width / 6, 0, 0, 0);
        this.btn_return.setLayoutParams(layoutParams4);
        this.btn_return.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (CaptureLayout.this.leftClickListener != null) {
                    CaptureLayout.this.leftClickListener.onClick();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.iv_custom_left = new ImageView(getContext());
        int i11 = this.button_size;
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams((int) (((float) i11) / 2.5f), (int) (((float) i11) / 2.5f));
        layoutParams5.gravity = 16;
        layoutParams5.setMargins(this.layout_width / 6, 0, 0, 0);
        this.iv_custom_left.setLayoutParams(layoutParams5);
        this.iv_custom_left.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (CaptureLayout.this.leftClickListener != null) {
                    CaptureLayout.this.leftClickListener.onClick();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.iv_custom_right = new ImageView(getContext());
        int i12 = this.button_size;
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams((int) (((float) i12) / 2.5f), (int) (((float) i12) / 2.5f));
        layoutParams6.gravity = 21;
        layoutParams6.setMargins(0, 0, this.layout_width / 6, 0);
        this.iv_custom_right.setLayoutParams(layoutParams6);
        this.iv_custom_right.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (CaptureLayout.this.rightClickListener != null) {
                    CaptureLayout.this.rightClickListener.onClick();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.txt_tip = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams7.gravity = 1;
        layoutParams7.setMargins(0, 0, 0, 0);
        this.txt_tip.setText(ServiceInitializer.getAppContext().getString(R.string.tap_tips));
        this.txt_tip.setTextColor(-1);
        this.txt_tip.setGravity(17);
        this.txt_tip.setLayoutParams(layoutParams7);
        addView(this.btn_capture);
        addView(this.btn_cancel);
        addView(this.btn_confirm);
        addView(this.btn_return);
        addView(this.iv_custom_left);
        addView(this.iv_custom_right);
        addView(this.txt_tip);
    }

    public void initEvent() {
        this.iv_custom_right.setVisibility(8);
        this.btn_cancel.setVisibility(8);
        this.btn_confirm.setVisibility(8);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        setMeasuredDimension(this.layout_width, this.layout_height);
    }

    public void resetCaptureLayout() {
        this.btn_capture.resetState();
        this.btn_cancel.setVisibility(8);
        this.btn_confirm.setVisibility(8);
        this.btn_capture.setVisibility(0);
        if (this.iconLeft != 0) {
            this.iv_custom_left.setVisibility(0);
        } else {
            this.btn_return.setVisibility(0);
        }
        if (this.iconRight != 0) {
            this.iv_custom_right.setVisibility(0);
        }
    }

    public void setButtonFeatures(int i11) {
        this.btn_capture.setButtonFeatures(i11);
    }

    public void setCaptureLisenter(CaptureListener captureListener) {
        this.captureLisenter = captureListener;
    }

    public void setDuration(int i11) {
        this.btn_capture.setDuration(i11);
    }

    public void setIconSrc(int i11, int i12) {
        this.iconLeft = i11;
        this.iconRight = i12;
        if (i11 != 0) {
            this.iv_custom_left.setImageResource(i11);
            this.iv_custom_left.setVisibility(0);
            this.btn_return.setVisibility(8);
        } else {
            this.iv_custom_left.setVisibility(8);
            this.btn_return.setVisibility(0);
        }
        if (this.iconRight != 0) {
            this.iv_custom_right.setImageResource(i12);
            this.iv_custom_right.setVisibility(0);
            return;
        }
        this.iv_custom_right.setVisibility(8);
    }

    public void setLeftClickListener(ClickListener clickListener) {
        this.leftClickListener = clickListener;
    }

    public void setReturnLisenter(ReturnListener returnListener2) {
        this.returnListener = returnListener2;
    }

    public void setRightClickListener(ClickListener clickListener) {
        this.rightClickListener = clickListener;
    }

    public void setTextWithAnimation(String str) {
        this.txt_tip.setText(str);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.txt_tip, "alpha", new float[]{0.0f, 1.0f, 1.0f, 0.0f});
        ofFloat.setDuration(2500);
        ofFloat.start();
    }

    public void setTip(String str) {
        this.txt_tip.setText(str);
    }

    public void setTypeLisenter(TypeListener typeListener) {
        this.typeLisenter = typeListener;
    }

    public void showTip() {
        this.txt_tip.setVisibility(0);
    }

    public void startAlphaAnimation() {
        if (this.isFirst) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.txt_tip, "alpha", new float[]{1.0f, 0.0f});
            ofFloat.setDuration(500);
            ofFloat.start();
            this.isFirst = false;
        }
    }

    public void startTypeBtnAnimator() {
        if (this.iconLeft != 0) {
            this.iv_custom_left.setVisibility(8);
        } else {
            this.btn_return.setVisibility(8);
        }
        if (this.iconRight != 0) {
            this.iv_custom_right.setVisibility(8);
        }
        this.btn_capture.setVisibility(8);
        this.btn_cancel.setVisibility(0);
        this.btn_confirm.setVisibility(0);
        this.btn_cancel.setClickable(false);
        this.btn_confirm.setClickable(false);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.btn_cancel, "translationX", new float[]{(float) (this.layout_width / 4), 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.btn_confirm, "translationX", new float[]{(float) ((-this.layout_width) / 4), 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CaptureLayout.this.btn_cancel.setClickable(true);
                CaptureLayout.this.btn_confirm.setClickable(true);
            }
        });
        animatorSet.setDuration(200);
        animatorSet.start();
    }

    public CaptureLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptureLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.iconLeft = 0;
        this.iconRight = 0;
        this.isFirst = true;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        if (getResources().getConfiguration().orientation == 1) {
            this.layout_width = displayMetrics.widthPixels;
        } else {
            this.layout_width = displayMetrics.widthPixels / 2;
        }
        int i12 = (int) (((float) this.layout_width) / 4.5f);
        this.button_size = i12;
        this.layout_height = i12 + ((i12 / 5) * 2) + 100;
        initView();
        initEvent();
    }
}
