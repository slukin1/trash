package com.zopim.android.sdk.breadcrumbs;

public class Event {
    public long timestamp;
    public String title = "";

    public Event(String str) {
        this.title = str;
        this.timestamp = System.currentTimeMillis();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        if (this.timestamp != event.timestamp) {
            return false;
        }
        String str = this.title;
        String str2 = event.title;
        if (str != null) {
            if (!str.equals(str2)) {
                return false;
            }
        } else if (str2 == null) {
            return true;
        } else {
            return false;
        }
        return true;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = str != null ? str.hashCode() : 0;
        long j11 = this.timestamp;
        return (hashCode * 31) + ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "title: " + this.title + " ts: " + this.timestamp;
    }

    public Event(String str, long j11) {
        this.title = str;
        this.timestamp = j11;
    }
}
