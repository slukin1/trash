package com.huobi.otc.helper;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$font;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$style;
import com.hbg.lib.widgets.input.ClearEditText;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import jp.n;
import jp.o;
import jp.p;
import jp.q;
import jp.r;
import jp.s;
import jp.t;
import jp.u;

@Deprecated
public class OtcDialogUtils {

    @Deprecated
    public static class b {
        public Integer A;
        public Integer B;
        public String C;
        public boolean D;
        public Integer E;
        public Integer F;
        public Integer G;
        public Float H;
        public boolean I;
        public Integer J;
        public String K;
        public String L;
        public String M;
        public boolean N;
        public Integer O;
        public Integer P;
        public Integer Q;
        public Integer R;
        public String S;
        public boolean T;
        public Integer U;
        public Integer V;
        public Integer W;
        public Integer X;
        public d Y;
        public d Z;

        /* renamed from: a  reason: collision with root package name */
        public final Float f78790a;

        /* renamed from: a0  reason: collision with root package name */
        public d f78791a0;

        /* renamed from: b  reason: collision with root package name */
        public final Float f78792b;

        /* renamed from: b0  reason: collision with root package name */
        public d f78793b0;

        /* renamed from: c  reason: collision with root package name */
        public final Float f78794c;

        /* renamed from: c0  reason: collision with root package name */
        public d f78795c0;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f78796d;

        /* renamed from: d0  reason: collision with root package name */
        public c f78797d0;

        /* renamed from: e  reason: collision with root package name */
        public boolean f78798e;

        /* renamed from: e0  reason: collision with root package name */
        public d f78799e0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f78800f;

        /* renamed from: f0  reason: collision with root package name */
        public Button f78801f0;

        /* renamed from: g  reason: collision with root package name */
        public Context f78802g;

        /* renamed from: h  reason: collision with root package name */
        public int f78803h;

        /* renamed from: i  reason: collision with root package name */
        public int f78804i;

        /* renamed from: j  reason: collision with root package name */
        public String f78805j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f78806k;

        /* renamed from: l  reason: collision with root package name */
        public Integer f78807l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f78808m;

        /* renamed from: n  reason: collision with root package name */
        public String f78809n;

        /* renamed from: o  reason: collision with root package name */
        public Spannable f78810o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f78811p;

        /* renamed from: q  reason: collision with root package name */
        public boolean f78812q;

        /* renamed from: r  reason: collision with root package name */
        public Float f78813r;

        /* renamed from: s  reason: collision with root package name */
        public Integer f78814s;

        /* renamed from: t  reason: collision with root package name */
        public CharSequence f78815t;

        /* renamed from: u  reason: collision with root package name */
        public View f78816u;

        /* renamed from: v  reason: collision with root package name */
        public boolean f78817v;

        /* renamed from: w  reason: collision with root package name */
        public Integer f78818w;

        /* renamed from: x  reason: collision with root package name */
        public String f78819x;

        /* renamed from: y  reason: collision with root package name */
        public boolean f78820y;

        /* renamed from: z  reason: collision with root package name */
        public Integer f78821z;

        public class a implements View.OnFocusChangeListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ View f78822b;

            public a(View view) {
                this.f78822b = view;
            }

            public void onFocusChange(View view, boolean z11) {
                if (z11) {
                    this.f78822b.setBackgroundColor(b.this.f78802g.getResources().getColor(R$color.global_button_end_color));
                } else {
                    this.f78822b.setBackgroundColor(b.this.f78802g.getResources().getColor(R$color.global_divider_color));
                }
            }
        }

        @Deprecated
        /* renamed from: com.huobi.otc.helper.OtcDialogUtils$b$b  reason: collision with other inner class name */
        public static final class C0840b {
            public Integer A;
            public Float B;
            public String C;
            public String D;
            public boolean E = true;
            public Integer F;
            public String G;
            public Integer H;
            public Integer I;
            public String J;
            public Integer K;
            public boolean L = false;
            public d M;
            public d N;
            public c O;
            public d P;
            public d Q;
            public d R;
            public d S;
            public Integer T = -1;
            public Integer U = -1;
            public String V;
            public boolean W;
            public Integer X;
            public Integer Y;
            public Integer Z = -1;

            /* renamed from: a  reason: collision with root package name */
            public Integer f78824a;

            /* renamed from: a0  reason: collision with root package name */
            public Float f78825a0;

            /* renamed from: b  reason: collision with root package name */
            public boolean f78826b = false;

            /* renamed from: b0  reason: collision with root package name */
            public boolean f78827b0;

            /* renamed from: c  reason: collision with root package name */
            public String f78828c;

