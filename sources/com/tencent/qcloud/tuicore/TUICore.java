package com.tencent.qcloud.tuicore;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.a;
import com.tencent.qcloud.tuicore.interfaces.ITUIExtension;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.tencent.qcloud.tuicore.interfaces.ITUIObjectFactory;
import com.tencent.qcloud.tuicore.interfaces.ITUIService;
import com.tencent.qcloud.tuicore.interfaces.TUIExtensionInfo;
import com.tencent.qcloud.tuicore.interfaces.TUIServiceCallback;
import java.util.List;
import java.util.Map;

public class TUICore {
    private static final String TAG = "TUICore";

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f48154a = 0;

    public static Object callService(String str, String str2, Map<String, Object> map) {
        return ServiceManager.getInstance().callService(str, str2, map);
    }

    public static Object createObject(String str, String str2, Map<String, Object> map) {
        return ObjectManager.getInstance().createObject(str, str2, map);
    }

    @Deprecated
    public static Map<String, Object> getExtensionInfo(String str, Map<String, Object> map) {
        return ExtensionManager.getInstance().getExtensionInfo(str, map);
    }

    public static List<TUIExtensionInfo> getExtensionList(String str, Map<String, Object> map) {
        return ExtensionManager.getInstance().getExtensionList(str, map);
    }

    public static ITUIService getService(String str) {
        return ServiceManager.getInstance().getService(str);
    }

    public static void notifyEvent(String str, String str2, Map<String, Object> map) {
        EventManager.getInstance().notifyEvent(str, str2, map);
    }

    public static void raiseExtension(String str, View view, Map<String, Object> map) {
        ExtensionManager.getInstance().raiseExtension(str, view, map);
    }

    public static void registerEvent(String str, String str2, ITUINotification iTUINotification) {
        EventManager.getInstance().registerEvent(str, str2, iTUINotification);
    }

    public static void registerExtension(String str, ITUIExtension iTUIExtension) {
        ExtensionManager.getInstance().registerExtension(str, iTUIExtension);
    }

    public static void registerObjectFactory(String str, ITUIObjectFactory iTUIObjectFactory) {
        ObjectManager.getInstance().registerObjectFactory(str, iTUIObjectFactory);
    }

    public static void registerService(String str, ITUIService iTUIService) {
        ServiceManager.getInstance().registerService(str, iTUIService);
    }

    public static void startActivity(String str, Bundle bundle) {
        startActivity((Object) null, str, bundle, -1);
    }

    public static void startActivityForResult(a aVar, String str, Bundle bundle, ActivityResultCallback<ActivityResult> activityResultCallback) {
        TUIRouter.startActivityForResult(aVar, str, bundle, activityResultCallback);
    }

    public static void unRegisterEvent(String str, String str2, ITUINotification iTUINotification) {
        EventManager.getInstance().unRegisterEvent(str, str2, iTUINotification);
    }

    public static void unRegisterExtension(String str, ITUIExtension iTUIExtension) {
        ExtensionManager.getInstance().unRegisterExtension(str, iTUIExtension);
    }

    public static void unregisterObjectFactory(String str) {
        ObjectManager.getInstance().unregisterObjectFactory(str);
    }

    public static void unregisterService(String str) {
        ServiceManager.getInstance().unregisterService(str);
    }

    public static Object callService(String str, String str2, Map<String, Object> map, TUIServiceCallback tUIServiceCallback) {
        return ServiceManager.getInstance().callService(str, str2, map, tUIServiceCallback);
    }

    public static void startActivity(Object obj, String str, Bundle bundle) {
        startActivity(obj, str, bundle, -1);
    }

    public static void startActivityForResult(a aVar, Class<? extends Activity> cls, Bundle bundle, ActivityResultCallback<ActivityResult> activityResultCallback) {
        TUIRouter.startActivityForResult(aVar, cls, bundle, activityResultCallback);
    }

    public static void unRegisterEvent(ITUINotification iTUINotification) {
        EventManager.getInstance().unRegisterEvent(iTUINotification);
    }

    @Deprecated
    public static void startActivity(Object obj, String str, Bundle bundle, int i11) {
        TUIRouter.startActivity(obj, str, bundle, i11);
    }
}
