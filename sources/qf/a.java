package qf;

import com.google.gson.Gson;
import com.hbg.module.monitor.model.MonitorConfigModel;
import com.hbg.module.monitor.model.NetWorkConfigModel;
import com.huobi.store.AppConfig;
import com.huobi.store.BusinessLine;
import java.util.Iterator;
import java.util.List;
import okhttp3.Interceptor;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f29180a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final Gson f29181b = new Gson();

    public static final Interceptor a() {
        return rf.a.f29190a.b();
    }

    public static final void b(List<? extends AppConfig> list) {
        boolean z11;
        String str;
        T t11;
        BusinessLine businessLine;
        boolean z12;
        Iterator<T> it2 = list.iterator();
        while (true) {
            z11 = true;
            str = null;
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (((AppConfig) t11).number == 74) {
                z12 = true;
                continue;
            } else {
                z12 = false;
                continue;
            }
            if (z12) {
                break;
            }
        }
        AppConfig appConfig = (AppConfig) t11;
        if (!(appConfig == null || (businessLine = appConfig.data) == null)) {
            str = businessLine.patternContent;
        }
        if (str == null) {
            str = "";
        }
        a aVar = f29180a;
        aVar.c("PatternContent : " + str);
        if (str.length() <= 0) {
            z11 = false;
        }
        if (z11) {
            try {
                Gson gson = f29181b;
                MonitorConfigModel monitorConfigModel = (MonitorConfigModel) gson.fromJson(str, MonitorConfigModel.class);
                aVar.c(gson.toJson((Object) monitorConfigModel));
                NetWorkConfigModel netWork = monitorConfigModel.getNetWork();
                if (netWork != null) {
                    rf.a.d(netWork);
                }
            } catch (Exception e11) {
                a aVar2 = f29180a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Parse Content Error ");
                String localizedMessage = e11.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "--";
                }
                sb2.append(localizedMessage);
                aVar2.c(sb2.toString());
            }
        }
    }

    public final void c(String str) {
    }
}
