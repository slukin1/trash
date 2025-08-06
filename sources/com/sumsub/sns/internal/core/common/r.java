package com.sumsub.sns.internal.core.common;

import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.huochat.community.network.domain.DomainTool;
import com.sumsub.sns.internal.log.a;

public final class r {
    public static final void a(Fragment fragment, String str) {
        String str2;
        if (StringsKt__StringsJVMKt.M(str, DomainTool.DOMAIN_PREFIX_HTTP, false, 2, (Object) null) || StringsKt__StringsJVMKt.M(str, DomainTool.DOMAIN_PREFIX, false, 2, (Object) null)) {
            str2 = str;
        } else {
            str2 = DomainTool.DOMAIN_PREFIX + str;
        }
        try {
            fragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
        } catch (Exception e11) {
            a.f34862a.e(i.a((Object) fragment), "Can't open url " + str, e11);
        }
    }
}
