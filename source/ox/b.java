package ox;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b extends FilterInputStream {
    public b(InputStream inputStream) {
        super(inputStream);
    }

    public long skip(long j11) throws IOException {
        long j12 = 0;
        while (j12 < j11) {
            long skip = this.in.skip(j11 - j12);
            if (skip == 0) {
                if (read() < 0) {
                    break;
                }
                skip = 1;
            }
            j12 += skip;
        }
        return j12;
    }
}
