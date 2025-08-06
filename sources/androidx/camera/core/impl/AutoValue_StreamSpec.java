package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.StreamSpec;
import java.util.Objects;

final class AutoValue_StreamSpec extends StreamSpec {
    private final DynamicRange dynamicRange;
    private final Range<Integer> expectedFrameRateRange;
    private final Config implementationOptions;
    private final Size resolution;

    public static final class Builder extends StreamSpec.Builder {
        private DynamicRange dynamicRange;
        private Range<Integer> expectedFrameRateRange;
        private Config implementationOptions;
        private Size resolution;

        public StreamSpec build() {
            String str = "";
            if (this.resolution == null) {
                str = str + " resolution";
            }
            if (this.dynamicRange == null) {
                str = str + " dynamicRange";
            }
            if (this.expectedFrameRateRange == null) {
                str = str + " expectedFrameRateRange";
            }
            if (str.isEmpty()) {
                return new AutoValue_StreamSpec(this.resolution, this.dynamicRange, this.expectedFrameRateRange, this.implementationOptions);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public StreamSpec.Builder setDynamicRange(DynamicRange dynamicRange2) {
            Objects.requireNonNull(dynamicRange2, "Null dynamicRange");
            this.dynamicRange = dynamicRange2;
            return this;
        }

        public StreamSpec.Builder setExpectedFrameRateRange(Range<Integer> range) {
            Objects.requireNonNull(range, "Null expectedFrameRateRange");
            this.expectedFrameRateRange = range;
            return this;
        }

        public StreamSpec.Builder setImplementationOptions(Config config) {
            this.implementationOptions = config;
            return this;
        }

        public StreamSpec.Builder setResolution(Size size) {
            Objects.requireNonNull(size, "Null resolution");
            this.resolution = size;
            return this;
        }

        public Builder() {
        }

        private Builder(StreamSpec streamSpec) {
            this.resolution = streamSpec.getResolution();
            this.dynamicRange = streamSpec.getDynamicRange();
            this.expectedFrameRateRange = streamSpec.getExpectedFrameRateRange();
            this.implementationOptions = streamSpec.getImplementationOptions();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamSpec)) {
            return false;
        }
        StreamSpec streamSpec = (StreamSpec) obj;
        if (this.resolution.equals(streamSpec.getResolution()) && this.dynamicRange.equals(streamSpec.getDynamicRange()) && this.expectedFrameRateRange.equals(streamSpec.getExpectedFrameRateRange())) {
            Config config = this.implementationOptions;
            if (config == null) {
                if (streamSpec.getImplementationOptions() == null) {
                    return true;
                }
            } else if (config.equals(streamSpec.getImplementationOptions())) {
                return true;
            }
        }
        return false;
    }

    public DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    public Range<Integer> getExpectedFrameRateRange() {
        return this.expectedFrameRateRange;
    }

    public Config getImplementationOptions() {
        return this.implementationOptions;
    }

    public Size getResolution() {
        return this.resolution;
    }

    public int hashCode() {
        int hashCode = (((((this.resolution.hashCode() ^ 1000003) * 1000003) ^ this.dynamicRange.hashCode()) * 1000003) ^ this.expectedFrameRateRange.hashCode()) * 1000003;
        Config config = this.implementationOptions;
        return hashCode ^ (config == null ? 0 : config.hashCode());
    }

    public StreamSpec.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "StreamSpec{resolution=" + this.resolution + ", dynamicRange=" + this.dynamicRange + ", expectedFrameRateRange=" + this.expectedFrameRateRange + ", implementationOptions=" + this.implementationOptions + "}";
    }

    private AutoValue_StreamSpec(Size size, DynamicRange dynamicRange2, Range<Integer> range, Config config) {
        this.resolution = size;
        this.dynamicRange = dynamicRange2;
        this.expectedFrameRateRange = range;
        this.implementationOptions = config;
    }
}
