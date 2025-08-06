package androidx.camera.core.impl;

import androidx.camera.core.impl.SurfaceConfig;
import java.util.Objects;

final class AutoValue_SurfaceConfig extends SurfaceConfig {
    private final SurfaceConfig.ConfigSize configSize;
    private final SurfaceConfig.ConfigType configType;
    private final long streamUseCase;

    public AutoValue_SurfaceConfig(SurfaceConfig.ConfigType configType2, SurfaceConfig.ConfigSize configSize2, long j11) {
        Objects.requireNonNull(configType2, "Null configType");
        this.configType = configType2;
        Objects.requireNonNull(configSize2, "Null configSize");
        this.configSize = configSize2;
        this.streamUseCase = j11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceConfig)) {
            return false;
        }
        SurfaceConfig surfaceConfig = (SurfaceConfig) obj;
        if (!this.configType.equals(surfaceConfig.getConfigType()) || !this.configSize.equals(surfaceConfig.getConfigSize()) || this.streamUseCase != surfaceConfig.getStreamUseCase()) {
            return false;
        }
        return true;
    }

    public SurfaceConfig.ConfigSize getConfigSize() {
        return this.configSize;
    }

    public SurfaceConfig.ConfigType getConfigType() {
        return this.configType;
    }

    public long getStreamUseCase() {
        return this.streamUseCase;
    }

    public int hashCode() {
        long j11 = this.streamUseCase;
        return ((((this.configType.hashCode() ^ 1000003) * 1000003) ^ this.configSize.hashCode()) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "SurfaceConfig{configType=" + this.configType + ", configSize=" + this.configSize + ", streamUseCase=" + this.streamUseCase + "}";
    }
}
