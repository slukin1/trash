package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Identifiable;
import com.twitter.sdk.android.core.models.Tweet;

public class TweetTimelineListAdapter extends TimelineListAdapter<Tweet> {
    public Callback<Tweet> actionCallback;
    public final int styleResId;
    public TweetUi tweetUi;

    public static class Builder {
        private Callback<Tweet> actionCallback;
        private Context context;
        private int styleResId = R.style.tw__TweetLightStyle;
        private Timeline<Tweet> timeline;
        private TimelineFilter timelineFilter;

        public Builder(Context context2) {
            this.context = context2;
        }

        public TweetTimelineListAdapter build() {
            TimelineFilter timelineFilter2 = this.timelineFilter;
            if (timelineFilter2 == null) {
                return new TweetTimelineListAdapter(this.context, this.timeline, this.styleResId, this.actionCallback);
            }
            return new TweetTimelineListAdapter(this.context, new FilterTimelineDelegate(this.timeline, timelineFilter2), this.styleResId, this.actionCallback, TweetUi.getInstance());
        }

        public Builder setOnActionCallback(Callback<Tweet> callback) {
            this.actionCallback = callback;
            return this;
        }

        public Builder setTimeline(Timeline<Tweet> timeline2) {
            this.timeline = timeline2;
            return this;
        }

        public Builder setTimelineFilter(TimelineFilter timelineFilter2) {
            this.timelineFilter = timelineFilter2;
            return this;
        }

        public Builder setViewStyle(int i11) {
            this.styleResId = i11;
            return this;
        }
    }

    public static class ReplaceTweetCallback extends Callback<Tweet> {

        /* renamed from: cb  reason: collision with root package name */
        public Callback<Tweet> f51215cb;
        public TimelineDelegate<Tweet> delegate;

        public ReplaceTweetCallback(TimelineDelegate<Tweet> timelineDelegate, Callback<Tweet> callback) {
            this.delegate = timelineDelegate;
            this.f51215cb = callback;
        }

        public void failure(TwitterException twitterException) {
            Callback<Tweet> callback = this.f51215cb;
            if (callback != null) {
                callback.failure(twitterException);
            }
        }

        public void success(Result<Tweet> result) {
            this.delegate.setItemById((Identifiable) result.data);
            Callback<Tweet> callback = this.f51215cb;
            if (callback != null) {
                callback.success(result);
            }
        }
    }

    public TweetTimelineListAdapter(Context context, Timeline<Tweet> timeline) {
        this(context, timeline, R.style.tw__TweetLightStyle, (Callback<Tweet>) null);
    }

    public /* bridge */ /* synthetic */ int getCount() {
        return super.getCount();
    }

    public /* bridge */ /* synthetic */ long getItemId(int i11) {
        return super.getItemId(i11);
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        Tweet tweet = (Tweet) getItem(i11);
        if (view == null) {
            CompactTweetView compactTweetView = new CompactTweetView(this.context, tweet, this.styleResId);
            compactTweetView.setOnActionCallback(this.actionCallback);
            return compactTweetView;
        }
        ((BaseTweetView) view).setTweet(tweet);
        return view;
    }

    public /* bridge */ /* synthetic */ void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public /* bridge */ /* synthetic */ void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
    }

    public /* bridge */ /* synthetic */ void refresh(Callback callback) {
        super.refresh(callback);
    }

    public /* bridge */ /* synthetic */ void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
    }

    public /* bridge */ /* synthetic */ void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
    }

    public TweetTimelineListAdapter(Context context, Timeline<Tweet> timeline, int i11, Callback<Tweet> callback) {
        this(context, new TimelineDelegate(timeline), i11, callback, TweetUi.getInstance());
    }

    public TweetTimelineListAdapter(Context context, TimelineDelegate<Tweet> timelineDelegate, int i11, Callback<Tweet> callback, TweetUi tweetUi2) {
        super(context, timelineDelegate);
        this.styleResId = i11;
        this.actionCallback = new ReplaceTweetCallback(timelineDelegate, callback);
        this.tweetUi = tweetUi2;
    }
}
