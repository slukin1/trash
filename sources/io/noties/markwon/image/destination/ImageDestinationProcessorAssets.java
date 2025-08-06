package io.noties.markwon.image.destination;

import android.net.Uri;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.ImageSource;
import zz.a;

public class ImageDestinationProcessorAssets extends ImageDestinationProcessor {

    /* renamed from: a  reason: collision with root package name */
    public final a f55410a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageDestinationProcessor f55411b;

    public ImageDestinationProcessorAssets() {
        this((ImageDestinationProcessor) null);
    }

    public String b(String str) {
        if (TextUtils.isEmpty(Uri.parse(str).getScheme())) {
            return this.f55410a.b(str).replace("https://android.asset/", ImageSource.ASSET_SCHEME);
        }
        ImageDestinationProcessor imageDestinationProcessor = this.f55411b;
        return imageDestinationProcessor != null ? imageDestinationProcessor.b(str) : str;
    }

    public ImageDestinationProcessorAssets(ImageDestinationProcessor imageDestinationProcessor) {
        this.f55410a = new a("https://android.asset/");
        this.f55411b = imageDestinationProcessor;
    }
}
