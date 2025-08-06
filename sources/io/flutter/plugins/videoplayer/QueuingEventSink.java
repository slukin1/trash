package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.EventChannel;
import java.util.ArrayList;
import java.util.Iterator;

final class QueuingEventSink implements EventChannel.EventSink {
    private EventChannel.EventSink delegate;
    private boolean done = false;
    private ArrayList<Object> eventQueue = new ArrayList<>();

    public static class EndOfStreamEvent {
        private EndOfStreamEvent() {
        }
    }

    public static class ErrorEvent {
        public String code;
        public Object details;
        public String message;

        public ErrorEvent(String str, String str2, Object obj) {
            this.code = str;
            this.message = str2;
            this.details = obj;
        }
    }

    private void enqueue(Object obj) {
        if (!this.done) {
            this.eventQueue.add(obj);
        }
    }

    private void maybeFlush() {
        if (this.delegate != null) {
            Iterator<Object> it2 = this.eventQueue.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (next instanceof EndOfStreamEvent) {
                    this.delegate.endOfStream();
                } else if (next instanceof ErrorEvent) {
                    ErrorEvent errorEvent = (ErrorEvent) next;
                    this.delegate.error(errorEvent.code, errorEvent.message, errorEvent.details);
                } else {
                    this.delegate.success(next);
                }
            }
            this.eventQueue.clear();
        }
    }

    public void endOfStream() {
        enqueue(new EndOfStreamEvent());
        maybeFlush();
        this.done = true;
    }

    public void error(String str, String str2, Object obj) {
        enqueue(new ErrorEvent(str, str2, obj));
        maybeFlush();
    }

    public void setDelegate(EventChannel.EventSink eventSink) {
        this.delegate = eventSink;
        maybeFlush();
    }

    public void success(Object obj) {
        enqueue(obj);
        maybeFlush();
    }
}
