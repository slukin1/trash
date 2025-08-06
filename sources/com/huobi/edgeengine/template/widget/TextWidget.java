package com.huobi.edgeengine.template.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huobi.edgeengine.util.IdentifierUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rj.n;

public class TextWidget extends Widget {
    public String A0;
    public String B0;
    public float C0;
    public boolean D0;

    /* renamed from: h0  reason: collision with root package name */
    public String f44103h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f44104i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f44105j0;

    /* renamed from: k0  reason: collision with root package name */
    public String f44106k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f44107l0;

    /* renamed from: m0  reason: collision with root package name */
    public String f44108m0;

    /* renamed from: n0  reason: collision with root package name */
    public int f44109n0 = 8;

    /* renamed from: o0  reason: collision with root package name */
    public int f44110o0 = -1;

    /* renamed from: p0  reason: collision with root package name */
    public String f44111p0;

    /* renamed from: q0  reason: collision with root package name */
    public int f44112q0;

    /* renamed from: r0  reason: collision with root package name */
    public int f44113r0;

    /* renamed from: s0  reason: collision with root package name */
    public String f44114s0;

    /* renamed from: t0  reason: collision with root package name */
    public String f44115t0;

    /* renamed from: u0  reason: collision with root package name */
    public String f44116u0;

    /* renamed from: v0  reason: collision with root package name */
    public String f44117v0;

    /* renamed from: w0  reason: collision with root package name */
    public String f44118w0;

    /* renamed from: x0  reason: collision with root package name */
    public String f44119x0;

    /* renamed from: y0  reason: collision with root package name */
    public String f44120y0;

    /* renamed from: z0  reason: collision with root package name */
    public Map<Integer, String> f44121z0 = new HashMap();

    public class a extends b {
        public a(View view) {
            super(view);
        }

