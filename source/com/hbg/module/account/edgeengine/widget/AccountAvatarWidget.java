package com.hbg.module.account.edgeengine.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.module.account.R$drawable;
import com.hbg.module.account.index.ui.view.AccountAvatarNewView;
import com.hbg.module.account.index.ui.view.AccountAvatarView;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.huobi.edgeengine.template.widget.Widget;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import rj.n;
import xb.c;

public final class AccountAvatarWidget extends Widget {

    /* renamed from: k0  reason: collision with root package name */
    public static final a f77658k0 = new a((r) null);

    /* renamed from: h0  reason: collision with root package name */
    public String f77659h0;

    /* renamed from: i0  reason: collision with root package name */
    public int f77660i0 = 76;

    /* renamed from: j0  reason: collision with root package name */
    public int f77661j0 = 76;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements ve.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseModuleConfig.a f77662a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccountAvatarWidget f77663b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f77664c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AccountAvatarNewView f77665d;

        public b(BaseModuleConfig.a aVar, AccountAvatarWidget accountAvatarWidget, Context context, AccountAvatarNewView accountAvatarNewView) {
            this.f77662a = aVar;
            this.f77663b = accountAvatarWidget;
            this.f77664c = context;
            this.f77665d = accountAvatarNewView;
        }

        public void a(UserOtherInfoData userOtherInfoData) {
            UserOtherInfoData Z;
            if (userOtherInfoData != null) {
                this.f77662a.I(userOtherInfoData);
            }
            AccountAvatarWidget accountAvatarWidget = this.f77663b;
            Context context = this.f77664c;
            AccountAvatarNewView accountAvatarNewView = this.f77665d;
            String avatar = this.f77662a.getAvatar();
            String str = null;
            boolean b11 = x.b(userOtherInfoData != null ? userOtherInfoData.getHead_image_type() : null, "NFT");
            BaseModuleConfig.a aVar = this.f77662a;
            if (!(aVar == null || (Z = aVar.Z()) == null)) {
                str = Z.getShow_ext_business_tag();
            }
            accountAvatarWidget.e0(context, accountAvatarNewView, avatar, b11, "BIG_V".equals(str));
        }
    }

    public static final void d0(AccountAvatarWidget accountAvatarWidget, AccountAvatarNewView accountAvatarNewView, Context context, String str) {
        if (x.b(str, "1")) {
            accountAvatarWidget.c0(accountAvatarNewView, context);
        }
    }

    public static final void f0(AccountAvatarWidget accountAvatarWidget, Context context, AccountAvatarNewView accountAvatarNewView, String str, boolean z11, boolean z12) {
        accountAvatarWidget.a0(context, accountAvatarNewView, str, z11, z12);
    }

    public static final void g0(AccountAvatarWidget accountAvatarWidget, Context context, AccountAvatarNewView accountAvatarNewView, String str, boolean z11, boolean z12) {
        accountAvatarWidget.a0(context, accountAvatarNewView, str, z11, z12);
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f77659h0 = map.get("refreshStatus");
        String str = map.get("width");
        int i11 = 76;
        this.f77660i0 = str != null ? Integer.parseInt(str) : 76;
        String str2 = map.get("width");
        if (str2 != null) {
            i11 = Integer.parseInt(str2);
        }
        this.f77661j0 = i11;
    }

    public View Q(Context context, n nVar) {
        super.Q(context, nVar);
        AccountAvatarNewView accountAvatarNewView = (AccountAvatarNewView) super.Q(context, nVar);
        c0(accountAvatarNewView, context);
        w(context, this.f77659h0, new xb.a(this, accountAvatarNewView, context), nVar);
        return accountAvatarNewView;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void a0(Context context, AccountAvatarNewView accountAvatarNewView, String str, boolean z11, boolean z12) {
        if (com.hbg.module.libkt.base.ext.b.x(str)) {
            AccountAvatarView avatar = accountAvatarNewView.getAvatar();
            if (avatar != null) {
                avatar.setImageDrawable(context != null ? context.getDrawable(R$drawable.account_user_image) : null);
            }
            accountAvatarNewView.d((int) (((double) this.f77660i0) * 0.88d)).c(z12);
            return;
        }
        AccountAvatarView avatar2 = accountAvatarNewView.getAvatar();
        if (avatar2 != null) {
            int i11 = this.f77660i0;
            avatar2.f(i11, (int) (((double) i11) * 0.88d), str, z11);
        }
        accountAvatarNewView.d(this.f77660i0).c(z12);
    }

    public final void c0(AccountAvatarNewView accountAvatarNewView, Context context) {
        BaseModuleConfig.a a11 = BaseModuleConfig.a();
        if (!a11.a()) {
            e0(context, accountAvatarNewView, (String) null, false, false);
        } else if (a11.Z() == null) {
            HbgBaseProvider hbgBaseProvider = (HbgBaseProvider) b2.a.d().a("/provider/content").navigation();
            if (hbgBaseProvider != null) {
                hbgBaseProvider.a(new b(a11, this, context, accountAvatarNewView));
            }
            e0(context, accountAvatarNewView, (String) null, false, false);
        } else {
            String avatar = a11.getAvatar();
            boolean b11 = x.b(a11.Z().getHead_image_type(), "NFT");
            UserOtherInfoData Z = a11.Z();
            e0(context, accountAvatarNewView, avatar, b11, "BIG_V".equals(Z != null ? Z.getShow_ext_business_tag() : null));
        }
    }

    public final void e0(Context context, AccountAvatarNewView accountAvatarNewView, String str, boolean z11, boolean z12) {
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new c(this, context, accountAvatarNewView, str, z11, z12));
        } else {
            new Handler(Looper.getMainLooper()).post(new xb.b(this, context, accountAvatarNewView, str, z11, z12));
        }
    }

    public View q(Context context) {
        if (context == null) {
            return null;
        }
        AccountAvatarNewView accountAvatarNewView = new AccountAvatarNewView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        accountAvatarNewView.b(new AccountAvatarView(context, (AttributeSet) null, 0, 6, (r) null));
        return accountAvatarNewView;
    }
}
