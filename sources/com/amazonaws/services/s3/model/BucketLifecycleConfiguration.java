package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BucketLifecycleConfiguration implements Serializable {
    public static final String DISABLED = "Disabled";
    public static final String ENABLED = "Enabled";
    private List<Rule> rules;

    public static class NoncurrentVersionTransition implements Serializable {
        private int days = -1;
        private String storageClass;

        public int getDays() {
            return this.days;
        }

        @Deprecated
        public StorageClass getStorageClass() {
            try {
                return StorageClass.fromValue(this.storageClass);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public String getStorageClassAsString() {
            return this.storageClass;
        }

        public void setDays(int i11) {
            this.days = i11;
        }

        public void setStorageClass(StorageClass storageClass2) {
            if (storageClass2 == null) {
                setStorageClass((String) null);
            } else {
                setStorageClass(storageClass2.toString());
            }
        }

        public NoncurrentVersionTransition withDays(int i11) {
            this.days = i11;
            return this;
        }

        public NoncurrentVersionTransition withStorageClass(StorageClass storageClass2) {
            setStorageClass(storageClass2);
            return this;
        }

        public NoncurrentVersionTransition withStorageClass(String str) {
            setStorageClass(str);
            return this;
        }

        public void setStorageClass(String str) {
            this.storageClass = str;
        }
    }

    public static class Rule implements Serializable {
        private AbortIncompleteMultipartUpload abortIncompleteMultipartUpload;
        private Date expirationDate;
        private int expirationInDays = -1;
        private boolean expiredObjectDeleteMarker = false;
        private LifecycleFilter filter;

        /* renamed from: id  reason: collision with root package name */
        private String f15205id;
        private int noncurrentVersionExpirationInDays = -1;
        private List<NoncurrentVersionTransition> noncurrentVersionTransitions;
        private String prefix;
        private String status;
        private List<Transition> transitions;

        public Rule addNoncurrentVersionTransition(NoncurrentVersionTransition noncurrentVersionTransition) {
            if (noncurrentVersionTransition != null) {
                if (this.noncurrentVersionTransitions == null) {
                    this.noncurrentVersionTransitions = new ArrayList();
                }
                this.noncurrentVersionTransitions.add(noncurrentVersionTransition);
                return this;
            }
            throw new IllegalArgumentException("NoncurrentVersionTransition cannot be null.");
        }

        public Rule addTransition(Transition transition) {
            if (transition != null) {
                if (this.transitions == null) {
                    this.transitions = new ArrayList();
                }
                this.transitions.add(transition);
                return this;
            }
            throw new IllegalArgumentException("Transition cannot be null.");
        }

        public AbortIncompleteMultipartUpload getAbortIncompleteMultipartUpload() {
            return this.abortIncompleteMultipartUpload;
        }

        public Date getExpirationDate() {
            return this.expirationDate;
        }

        public int getExpirationInDays() {
            return this.expirationInDays;
        }

        public LifecycleFilter getFilter() {
            return this.filter;
        }

        public String getId() {
            return this.f15205id;
        }

        public int getNoncurrentVersionExpirationInDays() {
            return this.noncurrentVersionExpirationInDays;
        }

        @Deprecated
        public NoncurrentVersionTransition getNoncurrentVersionTransition() {
            List<NoncurrentVersionTransition> noncurrentVersionTransitions2 = getNoncurrentVersionTransitions();
            if (noncurrentVersionTransitions2 == null || noncurrentVersionTransitions2.isEmpty()) {
                return null;
            }
            return noncurrentVersionTransitions2.get(noncurrentVersionTransitions2.size() - 1);
        }

        public List<NoncurrentVersionTransition> getNoncurrentVersionTransitions() {
            return this.noncurrentVersionTransitions;
        }

        @Deprecated
        public String getPrefix() {
            return this.prefix;
        }

        public String getStatus() {
            return this.status;
        }

        @Deprecated
        public Transition getTransition() {
            List<Transition> transitions2 = getTransitions();
            if (transitions2 == null || transitions2.isEmpty()) {
                return null;
            }
            return transitions2.get(transitions2.size() - 1);
        }

        public List<Transition> getTransitions() {
            return this.transitions;
        }

        public boolean isExpiredObjectDeleteMarker() {
            return this.expiredObjectDeleteMarker;
        }

        public void setAbortIncompleteMultipartUpload(AbortIncompleteMultipartUpload abortIncompleteMultipartUpload2) {
            this.abortIncompleteMultipartUpload = abortIncompleteMultipartUpload2;
        }

        public void setExpirationDate(Date date) {
            this.expirationDate = date;
        }

        public void setExpirationInDays(int i11) {
            this.expirationInDays = i11;
        }

        public void setExpiredObjectDeleteMarker(boolean z11) {
            this.expiredObjectDeleteMarker = z11;
        }

        public void setFilter(LifecycleFilter lifecycleFilter) {
            this.filter = lifecycleFilter;
        }

        public void setId(String str) {
            this.f15205id = str;
        }

        public void setNoncurrentVersionExpirationInDays(int i11) {
            this.noncurrentVersionExpirationInDays = i11;
        }

        @Deprecated
        public void setNoncurrentVersionTransition(NoncurrentVersionTransition noncurrentVersionTransition) {
            setNoncurrentVersionTransitions(Arrays.asList(new NoncurrentVersionTransition[]{noncurrentVersionTransition}));
        }

        public void setNoncurrentVersionTransitions(List<NoncurrentVersionTransition> list) {
            this.noncurrentVersionTransitions = new ArrayList(list);
        }

        @Deprecated
        public void setPrefix(String str) {
            this.prefix = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        @Deprecated
        public void setTransition(Transition transition) {
            setTransitions(Arrays.asList(new Transition[]{transition}));
        }

        public void setTransitions(List<Transition> list) {
            if (list != null) {
                this.transitions = new ArrayList(list);
            }
        }

        public Rule withAbortIncompleteMultipartUpload(AbortIncompleteMultipartUpload abortIncompleteMultipartUpload2) {
            setAbortIncompleteMultipartUpload(abortIncompleteMultipartUpload2);
            return this;
        }

        public Rule withExpirationDate(Date date) {
            this.expirationDate = date;
            return this;
        }

        public Rule withExpirationInDays(int i11) {
            this.expirationInDays = i11;
            return this;
        }

        public Rule withExpiredObjectDeleteMarker(boolean z11) {
            this.expiredObjectDeleteMarker = z11;
            return this;
        }

        public Rule withFilter(LifecycleFilter lifecycleFilter) {
            setFilter(lifecycleFilter);
            return this;
        }

        public Rule withId(String str) {
            this.f15205id = str;
            return this;
        }

        public Rule withNoncurrentVersionExpirationInDays(int i11) {
            setNoncurrentVersionExpirationInDays(i11);
            return this;
        }

        @Deprecated
        public Rule withNoncurrentVersionTransition(NoncurrentVersionTransition noncurrentVersionTransition) {
            setNoncurrentVersionTransitions(Arrays.asList(new NoncurrentVersionTransition[]{noncurrentVersionTransition}));
            return this;
        }

        public Rule withNoncurrentVersionTransitions(List<NoncurrentVersionTransition> list) {
            setNoncurrentVersionTransitions(list);
            return this;
        }

        @Deprecated
        public Rule withPrefix(String str) {
            this.prefix = str;
            return this;
        }

        public Rule withStatus(String str) {
            setStatus(str);
            return this;
        }

        @Deprecated
        public Rule withTransition(Transition transition) {
            setTransitions(Arrays.asList(new Transition[]{transition}));
            return this;
        }

        public Rule withTransitions(List<Transition> list) {
            setTransitions(list);
            return this;
        }
    }

    public static class Transition implements Serializable {
        private Date date;
        private int days = -1;
        private String storageClass;

        public Date getDate() {
            return this.date;
        }

        public int getDays() {
            return this.days;
        }

        @Deprecated
        public StorageClass getStorageClass() {
            try {
                return StorageClass.fromValue(this.storageClass);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public String getStorageClassAsString() {
            return this.storageClass;
        }

        public void setDate(Date date2) {
            this.date = date2;
        }

        public void setDays(int i11) {
            this.days = i11;
        }

        public void setStorageClass(StorageClass storageClass2) {
            if (storageClass2 == null) {
                setStorageClass((String) null);
            } else {
                setStorageClass(storageClass2.toString());
            }
        }

        public Transition withDate(Date date2) {
            this.date = date2;
            return this;
        }

        public Transition withDays(int i11) {
            this.days = i11;
            return this;
        }

        public Transition withStorageClass(StorageClass storageClass2) {
            setStorageClass(storageClass2);
            return this;
        }

        public Transition withStorageClass(String str) {
            setStorageClass(str);
            return this;
        }

        public void setStorageClass(String str) {
            this.storageClass = str;
        }
    }

    public BucketLifecycleConfiguration(List<Rule> list) {
        this.rules = list;
    }

    public List<Rule> getRules() {
        return this.rules;
    }

    public void setRules(List<Rule> list) {
        this.rules = list;
    }

    public BucketLifecycleConfiguration withRules(List<Rule> list) {
        setRules(list);
        return this;
    }

    public BucketLifecycleConfiguration withRules(Rule... ruleArr) {
        setRules(Arrays.asList(ruleArr));
        return this;
    }

    public BucketLifecycleConfiguration() {
    }
}
