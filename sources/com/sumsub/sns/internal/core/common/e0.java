package com.sumsub.sns.internal.core.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.sumsub.sns.core.MobileSdk;
import com.sumsub.sns.core.SNSModule;
import com.sumsub.sns.core.data.listener.SNSActionResultHandler;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.data.listener.SNSErrorHandler;
import com.sumsub.sns.core.data.listener.SNSEventHandler;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler;
import com.sumsub.sns.core.data.listener.SNSStateChangedHandler;
import com.sumsub.sns.core.data.listener.SNSUrlHandler;
import com.sumsub.sns.core.data.listener.TokenExpirationHandler;
import com.sumsub.sns.core.data.model.SNSDocumentDefinition;
import com.sumsub.sns.core.data.model.SNSInitConfig;
import com.sumsub.sns.core.data.model.SNSSDKState;
import com.sumsub.sns.core.data.model.SNSSupportItem;
import com.sumsub.sns.core.theme.SNSJsonCustomization;
import d10.l;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;

public final class e0 implements MobileSdk {
    public static final b A = new b();
    public static final a B = new a();

    /* renamed from: a  reason: collision with root package name */
    public static final e0 f32018a = new e0();

    /* renamed from: b  reason: collision with root package name */
    public static final String f32019b = "MobileSdkInternal";

    /* renamed from: c  reason: collision with root package name */
    public static String f32020c = "";

    /* renamed from: d  reason: collision with root package name */
    public static int f32021d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static String f32022e = "";

    /* renamed from: f  reason: collision with root package name */
    public static Locale f32023f = i.a();

    /* renamed from: g  reason: collision with root package name */
    public static boolean f32024g;

    /* renamed from: h  reason: collision with root package name */
    public static SNSSDKState f32025h = SNSSDKState.Initial.INSTANCE;

    /* renamed from: i  reason: collision with root package name */
    public static final String f32026i = com.sumsub.sns.a.f30551d;

    /* renamed from: j  reason: collision with root package name */
    public static d10.a<SNSInitConfig> f32027j;

    /* renamed from: k  reason: collision with root package name */
    public static d10.a<? extends Map<String, String>> f32028k;

    /* renamed from: l  reason: collision with root package name */
    public static d10.a<? extends TokenExpirationHandler> f32029l;

    /* renamed from: m  reason: collision with root package name */
    public static d10.a<? extends SNSStateChangedHandler> f32030m;

    /* renamed from: n  reason: collision with root package name */
    public static d10.a<? extends SNSErrorHandler> f32031n;

    /* renamed from: o  reason: collision with root package name */
    public static d10.a<? extends SNSEventHandler> f32032o;

    /* renamed from: p  reason: collision with root package name */
    public static d10.a<? extends SNSJsonCustomization> f32033p;

    /* renamed from: q  reason: collision with root package name */
    public static d10.a<? extends SNSInstructionsViewHandler> f32034q;

    /* renamed from: r  reason: collision with root package name */
    public static d10.a<? extends SNSActionResultHandler> f32035r;

    /* renamed from: s  reason: collision with root package name */
    public static l<? super String, ? extends SNSModule> f32036s;

    /* renamed from: t  reason: collision with root package name */
    public static d10.a<? extends SNSIconHandler> f32037t;

    /* renamed from: u  reason: collision with root package name */
    public static d10.a<? extends SNSCountryPicker> f32038u;

    /* renamed from: v  reason: collision with root package name */
    public static d10.a<? extends List<SNSSupportItem>> f32039v;

    /* renamed from: w  reason: collision with root package name */
    public static l<? super List<SNSSupportItem>, Unit> f32040w;

    /* renamed from: x  reason: collision with root package name */
    public static d10.a<? extends Map<String, SNSDocumentDefinition>> f32041x;

    /* renamed from: y  reason: collision with root package name */
    public static d10.a<Integer> f32042y;

    /* renamed from: z  reason: collision with root package name */
    public static d10.a<? extends SNSUrlHandler> f32043z;

