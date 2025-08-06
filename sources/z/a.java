package z;

import android.media.AudioFormat;
import android.media.AudioRecord;

public final class a {
    public static AudioRecord a(AudioRecord.Builder builder) {
        return builder.build();
    }

    public static AudioRecord.Builder b() {
        return new AudioRecord.Builder();
    }

    public static void c(AudioRecord.Builder builder, AudioFormat audioFormat) {
        builder.setAudioFormat(audioFormat);
    }

    public static void d(AudioRecord.Builder builder, int i11) {
        builder.setAudioSource(i11);
    }

    public static void e(AudioRecord.Builder builder, int i11) {
        builder.setBufferSizeInBytes(i11);
    }
}
