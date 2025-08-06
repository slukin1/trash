package t5;

import com.hbg.component.kline.render.buffer.DataBufferManager;
import java.lang.ref.SoftReference;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ a f29296b = new a();

    public final int compare(Object obj, Object obj2) {
        return DataBufferManager.c((SoftReference) obj, (SoftReference) obj2);
    }
}
