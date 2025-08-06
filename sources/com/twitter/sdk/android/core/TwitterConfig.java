package com.twitter.sdk.android.core;

import android.content.Context;
import java.util.concurrent.ExecutorService;

public class TwitterConfig {
    public final Context context;
    public final Boolean debug;
    public final ExecutorService executorService;
    public final Logger logger;
    public final TwitterAuthConfig twitterAuthConfig;

    public static class Builder {
        private final Context context;
        private Boolean debug;
        private ExecutorService executorService;
        private Logger logger;
        private TwitterAuthConfig twitterAuthConfig;

        public Builder(Context context2) {
            if (context2 != null) {
                this.context = context2.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public TwitterConfig build() {
            return new TwitterConfig(this.context, this.logger, this.twitterAuthConfig, this.executorService, this.debug);
        }

        public Builder debug(boolean z11) {
            this.debug = Boolean.valueOf(z11);
            return this;
        }

        public Builder executorService(ExecutorService executorService2) {
            if (executorService2 != null) {
                this.executorService = executorService2;
                return this;
            }
            throw new IllegalArgumentException("ExecutorService must not be null.");
        }

        public Builder logger(Logger logger2) {
            if (logger2 != null) {
                this.logger = logger2;
                return this;
            }
            throw new IllegalArgumentException("Logger must not be null.");
        }

        public Builder twitterAuthConfig(TwitterAuthConfig twitterAuthConfig2) {
            if (twitterAuthConfig2 != null) {
                this.twitterAuthConfig = twitterAuthConfig2;
                return this;
            }
            throw new IllegalArgumentException("TwitterAuthConfig must not be null.");
        }
    }

    private TwitterConfig(Context context2, Logger logger2, TwitterAuthConfig twitterAuthConfig2, ExecutorService executorService2, Boolean bool) {
        this.context = context2;
        this.logger = logger2;
        this.twitterAuthConfig = twitterAuthConfig2;
        this.executorService = executorService2;
        this.debug = bool;
    }
}
