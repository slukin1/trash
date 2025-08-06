package z;

import android.media.MediaMuxer;
import java.io.FileDescriptor;
import java.io.IOException;

public final class c {
    public static MediaMuxer a(FileDescriptor fileDescriptor, int i11) throws IOException {
        return new MediaMuxer(fileDescriptor, i11);
    }
}
