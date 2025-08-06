package ia;

import android.view.View;
import com.hbg.lib.widgets.photoviewer.PhotoViewFragment;
import com.hbg.lib.widgets.photoviewer.data.ImageData;

public final /* synthetic */ class g implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PhotoViewFragment f55032b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageData f55033c;

    public /* synthetic */ g(PhotoViewFragment photoViewFragment, ImageData imageData) {
        this.f55032b = photoViewFragment;
        this.f55033c = imageData;
    }

    public final boolean onLongClick(View view) {
        return this.f55032b.sh(this.f55033c, view);
    }
}
