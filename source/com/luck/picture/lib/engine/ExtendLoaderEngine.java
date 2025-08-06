package com.luck.picture.lib.engine;

import android.content.Context;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;

@Deprecated
public interface ExtendLoaderEngine {
    void loadAllAlbumData(Context context, OnQueryAllAlbumListener<LocalMediaFolder> onQueryAllAlbumListener);

    void loadFirstPageMediaData(Context context, long j11, int i11, int i12, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener);

    void loadMoreMediaData(Context context, long j11, int i11, int i12, int i13, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener);

    void loadOnlyInAppDirAllMediaData(Context context, OnQueryAlbumListener<LocalMediaFolder> onQueryAlbumListener);
}