    public static final class a implements SNSCountryPicker {
        public void pickCountry(Context context, List<SNSCountryPicker.CountryItem> list, SNSCountryPicker.SNSCountryPickerCallBack sNSCountryPickerCallBack, String str, String str2) {
            com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, e0.f32019b, "Attempt to call uninitialized MobileSdkInternal", (Throwable) null, 4, (Object) null);
        }
    }

    public static final class b implements SNSIconHandler {
        public Drawable onResolveIcon(Context context, String str) {
            com.sumsub.log.logger.a.a(com.sumsub.sns.internal.log.a.f34862a, e0.f32019b, "Attempt to call uninitialized MobileSdkInternal", (Throwable) null, 4, (Object) null);
            return null;
        }
    }

    public void a(SNSSDKState sNSSDKState) {
        f32025h = sNSSDKState;
    }

    public SNSActionResultHandler getActionResultHandler() {
        d10.a<? extends SNSActionResultHandler> aVar = f32035r;
        if (aVar != null) {
            return (SNSActionResultHandler) aVar.invoke();
        }
        return null;
    }

    public Integer getAutoCloseOnApproveTimeout() {
        d10.a<Integer> aVar = f32042y;
        if (aVar != null) {
            return aVar.invoke();
        }
        return null;
    }

    public SNSInitConfig getConf() {
        d10.a<SNSInitConfig> aVar = f32027j;
        if (aVar != null) {
            return aVar.invoke();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = (com.sumsub.sns.core.data.listener.SNSCountryPicker) r0.invoke();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sumsub.sns.core.data.listener.SNSCountryPicker getCountryPicker() {
        /*
            r1 = this;
            d10.a<? extends com.sumsub.sns.core.data.listener.SNSCountryPicker> r0 = f32038u
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r0.invoke()
            com.sumsub.sns.core.data.listener.SNSCountryPicker r0 = (com.sumsub.sns.core.data.listener.SNSCountryPicker) r0
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            com.sumsub.sns.internal.core.common.e0$a r0 = B
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.e0.getCountryPicker():com.sumsub.sns.core.data.listener.SNSCountryPicker");
    }

    public SNSJsonCustomization getCustomization() {
        d10.a<? extends SNSJsonCustomization> aVar = f32033p;
        if (aVar != null) {
            return (SNSJsonCustomization) aVar.invoke();
        }
        return null;
    }

    public SNSErrorHandler getErrorHandler() {
        d10.a<? extends SNSErrorHandler> aVar = f32031n;
        if (aVar != null) {
            return (SNSErrorHandler) aVar.invoke();
        }
        return null;
    }

    public SNSEventHandler getEventHandler() {
        d10.a<? extends SNSEventHandler> aVar = f32032o;
        if (aVar != null) {
            return (SNSEventHandler) aVar.invoke();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = (com.sumsub.sns.core.data.listener.SNSIconHandler) r0.invoke();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sumsub.sns.core.data.listener.SNSIconHandler getIconHandler() {
        /*
            r1 = this;
            d10.a<? extends com.sumsub.sns.core.data.listener.SNSIconHandler> r0 = f32037t
            if (r0 == 0) goto L_0x000c
            java.lang.Object r0 = r0.invoke()
            com.sumsub.sns.core.data.listener.SNSIconHandler r0 = (com.sumsub.sns.core.data.listener.SNSIconHandler) r0
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            com.sumsub.sns.internal.core.common.e0$b r0 = A
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.e0.getIconHandler():com.sumsub.sns.core.data.listener.SNSIconHandler");
    }

    public SNSInstructionsViewHandler getInstructionsViewHandler() {
        d10.a<? extends SNSInstructionsViewHandler> aVar = f32034q;
        if (aVar != null) {
            return (SNSInstructionsViewHandler) aVar.invoke();
        }
        return null;
    }

    public Locale getLocale() {
        return f32023f;
    }

    public String getPackageName() {
        return f32022e;
    }

    public SNSModule getPluggedModule(String str) {
        l<? super String, ? extends SNSModule> lVar = f32036s;
        if (lVar != null) {
            return (SNSModule) lVar.invoke(str);
        }
        return null;
    }

    public Map<String, SNSDocumentDefinition> getPreferredDocumentsDefinitions() {
        d10.a<? extends Map<String, SNSDocumentDefinition>> aVar = f32041x;
        if (aVar != null) {
            return (Map) aVar.invoke();
        }
        return null;
    }

    public Map<String, String> getSettings() {
        d10.a<? extends Map<String, String>> aVar = f32028k;
        if (aVar != null) {
            return (Map) aVar.invoke();
        }
        return null;
    }

    public SNSSDKState getState() {
        return f32025h;
    }

    public SNSStateChangedHandler getStateChangedHandler() {
        d10.a<? extends SNSStateChangedHandler> aVar = f32030m;
        if (aVar != null) {
            return (SNSStateChangedHandler) aVar.invoke();
        }
        return null;
    }

    public List<SNSSupportItem> getSupportItems() {
        d10.a<? extends List<SNSSupportItem>> aVar = f32039v;
        if (aVar != null) {
            return (List) aVar.invoke();
        }
        return null;
    }

    public TokenExpirationHandler getTokenExpirationHandler() {
        d10.a<? extends TokenExpirationHandler> aVar = f32029l;
        if (aVar != null) {
            return (TokenExpirationHandler) aVar.invoke();
        }
        return null;
    }

    public SNSUrlHandler getUrlHandler() {
        d10.a<? extends SNSUrlHandler> aVar = f32043z;
        if (aVar != null) {
            return (SNSUrlHandler) aVar.invoke();
        }
        return null;
    }

    public String getVersion() {
        return f32026i;
    }

    public int getVersionCode() {
        return f32021d;
    }

    public String getVersionName() {
        return f32020c;
    }

    public boolean isDebug() {
        return f32024g;
    }

    public boolean isModuleAvailable(String str) {
        return a(str);
    }

    public void setSupportItems(List<SNSSupportItem> list) {
        l<? super List<SNSSupportItem>, Unit> lVar = f32040w;
        if (lVar != null) {
            lVar.invoke(list);
        }
    }

    public final boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void a(String str, String str2, int i11) {
        f32022e = str;
        f32020c = str2;
        f32021d = i11;
    }

    public final void a(boolean z11, Locale locale) {
        f32024g = z11;
        f32023f = locale;
    }

    public final void a(d10.a<SNSInitConfig> aVar, d10.a<? extends Map<String, String>> aVar2, d10.a<? extends TokenExpirationHandler> aVar3, d10.a<? extends SNSStateChangedHandler> aVar4, d10.a<? extends SNSErrorHandler> aVar5, d10.a<? extends SNSEventHandler> aVar6, d10.a<? extends SNSJsonCustomization> aVar7, d10.a<? extends SNSInstructionsViewHandler> aVar8, d10.a<? extends SNSActionResultHandler> aVar9, l<? super String, ? extends SNSModule> lVar, d10.a<? extends SNSIconHandler> aVar10, d10.a<? extends SNSCountryPicker> aVar11, d10.a<? extends Map<String, SNSDocumentDefinition>> aVar12, d10.a<Integer> aVar13, d10.a<? extends SNSUrlHandler> aVar14) {
        f32027j = aVar;
        f32028k = aVar2;
        f32029l = aVar3;
        f32030m = aVar4;
        f32031n = aVar5;
        f32032o = aVar6;
        f32033p = aVar7;
        f32034q = aVar8;
        f32035r = aVar9;
        f32036s = lVar;
        f32037t = aVar10;
        f32038u = aVar11;
        f32041x = aVar12;
        f32042y = aVar13;
        f32043z = aVar14;
    }

    public final void a(d10.a<? extends List<SNSSupportItem>> aVar, l<? super List<SNSSupportItem>, Unit> lVar) {
        f32039v = aVar;
        f32040w = lVar;
    }
}
