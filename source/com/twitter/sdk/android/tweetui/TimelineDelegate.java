package com.twitter.sdk.android.tweetui;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Identifiable;
import java.util.ArrayList;
import java.util.List;

class TimelineDelegate<T extends Identifiable> {
    public static final long CAPACITY = 200;
    public List<T> itemList;
    public final DataSetObservable listAdapterObservable;
    public final Timeline<T> timeline;
    public final TimelineStateHolder timelineStateHolder;

    public class DefaultCallback extends Callback<TimelineResult<T>> {
        public final Callback<TimelineResult<T>> developerCallback;
        public final TimelineStateHolder timelineStateHolder;

        public DefaultCallback(Callback<TimelineResult<T>> callback, TimelineStateHolder timelineStateHolder2) {
            this.developerCallback = callback;
            this.timelineStateHolder = timelineStateHolder2;
        }

        public void failure(TwitterException twitterException) {
            this.timelineStateHolder.finishTimelineRequest();
            Callback<TimelineResult<T>> callback = this.developerCallback;
            if (callback != null) {
                callback.failure(twitterException);
            }
        }

        public void success(Result<TimelineResult<T>> result) {
            this.timelineStateHolder.finishTimelineRequest();
            Callback<TimelineResult<T>> callback = this.developerCallback;
            if (callback != null) {
                callback.success(result);
            }
        }
    }

    public class NextCallback extends TimelineDelegate<T>.DefaultCallback {
        public NextCallback(Callback<TimelineResult<T>> callback, TimelineStateHolder timelineStateHolder) {
            super(callback, timelineStateHolder);
        }

        public void success(Result<TimelineResult<T>> result) {
            if (((TimelineResult) result.data).items.size() > 0) {
                ArrayList arrayList = new ArrayList(((TimelineResult) result.data).items);
                arrayList.addAll(TimelineDelegate.this.itemList);
                TimelineDelegate timelineDelegate = TimelineDelegate.this;
                timelineDelegate.itemList = arrayList;
                timelineDelegate.notifyDataSetChanged();
                this.timelineStateHolder.setNextCursor(((TimelineResult) result.data).timelineCursor);
            }
            super.success(result);
        }
    }

    public class PreviousCallback extends TimelineDelegate<T>.DefaultCallback {
        public PreviousCallback(TimelineStateHolder timelineStateHolder) {
            super((Callback) null, timelineStateHolder);
        }

        public void success(Result<TimelineResult<T>> result) {
            if (((TimelineResult) result.data).items.size() > 0) {
                TimelineDelegate.this.itemList.addAll(((TimelineResult) result.data).items);
                TimelineDelegate.this.notifyDataSetChanged();
                this.timelineStateHolder.setPreviousCursor(((TimelineResult) result.data).timelineCursor);
            }
            super.success(result);
        }
    }

    public class RefreshCallback extends TimelineDelegate<T>.NextCallback {
        public RefreshCallback(Callback<TimelineResult<T>> callback, TimelineStateHolder timelineStateHolder) {
            super(callback, timelineStateHolder);
        }

        public void success(Result<TimelineResult<T>> result) {
            if (((TimelineResult) result.data).items.size() > 0) {
                TimelineDelegate.this.itemList.clear();
            }
            super.success(result);
        }
    }

    public TimelineDelegate(Timeline<T> timeline2) {
        this(timeline2, (DataSetObservable) null, (List) null);
    }

    public int getCount() {
        return this.itemList.size();
    }

    public T getItem(int i11) {
        if (isLastPosition(i11)) {
            previous();
        }
        return (Identifiable) this.itemList.get(i11);
    }

    public long getItemId(int i11) {
        return ((Identifiable) this.itemList.get(i11)).getId();
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    public boolean isLastPosition(int i11) {
        return i11 == this.itemList.size() - 1;
    }

    public void loadNext(Long l11, Callback<TimelineResult<T>> callback) {
        if (!withinMaxCapacity()) {
            callback.failure(new TwitterException("Max capacity reached"));
        } else if (this.timelineStateHolder.startTimelineRequest()) {
            this.timeline.next(l11, callback);
        } else {
            callback.failure(new TwitterException("Request already in flight"));
        }
    }

    public void loadPrevious(Long l11, Callback<TimelineResult<T>> callback) {
        if (!withinMaxCapacity()) {
            callback.failure(new TwitterException("Max capacity reached"));
        } else if (this.timelineStateHolder.startTimelineRequest()) {
            this.timeline.previous(l11, callback);
        } else {
            callback.failure(new TwitterException("Request already in flight"));
        }
    }

    public void next(Callback<TimelineResult<T>> callback) {
        loadNext(this.timelineStateHolder.positionForNext(), new NextCallback(callback, this.timelineStateHolder));
    }

    public void notifyDataSetChanged() {
        this.listAdapterObservable.notifyChanged();
    }

    public void notifyDataSetInvalidated() {
        this.listAdapterObservable.notifyInvalidated();
    }

    public void previous() {
        loadPrevious(this.timelineStateHolder.positionForPrevious(), new PreviousCallback(this.timelineStateHolder));
    }

    public void refresh(Callback<TimelineResult<T>> callback) {
        this.timelineStateHolder.resetCursors();
        loadNext(this.timelineStateHolder.positionForNext(), new RefreshCallback(callback, this.timelineStateHolder));
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.listAdapterObservable.registerObserver(dataSetObserver);
    }

    public void setItemById(T t11) {
        for (int i11 = 0; i11 < this.itemList.size(); i11++) {
            if (t11.getId() == ((Identifiable) this.itemList.get(i11)).getId()) {
                this.itemList.set(i11, t11);
            }
        }
        notifyDataSetChanged();
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.listAdapterObservable.unregisterObserver(dataSetObserver);
    }

    public boolean withinMaxCapacity() {
        return ((long) this.itemList.size()) < 200;
    }

    public TimelineDelegate(Timeline<T> timeline2, DataSetObservable dataSetObservable, List<T> list) {
        if (timeline2 != null) {
            this.timeline = timeline2;
            this.timelineStateHolder = new TimelineStateHolder();
            if (dataSetObservable == null) {
                this.listAdapterObservable = new DataSetObservable();
            } else {
                this.listAdapterObservable = dataSetObservable;
            }
            if (list == null) {
                this.itemList = new ArrayList();
            } else {
                this.itemList = list;
            }
        } else {
            throw new IllegalArgumentException("Timeline must not be null");
        }
    }
}