            /* renamed from: c0  reason: collision with root package name */
            public Integer f78829c0;

            /* renamed from: d  reason: collision with root package name */
            public Spannable f78830d;

            /* renamed from: d0  reason: collision with root package name */
            public Integer f78831d0;

            /* renamed from: e  reason: collision with root package name */
            public boolean f78832e;

            /* renamed from: e0  reason: collision with root package name */
            public Integer f78833e0;

            /* renamed from: f  reason: collision with root package name */
            public boolean f78834f;

            /* renamed from: g  reason: collision with root package name */
            public Integer f78835g;

            /* renamed from: h  reason: collision with root package name */
            public Float f78836h;

            /* renamed from: i  reason: collision with root package name */
            public Context f78837i;

            /* renamed from: j  reason: collision with root package name */
            public int f78838j = R$style.CommonDialogStyle;

            /* renamed from: k  reason: collision with root package name */
            public int f78839k = 0;

            /* renamed from: l  reason: collision with root package name */
            public String f78840l;

            /* renamed from: m  reason: collision with root package name */
            public boolean f78841m = true;

            /* renamed from: n  reason: collision with root package name */
            public boolean f78842n = false;

            /* renamed from: o  reason: collision with root package name */
            public boolean f78843o = false;

            /* renamed from: p  reason: collision with root package name */
            public boolean f78844p = false;

            /* renamed from: q  reason: collision with root package name */
            public Integer f78845q;

            /* renamed from: r  reason: collision with root package name */
            public Float f78846r;

            /* renamed from: s  reason: collision with root package name */
            public Integer f78847s;

            /* renamed from: t  reason: collision with root package name */
            public CharSequence f78848t;

            /* renamed from: u  reason: collision with root package name */
            public View f78849u;

            /* renamed from: v  reason: collision with root package name */
            public boolean f78850v = true;

            /* renamed from: w  reason: collision with root package name */
            public Float f78851w;

            /* renamed from: x  reason: collision with root package name */
            public String f78852x;

            /* renamed from: y  reason: collision with root package name */
            public boolean f78853y = false;

            /* renamed from: z  reason: collision with root package name */
            public Integer f78854z;

            public C0840b(Context context) {
                this.f78837i = context;
            }

            public Dialog e0() {
                return f0().j();
            }

            public b f0() {
                return new b(this);
            }

            public C0840b g0(String str) {
                this.D = str;
                return this;
            }

            public C0840b h0(CharSequence charSequence) {
                this.f78848t = charSequence;
                return this;
            }

            public C0840b i0(d dVar) {
                this.M = dVar;
                return this;
            }

            public C0840b j0(String str) {
                this.C = str;
                return this;
            }

            public C0840b k0(d dVar) {
                this.N = dVar;
                return this;
            }

            public C0840b l0(String str) {
                this.f78852x = str;
                return this;
            }

            public C0840b m0(boolean z11) {
                this.f78853y = z11;
                return this;
            }

            public C0840b n0(String str) {
                this.f78840l = str;
                return this;
            }
        }

        public interface c {
            void a(boolean z11);
        }

