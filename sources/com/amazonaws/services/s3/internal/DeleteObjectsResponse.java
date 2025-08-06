package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.MultiObjectDeleteException;
import java.util.ArrayList;
import java.util.List;

public class DeleteObjectsResponse implements S3RequesterChargedResult {

    /* renamed from: b  reason: collision with root package name */
    public List<DeleteObjectsResult.DeletedObject> f15144b;

    /* renamed from: c  reason: collision with root package name */
    public List<MultiObjectDeleteException.DeleteError> f15145c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f15146d;

    public DeleteObjectsResponse() {
        this(new ArrayList(), new ArrayList());
    }

    public List<DeleteObjectsResult.DeletedObject> a() {
        return this.f15144b;
    }

    public List<MultiObjectDeleteException.DeleteError> b() {
        return this.f15145c;
    }

    public void setRequesterCharged(boolean z11) {
        this.f15146d = z11;
    }

    public DeleteObjectsResponse(List<DeleteObjectsResult.DeletedObject> list, List<MultiObjectDeleteException.DeleteError> list2) {
        this.f15144b = list;
        this.f15145c = list2;
    }
}
