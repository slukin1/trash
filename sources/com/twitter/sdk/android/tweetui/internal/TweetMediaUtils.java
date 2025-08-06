package com.twitter.sdk.android.tweetui.internal;

import android.os.Build;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetEntities;
import com.twitter.sdk.android.core.models.VideoInfo;
import java.util.ArrayList;
import java.util.List;

public final class TweetMediaUtils {
    private static final String CONTENT_TYPE_HLS = "application/x-mpegURL";
    private static final String CONTENT_TYPE_MP4 = "video/mp4";
    public static final String GIF_TYPE = "animated_gif";
    private static final int LOOP_VIDEO_IN_MILLIS = 6500;
    public static final String PHOTO_TYPE = "photo";
    public static final String VIDEO_TYPE = "video";

    private TweetMediaUtils() {
    }

    public static List<MediaEntity> getAllMediaEntities(Tweet tweet) {
        List<MediaEntity> list;
        List<MediaEntity> list2;
        ArrayList arrayList = new ArrayList();
        TweetEntities tweetEntities = tweet.entities;
        if (!(tweetEntities == null || (list2 = tweetEntities.media) == null)) {
            arrayList.addAll(list2);
        }
        TweetEntities tweetEntities2 = tweet.extendedEntities;
        if (!(tweetEntities2 == null || (list = tweetEntities2.media) == null)) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public static List<MediaEntity> getPhotoEntities(Tweet tweet) {
        List<MediaEntity> list;
        ArrayList arrayList = new ArrayList();
        TweetEntities tweetEntities = tweet.extendedEntities;
        if (!(tweetEntities == null || (list = tweetEntities.media) == null || list.size() <= 0)) {
            for (int i11 = 0; i11 <= tweetEntities.media.size() - 1; i11++) {
                MediaEntity mediaEntity = tweetEntities.media.get(i11);
                if (mediaEntity.type != null && isPhotoType(mediaEntity)) {
                    arrayList.add(mediaEntity);
                }
            }
        }
        return arrayList;
    }

    public static MediaEntity getPhotoEntity(Tweet tweet) {
        List<MediaEntity> allMediaEntities = getAllMediaEntities(tweet);
        for (int size = allMediaEntities.size() - 1; size >= 0; size--) {
            MediaEntity mediaEntity = allMediaEntities.get(size);
            if (mediaEntity.type != null && isPhotoType(mediaEntity)) {
                return mediaEntity;
            }
        }
        return null;
    }

    public static VideoInfo.Variant getSupportedVariant(MediaEntity mediaEntity) {
        for (VideoInfo.Variant next : mediaEntity.videoInfo.variants) {
            if (isVariantSupported(next)) {
                return next;
            }
        }
        return null;
    }

    public static MediaEntity getVideoEntity(Tweet tweet) {
        for (MediaEntity next : getAllMediaEntities(tweet)) {
            if (next.type != null && isVideoType(next)) {
                return next;
            }
        }
        return null;
    }

    public static boolean hasPhoto(Tweet tweet) {
        return getPhotoEntity(tweet) != null;
    }

    public static boolean hasSupportedVideo(Tweet tweet) {
        MediaEntity videoEntity = getVideoEntity(tweet);
        return (videoEntity == null || getSupportedVariant(videoEntity) == null) ? false : true;
    }

    public static boolean isLooping(MediaEntity mediaEntity) {
        return GIF_TYPE.equals(mediaEntity.type) || ("video".endsWith(mediaEntity.type) && mediaEntity.videoInfo.durationMillis < 6500);
    }

    public static boolean isPhotoType(MediaEntity mediaEntity) {
        return "photo".equals(mediaEntity.type);
    }

    public static boolean isVariantSupported(VideoInfo.Variant variant) {
        if ((Build.VERSION.SDK_INT < 21 || !"application/x-mpegURL".equals(variant.contentType)) && !"video/mp4".equals(variant.contentType)) {
            return false;
        }
        return true;
    }

    public static boolean isVideoType(MediaEntity mediaEntity) {
        return "video".equals(mediaEntity.type) || GIF_TYPE.equals(mediaEntity.type);
    }

    public static boolean showVideoControls(MediaEntity mediaEntity) {
        return !GIF_TYPE.equals(mediaEntity.type);
    }
}
