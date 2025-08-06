package com.hbg.module.libkt.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import kotlin.jvm.internal.r;

@SuppressLint({"CustomViewStyleable", "Recycle"})
public final class MarqueeTextView extends RelativeLayout {

    /* renamed from: w  reason: collision with root package name */
    public static final b f24694w = new b((r) null);

    /* renamed from: b  reason: collision with root package name */
    public ViewFlipper f24695b;

    /* renamed from: c  reason: collision with root package name */
    public int f24696c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f24697d;

    /* renamed from: e  reason: collision with root package name */
    public int f24698e;

    /* renamed from: f  reason: collision with root package name */
    public int f24699f;

    /* renamed from: g  reason: collision with root package name */
    public float f24700g;

    /* renamed from: h  reason: collision with root package name */
    public float f24701h;

    /* renamed from: i  reason: collision with root package name */
    public int f24702i;

    /* renamed from: j  reason: collision with root package name */
    public int f24703j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f24704k;

    /* renamed from: l  reason: collision with root package name */
    public int f24705l;

    /* renamed from: m  reason: collision with root package name */
    public int f24706m;

    /* renamed from: n  reason: collision with root package name */
    public int f24707n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f24708o;

    /* renamed from: p  reason: collision with root package name */
    public int f24709p;

    /* renamed from: q  reason: collision with root package name */
    public ArrayList<String> f24710q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f24711r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f24712s;

    /* renamed from: t  reason: collision with root package name */
    public c f24713t;

    /* renamed from: u  reason: collision with root package name */
    public a f24714u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f24715v;

    public final class a implements Runnable {
        public a() {
        }

        public void run() {
            if (!MarqueeTextView.this.f24711r || MarqueeTextView.this.f24712s) {
                MarqueeTextView.this.m();
                return;
            }
            MarqueeTextView marqueeTextView = MarqueeTextView.this;
            marqueeTextView.j(marqueeTextView.f24706m, MarqueeTextView.this.f24707n);
            ViewFlipper d11 = MarqueeTextView.this.f24695b;
            if (d11 != null) {
                d11.showNext();
            }
            c c11 = MarqueeTextView.this.f24713t;
            if (c11 != null) {
                ViewFlipper d12 = MarqueeTextView.this.f24695b;
                c11.a(d12 != null ? d12.getDisplayedChild() : 0);
            }
            MarqueeTextView marqueeTextView2 = MarqueeTextView.this;
            marqueeTextView2.postDelayed(this, (long) marqueeTextView2.f24696c);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(r rVar) {
            this();
        }
    }

    public interface c {
        void a(int i11);

        void onItemClick(int i11);
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f24717b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f24718c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ MarqueeTextView f24719d;

        public d(View view, long j11, MarqueeTextView marqueeTextView) {
            this.f24717b = view;
            this.f24718c = j11;
            this.f24719d = marqueeTextView;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            com.hbg.module.libkt.utils.r rVar = com.hbg.module.libkt.utils.r.f24939a;
            if (currentTimeMillis - rVar.b(this.f24717b) > this.f24718c || (this.f24717b instanceof Checkable)) {
                rVar.e(this.f24717b, currentTimeMillis);
                ViewFlipper viewFlipper = (ViewFlipper) this.f24717b;
                int displayedChild = this.f24719d.f24695b.getDisplayedChild();
                c c11 = this.f24719d.f24713t;
                if (c11 != null) {
                    c11.onItemClick(displayedChild);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MarqueeTextView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public final void i(boolean z11) {
        if (this.f24715v != z11) {
            this.f24715v = z11;
            if (z11) {
                l();
            } else {
                m();
            }
        }
    }

    public final void j(int i11, int i12) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i11);
        loadAnimation.setDuration((long) this.f24709p);
        ViewFlipper viewFlipper = this.f24695b;
        if (viewFlipper != null) {
            viewFlipper.setInAnimation(loadAnimation);
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), i12);
        loadAnimation2.setDuration((long) this.f24709p);
        ViewFlipper viewFlipper2 = this.f24695b;
        if (viewFlipper2 != null) {
            viewFlipper2.setOutAnimation(loadAnimation2);
        }
    }

