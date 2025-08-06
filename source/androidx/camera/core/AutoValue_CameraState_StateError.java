package androidx.camera.core;

import androidx.camera.core.CameraState;

final class AutoValue_CameraState_StateError extends CameraState.StateError {
    private final Throwable cause;
    private final int code;

    public AutoValue_CameraState_StateError(int i11, Throwable th2) {
        this.code = i11;
        this.cause = th2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraState.StateError)) {
            return false;
        }
        CameraState.StateError stateError = (CameraState.StateError) obj;
        if (this.code == stateError.getCode()) {
            Throwable th2 = this.cause;
            if (th2 == null) {
                if (stateError.getCause() == null) {
                    return true;
                }
            } else if (th2.equals(stateError.getCause())) {
                return true;
            }
        }
        return false;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public int getCode() {
        return this.code;
    }

    public int hashCode() {
        int i11 = (this.code ^ 1000003) * 1000003;
        Throwable th2 = this.cause;
        return i11 ^ (th2 == null ? 0 : th2.hashCode());
    }

    public String toString() {
        return "StateError{code=" + this.code + ", cause=" + this.cause + "}";
    }
}
