package android.support.v4.media.session;

import android.media.session.MediaSession;

class MediaSessionCompatApi22 {
    private MediaSessionCompatApi22() {
    }

    public static void setRatingType(Object obj, int i11) {
        ((MediaSession) obj).setRatingType(i11);
    }
}
