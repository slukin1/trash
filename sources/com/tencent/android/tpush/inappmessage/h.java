package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.stat.ServiceStat;

abstract class h extends a {

    /* renamed from: d  reason: collision with root package name */
    public d f69389d;

    /* renamed from: e  reason: collision with root package name */
    public String f69390e = "PopupMessageTemplate";

    /* renamed from: f  reason: collision with root package name */
    public Intent f69391f;

    public h(Activity activity, d dVar, Intent intent) {
        super(activity);
        this.f69389d = dVar;
        this.f69391f = intent;
        a();
    }

    private View d(Context context) {
        if (this.f69389d.f() == 1) {
            Button button = new Button(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, SizeUtil.dipTopx(context, 48.0f));
            layoutParams.setMargins(SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f));
            layoutParams.gravity = 1;
            button.setLayoutParams(layoutParams);
            button.setBackgroundColor(Color.parseColor(this.f69389d.I()));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius((float) this.f69389d.l());
            gradientDrawable.setColor(Color.parseColor(this.f69389d.I()));
            button.setBackground(gradientDrawable);
            button.setText(this.f69389d.w());
            button.setTextColor(Color.parseColor(this.f69389d.J()));
            button.setTextSize((float) this.f69389d.k());
            button.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    h.this.f69391f.putExtra(MessageKey.MSG_INAPP_CUSTOM_EVENT_ID, "INNER_MESSAGE");
                    h hVar = h.this;
                    hVar.f69391f.putExtra(MessageKey.MSG_INAPP_BUTTON_EVENT_ID, hVar.f69389d.m());
                    ServiceStat.appReportNotificationClicked(b.e(), h.this.f69391f);
                    String n11 = h.this.f69389d.n();
                    int d11 = h.this.f69389d.d();
                    if (d11 == 1) {
                        h.this.cancel();
                    } else if (d11 == 2) {
                        h.this.b(n11);
                    } else if (d11 == 3) {
                        h.this.a(n11);
                    } else if (d11 == 4) {
                        h.this.g();
                    }
                    h.this.cancel();
                    h.this.f69339b.finish();
                    h.this.f69339b.overridePendingTransition(0, 0);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            return button;
        } else if (this.f69389d.f() != 2) {
            return null;
        } else {
            LinearLayout linearLayout = new LinearLayout(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, SizeUtil.dipTopx(context, 48.0f));
            layoutParams2.setMargins(SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f));
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setOrientation(0);
            Button button2 = new Button(context);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams3.gravity = 3;
            button2.setLayoutParams(layoutParams3);
            button2.setBackgroundColor(Color.parseColor(this.f69389d.I()));
            button2.setText(this.f69389d.w());
            button2.setTextColor(Color.parseColor(this.f69389d.J()));
            button2.setTextSize((float) this.f69389d.k());
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius((float) this.f69389d.l());
            gradientDrawable2.setColor(Color.parseColor(this.f69389d.I()));
            button2.setBackground(gradientDrawable2);
            button2.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    String n11 = h.this.f69389d.n();
                    h.this.f69391f.putExtra(MessageKey.MSG_INAPP_CUSTOM_EVENT_ID, "INNER_MESSAGE");
                    h hVar = h.this;
                    hVar.f69391f.putExtra(MessageKey.MSG_INAPP_BUTTON_EVENT_ID, hVar.f69389d.m());
                    ServiceStat.appReportNotificationClicked(b.e(), h.this.f69391f);
                    int d11 = h.this.f69389d.d();
                    if (d11 == 1) {
                        h.this.cancel();
                    } else if (d11 == 2) {
                        h.this.b(n11);
                    } else if (d11 == 3) {
                        h.this.a(n11);
                    } else if (d11 == 4) {
                        h.this.g();
                    }
                    h.this.cancel();
                    h.this.f69339b.finish();
                    h.this.f69339b.overridePendingTransition(0, 0);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            linearLayout.addView(button2);
            View view = new View(context);
            view.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.2f));
            linearLayout.addView(view);
            Button button3 = new Button(context);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams4.gravity = 5;
            button3.setLayoutParams(layoutParams4);
            button3.setBackgroundColor(Color.parseColor(this.f69389d.u()));
            button3.setText(this.f69389d.t());
            button3.setTextColor(Color.parseColor(this.f69389d.s()));
            button3.setTextSize((float) this.f69389d.r());
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(0);
            gradientDrawable3.setCornerRadius((float) this.f69389d.q());
            gradientDrawable3.setColor(Color.parseColor(this.f69389d.u()));
            button3.setBackground(gradientDrawable3);
            button3.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    String o11 = h.this.f69389d.o();
                    h.this.f69391f.putExtra(MessageKey.MSG_INAPP_CUSTOM_EVENT_ID, "INNER_MESSAGE");
                    h hVar = h.this;
                    hVar.f69391f.putExtra(MessageKey.MSG_INAPP_BUTTON_EVENT_ID, hVar.f69389d.p());
                    ServiceStat.appReportNotificationClicked(b.e(), h.this.f69391f);
                    int c11 = h.this.f69389d.c();
                    if (c11 == 1) {
                        h.this.cancel();
                    } else if (c11 == 2) {
                        h.this.b(o11);
                    } else if (c11 == 3) {
                        h.this.a(o11);
                    } else if (c11 == 4) {
                        h.this.g();
                    }
                    h.this.cancel();
                    h.this.f69339b.finish();
                    h.this.f69339b.overridePendingTransition(0, 0);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            linearLayout.addView(button3);
            return linearLayout;
        }
    }

    private TextView e(Context context) {
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int D = this.f69389d.D();
        if (D == 0) {
            layoutParams.gravity = 3;
        } else if (D == 1) {
            layoutParams.gravity = 1;
        } else if (D == 2) {
            layoutParams.gravity = 5;
        }
        textView.setLayoutParams(layoutParams);
        textView.setPadding(SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), 0);
        textView.setText(this.f69389d.F());
        textView.setTextColor(Color.parseColor(this.f69389d.G()));
        textView.setTextSize(2, (float) this.f69389d.C());
        textView.setMaxLines(8);
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        int E = this.f69389d.E();
        if (E == 0) {
            textView.setTypeface(Typeface.DEFAULT);
        } else if (E == 1) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (E == 2) {
            textView.setTypeface((Typeface) null, 2);
        } else if (E == 3) {
            textView.getPaint().setFlags(8);
        }
        return textView;
    }

    /* access modifiers changed from: private */
    public void g() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", this.f69339b.getPackageName());
            intent.putExtra("android.intent.extra.CHANNEL_ID", this.f69339b.getApplicationInfo().uid);
            intent.putExtra("app_package", this.f69339b.getPackageName());
            intent.putExtra("app_uid", this.f69339b.getApplicationInfo().uid);
            this.f69339b.startActivity(intent);
        } catch (Exception e11) {
            e11.printStackTrace();
            Intent intent2 = new Intent();
            intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.fromParts("package", this.f69339b.getPackageName(), (String) null));
            this.f69339b.startActivity(intent2);
        }
    }

    public boolean c() {
        return this.f69389d.e() == 1;
    }

    private RelativeLayout b(RelativeLayout relativeLayout) {
        if (this.f69389d.v() != null && !TextUtils.isEmpty(this.f69389d.v())) {
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setShape(i.a(this.f69389d.g()));
            shapeDrawable.getPaint().setColor(Color.parseColor(this.f69389d.v()));
            relativeLayout.setBackground(shapeDrawable);
        }
        if (this.f69389d.H() != null && !TextUtils.isEmpty(this.f69389d.H())) {
            relativeLayout.setBackgroundColor(-1);
            new f(this.f69389d.H(), relativeLayout, this.f69339b, this.f69389d.g()).execute(new Void[0]);
        }
        return relativeLayout;
    }

    private TextView c(Context context) {
        TextView textView = new TextView(context);
        textView.setPadding(SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), SizeUtil.dipTopx(context, 24.0f), 0);
        textView.setText(this.f69389d.x());
        textView.setTextColor(Color.parseColor(this.f69389d.y()));
        textView.setTextSize(2, (float) this.f69389d.A());
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView.setSingleLine(true);
        int z11 = this.f69389d.z();
        if (z11 == 0) {
            textView.setTypeface(Typeface.DEFAULT);
        } else if (z11 == 1) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (z11 == 2) {
            textView.setTypeface((Typeface) null, 2);
        } else if (z11 == 3) {
            textView.getPaint().setFlags(8);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int B = this.f69389d.B();
        if (B == 0) {
            layoutParams.gravity = 3;
        } else if (B == 1) {
            layoutParams.gravity = 1;
        } else if (B == 2) {
            layoutParams.gravity = 5;
        }
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public void a(RelativeLayout relativeLayout) {
        View d11;
        View d12;
        View d13;
        View d14;
        ScrollView scrollView = new ScrollView(this.f69339b);
        scrollView.setVerticalScrollBarEnabled(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(this.f69339b);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        String a11 = this.f69389d.a(1);
        if ("Title.Location".equals(a11) && !TextUtils.isEmpty(this.f69389d.x())) {
            linearLayout.addView(c(this.f69339b));
        } else if ("Message.Location".equals(a11) && !TextUtils.isEmpty(this.f69389d.F())) {
            linearLayout.addView(e(this.f69339b));
        } else if ("Media.Location".equals(a11) && !TextUtils.isEmpty(this.f69389d.h())) {
            linearLayout.addView(a((Context) this.f69339b));
        } else if ("Button.Location".equals(a11) && this.f69389d.f() > 0 && (d14 = d(this.f69339b)) != null) {
            linearLayout.addView(d14);
        }
        String a12 = this.f69389d.a(2);
        if ("Title.Location".equals(a12) && !TextUtils.isEmpty(this.f69389d.x())) {
            linearLayout.addView(c(this.f69339b));
        } else if ("Message.Location".equals(a12) && !TextUtils.isEmpty(this.f69389d.F())) {
            linearLayout.addView(e(this.f69339b));
        } else if ("Media.Location".equals(a12) && !TextUtils.isEmpty(this.f69389d.h())) {
            linearLayout.addView(a((Context) this.f69339b));
        } else if ("Button.Location".equals(a12) && this.f69389d.f() > 0 && (d13 = d(this.f69339b)) != null) {
            linearLayout.addView(d13);
        }
        String a13 = this.f69389d.a(3);
        if ("Title.Location".equals(a13) && !TextUtils.isEmpty(this.f69389d.x())) {
            linearLayout.addView(c(this.f69339b));
        } else if ("Message.Location".equals(a13) && !TextUtils.isEmpty(this.f69389d.F())) {
            linearLayout.addView(e(this.f69339b));
        } else if ("Media.Location".equals(a13) && !TextUtils.isEmpty(this.f69389d.h())) {
            linearLayout.addView(a((Context) this.f69339b));
        } else if ("Button.Location".equals(a13) && this.f69389d.f() > 0 && (d12 = d(this.f69339b)) != null) {
            linearLayout.addView(d12);
        }
        String a14 = this.f69389d.a(4);
        if ("Title.Location".equals(a14) && !TextUtils.isEmpty(this.f69389d.x())) {
            linearLayout.addView(c(this.f69339b));
        } else if ("Message.Location".equals(a14) && !TextUtils.isEmpty(this.f69389d.F())) {
            linearLayout.addView(e(this.f69339b));
        } else if ("Media.Location".equals(a14) && !TextUtils.isEmpty(this.f69389d.h())) {
            linearLayout.addView(a((Context) this.f69339b));
        } else if ("Button.Location".equals(a14) && this.f69389d.f() > 0 && (d11 = d(this.f69339b)) != null) {
            linearLayout.addView(d11);
        }
        b(relativeLayout);
        scrollView.addView(linearLayout);
        relativeLayout.addView(scrollView);
    }

    private ImageView b(Context context) {
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f69389d.i(), this.f69389d.j());
        layoutParams.gravity = 1;
        layoutParams.topMargin = SizeUtil.dipTopx(context, 24.0f);
        layoutParams.leftMargin = SizeUtil.dipTopx(context, 24.0f);
        layoutParams.rightMargin = SizeUtil.dipTopx(context, 24.0f);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        try {
            Intent intent = new Intent();
            String str2 = this.f69390e;
            TLogger.i(str2, "jumpIntent targetActivity:" + str);
            Uri parse = Uri.parse(str);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            if (intent.resolveActivity(this.f69339b.getPackageManager()) != null) {
                this.f69339b.startActivity(intent);
            }
        } catch (Throwable th2) {
            TLogger.e(this.f69390e, "jumpIntent error.", th2);
        }
    }

    private ImageView a(Context context) {
        ImageView b11 = b((Context) this.f69339b);
        new f(this.f69389d.h(), b11, this.f69339b, 0).execute(new Void[0]);
        return b11;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        try {
            String str2 = this.f69390e;
            TLogger.i(str2, "jumpUrl targetActivity :" + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            this.f69339b.startActivity(intent);
        } catch (Throwable th2) {
            TLogger.e(this.f69390e, "openUrl error.", th2);
        }
    }
}
