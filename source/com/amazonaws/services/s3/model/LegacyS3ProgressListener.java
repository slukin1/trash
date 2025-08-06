package com.amazonaws.services.s3.model;

import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;

public class LegacyS3ProgressListener implements ProgressListener {

    /* renamed from: a  reason: collision with root package name */
    public final ProgressListener f15232a;

    public LegacyS3ProgressListener(ProgressListener progressListener) {
        this.f15232a = progressListener;
    }

    public void a(ProgressEvent progressEvent) {
        ProgressListener progressListener = this.f15232a;
        if (progressListener != null) {
            progressListener.a(b(progressEvent));
        }
    }

    public final ProgressEvent b(ProgressEvent progressEvent) {
        return new ProgressEvent(progressEvent.b(), progressEvent.a());
    }

    public ProgressListener c() {
        return this.f15232a;
    }
}
