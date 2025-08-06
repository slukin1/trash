package com.hbg.lib.widgets.expandable;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$styleable;
import com.hbg.lib.widgets.expandable.FormatData;
import com.hbg.lib.widgets.expandable.UrlParamTool;
import com.huobi.view.roundimg.RoundedDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpandableTextView extends AppCompatTextView {
    public static final Pattern C0 = Pattern.compile("(mailto:|(news|(ht|f)tp(s?))://|((?<![\\p{L}0-9_.])(www\\.)))[-A-Za-z0-9+$&@#/%?=~_|!:,.;]*[-A-Za-z0-9+$&@#/%=~_|]");
    public static final StatusType D0 = StatusType.STATUS_EXPAND;
    public boolean A;
    public int A0;
    public int B;
    public fa.a B0;
    public CharSequence C;
    public CharSequence D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public String K;
    public String L;
    public String M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public Drawable R;
    public Drawable S;
    public int T;
    public int U;
    public int V;
    public int W;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f71960a0;

    /* renamed from: b  reason: collision with root package name */
    public int f71961b;

    /* renamed from: b0  reason: collision with root package name */
    public Drawable f71962b0;

    /* renamed from: c  reason: collision with root package name */
    public TextPaint f71963c;

    /* renamed from: c0  reason: collision with root package name */
    public int f71964c0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71965d;

    /* renamed from: d0  reason: collision with root package name */
    public int f71966d0;

    /* renamed from: e  reason: collision with root package name */
    public Context f71967e;

    /* renamed from: e0  reason: collision with root package name */
    public int f71968e0;

    /* renamed from: f  reason: collision with root package name */
    public fa.b f71969f;

    /* renamed from: f0  reason: collision with root package name */
    public int f71970f0;

    /* renamed from: g  reason: collision with root package name */
    public StatusType f71971g;

    /* renamed from: g0  reason: collision with root package name */
    public int f71972g0;

    /* renamed from: h  reason: collision with root package name */
    public DynamicLayout f71973h;

    /* renamed from: h0  reason: collision with root package name */
    public fa.g f71974h0;

    /* renamed from: i  reason: collision with root package name */
    public int f71975i;

    /* renamed from: i0  reason: collision with root package name */
    public CommentTextViewTouchListener f71976i0;

    /* renamed from: j  reason: collision with root package name */
    public int f71977j;

    /* renamed from: j0  reason: collision with root package name */
    public ViewTreeObserver.OnPreDrawListener f71978j0;

    /* renamed from: k  reason: collision with root package name */
    public int f71979k;

    /* renamed from: k0  reason: collision with root package name */
    public h f71980k0;

    /* renamed from: l  reason: collision with root package name */
    public int f71981l;

    /* renamed from: l0  reason: collision with root package name */
    public boolean f71982l0;

    /* renamed from: m  reason: collision with root package name */
    public Drawable f71983m;

    /* renamed from: m0  reason: collision with root package name */
    public String f71984m0;

    /* renamed from: n  reason: collision with root package name */
    public i f71985n;

    /* renamed from: n0  reason: collision with root package name */
    public int f71986n0;

    /* renamed from: o  reason: collision with root package name */
    public boolean f71987o;

    /* renamed from: p  reason: collision with root package name */
    public g f71988p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f71989q;

    /* renamed from: r  reason: collision with root package name */
    public FormatData f71990r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f71991s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f71992t;

    /* renamed from: t0  reason: collision with root package name */
    public float f71993t0;

    /* renamed from: u  reason: collision with root package name */
    public boolean f71994u;

    /* renamed from: u0  reason: collision with root package name */
    public int f71995u0;

    /* renamed from: v  reason: collision with root package name */
    public boolean f71996v;

    /* renamed from: v0  reason: collision with root package name */
    public int f71997v0;

    /* renamed from: w  reason: collision with root package name */
    public boolean f71998w;

    /* renamed from: w0  reason: collision with root package name */
    public Drawable f71999w0;

    /* renamed from: x  reason: collision with root package name */
    public boolean f72000x;

    /* renamed from: x0  reason: collision with root package name */
    public int f72001x0;

    /* renamed from: y  reason: collision with root package name */
    public boolean f72002y;

    /* renamed from: y0  reason: collision with root package name */
    public int f72003y0;

    /* renamed from: z  reason: collision with root package name */
    public boolean f72004z;

    /* renamed from: z0  reason: collision with root package name */
    public int f72005z0;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        public boolean onPreDraw() {
            if (ExpandableTextView.this.O) {
                return true;
            }
            boolean unused = ExpandableTextView.this.O = true;
            ExpandableTextView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableTextView.this.f71979k <= 0) {
                ExpandableTextView expandableTextView = ExpandableTextView.this;
                int unused2 = expandableTextView.f71979k = expandableTextView.getWidth() + ExpandableTextView.this.getPaddingLeft() + ExpandableTextView.this.getPaddingRight();
            }
            ExpandableTextView.this.correctWidthByDefault("ViewTreeObserver");
            ExpandableTextView expandableTextView2 = ExpandableTextView.this;
            expandableTextView2.setContent(expandableTextView2.D == null ? "" : ExpandableTextView.this.D, false);
            return true;
        }
    }

    public class b extends ClickableSpan {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (ExpandableTextView.this.f71988p != null) {
                ExpandableTextView.this.f71988p.a(StatusType.STATUS_EXPAND);
            }
            if (TextUtils.isEmpty(ExpandableTextView.this.K)) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            if (ExpandableTextView.this.f71987o) {
                if (ExpandableTextView.this.f71969f != null) {
                    ExpandableTextView.this.f71969f.a(StatusType.STATUS_CONTRACT);
                    ExpandableTextView expandableTextView = ExpandableTextView.this;
                    expandableTextView.B(expandableTextView.f71969f.getStatus());
                } else {
                    StatusType unused = ExpandableTextView.this.f71971g = StatusType.STATUS_CONTRACT;
                    ExpandableTextView.this.action();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            if (!TextUtils.isEmpty(ExpandableTextView.this.K)) {
                textPaint.setColor(ExpandableTextView.this.E);
                textPaint.setUnderlineText(false);
            }
        }
    }

    public class c extends ClickableSpan {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (ExpandableTextView.this.f71988p != null) {
                ExpandableTextView.this.f71988p.a(StatusType.STATUS_CONTRACT);
            }
            if (TextUtils.isEmpty(ExpandableTextView.this.L)) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            if (ExpandableTextView.this.f71969f != null) {
                ExpandableTextView.this.f71969f.a(StatusType.STATUS_EXPAND);
                ExpandableTextView expandableTextView = ExpandableTextView.this;
                expandableTextView.B(expandableTextView.f71969f.getStatus());
            } else {
                StatusType unused = ExpandableTextView.this.f71971g = StatusType.STATUS_EXPAND;
                ExpandableTextView.this.action();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            if (!TextUtils.isEmpty(ExpandableTextView.this.L)) {
                textPaint.setColor(ExpandableTextView.this.I);
                textPaint.setUnderlineText(false);
            }
        }
    }

    public class d extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormatData.a f72009b;

        public d(FormatData.a aVar) {
            this.f72009b = aVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (ExpandableTextView.this.f71985n != null) {
                ExpandableTextView.this.f71985n.a(LinkType.SELF, this.f72009b.b(), this.f72009b.c());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ExpandableTextView.this.H);
            textPaint.setUnderlineText(false);
        }
    }

    public class e extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormatData.a f72011b;

        public e(FormatData.a aVar) {
            this.f72011b = aVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (ExpandableTextView.this.f71985n != null) {
                ExpandableTextView.this.f71985n.a(LinkType.MENTION_TYPE, this.f72011b.f(), (String) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ExpandableTextView.this.F);
            textPaint.setUnderlineText(false);
        }
    }

    public class f extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormatData.a f72013b;

        public f(FormatData.a aVar) {
            this.f72013b = aVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (ExpandableTextView.this.f71985n != null) {
                ExpandableTextView.this.f71985n.a(LinkType.LINK_TYPE, this.f72013b.f(), (String) null);
            } else {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(268435456);
                intent.setData(Uri.parse(this.f72013b.f()));
                ExpandableTextView.this.f71967e.startActivity(intent);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ExpandableTextView.this.G);
            textPaint.setUnderlineText(false);
        }
    }

    public interface g {
        void a(StatusType statusType);
    }

    public interface h {
        void onGetLineCount(int i11, boolean z11);
    }

    public interface i {
        void a(LinkType linkType, String str, String str2);
    }

    public class j extends ImageSpan {

        /* renamed from: b  reason: collision with root package name */
        public Drawable f72015b;

        public j(Drawable drawable, int i11) {
            super(drawable, i11);
            this.f72015b = drawable;
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.save();
            canvas.translate(f11, (float) (((((fontMetricsInt.descent + i14) + i14) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2)));
            drawable.draw(canvas);
            canvas.restore();
        }

        public Drawable getDrawable() {
            return this.f72015b;
        }
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(boolean z11, StatusType statusType, ValueAnimator valueAnimator) {
        Float f11 = (Float) valueAnimator.getAnimatedValue();
        if (z11) {
            int i11 = this.f71975i;
            int i12 = this.f71972g0;
            this.f71977j = (i11 - i12) + ((int) (((float) ((this.B - i11) + i12)) * f11.floatValue()));
        } else if (this.f71989q) {
            int i13 = this.f71975i;
            int i14 = this.f71972g0;
            this.f71977j = (i13 - i14) + ((int) (((float) ((this.B - i13) + i14)) * (1.0f - f11.floatValue())));
        }
        CharSequence charSequence = this.D;
        setText(getRealContent(charSequence, "action_" + statusType));
    }

    private String getExpandEndContent() {
        if (TextUtils.isEmpty(this.M)) {
            return String.format(Locale.getDefault(), "  %s", new Object[]{this.L});
        }
        return String.format(Locale.getDefault(), "  %s  %s", new Object[]{this.M, this.L});
    }

    private fa.a getExpandableLabelSpan() {
        fa.a aVar = this.B0;
        if (aVar != null) {
            return aVar;
        }
        return new fa.a(this.f71967e, this.f71997v0, this.f72001x0, this.f72003y0, this.f71995u0, this.f72005z0, this.A0);
    }

    private String getHideEndContent() {
        if (TextUtils.isEmpty(this.M)) {
            return String.format(Locale.getDefault(), this.f72004z ? "  %s" : "...  %s", new Object[]{this.K});
        }
        return String.format(Locale.getDefault(), this.f72004z ? "  %s  %s" : "...  %s  %s", new Object[]{this.M, this.K});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doSetContent$1(CharSequence charSequence, String str) {
        this.f71979k = (getWidth() - getPaddingLeft()) - getPaddingRight();
        correctWidthByDefault("doSetContent");
        if (this.f71979k > 0) {
            setText(getRealContent(charSequence, str));
            this.f71961b = 0;
        } else if (this.f71961b > 2) {
            setText(getRealContent(charSequence, str));
            this.f71961b = 0;
        } else {
            setContent(charSequence, false);
            this.f71961b++;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setContent$0(CharSequence charSequence) {
        if (this.f71979k <= 0) {
            this.f71979k = (getWidth() - getPaddingLeft()) - getPaddingRight();
        }
        correctWidthByDefault("setContent");
        doSetContent(charSequence, "setContent");
    }

    public final void B(StatusType statusType) {
        int i11 = this.f71977j;
        int i12 = this.B;
        boolean z11 = i11 < i12;
        if (this.A) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new fa.c(this, z11, statusType));
            ofFloat.setDuration(100);
            ofFloat.start();
            return;
        }
        if (z11) {
            int i13 = this.f71975i;
            int i14 = this.f71972g0;
            this.f71977j = (i13 - i14) + (i12 - i13) + i14;
        } else if (this.f71989q) {
            this.f71977j = this.f71975i - this.f71972g0;
        }
        CharSequence charSequence = this.D;
        setText(getRealContent(charSequence, "action_" + statusType));
    }

    public final void C(SpannableStringBuilder spannableStringBuilder, FormatData.a aVar, int i11) {
        spannableStringBuilder.setSpan(new e(aVar), aVar.d(), i11, 17);
    }

    public final void D(SpannableStringBuilder spannableStringBuilder, FormatData.a aVar, int i11) {
        spannableStringBuilder.setSpan(new d(aVar), aVar.d(), i11, 17);
    }

    public final void E(SpannableStringBuilder spannableStringBuilder, FormatData.a aVar, int i11) {
        if (this.P) {
            spannableStringBuilder.setSpan(new StyleSpan(1), aVar.d(), i11, 17);
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.J), aVar.d(), i11, 17);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.f71970f0, true), aVar.d(), i11, 17);
    }

    public final void F(SpannableStringBuilder spannableStringBuilder, FormatData.a aVar, int i11) {
        spannableStringBuilder.setSpan(new f(aVar), aVar.d() + 1, i11, 17);
    }

    public final SpannableStringBuilder G(FormatData formatData, boolean z11, String str) {
        String str2;
        float f11;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f71971g.equals(StatusType.STATUS_CONTRACT)) {
            int i11 = this.f71975i;
            int i12 = this.f71972g0;
            this.f71977j = (i11 - i12) + (this.B - i11) + i12;
        } else if (this.f71989q) {
            this.f71977j = this.f71975i - this.f71972g0;
        }
        if (z11) {
            float measureText = this.f71963c.measureText(" ");
            if (!this.Q || measureText <= 0.0f) {
                str2 = "";
                f11 = 0.0f;
            } else {
                StringBuilder sb2 = new StringBuilder("");
                int i13 = this.V;
                int i14 = ((float) i13) < measureText ? 2 : ((int) ((((float) i13) + measureText) / measureText)) + 1;
                f11 = 0.0f;
                for (int i15 = 0; i15 < i14; i15++) {
                    sb2.append(" ");
                    f11 += measureText;
                }
                str2 = sb2.toString();
            }
            int i16 = this.f71977j;
            if (i16 < this.B) {
                int i17 = i16 - 1;
                int lineEnd = this.f71973h.getLineEnd(i17);
                int lineStart = this.f71973h.getLineStart(i17);
                float lineWidth = this.f71973h.getLineWidth(i17);
                String hideEndContent = getHideEndContent();
                String str3 = hideEndContent;
                int i18 = i17;
                String str4 = str2;
                String substring = formatData.a().substring(0, getFitPosition(hideEndContent + str2, lineEnd, lineStart, lineWidth, this.f71963c.measureText(hideEndContent) + f11, 0.0f));
                if (substring.endsWith("\n")) {
                    substring = substring.substring(0, substring.length() - 1);
                }
                spannableStringBuilder.append(substring);
                if (this.f72004z) {
                    float f12 = 0.0f;
                    for (int i19 = 0; i19 < i18; i19++) {
                        f12 += this.f71973h.getLineWidth(i19);
                    }
                    float measureText2 = ((f12 / ((float) i18)) - lineWidth) - this.f71963c.measureText(str3);
                    if (measureText2 > 0.0f) {
                        int i21 = 0;
                        while (((float) i21) * measureText < measureText2) {
                            i21++;
                        }
                        int i22 = i21 - 1;
                        for (int i23 = 0; i23 < i22; i23++) {
                            spannableStringBuilder.append(" ");
                        }
                    }
                }
                SpannableString spannableString = new SpannableString(str3);
                spannableString.setSpan(new ForegroundColorSpan(this.E), spannableString.length() - this.K.length(), spannableString.length(), 17);
                spannableStringBuilder.append(spannableString);
                int length = TextUtils.isEmpty(this.M) ? 0 : this.M.length() + 2;
                spannableStringBuilder.setSpan(new b(), (spannableStringBuilder.length() - this.K.length()) - length, spannableStringBuilder.length(), 17);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.E), (spannableStringBuilder.length() - this.K.length()) - length, spannableStringBuilder.length(), 17);
                if (this.Q) {
                    String str5 = str4;
                    spannableStringBuilder.append(str5);
                    spannableStringBuilder.setSpan(new j(this.R, 1), (spannableStringBuilder.length() - str5.length()) + 1, spannableStringBuilder.length(), 18);
                }
                fa.g gVar = this.f71974h0;
                if (gVar != null) {
                    gVar.a(true, StatusType.STATUS_EXPAND);
                }
            } else {
                String str6 = str2;
                spannableStringBuilder.append(formatData.a());
                if (this.f71989q) {
                    String expandEndContent = getExpandEndContent();
                    if (this.f72004z) {
                        int lineCount = this.f71973h.getLineCount() - 1;
                        float lineWidth2 = this.f71973h.getLineWidth(lineCount);
                        float f13 = 0.0f;
                        for (int i24 = 0; i24 < lineCount; i24++) {
                            f13 += this.f71973h.getLineWidth(i24);
                        }
                        float measureText3 = (((f13 / ((float) lineCount)) - lineWidth2) - this.f71963c.measureText(expandEndContent)) - f11;
                        if (measureText3 > 0.0f) {
                            int i25 = 0;
                            while (((float) i25) * measureText < measureText3) {
                                i25++;
                            }
                            int i26 = i25 - 1;
                            for (int i27 = 0; i27 < i26; i27++) {
                                spannableStringBuilder.append(" ");
                            }
                        }
                    }
                    SpannableString spannableString2 = new SpannableString(expandEndContent);
                    spannableString2.setSpan(new ForegroundColorSpan(this.I), spannableString2.length() - this.L.length(), spannableString2.length(), 17);
                    spannableStringBuilder.append(spannableString2);
                    int length2 = TextUtils.isEmpty(this.M) ? 0 : this.M.length() + 2;
                    spannableStringBuilder.setSpan(new c(), (spannableStringBuilder.length() - this.L.length()) - length2, spannableStringBuilder.length(), 17);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.I), (spannableStringBuilder.length() - this.L.length()) - length2, spannableStringBuilder.length(), 17);
                    if (this.Q) {
                        spannableStringBuilder.append(str6);
                        spannableStringBuilder.setSpan(new j(this.S, 1), (spannableStringBuilder.length() - str6.length()) + 1, spannableStringBuilder.length(), 18);
                    }
                    fa.g gVar2 = this.f71974h0;
                    if (gVar2 != null) {
                        gVar2.a(true, StatusType.STATUS_CONTRACT);
                    }
                } else {
                    if (!TextUtils.isEmpty(this.M)) {
                        spannableStringBuilder.append(this.M);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.N), spannableStringBuilder.length() - this.M.length(), spannableStringBuilder.length(), 17);
                    }
                    fa.g gVar3 = this.f71974h0;
                    if (gVar3 != null) {
                        gVar3.a(false, StatusType.STATUS_CONTRACT);
                    }
                }
            }
        } else {
            spannableStringBuilder.append(formatData.a());
            if (!TextUtils.isEmpty(this.M)) {
                spannableStringBuilder.append(this.M);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.N), spannableStringBuilder.length() - this.M.length(), spannableStringBuilder.length(), 17);
            }
            fa.g gVar4 = this.f71974h0;
            if (gVar4 != null) {
                gVar4.a(false, StatusType.STATUS_EXPAND);
            }
        }
        for (FormatData.a next : formatData.b()) {
            if (spannableStringBuilder.length() >= next.a()) {
                if (next.e().equals(LinkType.PREFIX_MARK)) {
                    spannableStringBuilder.setSpan(new j(this.f71962b0, 1), next.d(), next.a() - 1, 18);
                } else if (next.e().equals(LinkType.PREFIX_LABEL)) {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) this.f71993t0), next.d(), next.a(), 33);
                    spannableStringBuilder.setSpan(getExpandableLabelSpan(), next.d(), next.a(), 33);
                } else if (next.e().equals(LinkType.TITLE)) {
                    if (!this.f71991s || !z11) {
                        E(spannableStringBuilder, next, next.a());
                    } else {
                        int length3 = spannableStringBuilder.length() - getHideEndContent().length();
                        if (next.d() < length3) {
                            int a11 = next.a();
                            if (this.f71977j >= this.B || length3 >= next.a()) {
                                length3 = a11;
                            }
                            E(spannableStringBuilder, next, length3);
                        }
                    }
                } else if (next.e().equals(LinkType.LINK_TYPE)) {
                    if (!this.f71991s || !z11) {
                        spannableStringBuilder.setSpan(new j(this.f71983m, 1), next.d(), next.d() + 1, 18);
                        F(spannableStringBuilder, next, next.a());
                    } else {
                        int length4 = spannableStringBuilder.length() - getHideEndContent().length();
                        if (next.d() < length4) {
                            spannableStringBuilder.setSpan(new j(this.f71983m, 1), next.d(), next.d() + 1, 18);
                            int a12 = next.a();
                            if (this.f71977j < this.B && length4 > next.d() + 1 && length4 < next.a()) {
                                a12 = length4;
                            }
                            if (next.d() + 1 < length4) {
                                F(spannableStringBuilder, next, a12);
                            }
                        }
                    }
                } else if (next.e().equals(LinkType.MENTION_TYPE)) {
                    if (!this.f71991s || !z11) {
                        C(spannableStringBuilder, next, next.a());
                    } else {
                        int length5 = spannableStringBuilder.length() - getHideEndContent().length();
                        if (next.d() < length5) {
                            int a13 = next.a();
                            if (this.f71977j >= this.B || length5 >= next.a()) {
                                length5 = a13;
                            }
                            C(spannableStringBuilder, next, length5);
                        }
                    }
                } else if (next.e().equals(LinkType.SELF)) {
                    if (!this.f71991s || !z11) {
                        D(spannableStringBuilder, next, next.a());
                    } else {
                        int length6 = spannableStringBuilder.length() - getHideEndContent().length();
                        if (next.d() < length6) {
                            int a14 = next.a();
                            if (this.f71977j >= this.B || length6 >= next.a()) {
                                length6 = a14;
                            }
                            D(spannableStringBuilder, next, length6);
                        }
                    }
                }
            }
        }
        setHighlightColor(0);
        return spannableStringBuilder;
    }

    @SuppressLint({"RestrictedApi"})
    public final FormatData H(CharSequence charSequence) {
        int i11;
        int i12;
        CharSequence charSequence2;
        int i13;
        FormatData formatData = new FormatData();
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        if (this.f71960a0) {
            StringBuilder sb3 = new StringBuilder();
            String spaceStr = getSpaceStr(getSpaceCount((float) this.f71966d0));
            sb3.append(spaceStr);
            i11 = spaceStr.length();
            arrayList.add(new FormatData.a(0, i11, sb3.toString(), LinkType.PREFIX_MARK));
            stringBuffer.append(sb3.toString());
            sb2.append(sb3);
            i12 = i11;
        } else {
            i12 = 0;
            i11 = 0;
        }
        if (this.f71982l0) {
            StringBuilder sb4 = new StringBuilder();
            if (!TextUtils.isEmpty(this.f71984m0)) {
                int length = this.f71984m0.length();
                int i14 = this.f71986n0;
                if (length > i14) {
                    this.f71984m0 = this.f71984m0.substring(0, i14);
                }
                String str = this.f71984m0 + " ";
                this.f71984m0 = str;
                int length2 = str.length() + i11;
                arrayList.add(new FormatData.a(i11, length2 - 1, this.f71984m0, LinkType.PREFIX_LABEL));
                stringBuffer.append(this.f71984m0);
                sb4.append(this.f71984m0);
                i11 = length2;
            }
            sb2.append(sb4);
            charSequence2 = charSequence;
            i12 = i11;
        } else {
            charSequence2 = charSequence;
        }
        sb2.append(charSequence2);
        if (this.f72002y) {
            String charSequence3 = TextUtils.isEmpty(this.C) ? "" : this.C.toString();
            i13 = charSequence3.length() + i12;
            arrayList.add(new FormatData.a(i12, i13, charSequence3, LinkType.TITLE));
            stringBuffer.append(charSequence3);
            i11 = i13;
        } else {
            i13 = 0;
        }
        Matcher matcher = Pattern.compile(com.huochat.community.widget.expandable.ExpandableTextView.SELF_REGEX, 2).matcher(sb2);
        if (this.f72000x) {
            ArrayList arrayList2 = new ArrayList();
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                stringBuffer.append(sb2.toString().substring(i13, start));
                String group = matcher.group();
                if (!TextUtils.isEmpty(group)) {
                    String substring = group.substring(group.indexOf("[") + 1, group.indexOf("]"));
                    String substring2 = group.substring(group.indexOf("(") + 1, group.indexOf(")"));
                    String a11 = UUIDUtils.a(substring.length());
                    arrayList2.add(new FormatData.a(stringBuffer.length() + 1, stringBuffer.length() + 2 + substring.length(), substring, substring2, LinkType.SELF));
                    hashMap.put(a11, substring);
                    stringBuffer.append(" " + a11 + " ");
                    i13 = end;
                }
                i11 = end;
            }
            arrayList.addAll(arrayList2);
        }
        stringBuffer.append(sb2.toString().substring(i11, sb2.toString().length()));
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(stringBuffer2.toString().substring(0, stringBuffer2.toString().length()));
        if (this.f71994u) {
            Matcher matcher2 = Pattern.compile("#\u0002\\S*\u0002?#", 2).matcher(stringBuffer3.toString());
            ArrayList arrayList3 = new ArrayList();
            while (matcher2.find()) {
                arrayList3.add(new FormatData.a(matcher2.start(), matcher2.end(), matcher2.group(), LinkType.MENTION_TYPE));
            }
            arrayList.addAll(0, arrayList3);
        }
        if (!hashMap.isEmpty()) {
            String stringBuffer4 = stringBuffer3.toString();
            for (Map.Entry entry : hashMap.entrySet()) {
                stringBuffer4 = stringBuffer4.replaceAll((String) entry.getKey(), (String) entry.getValue());
            }
            stringBuffer3 = new StringBuffer(stringBuffer4);
        }
        formatData.c(stringBuffer3.toString());
        formatData.d(arrayList);
        return formatData;
    }

    public void J(CharSequence charSequence, StatusType statusType) {
        if (statusType != null) {
            this.f71971g = statusType;
        } else {
            this.f71971g = D0;
        }
        this.D = charSequence;
        this.f71961b = 0;
        setContent(charSequence, false);
    }

    public void K(g gVar, boolean z11) {
        this.f71988p = gVar;
        this.f71987o = z11;
    }

    public final void action() {
        B((StatusType) null);
    }

    public final void correctWidthByDefault(String str) {
        if (this.f71979k <= 0) {
            this.f71979k = this.f71981l;
        }
    }

    public final void doSetContent(CharSequence charSequence, String str) {
        this.f71977j = this.f71975i - this.f71972g0;
        if (TextUtils.isEmpty(charSequence)) {
            setText("");
        } else if (this.f71979k <= 0) {
            post(new fa.e(this, charSequence, str));
        } else {
            setText(getRealContent(charSequence, str));
            this.f71961b = 0;
        }
    }

    public String getContractString() {
        return this.L;
    }

    public int getContractTextColor() {
        return this.I;
    }

    public int getEndExpandTextColor() {
        return this.N;
    }

    public g getExpandOrContractClickListener() {
        return this.f71988p;
    }

    public String getExpandString() {
        return this.K;
    }

    public int getExpandTextColor() {
        return this.E;
    }

    public int getExpandableLineCount() {
        return this.B;
    }

    public int getExpandableLinkTextColor() {
        return this.G;
    }

    public final int getFitPosition(String str, int i11, int i12, float f11, float f12, float f13) {
        int i13 = (int) (((f11 - (f12 + f13)) * ((float) (i11 - i12))) / f11);
        if (i13 <= str.length()) {
            return i11;
        }
        int i14 = i13 + i12;
        if (this.f71963c.measureText(this.f71990r.a().substring(i12, i14)) <= f11 - f12) {
            return i14;
        }
        return getFitPosition(str, i11, i12, f11, f12, f13 + this.f71963c.measureText(" "));
    }

    public i getLinkClickListener() {
        return this.f71985n;
    }

    public Drawable getLinkDrawable() {
        return this.f71983m;
    }

    public h getOnGetLineCountListener() {
        return this.f71980k0;
    }

    public final SpannableStringBuilder getRealContent(CharSequence charSequence, String str) {
        CharSequence charSequence2;
        this.f71961b = 0;
        if (TextUtils.isEmpty(this.C)) {
            charSequence2 = charSequence;
        } else {
            charSequence2 = this.C.toString() + charSequence.toString();
        }
        FormatData H2 = H(charSequence2);
        this.f71990r = H2;
        if (TextUtils.isEmpty(H2.a())) {
            this.f71990r.c(charSequence.toString());
            this.f71990r.d(new ArrayList());
        }
        DynamicLayout dynamicLayout = new DynamicLayout(this.f71990r.a(), this.f71963c, this.f71979k, Layout.Alignment.ALIGN_NORMAL, 1.2f, 0.0f, true);
        this.f71973h = dynamicLayout;
        int lineCount = dynamicLayout.getLineCount();
        this.B = lineCount;
        h hVar = this.f71980k0;
        if (hVar != null) {
            hVar.onGetLineCount(lineCount, lineCount > this.f71975i);
        }
        if (!this.f71991s || this.B <= this.f71975i) {
            return G(this.f71990r, false, str);
        }
        return G(this.f71990r, true, str);
    }

    public int getSelfTextColor() {
        return this.H;
    }

    public final int getSpaceCount(float f11) {
        float measureText = this.f71963c.measureText(" ");
        return f11 % measureText == 0.0f ? (int) (f11 / measureText) : ((int) (f11 / measureText)) + 1;
    }

    public final String getSpaceStr(int i11) {
        if (i11 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int i12 = i11 - 1;
            if (i11 <= 0) {
                return sb2.toString();
            }
            sb2.append(" ");
            i11 = i12;
        }
    }

    public StatusType getStatusType() {
        return this.f71971g;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void init(Context context, AttributeSet attributeSet, int i11) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ExpandableTextView, i11, 0);
            this.f71975i = obtainStyledAttributes.getInt(R$styleable.ExpandableTextView_ep_max_line, 5);
            int i12 = obtainStyledAttributes.getInt(R$styleable.ExpandableTextView_ep_max_line_diff, 0);
            this.f71972g0 = i12;
            this.f71977j = this.f71975i - i12;
            this.f71991s = obtainStyledAttributes.getBoolean(R$styleable.ExpandableTextView_ep_need_expand, this.f71991s);
            this.K = obtainStyledAttributes.getString(R$styleable.ExpandableTextView_ep_expand_text);
            this.E = obtainStyledAttributes.getColor(R$styleable.ExpandableTextView_ep_expand_color, this.E);
            this.f71989q = obtainStyledAttributes.getBoolean(R$styleable.ExpandableTextView_ep_need_contract, this.f71989q);
            this.L = obtainStyledAttributes.getString(R$styleable.ExpandableTextView_ep_contract_text);
            this.I = obtainStyledAttributes.getColor(R$styleable.ExpandableTextView_ep_contract_color, this.I);
            this.M = obtainStyledAttributes.getString(R$styleable.ExpandableTextView_ep_end_text);
            this.N = obtainStyledAttributes.getColor(R$styleable.ExpandableTextView_ep_end_color, this.N);
            this.f72002y = obtainStyledAttributes.getBoolean(R$styleable.ExpandableTextView_ep_need_title, this.f72002y);
            this.J = obtainStyledAttributes.getColor(R$styleable.ExpandableTextView_ep_title_color, this.J);
            this.f71970f0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableTextView_ep_title_size, 16);
            this.f72000x = obtainStyledAttributes.getBoolean(R$styleable.ExpandableTextView_ep_need_self, this.f72000x);
            this.H = obtainStyledAttributes.getColor(R$styleable.ExpandableTextView_ep_self_color, this.H);
            this.f71994u = obtainStyledAttributes.getBoolean(R$styleable.ExpandableTextView_ep_need_mention, this.f71994u);
            this.F = obtainStyledAttributes.getColor(R$styleable.ExpandableTextView_ep_mention_color, this.F);
            this.f71996v = obtainStyledAttributes.getBoolean(R$styleable.ExpandableTextView_ep_need_link, this.f71996v);
            this.f71998w = obtainStyledAttributes.getBoolean(R$styleable.ExpandableTextView_ep_need_link_res, this.f71998w);
            this.G = obtainStyledAttributes.getColor(R$styleable.ExpandableTextView_ep_link_color, this.G);
            this.f71983m = getResources().getDrawable(obtainStyledAttributes.getResourceId(R$styleable.ExpandableTextView_ep_link_res, R$drawable.ic_expandable_link));
            this.A = obtainStyledAttributes.getBoolean(R$styleable.ExpandableTextView_ep_need_animation, this.A);
            this.f72004z = obtainStyledAttributes.getBoolean(R$styleable.ExpandableTextView_ep_need_always_showright, this.f72004z);
            this.f71992t = obtainStyledAttributes.getBoolean(R$styleable.ExpandableTextView_ep_need_convert_url, this.f71992t);
            this.Q = obtainStyledAttributes.getBoolean(R$styleable.ExpandableTextView_ep_need_show_arrow_icon, this.Q);
            this.V = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableTextView_ep_arrow_icon_width, this.V);
            this.W = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableTextView_ep_arrow_icon_height, this.W);
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.ExpandableTextView_ep_expand_arrow_res, this.T);
            this.T = resourceId;
            if (resourceId != 0) {
                Drawable drawable = getResources().getDrawable(this.T);
                this.R = drawable;
                drawable.setBounds(0, 0, this.V, this.W);
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.ExpandableTextView_ep_contract_arrow_res, this.U);
            this.U = resourceId2;
            if (resourceId2 != 0) {
                Drawable drawable2 = getResources().getDrawable(this.U);
                this.S = drawable2;
                drawable2.setBounds(0, 0, this.V, this.W);
            }
            this.f71960a0 = obtainStyledAttributes.getBoolean(R$styleable.ExpandableTextView_ep_need_prefix_mark_icon, this.f71960a0);
            this.f71966d0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableTextView_ep_prefix_mark_icon_width, this.f71966d0);
            this.f71968e0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableTextView_ep_prefix_mark_icon_height, this.f71968e0);
            int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.ExpandableTextView_ep_prefix_mark_icon_res, this.f71964c0);
            this.f71964c0 = resourceId3;
            if (resourceId3 != 0) {
                Drawable drawable3 = getResources().getDrawable(this.f71964c0);
                this.f71962b0 = drawable3;
                drawable3.setBounds(0, 0, this.f71966d0, this.f71968e0);
            }
            obtainStyledAttributes.recycle();
        } else {
            this.f71983m = context.getResources().getDrawable(R$drawable.ic_expandable_link);
        }
        this.f71967e = context;
        TextPaint paint = getPaint();
        this.f71963c = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        if (this.f71998w) {
            this.f71983m.setBounds(0, 0, 30, 30);
        } else {
            this.f71983m.setBounds(0, 0, 0, 0);
        }
    }

    public final List<String> matchLinkStringArrays(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<UrlParamTool.UrlResult> a11 = UrlParamTool.a(charSequence.toString());
        if (a11 != null && !a11.isEmpty()) {
            for (UrlParamTool.UrlResult urlResult : a11) {
                arrayList.add(urlResult.f72028a);
            }
        }
        return arrayList;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.f71978j0);
    }

    public void setContent(CharSequence charSequence, boolean z11) {
        this.D = charSequence;
        if (TextUtils.isEmpty(charSequence)) {
            setText("");
        } else if (z11) {
            post(new fa.d(this, charSequence));
        } else {
            doSetContent(charSequence, "setContent");
        }
    }

    public void setContractTextColor(int i11) {
        this.I = i11;
    }

    public void setCurrStatus(StatusType statusType) {
        this.f71971g = statusType;
        B((StatusType) null);
    }

    public void setEndExpendContent(String str) {
        this.M = str;
    }

    public void setExpandOrContractClickListener(g gVar) {
        this.f71988p = gVar;
    }

    public void setExpandTextColor(int i11) {
        this.E = i11;
    }

    public void setExpandableDefaultWidth(int i11) {
        this.f71981l = i11;
    }

    public void setExpandableLineCount(int i11) {
        this.B = i11;
    }

    public void setExpandableLinkTextColor(int i11) {
        this.G = i11;
    }

    public void setExpandableTextViewWidth(int i11) {
        this.f71979k = i11;
    }

    public void setLinkClickListener(i iVar) {
        this.f71985n = iVar;
    }

    public void setLinkDrawable(Drawable drawable) {
        this.f71983m = drawable;
    }

    public void setNeedAnimation(boolean z11) {
        this.A = z11;
    }

    public void setNeedContract(boolean z11) {
        this.f71989q = z11;
    }

    public void setNeedExpend(boolean z11) {
        this.f71991s = z11;
    }

    public void setNeedMention(boolean z11) {
        this.f71994u = z11;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f71976i0.a(onClickListener);
    }

    public void setOnExpandableContractChangedListener(fa.g gVar) {
        this.f71974h0 = gVar;
    }

    public void setOnGetLineCountListener(h hVar) {
        this.f71980k0 = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        this.f71976i0.b(onLongClickListener);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Spannable spannable;
        if (!this.f71996v || TextUtils.isEmpty(charSequence)) {
            super.setText(charSequence, bufferType);
            return;
        }
        if (charSequence instanceof Spannable) {
            spannable = (Spannable) charSequence;
        } else {
            spannable = new SpannableString(charSequence);
        }
        List<UrlParamTool.UrlResult> a11 = UrlParamTool.a(charSequence.toString());
        if (a11 != null && !a11.isEmpty()) {
            for (UrlParamTool.UrlResult next : a11) {
                TextLinkSpan textLinkSpan = new TextLinkSpan(next.f72028a);
                textLinkSpan.setLinkColor(this.G);
                spannable.setSpan(textLinkSpan, next.f72029b, next.f72030c, 33);
            }
        }
        super.setText(spannable, bufferType);
        setMovementMethod(new fa.f(matchLinkStringArrays(this.D)));
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71961b = 0;
        this.f71971g = D0;
        this.f71975i = 5;
        this.f71981l = 0;
        this.f71983m = null;
        this.f71987o = true;
        this.f71989q = true;
        this.f71991s = true;
        this.f71992t = false;
        this.f71994u = false;
        this.f71996v = true;
        this.f71998w = false;
        this.f72000x = false;
        this.f72002y = false;
        this.f72004z = false;
        this.A = true;
        this.C = "";
        this.E = Color.parseColor("#FFBE00");
        this.F = Color.parseColor("#FF9B00");
        this.G = Color.parseColor("#FF6200");
        this.H = Color.parseColor("#FF6200");
        this.I = Color.parseColor("#FFBE00");
        this.J = Color.parseColor("#1A1A1A");
        this.N = Color.parseColor("#999999");
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = null;
        this.S = null;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.f71960a0 = false;
        this.f71962b0 = null;
        this.f71964c0 = 0;
        this.f71966d0 = 0;
        this.f71968e0 = 0;
        this.f71972g0 = 0;
        this.f71978j0 = new a();
        this.f71982l0 = false;
        this.f71984m0 = "";
        this.f71986n0 = 12;
        this.f71993t0 = (float) PixelUtils.a(10.0f);
        this.f71995u0 = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.f71997v0 = 0;
        this.f71999w0 = null;
        this.f72001x0 = 0;
        this.f72003y0 = 0;
        this.f72005z0 = 0;
        this.A0 = 0;
        init(context, attributeSet, i11);
        CommentTextViewTouchListener commentTextViewTouchListener = new CommentTextViewTouchListener();
        this.f71976i0 = commentTextViewTouchListener;
        setOnTouchListener(commentTextViewTouchListener);
        getViewTreeObserver().addOnPreDrawListener(this.f71978j0);
    }
}
