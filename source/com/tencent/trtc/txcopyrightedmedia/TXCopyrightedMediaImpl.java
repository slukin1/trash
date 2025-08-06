package com.tencent.trtc.txcopyrightedmedia;

import android.content.Context;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.trtc.txcopyrightedmedia.TXCopyrightedMedia;

@JNINamespace("liteav::extensions")
public class TXCopyrightedMediaImpl extends TXCopyrightedMedia {
    private long mNativeTXCopyrightedMediaImpl = 0;

    private static native void nativeCancelPreloadMusic(long j11, String str, String str2);

    private static native void nativeClearMusicCache(long j11);

    private static native long nativeCreateCopyRightedMedia(TXCopyrightedMediaImpl tXCopyrightedMediaImpl);

    private static native void nativeDestroyCopyRightedMedia(TXCopyrightedMediaImpl tXCopyrightedMediaImpl, long j11);

    private static native String nativeGenMusicURI(long j11, String str, int i11, String str2);

    private static native boolean nativeIsMusicPreloaded(long j11, String str, String str2);

    private static native void nativePreloadMusic(long j11, String str, String str2, String str3, Object obj);

    private static native void nativeSetLicense(long j11, Context context, String str, String str2);

    private static native void nativeSetMusicCacheMaxCount(long j11, int i11);

    public void cancelPreloadMusic(String str, String str2) {
        nativeCancelPreloadMusic(this.mNativeTXCopyrightedMediaImpl, str, str2);
    }

    public void clearMusicCache() {
        nativeClearMusicCache(this.mNativeTXCopyrightedMediaImpl);
    }

    public void destroy() {
        nativeDestroyCopyRightedMedia(this, this.mNativeTXCopyrightedMediaImpl);
    }

    public String genMusicURI(String str, int i11, String str2) {
        return nativeGenMusicURI(this.mNativeTXCopyrightedMediaImpl, str, i11, str2);
    }

    public void init() {
        this.mNativeTXCopyrightedMediaImpl = nativeCreateCopyRightedMedia(this);
    }

    public boolean isMusicPreloaded(String str, String str2) {
        return nativeIsMusicPreloaded(this.mNativeTXCopyrightedMediaImpl, str, str2);
    }

    public void onPreloadComplete(String str, String str2, int i11, String str3, Object obj) {
        ((TXCopyrightedMedia.ITXMusicPreloadCallback) obj).onPreloadComplete(str, str2, i11, str3);
    }

    public void onPreloadProgress(String str, String str2, float f11, Object obj) {
        ((TXCopyrightedMedia.ITXMusicPreloadCallback) obj).onPreloadProgress(str, str2, f11);
    }

    public void onPreloadStart(String str, String str2, Object obj) {
        ((TXCopyrightedMedia.ITXMusicPreloadCallback) obj).onPreloadStart(str, str2);
    }

    public void preloadMusic(String str, String str2, String str3, TXCopyrightedMedia.ITXMusicPreloadCallback iTXMusicPreloadCallback) {
        nativePreloadMusic(this.mNativeTXCopyrightedMediaImpl, str, str2, str3, iTXMusicPreloadCallback);
    }

    public void setLicense(Context context, String str, String str2) {
        nativeSetLicense(this.mNativeTXCopyrightedMediaImpl, context, str, str2);
    }

    public void setMusicCacheMaxCount(int i11) {
        nativeSetMusicCacheMaxCount(this.mNativeTXCopyrightedMediaImpl, i11);
    }
}
