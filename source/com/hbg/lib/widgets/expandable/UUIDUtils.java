package com.hbg.lib.widgets.expandable;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huawei.secure.android.common.ssl.util.f;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import e7.s;
import fv.g;
import java.util.UUID;

public class UUIDUtils {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f72025a = {"a", "b", "c", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "e", f.f38658a, g.f22793a, "h", "i", "j", "k", "l", "m", GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, "o", TtmlNode.TAG_P, "q", "r", s.f70071a, "t", "u", com.sumsub.sns.internal.fingerprint.signalproviders.f.f34662a, "w", "x", "y", "z", "0", "1", "2", "3", "4", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", KvStore.N, "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", KvStore.Y, "Z"};

    public static String a(int i11) {
        StringBuilder sb2 = new StringBuilder(UUID.randomUUID().toString());
        while (sb2.length() < i11) {
            sb2.append(UUID.randomUUID().toString());
        }
        return sb2.substring(0, i11);
    }
}
