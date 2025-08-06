package com.tencent.thumbplayer.tcmedia.adapter.a.a;

import com.tencent.thumbplayer.tcmedia.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.tcmedia.core.common.TPSubtitleFrame;
import java.util.Map;

public interface a {

    /* renamed from: com.tencent.thumbplayer.tcmedia.adapter.a.a.a$a  reason: collision with other inner class name */
    public interface C0611a {
        void a(e eVar);

        void a(TPSubtitleFrame tPSubtitleFrame);

        void a(String str);
    }

    public interface b {
        void a(int i11, int i12);
    }

    public interface c {
        void a(int i11, long j11);

        void a(long j11);
    }

    public interface d {
        long a();
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public String f48710a;

        public e(String str) {
            this.f48710a = str;
        }
    }

    void a();

    void a(int i11);

    void a(C0611a aVar);

    void a(b bVar);

    void a(c cVar);

    void a(d dVar);

    void a(TPSubtitleRenderModel tPSubtitleRenderModel);

    void a(String str, Map<String, String> map, long j11);

    void b();

    void c();

    void d();

    void e();

    void f();
}
