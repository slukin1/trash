package com.huobi.view.keyboard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$font;
import oa.a;

public class HuobiKeyBoardView extends KeyboardView {
    public static final int INPUTTYPE_ABC = 6;
    public static final int INPUTTYPE_NUM = 1;
    public static final int INPUTTYPE_NUM_ABC = 8;
    public static final int INPUTTYPE_NUM_FINISH = 2;
    public static final int INPUTTYPE_NUM_NEXT = 5;
    public static final int INPUTTYPE_NUM_POINT = 3;
    public static final int INPUTTYPE_NUM_X = 4;
    public static final int INPUTTYPE_SYMBOL = 7;
    private Context mContext;
    private int mInputType;
    private int mLargeTextSize;
    private int rightType = 1;

    public HuobiKeyBoardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void drawABCSpecialKey(Keyboard.Key key, Canvas canvas) {
        if (key.codes[0] == -5) {
            drawKeyBackground(R$drawable.selector_keyboard_key_bg, canvas, key);
            drawImg(R$drawable.btn_keyboard_key_delete, canvas, key);
        }
        if (key.codes[0] == -1) {
            drawKeyBackground(R$drawable.selector_keyboard_key_bg, canvas, key);
            drawImg(R$drawable.btn_keyboard_key_shift, canvas, key);
        }
        int[] iArr = key.codes;
        if (iArr[0] == 123123 || iArr[0] == 789789) {
            drawKeyBackground(R$drawable.selector_keyboard_key_bg, canvas, key);
            drawText(canvas, key);
        }
    }

    private void drawImg(int i11, Canvas canvas, Keyboard.Key key) {
        Drawable drawable = this.mContext.getResources().getDrawable(i11);
        int[] currentDrawableState = key.getCurrentDrawableState();
        if (key.codes[0] != 0) {
            drawable.setState(currentDrawableState);
        }
        int intrinsicWidth = key.x + ((key.width - drawable.getIntrinsicWidth()) / 2) + getPaddingLeft();
        int intrinsicHeight = key.y + ((key.height - drawable.getIntrinsicHeight()) / 2) + getPaddingTop();
        drawable.setBounds(intrinsicWidth, intrinsicHeight, drawable.getIntrinsicWidth() + intrinsicWidth, drawable.getIntrinsicHeight() + intrinsicHeight);
        drawable.draw(canvas);
    }

    private void drawKeyBackground(int i11, Canvas canvas, Keyboard.Key key) {
        Drawable drawable = this.mContext.getResources().getDrawable(i11);
        int[] currentDrawableState = key.getCurrentDrawableState();
        if (key.codes[0] != 0) {
            drawable.setState(currentDrawableState);
        }
        drawable.setBounds(key.x + getPaddingLeft(), key.y + getPaddingTop(), key.x + key.width + getPaddingLeft(), key.y + key.height + getPaddingTop());
        drawable.draw(canvas);
    }

    private void drawNumSpecialKey(Keyboard.Key key, Canvas canvas) {
        int[] iArr = key.codes;
        if (iArr[0] == -5) {
            drawKeyBackground(R$drawable.selector_keyboard_sepcial_key_bg, canvas, key);
            drawImg(R$drawable.keyboard_delete, canvas, key);
        } else if (iArr[0] == 0 || iArr[0] == 741741 || iArr[0] == 88 || ((iArr[0] == -4 && key.label != null) || iArr[0] == 46)) {
            drawKeyBackground(R$drawable.selector_keyboard_sepcial_key_bg, canvas, key);
            drawText(canvas, key);
        } else {
            drawKeyBackground(R$drawable.selector_keyboard_key_bg, canvas, key);
            drawText(canvas, key);
        }
    }

    private void drawSymbolSpecialKey(Keyboard.Key key, Canvas canvas) {
        int[] iArr = key.codes;
        if (iArr[0] == 123123 || iArr[0] == 456456) {
            drawKeyBackground(R$drawable.selector_keyboard_key_bg, canvas, key);
            drawText(canvas, key);
        }
        if (key.codes[0] == -5) {
            drawKeyBackground(R$drawable.selector_keyboard_key_bg, canvas, key);
            drawImg(R$drawable.btn_keyboard_key_delete, canvas, key);
        }
    }

    private void drawText(Canvas canvas, Keyboard.Key key) {
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_regular));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize((float) this.mLargeTextSize);
        paint.setAntiAlias(true);
        Context context = getContext();
        int i11 = R$color.custom_keyboard_key_text_color;
        paint.setColor(ContextCompat.getColor(context, i11));
        int i12 = this.mInputType;
        if (i12 == 1 || i12 == 2 || i12 == 3 || i12 == 4 || i12 == 5 || i12 == 8) {
            CharSequence charSequence = key.label;
            if (charSequence != null) {
                paint.getTextBounds(charSequence.toString(), 0, key.label.toString().length(), rect);
                canvas.drawText(key.label.toString(), (float) (key.x + (key.width / 2) + getPaddingLeft()), (float) (key.y + (key.height / 2) + (rect.height() / 2) + getPaddingTop()), paint);
            }
        } else if ((i12 == 6 || i12 == 7) && key.label != null) {
            paint.setColor(this.mContext.getResources().getColor(i11));
            paint.getTextBounds(key.label.toString(), 0, key.label.toString().length(), rect);
            canvas.drawText(key.label.toString(), (float) (key.x + (key.width / 2) + getPaddingLeft()), (float) (key.y + (key.height / 2) + (rect.height() / 2) + getPaddingTop()), paint);
        }
    }

    private void init(Context context) {
        this.mContext = context;
        if (context instanceof Activity) {
            ((Activity) getContext()).getWindow().setSoftInputMode(3);
        } else {
            a.g().b().getWindow().setSoftInputMode(3);
        }
        this.mLargeTextSize = PixelUtils.a(32.0f);
    }

    private void initRightType(Keyboard.Key key) {
        int[] iArr = key.codes;
        if (iArr[0] == 0) {
            this.rightType = 1;
        } else if (iArr[0] == 88) {
            this.rightType = 2;
        } else if (iArr[0] == 46) {
            this.rightType = 3;
        } else if (iArr[0] == -4 && key.label.equals("完成")) {
            this.rightType = 4;
        } else if (key.codes[0] == -4 && key.label.equals("下一项")) {
            this.rightType = 5;
        }
    }

    public int getRightType() {
        return this.rightType;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Keyboard.Key next : getKeyboard().getKeys()) {
            int i11 = this.mInputType;
            if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4 || i11 == 5 || i11 == 8) {
                initRightType(next);
                drawNumSpecialKey(next, canvas);
            } else if (i11 == 6) {
                drawABCSpecialKey(next, canvas);
            } else if (i11 == 7) {
                drawSymbolSpecialKey(next, canvas);
            }
        }
    }

    public void setInputType(int i11) {
        this.mInputType = i11;
    }

    public HuobiKeyBoardView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
