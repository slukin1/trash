package com.huochat.community.network.domain;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.places.model.PlaceFields;
import com.huochat.community.R;
import com.huochat.community.util.CollectionTool;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class DomainTool {
    public static final Companion Companion = new Companion((r) null);
    public static final String DOMAIN_PREFIX = "https://";
    public static final String DOMAIN_PREFIX_HTTP = "http://";
    public static final String LOG_TAG = "community_domain";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final String findInDomainList(String str, List<String> list) {
            for (String next : list) {
                try {
                    if (x.b(new URL(next).getHost(), str)) {
                        return next;
                    }
                } catch (MalformedURLException unused) {
                }
            }
            return null;
        }

        public final List<String> getNewDomainListFromDomainMap(Context context, String str, String str2, Map<String, ? extends List<String>> map) {
            if (!isChinaUser(context)) {
                str = str2;
            }
            return setDomainPrefix(map != null ? (List) map.get(str) : null);
        }

        @SuppressLint({"WrongConstant"})
        public final boolean isChinaMobileUser(Context context) {
            String simOperator = ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getSimOperator();
            return !TextUtils.isEmpty(simOperator) && (x.b(simOperator, "46000") || x.b(simOperator, "46001") || x.b(simOperator, "46002") || x.b(simOperator, "46003"));
        }

        public final boolean isChinaTimeZone(Context context) {
            String[] stringArray = context.getResources().getStringArray(R.array.community_utils_china_timezone);
            String id2 = TimeZone.getDefault().getID();
            Log.i(DomainTool.LOG_TAG, "timezone = " + id2);
            Log.i(DomainTool.LOG_TAG, "isChinaTimeZone = " + CollectionsKt__CollectionsKt.n(Arrays.copyOf(stringArray, stringArray.length)).contains(id2));
            return Arrays.asList(Arrays.copyOf(stringArray, stringArray.length)).contains(id2);
        }

        public final boolean isChinaUser(Context context) {
            boolean z11 = true;
            try {
                if (!isChinaMobileUser(context) && !isChinaTimeZone(context)) {
                    z11 = false;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            Log.i(DomainTool.LOG_TAG, "isChinaUser:" + z11);
            return z11;
        }

        public final List<String> setDomainPrefix(List<String> list) {
            int collectionSize = CollectionTool.Companion.getCollectionSize(list);
            for (int i11 = 0; i11 < collectionSize; i11++) {
                String str = list.get(i11);
                if (str == null) {
                    str = "";
                }
                if (!StringsKt__StringsJVMKt.M(str, DomainTool.DOMAIN_PREFIX, false, 2, (Object) null) && !StringsKt__StringsJVMKt.M(str, DomainTool.DOMAIN_PREFIX_HTTP, false, 2, (Object) null)) {
                    list.set(i11, DomainTool.DOMAIN_PREFIX + str);
                }
            }
            return list;
        }
    }
}
