package com.airbnb.lottie;

import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import java.io.File;

public class LottieConfig {
    public final LottieNetworkCacheProvider cacheProvider;
    public final boolean enableSystraceMarkers;
    public final LottieNetworkFetcher networkFetcher;

    public static final class Builder {
        private LottieNetworkCacheProvider cacheProvider;
        private boolean enableSystraceMarkers = false;
        private LottieNetworkFetcher networkFetcher;

        public LottieConfig build() {
            return new LottieConfig(this.networkFetcher, this.cacheProvider, this.enableSystraceMarkers);
        }

        public Builder setEnableSystraceMarkers(boolean z11) {
            this.enableSystraceMarkers = z11;
            return this;
        }

        public Builder setNetworkCacheDir(final File file) {
            if (this.cacheProvider == null) {
                this.cacheProvider = new LottieNetworkCacheProvider() {
                    public File getCacheDir() {
                        if (file.isDirectory()) {
                            return file;
                        }
                        throw new IllegalArgumentException("cache file must be a directory");
                    }
                };
                return this;
            }
            throw new IllegalStateException("There is already a cache provider!");
        }

        public Builder setNetworkCacheProvider(final LottieNetworkCacheProvider lottieNetworkCacheProvider) {
            if (this.cacheProvider == null) {
                this.cacheProvider = new LottieNetworkCacheProvider() {
                    public File getCacheDir() {
                        File cacheDir = lottieNetworkCacheProvider.getCacheDir();
                        if (cacheDir.isDirectory()) {
                            return cacheDir;
                        }
                        throw new IllegalArgumentException("cache file must be a directory");
                    }
                };
                return this;
            }
            throw new IllegalStateException("There is already a cache provider!");
        }

        public Builder setNetworkFetcher(LottieNetworkFetcher lottieNetworkFetcher) {
            this.networkFetcher = lottieNetworkFetcher;
            return this;
        }
    }

    private LottieConfig(LottieNetworkFetcher lottieNetworkFetcher, LottieNetworkCacheProvider lottieNetworkCacheProvider, boolean z11) {
        this.networkFetcher = lottieNetworkFetcher;
        this.cacheProvider = lottieNetworkCacheProvider;
        this.enableSystraceMarkers = z11;
    }
}
