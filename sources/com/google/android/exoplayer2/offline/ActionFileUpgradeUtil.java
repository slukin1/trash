package com.google.android.exoplayer2.offline;

import java.io.File;
import java.io.IOException;

public final class ActionFileUpgradeUtil {

    public interface DownloadIdProvider {
        String getId(DownloadRequest downloadRequest);
    }

    private ActionFileUpgradeUtil() {
    }

    public static void mergeRequest(DownloadRequest downloadRequest, DefaultDownloadIndex defaultDownloadIndex, boolean z11, long j11) throws IOException {
        Download download;
        DefaultDownloadIndex defaultDownloadIndex2 = defaultDownloadIndex;
        Download download2 = defaultDownloadIndex.getDownload(downloadRequest.f65951id);
        if (download2 != null) {
            download = DownloadManager.mergeRequest(download2, downloadRequest, download2.stopReason, j11);
        } else {
            long j12 = j11;
            download = new Download(downloadRequest, z11 ? 3 : 0, j11, j11, -1, 0, 0);
        }
        defaultDownloadIndex.putDownload(download);
    }

    public static void upgradeAndDelete(File file, DownloadIdProvider downloadIdProvider, DefaultDownloadIndex defaultDownloadIndex, boolean z11, boolean z12) throws IOException {
        ActionFile actionFile = new ActionFile(file);
        if (actionFile.exists()) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                for (DownloadRequest downloadRequest : actionFile.load()) {
                    if (downloadIdProvider != null) {
                        downloadRequest = downloadRequest.copyWithId(downloadIdProvider.getId(downloadRequest));
                    }
                    mergeRequest(downloadRequest, defaultDownloadIndex, z12, currentTimeMillis);
                }
                actionFile.delete();
            } catch (Throwable th2) {
                if (z11) {
                    actionFile.delete();
                }
                throw th2;
            }
        }
    }
}
