package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

@KeepForSdk
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    private boolean zaa = false;
    private ArrayList<Integer> zab;

    @KeepForSdk
    public EntityBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    private final void zab() {
        synchronized (this) {
            if (!this.zaa) {
                int count = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                ArrayList<Integer> arrayList = new ArrayList<>();
                this.zab = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String string = this.mDataHolder.getString(primaryDataMarkerColumn, 0, this.mDataHolder.getWindowIndex(0));
                    int i11 = 1;
                    while (i11 < count) {
                        int windowIndex = this.mDataHolder.getWindowIndex(i11);
                        String string2 = this.mDataHolder.getString(primaryDataMarkerColumn, i11, windowIndex);
                        if (string2 != null) {
                            if (!string2.equals(string)) {
                                this.zab.add(Integer.valueOf(i11));
                                string = string2;
                            }
                            i11++;
                        } else {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(primaryDataMarkerColumn).length() + 78);
                            sb2.append("Missing value for markerColumn: ");
                            sb2.append(primaryDataMarkerColumn);
                            sb2.append(", at row: ");
                            sb2.append(i11);
                            sb2.append(", for window: ");
                            sb2.append(windowIndex);
                            throw new NullPointerException(sb2.toString());
                        }
                    }
                }
                this.zaa = true;
            }
        }
    }

    @KeepForSdk
    public final T get(int i11) {
        int i12;
        int i13;
        zab();
        int zaa2 = zaa(i11);
        int i14 = 0;
        if (i11 >= 0 && i11 != this.zab.size()) {
            if (i11 == this.zab.size() - 1) {
                i13 = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                i12 = this.zab.get(i11).intValue();
            } else {
                i13 = this.zab.get(i11 + 1).intValue();
                i12 = this.zab.get(i11).intValue();
            }
            int i15 = i13 - i12;
            if (i15 == 1) {
                int zaa3 = zaa(i11);
                int windowIndex = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getWindowIndex(zaa3);
                String childDataMarkerColumn = getChildDataMarkerColumn();
                if (childDataMarkerColumn == null || this.mDataHolder.getString(childDataMarkerColumn, zaa3, windowIndex) != null) {
                    i14 = 1;
                }
            } else {
                i14 = i15;
            }
        }
        return getEntry(zaa2, i14);
    }

    @KeepForSdk
    public String getChildDataMarkerColumn() {
        return null;
    }

    @KeepForSdk
    public int getCount() {
        zab();
        return this.zab.size();
    }

    @KeepForSdk
    public abstract T getEntry(int i11, int i12);

    @KeepForSdk
    public abstract String getPrimaryDataMarkerColumn();

    public final int zaa(int i11) {
        if (i11 >= 0 && i11 < this.zab.size()) {
            return this.zab.get(i11).intValue();
        }
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("Position ");
        sb2.append(i11);
        sb2.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb2.toString());
    }
}
