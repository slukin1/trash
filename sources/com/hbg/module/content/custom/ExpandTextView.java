package com.hbg.module.content.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$styleable;
import com.hbg.module.libkt.base.ext.b;
import kotlin.jvm.internal.x;

public final class ExpandTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public boolean f17978b;

    /* renamed from: c  reason: collision with root package name */
    public a f17979c;

    /* renamed from: d  reason: collision with root package name */
    public String f17980d;

    /* renamed from: e  reason: collision with root package name */
    public String f17981e;

    /* renamed from: f  reason: collision with root package name */
    public final int f17982f = 3;

    /* renamed from: g  reason: collision with root package name */
    public final int f17983g = 3;

    /* renamed from: h  reason: collision with root package name */
    public int f17984h = 3;

    /* renamed from: i  reason: collision with root package name */
    public int f17985i = 3;

    /* renamed from: j  reason: collision with root package name */
    public final String f17986j = "...";

    /* renamed from: k  reason: collision with root package name */
    public String f17987k;

    /* renamed from: l  reason: collision with root package name */
    public String f17988l = "...";

    /* renamed from: m  reason: collision with root package name */
    public String f17989m = "";

    /* renamed from: n  reason: collision with root package name */
    public final SpannableStringBuilder f17990n = new SpannableStringBuilder();

    /* renamed from: o  reason: collision with root package name */
    public final ForegroundColorSpan f17991o = new ForegroundColorSpan(b.h(R$color.baseColorMajorTheme100));

    public interface a {
        void a();

        void b();

        void c();
    }

    public ExpandTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandTextView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ExpandTextView_etv_MaxLinesOnShrink) {
                    this.f17985i = obtainStyledAttributes.getInt(index, this.f17982f);
                } else if (index == R$styleable.ExpandTextView_etv_ToExpandHint) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f17988l = string == null ? "..." : string;
                } else if (index == R$styleable.ExpandTextView_etv_ExpandThreshold) {
                    this.f17984h = obtainStyledAttributes.getInt(index, this.f17983g);
                }
            }
        }
    }

    public final StaticLayout d(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return new StaticLayout(str, getPaint(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        } else if (str != null) {
            return StaticLayout.Builder.obtain(str, 0, str.length(), getPaint(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()).build();
        } else {
            return null;
        }
    }

    public final int getMExpandThreshold() {
        return this.f17984h;
    }

    public final int getMMaxLineCount() {
        return this.f17985i;
    }

    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i11, int i12) {
        SpannableStringBuilder spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2;
        super.onMeasure(i11, i12);
        StaticLayout d11 = d(this.f17980d);
        if (d11 != null) {
            int lineCount = d11.getLineCount();
            if (!b.x(this.f17989m) && lineCount > this.f17984h && this.f17978b) {
                d11 = d(this.f17980d + this.f17989m);
                lineCount = d11.getLineCount();
            }
            if (lineCount <= this.f17984h) {
                setText(b.n(this.f17987k, this.f17980d));
                a aVar = this.f17979c;
                if (aVar != null) {
                    aVar.b();
                }
            } else if (this.f17978b) {
                if (!b.x(this.f17989m)) {
                    String str = this.f17980d + this.f17989m;
                    this.f17990n.clear();
                    this.f17990n.append(str);
                    String str2 = str;
                    this.f17990n.setSpan(this.f17991o, StringsKt__StringsKt.m0(str2, this.f17989m, 0, false, 6, (Object) null), StringsKt__StringsKt.m0(str2, this.f17989m, 0, false, 6, (Object) null) + this.f17989m.length(), 33);
                    spannableStringBuilder2 = this.f17990n;
                } else {
                    spannableStringBuilder2 = b.n(this.f17987k, this.f17980d);
                }
                setText(spannableStringBuilder2);
                a aVar2 = this.f17979c;
                if (aVar2 != null) {
                    aVar2.c();
                }
            } else {
                lineCount = this.f17985i;
                float measureText = getPaint().measureText(this.f17988l);
                int i13 = lineCount - 1;
                int lineStart = d11.getLineStart(i13);
                String substring = this.f17981e.substring(lineStart, d11.getLineEnd(i13));
                int length = substring.length();
                while (true) {
                    length--;
                    if (-1 >= length) {
                        length = 0;
                        break;
                    } else {
                        if (getPaint().measureText(substring.substring(length)) >= measureText) {
                            break;
                        }
                    }
                }
                int i14 = length < 2 ? 0 : length - 2;
                StringBuilder sb2 = new StringBuilder();
                if (!x.b(this.f17988l, this.f17986j)) {
                    length = i14;
                }
                sb2.append(substring.substring(0, length));
                sb2.append(!x.b(this.f17988l, this.f17986j) ? this.f17986j : "");
                sb2.append(this.f17988l);
                String str3 = this.f17981e.substring(0, lineStart) + sb2.toString();
                if (!x.b(this.f17988l, this.f17986j)) {
                    this.f17990n.clear();
                    this.f17990n.append(str3);
                    String str4 = str3;
                    this.f17990n.setSpan(this.f17991o, StringsKt__StringsKt.g0(str4, this.f17988l, 0, false, 6, (Object) null), StringsKt__StringsKt.g0(str4, this.f17988l, 0, false, 6, (Object) null) + this.f17988l.length(), 33);
                    spannableStringBuilder = this.f17990n;
                } else {
                    spannableStringBuilder = b.n(this.f17987k, str3);
                }
                setText(spannableStringBuilder);
                a aVar3 = this.f17979c;
                if (aVar3 != null) {
                    aVar3.a();
                }
            }
            float f11 = 0.0f;
            for (int i15 = 0; i15 < lineCount; i15++) {
                f11 += (float) (d11.getLineBottom(i15) - d11.getLineTop(i15));
            }
            setMeasuredDimension(getMeasuredWidth(), (int) (f11 + (((float) lineCount) * getLineSpacingExtra() * ((float) 2)) + ((float) getPaddingTop()) + ((float) getPaddingBottom())));
        }
    }

    public final void setChanged(boolean z11) {
        this.f17978b = z11;
        b.P(this);
    }

    public final void setCollapseText(String str) {
        this.f17989m = str;
    }

    public final void setEllipsizeText(String str) {
        this.f17988l = str;
    }

    public final void setMExpandThreshold(int i11) {
        this.f17984h = i11;
    }

    public final void setMMaxLineCount(int i11) {
        this.f17985i = i11;
    }

    public final void setSearchKey(String str) {
        this.f17987k = str;
    }
}
