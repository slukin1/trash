package com.hbg.module.livesquare.adapter;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import he.c;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.d0;
import lc.a5;
import lc.u4;
import lc.w4;
import lc.y4;
import rd.s;

public final class CategoryListAdapter extends he.c<LiveSquareBaseData, c.a<f>> {

    /* renamed from: f  reason: collision with root package name */
    public final SimpleDateFormat f26415f = new SimpleDateFormat("MM-dd HH:mm ");

    /* renamed from: g  reason: collision with root package name */
    public final SimpleDateFormat f26416g = new SimpleDateFormat("HH:mm ");

    /* renamed from: h  reason: collision with root package name */
    public HbgBaseProvider f26417h = ((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());

    /* renamed from: i  reason: collision with root package name */
    public CountDownTimer f26418i;

    public static final class a implements com.hbg.module.content.utls.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f26419a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f26420b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ w4 f26421c;

        public a(LiveDetailBean liveDetailBean, long j11, w4 w4Var) {
            this.f26419a = liveDetailBean;
            this.f26420b = j11;
            this.f26421c = w4Var;
        }

        public void a() {
            this.f26421c.K.setText("00");
            this.f26421c.L.setText("00");
            this.f26421c.O.setText("00");
            this.f26421c.S.setText("00");
        }

        public void b(long j11) {
            LiveDetailBean liveDetailBean = this.f26419a;
            liveDetailBean.currentTime = (liveDetailBean.currentTime - this.f26420b) + j11;
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f26422b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f26423c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f26424d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CategoryListAdapter f26425e;

        public b(View view, long j11, LiveDetailBean liveDetailBean, CategoryListAdapter categoryListAdapter) {
            this.f26422b = view;
            this.f26423c = j11;
            this.f26424d = liveDetailBean;
            this.f26425e = categoryListAdapter;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f26422b) > this.f26423c || (this.f26422b instanceof Checkable)) {
                sVar.e(this.f26422b, currentTimeMillis);
                Bundle bundle = new Bundle();
                bundle.putInt("liveStatus", this.f26424d.status);
                bundle.putString("liveId", this.f26424d.f70249id.toString());
                HbgRouter.i(this.f26425e.f(), "/live/room", bundle);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f26426b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f26427c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f26428d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CategoryListAdapter f26429e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f26430f;

        public c(View view, long j11, LiveDetailBean liveDetailBean, CategoryListAdapter categoryListAdapter, int i11) {
            this.f26426b = view;
            this.f26427c = j11;
            this.f26428d = liveDetailBean;
            this.f26429e = categoryListAdapter;
            this.f26430f = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f26426b) > this.f26427c || (this.f26426b instanceof Checkable)) {
                sVar.e(this.f26426b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f26426b;
                if (this.f26428d.getModuleType() == 4) {
                    HbgBaseProvider k11 = this.f26429e.f26417h;
                    boolean z11 = true;
                    if (k11 == null || !k11.j(this.f26429e.f())) {
                        z11 = false;
                    }
                    if (z11) {
                        if (this.f26428d.appointed == 0) {
                            RequestExtKt.d(v7.b.a().v0(this.f26428d.f70249id.toString()), new CategoryListAdapter$llIntoClick$2$1(this.f26428d, this.f26429e, this.f26430f), CategoryListAdapter$llIntoClick$2$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
                        } else {
                            DialogUtils.c0(this.f26429e.f(), this.f26429e.f().getResources().getString(R$string.n_live_cancel_prepare_hint_dialog), (String) null, this.f26429e.f().getResources().getString(R$string.n_cancel), this.f26429e.f().getResources().getString(R$string.n_confirm), d.f26431a, new CategoryListAdapter$llIntoClick$2$4(this.f26428d, this.f26429e, this.f26430f));
                        }
                    }
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("liveStatus", this.f26428d.status);
                    bundle.putString("liveId", this.f26428d.f70249id.toString());
                    HbgRouter.i(this.f26429e.f(), "/live/room", bundle);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements DialogUtils.b.f {

        /* renamed from: a  reason: collision with root package name */
        public static final d f26431a = new d();

        public final void a(HBDialogFragment hBDialogFragment) {
            if (hBDialogFragment != null) {
                hBDialogFragment.dismiss();
            }
        }
    }

    public CategoryListAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public int getItemViewType(int i11) {
        if (com.hbg.module.libkt.base.ext.b.w(g())) {
            return super.getItemViewType(i11);
        }
        return ((LiveSquareBaseData) g().get(i11)).getViewType();
    }

    public final void l(y4 y4Var, LiveDetailBean liveDetailBean) {
        y4Var.M(liveDetailBean);
        x(y4Var.D, f().getResources().getString(R$string.n_content_live_watched), he.b.e(liveDetailBean.onlineNum.toString()));
        w(liveDetailBean.speakerList, y4Var.E, y4Var.C);
        TextView textView = y4Var.F;
        textView.setText(this.f26415f.format(new Date(liveDetailBean.startTime)) + '-' + this.f26416g.format(new Date(liveDetailBean.finishTime)));
    }

    public final void m(w4 w4Var, LiveDetailBean liveDetailBean, int i11) {
        w4Var.F.setVisibility(0);
        w4Var.I.setBackgroundResource(R$drawable.bg_live_broadcast_tips);
        x(w4Var.N, f().getResources().getString(R$string.n_content_live_watch), he.b.e(liveDetailBean.onlineNum.toString()));
        w4Var.Q.setVisibility(8);
        w(liveDetailBean.speakerList, w4Var.P, w4Var.D);
        w4Var.R.setText(f().getResources().getString(R$string.n_live_look_live));
        w4Var.G.setVisibility(8);
    }

    public final void n(a5 a5Var, LiveDetailBean liveDetailBean) {
        a5Var.F.setVisibility(0);
        a5Var.H.setBackgroundResource(R$drawable.bg_live_broadcast_tips);
        x(a5Var.J, f().getResources().getString(R$string.n_content_live_watch), he.b.e(liveDetailBean.onlineNum.toString()));
        a5Var.L.setVisibility(8);
        w(liveDetailBean.speakerList, a5Var.K, a5Var.D);
        r(a5Var.G, a5Var.E, a5Var.M, R$drawable.bg_live_into_btn, R$drawable.icon_arrow_green_right, R$color.color_12B298);
        a5Var.M.setText(f().getResources().getString(R$string.n_live_look_live));
    }

    public final void o(w4 w4Var, LiveDetailBean liveDetailBean) {
        w4Var.F.setVisibility(8);
        w4Var.I.setBackgroundResource(R$drawable.bg_live_playback_tips);
        x(w4Var.N, f().getResources().getString(R$string.n_content_live_play_time), this.f26415f.format(new Date(liveDetailBean.startTime)), he.b.e(String.valueOf(liveDetailBean.appointedNum)));
        w4Var.Q.setVisibility(8);
        w(liveDetailBean.speakerList, w4Var.P, w4Var.D);
        q(w4Var.E, w4Var.H, w4Var.R, liveDetailBean.appointed == 1, false);
        w4Var.G.setVisibility(0);
        long j11 = liveDetailBean.startTime - liveDetailBean.currentTime;
        if (j11 <= 1000) {
            w4Var.K.setText("00");
            w4Var.L.setText("00");
            w4Var.O.setText("00");
            w4Var.S.setText("00");
            return;
        }
        CountDownTimer countDownTimer = this.f26418i;
        if (countDownTimer != null) {
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f26418i = null;
        }
        this.f26418i = com.hbg.module.content.utls.b.a(f(), j11, w4Var.K, w4Var.L, w4Var.O, w4Var.S, new a(liveDetailBean, j11, w4Var));
    }

    public final void p(a5 a5Var, LiveDetailBean liveDetailBean) {
        a5Var.F.setVisibility(8);
        a5Var.H.setBackgroundResource(R$drawable.bg_live_playback_tips);
        x(a5Var.J, f().getResources().getString(R$string.n_content_live_appointment), he.b.e(String.valueOf(liveDetailBean.appointedNum)));
        a5Var.L.setVisibility(0);
        TextView textView = a5Var.L;
        textView.setText(this.f26415f.format(new Date(liveDetailBean.startTime)) + f().getResources().getString(R$string.n_live_start_playing));
        w(liveDetailBean.speakerList, a5Var.K, a5Var.D);
        q(a5Var.E, a5Var.G, a5Var.M, liveDetailBean.appointed == 1, false);
    }

    public final void q(ImageView imageView, LinearLayout linearLayout, TextView textView, boolean z11, boolean z12) {
        imageView.setVisibility(8);
        if (z12) {
            if (z11) {
                GradientDrawable gradientDrawable = (GradientDrawable) f().getResources().getDrawable(R$drawable.bg_live_into_btn_one);
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(f().getResources().getColor(R$color.color_33F3F3F3));
                }
                linearLayout.setBackground(gradientDrawable);
                textView.setText(f().getResources().getString(R$string.n_live_already_appointment));
                textView.setTextColor(f().getResources().getColor(R$color.white));
                return;
            }
            GradientDrawable gradientDrawable2 = (GradientDrawable) f().getResources().getDrawable(R$drawable.bg_live_into_btn_one);
            if (gradientDrawable2 != null) {
                gradientDrawable2.setColor(f().getResources().getColor(R$color.color_03AD8F));
            }
            linearLayout.setBackground(gradientDrawable2);
            textView.setText(f().getResources().getString(R$string.n_live_make_appointment));
            textView.setTextColor(f().getResources().getColor(R$color.white));
        } else if (z11) {
            linearLayout.setBackground(f().getResources().getDrawable(R$drawable.bg_live_into_prepare));
            textView.setText(f().getResources().getString(R$string.n_live_already_appointment));
            textView.setTextColor(f().getResources().getColor(R$color.color_live_square_two_base));
        } else {
            GradientDrawable gradientDrawable3 = (GradientDrawable) f().getResources().getDrawable(R$drawable.bg_live_into_btn);
            if (gradientDrawable3 != null) {
                gradientDrawable3.setStroke(com.hbg.module.libkt.base.ext.c.a(0.5f), f().getResources().getColor(R$color.color_03AD8F));
            }
            linearLayout.setBackground(gradientDrawable3);
            textView.setText(f().getResources().getString(R$string.n_live_make_appointment));
            textView.setTextColor(f().getResources().getColor(R$color.color_03AD8F));
        }
    }

    public final void r(LinearLayout linearLayout, ImageView imageView, TextView textView, int i11, int i12, int i13) {
        linearLayout.setBackgroundResource(i11);
        imageView.setImageResource(i12);
        textView.setTextColor(f().getResources().getColor(i13));
    }

    public final int s(View view, int i11, int i12) {
        view.setVisibility(i12 == 0 ? 8 : 0);
        return i11;
    }

    public final void t(View view, LinearLayout linearLayout, LiveDetailBean liveDetailBean, int i11) {
        int i12;
        if (liveDetailBean.getViewType() == 4) {
            int d11 = liveDetailBean.getRealPos() % 2 == 1 ? com.hbg.module.libkt.base.ext.c.d(Float.valueOf(9.5f)) : 0;
            if (liveDetailBean.getRealPos() % 2 == 1) {
                i12 = 0;
            } else {
                i12 = com.hbg.module.libkt.base.ext.c.d(Float.valueOf(9.5f));
            }
            view.setPadding(d11, 0, i12, 0);
        }
        s sVar = s.f23381a;
        view.setOnClickListener(new b(view, 800, liveDetailBean, this));
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new c(linearLayout, 800, liveDetailBean, this, i11));
        }
    }

    /* renamed from: u */
    public void onBindViewHolder(c.a<f> aVar, int i11) {
        int i12;
        super.onBindViewHolder(aVar, i11);
        f e11 = aVar.e();
        if (e11 instanceof u4) {
            u4 u4Var = (u4) aVar.e();
            TextView textView = u4Var.B;
            Resources resources = f().getResources();
            View view = u4Var.C;
            int moduleType = ((LiveSquareBaseData) g().get(i11)).getModuleType();
            if (moduleType == 2) {
                i12 = R$string.n_content_live_liveboadcast;
            } else if (moduleType != 4) {
                i12 = R$string.n_content_live_playback;
            } else {
                i12 = R$string.n_content_live_liveboadcast_preview;
            }
            textView.setText(resources.getString(s(view, i12, i11)));
        } else if (e11 instanceof w4) {
            LiveDetailBean liveDetailBean = (LiveDetailBean) g().get(i11);
            ((w4) aVar.e()).M(liveDetailBean);
            int moduleType2 = liveDetailBean.getModuleType();
            if (moduleType2 == 2) {
                m((w4) aVar.e(), liveDetailBean, i11);
            } else if (moduleType2 == 4) {
                o((w4) aVar.e(), liveDetailBean);
            }
            t(((w4) aVar.e()).B, ((w4) aVar.e()).H, liveDetailBean, i11);
        } else if (e11 instanceof a5) {
            LiveDetailBean liveDetailBean2 = (LiveDetailBean) g().get(i11);
            ((a5) aVar.e()).M(liveDetailBean2);
            int moduleType3 = liveDetailBean2.getModuleType();
            if (moduleType3 == 2) {
                n((a5) aVar.e(), liveDetailBean2);
            } else if (moduleType3 == 4) {
                p((a5) aVar.e(), liveDetailBean2);
            }
            t(((a5) aVar.e()).B, ((a5) aVar.e()).G, liveDetailBean2, i11);
        } else if (e11 instanceof y4) {
            LiveDetailBean liveDetailBean3 = (LiveDetailBean) g().get(i11);
            l((y4) aVar.e(), liveDetailBean3);
            t(((y4) aVar.e()).B, (LinearLayout) null, liveDetailBean3, i11);
        }
    }

    /* renamed from: v */
    public c.a<f> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 == 2) {
            return new c.a<>(u4.K(h(), viewGroup, false));
        }
        if (i11 == 3) {
            return new c.a<>(w4.K(h(), viewGroup, false));
        }
        if (i11 != 8) {
            return new c.a<>(a5.K(h(), viewGroup, false));
        }
        return new c.a<>(y4.K(h(), viewGroup, false));
    }

    public final void w(List<? extends LiveSpeaker> list, TextView textView, ImageView imageView) {
        LiveSpeaker liveSpeaker;
        if (!com.hbg.module.libkt.base.ext.b.w(list) && list != null && (liveSpeaker = (LiveSpeaker) list.get(0)) != null) {
            textView.setText(liveSpeaker.nickname);
            com.hbg.module.libkt.base.ext.b.K(imageView, liveSpeaker.avatar, R$drawable.icon_community_user_header);
        }
    }

    public final void x(TextView textView, String str, Object... objArr) {
        d0 d0Var = d0.f56774a;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        textView.setText(String.format(str, Arrays.copyOf(copyOf, copyOf.length)));
    }
}
