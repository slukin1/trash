package com.alibaba.android.arouter.core;

import android.content.Context;
import android.util.LruCache;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import java.util.ArrayList;
import java.util.List;

@Route(path = "/arouter/service/autowired")
public class AutowiredServiceImpl implements AutowiredService {

    /* renamed from: a  reason: collision with root package name */
    public LruCache<String, ISyringe> f14053a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f14054b;

    public void autowire(Object obj) {
        String name = obj.getClass().getName();
        try {
            if (!this.f14054b.contains(name)) {
                ISyringe iSyringe = this.f14053a.get(name);
                if (iSyringe == null) {
                    iSyringe = (ISyringe) Class.forName(obj.getClass().getName() + "$$ARouter$$Autowired").getConstructor(new Class[0]).newInstance(new Object[0]);
                }
                iSyringe.inject(obj);
                this.f14053a.put(name, iSyringe);
            }
        } catch (Exception unused) {
            this.f14054b.add(name);
        }
    }

    public void init(Context context) {
        this.f14053a = new LruCache<>(66);
        this.f14054b = new ArrayList();
    }
}