        public void b(View view, String str) {
            TextView textView = (TextView) view;
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt > 0) {
                    textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(parseInt)});
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class b extends c<TextView> {
        public b(TextView textView) {
            super(textView);
        }

        /* renamed from: c */
        public void b(TextView textView, String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (str.startsWith("#")) {
                        textView.setTextColor(Color.parseColor(str));
                        return;
                    }
                    textView.setTextColor(ContextCompat.getColor(textView.getContext(), IdentifierUtil.a(textView.getContext(), str, "color")));
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class c extends c<TextView> {

        public class a extends c<TextView> {
            public a(TextView textView) {
                super(textView);
            }

            /* renamed from: c */
            public void b(TextView textView, String str) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (str.startsWith("#")) {
                            textView.setTextColor(Color.parseColor(str));
                            return;
                        }
                        textView.setTextColor(ContextCompat.getColor(textView.getContext(), IdentifierUtil.a(textView.getContext(), str, "color")));
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        public c(TextView textView) {
            super(textView);
        }

        /* renamed from: c */
        public void b(TextView textView, String str) {
            TextWidget.this.u(str, new a(textView));
        }
    }

    public class d extends b {
        public d(View view) {
            super(view);
        }

        public void b(View view, String str) {
            try {
                if (str.startsWith("#")) {
                    ((TextView) view).setHintTextColor(Color.parseColor(str));
                    return;
                }
                ((TextView) view).setHintTextColor(ContextCompat.getColor(view.getContext(), IdentifierUtil.a(view.getContext(), str, "color")));
            } catch (Throwable unused) {
            }
        }
    }

    public class e extends b {
        public e(View view) {
            super(view);
        }

        public void b(View view, String str) {
            try {
                ((TextView) view).setHintTextColor(Color.parseColor(str));
            } catch (Throwable unused) {
            }
        }
    }

    public class f extends c<TextView> {
        public f(TextView textView) {
            super(textView);
        }

        /* renamed from: c */
        public void b(TextView textView, String str) {
            try {
                TextWidget textWidget = TextWidget.this;
                int unused = textWidget.f44112q0 = textWidget.A(textView.getContext(), Float.parseFloat(str));
                textView.setTextSize(0, (float) TextWidget.this.f44112q0);
            } catch (Throwable unused2) {
            }
        }
    }

    public class g extends b {
        public g(View view) {
            super(view);
        }

        public void b(View view, String str) {
            try {
                ((TextView) view).setLineSpacing(TextWidget.this.B(view.getContext(), Float.parseFloat(str)) + 2.0f, 1.0f);
            } catch (Throwable unused) {
            }
        }
    }

    public class h extends b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ rj.n f44130b;

        public class a extends NoUnderLineClickableSpan {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ URLSpan f44132b;

            public a(URLSpan uRLSpan) {
                this.f44132b = uRLSpan;
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                if (!TextWidget.this.z(this.f44132b.getURL(), h.this.f44130b)) {
                    this.f44132b.onClick(view);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(View view, rj.n nVar) {
            super(view);
            this.f44130b = nVar;
        }

        public void b(View view, String str) {
            String str2 = str;
            Spanned a11 = z0.a.a(str2, 63);
            SpannableString spannableString = new SpannableString(a11);
            String spannableString2 = spannableString.toString();
            int indexOf = str2.indexOf("<span");
            int i11 = 0;
            int i12 = 0;
            while (indexOf >= 0) {
                int indexOf2 = str2.indexOf("</span>", indexOf) + 7;
                if (indexOf2 > indexOf) {
                    String substring = str2.substring(indexOf, indexOf2);
                    String Z = TextWidget.this.g0(substring);
                    String a02 = TextWidget.this.f0(substring, "style");
                    if (a02 != null) {
                        String[] split = a02.split(";");
                        int length = split.length;
                        int i13 = i11;
                        while (true) {
                            if (i13 >= length) {
                                break;
                            }
                            String[] split2 = split[i13].split(":");
                            if (split2.length == 2) {
                                String trim = split2[i11].trim();
                                String trim2 = split2[1].trim();
                                if (trim.equals("font-size")) {
                                    if (trim2.endsWith("px")) {
                                        int parseInt = Integer.parseInt(trim2.substring(0, trim2.length() - 2));
                                        int indexOf3 = spannableString2.indexOf(Z, i12);
                                        int length2 = Z.length() + indexOf3;
                                        int i14 = length2 - 1;
                                        try {
                                            spannableString.setSpan(new AbsoluteSizeSpan(parseInt, true), indexOf3, length2, 33);
                                        } catch (Throwable th2) {
                                            Log.e("EdgeEngine.Widget", "富文本 处理失败:" + Z + ",htmlString:" + str2);
                                            String message = th2.getMessage();
                                            Objects.requireNonNull(message);
                                            Log.e("EdgeEngine.Widget", message);
                                        }
                                        i12 = i14;
                                    }
                                }
                            }
                            i13++;
                            i11 = 0;
                        }
                    }
                }
                indexOf = str2.indexOf("<span", indexOf2);
                i11 = 0;
            }
            if (str2.contains("<a href=")) {
                for (URLSpan uRLSpan : (URLSpan[]) spannableString.getSpans(0, a11.length(), URLSpan.class)) {
                    spannableString.setSpan(new a(uRLSpan), spannableString.getSpanStart(uRLSpan), spannableString.getSpanEnd(uRLSpan), spannableString.getSpanFlags(uRLSpan));
                    spannableString.removeSpan(uRLSpan);
                }
                ((TextView) view).setMovementMethod(LinkMovementMethod.getInstance());
            }
            ((TextView) view).setText(spannableString);
        }
    }

    public class i extends c<TextView> {
        public i(TextView textView) {
            super(textView);
        }

        /* renamed from: c */
        public void b(TextView textView, String str) {
            textView.setText(str);
            if (textView instanceof EditText) {
                try {
                    ((EditText) textView).setSelection(str.length());
                } catch (Throwable th2) {
                    Log.w("EdgeEngine.Widget", th2);
                }
            }
        }
    }

    public class j extends yj.i<TextView> {
        public j(TextView textView) {
            super(textView);
        }

        /* renamed from: b */
        public void a(TextView textView, Object obj) {
            if (obj != null) {
                textView.setText(obj.toString());
                if (textView instanceof EditText) {
                    try {
                        ((EditText) textView).setSelection(obj.toString().length());
                    } catch (Throwable th2) {
                        Log.w("EdgeEngine.Widget", th2);
                    }
                }
            }
        }
    }

    public class k implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n.c f44136b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f44137c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f44138d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ rj.n f44139e;

        public k(n.c cVar, int i11, TextView textView, rj.n nVar) {
            this.f44136b = cVar;
            this.f44137c = i11;
            this.f44138d = textView;
            this.f44139e = nVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(String str, int i11, TextView textView, n.c cVar, rj.n nVar, String str2) {
            if (!TextUtils.equals(str, str2)) {
                TextWidget.this.f44121z0.put(Integer.valueOf(i11), str2);
                textView.setText(str2);
                if (textView instanceof EditText) {
                    ((EditText) textView).setSelection(str2.length());
                }
            }
            String replaceAll = str2.replaceAll("\\\\", "\\\\\\\\");
            String b02 = TextWidget.this.f44119x0;
            String replace = b02.replace("@eventParams", "'" + replaceAll + "'");
            if (cVar != null) {
                cVar.a(replaceAll);
            }
            TextWidget.this.z(replace, nVar);
        }

        public void afterTextChanged(Editable editable) {
            CharSequence charSequence;
            if (TextUtils.isEmpty(TextWidget.this.f44119x0)) {
                n.c cVar = this.f44136b;
                if (cVar != null) {
                    cVar.a(editable.toString());
                    return;
                }
                return;
            }
            String obj = editable.toString();
            if (!TextUtils.equals(obj, (String) TextWidget.this.f44121z0.get(Integer.valueOf(this.f44137c)))) {
                TextWidget.this.f44121z0.put(Integer.valueOf(this.f44137c), obj);
                if (TextUtils.isEmpty(TextWidget.this.f44120y0) || !TextWidget.this.f44120y0.startsWith("@dataParser.")) {
                    String replaceAll = obj.replaceAll("\\\\", "\\\\\\\\");
                    String b02 = TextWidget.this.f44119x0;
                    String replace = b02.replace("@eventParams", "'" + replaceAll + "'");
                    n.c cVar2 = this.f44136b;
                    if (cVar2 != null) {
                        cVar2.a(replaceAll);
                    }
                    TextWidget.this.z(replace, this.f44139e);
                    return;
                }
                int indexOf = TextWidget.this.f44120y0.indexOf(40);
                int indexOf2 = TextWidget.this.f44120y0.indexOf(41);
                boolean z11 = false;
                if (indexOf <= 0 || indexOf <= 12 || indexOf >= indexOf2) {
                    charSequence = "@eventParams";
                } else {
                    TextWidget textWidget = TextWidget.this;
                    rj.b bVar = textWidget.f44152d0;
                    String substring = textWidget.f44120y0.substring(12, indexOf);
                    TextWidget textWidget2 = TextWidget.this;
                    List d02 = textWidget2.h0(textWidget2.f44120y0.substring(indexOf + 1, indexOf2), obj);
                    charSequence = "@eventParams";
                    yj.h hVar = r0;
                    yj.h hVar2 = new yj.h(this, obj, this.f44137c, this.f44138d, this.f44136b, this.f44139e);
                    z11 = bVar.o(substring, d02, hVar);
                }
                if (!z11) {
                    String replaceAll2 = obj.replaceAll("\\\\", "\\\\\\\\");
                    String b03 = TextWidget.this.f44119x0;
                    String replace2 = b03.replace(charSequence, "'" + replaceAll2 + "'");
                    n.c cVar3 = this.f44136b;
                    if (cVar3 != null) {
                        cVar3.a(replaceAll2);
                    }
                    TextWidget.this.z(replace2, this.f44139e);
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class l extends b {
        public l(View view) {
            super(view);
        }

        public void b(View view, String str) {
            ((TextView) view).setHint(str);
        }
    }

    public class m extends b {
        public m(View view) {
            super(view);
        }

        public void b(View view, String str) {
            TextView textView = (TextView) view;
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt == 0) {
                    parseInt = Integer.MAX_VALUE;
                }
                textView.setMaxLines(parseInt);
            } catch (Throwable unused) {
                textView.setMaxLines(1);
            }
        }
    }

    public class n extends b {
        public n(View view) {
            super(view);
        }

        public void b(View view, String str) {
            TextView textView = (TextView) view;
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt == 0) {
                    parseInt = Integer.MAX_VALUE;
                }
                textView.setLines(parseInt);
            } catch (Throwable unused) {
                textView.setLines(1);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|(2:5|6)|7|(2:9|10)|11|(3:13|14|16)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x00a7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x00ad */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void C(android.content.Context r5, java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r4 = this;
            super.C(r5, r6)
            java.lang.String r0 = "text"
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r4.f44103h0 = r0
            java.lang.String r0 = "richText"
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r4.f44105j0 = r0
            java.lang.String r0 = "bindText"
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r4.f44104i0 = r0
            java.lang.String r0 = "hint"
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r4.f44115t0 = r0
            java.lang.String r0 = "textColor"
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r4.f44106k0 = r0
            java.lang.String r0 = "textColorHint"
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r4.f44107l0 = r0
            java.lang.String r0 = "autoSizeTextType"
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r4.f44108m0 = r0
            java.lang.String r0 = "textFontWeight"
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "textSize"
            java.lang.Object r1 = r6.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r4.f44111p0 = r1
            java.lang.String r1 = "autoSizeMinTextSize"
            java.lang.Object r1 = r6.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "maxWidth"
            java.lang.Object r2 = r6.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "maxLength"
            java.lang.Object r3 = r6.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r4.f44114s0 = r3
            java.lang.String r3 = "maxLines"
            java.lang.Object r3 = r6.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r4.f44116u0 = r3
            java.lang.String r3 = "lines"
            java.lang.Object r3 = r6.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r4.f44117v0 = r3
            java.lang.String r3 = "singleLine"
            java.lang.Object r3 = r6.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r4.f44118w0 = r3
            java.lang.String r3 = "onTextChange"
            java.lang.Object r3 = r6.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r4.f44119x0 = r3
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ Exception -> 0x00a7 }
            int r2 = r4.A(r5, r2)     // Catch:{ Exception -> 0x00a7 }
            r4.f44113r0 = r2     // Catch:{ Exception -> 0x00a7 }
        L_0x00a7:
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x00ad }
            r4.f44110o0 = r0     // Catch:{ Exception -> 0x00ad }
        L_0x00ad:
            float r0 = java.lang.Float.parseFloat(r1)     // Catch:{ Exception -> 0x00b7 }
            int r5 = r4.A(r5, r0)     // Catch:{ Exception -> 0x00b7 }
            r4.f44109n0 = r5     // Catch:{ Exception -> 0x00b7 }
        L_0x00b7:
            java.lang.String r5 = "lineSpacing"
            java.lang.Object r5 = r6.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            r4.A0 = r5
            java.lang.String r5 = "ellipsis"
            java.lang.Object r5 = r6.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            r4.B0 = r5
            java.lang.String r5 = "letterSpacing"
            java.lang.Object r5 = r6.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            float r5 = java.lang.Float.parseFloat(r5)     // Catch:{ Exception -> 0x00d9 }
            r4.C0 = r5     // Catch:{ Exception -> 0x00d9 }
        L_0x00d9:
            java.lang.String r5 = "true"
            java.lang.String r0 = "isSubscript"
            java.lang.Object r6 = r6.get(r0)     // Catch:{ all -> 0x00e7 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x00e7 }
            r4.D0 = r5     // Catch:{ all -> 0x00e7 }
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.template.widget.TextWidget.C(android.content.Context, java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View Q(android.content.Context r12, rj.n r13) {
        /*
            r11 = this;
            android.view.View r0 = super.Q(r12, r13)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r4 = r0.hashCode()
            java.lang.String r1 = r11.f44111p0
            com.huobi.edgeengine.template.widget.TextWidget$f r2 = new com.huobi.edgeengine.template.widget.TextWidget$f
            r2.<init>(r0)
            r11.w(r12, r1, r2, r13)
            r7 = 1
            r0.setMaxLines(r7)
            java.lang.String r1 = r11.B0
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L_0x0033
            java.lang.String r1 = r11.B0
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            if (r1 == 0) goto L_0x002f
            android.text.TextUtils$TruncateAt r1 = android.text.TextUtils.TruncateAt.END
            r0.setEllipsize(r1)
            goto L_0x0038
        L_0x002f:
            r0.setEllipsize(r2)
            goto L_0x0038
        L_0x0033:
            android.text.TextUtils$TruncateAt r1 = android.text.TextUtils.TruncateAt.END
            r0.setEllipsize(r1)
        L_0x0038:
            int r1 = r11.f44113r0
            if (r1 <= 0) goto L_0x003f
            r0.setMaxWidth(r1)
        L_0x003f:
            java.lang.String r1 = r11.E
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r8 = 0
            if (r1 != 0) goto L_0x00c5
            java.lang.String r1 = r11.E
            java.lang.String r3 = "\\|"
            java.lang.String[] r1 = r1.split(r3)
            int r3 = r1.length
            r5 = r8
            r6 = r5
        L_0x0053:
            if (r5 >= r3) goto L_0x00c0
            r9 = r1[r5]
            java.lang.String r10 = "center"
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x0062
            r6 = r6 | 17
            goto L_0x00bd
        L_0x0062:
            java.lang.String r10 = "top"
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x006d
            r6 = r6 | 48
            goto L_0x00bd
        L_0x006d:
            java.lang.String r10 = "bottom"
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x0078
            r6 = r6 | 80
            goto L_0x00bd
        L_0x0078:
            java.lang.String r10 = "left"
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x0083
            r6 = r6 | 3
            goto L_0x00bd
        L_0x0083:
            java.lang.String r10 = "right"
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x008e
            r6 = r6 | 5
            goto L_0x00bd
        L_0x008e:
            java.lang.String r10 = "centerVertical"
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x0099
            r6 = r6 | 16
            goto L_0x00bd
        L_0x0099:
            java.lang.String r10 = "centerHorizontal"
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x00a4
            r6 = r6 | 1
            goto L_0x00bd
        L_0x00a4:
            java.lang.String r10 = "start"
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x00b1
            r9 = 8388611(0x800003, float:1.1754948E-38)
        L_0x00af:
            r6 = r6 | r9
            goto L_0x00bd
        L_0x00b1:
            java.lang.String r10 = "end"
            boolean r9 = r10.equals(r9)
            if (r9 == 0) goto L_0x00bd
            r9 = 8388613(0x800005, float:1.175495E-38)
            goto L_0x00af
        L_0x00bd:
            int r5 = r5 + 1
            goto L_0x0053
        L_0x00c0:
            if (r6 == 0) goto L_0x00c5
            r0.setGravity(r6)
        L_0x00c5:
            java.lang.String r1 = r11.f44118w0
            java.lang.String r3 = "true"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x00d2
            r0.setSingleLine()
        L_0x00d2:
            java.lang.String r1 = r11.A0
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00e4
            java.lang.String r1 = r11.A0
            com.huobi.edgeengine.template.widget.TextWidget$g r3 = new com.huobi.edgeengine.template.widget.TextWidget$g
            r3.<init>(r0)
            r11.w(r12, r1, r3, r13)
        L_0x00e4:
            float r1 = r11.C0
            r3 = 0
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00ee
            r0.setLetterSpacing(r1)
        L_0x00ee:
            int r1 = r11.f44110o0
            r3 = -1
            if (r1 <= r3) goto L_0x011a
            android.graphics.Typeface r1 = r0.getTypeface()
            int r3 = android.os.Build.VERSION.SDK_INT
            r5 = 28
            if (r3 < r5) goto L_0x011a
            int r3 = r11.f44110o0
            r5 = 400(0x190, float:5.6E-43)
            if (r3 > r5) goto L_0x0106
            r11.f44110o0 = r5
            goto L_0x0111
        L_0x0106:
            r5 = 700(0x2bc, float:9.81E-43)
            if (r3 > r5) goto L_0x010d
            r11.f44110o0 = r5
            goto L_0x0111
        L_0x010d:
            r3 = 900(0x384, float:1.261E-42)
            r11.f44110o0 = r3
        L_0x0111:
            int r3 = r11.f44110o0
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r3, r8)
            r0.setTypeface(r1)
        L_0x011a:
            java.lang.String r1 = r11.f44105j0
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x012d
            java.lang.String r1 = r11.f44105j0
            com.huobi.edgeengine.template.widget.TextWidget$h r3 = new com.huobi.edgeengine.template.widget.TextWidget$h
            r3.<init>(r0, r13)
            r11.w(r12, r1, r3, r13)
            goto L_0x0155
        L_0x012d:
            java.lang.String r1 = r11.f44103h0
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0140
            java.lang.String r1 = r11.f44103h0
            com.huobi.edgeengine.template.widget.TextWidget$i r3 = new com.huobi.edgeengine.template.widget.TextWidget$i
            r3.<init>(r0)
            r11.w(r12, r1, r3, r13)
            goto L_0x0155
        L_0x0140:
            java.lang.String r1 = r11.f44104i0
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0155
            java.lang.String r1 = r11.f44104i0
            com.huobi.edgeengine.template.widget.TextWidget$j r2 = new com.huobi.edgeengine.template.widget.TextWidget$j
            r2.<init>(r0)
            rj.n$c r1 = r11.p(r13, r1, r2)
            r3 = r1
            goto L_0x0156
        L_0x0155:
            r3 = r2
        L_0x0156:
            com.huobi.edgeengine.template.widget.TextWidget$k r9 = new com.huobi.edgeengine.template.widget.TextWidget$k
            r1 = r9
            r2 = r11
            r5 = r0
            r6 = r13
            r1.<init>(r3, r4, r5, r6)
            r0.addTextChangedListener(r9)
            java.lang.String r1 = r11.f44115t0
            com.huobi.edgeengine.template.widget.TextWidget$l r2 = new com.huobi.edgeengine.template.widget.TextWidget$l
            r2.<init>(r0)
            r11.w(r12, r1, r2, r13)
            java.lang.String r1 = r11.f44116u0
            com.huobi.edgeengine.template.widget.TextWidget$m r2 = new com.huobi.edgeengine.template.widget.TextWidget$m
            r2.<init>(r0)
            r11.w(r12, r1, r2, r13)
            java.lang.String r1 = r11.f44117v0
            com.huobi.edgeengine.template.widget.TextWidget$n r2 = new com.huobi.edgeengine.template.widget.TextWidget$n
            r2.<init>(r0)
            r11.w(r12, r1, r2, r13)
            java.lang.String r1 = r11.f44114s0
            com.huobi.edgeengine.template.widget.TextWidget$a r2 = new com.huobi.edgeengine.template.widget.TextWidget$a
            r2.<init>(r0)
            r11.w(r12, r1, r2, r13)
            java.lang.String r1 = r11.f44108m0
            java.lang.String r2 = "uniform"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x019d
            int r1 = r11.f44112q0
            int r2 = r11.f44109n0
            if (r1 <= r2) goto L_0x019d
            androidx.core.widget.l.j(r0, r2, r1, r7, r8)
        L_0x019d:
            java.lang.String r1 = r11.f44106k0
            com.huobi.edgeengine.template.widget.TextWidget$b r2 = new com.huobi.edgeengine.template.widget.TextWidget$b
            r2.<init>(r0)
            boolean r1 = r11.u(r1, r2)
            if (r1 != 0) goto L_0x01b4
            java.lang.String r1 = r11.f44106k0
            com.huobi.edgeengine.template.widget.TextWidget$c r2 = new com.huobi.edgeengine.template.widget.TextWidget$c
            r2.<init>(r0)
            r11.w(r12, r1, r2, r13)
        L_0x01b4:
            java.lang.String r1 = r11.f44107l0
            com.huobi.edgeengine.template.widget.TextWidget$d r2 = new com.huobi.edgeengine.template.widget.TextWidget$d
            r2.<init>(r0)
            boolean r1 = r11.u(r1, r2)
            if (r1 != 0) goto L_0x01cb
            java.lang.String r1 = r11.f44107l0
            com.huobi.edgeengine.template.widget.TextWidget$e r2 = new com.huobi.edgeengine.template.widget.TextWidget$e
            r2.<init>(r0)
            r11.w(r12, r1, r2, r13)
        L_0x01cb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.template.widget.TextWidget.Q(android.content.Context, rj.n):android.view.View");
    }

    /* renamed from: e0 */
    public TextView q(Context context) {
        if (this.D0) {
            try {
                return (TextView) Class.forName("com.hbg.lib.widgets.SubscriptTextView").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return new TextView(context);
    }

    public final String f0(String str, String str2) {
        Matcher matcher = Pattern.compile(str2 + "\\s*?=\\s*?[\"'](.*?)[\"']").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public final String g0(String str) {
        Matcher matcher = Pattern.compile("<span.*?>" + "(.*?)" + "</span>").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public final List<String> h0(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (String str3 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if ("@eventParams".equals(str3)) {
                arrayList.add(str2);
            } else if (str3.startsWith("@data.")) {
                rj.b bVar = this.f44152d0;
                arrayList.add(bVar == null ? "" : bVar.e(str3.substring(6)));
            } else {
                arrayList.add(str3);
            }
        }
        return arrayList;
    }
}
