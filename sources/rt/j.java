package rt;

import com.huobi.tradenew.handler.SpotOrderEmptyViewHandler;
import s9.a;

public class j implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f84826b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f84827c;

    public j(String str, boolean z11) {
        this.f84826b = str;
        this.f84827c = z11;
    }

    public String a() {
        return this.f84826b;
    }

    public boolean c() {
        return this.f84827c;
    }

    public String getViewHandlerName() {
        return SpotOrderEmptyViewHandler.class.getName();
    }
}
