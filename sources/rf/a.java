package rf;

import com.hbg.module.monitor.interceptor.NetworkMonitorInterceptor;
import com.hbg.module.monitor.model.NetWorkConfigModel;
import com.hbg.module.monitor.model.NetworkMonitorModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Interceptor;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f29190a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap<String, NetworkMonitorModel> f29191b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static long f29192c = (new Date().getTime() / ((long) 1000));

    /* renamed from: d  reason: collision with root package name */
    public static NetWorkConfigModel f29193d = new NetWorkConfigModel(new ArrayList(), new ArrayList(), 1, 2, 300L);

    public static final void a(String str, boolean z11) {
        ConcurrentHashMap<String, NetworkMonitorModel> concurrentHashMap = f29191b;
        NetworkMonitorModel networkMonitorModel = concurrentHashMap.get(str);
        if (networkMonitorModel == null) {
            networkMonitorModel = new NetworkMonitorModel(str, 1, z11 ? 1 : 0, z11 ^ true ? 1 : 0);
        } else {
            networkMonitorModel.setRequestTotal(networkMonitorModel.getRequestTotal() + 1);
            if (z11) {
                networkMonitorModel.setRequestSuccess(networkMonitorModel.getRequestSuccess() + 1);
            } else {
                networkMonitorModel.setRequestFailed(networkMonitorModel.getRequestFailed() + 1);
            }
        }
        concurrentHashMap.put(str, networkMonitorModel);
        if (!concurrentHashMap.isEmpty()) {
            long time = new Date().getTime() / ((long) 1000);
            if (time - f29192c >= f29190a.c().timeInterval()) {
                for (NetworkMonitorModel next : concurrentHashMap.values()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("requestTotal", Integer.valueOf(next.getRequestTotal()));
                    hashMap.put("path", next.getPath());
                    hashMap.put("requestSuccess", Integer.valueOf(next.getRequestSuccess()));
                    hashMap.put("requestFailed", Integer.valueOf(next.getRequestFailed()));
                    vf.a.a("app_monitor_network", hashMap);
                }
                f29191b.clear();
                f29192c = time;
            }
        }
    }

    public static final void d(NetWorkConfigModel netWorkConfigModel) {
        f29193d = netWorkConfigModel;
    }

    public final Interceptor b() {
        return new NetworkMonitorInterceptor();
    }

    public final NetWorkConfigModel c() {
        return f29193d;
    }
}
