package jo;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.uc.retrofit.bean.MessageConfig;
import com.hbg.lib.network.uc.retrofit.bean.MessageConfigWrapper;
import com.hbg.module.huobi.im.IMConversationHelper;
import com.huochat.community.util.JsonTool;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import u6.g;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, MessageConfig> f84302a;

    /* renamed from: jo.a$a  reason: collision with other inner class name */
    public class C0870a extends BaseSubscriber<List<MessageConfigWrapper>> {
        public C0870a() {
        }

        public void onNext(List<MessageConfigWrapper> list) {
            super.onNext(list);
            if (list != null && !list.isEmpty()) {
                for (MessageConfigWrapper next : list) {
                    if ("4".equals(next.c()) && next.b() != null && !next.b().isEmpty()) {
                        List<MessageConfig> b11 = next.b();
                        int size = b11.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            MessageConfig messageConfig = b11.get(i11);
                            if ("Push-Chat".equals(messageConfig.c())) {
                                IMConversationHelper.o().z("2".equals(messageConfig.d()));
                            }
                        }
                    }
                }
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f84304a = new a((C0870a) null);
    }

    public /* synthetic */ a(C0870a aVar) {
        this();
    }

    public static a e() {
        return b.f84304a;
    }

    public void a(String str, MessageConfig messageConfig) {
        if (this.f84302a.get(str) != null) {
            this.f84302a.remove(str);
        }
        this.f84302a.put(str, messageConfig);
    }

    public void b() {
        SP.w("MESSAGE_CONFIG", "messageConfigData", JsonTool.toJSONString(this.f84302a));
    }

    public void c() {
        this.f84302a.clear();
    }

    public Map<String, MessageConfig> d() {
        return this.f84302a;
    }

    public void f() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "PRO_LETTER");
        o9.a.a().requestSwitchConfig(hashMap).b().compose(RxJavaHelper.t((g) null)).retry(3).subscribe(new C0870a());
    }

    public void g() {
        Map map;
        String j11 = SP.j("MESSAGE_CONFIG", "messageConfigData", "");
        if (!TextUtils.isEmpty(j11) && (map = (Map) JsonTool.parseObject(j11, new HashMap().getClass())) != null) {
            for (String str : map.keySet()) {
                a(str, (MessageConfig) JsonTool.parseObject(((JSONObject) map.get(str)).toJSONString(), MessageConfig.class));
            }
        }
    }

    public a() {
        this.f84302a = new HashMap(5);
        g();
    }
}
