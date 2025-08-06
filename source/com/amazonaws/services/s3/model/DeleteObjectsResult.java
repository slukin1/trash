package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DeleteObjectsResult implements Serializable, S3RequesterChargedResult {
    private final List<DeletedObject> deletedObjects;
    private boolean isRequesterCharged;

    public static class DeletedObject implements Serializable {
        private boolean deleteMarker;
        private String deleteMarkerVersionId;
        private String key;
        private String versionId;

        public String getDeleteMarkerVersionId() {
            return this.deleteMarkerVersionId;
        }

        public String getKey() {
            return this.key;
        }

        public String getVersionId() {
            return this.versionId;
        }

        public boolean isDeleteMarker() {
            return this.deleteMarker;
        }

        public void setDeleteMarker(boolean z11) {
            this.deleteMarker = z11;
        }

        public void setDeleteMarkerVersionId(String str) {
            this.deleteMarkerVersionId = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setVersionId(String str) {
            this.versionId = str;
        }
    }

    public DeleteObjectsResult(List<DeletedObject> list) {
        this(list, false);
    }

    public List<DeletedObject> getDeletedObjects() {
        return this.deletedObjects;
    }

    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public void setRequesterCharged(boolean z11) {
        this.isRequesterCharged = z11;
    }

    public DeleteObjectsResult(List<DeletedObject> list, boolean z11) {
        ArrayList arrayList = new ArrayList();
        this.deletedObjects = arrayList;
        arrayList.addAll(list);
        setRequesterCharged(z11);
    }
}
