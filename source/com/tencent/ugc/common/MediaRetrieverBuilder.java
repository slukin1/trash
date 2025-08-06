package com.tencent.ugc.common;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.f;

public class MediaRetrieverBuilder {
    private final String TAG = "MediaRetrieverBuilder";
    private String mFilePath = "";

    public MediaMetadataRetriever build() {
        Context applicationContext = ContextUtils.getApplicationContext();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (MediaExtractorBuilder.isContentUri(this.mFilePath)) {
                mediaMetadataRetriever.setDataSource(applicationContext, Uri.parse(this.mFilePath));
                return mediaMetadataRetriever;
            } else if (!f.a(this.mFilePath)) {
                mediaMetadataRetriever.release();
                return null;
            } else {
                mediaMetadataRetriever.setDataSource(this.mFilePath);
                return mediaMetadataRetriever;
            }
        } catch (Exception e11) {
            LiteavLog.e("MediaRetrieverBuilder", String.valueOf(e11));
            mediaMetadataRetriever.release();
            return null;
        }
    }

    public MediaRetrieverBuilder setPath(String str) {
        this.mFilePath = str;
        return this;
    }
}
