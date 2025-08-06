package com.hbg.module.community.adapter;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.community.adapter.CommunityBaseCommonBinder;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.helper.s3.S3UploadInterface;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;

public final class CommunityBaseCommonBinder$onBindShareAction$1$1 implements S3UploadInterface {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder<ItemData, SubViewHolder> f17026a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f17027b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f17028c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f17029d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f17030e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ CommunityBaseCommonBinder.a f17031f;

    public CommunityBaseCommonBinder$onBindShareAction$1$1(CommunityBaseCommonBinder<ItemData, SubViewHolder> communityBaseCommonBinder, Context context, String str, CommunityFeedInfo.ListBean listBean, int i11, CommunityBaseCommonBinder.a aVar) {
        this.f17026a = communityBaseCommonBinder;
        this.f17027b = context;
        this.f17028c = str;
        this.f17029d = listBean;
        this.f17030e = i11;
        this.f17031f = aVar;
    }

    public void upLoadCallback(int i11, String str, String str2) {
        if (i11 != 0 || b.x(str2)) {
            HuobiToastUtil.g(R$string.n_service_error);
            return;
        }
        HbgBaseShareProvider F = this.f17026a.F();
        if (F != null) {
            String str3 = this.f17028c;
            BaseModuleConfig.a a11 = BaseModuleConfig.a();
            F.b((FragmentActivity) this.f17027b, str3, "", a11.k("views/feed/details/community-details/" + this.f17029d.getId()), "community", str2, String.valueOf(this.f17029d.getId()), this.f17030e, new CommunityBaseCommonBinder$onBindShareAction$1$1$upLoadCallback$1(this.f17029d, this.f17031f));
        }
    }
}
