package com.jumio.core.plugins;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.jumio.core.Controller;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.plugins.Plugin;
import java.util.Map;

public interface AnalyticsPlugin<T extends StaticModel> extends Plugin {

    public static final class DefaultImpls {
        public static <T extends StaticModel> boolean isUsable(AnalyticsPlugin<T> analyticsPlugin, Controller controller, ScanPartModel scanPartModel) {
            return Plugin.DefaultImpls.isUsable(analyticsPlugin, controller, scanPartModel);
        }

        public static <T extends StaticModel> void preload(AnalyticsPlugin<T> analyticsPlugin, Controller controller) {
            Plugin.DefaultImpls.preload(analyticsPlugin, controller);
        }

        public static /* synthetic */ void reportCustomAction$default(AnalyticsPlugin analyticsPlugin, String str, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    map = MapsKt__MapsKt.h();
                }
                analyticsPlugin.reportCustomAction(str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportCustomAction");
        }

        public static /* synthetic */ void reportResponse$default(AnalyticsPlugin analyticsPlugin, String str, String str2, Integer num, int i11, Exception exc, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 16) != 0) {
                    exc = null;
                }
                analyticsPlugin.reportResponse(str, str2, num, i11, exc);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportResponse");
        }

        public static /* synthetic */ void reportViewStart$default(AnalyticsPlugin analyticsPlugin, Object obj, Map map, int i11, Object obj2) {
            if (obj2 == null) {
                if ((i11 & 2) != 0) {
                    map = MapsKt__MapsKt.h();
                }
                analyticsPlugin.reportViewStart(obj, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportViewStart");
        }

        public static /* synthetic */ void reportViewStop$default(AnalyticsPlugin analyticsPlugin, Object obj, Map map, int i11, Object obj2) {
            if (obj2 == null) {
                if ((i11 & 2) != 0) {
                    map = MapsKt__MapsKt.h();
                }
                analyticsPlugin.reportViewStop(obj, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportViewStop");
        }

        public static <T extends StaticModel> void unload(AnalyticsPlugin<T> analyticsPlugin) {
            Plugin.DefaultImpls.unload(analyticsPlugin);
        }
    }

    void attachActivity(AppCompatActivity appCompatActivity);

    void enableDataCollection(boolean z11);

    void reportCustomAction(String str, Map<String, ? extends Object> map);

    void reportRequest(String str, String str2, int i11, String str3);

    void reportResponse(String str, String str2, Integer num, int i11, Exception exc);

    void reportViewStart(Object obj, Map<String, ? extends Object> map);

    void reportViewStop(Object obj, Map<String, ? extends Object> map);

    void run(Context context, T t11);
}
