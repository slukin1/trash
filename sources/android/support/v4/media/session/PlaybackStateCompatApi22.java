package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

class PlaybackStateCompatApi22 {
    private PlaybackStateCompatApi22() {
    }

    public static Bundle getExtras(Object obj) {
        return ((PlaybackState) obj).getExtras();
    }

    public static Object newInstance(int i11, long j11, long j12, float f11, long j13, CharSequence charSequence, long j14, List<Object> list, long j15, Bundle bundle) {
        PlaybackState.Builder builder = new PlaybackState.Builder();
        builder.setState(i11, j11, f11, j14);
        long j16 = j12;
        builder.setBufferedPosition(j12);
        long j17 = j13;
        builder.setActions(j13);
        builder.setErrorMessage(charSequence);
        Iterator<Object> it2 = list.iterator();
        while (it2.hasNext()) {
            builder.addCustomAction((PlaybackState.CustomAction) it2.next());
        }
        builder.setActiveQueueItemId(j15);
        builder.setExtras(bundle);
        return builder.build();
    }
}
