package com.mob.commons.a;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.C0891r;
import com.mob.commons.ab;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import org.json.JSONObject;

public class n extends c {
    public n() {
        super(C0891r.b("002Gefch"), 0, C0891r.b("005Hefchdi7ci"), 3600, c.a(C0891r.b("002Gefch"), (Long) 0L));
    }

    /* access modifiers changed from: private */
    public void m() {
        DH.requester(MobSDK.getContext()).getMwfo().getMwlfo().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                HashMap hashMap = new HashMap();
                HashMap<String, Object> mwfo = dHResponse.getMwfo();
                if (mwfo != null) {
                    String str = (String) mwfo.get("bsmt");
                    String str2 = (String) mwfo.get("ssmt");
                    if (!TextUtils.isEmpty(str)) {
                        ArrayList<HashMap<String, Object>> mwlfo = dHResponse.getMwlfo();
                        if (mwlfo != null && !mwlfo.isEmpty()) {
                            Iterator<HashMap<String, Object>> it2 = mwlfo.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    HashMap next = it2.next();
                                    Object obj = next.get(C0891r.b("005Zeidkdkddek"));
                                    if (obj != null && String.valueOf(obj).equals(str)) {
                                        hashMap.putAll(next);
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            hashMap.remove(C0891r.b("005:eidkdkddek"));
                            hashMap.remove(C0891r.b("004[dkdkddek"));
                        }
                    } else if (TextUtils.isEmpty(str2) || C0891r.b("0142hdcfXd9dgLd^cjef<d)heehehchcbhf").equalsIgnoreCase(str2)) {
                        return;
                    }
                    hashMap.putAll(mwfo);
                    hashMap.put("ssmt", str2);
                    hashMap.put("bsmt", str);
                    n.this.a("WIMT", (HashMap<String, Object>) hashMap, true);
                    TreeMap treeMap = new TreeMap();
                    treeMap.put("ssmt", str2);
                    treeMap.put("bsmt", str);
                    ab.a().a(ab.f26995i, Data.MD5(new JSONObject(treeMap).toString()));
                }
            }
        });
    }

    public void c() {
        k.a().a(getClass().getName(), (k.a) new k.a() {
            public void a() {
                if (n.this.e()) {
                    n.this.m();
                }
            }
        });
    }

    public void a() {
        m();
    }
}
