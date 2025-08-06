package com.tencent.qcloud.tuikit.tuibarrage.view;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.tuibarrage.R;
import java.lang.ref.WeakReference;

public class TUIBarrageSendView extends Dialog {
    private static final String TAG = "TUIBarrageSendView";
    private WeakReference<OnHideListener> listener;
    private Button mBtnSend;
    private Context mContext;
    /* access modifiers changed from: private */
    public EditText mEditText;
    /* access modifiers changed from: private */
    public final InputMethodManager mInputMethodManager;
    private View mLayoutInputView;
    private View mLayoutOutSide;
    /* access modifiers changed from: private */
    public OnTextSendListener mOnTextSendListener;

    public interface OnHideListener {
        void onHide(String str);
    }

    public interface OnTextSendListener {
        void onTextSend(String str);
    }

    public TUIBarrageSendView(Context context) {
        super(context, R.style.TUIBarrageInputDialog);
        setContentView(R.layout.tuibarrage_dialog_send);
        this.mContext = context;
        this.mInputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        initView();
        initListener();
    }

    private void initListener() {
        this.mBtnSend.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                String trim = TUIBarrageSendView.this.mEditText.getText().toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    TUIBarrageSendView.this.mOnTextSendListener.onTextSend(trim);
                    TUIBarrageSendView.this.mInputMethodManager.showSoftInput(TUIBarrageSendView.this.mEditText, 2);
                    TUIBarrageSendView.this.mInputMethodManager.hideSoftInputFromWindow(TUIBarrageSendView.this.mEditText.getWindowToken(), 0);
                    TUIBarrageSendView.this.mEditText.setText("");
                    TUIBarrageSendView.this.dismiss();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                if (i11 != 4) {
                    return false;
                }
                String trim = TUIBarrageSendView.this.mEditText.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    return true;
                }
                TUIBarrageSendView.this.mOnTextSendListener.onTextSend(trim);
                TUIBarrageSendView.this.mInputMethodManager.showSoftInput(TUIBarrageSendView.this.mEditText, 2);
                TUIBarrageSendView.this.mInputMethodManager.hideSoftInputFromWindow(TUIBarrageSendView.this.mEditText.getWindowToken(), 0);
                TUIBarrageSendView.this.mEditText.setText("");
                TUIBarrageSendView.this.dismiss();
                return true;
            }
        });
        this.mLayoutOutSide.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                if (view.getId() != R.id.ll_input_view) {
                    TUIBarrageSendView.this.dismiss();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mLayoutInputView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                TUIBarrageSendView.this.mInputMethodManager.hideSoftInputFromWindow(TUIBarrageSendView.this.mEditText.getWindowToken(), 0);
                TUIBarrageSendView.this.dismiss();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    private void initView() {
        this.mEditText = (EditText) findViewById(R.id.et_input_message);
        this.mBtnSend = (Button) findViewById(R.id.btn_send);
        this.mLayoutOutSide = findViewById(R.id.ll_outside_view);
        this.mLayoutInputView = findViewById(R.id.ll_input_view);
    }

    public void focus() {
        this.mEditText.requestFocus();
        this.mInputMethodManager.showSoftInput(this.mEditText, 2);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference<OnHideListener> weakReference = this.listener;
        if (weakReference != null && weakReference.get() != null) {
            String obj = this.mEditText.getText().toString();
            if (obj == null) {
                obj = "";
            }
            ((OnHideListener) this.listener.get()).onHide(obj);
        }
    }

    public void setListener(OnHideListener onHideListener) {
        this.listener = new WeakReference<>(onHideListener);
    }

    public void setOnTextSendListener(OnTextSendListener onTextSendListener) {
        this.mOnTextSendListener = onTextSendListener;
    }
}
