package wx;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.opensource.svgaplayer.bitmap.SVGABitmapDecoder;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lwx/c;", "Lcom/opensource/svgaplayer/bitmap/SVGABitmapDecoder;", "", "data", "Landroid/graphics/BitmapFactory$Options;", "ops", "Landroid/graphics/Bitmap;", "c", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class c extends SVGABitmapDecoder<String> {

    /* renamed from: a  reason: collision with root package name */
    public static final c f29378a = new c();

    /* renamed from: c */
    public Bitmap b(String str, BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }
}
