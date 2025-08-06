package com.amazonaws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.metrics.RequestMetricCollector;

public abstract class AmazonWebServiceRequest implements Cloneable {
    private AmazonWebServiceRequest cloneSource;
    private AWSCredentials credentials;
    private ProgressListener generalProgressListener;
    private final RequestClientOptions requestClientOptions = new RequestClientOptions();
    @Deprecated
    private RequestMetricCollector requestMetricCollector;

    private void setCloneSource(AmazonWebServiceRequest amazonWebServiceRequest) {
        this.cloneSource = amazonWebServiceRequest;
    }

    public final <T extends AmazonWebServiceRequest> T copyBaseTo(T t11) {
        t11.setGeneralProgressListener(this.generalProgressListener);
        t11.setRequestMetricCollector(this.requestMetricCollector);
        return t11;
    }

    public AmazonWebServiceRequest getCloneRoot() {
        AmazonWebServiceRequest amazonWebServiceRequest = this.cloneSource;
        if (amazonWebServiceRequest != null) {
            while (amazonWebServiceRequest.getCloneSource() != null) {
                amazonWebServiceRequest = amazonWebServiceRequest.getCloneSource();
            }
        }
        return amazonWebServiceRequest;
    }

    public AmazonWebServiceRequest getCloneSource() {
        return this.cloneSource;
    }

    public ProgressListener getGeneralProgressListener() {
        return this.generalProgressListener;
    }

    public RequestClientOptions getRequestClientOptions() {
        return this.requestClientOptions;
    }

    public AWSCredentials getRequestCredentials() {
        return this.credentials;
    }

    @Deprecated
    public RequestMetricCollector getRequestMetricCollector() {
        return this.requestMetricCollector;
    }

    public void setGeneralProgressListener(ProgressListener progressListener) {
        this.generalProgressListener = progressListener;
    }

    public void setRequestCredentials(AWSCredentials aWSCredentials) {
        this.credentials = aWSCredentials;
    }

    @Deprecated
    public void setRequestMetricCollector(RequestMetricCollector requestMetricCollector2) {
        this.requestMetricCollector = requestMetricCollector2;
    }

    public <T extends AmazonWebServiceRequest> T withGeneralProgressListener(ProgressListener progressListener) {
        setGeneralProgressListener(progressListener);
        return this;
    }

    @Deprecated
    public <T extends AmazonWebServiceRequest> T withRequestMetricCollector(RequestMetricCollector requestMetricCollector2) {
        setRequestMetricCollector(requestMetricCollector2);
        return this;
    }

    public AmazonWebServiceRequest clone() {
        try {
            AmazonWebServiceRequest amazonWebServiceRequest = (AmazonWebServiceRequest) super.clone();
            amazonWebServiceRequest.setCloneSource(this);
            return amazonWebServiceRequest;
        } catch (CloneNotSupportedException e11) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e11);
        }
    }
}
