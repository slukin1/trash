package gq;

import com.huobi.points.entity.Points;
import com.huobi.points.viewhandler.TransferToMeListItemHandler;

public class d implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public a f84174b;

    /* renamed from: c  reason: collision with root package name */
    public Points f84175c;

    public interface a {
        void a(d dVar);

        String getType();
    }

    public d(Points points, a aVar) {
        this.f84175c = points;
        this.f84174b = aVar;
    }

    public a a() {
        return this.f84174b;
    }

    public String getViewHandlerName() {
        return TransferToMeListItemHandler.class.getName();
    }
}
