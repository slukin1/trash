package m5;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class b implements FilenameFilter {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ b f58115b = new b();

    public final boolean accept(File file, String str) {
        return str.startsWith(CrashlyticsReportPersistence.EVENT_FILE_NAME_PREFIX);
    }
}
