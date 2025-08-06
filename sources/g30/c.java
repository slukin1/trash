package g30;

import com.zendesk.logger.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import zendesk.belvedere.Callback;
import zendesk.belvedere.MediaResult;
import zendesk.classic.messaging.e;

public class c extends Callback<List<MediaResult>> {

    /* renamed from: a  reason: collision with root package name */
    public final f f60288a;

    /* renamed from: b  reason: collision with root package name */
    public final e f60289b;

    public c(f fVar, e eVar) {
        this.f60288a = fVar;
        this.f60289b = eVar;
    }

    public void success(List<MediaResult> list) {
        Logger.b("BelvedereMediaResolverCallback", "Uris have been resolved, collecting files to send the event", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (MediaResult next : list) {
            File file = next.getFile();
            if (file == null) {
                Logger.l("BelvedereMediaResolverCallback", "Unable to get file, skipping Uri: %s", next.getUri().toString());
            } else {
                arrayList.add(file);
            }
        }
        if (arrayList.isEmpty()) {
            Logger.l("BelvedereMediaResolverCallback", "No files resolved. No event will be sent", new Object[0]);
            return;
        }
        Logger.b("BelvedereMediaResolverCallback", "Sending attachment event", new Object[0]);
        this.f60288a.a(this.f60289b.k(arrayList));
    }
}
