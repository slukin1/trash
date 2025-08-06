package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Identifiable;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetBuilder;

public class TweetTimelineRecyclerViewAdapter extends RecyclerView.Adapter<TweetViewHolder> {
    public Callback<Tweet> actionCallback;
    public final Context context;
    /* access modifiers changed from: private */
    public int previousCount;
    public final int styleResId;
    public final TimelineDelegate<Tweet> timelineDelegate;
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

        public TweetTimelineRecyclerViewAdapter build() {
            TimelineFilter timelineFilter2 = this.timelineFilter;
            if (timelineFilter2 == null) {
                return new TweetTimelineRecyclerViewAdapter(this.context, this.timeline, this.styleResId, this.actionCallback);
            }
            return new TweetTimelineRecyclerViewAdapter(this.context, new FilterTimelineDelegate(this.timeline, timelineFilter2), this.styleResId, this.actionCallback, TweetUi.getInstance());
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
        public Callback<Tweet> f51216cb;
        public TimelineDelegate<Tweet> delegate;

        public ReplaceTweetCallback(TimelineDelegate<Tweet> timelineDelegate, Callback<Tweet> callback) {
            this.delegate = timelineDelegate;
            this.f51216cb = callback;
        }

        public void failure(TwitterException twitterException) {
            Callback<Tweet> callback = this.f51216cb;
            if (callback != null) {
                callback.failure(twitterException);
            }
        }

        public void success(Result<Tweet> result) {
            this.delegate.setItemById((Identifiable) result.data);
            Callback<Tweet> callback = this.f51216cb;
            if (callback != null) {
                callback.success(result);
            }
        }
    }

    public static final class TweetViewHolder extends RecyclerView.ViewHolder {
        public TweetViewHolder(CompactTweetView compactTweetView) {
            super(compactTweetView);
        }
    }

    public TweetTimelineRecyclerViewAdapter(Context context2, Timeline<Tweet> timeline) {
        this(context2, timeline, R.style.tw__TweetLightStyle, (Callback<Tweet>) null);
    }

    public int getItemCount() {
        return this.timelineDelegate.getCount();
    }

    public void refresh(Callback<TimelineResult<Tweet>> callback) {
        this.timelineDelegate.refresh(callback);
        this.previousCount = 0;
    }

    public TweetTimelineRecyclerViewAdapter(Context context2, Timeline<Tweet> timeline, int i11, Callback<Tweet> callback) {
        this(context2, new TimelineDelegate(timeline), i11, callback, TweetUi.getInstance());
    }

    public void onBindViewHolder(TweetViewHolder tweetViewHolder, int i11) {
        ((CompactTweetView) tweetViewHolder.itemView).setTweet(this.timelineDelegate.getItem(i11));
    }

    public TweetViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        CompactTweetView compactTweetView = new CompactTweetView(this.context, new TweetBuilder().build(), this.styleResId);
        compactTweetView.setOnActionCallback(this.actionCallback);
        return new TweetViewHolder(compactTweetView);
    }

    public TweetTimelineRecyclerViewAdapter(Context context2, TimelineDelegate<Tweet> timelineDelegate2, int i11, Callback<Tweet> callback, TweetUi tweetUi2) {
        this(context2, timelineDelegate2, i11);
        this.actionCallback = new ReplaceTweetCallback(timelineDelegate2, callback);
        this.tweetUi = tweetUi2;
    }

    public TweetTimelineRecyclerViewAdapter(Context context2, TimelineDelegate<Tweet> timelineDelegate2, int i11) {
        if (context2 != null) {
            this.context = context2;
            this.timelineDelegate = timelineDelegate2;
            this.styleResId = i11;
            timelineDelegate2.refresh(new Callback<TimelineResult<Tweet>>() {
                public void failure(TwitterException twitterException) {
                }

                public void success(Result<TimelineResult<Tweet>> result) {
                    TweetTimelineRecyclerViewAdapter.this.notifyDataSetChanged();
                    TweetTimelineRecyclerViewAdapter tweetTimelineRecyclerViewAdapter = TweetTimelineRecyclerViewAdapter.this;
                    int unused = tweetTimelineRecyclerViewAdapter.previousCount = tweetTimelineRecyclerViewAdapter.timelineDelegate.getCount();
                }
            });
            timelineDelegate2.registerDataSetObserver(new DataSetObserver() {
                public void onChanged() {
                    super.onChanged();
                    if (TweetTimelineRecyclerViewAdapter.this.previousCount == 0) {
                        TweetTimelineRecyclerViewAdapter.this.notifyDataSetChanged();
                    } else {
                        TweetTimelineRecyclerViewAdapter tweetTimelineRecyclerViewAdapter = TweetTimelineRecyclerViewAdapter.this;
                        tweetTimelineRecyclerViewAdapter.notifyItemRangeInserted(tweetTimelineRecyclerViewAdapter.previousCount, TweetTimelineRecyclerViewAdapter.this.timelineDelegate.getCount() - TweetTimelineRecyclerViewAdapter.this.previousCount);
                    }
                    TweetTimelineRecyclerViewAdapter tweetTimelineRecyclerViewAdapter2 = TweetTimelineRecyclerViewAdapter.this;
                    int unused = tweetTimelineRecyclerViewAdapter2.previousCount = tweetTimelineRecyclerViewAdapter2.timelineDelegate.getCount();
                }

                public void onInvalidated() {
                    TweetTimelineRecyclerViewAdapter.this.notifyDataSetChanged();
                    super.onInvalidated();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Context must not be null");
    }
}
