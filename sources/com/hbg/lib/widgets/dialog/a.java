package com.hbg.lib.widgets.dialog;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import z9.g;
import z9.h;
import z9.i;
import z9.j;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Float f71877a;

    /* renamed from: b  reason: collision with root package name */
    public final Float f71878b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f71879c;

    /* renamed from: d  reason: collision with root package name */
    public Context f71880d;

    /* renamed from: e  reason: collision with root package name */
    public String f71881e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f71882f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f71883g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f71884h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f71885i;

    /* renamed from: j  reason: collision with root package name */
    public String f71886j;

    /* renamed from: k  reason: collision with root package name */
    public SpannableStringBuilder f71887k;

    /* renamed from: l  reason: collision with root package name */
    public Float f71888l;

    /* renamed from: m  reason: collision with root package name */
    public Integer f71889m;

    /* renamed from: n  reason: collision with root package name */
    public String f71890n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f71891o;

    /* renamed from: p  reason: collision with root package name */
    public Integer f71892p;

    /* renamed from: q  reason: collision with root package name */
    public String f71893q;

    /* renamed from: r  reason: collision with root package name */
    public String f71894r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f71895s;

    /* renamed from: t  reason: collision with root package name */
    public Integer f71896t;

    /* renamed from: u  reason: collision with root package name */
    public Integer f71897u;

    /* renamed from: v  reason: collision with root package name */
    public Integer f71898v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f71899w;

    /* renamed from: x  reason: collision with root package name */
    public d f71900x;

    /* renamed from: y  reason: collision with root package name */
    public d f71901y;

    /* renamed from: z  reason: collision with root package name */
    public c f71902z;

    /* renamed from: com.hbg.lib.widgets.dialog.a$a  reason: collision with other inner class name */
    public class C0792a implements HBDialogFragment.a {
        public C0792a() {
        }

        @SensorsDataInstrumented
        public static /* synthetic */ void f(Button button, CompoundButton compoundButton, boolean z11) {
            button.setEnabled(z11);
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void g(CompoundButton compoundButton, boolean z11) {
            a.this.f71902z.a(z11);
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void h(CheckBox checkBox, HBDialogFragment hBDialogFragment, View view) {
            if (!a.this.f71884h) {
                a.this.f71901y.a(hBDialogFragment);
            } else if (checkBox.isChecked()) {
                a.this.f71901y.a(hBDialogFragment);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void i(HBDialogFragment hBDialogFragment, View view) {
            a.this.f71900x.a(hBDialogFragment);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void a(View view, HBDialogFragment hBDialogFragment) {
            TextView textView = (TextView) view.findViewById(R$id.dialog_title);
            CheckBox checkBox = (CheckBox) view.findViewById(R$id.agreement_cb);
            Button button = (Button) view.findViewById(R$id.dialog_cancel_btn);
            Button button2 = (Button) view.findViewById(R$id.dialog_confirm_btn);
            TextView textView2 = (TextView) view.findViewById(R$id.agreement_tv);
            TextView textView3 = (TextView) view.findViewById(R$id.agreement_content_tv);
            if (!a.this.f71882f || TextUtils.isEmpty(a.this.f71881e)) {
                textView.setVisibility(8);
            } else {
                textView.setText(a.this.f71881e);
                if (a.this.f71879c) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                }
                if (a.this.f71883g != null) {
                    textView.setGravity(a.this.f71883g.intValue());
                }
                if (a.this.f71897u != null) {
                    textView.setTextColor(a.this.f71897u.intValue());
                }
                if (a.this.f71877a != null) {
                    textView.setTextSize(1, a.this.f71877a.floatValue());
                }
            }
            if (a.this.f71884h) {
                checkBox.setVisibility(0);
            } else {
                checkBox.setVisibility(8);
            }
            checkBox.setChecked(a.this.f71885i);
            checkBox.setOnCheckedChangeListener(new i(button2));
            button2.setEnabled(false);
            if (!a.this.f71891o || TextUtils.isEmpty(a.this.f71890n)) {
                textView3.setVisibility(8);
            } else {
                textView3.setText(a.this.f71890n);
                if (a.this.f71892p != null) {
                    textView3.setGravity(a.this.f71892p.intValue());
                }
                if (a.this.f71898v != null) {
                    textView3.setTextColor(a.this.f71898v.intValue());
                }
                if (a.this.f71878b != null) {
                    textView3.setTextSize(1, a.this.f71878b.floatValue());
                }
            }
            if (!a.this.f71895s) {
                button.setVisibility(8);
            } else if (!TextUtils.isEmpty(a.this.f71894r)) {
                button.setText(a.this.f71894r);
            }
            if (!TextUtils.isEmpty(a.this.f71893q)) {
                button2.setText(a.this.f71893q);
            }
            if (a.this.f71896t != null) {
                button2.setTextColor(a.this.f71896t.intValue());
            }
            if (a.this.f71889m != null) {
                textView2.setTextColor(a.this.f71889m.intValue());
            }
            if (a.this.f71888l != null) {
                textView2.setTextSize(1, a.this.f71888l.floatValue());
            }
            if (a.this.f71902z != null) {
                checkBox.setOnCheckedChangeListener(new j(this));
            }
            if (!TextUtils.isEmpty(a.this.f71886j)) {
                textView2.setText(a.this.f71886j);
            } else if (a.this.f71887k != null) {
                textView2.setText(a.this.f71887k);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                textView2.setHighlightColor(ContextCompat.getColor(a.this.f71880d, 17170445));
            }
            if (a.this.f71901y != null) {
                button2.setOnClickListener(new g(this, checkBox, hBDialogFragment));
            }
            if (a.this.f71900x != null) {
                button.setOnClickListener(new h(this, hBDialogFragment));
            }
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f71904a = true;

        /* renamed from: b  reason: collision with root package name */
        public boolean f71905b;

        /* renamed from: c  reason: collision with root package name */
        public String f71906c;

        /* renamed from: d  reason: collision with root package name */
        public SpannableStringBuilder f71907d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f71908e;

        /* renamed from: f  reason: collision with root package name */
        public Float f71909f;

        /* renamed from: g  reason: collision with root package name */
        public Context f71910g;

        /* renamed from: h  reason: collision with root package name */
        public String f71911h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f71912i = true;

        /* renamed from: j  reason: collision with root package name */
        public boolean f71913j = false;

        /* renamed from: k  reason: collision with root package name */
        public Integer f71914k;

        /* renamed from: l  reason: collision with root package name */
        public Float f71915l;

        /* renamed from: m  reason: collision with root package name */
        public Integer f71916m;

        /* renamed from: n  reason: collision with root package name */
        public String f71917n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f71918o = true;

        /* renamed from: p  reason: collision with root package name */
        public Float f71919p;

        /* renamed from: q  reason: collision with root package name */
        public Integer f71920q;

        /* renamed from: r  reason: collision with root package name */
        public String f71921r;

        /* renamed from: s  reason: collision with root package name */
        public Integer f71922s;

        /* renamed from: t  reason: collision with root package name */
        public String f71923t;

        /* renamed from: u  reason: collision with root package name */
        public boolean f71924u = true;

        /* renamed from: v  reason: collision with root package name */
        public Integer f71925v;

        /* renamed from: w  reason: collision with root package name */
        public boolean f71926w = false;

        /* renamed from: x  reason: collision with root package name */
        public d f71927x;

        /* renamed from: y  reason: collision with root package name */
        public d f71928y;

        /* renamed from: z  reason: collision with root package name */
        public c f71929z;

        public b(Context context) {
            this.f71910g = context;
        }

        public HBDialogFragment A() {
            return new a(this, (C0792a) null).A();
        }

        public b B(boolean z11) {
            this.f71924u = z11;
            return this;
        }

        public b C(boolean z11) {
            this.f71904a = z11;
            return this;
        }

        public b D(SpannableStringBuilder spannableStringBuilder) {
            this.f71907d = spannableStringBuilder;
            return this;
        }

        public b E(String str) {
            this.f71917n = str;
            return this;
        }

        public b F(d dVar) {
            this.f71928y = dVar;
            return this;
        }

        public b G(String str) {
            this.f71911h = str;
            return this;
        }
    }

    public interface c {
        void a(boolean z11);
    }

    public interface d {
        void a(HBDialogFragment hBDialogFragment);
    }

    public /* synthetic */ a(b bVar, C0792a aVar) {
        this(bVar);
    }

    public final HBDialogFragment A() {
        if (this.f71880d == null) {
            return null;
        }
        HBDialogFragment uh2 = HBDialogFragment.uh(R$layout.dialog_common_agreement, new C0792a());
        uh2.setCancelable(this.f71899w);
        return uh2;
    }

    public a(b bVar) {
        this.f71880d = bVar.f71910g;
        this.f71881e = bVar.f71911h;
        this.f71882f = bVar.f71912i;
        this.f71879c = bVar.f71913j;
        this.f71883g = bVar.f71914k;
        this.f71890n = bVar.f71917n;
        this.f71891o = bVar.f71918o;
        this.f71893q = bVar.f71921r;
        this.f71894r = bVar.f71923t;
        this.f71895s = bVar.f71924u;
        this.f71896t = bVar.f71922s;
        this.f71897u = bVar.f71916m;
        this.f71898v = bVar.f71920q;
        this.f71899w = bVar.f71926w;
        this.f71892p = bVar.f71925v;
        this.f71900x = bVar.f71927x;
        this.f71901y = bVar.f71928y;
        this.f71877a = bVar.f71915l;
        this.f71878b = bVar.f71919p;
        this.f71884h = bVar.f71904a;
        this.f71885i = bVar.f71905b;
        this.f71889m = bVar.f71908e;
        this.f71888l = bVar.f71909f;
        this.f71886j = bVar.f71906c;
        this.f71887k = bVar.f71907d;
        this.f71902z = bVar.f71929z;
    }
}
