package com.google.android.datatransport.runtime.dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import q00.a;

public final class SetFactory<T> implements Factory<Set<T>> {
    private static final Factory<Set<Object>> EMPTY_FACTORY = InstanceFactory.create(Collections.emptySet());
    private final List<a<Collection<T>>> collectionProviders;
    private final List<a<T>> individualProviders;

    public static final class Builder<T> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<a<Collection<T>>> collectionProviders;
        private final List<a<T>> individualProviders;

        public Builder<T> addCollectionProvider(a<? extends Collection<? extends T>> aVar) {
            this.collectionProviders.add(aVar);
            return this;
        }

        public Builder<T> addProvider(a<? extends T> aVar) {
            this.individualProviders.add(aVar);
            return this;
        }

        public SetFactory<T> build() {
            return new SetFactory<>(this.individualProviders, this.collectionProviders);
        }

        private Builder(int i11, int i12) {
            this.individualProviders = DaggerCollections.presizedList(i11);
            this.collectionProviders = DaggerCollections.presizedList(i12);
        }
    }

    public static <T> Builder<T> builder(int i11, int i12) {
        return new Builder<>(i11, i12);
    }

    public static <T> Factory<Set<T>> empty() {
        return EMPTY_FACTORY;
    }

    private SetFactory(List<a<T>> list, List<a<Collection<T>>> list2) {
        this.individualProviders = list;
        this.collectionProviders = list2;
    }

    public Set<T> get() {
        int size = this.individualProviders.size();
        ArrayList arrayList = new ArrayList(this.collectionProviders.size());
        int size2 = this.collectionProviders.size();
        for (int i11 = 0; i11 < size2; i11++) {
            Collection collection = (Collection) this.collectionProviders.get(i11).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet newHashSetWithExpectedSize = DaggerCollections.newHashSetWithExpectedSize(size);
        int size3 = this.individualProviders.size();
        for (int i12 = 0; i12 < size3; i12++) {
            newHashSetWithExpectedSize.add(Preconditions.checkNotNull(this.individualProviders.get(i12).get()));
        }
        int size4 = arrayList.size();
        for (int i13 = 0; i13 < size4; i13++) {
            for (Object checkNotNull : (Collection) arrayList.get(i13)) {
                newHashSetWithExpectedSize.add(Preconditions.checkNotNull(checkNotNull));
            }
        }
        return Collections.unmodifiableSet(newHashSetWithExpectedSize);
    }
}
