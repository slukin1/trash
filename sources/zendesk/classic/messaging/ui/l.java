package zendesk.classic.messaging.ui;

import g30.c;
import g30.f;
import java.util.ArrayList;
import zendesk.belvedere.ImageStream;
import zendesk.belvedere.MediaResult;
import zendesk.belvedere.a;
import zendesk.classic.messaging.BelvedereMediaHolder;
import zendesk.classic.messaging.e;
import zendesk.classic.messaging.ui.InputBox;

public class l implements InputBox.f {

    /* renamed from: a  reason: collision with root package name */
    public final f f62805a;

    /* renamed from: b  reason: collision with root package name */
    public final e f62806b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageStream f62807c;

    /* renamed from: d  reason: collision with root package name */
    public final a f62808d;

    /* renamed from: e  reason: collision with root package name */
    public final BelvedereMediaHolder f62809e;

    /* renamed from: f  reason: collision with root package name */
    public final c f62810f;

    public l(f fVar, e eVar, ImageStream imageStream, a aVar, BelvedereMediaHolder belvedereMediaHolder, c cVar) {
        this.f62805a = fVar;
        this.f62806b = eVar;
        this.f62807c = imageStream;
        this.f62808d = aVar;
        this.f62809e = belvedereMediaHolder;
        this.f62810f = cVar;
    }

    public boolean a(String str) {
        if (mz.f.c(str)) {
            this.f62805a.a(this.f62806b.l(str));
        }
        ArrayList arrayList = new ArrayList();
        for (MediaResult uri : this.f62809e.c()) {
            arrayList.add(uri.getUri());
        }
        if (!arrayList.isEmpty()) {
            this.f62808d.h(arrayList, "zendesk/messaging", this.f62810f);
            this.f62809e.b();
        }
        if (!this.f62807c.uh()) {
            return true;
        }
        this.f62807c.dismiss();
        return true;
    }
}
