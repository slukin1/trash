package com.hbg.module.huobi.im.group.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.network.hbg.core.bean.ApplyListBean;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import he.c;
import rd.s;

public final class ApplyUserAdapter extends he.c<ApplyListBean.ApplyUser, c.a<fd.e>> {

    /* renamed from: f  reason: collision with root package name */
    public String f20047f;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20048b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20049c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ApplyUserAdapter f20050d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ApplyListBean.ApplyUser f20051e;

        public a(View view, long j11, ApplyUserAdapter applyUserAdapter, ApplyListBean.ApplyUser applyUser) {
            this.f20048b = view;
            this.f20049c = j11;
            this.f20050d = applyUserAdapter;
            this.f20051e = applyUser;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20048b) > this.f20049c || (this.f20048b instanceof Checkable)) {
                sVar.e(this.f20048b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f20048b;
                this.f20050d.n(this.f20051e.uid);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20052b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20053c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ApplyUserAdapter f20054d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ApplyListBean.ApplyUser f20055e;

        public b(View view, long j11, ApplyUserAdapter applyUserAdapter, ApplyListBean.ApplyUser applyUser) {
            this.f20052b = view;
            this.f20053c = j11;
            this.f20054d = applyUserAdapter;
            this.f20055e = applyUser;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20052b) > this.f20053c || (this.f20052b instanceof Checkable)) {
                sVar.e(this.f20052b, currentTimeMillis);
                TextView textView = (TextView) this.f20052b;
                this.f20054d.n(this.f20055e.uid);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20056b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20057c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ApplyUserAdapter f20058d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20059e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ApplyListBean.ApplyUser f20060f;

        public c(View view, long j11, ApplyUserAdapter applyUserAdapter, int i11, ApplyListBean.ApplyUser applyUser) {
            this.f20056b = view;
            this.f20057c = j11;
            this.f20058d = applyUserAdapter;
            this.f20059e = i11;
            this.f20060f = applyUser;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20056b) > this.f20057c || (this.f20056b instanceof Checkable)) {
                sVar.e(this.f20056b, currentTimeMillis);
                TextView textView = (TextView) this.f20056b;
                DialogUtils.b0(this.f20058d.f(), this.f20058d.f().getResources().getString(R$string.n_otc_use_tip), this.f20058d.f().getResources().getString(R$string.n_live_group_reject_or_not), "", this.f20058d.f().getResources().getString(R$string.n_cancel), this.f20058d.f().getResources().getString(R$string.n_sure), e.f20066a, new f(this.f20058d, this.f20059e, this.f20060f));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20061b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20062c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ApplyUserAdapter f20063d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20064e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ApplyListBean.ApplyUser f20065f;

        public d(View view, long j11, ApplyUserAdapter applyUserAdapter, int i11, ApplyListBean.ApplyUser applyUser) {
            this.f20061b = view;
            this.f20062c = j11;
            this.f20063d = applyUserAdapter;
            this.f20064e = i11;
            this.f20065f = applyUser;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20061b) > this.f20062c || (this.f20061b instanceof Checkable)) {
                sVar.e(this.f20061b, currentTimeMillis);
                TextView textView = (TextView) this.f20061b;
                this.f20063d.m(this.f20064e, this.f20065f.f70223id, 2);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements DialogUtils.b.f {

        /* renamed from: a  reason: collision with root package name */
        public static final e f20066a = new e();

        public final void a(HBDialogFragment hBDialogFragment) {
            if (hBDialogFragment != null) {
                hBDialogFragment.dismiss();
            }
        }
    }

    public static final class f implements DialogUtils.b.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ApplyUserAdapter f20067a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f20068b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ApplyListBean.ApplyUser f20069c;

        public f(ApplyUserAdapter applyUserAdapter, int i11, ApplyListBean.ApplyUser applyUser) {
            this.f20067a = applyUserAdapter;
            this.f20068b = i11;
            this.f20069c = applyUser;
        }

        public final void a(HBDialogFragment hBDialogFragment) {
            if (hBDialogFragment != null) {
                hBDialogFragment.dismiss();
            }
            this.f20067a.m(this.f20068b, this.f20069c.f70223id, 3);
        }
    }

    public ApplyUserAdapter(FragmentActivity fragmentActivity, String str) {
        super(fragmentActivity);
        this.f20047f = str;
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public final void m(int i11, String str, int i12) {
        RequestExtKt.d(v7.b.a().N0(this.f20047f, i12, str), new ApplyUserAdapter$applyAudit$1(this, i11, i12), ApplyUserAdapter$applyAudit$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public final void n(String str) {
        b2.a.d().a("/content/PersonalCenter").withString("uidUnique", str).navigation();
    }

    /* renamed from: o */
    public void onBindViewHolder(c.a<fd.e> aVar, int i11) {
        super.onBindViewHolder(aVar, i11);
        ApplyListBean.ApplyUser applyUser = (ApplyListBean.ApplyUser) g().get(i11);
        aVar.e().M(applyUser);
        aVar.e().H.setText(DateTimeUtils.d(applyUser.createTime));
        s sVar = s.f23381a;
        ImageView imageView = aVar.e().B;
        ApplyListBean.ApplyUser applyUser2 = applyUser;
        imageView.setOnClickListener(new a(imageView, 800, this, applyUser2));
        TextView textView = aVar.e().F;
        textView.setOnClickListener(new b(textView, 800, this, applyUser2));
        TextView textView2 = aVar.e().G;
        int i12 = i11;
        ApplyListBean.ApplyUser applyUser3 = applyUser;
        textView2.setOnClickListener(new c(textView2, 800, this, i12, applyUser3));
        TextView textView3 = aVar.e().C;
        textView3.setOnClickListener(new d(textView3, 800, this, i12, applyUser3));
    }

    /* renamed from: p */
    public c.a<fd.e> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(fd.e.K(h(), viewGroup, false));
    }
}