        public interface d {
            void a(Dialog dialog);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void m(Dialog dialog, View view) {
            this.f78799e0.a(dialog);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void n(CompoundButton compoundButton, boolean z11) {
            this.f78797d0.a(z11);
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void o(CompoundButton compoundButton, boolean z11) {
            this.f78797d0.a(z11);
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void p(Dialog dialog, View view) {
            d dVar = this.f78793b0;
            if (dVar != null) {
                dVar.a(dialog);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void q(Dialog dialog, View view) {
            this.Z.a(dialog);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void r(Dialog dialog, View view) {
            this.Y.a(dialog);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public Dialog j() {
            View findViewById;
            Integer num;
            if (this.f78802g == null) {
                return null;
            }
            int i11 = R$layout.dialog_content_two_btn;
            int i12 = this.f78804i;
            if (i12 == 1) {
                i11 = R$layout.dialog_img_two_btn;
            } else if (i12 == 2) {
                i11 = R$layout.dialog_input_two_btn;
            } else if (i12 == 3) {
                i11 = R$layout.dialog_video_two_btn;
            } else if (i12 == 4) {
                i11 = R$layout.dialog_custom_two_btn;
            } else if (i12 == 5) {
                i11 = R$layout.dialog_long_content_two_btn;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f78802g, this.f78803h);
            View inflate = LayoutInflater.from(this.f78802g).inflate(i11, (ViewGroup) null);
            builder.setView(inflate);
            AlertDialog create = builder.create();
            create.setOnDismissListener(new n(create));
            create.setOnShowListener(new o(create));
            if (!(this.f78804i != 0 || (findViewById = inflate.findViewById(R$id.dialog_parent_container)) == null || (num = this.U) == null)) {
                findViewById.setBackgroundResource(num.intValue());
            }
            TextView textView = (TextView) inflate.findViewById(R$id.dialog_title);
            Button button = (Button) inflate.findViewById(R$id.dialog_cancel_btn);
            this.f78801f0 = (Button) inflate.findViewById(R$id.dialog_confirm_btn);
            if (!this.f78806k || TextUtils.isEmpty(this.f78805j)) {
                textView.setVisibility(8);
            } else {
                textView.setText(this.f78805j);
                if (this.f78796d) {
                    textView.setTypeface(ResourcesCompat.h(this.f78802g, R$font.roboto_medium));
                }
                Integer num2 = this.f78807l;
                if (num2 != null) {
                    textView.setGravity(num2.intValue());
                }
                Integer num3 = this.P;
                if (num3 != null) {
                    textView.setTextColor(num3.intValue());
                }
                Float f11 = this.f78790a;
                if (f11 != null) {
                    textView.setTextSize(0, f11.floatValue());
                }
            }
            if (!this.N) {
                button.setVisibility(8);
            } else if (!TextUtils.isEmpty(this.M)) {
                button.setText(this.M);
                Integer num4 = this.V;
                if (num4 != null) {
                    button.setTextColor(num4.intValue());
                }
                Integer num5 = this.W;
                if (num5 != null) {
                    button.setBackgroundResource(num5.intValue());
                }
            }
            if (!TextUtils.isEmpty(this.K)) {
                this.f78801f0.setText(this.K);
            }
            Integer num6 = this.O;
            if (num6 != null) {
                this.f78801f0.setTextColor(num6.intValue());
            }
            Integer num7 = this.X;
            if (num7 != null) {
                this.f78801f0.setBackgroundResource(num7.intValue());
            }
            int i13 = this.f78804i;
            if (i13 == 4) {
                FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.dialog_container);
                frameLayout.removeAllViews();
                frameLayout.addView(this.f78816u, -1, -2);
            } else if (i13 == 2) {
                ClearEditText clearEditText = (ClearEditText) inflate.findViewById(R$id.dialog_sub_title);
                clearEditText.setOnFocusChangeListener(new a(inflate.findViewById(R$id.divider1)));
                if (!TextUtils.isEmpty(this.L)) {
                    clearEditText.setHint(this.L);
                }
            } else {
                if (i13 == 1 || i13 == 3) {
                    ImageView imageView = (ImageView) inflate.findViewById(R$id.dialog_icon);
                    if (this.S != null) {
                        g6.b.c().i(imageView, this.S, R$color.dialog_video_default);
                    } else {
                        Integer num8 = this.R;
                        if (num8 != null) {
                            imageView.setImageResource(num8.intValue());
                        }
                    }
                    View findViewById2 = inflate.findViewById(R$id.cl_dialog_video);
                    if (!(inflate.findViewById(R$id.iv_dialog_play) == null || this.f78799e0 == null)) {
                        findViewById2.setOnClickListener(new s(this, create));
                    }
                    View findViewById3 = inflate.findViewById(R$id.dialog_check_root);
                    CheckBox checkBox = (CheckBox) inflate.findViewById(R$id.dialog_check);
                    if (!this.f78808m) {
                        findViewById3.setVisibility(8);
                    } else {
                        findViewById3.setVisibility(0);
                        checkBox.setText(this.f78809n);
                        Integer num9 = this.f78814s;
                        if (num9 != null) {
                            checkBox.setTextColor(num9.intValue());
                        }
                        Float f12 = this.f78813r;
                        if (f12 != null) {
                            checkBox.setTextSize(0, f12.floatValue());
                        }
                        if (this.f78797d0 != null) {
                            checkBox.setOnCheckedChangeListener(new t(this));
                        }
                    }
                } else {
                    View findViewById4 = inflate.findViewById(R$id.dialog_check_root);
                    CheckBox checkBox2 = (CheckBox) inflate.findViewById(R$id.dialog_check);
                    if (!this.f78808m) {
                        findViewById4.setVisibility(8);
                    } else {
                        findViewById4.setVisibility(0);
                        checkBox2.setText(this.f78809n);
                        Integer num10 = this.f78814s;
                        if (num10 != null) {
                            checkBox2.setTextColor(num10.intValue());
                        }
                        Float f13 = this.f78813r;
                        if (f13 != null) {
                            checkBox2.setTextSize(0, f13.floatValue());
                        }
                        if (this.f78797d0 != null) {
                            checkBox2.setOnCheckedChangeListener(new u(this));
                        }
                    }
                }
                TextView textView2 = (TextView) inflate.findViewById(R$id.dialog_third_title);
                if (!this.f78820y || TextUtils.isEmpty(this.f78819x)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(this.f78819x);
                    if (this.B.intValue() != -1 && (textView2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                        marginLayoutParams.topMargin = this.B.intValue();
                        textView2.setLayoutParams(marginLayoutParams);
                    }
                    Integer num11 = this.f78821z;
                    if (num11 != null) {
                        textView2.setGravity(num11.intValue());
                    }
                    Integer num12 = this.A;
                    if (num12 != null) {
                        textView2.setTextColor(num12.intValue());
                    }
                    Float f14 = this.f78794c;
                    if (f14 != null) {
                        textView2.setTextSize(0, f14.floatValue());
                    }
                }
                textView2.setOnClickListener(new r(this, create));
                TextView textView3 = (TextView) inflate.findViewById(R$id.dialog_sub_title);
                if (!this.f78817v || TextUtils.isEmpty(this.f78815t)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(this.f78815t);
                    Integer num13 = this.f78818w;
                    if (num13 != null) {
                        textView3.setGravity(num13.intValue());
                    }
                    Integer num14 = this.Q;
                    if (num14 != null) {
                        textView3.setTextColor(num14.intValue());
                    }
                    Float f15 = this.f78792b;
                    if (f15 != null) {
                        textView3.setTextSize(0, f15.floatValue());
                    }
                    if (this.J.intValue() != -1 && (textView3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView3.getLayoutParams();
                        marginLayoutParams2.topMargin = this.J.intValue();
                        textView3.setLayoutParams(marginLayoutParams2);
                    }
                }
            }
            if (this.Z != null) {
                this.f78801f0.setOnClickListener(new q(this, create));
            }
            if (this.Y != null) {
                button.setOnClickListener(new p(this, create));
            }
            create.setCancelable(this.T);
            return create;
        }

        public b(C0840b bVar) {
            this.f78802g = bVar.f78837i;
            this.f78803h = bVar.f78838j;
            this.f78804i = bVar.f78839k;
            this.U = bVar.f78824a;
            this.f78805j = bVar.f78840l;
            this.f78806k = bVar.f78841m;
            this.f78796d = bVar.f78842n;
            this.f78798e = bVar.f78843o;
            this.f78800f = bVar.f78844p;
            this.f78808m = bVar.f78826b;
            this.f78807l = bVar.f78845q;
            this.f78816u = bVar.f78849u;
            this.f78815t = bVar.f78848t;
            this.f78791a0 = bVar.P;
            this.f78817v = bVar.f78850v;
            this.K = bVar.C;
            this.M = bVar.D;
            this.N = bVar.E;
            this.O = bVar.F;
            this.f78819x = bVar.f78852x;
            this.f78820y = bVar.f78853y;
            this.f78821z = bVar.f78854z;
            this.A = bVar.A;
            this.P = bVar.f78847s;
            this.Q = bVar.H;
            this.R = bVar.I;
            this.S = bVar.J;
            this.T = bVar.L;
            this.L = bVar.G;
            this.f78818w = bVar.K;
            this.Y = bVar.M;
            this.Z = bVar.N;
            this.f78793b0 = bVar.Q;
            this.f78790a = bVar.f78846r;
            this.f78792b = bVar.f78851w;
            this.f78794c = bVar.B;
            this.f78808m = bVar.f78826b;
            this.f78814s = bVar.f78835g;
            this.f78813r = bVar.f78836h;
            this.f78809n = bVar.f78828c;
            this.f78810o = bVar.f78830d;
            this.f78811p = bVar.f78832e;
            this.f78812q = bVar.f78834f;
            this.f78797d0 = bVar.O;
            this.f78799e0 = bVar.S;
            this.B = bVar.T;
            this.J = bVar.U;
            this.C = bVar.V;
            this.D = bVar.W;
            this.E = bVar.X;
            this.F = bVar.Y;
            this.G = bVar.Z;
            this.H = bVar.f78825a0;
            this.f78795c0 = bVar.R;
            this.I = bVar.f78827b0;
            this.V = bVar.f78829c0;
            this.W = bVar.f78831d0;
            this.X = bVar.f78833e0;
        }
    }

    public static Dialog a(Context context, String str, CharSequence charSequence, String str2, String str3, String str4, b.d dVar, b.d dVar2) {
        Dialog e02 = new b.C0840b(context).n0(str).h0(charSequence).l0(str2).m0(true).j0(str4).g0(str3).k0(dVar2).i0(dVar).e0();
        e02.show();
        return e02;
    }
}
