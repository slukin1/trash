package com.luck.picture.lib.utils;

import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import java.util.Collections;
import java.util.List;

public class SortUtils {
    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortFolder$0(LocalMediaFolder localMediaFolder, LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.getData() == null || localMediaFolder2.getData() == null) {
            return 0;
        }
        return Integer.compare(localMediaFolder2.getFolderTotalNum(), localMediaFolder.getFolderTotalNum());
    }

    public static void sortFolder(List<LocalMediaFolder> list) {
        Collections.sort(list, b.f26827b);
    }

    public static void sortLocalMediaAddedTime(List<LocalMedia> list) {
        Collections.sort(list, a.f26826b);
    }
}
