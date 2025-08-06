package z;

import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;

public final class b {
    public static int a(AudioRecordingConfiguration audioRecordingConfiguration) {
        return audioRecordingConfiguration.getClientAudioSessionId();
    }

    public static int b(AudioRecord audioRecord, AudioTimestamp audioTimestamp, int i11) {
        return audioRecord.getTimestamp(audioTimestamp, i11);
    }
}