    public final void k(TextView textView, int i11) {
        ArrayList<String> arrayList = this.f24710q;
        textView.setText(arrayList != null ? arrayList.get(i11) : null);
        textView.setTypeface((Typeface) null, this.f24703j);
        boolean z11 = this.f24697d;
        if (z11) {
            textView.setSingleLine(z11);
        } else {
            int i12 = this.f24698e;
            if (i12 > 0) {
                textView.setMaxLines(i12);
            }
        }
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(this.f24699f);
        textView.setTextSize(this.f24700g);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight((int) this.f24701h);
        }
        textView.setIncludeFontPadding(false);
        textView.setGravity(this.f24702i);
    }

    public final void l() {
        if (!this.f24711r && !this.f24712s) {
            this.f24711r = true;
            postDelayed(this.f24714u, (long) this.f24696c);
        }
    }

    public final void m() {
        if (this.f24711r) {
            this.f24711r = false;
            removeCallbacks(this.f24714u);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f24712s = false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f24712s = true;
        m();
    }

    public final void setDatas(ArrayList<String> arrayList) {
        this.f24710q = arrayList;
        if (!com.hbg.module.libkt.base.ext.b.w(arrayList)) {
            ViewFlipper viewFlipper = this.f24695b;
            if (viewFlipper != null) {
                viewFlipper.removeAllViews();
            }
            int size = this.f24710q.size();
            for (int i11 = 0; i11 < size; i11++) {
                TextView textView = new TextView(getContext());
                k(textView, i11);
                ViewFlipper viewFlipper2 = this.f24695b;
                if (viewFlipper2 != null) {
                    viewFlipper2.addView(textView, i11);
                }
            }
        }
    }

    public final void setMarqueeListener(c cVar) {
        this.f24713t = cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MarqueeTextView(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9, r10)
            r0 = 5000(0x1388, float:7.006E-42)
            r6.f24696c = r0
            r0 = 1096810496(0x41600000, float:14.0)
            r6.f24700g = r0
            r0 = 1099956224(0x41900000, float:18.0)
            r6.f24701h = r0
            r0 = 3
            r6.f24702i = r0
            int r1 = com.hbg.module.libkt.R$anim.anim_right_in
            r6.f24706m = r1
            int r2 = com.hbg.module.libkt.R$anim.anim_left_out
            r6.f24707n = r2
            r3 = 1500(0x5dc, float:2.102E-42)
            r6.f24709p = r3
            com.hbg.module.libkt.custom.MarqueeTextView$a r3 = new com.hbg.module.libkt.custom.MarqueeTextView$a
            r3.<init>()
            r6.f24714u = r3
            int[] r3 = com.hbg.module.libkt.R$styleable.MarqueeTextViewStyle
            android.content.res.TypedArray r8 = r7.obtainStyledAttributes(r8, r3, r9, r10)
            int r9 = com.hbg.module.libkt.R$styleable.MarqueeTextViewStyle_setInterval
            int r10 = r6.f24696c
            int r9 = r8.getInteger(r9, r10)
            r6.f24696c = r9
            int r9 = com.hbg.module.libkt.R$styleable.MarqueeTextViewStyle_setSingleLine
            r10 = 0
            boolean r9 = r8.getBoolean(r9, r10)
            r6.f24697d = r9
            if (r9 != 0) goto L_0x004a
            int r9 = com.hbg.module.libkt.R$styleable.MarqueeTextViewStyle_setMaxLines
            int r3 = r6.f24698e
            int r9 = r8.getInt(r9, r3)
            r6.f24698e = r9
        L_0x004a:
            int r9 = com.hbg.module.libkt.R$styleable.MarqueeTextViewStyle_setTextColor
            int r3 = r6.f24699f
            int r9 = r8.getColor(r9, r3)
            r6.f24699f = r9
            int r9 = com.hbg.module.libkt.R$styleable.MarqueeTextViewStyle_setTextSize
            float r3 = r6.f24700g
            float r9 = r8.getDimension(r9, r3)
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            int r9 = com.hbg.module.libkt.base.ext.c.g(r9)
            float r9 = (float) r9
            r6.f24700g = r9
            int r9 = com.hbg.module.libkt.R$styleable.MarqueeTextViewStyle_setLineHeight
            float r3 = r6.f24701h
            float r9 = r8.getDimension(r9, r3)
            r6.f24701h = r9
            int r9 = com.hbg.module.libkt.R$styleable.MarqueeTextViewStyle_setGravity
            int r9 = r8.getInt(r9, r10)
            r3 = 2
            r4 = 1
            if (r9 == 0) goto L_0x0085
            if (r9 == r4) goto L_0x0082
            if (r9 == r3) goto L_0x0080
            goto L_0x0085
        L_0x0080:
            r9 = 5
            goto L_0x0086
        L_0x0082:
            r9 = 17
            goto L_0x0086
        L_0x0085:
            r9 = r0
        L_0x0086:
            r6.f24702i = r9
            int r9 = com.hbg.module.libkt.R$styleable.MarqueeTextViewStyle_setAnimDuration
            boolean r5 = r8.hasValue(r9)
            r6.f24708o = r5
            int r5 = r6.f24709p
            int r9 = r8.getInt(r9, r5)
            r6.f24709p = r9
            int r9 = com.hbg.module.libkt.R$styleable.MarqueeTextViewStyle_setDirection
            boolean r5 = r8.hasValue(r9)
            r6.f24704k = r5
            if (r5 == 0) goto L_0x00d2
            int r5 = r6.f24705l
            int r9 = r8.getInt(r9, r5)
            r6.f24705l = r9
            if (r9 == 0) goto L_0x00ca
            if (r9 == r4) goto L_0x00c1
            if (r9 == r3) goto L_0x00bc
            if (r9 == r0) goto L_0x00b3
            goto L_0x00d2
        L_0x00b3:
            int r9 = com.hbg.module.libkt.R$anim.anim_left_in
            r6.f24706m = r9
            int r9 = com.hbg.module.libkt.R$anim.anim_right_out
            r6.f24707n = r9
            goto L_0x00d2
        L_0x00bc:
            r6.f24706m = r1
            r6.f24707n = r2
            goto L_0x00d2
        L_0x00c1:
            int r9 = com.hbg.module.libkt.R$anim.anim_top_in
            r6.f24706m = r9
            int r9 = com.hbg.module.libkt.R$anim.anim_bottom_out
            r6.f24707n = r9
            goto L_0x00d2
        L_0x00ca:
            int r9 = com.hbg.module.libkt.R$anim.anim_bottom_in
            r6.f24706m = r9
            int r9 = com.hbg.module.libkt.R$anim.anim_top_out
            r6.f24707n = r9
        L_0x00d2:
            int r9 = com.hbg.module.libkt.R$styleable.MarqueeTextViewStyle_setTypeface
            int r1 = r6.f24703j
            int r8 = r8.getInt(r9, r1)
            if (r8 == r4) goto L_0x00e4
            if (r8 == r3) goto L_0x00e2
            if (r8 == r0) goto L_0x00e5
            r0 = r10
            goto L_0x00e5
        L_0x00e2:
            r0 = r3
            goto L_0x00e5
        L_0x00e4:
            r0 = r4
        L_0x00e5:
            r6.f24703j = r0
            android.widget.ViewFlipper r8 = new android.widget.ViewFlipper
            r8.<init>(r7)
            r6.f24695b = r8
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams
            r9 = -1
            r7.<init>(r9, r9)
            r8.setLayoutParams(r7)
            android.widget.ViewFlipper r7 = r6.f24695b
            r6.addView(r7)
            android.widget.ViewFlipper r7 = r6.f24695b
            if (r7 == 0) goto L_0x010c
            com.hbg.module.libkt.utils.r r8 = com.hbg.module.libkt.utils.r.f24939a
            r8 = 800(0x320, double:3.953E-321)
            com.hbg.module.libkt.custom.MarqueeTextView$d r10 = new com.hbg.module.libkt.custom.MarqueeTextView$d
            r10.<init>(r7, r8, r6)
            r7.setOnClickListener(r10)
        L_0x010c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.custom.MarqueeTextView.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }
}
