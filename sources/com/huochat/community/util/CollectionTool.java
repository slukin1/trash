package com.huochat.community.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class CollectionTool {
    public static final Companion Companion = new Companion((r) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final boolean equals(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return true;
            }
            if (obj == null || obj2 == null) {
                return false;
            }
            return x.b(obj, obj2);
        }

        public final int getCollectionSize(Collection<?> collection) {
            if (collection != null) {
                return collection.size();
            }
            return 0;
        }

        public final <T> T getListFirstItem(List<T> list) {
            return safeGetListItem(0, list);
        }

        public final <T> T getListLastItem(List<? extends T> list) {
            int collectionSize = getCollectionSize(list);
            if (collectionSize > 0) {
                return list.get(collectionSize - 1);
            }
            return null;
        }

        public final <T> List<T> getNoneNullList(List<T> list) {
            return list == null ? new ArrayList() : list;
        }

        public final boolean hasItem(Collection<?> collection) {
            return collection != null && !collection.isEmpty();
        }

        public final boolean isListHasAllSameItems(List<?> list, List<?> list2) {
            if (!isSameSize(list, list2)) {
                return false;
            }
            int collectionSize = getCollectionSize(list);
            for (int i11 = 0; i11 < collectionSize; i11++) {
                Object obj = null;
                Object obj2 = list != null ? list.get(i11) : null;
                if (list2 != null) {
                    obj = list2.get(i11);
                }
                if (!equals(obj2, obj)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isSameSize(Collection<?> collection, Collection<?> collection2) {
            if (!hasItem(collection) && !hasItem(collection2)) {
                return true;
            }
            if (!hasItem(collection) || !hasItem(collection2)) {
                return false;
            }
            Integer num = null;
            Integer valueOf = collection != null ? Integer.valueOf(collection.size()) : null;
            if (collection2 != null) {
                num = Integer.valueOf(collection2.size());
            }
            return x.b(valueOf, num);
        }

        public final <T> T safeGetListItem(int i11, List<T> list) {
            if (getCollectionSize(list) <= i11 || i11 < 0) {
                return null;
            }
            return list.get(i11);
        }

        public final <T> List<T> subList(List<T> list, int i11, int i12) {
            ArrayList arrayList = new ArrayList();
            if (list.size() <= i12) {
                arrayList.addAll(list);
            } else {
                arrayList.addAll(list.subList(i11, i12));
            }
            return arrayList;
        }

        public final List<String> toUpperCase(List<String> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String upperCase : list) {
                arrayList.add(upperCase.toUpperCase());
            }
            return arrayList;
        }
    }
}
