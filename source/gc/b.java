package gc;

import android.util.Log;
import com.alibaba.android.arouter.facade.Postcard;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.huochat.community.base.CommunityConstants;
import wf.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f19131a = new b();

    public static /* synthetic */ void d(b bVar, String str, TopicDetailInfo.HeaderInfo headerInfo, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            headerInfo = null;
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        if ((i11 & 8) != 0) {
            str3 = null;
        }
        bVar.b(str, headerInfo, str2, str3);
    }

    public static /* synthetic */ void e(b bVar, String str, TopicDetailInfo.HeaderInfo headerInfo, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            headerInfo = null;
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        if ((i11 & 8) != 0) {
            str3 = null;
        }
        if ((i11 & 16) != 0) {
            str4 = null;
        }
        bVar.c(str, headerInfo, str2, str3, str4);
    }

    public static final void f() {
        String f11 = a.f40622a.f();
        if (f11 == null) {
            f11 = "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("资格地址(isEmpty = ");
        boolean z11 = true;
        sb2.append(f11.length() == 0);
        sb2.append("): ");
        sb2.append(f11);
        Log.d("发布资格", sb2.toString());
        if (f11.length() != 0) {
            z11 = false;
        }
        if (z11) {
            String k11 = BaseModuleConfig.a().k("live/community/join/");
            Log.d("发布资格", "url: " + k11);
            b2.a.d().a("/webView/index").withString("url", k11).navigation();
            return;
        }
        String str = BaseModuleConfig.a().j() + f11;
        Log.d("发布资格", "url: " + str);
        b2.a.d().a("/webView/index").withString("url", str).navigation();
    }

    public final String a(String str, String str2) {
        if (com.hbg.module.libkt.base.ext.b.x(str2)) {
            return "";
        }
        return '&' + str + '=' + str2;
    }

    public final void b(String str, TopicDetailInfo.HeaderInfo headerInfo, String str2, String str3) {
        c(str, headerInfo, str2, (String) null, str3);
    }

    public final void c(String str, TopicDetailInfo.HeaderInfo headerInfo, String str2, String str3, String str4) {
        if (BaseModuleConfig.a().L()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("?hideNav=1&ts=");
            sb2.append(System.currentTimeMillis());
            sb2.append(a(CommunityConstants.TOPIC_ID, str));
            sb2.append(a("topicTitle", headerInfo != null ? headerInfo.getTitle() : null));
            sb2.append(!com.hbg.module.libkt.base.ext.b.x(str4) ? a("symbol", str2) : "");
            sb2.append(a("coin", str4));
            String sb3 = sb2.toString();
            Postcard a11 = b2.a.d().a("/webView/index");
            a11.withString("url", BaseModuleConfig.a().j() + "/microapps" + m6.a.h() + "hbg-publisher-l10n/communt-slate" + sb3).navigation();
            return;
        }
        Postcard a12 = b2.a.d().a("/content/CommunityPublisher");
        if (headerInfo != null) {
            a12.withSerializable("topicInfo", headerInfo);
        }
        if (!com.hbg.module.libkt.base.ext.b.x(str2)) {
            a12.withString("symbol", str2);
        }
        if (!com.hbg.module.libkt.base.ext.b.x(str3)) {
            a12.withString("tradeType", str3);
        }
        a12.navigation();
    }
}
