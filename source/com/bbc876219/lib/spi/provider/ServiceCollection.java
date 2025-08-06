package com.bbc876219.lib.spi.provider;

import android.os.Build;
import androidx.annotation.Keep;
import com.bbc876219.lib.spi.provider.a;
import com.bbc876219.lib.spi.provider.utils.ServiceKeyList;
import com.google.common.collect.ImmutableMap;
import java.util.HashSet;
import java.util.Set;

@Keep
public final class ServiceCollection {
    public static String AppId = "pro.huobi";
    public static int SdkVersin = Build.VERSION.SDK_INT;
    public static ImmutableMap.Builder<Class<?>, a.b> builder;
    public static Set<String> dynamicCollection = new HashSet();
    public static ServiceKeyList keyList;
    public static ImmutableMap<Class<?>, a.b> serviceclasses;

    static {
        System.out.println(" static init{} ");
    }

    private ServiceCollection() {
        System.out.println(" init{} ");
    }
}
