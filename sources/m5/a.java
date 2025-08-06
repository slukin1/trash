package m5;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class a implements FilenameFilter {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ a f58114b = new a();

    public final boolean accept(File file, String str) {
        return CrashlyticsReportPersistence.isNormalPriorityEventFile(file, str);
    }
}
