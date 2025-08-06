package androidx.camera.core;

import androidx.core.util.h;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class FocusMeteringAction {
    public static final long DEFAULT_AUTOCANCEL_DURATION = 5000;
    public static final int DEFAULT_METERING_MODE = 7;
    public static final int FLAG_AE = 2;
    public static final int FLAG_AF = 1;
    public static final int FLAG_AWB = 4;
    private final long mAutoCancelDurationInMillis;
    private final List<MeteringPoint> mMeteringPointsAe;
    private final List<MeteringPoint> mMeteringPointsAf;
    private final List<MeteringPoint> mMeteringPointsAwb;

    public static class Builder {
        public long mAutoCancelDurationInMillis;
        public final List<MeteringPoint> mMeteringPointsAe;
        public final List<MeteringPoint> mMeteringPointsAf;
        public final List<MeteringPoint> mMeteringPointsAwb;

        public Builder(MeteringPoint meteringPoint) {
            this(meteringPoint, 7);
        }

        public Builder addPoint(MeteringPoint meteringPoint) {
            return addPoint(meteringPoint, 7);
        }

        public FocusMeteringAction build() {
            return new FocusMeteringAction(this);
        }

        public Builder disableAutoCancel() {
            this.mAutoCancelDurationInMillis = 0;
            return this;
        }

        public Builder removePoints(int i11) {
            if ((i11 & 1) != 0) {
                this.mMeteringPointsAf.clear();
            }
            if ((i11 & 2) != 0) {
                this.mMeteringPointsAe.clear();
            }
            if ((i11 & 4) != 0) {
                this.mMeteringPointsAwb.clear();
            }
            return this;
        }

        public Builder setAutoCancelDuration(long j11, TimeUnit timeUnit) {
            h.b(j11 >= 1, "autoCancelDuration must be at least 1");
            this.mAutoCancelDurationInMillis = timeUnit.toMillis(j11);
            return this;
        }

        public Builder(MeteringPoint meteringPoint, int i11) {
            this.mMeteringPointsAf = new ArrayList();
            this.mMeteringPointsAe = new ArrayList();
            this.mMeteringPointsAwb = new ArrayList();
            this.mAutoCancelDurationInMillis = 5000;
            addPoint(meteringPoint, i11);
        }

        public Builder addPoint(MeteringPoint meteringPoint, int i11) {
            boolean z11 = false;
            h.b(meteringPoint != null, "Point cannot be null.");
            if (i11 >= 1 && i11 <= 7) {
                z11 = true;
            }
            h.b(z11, "Invalid metering mode " + i11);
            if ((i11 & 1) != 0) {
                this.mMeteringPointsAf.add(meteringPoint);
            }
            if ((i11 & 2) != 0) {
                this.mMeteringPointsAe.add(meteringPoint);
            }
            if ((i11 & 4) != 0) {
                this.mMeteringPointsAwb.add(meteringPoint);
            }
            return this;
        }

        public Builder(FocusMeteringAction focusMeteringAction) {
            ArrayList arrayList = new ArrayList();
            this.mMeteringPointsAf = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.mMeteringPointsAe = arrayList2;
            ArrayList arrayList3 = new ArrayList();
            this.mMeteringPointsAwb = arrayList3;
            this.mAutoCancelDurationInMillis = 5000;
            arrayList.addAll(focusMeteringAction.getMeteringPointsAf());
            arrayList2.addAll(focusMeteringAction.getMeteringPointsAe());
            arrayList3.addAll(focusMeteringAction.getMeteringPointsAwb());
            this.mAutoCancelDurationInMillis = focusMeteringAction.getAutoCancelDurationInMillis();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MeteringMode {
    }

    public FocusMeteringAction(Builder builder) {
        this.mMeteringPointsAf = Collections.unmodifiableList(builder.mMeteringPointsAf);
        this.mMeteringPointsAe = Collections.unmodifiableList(builder.mMeteringPointsAe);
        this.mMeteringPointsAwb = Collections.unmodifiableList(builder.mMeteringPointsAwb);
        this.mAutoCancelDurationInMillis = builder.mAutoCancelDurationInMillis;
    }

    public long getAutoCancelDurationInMillis() {
        return this.mAutoCancelDurationInMillis;
    }

    public List<MeteringPoint> getMeteringPointsAe() {
        return this.mMeteringPointsAe;
    }

    public List<MeteringPoint> getMeteringPointsAf() {
        return this.mMeteringPointsAf;
    }

    public List<MeteringPoint> getMeteringPointsAwb() {
        return this.mMeteringPointsAwb;
    }

    public boolean isAutoCancelEnabled() {
        return this.mAutoCancelDurationInMillis > 0;
    }
}
