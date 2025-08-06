package zendesk.classic.messaging;

import java.util.ArrayList;
import java.util.List;
import zendesk.belvedere.MediaResult;

public class BelvedereMediaHolder {

    /* renamed from: a  reason: collision with root package name */
    public List<MediaResult> f62346a = new ArrayList();

    public void a(List<MediaResult> list) {
        this.f62346a.addAll(0, new ArrayList(list));
    }

    public void b() {
        this.f62346a.clear();
    }

    public List<MediaResult> c() {
        return new ArrayList(this.f62346a);
    }

    public int d() {
        return this.f62346a.size();
    }

    public void e(List<MediaResult> list) {
        this.f62346a.removeAll(new ArrayList(list));
    }
}
