package com.hbg.module.content.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentGroupData;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.livesquare.dialog.LivePrepareDialog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;
import rd.s;
import u6.g;

public final class o extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f17903a;

    /* renamed from: b  reason: collision with root package name */
    public List<? extends LiveDetailBean> f17904b;

    /* renamed from: c  reason: collision with root package name */
    public SimpleDateFormat f17905c = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /* renamed from: d  reason: collision with root package name */
    public HbgBaseProvider f17906d = ((HbgBaseProvider) b2.a.d().a("/provider/content").navigation());

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17907b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17908c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ o f17909d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f17910e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f17911f;

        public a(View view, long j11, o oVar, LiveDetailBean liveDetailBean, TextView textView) {
            this.f17907b = view;
            this.f17908c = j11;
            this.f17909d = oVar;
            this.f17910e = liveDetailBean;
            this.f17911f = textView;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17907b) > this.f17908c || (this.f17907b instanceof Checkable)) {
                sVar.e(this.f17907b, currentTimeMillis);
                TextView textView = (TextView) this.f17907b;
                this.f17909d.f(this.f17910e, this.f17911f);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17912b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17913c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ o f17914d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f17915e;

        public b(View view, long j11, o oVar, LiveDetailBean liveDetailBean) {
            this.f17912b = view;
            this.f17913c = j11;
            this.f17914d = oVar;
            this.f17915e = liveDetailBean;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17912b) > this.f17913c || (this.f17912b instanceof Checkable)) {
                sVar.e(this.f17912b, currentTimeMillis);
                this.f17914d.e(this.f17915e.f70249id, this.f17915e.status);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c extends BaseSubscriber<LiveAppointmentData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f17916b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f17917c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f17918d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f17919e;

        public c(FragmentActivity fragmentActivity, LiveDetailBean liveDetailBean, TextView textView, o oVar) {
            this.f17916b = fragmentActivity;
            this.f17917c = liveDetailBean;
            this.f17918d = textView;
            this.f17919e = oVar;
        }

        /* renamed from: a */
        public void onNext(LiveAppointmentData liveAppointmentData) {
            super.onNext(liveAppointmentData);
            FragmentActivity fragmentActivity = this.f17916b;
            if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
                this.f17917c.appointed = 1;
                this.f17918d.setText(this.f17919e.d().getString(R$string.n_live_already_appointment));
                if (liveAppointmentData.getLiveGroup() == null) {
                    LiveAppointmentGroupData liveAppointmentGroupData = new LiveAppointmentGroupData();
                    try {
                        liveAppointmentGroupData.setLiveId(Long.parseLong(this.f17917c.f70249id));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    liveAppointmentData.setLiveGroup(liveAppointmentGroupData);
                }
                new LivePrepareDialog(liveAppointmentData, this.f17917c).show(this.f17916b.getSupportFragmentManager(), "");
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public static final class d extends BaseSubscriber<LiveAppointmentData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f17920b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f17921c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f17922d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f17923e;

        public d(FragmentActivity fragmentActivity, LiveDetailBean liveDetailBean, TextView textView, o oVar) {
            this.f17920b = fragmentActivity;
            this.f17921c = liveDetailBean;
            this.f17922d = textView;
            this.f17923e = oVar;
        }

        /* renamed from: a */
        public void onNext(LiveAppointmentData liveAppointmentData) {
            super.onNext(liveAppointmentData);
            HuobiToastUtil.s(R$string.n_live_cancel_success);
            FragmentActivity fragmentActivity = this.f17920b;
            if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
                this.f17921c.appointed = 0;
                this.f17922d.setText(this.f17923e.d().getString(R$string.n_live_make_appointment));
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            HuobiToastUtil.g(R$string.n_live_cancel_failure);
        }
    }

    public o(Context context) {
        this.f17903a = context;
    }

    public final Drawable c(int i11) {
        Drawable drawable = ContextCompat.getDrawable(this.f17903a, R$drawable.bg_live_type);
        ((GradientDrawable) drawable).setColor(ContextCompat.getColor(this.f17903a, i11));
        return drawable;
    }

    public final Context d() {
        return this.f17903a;
    }

    public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final void e(String str, int i11) {
        Intent intent = new Intent(this.f17903a, LiveDetailActivity.class);
        Context context = this.f17903a;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
        intent.putExtra("liveStatus", i11);
        intent.putExtra("liveId", str);
        this.f17903a.startActivity(intent);
    }

    public final void f(LiveDetailBean liveDetailBean, TextView textView) {
        FragmentActivity fragmentActivity = (FragmentActivity) this.f17903a;
        if (liveDetailBean.appointed == 0) {
            HbgBaseProvider hbgBaseProvider = this.f17906d;
            if (hbgBaseProvider != null && hbgBaseProvider.j(fragmentActivity)) {
                v7.b.a().v0(liveDetailBean.f70249id).b().compose(RxJavaHelper.t((g) null)).subscribe(new c(fragmentActivity, liveDetailBean, textView, this));
                return;
            }
            return;
        }
        v7.b.a().K0(liveDetailBean.f70249id).b().compose(RxJavaHelper.t((g) null)).subscribe(new d(fragmentActivity, liveDetailBean, textView, this));
    }

    public final void g(List<? extends LiveDetailBean> list) {
        this.f17904b = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        List<? extends LiveDetailBean> list = this.f17904b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final void h(TextView textView, String str, Object... objArr) {
        d0 d0Var = d0.f56774a;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        textView.setText(String.format(str, Arrays.copyOf(copyOf, copyOf.length)));
    }

    public Object instantiateItem(ViewGroup viewGroup, int i11) {
        List<? extends LiveDetailBean> list = this.f17904b;
        LiveDetailBean liveDetailBean = list != null ? (LiveDetailBean) list.get(i11) : null;
        View inflate = LayoutInflater.from(this.f17903a).inflate(R$layout.item_live_end_recommend, (ViewGroup) null);
        if (liveDetailBean != null) {
            com.hbg.module.libkt.base.ext.b.L((ImageView) inflate.findViewById(R$id.iv_cover), liveDetailBean.coverImageUrl, 0.0f);
            TextView textView = (TextView) inflate.findViewById(R$id.tv_live_type);
            SafeLottieView safeLottieView = (SafeLottieView) inflate.findViewById(R$id.iv_live_playing);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.ll_live_hint);
            TextView textView2 = (TextView) inflate.findViewById(R$id.tv_play_time);
            ImageView imageView = (ImageView) inflate.findViewById(R$id.iv_icon);
            TextView textView3 = (TextView) inflate.findViewById(R$id.tv_name);
            TextView textView4 = (TextView) inflate.findViewById(R$id.tv_prepare);
            ImageView imageView2 = (ImageView) inflate.findViewById(R$id.iv_into);
            ((TextView) inflate.findViewById(R$id.tv_live_title)).setText(liveDetailBean.title);
            List<LiveSpeaker> list2 = liveDetailBean.speakerList;
            if (list2 != null && list2.size() > 0) {
                LiveSpeaker liveSpeaker = list2.get(0);
                com.hbg.module.libkt.base.ext.b.J(imageView, liveSpeaker != null ? liveSpeaker.avatar : null);
                textView3.setText(liveSpeaker.nickname);
            }
            int i12 = liveDetailBean.status;
            if (i12 == 1) {
                safeLottieView.setVisibility(8);
                textView2.setVisibility(8);
                imageView2.setVisibility(8);
                if (liveDetailBean.appointed == 1) {
                    textView4.setText(this.f17903a.getString(R$string.n_live_already_appointment));
                } else {
                    textView4.setText(this.f17903a.getString(R$string.n_live_make_appointment));
                }
                String string = this.f17903a.getString(R$string.n_content_live_appointment);
                h(textView, string, he.b.e(liveDetailBean.appointedNum + ""));
                linearLayout.setBackground(c(R$color.color_E60066ED));
                s sVar = s.f23381a;
                textView4.setOnClickListener(new a(textView4, 800, this, liveDetailBean, textView4));
            } else if (i12 == 2) {
                safeLottieView.setVisibility(0);
                textView2.setVisibility(0);
                imageView2.setVisibility(0);
                textView2.setText(this.f17905c.format(new Date(liveDetailBean.startTime)));
                String string2 = this.f17903a.getString(R$string.n_content_live_watch);
                h(textView, string2, he.b.e(liveDetailBean.onlineNum + ""));
                linearLayout.setBackground(c(R$color.color_FF7600));
                textView4.setOnClickListener((View.OnClickListener) null);
                textView4.setText(this.f17903a.getString(R$string.n_live_look_live));
            } else if (i12 == 3) {
                safeLottieView.setVisibility(8);
                textView2.setVisibility(8);
                imageView2.setVisibility(0);
                textView4.setOnClickListener((View.OnClickListener) null);
                String string3 = this.f17903a.getString(R$string.n_content_live_watched);
                h(textView, string3, he.b.e(liveDetailBean.onlineNum + ""));
                linearLayout.setBackground(c(R$color.color_E60066ED));
                textView4.setText(this.f17903a.getString(R$string.n_live_look_playback));
            }
            s sVar2 = s.f23381a;
            inflate.setOnClickListener(new b(inflate, 800, this, liveDetailBean));
        }
        viewGroup.addView(inflate);
        return inflate;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return x.b(view, obj);
    }
}
