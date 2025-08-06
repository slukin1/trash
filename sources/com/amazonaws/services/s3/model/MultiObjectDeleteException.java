package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.DeleteObjectsResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MultiObjectDeleteException extends AmazonS3Exception {
    private static final long serialVersionUID = -2004213552302446866L;
    private final List<DeleteObjectsResult.DeletedObject> deletedObjects;
    private final List<DeleteError> errors;

    public static class DeleteError {

        /* renamed from: a  reason: collision with root package name */
        public String f15258a;

        /* renamed from: b  reason: collision with root package name */
        public String f15259b;

        /* renamed from: c  reason: collision with root package name */
        public String f15260c;

        /* renamed from: d  reason: collision with root package name */
        public String f15261d;

        public void a(String str) {
            this.f15260c = str;
        }

        public void b(String str) {
            this.f15258a = str;
        }

        public void c(String str) {
            this.f15261d = str;
        }

        public void d(String str) {
            this.f15259b = str;
        }
    }

    public MultiObjectDeleteException(Collection<DeleteError> collection, Collection<DeleteObjectsResult.DeletedObject> collection2) {
        super("One or more objects could not be deleted");
        ArrayList arrayList = new ArrayList();
        this.errors = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.deletedObjects = arrayList2;
        arrayList2.addAll(collection2);
        arrayList.addAll(collection);
    }

    public List<DeleteObjectsResult.DeletedObject> getDeletedObjects() {
        return this.deletedObjects;
    }

    public String getErrorCode() {
        return super.getErrorCode();
    }

    public List<DeleteError> getErrors() {
        return this.errors;
    }
}
