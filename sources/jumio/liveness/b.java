package jumio.liveness;

import kotlin.NoWhenBranchMatchedException;

public enum b {
    NO_FACE,
    CENTER_FACE,
    FACE_TOO_CLOSE,
    MOVE_FACE_CLOSER,
    LEVEL_EYES_AND_DEVICE,
    HOLD_STILL;

    public final String toString() {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return "noFace";
        }
        if (ordinal == 1) {
            return "centerFace";
        }
        if (ordinal == 2) {
            return "faceTooClose";
        }
        if (ordinal == 3) {
            return "moveFaceCloser";
        }
        if (ordinal == 4) {
            return "levelEyesAndDevice";
        }
        if (ordinal == 5) {
            return "holdStill";
        }
        throw new NoWhenBranchMatchedException();
    }
}
