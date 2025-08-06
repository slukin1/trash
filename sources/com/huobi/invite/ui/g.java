package com.huobi.invite.ui;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.invite.bean.InvitePosterItem;
import com.huobi.invite.helper.InviteReturnHelper;
import com.huobi.utils.x;
import java.util.ArrayList;
import pro.huobi.R;

public final class g {

    /* renamed from: b  reason: collision with root package name */
    public static g f74635b;

    /* renamed from: a  reason: collision with root package name */
    public CommonShareFragment f74636a;

    public class a extends EasySubscriber<ArrayList<InvitePosterItem>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f74637b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f74638c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f74639d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f74640e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f74641f;

        public a(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4) {
            this.f74637b = fragmentActivity;
            this.f74638c = str;
            this.f74639d = str2;
            this.f74640e = str3;
            this.f74641f = str4;
        }

        /* renamed from: a */
        public void onNext(ArrayList<InvitePosterItem> arrayList) {
            super.onNext(arrayList);
            g.this.f(this.f74637b, this.f74638c, this.f74639d, arrayList, this.f74640e, this.f74641f);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            HuobiToastUtil.g(R.string.invite_share_poster_none);
        }
    }

    public static g c() {
        if (f74635b == null) {
            f74635b = new g();
        }
        return f74635b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(DialogInterface dialogInterface) {
        this.f74636a = null;
    }

    public final String d(String str) {
        String str2;
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            if (x.d()) {
                str2 = DomainSwitcher.C();
            } else {
                str2 = DomainSwitcher.E();
            }
        } else if (x.d()) {
            str2 = DomainSwitcher.D();
        } else {
            str2 = DomainSwitcher.F();
        }
        return str2 + str;
    }

    public final void f(FragmentActivity fragmentActivity, String str, String str2, ArrayList<InvitePosterItem> arrayList, String str3, String str4) {
        if (!x.e(arrayList)) {
            CommonShareFragment commonShareFragment = this.f74636a;
            if (commonShareFragment == null || !commonShareFragment.isVisible()) {
                this.f74636a = new CommonShareFragment();
                if (TextUtils.isEmpty(str)) {
                    str = d(str2);
                }
                this.f74636a.Mh(str2);
                this.f74636a.Nh(str);
                this.f74636a.Rh(str3);
                this.f74636a.Ph(str4);
                this.f74636a.Qh(arrayList);
                this.f74636a.Oh(new f(this));
                this.f74636a.show(fragmentActivity.getSupportFragmentManager(), "invite_poster_share[17]");
                return;
            }
            return;
        }
        HuobiToastUtil.g(R.string.invite_share_poster_none);
    }

    public void g(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4) {
        if (!NetworkStatus.c(fragmentActivity)) {
            HuobiToastUtil.j(R.string.server_error);
        } else {
            InviteReturnHelper.a().compose(RxJavaHelper.t((u6.g) null)).subscribe(new a(fragmentActivity, str, str2, str3, str4));
        }
    }
}
