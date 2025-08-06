package com.huobi.view.rolltext;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.huobi.R$styleable;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public class MultiScrollNumber extends LinearLayout {
    private Context mContext;
    private String mFontFileName;
    private Interpolator mInterpolator;
    private List<Integer> mPrimaryNumbers;
    private List<ScrollNumber> mScrollNumbers;
    private List<Integer> mTargetNumbers;
    private int[] mTextColors;
    private int mTextSize;

    public MultiScrollNumber(Context context) {
        this(context, (AttributeSet) null);
    }

    private void resetView() {
        this.mTargetNumbers.clear();
        this.mScrollNumbers.clear();
        removeAllViews();
    }

    public void setBlank() {
        for (int i11 = 0; i11 < 2; i11--) {
            TextView textView = new TextView(this.mContext);
            textView.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            textView.setTextSize((float) this.mTextSize);
            textView.setTextColor(this.mContext.getResources().getColor(R.color.baseTextColor));
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            addView(textView);
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        if (interpolator != null) {
            this.mInterpolator = interpolator;
            List<ScrollNumber> list = this.mScrollNumbers;
            if (list != null && list.size() > 0) {
                for (ScrollNumber interpolator2 : this.mScrollNumbers) {
                    interpolator2.setInterpolator(interpolator);
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("interpolator couldn't be null");
    }

    public void setNumber(double d11, int i11) {
        resetView();
        DecimalFormat decimalFormat = new DecimalFormat(new StringBuffer(i11 == 2 ? "#0.00" : "#0.0000").toString());
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        String format = decimalFormat.format(d11);
        if (d11 > 0.0d) {
            for (int length = format.length() - 1; length >= 0; length--) {
                int i12 = length + 1;
                if (!format.substring(length, i12).equals(InstructionFileId.DOT)) {
                    this.mTargetNumbers.add(Integer.valueOf(m.k0(format.substring(length, i12))));
                }
            }
        } else {
            for (int i13 = 0; i13 <= i11; i13++) {
                this.mTargetNumbers.add(0);
            }
        }
        for (int size = this.mTargetNumbers.size() - 1; size >= 0; size--) {
            ScrollNumber scrollNumber = new ScrollNumber(this.mContext);
            scrollNumber.setTextColor(ContextCompat.getColor(this.mContext, this.mTextColors[0]));
            scrollNumber.setTextSize(this.mTextSize);
            scrollNumber.setInterpolator(this.mInterpolator);
            if (!TextUtils.isEmpty(this.mFontFileName)) {
                scrollNumber.setTextFont(this.mFontFileName);
            }
            scrollNumber.setNumber(0, this.mTargetNumbers.get(size).intValue(), (long) (size * 10));
            this.mScrollNumbers.add(scrollNumber);
            if (size == i11 - 1) {
                TextView textView = new TextView(this.mContext);
                textView.setText(InstructionFileId.DOT);
                textView.setTextSize((float) this.mTextSize);
                textView.setTextColor(this.mContext.getResources().getColor(R.color.baseTextColor));
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                addView(textView);
            }
            addView(scrollNumber);
        }
    }

    public void setTextColors(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("color array couldn't be empty!");
        }
        this.mTextColors = iArr;
        for (int size = this.mScrollNumbers.size() - 1; size >= 0; size--) {
            Context context = this.mContext;
            int[] iArr2 = this.mTextColors;
            this.mScrollNumbers.get(size).setTextColor(ContextCompat.getColor(context, iArr2[size % iArr2.length]));
        }
    }

    public void setTextFont(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mFontFileName = str;
            for (ScrollNumber textFont : this.mScrollNumbers) {
                textFont.setTextFont(str);
            }
            return;
        }
        throw new IllegalArgumentException("file name is null");
    }

    public void setTextSize(int i11) {
        if (i11 > 0) {
            this.mTextSize = i11;
            List<ScrollNumber> list = this.mScrollNumbers;
            if (list != null && list.size() > 0) {
                for (ScrollNumber textSize : this.mScrollNumbers) {
                    textSize.setTextSize(i11);
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("text size must > 0!");
    }

    public MultiScrollNumber(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiScrollNumber(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mTargetNumbers = new ArrayList();
        this.mPrimaryNumbers = new ArrayList();
        this.mScrollNumbers = new ArrayList();
        this.mTextSize = 130;
        this.mTextColors = new int[]{R.color.baseTextColor};
        this.mInterpolator = new AccelerateDecelerateInterpolator();
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MultiScrollNumber);
        int integer = obtainStyledAttributes.getInteger(1, 0);
        int integer2 = obtainStyledAttributes.getInteger(2, 0);
        int integer3 = obtainStyledAttributes.getInteger(0, 130);
        setNumber(integer, integer2);
        setTextSize(integer3);
        obtainStyledAttributes.recycle();
        setOrientation(0);
        setGravity(17);
    }

    public void setNumber(int i11, int i12) {
        if (i12 >= i11) {
            resetView();
            int i13 = 0;
            while (i12 > 0) {
                this.mTargetNumbers.add(Integer.valueOf(i12 % 10));
                i12 /= 10;
                i13++;
            }
            while (i13 > 0) {
                this.mPrimaryNumbers.add(Integer.valueOf(i11 % 10));
                i11 /= 10;
                i13--;
            }
            for (int size = this.mTargetNumbers.size() - 1; size >= 0; size--) {
                ScrollNumber scrollNumber = new ScrollNumber(this.mContext);
                Context context = this.mContext;
                int[] iArr = this.mTextColors;
                scrollNumber.setTextColor(ContextCompat.getColor(context, iArr[size % iArr.length]));
                scrollNumber.setTextSize(this.mTextSize);
                if (!TextUtils.isEmpty(this.mFontFileName)) {
                    scrollNumber.setTextFont(this.mFontFileName);
                }
                scrollNumber.setNumber(this.mPrimaryNumbers.get(size).intValue(), this.mTargetNumbers.get(size).intValue(), (long) (size * 10));
                this.mScrollNumbers.add(scrollNumber);
                addView(scrollNumber);
            }
            return;
        }
        throw new UnsupportedOperationException("'to' value must > 'from' value");
    }
}
