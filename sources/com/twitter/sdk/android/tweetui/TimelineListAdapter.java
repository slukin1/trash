package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.database.DataSetObserver;
import android.widget.BaseAdapter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.models.Identifiable;

abstract class TimelineListAdapter<T extends Identifiable> extends BaseAdapter {
    public final Context context;
    public final TimelineDelegate<T> delegate;

    public TimelineListAdapter(Context context2, Timeline<T> timeline) {
        this(context2, new TimelineDelegate(timeline));
    }

    public int getCount() {
        return this.delegate.getCount();
    }

    public long getItemId(int i11) {
        return this.delegate.getItemId(i11);
    }

    public void notifyDataSetChanged() {
        this.delegate.notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated() {
        this.delegate.notifyDataSetInvalidated();
    }

    public void refresh(Callback<TimelineResult<T>> callback) {
        this.delegate.refresh(callback);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.delegate.registerDataSetObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.delegate.unregisterDataSetObserver(dataSetObserver);
    }

    public TimelineListAdapter(Context context2, TimelineDelegate<T> timelineDelegate) {
        if (context2 != null) {
            this.context = context2;
            this.delegate = timelineDelegate;
            timelineDelegate.refresh((Callback<TimelineResult<T>>) null);
            return;
        }
        throw new IllegalArgumentException("Context must not be null");
    }

    public T getItem(int i11) {
        return this.delegate.getItem(i11);
    }
}
