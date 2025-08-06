package com.huobi.account.ui;

import android.net.Uri;
import com.hbg.lib.network.hbg.core.bean.S3TokenBean;
import com.huobi.account.ui.UserNftSettingActivity;
import d10.l;

public final /* synthetic */ class h6 implements l {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserNftSettingActivity f41702b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Uri f41703c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ UserNftSettingActivity.b f41704d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f41705e;

    public /* synthetic */ h6(UserNftSettingActivity userNftSettingActivity, Uri uri, UserNftSettingActivity.b bVar, String str) {
        this.f41702b = userNftSettingActivity;
        this.f41703c = uri;
        this.f41704d = bVar;
        this.f41705e = str;
    }

    public final Object invoke(Object obj) {
        return this.f41702b.Oi(this.f41703c, this.f41704d, this.f41705e, (S3TokenBean) obj);
    }
}
