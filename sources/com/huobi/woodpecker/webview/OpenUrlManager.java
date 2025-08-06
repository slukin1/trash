package com.huobi.woodpecker.webview;

import com.huobi.woodpecker.utils.ContextUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kv.b;

public class OpenUrlManager {

    /* renamed from: a  reason: collision with root package name */
    public Set<String> f21169a;

    /* renamed from: b  reason: collision with root package name */
    public StringBuilder f21170b;

    public static final class Holder {

        /* renamed from: a  reason: collision with root package name */
        public static final OpenUrlManager f21171a = new OpenUrlManager();
    }

    public static OpenUrlManager b() {
        return Holder.f21171a;
    }

    public void a(String str) {
        if (!c(str)) {
            this.f21169a.add(str);
            if (this.f21170b.length() > 0) {
                this.f21170b.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            this.f21170b.append(str);
            b.d(ContextUtil.g(), "openUrlList", this.f21170b.toString());
        }
    }

    public boolean c(String str) {
        return this.f21169a.contains(str);
    }

    public final void d() {
        String[] split = b.a(ContextUtil.g(), "openUrlList", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split.length > 0) {
            Collections.addAll(this.f21169a, split);
            if (!this.f21169a.isEmpty()) {
                for (String append : this.f21169a) {
                    StringBuilder sb2 = this.f21170b;
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb2.append(append);
                }
                this.f21170b.deleteCharAt(0);
            }
        }
    }

    public OpenUrlManager() {
        this.f21169a = new HashSet();
        this.f21170b = new StringBuilder();
        d();
    }
}
