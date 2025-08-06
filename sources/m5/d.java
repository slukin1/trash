package m5;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d f58117b = new d();

    public final int compare(Object obj, Object obj2) {
        return CrashlyticsReportPersistence.oldestEventFileFirst((File) obj, (File) obj2);
    }
}
