package com.appsflyer.internal;

import com.appsflyer.AFLogger;

final class al {
    private b valueOf = new b() {
        public final Class<?> valueOf(String str) throws ClassNotFoundException {
            return Class.forName(str);
        }
    };

    public interface b {
        Class<?> valueOf(String str) throws ClassNotFoundException;
    }

    public enum c {
        ADOBE_AIR("android_adobe_air", "com.appsflyer.adobeair.AppsFlyerExtension"),
        ADOBE_MOBILE_SDK("android_adobe_mobile", "com.appsflyer.adobeextension.AppsFlyerAdobeExtension"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        CORDOVA("android_cordova", "com.appsflyer.cordova.plugin.AppsFlyerPlugin"),
        DEFAULT("android_native", "android_native"),
        FLUTTER("android_flutter", "com.appsflyer.appsflyersdk.AppsflyerSdkPlugin"),
        M_PARTICLE("android_mparticle", "com.mparticle.kits.AppsFlyerKit"),
        NATIVE_SCRIPT("android_native_script", "com.tns.NativeScriptActivity"),
        REACT_NATIVE("android_reactNative", "com.appsflyer.reactnative.RNAppsFlyerModule"),
        SEGMENT("android_segment", "com.segment.analytics.android.integrations.appsflyer.AppsflyerIntegration"),
        UNITY("android_unity", "com.appsflyer.unity.AppsFlyerAndroidWrapper"),
        UNREAL_ENGINE("android_unreal", "com.epicgames.ue4.GameActivity"),
        XAMARIN("android_xamarin", "mono.android.app.XamarinAndroidEnvironmentVariables");
        
        /* access modifiers changed from: private */
        public String onAttributionFailureNative;
        /* access modifiers changed from: private */
        public String onDeepLinkingNative;

        private c(String str, String str2) {
            this.onAttributionFailureNative = str;
            this.onDeepLinkingNative = str2;
        }
    }

    private boolean valueOf(String str) {
        try {
            this.valueOf.valueOf(str);
            StringBuilder sb2 = new StringBuilder("Class: ");
            sb2.append(str);
            sb2.append(" is found.");
            AFLogger.AFInAppEventParameterName(sb2.toString());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th2) {
            AFLogger.AFInAppEventType(th2.getMessage(), th2);
            return false;
        }
    }

    public final String AFInAppEventParameterName() {
        for (c cVar : c.values()) {
            if (valueOf(cVar.onDeepLinkingNative)) {
                return cVar.onAttributionFailureNative;
            }
        }
        return c.DEFAULT.onAttributionFailureNative;
    }
}
