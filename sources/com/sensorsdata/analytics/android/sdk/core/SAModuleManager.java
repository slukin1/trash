package com.sensorsdata.analytics.android.sdk.core;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.core.mediator.ModuleConstants;
import com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertModuleProtocol;
import com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol;
import com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAScanListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public class SAModuleManager {
    private static volatile SAModuleManager mSingleton;
    private Map<String, SAModuleProtocol> mServiceMap = new HashMap();

    private SAModuleManager() {
    }

    public static SAModuleManager getInstance() {
        if (mSingleton == null) {
            synchronized (SAModuleManager.class) {
                if (mSingleton == null) {
                    mSingleton = new SAModuleManager();
                }
            }
        }
        return mSingleton;
    }

    public SAAdvertModuleProtocol getAdvertModuleService() {
        return (SAAdvertModuleProtocol) getService(ModuleConstants.ModuleName.ADVERT_NAME, SAAdvertModuleProtocol.class);
    }

    public <T> T getService(String str, Class<T> cls) {
        try {
            SAModuleProtocol sAModuleProtocol = this.mServiceMap.get(str);
            if (sAModuleProtocol != null) {
                return cls.cast(sAModuleProtocol);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean handlerScanUri(Activity activity, Uri uri) {
        if (uri != null && !TextUtils.isEmpty(uri.getHost()) && !this.mServiceMap.isEmpty()) {
            for (SAModuleProtocol next : this.mServiceMap.values()) {
                if (next.isEnable() && (next instanceof SAScanListener) && ((SAScanListener) next).handlerScanUri(activity, uri)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasModuleByName(String str) {
        if (!TextUtils.isEmpty(str) && this.mServiceMap.containsKey(str)) {
            return this.mServiceMap.get(str).isEnable();
        }
        return false;
    }

    public void installService(Context context, SAConfigOptions sAConfigOptions) {
        Iterator<S> it2 = ServiceLoader.load(SAModuleProtocol.class).iterator();
        while (it2.hasNext()) {
            SAModuleProtocol sAModuleProtocol = (SAModuleProtocol) it2.next();
            if (sAModuleProtocol != null) {
                sAModuleProtocol.install(context, sAConfigOptions);
                this.mServiceMap.put(sAModuleProtocol.getModuleName(), sAModuleProtocol);
            }
        }
    }

    public void setModuleState(boolean z11) {
        for (SAModuleProtocol moduleState : this.mServiceMap.values()) {
            moduleState.setModuleState(z11);
        }
    }

    public void setModuleStateByName(String str, boolean z11) {
        SAModuleProtocol sAModuleProtocol;
        if (this.mServiceMap.containsKey(str) && (sAModuleProtocol = this.mServiceMap.get(str)) != null && z11 != sAModuleProtocol.isEnable()) {
            sAModuleProtocol.setModuleState(z11);
        }
    }
}
