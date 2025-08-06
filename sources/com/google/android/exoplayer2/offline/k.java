package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadManager;
import java.util.Comparator;

public final /* synthetic */ class k implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ k f65964b = new k();

    public final int compare(Object obj, Object obj2) {
        return DownloadManager.InternalHandler.compareStartTimes((Download) obj, (Download) obj2);
    }
}
