package com.bumptech.glide.request;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import n3.b;

public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    public static RequestOptions B;
    public static RequestOptions C;

    /* JADX WARNING: type inference failed for: r1v0, types: [n3.g<android.graphics.Bitmap>, n3.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bumptech.glide.request.RequestOptions r0(n3.g<android.graphics.Bitmap> r1) {
        /*
            com.bumptech.glide.request.RequestOptions r0 = new com.bumptech.glide.request.RequestOptions
            r0.<init>()
            com.bumptech.glide.request.BaseRequestOptions r1 = r0.n0(r1)
            com.bumptech.glide.request.RequestOptions r1 = (com.bumptech.glide.request.RequestOptions) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestOptions.r0(n3.g):com.bumptech.glide.request.RequestOptions");
    }

    public static RequestOptions s0(Class<?> cls) {
        return (RequestOptions) new RequestOptions().g(cls);
    }

    public static RequestOptions t0(DiskCacheStrategy diskCacheStrategy) {
        return (RequestOptions) new RequestOptions().h(diskCacheStrategy);
    }

    public static RequestOptions u0(b bVar) {
        return (RequestOptions) new RequestOptions().i0(bVar);
    }

    public static RequestOptions v0(boolean z11) {
        if (z11) {
            if (B == null) {
                B = (RequestOptions) ((RequestOptions) new RequestOptions().k0(true)).c();
            }
            return B;
        }
        if (C == null) {
            C = (RequestOptions) ((RequestOptions) new RequestOptions().k0(false)).c();
        }
        return C;
    }
}
