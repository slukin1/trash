package com.tencent.qcloud.tuikit.tuibarrage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuibarrage.R;
import com.tencent.qcloud.tuikit.tuibarrage.manager.HbBarrageManager;
import com.tencent.qcloud.tuikit.tuibarrage.manager.IHbBarrageManager;
import com.tencent.qcloud.tuikit.tuibarrage.manager.TUIBarrageCallBack;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageMessage;
import com.tencent.qcloud.tuikit.tuibarrage.view.TUIBarrageSendView;

public class TUIBarrageButton extends FrameLayout implements ITUIBarrageButton {
    private static final String TAG = "TUIBarrageButton";
    /* access modifiers changed from: private */
    public ITUIBarrageListener mBarrageListener;
    private IHbBarrageManager mBarrageManager;
    private TUIBarrageSendView mBarrageSendView;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public TUIBarrageDisplayView mDisplayView;
    private String mGroupId;
    private TUIBarrageSendView.OnHideListener onSendHideListener;

    public TUIBarrageButton(Context context) {
        super(context);
    }

    private void initPresenter() {
        HbBarrageManager instance = HbBarrageManager.getInstance();
        this.mBarrageManager = instance;
        instance.init(this.mGroupId);
        this.mBarrageManager.addBarrageCallBack(new TUIBarrageCallBack() {
            public void onFailed(int i11, String str) {
            }
        });
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.tuibarrage_view_send, this);
        initSendView(this.mContext);
        this.mDisplayView = new TUIBarrageDisplayView(this.mContext, this.mGroupId);
        setBarrageListener(new ITUIBarrageListener() {
            public void onFailed(int i11, String str) {
                Log.d("TUIBarrageButton", "message is " + str);
                if (i11 == 10016) {
                    ToastUtil.toastLongMessage(TUIBarrageButton.this.getContext().getString(R.string.n_im_sensitive_word));
                } else if (i11 != 10017) {
                    ToastUtil.toastLongMessage(str);
                } else {
                    ToastUtil.toastLongMessage(TUIBarrageButton.this.getContext().getString(R.string.n_im_forbidden));
                }
            }

            public void onSuccess(int i11, TUIBarrageMessage tUIBarrageMessage) {
                if (tUIBarrageMessage == null) {
                    Log.d("TUIBarrageButton", "message is null");
                } else {
                    TUIBarrageButton.this.mDisplayView.receiveBarrage(tUIBarrageMessage);
                }
            }
        });
        findViewById(R.id.iv_linkto_send_dialog).setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUIBarrageButton tUIBarrageButton = TUIBarrageButton.this;
                tUIBarrageButton.showSendDialog(tUIBarrageButton.mContext);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    public TUIBarrageDisplayView getDisplayView() {
        return this.mDisplayView;
    }

    public void initSendView(Context context) {
        TUIBarrageSendView tUIBarrageSendView = new TUIBarrageSendView(context);
        this.mBarrageSendView = tUIBarrageSendView;
        tUIBarrageSendView.setOnTextSendListener(new TUIBarrageSendView.OnTextSendListener() {
            public void onTextSend(String str) {
                TUIBarrageButton.this.sendBarrage(str);
            }
        });
        TUIBarrageSendView.OnHideListener onHideListener = this.onSendHideListener;
        if (onHideListener != null) {
            this.mBarrageSendView.setListener(onHideListener);
        }
    }

    public void sendBarrage(String str) {
        if (this.mBarrageManager == null) {
            initPresenter();
        }
        this.mBarrageManager.sendTextBarrage(str, new TUIBarrageCallBack() {
            public void onFailed(int i11, String str) {
                if (TUIBarrageButton.this.mBarrageListener != null) {
                    TUIBarrageButton.this.mBarrageListener.onFailed(i11, str);
                }
            }

            public void onTextCallback(int i11, TUIBarrageMessage tUIBarrageMessage) {
                if (TUIBarrageButton.this.mBarrageListener != null) {
                    TUIBarrageButton.this.mBarrageListener.onSuccess(i11, tUIBarrageMessage);
                }
            }
        });
    }

    public void setBarrageListener(ITUIBarrageListener iTUIBarrageListener) {
        this.mBarrageListener = iTUIBarrageListener;
    }

    public void setSendHideListener(TUIBarrageSendView.OnHideListener onHideListener) {
        this.onSendHideListener = onHideListener;
        this.mBarrageSendView.setListener(onHideListener);
    }

    public void showSendDialog(Context context) {
        if (this.mContext != context) {
            this.mContext = context;
            initSendView(context);
        }
        if (!this.mBarrageSendView.isShowing()) {
            Context context2 = this.mContext;
            if (!(context2 instanceof Activity) || !((Activity) context2).isFinishing()) {
                Window window = this.mBarrageSendView.getWindow();
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                window.setAttributes(attributes);
                this.mBarrageSendView.getWindow().setSoftInputMode(4);
                this.mBarrageSendView.show();
                this.mBarrageSendView.focus();
            }
        }
    }

    public TUIBarrageButton(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public TUIBarrageButton(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }

    public TUIBarrageButton(Context context, String str) {
        this(context);
        this.mContext = context;
        this.mGroupId = str;
        initView();
        initPresenter();
    }
}
