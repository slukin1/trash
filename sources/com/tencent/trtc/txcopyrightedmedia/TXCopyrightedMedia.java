package com.tencent.trtc.txcopyrightedmedia;

import android.content.Context;

public abstract class TXCopyrightedMedia {
    public static TXCopyrightedMediaImpl impl = new TXCopyrightedMediaImpl();

    public interface ITXMusicPreloadCallback {
        void onPreloadComplete(String str, String str2, int i11, String str3);

        void onPreloadProgress(String str, String str2, float f11);

        void onPreloadStart(String str, String str2);
    }

    public enum TXCopyrightedError {
        TXCopyrightedErrorNoError(0),
        TXCopyrightedErrorInitFail(-1),
        TXCopyrightedErrorCancel(-2),
        TXCopyrightedErrorTokenFail(-3),
        TXCopyrightedErrorNetFail(-4),
        TXCopyrightedErrorInner(-5),
        TXCopyrightedErrorParseFail(-6),
        TXCopyrightedErrorDecryptFail(-7),
        TXCopyrightedErrorLicenseFail(-8),
        TXCopyrightedErrorIsDownloading(-9),
        TXCopyrightedErrorAccompanimentNotExist(-10),
        TXCopyrightedErrorOriginNotExist(-11),
        TXCopyrightedErrorLyricNotExist(-12),
        TXCopyrightedErrorWriteFileFail(-13);
        
        private int nativeValue;

        private TXCopyrightedError(int i11) {
            this.nativeValue = i11;
        }

        public final int getNativeValue() {
            return this.nativeValue;
        }
    }

    public static TXCopyrightedMedia instance() {
        return impl;
    }

    public abstract void cancelPreloadMusic(String str, String str2);

    public abstract void clearMusicCache();

    public abstract void destroy();

    public abstract String genMusicURI(String str, int i11, String str2);

    public abstract void init();

    public abstract boolean isMusicPreloaded(String str, String str2);

    public abstract void preloadMusic(String str, String str2, String str3, ITXMusicPreloadCallback iTXMusicPreloadCallback);

    public abstract void setLicense(Context context, String str, String str2);

    public abstract void setMusicCacheMaxCount(int i11);
}
