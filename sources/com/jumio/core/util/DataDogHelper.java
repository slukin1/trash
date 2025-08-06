package com.jumio.core.util;

import androidx.appcompat.app.AppCompatActivity;
import com.jumio.core.ServiceLocator;
import com.jumio.core.models.DataDogModel;
import com.jumio.core.plugins.AnalyticsPlugin;
import java.util.Map;
import jumio.core.d2;
import jumio.core.e2;
import jumio.core.u0;
import kotlin.jvm.internal.Lambda;

public final class DataDogHelper {
    public static final DataDogHelper INSTANCE = new DataDogHelper();

    public static final class a extends Lambda implements d10.a<e2> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f39503a = new a();

        public a() {
            super(0);
        }

        public final Object invoke() {
            return new u0();
        }
    }

    public static /* synthetic */ void reportCustomAction$default(DataDogHelper dataDogHelper, String str, Map map, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            map = MapsKt__MapsKt.h();
        }
        dataDogHelper.reportCustomAction(str, map);
    }

    public static /* synthetic */ void reportViewStop$default(DataDogHelper dataDogHelper, Object obj, Map map, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            map = MapsKt__MapsKt.h();
        }
        dataDogHelper.reportViewStop(obj, map);
    }

    public final void attachActivity(AppCompatActivity appCompatActivity) {
        AnalyticsPlugin<DataDogModel> plugin = getPlugin();
        if (plugin != null) {
            plugin.attachActivity(appCompatActivity);
        }
    }

    public final AnalyticsPlugin<DataDogModel> getPlugin() {
        return (AnalyticsPlugin) ((e2) ServiceLocator.INSTANCE.getServiceImplementation(e2.class, a.f39503a)).a(d2.DATADOG);
    }

    public final void reportCustomAction(String str, Map<String, ? extends Object> map) {
        AnalyticsPlugin<DataDogModel> plugin = getPlugin();
        if (plugin != null) {
            plugin.reportCustomAction(str, map);
        }
    }

    public final void reportViewStart(Object obj) {
        AnalyticsPlugin<DataDogModel> plugin = getPlugin();
        if (plugin != null) {
            AnalyticsPlugin.DefaultImpls.reportViewStart$default(plugin, obj, (Map) null, 2, (Object) null);
        }
    }

    public final void reportViewStop(Object obj, Map<String, ? extends Object> map) {
        AnalyticsPlugin<DataDogModel> plugin = getPlugin();
        if (plugin != null) {
            plugin.reportViewStop(obj, map);
        }
    }
}
