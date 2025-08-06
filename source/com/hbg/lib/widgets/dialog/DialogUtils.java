package com.hbg.lib.widgets.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$font;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$string;
import com.hbg.lib.widgets.R$style;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.input.ClearEditText;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.concurrent.TimeUnit;
import z9.a0;
import z9.a1;
import z9.b0;
import z9.b1;
import z9.c0;
import z9.c1;
import z9.d0;
import z9.d1;
import z9.e0;
import z9.f0;
import z9.g0;
import z9.h0;
import z9.i0;
import z9.j0;
import z9.k;
import z9.k0;
import z9.l;
import z9.l0;
import z9.m;
import z9.m0;
import z9.n;
import z9.n0;
import z9.o;
import z9.o0;
import z9.p;
import z9.p0;
import z9.q;
import z9.q0;
import z9.r;
import z9.r0;
import z9.s;
import z9.s0;
import z9.t;
import z9.t0;
import z9.u;
import z9.u0;
import z9.v;
import z9.v0;
import z9.w;
import z9.w0;
import z9.x;
import z9.x0;
import z9.y;
import z9.y0;
import z9.z;
import z9.z0;

public class DialogUtils {

    public interface a {
        void onClick();
    }

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
        public boolean O;
        public Integer P;
        public Integer Q;
        public Integer R;
        public Integer S;
        public String T;
        public boolean U;
        public boolean V;
        public Integer W;
        public Integer X;
        public Integer Y;
        public Integer Z;

        /* renamed from: a  reason: collision with root package name */
        public final Float f71770a;

        /* renamed from: a0  reason: collision with root package name */
        public long f71771a0;

        /* renamed from: b  reason: collision with root package name */
        public final Float f71772b;

        /* renamed from: b0  reason: collision with root package name */
        public boolean f71773b0;

        /* renamed from: c  reason: collision with root package name */
        public final Float f71774c;

        /* renamed from: c0  reason: collision with root package name */
        public int f71775c0;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f71776d;

        /* renamed from: d0  reason: collision with root package name */
        public f f71777d0;

        /* renamed from: e  reason: collision with root package name */
        public boolean f71778e;

        /* renamed from: e0  reason: collision with root package name */
        public f f71779e0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f71780f;

        /* renamed from: f0  reason: collision with root package name */
        public f f71781f0;

        /* renamed from: g  reason: collision with root package name */
        public Context f71782g;

        /* renamed from: g0  reason: collision with root package name */
        public f f71783g0;

        /* renamed from: h  reason: collision with root package name */
        public int f71784h;

        /* renamed from: h0  reason: collision with root package name */
        public f f71785h0;

        /* renamed from: i  reason: collision with root package name */
        public int f71786i;

        /* renamed from: i0  reason: collision with root package name */
        public e f71787i0;

        /* renamed from: j  reason: collision with root package name */
        public CharSequence f71788j;

        /* renamed from: j0  reason: collision with root package name */
        public f f71789j0;

        /* renamed from: k  reason: collision with root package name */
        public boolean f71790k;

        /* renamed from: k0  reason: collision with root package name */
        public View f71791k0;

        /* renamed from: l  reason: collision with root package name */
        public Integer f71792l;

        /* renamed from: l0  reason: collision with root package name */
        public TextView f71793l0;

        /* renamed from: m  reason: collision with root package name */
        public boolean f71794m;

        /* renamed from: m0  reason: collision with root package name */
        public Button f71795m0;

        /* renamed from: n  reason: collision with root package name */
        public String f71796n;

        /* renamed from: n0  reason: collision with root package name */
        public Button f71797n0;

        /* renamed from: o  reason: collision with root package name */
        public Spannable f71798o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f71799p;

        /* renamed from: q  reason: collision with root package name */
        public boolean f71800q;

        /* renamed from: r  reason: collision with root package name */
        public Float f71801r;

        /* renamed from: s  reason: collision with root package name */
        public Integer f71802s;

        /* renamed from: t  reason: collision with root package name */
        public CharSequence f71803t;

        /* renamed from: u  reason: collision with root package name */
        public View f71804u;

        /* renamed from: v  reason: collision with root package name */
        public boolean f71805v;

        /* renamed from: w  reason: collision with root package name */
        public Integer f71806w;

        /* renamed from: x  reason: collision with root package name */
        public String f71807x;

        /* renamed from: y  reason: collision with root package name */
        public boolean f71808y;

        /* renamed from: z  reason: collision with root package name */
        public Integer f71809z;

        public class a implements HBDialogFragment.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Runnable f71810a;

            /* renamed from: com.hbg.lib.widgets.dialog.DialogUtils$b$a$a  reason: collision with other inner class name */
            public class C0788a implements View.OnFocusChangeListener {

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ View f71812b;

                public C0788a(View view) {
                    this.f71812b = view;
                }

                public void onFocusChange(View view, boolean z11) {
                    if (z11) {
                        this.f71812b.setBackgroundColor(b.this.f71782g.getResources().getColor(R$color.global_button_end_color));
                    } else {
                        this.f71812b.setBackgroundColor(b.this.f71782g.getResources().getColor(R$color.global_divider_color));
                    }
                }
            }

            /* renamed from: com.hbg.lib.widgets.dialog.DialogUtils$b$a$b  reason: collision with other inner class name */
            public class C0789b extends CountDownTimer {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ HBDialogFragment f71814a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0789b(long j11, long j12, HBDialogFragment hBDialogFragment) {
                    super(j11, j12);
                    this.f71814a = hBDialogFragment;
                }

                public void onFinish() {
                    HBDialogFragment hBDialogFragment = this.f71814a;
                    if (hBDialogFragment != null && hBDialogFragment.th()) {
                        this.f71814a.dismiss();
                    }
                }

                public void onTick(long j11) {
                }
            }

            public a(Runnable runnable) {
                this.f71810a = runnable;
            }

