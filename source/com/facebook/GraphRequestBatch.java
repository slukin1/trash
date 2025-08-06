package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphRequestBatch extends AbstractList<GraphRequest> {
    private static AtomicInteger idGenerator = new AtomicInteger();
    private String batchApplicationId;
    private Handler callbackHandler;
    private List<Callback> callbacks;

    /* renamed from: id  reason: collision with root package name */
    private final String f64990id;
    private List<GraphRequest> requests;
    private int timeoutInMilliseconds;

    public interface Callback {
        void onBatchCompleted(GraphRequestBatch graphRequestBatch);
    }

    public interface OnProgressCallback extends Callback {
        void onBatchProgress(GraphRequestBatch graphRequestBatch, long j11, long j12);
    }

    public GraphRequestBatch() {
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.f64990id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList();
    }

    public void addCallback(Callback callback) {
        if (!this.callbacks.contains(callback)) {
            this.callbacks.add(callback);
        }
    }

    public final void clear() {
        this.requests.clear();
    }

    public final List<GraphResponse> executeAndWait() {
        return executeAndWaitImpl();
    }

    public List<GraphResponse> executeAndWaitImpl() {
        return GraphRequest.executeBatchAndWait(this);
    }

    public final GraphRequestAsyncTask executeAsync() {
        return executeAsyncImpl();
    }

    public GraphRequestAsyncTask executeAsyncImpl() {
        return GraphRequest.executeBatchAsync(this);
    }

    public final String getBatchApplicationId() {
        return this.batchApplicationId;
    }

    public final Handler getCallbackHandler() {
        return this.callbackHandler;
    }

    public final List<Callback> getCallbacks() {
        return this.callbacks;
    }

    public final String getId() {
        return this.f64990id;
    }

    public final List<GraphRequest> getRequests() {
        return this.requests;
    }

    public int getTimeout() {
        return this.timeoutInMilliseconds;
    }

    public void removeCallback(Callback callback) {
        this.callbacks.remove(callback);
    }

    public final void setBatchApplicationId(String str) {
        this.batchApplicationId = str;
    }

    public final void setCallbackHandler(Handler handler) {
        this.callbackHandler = handler;
    }

    public void setTimeout(int i11) {
        if (i11 >= 0) {
            this.timeoutInMilliseconds = i11;
            return;
        }
        throw new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
    }

    public final int size() {
        return this.requests.size();
    }

    public final GraphRequest get(int i11) {
        return this.requests.get(i11);
    }

    public final GraphRequest remove(int i11) {
        return this.requests.remove(i11);
    }

    public final GraphRequest set(int i11, GraphRequest graphRequest) {
        return this.requests.set(i11, graphRequest);
    }

    public final boolean add(GraphRequest graphRequest) {
        return this.requests.add(graphRequest);
    }

    public final void add(int i11, GraphRequest graphRequest) {
        this.requests.add(i11, graphRequest);
    }

    public GraphRequestBatch(Collection<GraphRequest> collection) {
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.f64990id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(collection);
    }

    public GraphRequestBatch(GraphRequest... graphRequestArr) {
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.f64990id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = Arrays.asList(graphRequestArr);
    }

    public GraphRequestBatch(GraphRequestBatch graphRequestBatch) {
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.f64990id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(graphRequestBatch);
        this.callbackHandler = graphRequestBatch.callbackHandler;
        this.timeoutInMilliseconds = graphRequestBatch.timeoutInMilliseconds;
        this.callbacks = new ArrayList(graphRequestBatch.callbacks);
    }
}
