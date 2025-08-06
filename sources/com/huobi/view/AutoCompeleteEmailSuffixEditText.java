package com.huobi.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;

public class AutoCompeleteEmailSuffixEditText extends AppCompatEditText {
    private String[] emailSufixs = {"@163.com", "@126.com", "@139.com", "@qq.com", "@sina.com", "@sohu.com", "@gmail.com", "@foxmail.com", "@vip.qq.com", "@huobi.com", "@hotmail.com"};
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (AutoCompeleteEmailSuffixEditText.this.getSelectionStart() > AutoCompeleteEmailSuffixEditText.this.textLength) {
                AutoCompeleteEmailSuffixEditText autoCompeleteEmailSuffixEditText = AutoCompeleteEmailSuffixEditText.this;
                autoCompeleteEmailSuffixEditText.setSelection(autoCompeleteEmailSuffixEditText.textLength);
            }
        }
    };
    private String lastAutoText = "";
    private String lastText = "";
    private String mString;
    private String suffixString;
    /* access modifiers changed from: private */
    public int textLength = 0;

    public AutoCompeleteEmailSuffixEditText(Context context) {
        super(context);
    }

    public void onFocusChanged(boolean z11, int i11, Rect rect) {
        if (!z11) {
            setText(Html.fromHtml("<font color=\"#ffffff\">" + this.lastText + "</font>"));
        }
        super.onFocusChanged(z11, i11, rect);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        super.onTextChanged(charSequence, i11, i12, i13);
        if (charSequence.length() == 0) {
            this.mString = "";
        }
        int i14 = 0;
        if (charSequence.toString().contains(TIMMentionEditText.TIM_MENTION_TAG) && !this.lastText.equals(getText().toString())) {
            this.suffixString = "";
            if (charSequence.toString().contains(this.lastAutoText) && !TextUtils.isEmpty(this.lastAutoText)) {
                charSequence = charSequence.subSequence(0, charSequence.toString().lastIndexOf(this.lastAutoText));
            }
            this.mString = "<font color=\"#ffffff\">" + charSequence.toString() + "</font>";
            String substring = charSequence.toString().substring(charSequence.toString().indexOf(TIMMentionEditText.TIM_MENTION_TAG));
            while (true) {
                String[] strArr = this.emailSufixs;
                if (i14 >= strArr.length) {
                    break;
                } else if (strArr[i14].startsWith(substring)) {
                    this.lastAutoText = this.emailSufixs[i14].substring(substring.length());
                    this.suffixString = "<font color=\"#b1b1b1\">" + this.lastAutoText + "</font>";
                    break;
                } else {
                    i14++;
                }
            }
            this.lastText = Html.fromHtml(this.mString + this.suffixString).toString();
            setText(Html.fromHtml(this.mString + this.suffixString));
            int length = getText().length();
            this.textLength = length;
            int i15 = i11 + i13;
            if (i15 >= length) {
                setSelection(getText().length());
            } else {
                setSelection(i15);
            }
        } else if (!TextUtils.isEmpty(this.mString) && !this.lastText.equals(getText().toString()) && !TextUtils.isEmpty(this.suffixString)) {
            if (charSequence.toString().contains(this.lastAutoText) && !TextUtils.isEmpty(this.lastAutoText)) {
                charSequence = charSequence.subSequence(0, charSequence.toString().lastIndexOf(this.lastAutoText));
            }
            String str = "<font color=\"#ffffff\">" + charSequence.toString() + "</font>";
            this.mString = str;
            this.lastText = Html.fromHtml(str).toString();
            setText(Html.fromHtml(this.mString));
            int length2 = charSequence.length();
            this.textLength = length2;
            int i16 = i11 + i13;
            if (i16 >= length2) {
                setSelection(charSequence.length());
            } else {
                setSelection(i16);
            }
        }
        this.textLength = charSequence.length();
        this.lastText = getText().toString();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.handler.sendEmptyMessageDelayed(0, 1);
        }
        return super.onTouchEvent(motionEvent);
    }

    public AutoCompeleteEmailSuffixEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoCompeleteEmailSuffixEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
