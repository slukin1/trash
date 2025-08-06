package com.twitter.sdk.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.internal.ActivityLifecycleManager;
import com.twitter.sdk.android.core.internal.CommonUtils;
import com.twitter.sdk.android.core.internal.ExecutorUtils;
import java.io.File;
import java.util.concurrent.ExecutorService;

public class Twitter {
    private static final String CONSUMER_KEY = "com.twitter.sdk.android.CONSUMER_KEY";
    private static final String CONSUMER_SECRET = "com.twitter.sdk.android.CONSUMER_SECRET";
    public static final Logger DEFAULT_LOGGER = new DefaultLogger();
    private static final String NOT_INITIALIZED_MESSAGE = "Must initialize Twitter before using getInstance()";
    public static final String TAG = "Twitter";
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Twitter instance;
    private final Context context;
    private final boolean debug;
    private final ExecutorService executorService;
    private final ActivityLifecycleManager lifecycleManager;
    private final Logger logger;
    private final TwitterAuthConfig twitterAuthConfig;

    private Twitter(TwitterConfig twitterConfig) {
        Context context2 = twitterConfig.context;
        this.context = context2;
        this.lifecycleManager = new ActivityLifecycleManager(context2);
        TwitterAuthConfig twitterAuthConfig2 = twitterConfig.twitterAuthConfig;
        if (twitterAuthConfig2 == null) {
            this.twitterAuthConfig = new TwitterAuthConfig(CommonUtils.getStringResourceValue(context2, CONSUMER_KEY, ""), CommonUtils.getStringResourceValue(context2, CONSUMER_SECRET, ""));
        } else {
            this.twitterAuthConfig = twitterAuthConfig2;
        }
        ExecutorService executorService2 = twitterConfig.executorService;
        if (executorService2 == null) {
            this.executorService = ExecutorUtils.buildThreadPoolExecutorService("twitter-worker");
        } else {
            this.executorService = executorService2;
        }
        Logger logger2 = twitterConfig.logger;
        if (logger2 == null) {
            this.logger = DEFAULT_LOGGER;
        } else {
            this.logger = logger2;
        }
        Boolean bool = twitterConfig.debug;
        if (bool == null) {
            this.debug = false;
        } else {
            this.debug = bool.booleanValue();
        }
    }

    public static void checkInitialized() {
        if (instance == null) {
            throw new IllegalStateException(NOT_INITIALIZED_MESSAGE);
        }
    }

    public static synchronized Twitter createTwitter(TwitterConfig twitterConfig) {
        synchronized (Twitter.class) {
            if (instance == null) {
                instance = new Twitter(twitterConfig);
                Twitter twitter = instance;
                return twitter;
            }
            Twitter twitter2 = instance;
            return twitter2;
        }
    }

    public static Twitter getInstance() {
        checkInitialized();
        return instance;
    }

    public static Logger getLogger() {
        if (instance == null) {
            return DEFAULT_LOGGER;
        }
        return instance.logger;
    }

    public static void initialize(Context context2) {
        createTwitter(new TwitterConfig.Builder(context2).build());
    }

    public static boolean isDebug() {
        if (instance == null) {
            return false;
        }
        return instance.debug;
    }

    public ActivityLifecycleManager getActivityLifecycleManager() {
        return this.lifecycleManager;
    }

    public Context getContext(String str) {
        Context context2 = this.context;
        return new TwitterContext(context2, str, ".TwitterKit" + File.separator + str);
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public TwitterAuthConfig getTwitterAuthConfig() {
        return this.twitterAuthConfig;
    }

    public static void initialize(TwitterConfig twitterConfig) {
        createTwitter(twitterConfig);
    }
}
