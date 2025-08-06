package com.luck.picture.lib.loader;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public abstract class IBridgeMediaLoader {
    public static final String[] ALL_PROJECTION = {"_id", "_data", "mime_type", "width", "height", COLUMN_DURATION, "_size", COLUMN_BUCKET_DISPLAY_NAME, "_display_name", COLUMN_BUCKET_ID, "date_added", "orientation", "COUNT(*) AS count"};
    public static final String COLUMN_BUCKET_DISPLAY_NAME = "bucket_display_name";
    public static final String COLUMN_BUCKET_ID = "bucket_id";
    public static final String COLUMN_COUNT = "count";
    public static final String COLUMN_DURATION = "duration";
    public static final String COLUMN_ORIENTATION = "orientation";
    public static final String DISTINCT_BUCKET_Id = "DISTINCT bucket_id";
    public static final String GROUP_BY_BUCKET_Id = " GROUP BY (bucket_id";
    public static final int MAX_SORT_SIZE = 60;
    public static final String NOT_GIF = " AND (mime_type!='image/gif')";
    public static final String ORDER_BY = "date_modified DESC";
    public static final String[] PROJECTION = {"_id", "_data", "mime_type", "width", "height", COLUMN_DURATION, "_size", COLUMN_BUCKET_DISPLAY_NAME, "_display_name", COLUMN_BUCKET_ID, "date_added", "orientation"};
    public static final Uri QUERY_URI = MediaStore.Files.getContentUri("external");
    public static final String TAG = "IBridgeMediaLoader";
    public final SelectorConfig mConfig;
    private final Context mContext;

    public IBridgeMediaLoader(Context context, SelectorConfig selectorConfig) {
        this.mContext = context;
        this.mConfig = selectorConfig;
    }

    public abstract String getAlbumFirstCover(long j11);

    public SelectorConfig getConfig() {
        return this.mConfig;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDurationCondition() {
        return String.format(Locale.CHINA, "%d <%s duration and duration <= %d", new Object[]{Long.valueOf(Math.max(0, (long) getConfig().filterVideoMinSecond)), ContainerUtils.KEY_VALUE_DELIMITER, Long.valueOf(getConfig().filterVideoMaxSecond == 0 ? Long.MAX_VALUE : (long) getConfig().filterVideoMaxSecond)});
    }

    public String getFileSizeCondition() {
        return String.format(Locale.CHINA, "%d <%s _size and _size <= %d", new Object[]{Long.valueOf(Math.max(0, getConfig().filterMinFileSize)), ContainerUtils.KEY_VALUE_DELIMITER, Long.valueOf(getConfig().filterMaxFileSize == 0 ? Long.MAX_VALUE : getConfig().filterMaxFileSize)});
    }

    public String getQueryMimeCondition() {
        HashSet hashSet = new HashSet(getConfig().queryOnlyList);
        Iterator it2 = hashSet.iterator();
        StringBuilder sb2 = new StringBuilder();
        int i11 = -1;
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (!TextUtils.isEmpty(str) && (getConfig().chooseMode != SelectMimeType.ofVideo() ? getConfig().chooseMode != SelectMimeType.ofImage() ? getConfig().chooseMode != SelectMimeType.ofAudio() || (!str.startsWith("video") && !str.startsWith("image")) : !str.startsWith("audio") && !str.startsWith("video") : !str.startsWith("image") && !str.startsWith("audio"))) {
                i11++;
                sb2.append(i11 == 0 ? " AND " : " OR ");
                sb2.append("mime_type");
                sb2.append("='");
                sb2.append(str);
                sb2.append("'");
            }
        }
        if (getConfig().chooseMode != SelectMimeType.ofVideo() && !getConfig().isGif && !hashSet.contains(PictureMimeType.ofGIF())) {
            sb2.append(NOT_GIF);
        }
        return sb2.toString();
    }

    public abstract String getSelection();

    public abstract String[] getSelectionArgs();

    public abstract String getSortOrder();

    public abstract void loadAllAlbum(OnQueryAllAlbumListener<LocalMediaFolder> onQueryAllAlbumListener);

    public abstract void loadOnlyInAppDirAllMedia(OnQueryAlbumListener<LocalMediaFolder> onQueryAlbumListener);

    public abstract void loadPageMediaData(long j11, int i11, int i12, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener);

    public abstract LocalMedia parseLocalMedia(Cursor cursor, boolean z11);
}
