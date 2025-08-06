package g6;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import com.hbg.lib.common.BaseApplication;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.c;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import i6.d;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<DisplayImageOptions> f68158a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f68159a = new b((a) null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b c() {
        return a.f68159a;
    }

    public final DisplayImageOptions a(int i11) {
        int d11 = (i11 * 10) + d();
        DisplayImageOptions displayImageOptions = this.f68158a.get(d11);
        if (displayImageOptions != null) {
            return displayImageOptions;
        }
        DisplayImageOptions u11 = b(i11).u();
        this.f68158a.put(d11, u11);
        return u11;
    }

    public final DisplayImageOptions.Builder b(int i11) {
        DisplayImageOptions.Builder w11 = new DisplayImageOptions.Builder().A(true).w(true);
        if (i11 != -1) {
            w11.F(i11);
            w11.D(i11);
            w11.B(i11);
        }
        int d11 = d();
        if (d11 == 1) {
            w11.z(ImageScaleType.EXACTLY).t(Bitmap.Config.RGB_565);
        } else if (d11 == 2) {
            w11.v(true).z(ImageScaleType.IN_SAMPLE_POWER_OF_2).t(Bitmap.Config.RGB_565);
        } else if (d11 == 3) {
            w11.v(true).z(ImageScaleType.IN_SAMPLE_INT).t(Bitmap.Config.ARGB_8888);
        }
        return w11;
    }

    public int d() {
        ActivityManager activityManager = (ActivityManager) BaseApplication.b().getSystemService("activity");
        int memoryClass = activityManager.getMemoryClass();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j11 = (long) ((((float) memoryInfo.availMem) / 1024.0f) / 1024.0f);
        int i11 = (((((float) memoryClass) * 1.0f) / ((float) j11)) > 0.5f ? 1 : (((((float) memoryClass) * 1.0f) / ((float) j11)) == 0.5f ? 0 : -1));
        if (i11 <= 0 || j11 >= 512 || memoryClass >= 96) {
            return (i11 > 0 || j11 <= 512 || memoryClass <= 96) ? 2 : 3;
        }
        d.n("low memory!");
        return 1;
    }

    public DisplayImageOptions e(int i11) {
        DisplayImageOptions.Builder b11 = b(i11);
        b11.y(new qx.b(Integer.MAX_VALUE));
        return b11.u();
    }

    public DisplayImageOptions f(int i11, int i12) {
        DisplayImageOptions.Builder b11 = b(i11);
        b11.y(new qx.b(i12));
        return b11.u();
    }

    public void g() {
        if (!com.nostra13.universalimageloader.core.b.g().j()) {
            c.b C = new c.b(BaseApplication.b()).w(new HashCodeFileNameGenerator()).C(QueueProcessingType.FIFO);
            com.nostra13.universalimageloader.core.download.a aVar = new com.nostra13.universalimageloader.core.download.a(BaseApplication.b(), 10000, 10000);
            int d11 = d();
            if (d11 == 1) {
                C.E(1).D(2).y(aVar).x(31457280).v(100).u(TXVodDownloadDataSource.QUALITY_480P, 320, (ux.a) null);
            } else if (d11 == 2) {
                C.E(3).D(2).y(aVar).A(2097152).x(31457280).v(100);
            } else if (d11 == 3) {
                C.E(5).D(3).y(aVar).A((int) (Runtime.getRuntime().maxMemory() / 8)).B(20).x(52428800).v(150);
            }
            com.nostra13.universalimageloader.core.b.g().i(C.t());
            com.nostra13.universalimageloader.core.b.g().h(true);
        }
    }

    public void h(ImageView imageView, String str) {
        j(imageView, str, -1, a(-1), (tx.a) null);
    }

    public void i(ImageView imageView, String str, int i11) {
        j(imageView, str, i11, a(i11), (tx.a) null);
    }

    public void j(ImageView imageView, String str, int i11, DisplayImageOptions displayImageOptions, tx.a aVar) {
        if (imageView != null) {
            g();
            if (displayImageOptions == null) {
                displayImageOptions = a(i11);
            }
            sx.b bVar = new sx.b(imageView, false);
            if (aVar == null) {
                com.nostra13.universalimageloader.core.b.g().c(str, bVar, displayImageOptions);
            } else {
                com.nostra13.universalimageloader.core.b.g().e(str, bVar, displayImageOptions, aVar);
            }
        }
    }

    public void k(ImageView imageView, String str, int i11, tx.a aVar) {
        j(imageView, str, i11, a(i11), aVar);
    }

    public void l(String str, DisplayImageOptions displayImageOptions, tx.a aVar) {
        g();
        com.nostra13.universalimageloader.core.b.g().k(str, displayImageOptions, aVar);
    }

    public void m(String str, tx.a aVar) {
        g();
        com.nostra13.universalimageloader.core.b.g().m(str, aVar);
    }

    public b() {
        this.f68158a = new SparseArray<>();
    }
}
