package com.sumsub.sns.internal.core.data.network.interceptor;

import com.sumsub.sns.internal.core.common.n0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Regex;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public final class b implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final HttpLoggingInterceptor f32943a;

    /* renamed from: b  reason: collision with root package name */
    public final List<Regex> f32944b;

    public b(HttpLoggingInterceptor httpLoggingInterceptor, List<Regex> list) {
        this.f32943a = httpLoggingInterceptor;
        this.f32944b = list;
        httpLoggingInterceptor.redactHeader(n0.e.f32153d);
    }

    public Response intercept(Interceptor.Chain chain) {
        boolean z11;
        String httpUrl = chain.request().url().toString();
        if (this.f32943a.getLevel() == HttpLoggingInterceptor.Level.BODY) {
            List<Regex> list = this.f32944b;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((Regex) it2.next()).containsMatchIn(httpUrl)) {
                            z11 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z11 = false;
            if (z11) {
                this.f32943a.level(HttpLoggingInterceptor.Level.HEADERS);
                Response intercept = this.f32943a.intercept(chain);
                this.f32943a.level(HttpLoggingInterceptor.Level.BODY);
                return intercept;
            }
        }
        return this.f32943a.intercept(chain);
    }
}
