package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.impl.Utils;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.OnTokenListener;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b extends AGConnectInstance {

    /* renamed from: a  reason: collision with root package name */
    private static List<Service> f37531a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, AGConnectInstance> f37532b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static String f37533c;

    /* renamed from: d  reason: collision with root package name */
    private final AGConnectOptions f37534d;

    /* renamed from: e  reason: collision with root package name */
    private final d f37535e;

    /* renamed from: f  reason: collision with root package name */
    private final d f37536f;

    public b(AGConnectOptions aGConnectOptions) {
        Log.d("AGC_Instance", "AGConnectInstanceImpl init");
        this.f37534d = aGConnectOptions;
        if (f37531a == null) {
            Log.e("AGC_Instance", "please call `initialize()` first");
        }
        this.f37535e = new d(f37531a, aGConnectOptions.getContext());
        d dVar = new d((List<Service>) null, aGConnectOptions.getContext());
        this.f37536f = dVar;
        if (aGConnectOptions instanceof com.huawei.agconnect.config.impl.b) {
            dVar.a(((com.huawei.agconnect.config.impl.b) aGConnectOptions).a(), aGConnectOptions.getContext());
        }
        Log.d("AGC_Instance", "AGConnectInstanceImpl init end");
    }

    public static AGConnectInstance a() {
        String str = f37533c;
        if (str == null) {
            str = Utils.DEFAULT_NAME;
        }
        return a(str);
    }

    public static AGConnectInstance a(AGConnectOptions aGConnectOptions) {
        return a(aGConnectOptions, false);
    }

    private static synchronized AGConnectInstance a(AGConnectOptions aGConnectOptions, boolean z11) {
        AGConnectInstance aGConnectInstance;
        synchronized (b.class) {
            Map<String, AGConnectInstance> map = f37532b;
            aGConnectInstance = map.get(aGConnectOptions.getIdentifier());
            if (aGConnectInstance == null || z11) {
                aGConnectInstance = new b(aGConnectOptions);
                map.put(aGConnectOptions.getIdentifier(), aGConnectInstance);
            }
        }
        return aGConnectInstance;
    }

    public static synchronized AGConnectInstance a(String str) {
        AGConnectInstance aGConnectInstance;
        synchronized (b.class) {
            aGConnectInstance = f37532b.get(str);
            if (aGConnectInstance == null) {
                if (Utils.DEFAULT_NAME.equals(str)) {
                    Log.w("AGC_Instance", "please call `initialize()` first");
                } else {
                    Log.w("AGC_Instance", "not find instance for : " + str);
                }
            }
        }
        return aGConnectInstance;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            Log.w("AGC_Instance", "agc sdk initialize");
            if (f37532b.size() > 0) {
                Log.w("AGC_Instance", "Repeated invoking initialize");
            } else {
                a(context, (AGConnectOptions) AGConnectServicesConfig.fromContext(context));
            }
        }
    }

    private static synchronized void a(Context context, AGConnectOptions aGConnectOptions) {
        synchronized (b.class) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                Log.w("AGC_Instance", "context.getApplicationContext null");
            } else {
                context = applicationContext;
            }
            b();
            if (f37531a == null) {
                f37531a = new c(context).a();
            }
            a(aGConnectOptions, true);
            f37533c = aGConnectOptions.getIdentifier();
            Log.i("AGC_Instance", "initFinish callback start");
            a.a();
            Log.i("AGC_Instance", "AGC SDK initialize end");
        }
    }

    public static synchronized void a(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        synchronized (b.class) {
            b(context, aGConnectOptionsBuilder);
            a(context, aGConnectOptionsBuilder.build(context));
        }
    }

    private static void b() {
        JsonProcessingFactory.registerProcessor("/agcgw/url", new JsonProcessingFactory.JsonProcessor() {
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE";
                } else if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG";
                }
                return aGConnectOptions.getString(str);
            }
        });
        JsonProcessingFactory.registerProcessor("/agcgw/backurl", new JsonProcessingFactory.JsonProcessor() {
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE_back";
                } else if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                    return null;
                } else {
                    str = "/agcgw_all/SG_back";
                }
                return aGConnectOptions.getString(str);
            }
        });
    }

    private static void b(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        AGConnectServicesConfig fromContext = AGConnectServicesConfig.fromContext(context);
        if (aGConnectOptionsBuilder.getInputStream() != null) {
            try {
                String utils = Utils.toString(aGConnectOptionsBuilder.getInputStream(), "UTF-8");
                aGConnectOptionsBuilder.getInputStream().reset();
                fromContext.overlayWith((InputStream) new ByteArrayInputStream(utils.getBytes(Charset.forName("UTF-8"))));
            } catch (IOException unused) {
                Log.e("AGC_Instance", "input stream set to AGConnectServicesConfig fail");
            }
        }
        for (Map.Entry next : aGConnectOptionsBuilder.getCustomConfigMap().entrySet()) {
            fromContext.setParam((String) next.getKey(), (String) next.getValue());
        }
        if (aGConnectOptionsBuilder.getRoutePolicy() != AGCRoutePolicy.UNKNOWN) {
            fromContext.setRoutePolicy(aGConnectOptionsBuilder.getRoutePolicy());
        }
    }

    public void a(final CustomAuthProvider customAuthProvider) {
        this.f37536f.a((List<Service>) Collections.singletonList(Service.builder((Class<?>) AuthProvider.class, (Object) new AuthProvider() {
            public void addTokenListener(OnTokenListener onTokenListener) {
            }

            public Task<Token> getTokens() {
                return customAuthProvider.getTokens(false);
            }

            public Task<Token> getTokens(boolean z11) {
                return customAuthProvider.getTokens(z11);
            }

            public String getUid() {
                return "";
            }

            public void removeTokenListener(OnTokenListener onTokenListener) {
            }
        }).build()), this.f37534d.getContext());
    }

    public void a(final CustomCredentialsProvider customCredentialsProvider) {
        this.f37536f.a((List<Service>) Collections.singletonList(Service.builder((Class<?>) CredentialsProvider.class, (Object) new CredentialsProvider() {
            public Task<Token> getTokens() {
                return customCredentialsProvider.getTokens(false);
            }

            public Task<Token> getTokens(boolean z11) {
                return customCredentialsProvider.getTokens(z11);
            }
        }).build()), this.f37534d.getContext());
    }

    public Context getContext() {
        return this.f37534d.getContext();
    }

    public String getIdentifier() {
        return this.f37534d.getIdentifier();
    }

    public AGConnectOptions getOptions() {
        return this.f37534d;
    }

    public <T> T getService(Class<? super T> cls) {
        T a11 = this.f37536f.a((AGConnectInstance) this, (Class<?>) cls);
        return a11 != null ? a11 : this.f37535e.a((AGConnectInstance) this, (Class<?>) cls);
    }
}
