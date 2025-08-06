package com.google.android.recaptcha.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.huochat.community.network.domain.DomainTool;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.x;

public final class zzfb {
    public static final zzfb zza = new zzfb();
    private static final List zzb = zze(CollectionsKt__CollectionsKt.n("www.recaptcha.net", "www.gstatic.com/recaptcha", "www.gstatic.cn/recaptcha"));

    private zzfb() {
    }

    public static final boolean zza(Uri uri) {
        return zzd(uri) && zzc(uri.toString());
    }

    public static final boolean zzb(Uri uri) {
        return zzd(uri);
    }

    private static final boolean zzc(String str) {
        List<String> list = zzb;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String M : list) {
            if (StringsKt__StringsJVMKt.M(str, M, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean zzd(Uri uri) {
        return !TextUtils.isEmpty(uri.toString()) && x.b(Constants.SCHEME, uri.getScheme()) && !TextUtils.isEmpty(uri.getHost());
    }

    private static final List zze(List list) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(DomainTool.DOMAIN_PREFIX + ((String) it2.next()) + "/");
        }
        return arrayList;
    }
}