            /* access modifiers changed from: private */
            @SensorsDataInstrumented
            public /* synthetic */ void h(HBDialogFragment hBDialogFragment, View view) {
                b.this.f71789j0.a(hBDialogFragment);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            /* access modifiers changed from: private */
            @SensorsDataInstrumented
            public /* synthetic */ void i(CompoundButton compoundButton, boolean z11) {
                b.this.f71787i0.a(z11);
                SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
            }

            /* access modifiers changed from: private */
            @SensorsDataInstrumented
            public /* synthetic */ void j(CompoundButton compoundButton, boolean z11) {
                b.this.f71787i0.a(z11);
                SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
            }

            /* access modifiers changed from: private */
            @SensorsDataInstrumented
            public /* synthetic */ void k(HBDialogFragment hBDialogFragment, View view) {
                if (b.this.f71783g0 != null) {
                    b.this.f71783g0.a(hBDialogFragment);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void l(HBDialogFragment hBDialogFragment, Void voidR) {
                b.this.f71779e0.a(hBDialogFragment);
            }

            /* access modifiers changed from: private */
            @SensorsDataInstrumented
            public /* synthetic */ void m(HBDialogFragment hBDialogFragment, View view) {
                b.this.f71777d0.a(hBDialogFragment);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            public void a(View view, HBDialogFragment hBDialogFragment) {
                View unused = b.this.f71791k0 = view.findViewById(R$id.dialog_parent_container);
                b bVar = b.this;
                int i11 = R$id.dialog_sub_title;
                TextView unused2 = bVar.f71793l0 = (TextView) view.findViewById(i11);
                Button unused3 = b.this.f71797n0 = (Button) view.findViewById(R$id.dialog_cancel_btn);
                Button unused4 = b.this.f71795m0 = (Button) view.findViewById(R$id.dialog_confirm_btn);
                TextView textView = (TextView) view.findViewById(R$id.dialog_title);
                b bVar2 = b.this;
                if (bVar2.f71776d) {
                    textView.setTypeface(ResourcesCompat.h(bVar2.f71782g, R$font.roboto_medium));
                }
                if (b.this.f71792l != null) {
                    textView.setGravity(b.this.f71792l.intValue());
                }
                if (b.this.Q != null) {
                    textView.setTextColor(b.this.Q.intValue());
                }
                Float f11 = b.this.f71770a;
                if (f11 != null) {
                    textView.setTextSize(0, f11.floatValue());
                }
                b bVar3 = b.this;
                if (!(bVar3.f71786i != 0 || bVar3.f71791k0 == null || b.this.W == null)) {
                    b.this.f71791k0.setBackgroundResource(b.this.W.intValue());
                }
                if (!b.this.f71790k || TextUtils.isEmpty(b.this.f71788j)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(b.this.f71788j);
                }
                if (!b.this.N) {
                    b.this.f71797n0.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) b.this.f71795m0.getLayoutParams();
                    marginLayoutParams.leftMargin = 0;
                    b.this.f71795m0.setLayoutParams(marginLayoutParams);
                } else if (!TextUtils.isEmpty(b.this.M)) {
                    b.this.f71797n0.setText(b.this.M);
                    if (b.this.X != null) {
                        b.this.f71797n0.setTextColor(b.this.X.intValue());
                    }
                    if (b.this.Y != null) {
                        b.this.f71797n0.setBackgroundResource(b.this.Y.intValue());
                    }
                }
                if (b.this.O) {
                    b.this.f71797n0.setVisibility(8);
                    b.this.f71795m0.setVisibility(8);
                }
                if (!TextUtils.isEmpty(b.this.K)) {
                    b.this.f71795m0.setText(b.this.K);
                }
                if (b.this.P != null) {
                    b.this.f71795m0.setTextColor(b.this.P.intValue());
                }
                if (b.this.Z != null) {
                    b.this.f71795m0.setBackgroundResource(b.this.Z.intValue());
                }
                int i12 = b.this.f71786i;
                if (i12 == 4) {
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.dialog_container);
                    frameLayout.removeAllViews();
                    frameLayout.addView(b.this.f71804u, -1, -2);
                } else if (i12 == 2) {
                    ClearEditText clearEditText = (ClearEditText) view.findViewById(i11);
                    clearEditText.setOnFocusChangeListener(new C0788a(view.findViewById(R$id.divider1)));
                    if (!TextUtils.isEmpty(b.this.L)) {
                        clearEditText.setHint(b.this.L);
                    }
                } else {
                    if (i12 == 1 || i12 == 3) {
                        ImageView imageView = (ImageView) view.findViewById(R$id.dialog_icon);
                        if (b.this.T != null) {
                            g6.b.c().i(imageView, b.this.T, R$color.dialog_video_default);
                        } else if (b.this.S != null) {
                            imageView.setImageResource(b.this.S.intValue());
                        }
                        View findViewById = view.findViewById(R$id.cl_dialog_video);
                        if (!(view.findViewById(R$id.iv_dialog_play) == null || b.this.f71789j0 == null)) {
                            findViewById.setOnClickListener(new s0(this, hBDialogFragment));
                        }
                        View findViewById2 = view.findViewById(R$id.dialog_check_root);
                        CheckBox checkBox = (CheckBox) view.findViewById(R$id.dialog_check);
                        if (!b.this.f71794m) {
                            findViewById2.setVisibility(8);
                        } else {
                            findViewById2.setVisibility(0);
                            checkBox.setText(b.this.f71796n);
                            if (b.this.f71802s != null) {
                                checkBox.setTextColor(b.this.f71802s.intValue());
                            }
                            if (b.this.f71801r != null) {
                                checkBox.setTextSize(0, b.this.f71801r.floatValue());
                            }
                            if (b.this.f71787i0 != null) {
                                checkBox.setOnCheckedChangeListener(new t0(this));
                            }
                        }
                    } else {
                        View findViewById3 = view.findViewById(R$id.dialog_check_root);
                        CheckBox checkBox2 = (CheckBox) view.findViewById(R$id.dialog_check);
                        if (!b.this.f71794m) {
                            findViewById3.setVisibility(8);
                        } else {
                            findViewById3.setVisibility(0);
                            checkBox2.setText(b.this.f71796n);
                            if (b.this.f71802s != null) {
                                checkBox2.setTextColor(b.this.f71802s.intValue());
                            }
                            if (b.this.f71801r != null) {
                                checkBox2.setTextSize(0, b.this.f71801r.floatValue());
                            }
                            if (b.this.f71787i0 != null) {
                                checkBox2.setOnCheckedChangeListener(new u0(this));
                            }
                        }
                    }
                    TextView textView2 = (TextView) view.findViewById(R$id.dialog_third_title);
                    if (!b.this.f71808y || TextUtils.isEmpty(b.this.f71807x)) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setVisibility(0);
                        textView2.setText(b.this.f71807x);
                        if (b.this.B.intValue() != -1 && (textView2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                            marginLayoutParams2.topMargin = b.this.B.intValue();
                            textView2.setLayoutParams(marginLayoutParams2);
                        }
                        if (b.this.f71809z != null) {
                            textView2.setGravity(b.this.f71809z.intValue());
                        }
                        if (b.this.A != null) {
                            textView2.setTextColor(b.this.A.intValue());
                        }
                        if (b.this.f71774c != null) {
                            textView2.setTextSize(0, b.this.f71774c.floatValue());
                        }
                    }
                    textView2.setOnClickListener(new q0(this, hBDialogFragment));
                    TextView textView3 = (TextView) view.findViewById(i11);
                    if (b.this.f71806w != null) {
                        textView3.setGravity(b.this.f71806w.intValue());
                    }
                    if (b.this.R != null) {
                        textView3.setTextColor(b.this.R.intValue());
                    }
                    if (b.this.f71772b != null) {
                        textView3.setTextSize(0, b.this.f71772b.floatValue());
                    }
                    if (b.this.f71778e) {
                        textView3.setTypeface(ResourcesCompat.h(b.this.f71782g, R$font.roboto_medium));
                    } else {
                        textView3.setTypeface(ResourcesCompat.h(b.this.f71782g, R$font.roboto_regular));
                    }
                    if (!b.this.f71805v || TextUtils.isEmpty(b.this.f71803t)) {
                        textView3.setVisibility(8);
                    } else {
                        textView3.setText(b.this.f71803t);
                        if (b.this.f71803t instanceof SpannableString) {
                            textView3.setMovementMethod(LinkMovementMethod.getInstance());
                        }
                        if (b.this.J.intValue() != -1 && (textView3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) textView3.getLayoutParams();
                            marginLayoutParams3.topMargin = b.this.J.intValue();
                            textView3.setLayoutParams(marginLayoutParams3);
                        }
                    }
                }
                if (b.this.f71779e0 != null) {
                    dw.a.a(b.this.f71795m0).throttleFirst(1, TimeUnit.SECONDS).subscribe(new v0(this, hBDialogFragment));
                }
                if (b.this.f71777d0 != null) {
                    b.this.f71797n0.setOnClickListener(new r0(this, hBDialogFragment));
                }
                if (b.this.f71771a0 > 0) {
                    new C0789b(b.this.f71771a0, 1000, hBDialogFragment).start();
                }
                Runnable runnable = this.f71810a;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        /* renamed from: com.hbg.lib.widgets.dialog.DialogUtils$b$b  reason: collision with other inner class name */
        public class C0790b implements HBDialogFragment.a {

            /* renamed from: com.hbg.lib.widgets.dialog.DialogUtils$b$b$a */
            public class a implements View.OnClickListener {

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ HBDialogFragment f71817b;

                public a(HBDialogFragment hBDialogFragment) {
                    this.f71817b = hBDialogFragment;
                }

                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (b.this.f71785h0 != null) {
                        b.this.f71785h0.a(this.f71817b);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            }

            /* renamed from: com.hbg.lib.widgets.dialog.DialogUtils$b$b$b  reason: collision with other inner class name */
            public class C0791b implements CompoundButton.OnCheckedChangeListener {

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Button f71819b;

                public C0791b(Button button) {
                    this.f71819b = button;
                }

                @SensorsDataInstrumented
                public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                    this.f71819b.setEnabled(z11);
                    this.f71819b.setBackgroundResource(z11 ? R$drawable.common_blue_5_radius_selector : R$drawable.common_un_enable_radius_selector);
                    SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
                }
            }

            public C0790b() {
            }

            /* access modifiers changed from: private */
            @SensorsDataInstrumented
            public /* synthetic */ void j(HBDialogFragment hBDialogFragment, View view) {
                if (b.this.f71781f0 != null) {
                    b.this.f71781f0.a(hBDialogFragment);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            /* access modifiers changed from: private */
            @SensorsDataInstrumented
            public /* synthetic */ void k(HBDialogFragment hBDialogFragment, View view) {
                if (b.this.f71783g0 != null) {
                    b.this.f71783g0.a(hBDialogFragment);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            /* access modifiers changed from: private */
            @SensorsDataInstrumented
            public /* synthetic */ void l(CheckBox checkBox, View view) {
                boolean z11 = !checkBox.isChecked();
                checkBox.setChecked(z11);
                if (b.this.f71787i0 != null) {
                    b.this.f71787i0.a(z11);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            /* access modifiers changed from: private */
            @SensorsDataInstrumented
            public /* synthetic */ void m(CompoundButton compoundButton, boolean z11) {
                if (b.this.f71787i0 != null) {
                    b.this.f71787i0.a(z11);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
            }

            /* access modifiers changed from: private */
            @SensorsDataInstrumented
            public /* synthetic */ void n(CheckBox checkBox, View view) {
                boolean z11 = !checkBox.isChecked();
                checkBox.setChecked(z11);
                if (b.this.f71787i0 != null) {
                    b.this.f71787i0.a(z11);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            /* access modifiers changed from: private */
            @SensorsDataInstrumented
            public /* synthetic */ void o(CompoundButton compoundButton, boolean z11) {
                if (b.this.f71787i0 != null) {
                    b.this.f71787i0.a(z11);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
            }

            /* access modifiers changed from: private */
            @SensorsDataInstrumented
            public /* synthetic */ void p(HBDialogFragment hBDialogFragment, View view) {
                b.this.f71777d0.a(hBDialogFragment);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            /* access modifiers changed from: private */
            @SensorsDataInstrumented
            public /* synthetic */ void q(HBDialogFragment hBDialogFragment, View view) {
                b.this.f71779e0.a(hBDialogFragment);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }

            public void a(View view, HBDialogFragment hBDialogFragment) {
                Button button;
                Button button2;
                View findViewById = view.findViewById(R$id.top_area);
                ImageView imageView = (ImageView) view.findViewById(R$id.dialog_icon);
                int i11 = 8;
                if (b.this.T != null) {
                    g6.b.c().i(imageView, b.this.T, R$color.dialog_video_default);
                } else if (b.this.S != null) {
                    imageView.setImageResource(b.this.S.intValue());
                } else {
                    findViewById.setVisibility(8);
                }
                TextView textView = (TextView) view.findViewById(R$id.dialog_title);
                if (b.this.f71776d) {
                    textView.getPaint().setTypeface(ResourcesCompat.h(b.this.f71782g, R$font.roboto_medium));
                }
                if (b.this.f71792l != null) {
                    textView.setGravity(b.this.f71792l.intValue());
                }
                if (b.this.Q != null) {
                    textView.setTextColor(b.this.Q.intValue());
                }
                Float f11 = b.this.f71770a;
                if (f11 != null) {
                    textView.setTextSize(0, f11.floatValue());
                }
                if (TextUtils.isEmpty(b.this.f71788j)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(b.this.f71788j);
                }
                TextView textView2 = (TextView) view.findViewById(R$id.dialog_sub_title);
                if (b.this.f71778e) {
                    textView2.setTypeface(ResourcesCompat.h(b.this.f71782g, R$font.roboto_medium));
                } else {
                    textView2.setTypeface(ResourcesCompat.h(b.this.f71782g, R$font.roboto_regular));
                }
                if (b.this.f71806w != null) {
                    textView2.setGravity(b.this.f71806w.intValue());
                }
                if (b.this.R != null) {
                    textView2.setTextColor(b.this.R.intValue());
                }
                if (b.this.f71772b != null) {
                    textView2.setTextSize(0, b.this.f71772b.floatValue());
                }
                if (TextUtils.isEmpty(b.this.f71803t)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(b.this.f71803t);
                    if (b.this.f71803t instanceof SpannableString) {
                        textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                    if (b.this.J.intValue() != -1 && (textView2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                        marginLayoutParams.topMargin = b.this.J.intValue();
                        textView2.setLayoutParams(marginLayoutParams);
                    }
                    textView2.setOnClickListener(new a1(this, hBDialogFragment));
                }
                TextView textView3 = (TextView) view.findViewById(R$id.dialog_third_title);
                if (TextUtils.isEmpty(b.this.f71807x)) {
                    textView3.setVisibility(8);
                } else {
                    if (b.this.f71780f) {
                        textView3.getPaint().setTypeface(ResourcesCompat.h(b.this.f71782g, R$font.roboto_medium));
                    }
                    textView3.setVisibility(0);
                    textView3.setText(b.this.f71807x);
                    if (b.this.B.intValue() != -1 && (textView3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView3.getLayoutParams();
                        marginLayoutParams2.topMargin = b.this.B.intValue();
                        textView3.setLayoutParams(marginLayoutParams2);
                    }
                    if (b.this.f71809z != null) {
                        textView3.setGravity(b.this.f71809z.intValue());
                    }
                    if (b.this.A != null) {
                        textView3.setTextColor(b.this.A.intValue());
                    }
                    if (b.this.f71774c != null) {
                        textView3.setTextSize(0, b.this.f71774c.floatValue());
                    }
                    textView3.setOnClickListener(new b1(this, hBDialogFragment));
                }
                TextView textView4 = (TextView) view.findViewById(R$id.dialog_forth_title);
                if (TextUtils.isEmpty(b.this.C)) {
                    textView4.setVisibility(8);
                } else {
                    textView4.setVisibility(0);
                    textView4.setText(b.this.C);
                    if (b.this.G.intValue() != -1 && (textView4.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) textView4.getLayoutParams();
                        marginLayoutParams3.topMargin = b.this.G.intValue();
                        textView4.setLayoutParams(marginLayoutParams3);
                    }
                    if (b.this.E != null) {
                        textView4.setGravity(b.this.E.intValue());
                    }
                    if (b.this.F != null) {
                        textView4.setTextColor(b.this.F.intValue());
                    }
                    if (b.this.H != null) {
                        textView4.setTextSize(0, b.this.H.floatValue());
                    }
                    textView4.setOnClickListener(new a(hBDialogFragment));
                }
                View findViewById2 = view.findViewById(R$id.dialog_check_root);
                CheckBox checkBox = (CheckBox) view.findViewById(R$id.dialog_check);
                TextView textView5 = (TextView) view.findViewById(R$id.dialog_check_text);
                if (b.this.f71775c0 != 0) {
                    checkBox.setButtonDrawable(b.this.f71775c0);
                }
                checkBox.setChecked(b.this.f71773b0);
                if (b.this.f71800q) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 48;
                    checkBox.setLayoutParams(layoutParams);
                }
                if (b.this.f71798o == null && b.this.f71796n == null) {
                    findViewById2.setVisibility(8);
                } else {
                    findViewById2.setVisibility(0);
                    if (b.this.f71798o != null) {
                        findViewById2.setOnClickListener(new w0(this, checkBox));
                        checkBox.setOnCheckedChangeListener(new d1(this));
                        textView5.setText(b.this.f71798o);
                        textView5.setMovementMethod(LinkMovementMethod.getInstance());
                        textView5.setHighlightColor(ContextCompat.getColor(b.this.f71782g, 17170445));
                    } else if (b.this.f71796n != null) {
                        findViewById2.setOnClickListener(new x0(this, checkBox));
                        checkBox.setOnCheckedChangeListener(new c1(this));
                        textView5.setText(b.this.f71796n);
                    } else {
                        textView5.setText("");
                    }
                    if (b.this.f71802s != null) {
                        textView5.setTextColor(b.this.f71802s.intValue());
                    }
                    if (b.this.f71801r != null) {
                        textView5.setTextSize(0, b.this.f71801r.floatValue());
                    }
                }
                View findViewById3 = view.findViewById(R$id.layout_dialog_action);
                View findViewById4 = view.findViewById(R$id.layout_dialog_action_vertical);
                if (b.this.I) {
                    findViewById3.setVisibility(8);
                    findViewById4.setVisibility(0);
                    button2 = (Button) findViewById4.findViewById(R$id.dialog_cancel_btn);
                    button = (Button) findViewById4.findViewById(R$id.dialog_confirm_btn);
                } else {
                    findViewById3.setVisibility(0);
                    findViewById4.setVisibility(8);
                    Button button3 = (Button) findViewById3.findViewById(R$id.dialog_confirm_btn);
                    button2 = (Button) findViewById3.findViewById(R$id.dialog_cancel_btn);
                    button = button3;
                }
                if (!TextUtils.isEmpty(b.this.M)) {
                    i11 = 0;
                }
                button2.setVisibility(i11);
                button2.setText(b.this.M);
                if (b.this.f71777d0 != null) {
                    button2.setOnClickListener(new y0(this, hBDialogFragment));
                }
                if (b.this.f71799p) {
                    button.setBackgroundResource(R$drawable.common_un_enable_radius_selector);
                    button.setEnabled(b.this.f71773b0);
                    checkBox.setOnCheckedChangeListener(new C0791b(button));
                }
                if (!TextUtils.isEmpty(b.this.K)) {
                    button.setText(b.this.K);
                }
                if (b.this.P != null) {
                    button.setTextColor(b.this.P.intValue());
                }
                if (b.this.f71779e0 != null) {
                    button.setOnClickListener(new z0(this, hBDialogFragment));
                }
                hBDialogFragment.setCancelable(b.this.U);
                hBDialogFragment.setCanceledOnTouchOutside(b.this.V);
            }
        }

        public class c implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ HBDialogFragment f71821b;

            public c(HBDialogFragment hBDialogFragment) {
                this.f71821b = hBDialogFragment;
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                if (b.this.f71785h0 != null) {
                    b.this.f71785h0.a(this.f71821b);
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public interface e {
            void a(boolean z11);
        }

        public interface f {
            void a(HBDialogFragment hBDialogFragment);
        }

        public /* synthetic */ b(d dVar, f0 f0Var) {
            this(dVar);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void F0(HBDialogFragment hBDialogFragment, View view) {
            f fVar = this.f71781f0;
            if (fVar != null) {
                fVar.a(hBDialogFragment);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void G0(HBDialogFragment hBDialogFragment, View view) {
            f fVar = this.f71783g0;
            if (fVar != null) {
                fVar.a(hBDialogFragment);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void H0(CheckBox checkBox, View view) {
            boolean z11 = !checkBox.isChecked();
            checkBox.setChecked(z11);
            e eVar = this.f71787i0;
            if (eVar != null) {
                eVar.a(z11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void I0(CompoundButton compoundButton, boolean z11) {
            e eVar = this.f71787i0;
            if (eVar != null) {
                eVar.a(z11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void J0(CheckBox checkBox, View view) {
            boolean z11 = !checkBox.isChecked();
            checkBox.setChecked(z11);
            e eVar = this.f71787i0;
            if (eVar != null) {
                eVar.a(z11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void K0(CompoundButton compoundButton, boolean z11) {
            e eVar = this.f71787i0;
            if (eVar != null) {
                eVar.a(z11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void L0(HBDialogFragment hBDialogFragment, View view) {
            this.f71777d0.a(hBDialogFragment);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        @SensorsDataInstrumented
        public static /* synthetic */ void M0(Button button, CompoundButton compoundButton, boolean z11) {
            button.setEnabled(z11);
            SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void N0(HBDialogFragment hBDialogFragment, View view) {
            this.f71779e0.a(hBDialogFragment);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O0(View view, HBDialogFragment hBDialogFragment) {
            Button button;
            Button button2;
            View findViewById = view.findViewById(R$id.top_area);
            ImageView imageView = (ImageView) view.findViewById(R$id.dialog_icon);
            int i11 = 8;
            if (this.T != null) {
                g6.b.c().i(imageView, this.T, R$color.dialog_video_default);
            } else {
                Integer num = this.S;
                if (num != null) {
                    imageView.setImageResource(num.intValue());
                } else {
                    findViewById.setVisibility(8);
                }
            }
            TextView textView = (TextView) view.findViewById(R$id.dialog_title);
            if (this.f71776d) {
                textView.getPaint().setTypeface(ResourcesCompat.h(this.f71782g, R$font.roboto_medium));
            }
            Integer num2 = this.f71792l;
            if (num2 != null) {
                textView.setGravity(num2.intValue());
            }
            Integer num3 = this.Q;
            if (num3 != null) {
                textView.setTextColor(num3.intValue());
            }
            Float f11 = this.f71770a;
            if (f11 != null) {
                textView.setTextSize(0, f11.floatValue());
            }
            if (TextUtils.isEmpty(this.f71788j)) {
                textView.setVisibility(8);
            } else {
                textView.setText(this.f71788j);
            }
            TextView textView2 = (TextView) view.findViewById(R$id.dialog_sub_title);
            if (TextUtils.isEmpty(this.f71803t)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(this.f71803t);
                if (this.f71803t instanceof SpannableString) {
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                }
                if (this.f71778e) {
                    textView2.setTypeface(ResourcesCompat.h(this.f71782g, R$font.roboto_medium));
                } else {
                    textView2.setTypeface(ResourcesCompat.h(this.f71782g, R$font.roboto_regular));
                }
                Integer num4 = this.f71806w;
                if (num4 != null) {
                    textView2.setGravity(num4.intValue());
                }
                Integer num5 = this.R;
                if (num5 != null) {
                    textView2.setTextColor(num5.intValue());
                }
                Float f12 = this.f71772b;
                if (f12 != null) {
                    textView2.setTextSize(0, f12.floatValue());
                }
                if (this.J.intValue() != -1 && (textView2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                    marginLayoutParams.topMargin = this.J.intValue();
                    textView2.setLayoutParams(marginLayoutParams);
                }
                textView2.setOnClickListener(new l0(this, hBDialogFragment));
            }
            TextView textView3 = (TextView) view.findViewById(R$id.dialog_third_title);
            if (TextUtils.isEmpty(this.f71807x)) {
                textView3.setVisibility(8);
            } else {
                if (this.f71780f) {
                    textView3.getPaint().setTypeface(ResourcesCompat.h(this.f71782g, R$font.roboto_medium));
                }
                textView3.setVisibility(0);
                textView3.setText(this.f71807x);
                if (this.B.intValue() != -1 && (textView3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView3.getLayoutParams();
                    marginLayoutParams2.topMargin = this.B.intValue();
                    textView3.setLayoutParams(marginLayoutParams2);
                }
                Integer num6 = this.f71809z;
                if (num6 != null) {
                    textView3.setGravity(num6.intValue());
                }
                Integer num7 = this.A;
                if (num7 != null) {
                    textView3.setTextColor(num7.intValue());
                }
                Float f13 = this.f71774c;
                if (f13 != null) {
                    textView3.setTextSize(0, f13.floatValue());
                }
                textView3.setOnClickListener(new j0(this, hBDialogFragment));
            }
            TextView textView4 = (TextView) view.findViewById(R$id.dialog_forth_title);
            if (TextUtils.isEmpty(this.C)) {
                textView4.setVisibility(8);
            } else {
                textView4.setVisibility(0);
                textView4.setText(this.C);
                if (this.G.intValue() != -1 && (textView4.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) textView4.getLayoutParams();
                    marginLayoutParams3.topMargin = this.G.intValue();
                    textView4.setLayoutParams(marginLayoutParams3);
                }
                Integer num8 = this.E;
                if (num8 != null) {
                    textView4.setGravity(num8.intValue());
                }
                Integer num9 = this.F;
                if (num9 != null) {
                    textView4.setTextColor(num9.intValue());
                }
                Float f14 = this.H;
                if (f14 != null) {
                    textView4.setTextSize(0, f14.floatValue());
                }
                textView4.setOnClickListener(new c(hBDialogFragment));
            }
            View findViewById2 = view.findViewById(R$id.dialog_check_root);
            CheckBox checkBox = (CheckBox) view.findViewById(R$id.dialog_check);
            TextView textView5 = (TextView) view.findViewById(R$id.dialog_check_text);
            int i12 = this.f71775c0;
            if (i12 != 0) {
                checkBox.setButtonDrawable(i12);
            }
            checkBox.setChecked(this.f71773b0);
            if (this.f71798o == null && this.f71796n == null) {
                findViewById2.setVisibility(8);
            } else {
                findViewById2.setVisibility(0);
                if (this.f71798o != null) {
                    findViewById2.setOnClickListener(new g0(this, checkBox));
                    checkBox.setOnCheckedChangeListener(new o0(this));
                    textView5.setText(this.f71798o);
                    textView5.setMovementMethod(LinkMovementMethod.getInstance());
                    textView5.setHighlightColor(ContextCompat.getColor(this.f71782g, 17170445));
                } else if (this.f71796n != null) {
                    findViewById2.setOnClickListener(new h0(this, checkBox));
                    checkBox.setOnCheckedChangeListener(new n0(this));
                    textView5.setText(this.f71796n);
                } else {
                    textView5.setText("");
                }
                Integer num10 = this.f71802s;
                if (num10 != null) {
                    textView5.setTextColor(num10.intValue());
                }
                Float f15 = this.f71801r;
                if (f15 != null) {
                    textView5.setTextSize(0, f15.floatValue());
                }
            }
            View findViewById3 = view.findViewById(R$id.layout_dialog_action);
            View findViewById4 = view.findViewById(R$id.layout_dialog_action_vertical);
            if (this.I) {
                findViewById3.setVisibility(8);
                findViewById4.setVisibility(0);
                button2 = (Button) findViewById4.findViewById(R$id.dialog_cancel_btn);
                button = (Button) findViewById4.findViewById(R$id.dialog_confirm_btn);
            } else {
                findViewById3.setVisibility(0);
                findViewById4.setVisibility(8);
                Button button3 = (Button) findViewById3.findViewById(R$id.dialog_confirm_btn);
                button2 = (Button) findViewById3.findViewById(R$id.dialog_cancel_btn);
                button = button3;
            }
            if (!TextUtils.isEmpty(this.M)) {
                i11 = 0;
            }
            button2.setVisibility(i11);
            button2.setText(this.M);
            if (this.f71777d0 != null) {
                button2.setOnClickListener(new i0(this, hBDialogFragment));
            }
            if (this.f71799p) {
                button.setEnabled(this.f71773b0);
                checkBox.setOnCheckedChangeListener(new m0(button));
            }
            if (!TextUtils.isEmpty(this.K)) {
                button.setText(this.K);
            }
            Integer num11 = this.P;
            if (num11 != null) {
                button.setTextColor(num11.intValue());
            }
            if (this.f71779e0 != null) {
                button.setOnClickListener(new k0(this, hBDialogFragment));
            }
            hBDialogFragment.setCancelable(this.U);
            hBDialogFragment.setCanceledOnTouchOutside(this.V);
        }

        public final HBDialogFragment A0() {
            HBDialogFragment uh2 = HBDialogFragment.uh(R$layout.dialog_content_two_btn_3, new p0(this));
            uh2.setStyle(0, R$style.CommonDialogStyle);
            return uh2;
        }

        public TextView B0() {
            return this.f71793l0;
        }

        public View C0() {
            return this.f71791k0;
        }

        public Button D0() {
            return this.f71797n0;
        }

        public Button E0() {
            return this.f71795m0;
        }

        public HBDialogFragment x0() {
            return y0((Runnable) null);
        }

        public HBDialogFragment y0(Runnable runnable) {
            if (this.f71782g == null) {
                return null;
            }
            int i11 = R$layout.dialog_content_two_btn;
            int i12 = this.f71786i;
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
            HBDialogFragment uh2 = HBDialogFragment.uh(i11, new a(runnable));
            uh2.setCancelable(this.U);
            uh2.setCanceledOnTouchOutside(this.V);
            uh2.setStyle(0, this.f71784h);
            return uh2;
        }

        public final HBDialogFragment z0() {
            HBDialogFragment uh2 = HBDialogFragment.uh(R$layout.dialog_content_two_btn_new, new C0790b());
            uh2.setStyle(0, R$style.CommonDialogStyle);
            return uh2;
        }

        public b(d dVar) {
            this.f71782g = dVar.f71839i;
            this.f71784h = dVar.f71841j;
            this.f71786i = dVar.f71843k;
            this.W = dVar.f71823a;
            this.f71788j = dVar.f71844l;
            this.f71790k = dVar.f71845m;
            this.f71776d = dVar.f71846n;
            this.f71778e = dVar.f71847o;
            this.f71780f = dVar.f71848p;
            this.f71794m = dVar.f71825b;
            this.f71792l = dVar.f71849q;
            this.f71804u = dVar.f71853u;
            this.f71803t = dVar.f71852t;
            this.f71781f0 = dVar.R;
            this.f71805v = dVar.f71854v;
            this.K = dVar.C;
            this.M = dVar.D;
            this.N = dVar.E;
            this.O = dVar.N;
            this.P = dVar.F;
            this.f71807x = dVar.f71856x;
            this.f71808y = dVar.f71857y;
            this.f71809z = dVar.f71858z;
            this.A = dVar.A;
            this.Q = dVar.f71851s;
            this.R = dVar.H;
            this.S = dVar.I;
            this.T = dVar.J;
            this.U = dVar.L;
            this.V = dVar.M;
            this.L = dVar.G;
            this.f71806w = dVar.K;
            this.f71777d0 = dVar.O;
            this.f71779e0 = dVar.P;
            this.f71783g0 = dVar.S;
            this.f71770a = dVar.f71850r;
            this.f71772b = dVar.f71855w;
            this.f71774c = dVar.B;
            this.f71794m = dVar.f71825b;
            this.f71802s = dVar.f71835g;
            this.f71801r = dVar.f71837h;
            this.f71796n = dVar.f71827c;
            this.f71798o = dVar.f71829d;
            this.f71799p = dVar.f71831e;
            this.f71800q = dVar.f71833f;
            this.f71787i0 = dVar.Q;
            this.f71789j0 = dVar.U;
            this.B = dVar.V;
            this.J = dVar.W;
            this.C = dVar.X;
            this.D = dVar.Y;
            this.E = dVar.Z;
            this.F = dVar.f71824a0;
            this.G = dVar.f71826b0;
            this.H = dVar.f71828c0;
            this.f71785h0 = dVar.T;
            this.I = dVar.f71830d0;
            this.X = dVar.f71832e0;
            this.Y = dVar.f71834f0;
            this.Z = dVar.f71836g0;
            this.f71771a0 = dVar.f71838h0;
            this.f71773b0 = dVar.f71840i0;
            this.f71775c0 = dVar.f71842j0;
        }

        public static final class d {
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
            public boolean M = false;
            public boolean N;
            public f O;
            public f P;
            public e Q;
            public f R;
            public f S;
            public f T;
            public f U;
            public Integer V = -1;
            public Integer W = -1;
            public String X;
            public boolean Y;
            public Integer Z;

            /* renamed from: a  reason: collision with root package name */
            public Integer f71823a;

            /* renamed from: a0  reason: collision with root package name */
            public Integer f71824a0;

            /* renamed from: b  reason: collision with root package name */
            public boolean f71825b = false;

            /* renamed from: b0  reason: collision with root package name */
            public Integer f71826b0 = -1;

            /* renamed from: c  reason: collision with root package name */
            public String f71827c;

            /* renamed from: c0  reason: collision with root package name */
            public Float f71828c0;

            /* renamed from: d  reason: collision with root package name */
            public Spannable f71829d;

            /* renamed from: d0  reason: collision with root package name */
            public boolean f71830d0;

            /* renamed from: e  reason: collision with root package name */
            public boolean f71831e;

            /* renamed from: e0  reason: collision with root package name */
            public Integer f71832e0;

            /* renamed from: f  reason: collision with root package name */
            public boolean f71833f;

            /* renamed from: f0  reason: collision with root package name */
            public Integer f71834f0;

            /* renamed from: g  reason: collision with root package name */
            public Integer f71835g;

            /* renamed from: g0  reason: collision with root package name */
            public Integer f71836g0;

            /* renamed from: h  reason: collision with root package name */
            public Float f71837h;

            /* renamed from: h0  reason: collision with root package name */
            public long f71838h0;

            /* renamed from: i  reason: collision with root package name */
            public Context f71839i;

            /* renamed from: i0  reason: collision with root package name */
            public boolean f71840i0;

            /* renamed from: j  reason: collision with root package name */
            public int f71841j = R$style.CommonDialogStyle;

            /* renamed from: j0  reason: collision with root package name */
            public int f71842j0;

            /* renamed from: k  reason: collision with root package name */
            public int f71843k = 0;

            /* renamed from: l  reason: collision with root package name */
            public CharSequence f71844l;

            /* renamed from: m  reason: collision with root package name */
            public boolean f71845m = true;

            /* renamed from: n  reason: collision with root package name */
            public boolean f71846n = false;

            /* renamed from: o  reason: collision with root package name */
            public boolean f71847o = false;

            /* renamed from: p  reason: collision with root package name */
            public boolean f71848p = false;

            /* renamed from: q  reason: collision with root package name */
            public Integer f71849q;

            /* renamed from: r  reason: collision with root package name */
            public Float f71850r;

            /* renamed from: s  reason: collision with root package name */
            public Integer f71851s;

            /* renamed from: t  reason: collision with root package name */
            public CharSequence f71852t;

            /* renamed from: u  reason: collision with root package name */
            public View f71853u;

            /* renamed from: v  reason: collision with root package name */
            public boolean f71854v = true;

            /* renamed from: w  reason: collision with root package name */
            public Float f71855w;

            /* renamed from: x  reason: collision with root package name */
            public String f71856x;

            /* renamed from: y  reason: collision with root package name */
            public boolean f71857y = false;

            /* renamed from: z  reason: collision with root package name */
            public Integer f71858z;

            public d(FragmentActivity fragmentActivity) {
                this.f71839i = fragmentActivity;
            }

            public d A0(Float f11) {
                this.f71837h = f11;
                return this;
            }

            public d B0(Integer num) {
                this.f71836g0 = num;
                return this;
            }

            public d C0(CharSequence charSequence) {
                this.f71852t = charSequence;
                return this;
            }

            public d D0(Integer num) {
                this.H = num;
                return this;
            }

            public d E0(boolean z11) {
                this.f71854v = z11;
                return this;
            }

            public d F0(Integer num) {
                this.K = num;
                return this;
            }

            public d G0(Integer num) {
                this.W = num;
                return this;
            }

            public d H0(Float f11) {
                this.f71855w = f11;
                return this;
            }

            public d I0(View view) {
                this.f71853u = view;
                return this;
            }

            public d J0(boolean z11) {
                this.f71840i0 = z11;
                return this;
            }

            public d K0(int i11) {
                this.f71842j0 = i11;
                return this;
            }

            public d L0(Integer num) {
                this.f71823a = num;
                return this;
            }

            public d M0(Integer num) {
                this.I = num;
                return this;
            }

            public d N0(f fVar) {
                this.O = fVar;
                return this;
            }

            public d O0(boolean z11) {
                this.N = z11;
                return this;
            }

            public d P0(String str) {
                this.C = str;
                return this;
            }

            public d Q0(f fVar) {
                this.P = fVar;
                return this;
            }

            public d R0(String str) {
                this.f71856x = str;
                return this;
            }

            public d S0(Integer num) {
                this.A = num;
                return this;
            }

            public d T0(boolean z11) {
                this.f71857y = z11;
                return this;
            }

            public d U0(f fVar) {
                this.S = fVar;
                return this;
            }

            public d V0(Integer num) {
                this.V = num;
                return this;
            }

            public d W0(Float f11) {
                this.B = f11;
                return this;
            }

            public d X0(boolean z11) {
                this.f71847o = z11;
                return this;
            }

            public d Y0(String str) {
                this.X = str;
                return this;
            }

            public d Z0(boolean z11) {
                this.Y = z11;
                return this;
            }

            public d a1(f fVar) {
                this.T = fVar;
                return this;
            }

            public d b1(Integer num) {
                this.f71826b0 = num;
                return this;
            }

            public d c1(CharSequence charSequence) {
                this.f71844l = charSequence;
                return this;
            }

            public d d1(boolean z11) {
                this.f71846n = z11;
                return this;
            }

            public d e1(Integer num) {
                this.f71851s = num;
                return this;
            }

            public d f1(boolean z11) {
                this.f71845m = z11;
                return this;
            }

            public d g1(Integer num) {
                this.f71849q = num;
                return this;
            }

            public d h1(Float f11) {
                this.f71850r = f11;
                return this;
            }

            public d i1(int i11) {
                this.f71843k = i11;
                return this;
            }

            public HBDialogFragment j0() {
                return m0().x0();
            }

            public HBDialogFragment k0() {
                return m0().z0();
            }

            public HBDialogFragment l0() {
                return m0().A0();
            }

            public b m0() {
                return new b(this, (f0) null);
            }

            public d n0(boolean z11) {
                this.L = z11;
                return this;
            }

            public d o0(boolean z11) {
                this.M = z11;
                return this;
            }

            public d p0(Integer num) {
                this.f71834f0 = num;
                return this;
            }

            public d q0(boolean z11) {
                this.E = z11;
                return this;
            }

            public d r0(Integer num) {
                this.f71832e0 = num;
                return this;
            }

            public d s0(String str) {
                this.D = str;
                return this;
            }

            public d t0(boolean z11) {
                this.f71831e = z11;
                return this;
            }

            public d u0(boolean z11) {
                this.f71833f = z11;
                return this;
            }

            public d v0(e eVar) {
                this.Q = eVar;
                return this;
            }

            public d w0(Spannable spannable) {
                this.f71829d = spannable;
                return this;
            }

            public d x0(boolean z11) {
                this.f71825b = z11;
                return this;
            }

            public d y0(String str) {
                this.f71827c = str;
                return this;
            }

            public d z0(Integer num) {
                this.f71835g = num;
                return this;
            }

            public d(FragmentActivity fragmentActivity, int i11) {
                this.f71839i = fragmentActivity;
                this.f71841j = i11;
            }
        }
    }

    public interface c {
        void onClick(int i11);
    }

    public interface d {
        void a();
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void A(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void B(FragmentActivity fragmentActivity, Dialog dialog, View view) {
        g0(fragmentActivity, dialog);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void C(FragmentActivity fragmentActivity, Dialog dialog, View view) {
        g0(fragmentActivity, dialog);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void D(FragmentActivity fragmentActivity, Dialog dialog, View view) {
        g0(fragmentActivity, dialog);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void E(FragmentActivity fragmentActivity, Dialog dialog, View view) {
        g0(fragmentActivity, dialog);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void F(FragmentActivity fragmentActivity, Dialog dialog, View view) {
        g0(fragmentActivity, dialog);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void G(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void H(c cVar, FragmentActivity fragmentActivity, Dialog dialog, View view) {
        if (cVar != null) {
            cVar.onClick(0);
        }
        g0(fragmentActivity, dialog);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void I(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void J(Dialog dialog, FragmentActivity fragmentActivity, View view) {
        dialog.dismiss();
        S(fragmentActivity);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void K(Dialog dialog, d dVar, View view) {
        dialog.dismiss();
        if (dVar != null) {
            dVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void L(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void M(Dialog dialog, a aVar, View view) {
        dialog.dismiss();
        aVar.onClick();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void N(Dialog dialog, a aVar, View view) {
        dialog.dismiss();
        aVar.onClick();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void O(Dialog dialog, a aVar, View view) {
        dialog.dismiss();
        aVar.onClick();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void P(Dialog dialog, a aVar, View view) {
        dialog.dismiss();
        aVar.onClick();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Q(Dialog dialog, FragmentActivity fragmentActivity, View view) {
        dialog.dismiss();
        S(fragmentActivity);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void R(Dialog dialog) {
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().setGravity(80);
        Window window = dialog.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.horizontalMargin = 0.0f;
        window.setAttributes(attributes);
    }

    public static void S(FragmentActivity fragmentActivity) {
        View inflate = LayoutInflater.from(fragmentActivity).inflate(R$layout.dialog_feedback, (ViewGroup) null);
        Dialog v11 = v(fragmentActivity, inflate);
        if (v11 != null) {
            ((TextView) inflate.findViewById(R$id.tvObscene)).setOnClickListener(new n(fragmentActivity, v11));
            ((TextView) inflate.findViewById(R$id.tvAdvertisement)).setOnClickListener(new m(fragmentActivity, v11));
            ((TextView) inflate.findViewById(R$id.tvAbuse)).setOnClickListener(new p(fragmentActivity, v11));
            ((TextView) inflate.findViewById(R$id.tvFalseRumors)).setOnClickListener(new q(fragmentActivity, v11));
            ((TextView) inflate.findViewById(R$id.tvIllegal)).setOnClickListener(new o(fragmentActivity, v11));
            ((TextView) inflate.findViewById(R$id.tvCancel)).setOnClickListener(new k(v11));
            v11.show();
            R(v11);
        }
    }

    public static void T(FragmentActivity fragmentActivity, c cVar) {
        View inflate = LayoutInflater.from(fragmentActivity).inflate(R$layout.dialog_feedback, (ViewGroup) null);
        Dialog v11 = v(fragmentActivity, inflate);
        if (v11 != null) {
            ((TextView) inflate.findViewById(R$id.tvObscene)).setOnClickListener(new t(cVar, fragmentActivity, v11));
            ((TextView) inflate.findViewById(R$id.tvAdvertisement)).setOnClickListener(new u(cVar, fragmentActivity, v11));
            ((TextView) inflate.findViewById(R$id.tvAbuse)).setOnClickListener(new w(cVar, fragmentActivity, v11));
            ((TextView) inflate.findViewById(R$id.tvFalseRumors)).setOnClickListener(new r(cVar, fragmentActivity, v11));
            ((TextView) inflate.findViewById(R$id.tvIllegal)).setOnClickListener(new s(cVar, fragmentActivity, v11));
            ((TextView) inflate.findViewById(R$id.tvCancel)).setOnClickListener(new y(v11));
            v11.show();
            R(v11);
        }
    }

    public static void U(int i11, FragmentActivity fragmentActivity, d dVar) {
        View inflate = LayoutInflater.from(fragmentActivity).inflate(R$layout.dialog_content_more, (ViewGroup) null);
        Dialog v11 = v(fragmentActivity, inflate);
        if (v11 != null) {
            ImageView imageView = (ImageView) inflate.findViewById(R$id.ivClose);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.llComplaint);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R$id.llShare);
            if (i11 == 0) {
                linearLayout2.setVisibility(8);
            } else if (i11 == 1) {
                linearLayout.setVisibility(8);
            }
            imageView.setOnClickListener(new x(v11));
            linearLayout.setOnClickListener(new z(v11, fragmentActivity));
            linearLayout2.setOnClickListener(new l(v11, dVar));
            v11.show();
            R(v11);
        }
    }

    public static void V(FragmentActivity fragmentActivity) {
        U(0, fragmentActivity, (d) null);
    }

    public static HBDialogFragment W(FragmentActivity fragmentActivity, CharSequence charSequence, String str, String str2, String str3, boolean z11, b.f fVar) {
        int color = fragmentActivity.getResources().getColor(R$color.baseColorPrimaryText);
        b.d Q0 = new b.d(fragmentActivity).c1(charSequence).d1(true).C0(str).D0(Integer.valueOf(color)).R0(str2).S0(Integer.valueOf(color)).X0(true).T0(true).q0(false).P0(str3).Q0(fVar);
        Q0.n0(z11);
        Q0.o0(z11);
        HBDialogFragment k02 = Q0.k0();
        k02.show(fragmentActivity.getSupportFragmentManager(), "");
        return k02;
    }

    public static void X(FragmentActivity fragmentActivity, CharSequence charSequence, CharSequence charSequence2, String str, String str2, b.f fVar) {
        new b.d(fragmentActivity).c1(charSequence).C0(charSequence2).R0(str).T0(true).q0(false).P0(str2).Q0(fVar).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }

    public static void Y(FragmentActivity fragmentActivity, String str, String str2, String str3, b.f fVar) {
        X(fragmentActivity, (CharSequence) null, str, str2, str3, fVar);
    }

    public static void Z(FragmentActivity fragmentActivity, CharSequence charSequence, SpannableString spannableString, String str, String str2, b.f fVar) {
        new b.d(fragmentActivity).c1(charSequence).C0(spannableString).R0(str).T0(true).q0(false).P0(str2).Q0(fVar).k0().show(fragmentActivity.getSupportFragmentManager(), "");
    }

    public static DialogFragment a0(FragmentActivity fragmentActivity, CharSequence charSequence, View view, String str, b.f fVar) {
        HBDialogFragment j02 = new b.d(fragmentActivity).i1(4).c1(charSequence).I0(view).q0(false).P0(str).Q0(fVar).j0();
        j02.show(fragmentActivity.getSupportFragmentManager(), "");
        return j02;
    }

    public static HBDialogFragment b0(FragmentActivity fragmentActivity, CharSequence charSequence, CharSequence charSequence2, String str, String str2, String str3, b.f fVar, b.f fVar2) {
        HBDialogFragment j02 = new b.d(fragmentActivity).c1(charSequence).C0(charSequence2).R0(str).T0(true).P0(str3).s0(str2).Q0(fVar2).N0(fVar).j0();
        j02.show(fragmentActivity.getSupportFragmentManager(), "");
        return j02;
    }

    public static HBDialogFragment c0(FragmentActivity fragmentActivity, CharSequence charSequence, String str, String str2, String str3, b.f fVar, b.f fVar2) {
        return b0(fragmentActivity, (CharSequence) null, charSequence, str, str2, str3, fVar, fVar2);
    }

    public static HBDialogFragment d0(FragmentActivity fragmentActivity, CharSequence charSequence, CharSequence charSequence2, String str, String str2, b.f fVar, b.f fVar2) {
        HBDialogFragment j02 = new b.d(fragmentActivity).c1(charSequence).d1(true).C0(charSequence2).D0(Integer.valueOf(fragmentActivity.getResources().getColor(R$color.baseColorPrimaryText))).R0((String) null).T0(true).P0(str2).s0(str).Q0(fVar2).N0(fVar).j0();
        j02.show(fragmentActivity.getSupportFragmentManager(), "");
        return j02;
    }

    public static HBDialogFragment e0(FragmentActivity fragmentActivity, CharSequence charSequence, CharSequence charSequence2) {
        HBDialogFragment j02 = new b.d(fragmentActivity).c1(charSequence).C0(charSequence2).T0(false).q0(false).O0(true).j0();
        j02.show(fragmentActivity.getSupportFragmentManager(), "");
        return j02;
    }

    public static void f0(FragmentActivity fragmentActivity, int i11, boolean z11, boolean z12, boolean z13, a aVar, a aVar2, a aVar3, a aVar4) {
        FragmentActivity fragmentActivity2 = fragmentActivity;
        View inflate = LayoutInflater.from(fragmentActivity).inflate(R$layout.dialog_private_chat_menu, (ViewGroup) null);
        Dialog v11 = v(fragmentActivity, inflate);
        if (v11 != null) {
            TextView textView = (TextView) inflate.findViewById(R$id.tvFollow);
            TextView textView2 = (TextView) inflate.findViewById(R$id.tvBlock);
            TextView textView3 = (TextView) inflate.findViewById(R$id.tvPin);
            TextView textView4 = (TextView) inflate.findViewById(R$id.tvReport);
            TextView textView5 = (TextView) inflate.findViewById(R$id.tvNoDisturb);
            inflate.findViewById(R$id.tvCancel).setOnClickListener(new v(v11));
            if (i11 == 0) {
                textView.setText(fragmentActivity.getResources().getString(R$string.n_content_community_userinfo_focus));
            } else {
                textView.setText(fragmentActivity.getResources().getString(R$string.n_content_live_unfollow));
            }
            if (z11) {
                textView3.setText(fragmentActivity.getResources().getString(R$string.n_content_live_un_pin));
            } else {
                textView3.setText(fragmentActivity.getResources().getString(R$string.n_market_top_title));
            }
            if (z13) {
                textView5.setText(fragmentActivity.getResources().getString(R$string.n_im_not_disturbing));
            } else {
                textView5.setText(fragmentActivity.getResources().getString(R$string.n_im_no_disturbing));
            }
            a aVar5 = aVar;
            textView.setOnClickListener(new d0(v11, aVar));
            if (z12) {
                textView2.setText(fragmentActivity.getResources().getText(R$string.n_im_black_cancel));
            } else {
                textView2.setText(fragmentActivity.getResources().getText(R$string.n_im_block_user));
            }
            a aVar6 = aVar2;
            textView2.setOnClickListener(new e0(v11, aVar2));
            textView3.setOnClickListener(new b0(v11, aVar3));
            textView5.setOnClickListener(new c0(v11, aVar4));
            textView4.setOnClickListener(new a0(v11, fragmentActivity));
            v11.show();
            R(v11);
        }
    }

    public static void g0(FragmentActivity fragmentActivity, Dialog dialog) {
        dialog.dismiss();
        Y(fragmentActivity, fragmentActivity.getResources().getString(R$string.n_content_complaint_tips), (String) null, fragmentActivity.getResources().getString(R$string.n_confirm), bj.o0.f12469a);
    }

    public static Dialog v(FragmentActivity fragmentActivity, View view) {
        if (fragmentActivity == null || fragmentActivity.isFinishing()) {
            return null;
        }
        return new AlertDialog.Builder(fragmentActivity).setView(view).create();
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void w(c cVar, FragmentActivity fragmentActivity, Dialog dialog, View view) {
        if (cVar != null) {
            cVar.onClick(1);
        }
        g0(fragmentActivity, dialog);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void x(c cVar, FragmentActivity fragmentActivity, Dialog dialog, View view) {
        if (cVar != null) {
            cVar.onClick(2);
        }
        g0(fragmentActivity, dialog);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void y(c cVar, FragmentActivity fragmentActivity, Dialog dialog, View view) {
        if (cVar != null) {
            cVar.onClick(3);
        }
        g0(fragmentActivity, dialog);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void z(c cVar, FragmentActivity fragmentActivity, Dialog dialog, View view) {
        if (cVar != null) {
            cVar.onClick(4);
        }
        g0(fragmentActivity, dialog);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
