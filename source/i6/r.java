package i6;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class r {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<WeakReference<View>> f68191a;

    /* renamed from: b  reason: collision with root package name */
    public final a f68192b;

    public interface a {
        View findViewById(int i11);
    }

    public static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public final View f68193a;

        public b(View view) {
            this.f68193a = view;
        }

        public View findViewById(int i11) {
            return this.f68193a.findViewById(i11);
        }
    }

    public static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        public final Window f68194a;

        public c(Window window) {
            this.f68194a = window;
        }

        public View findViewById(int i11) {
            return this.f68194a.findViewById(i11);
        }
    }

    public r(View view) {
        this.f68192b = new b(view);
        d();
    }

    public EditText a(int i11) {
        return (EditText) b(i11);
    }

    public <V extends View> V b(int i11) {
        if (this.f68191a.get(i11) != null) {
            return (View) this.f68191a.get(i11).get();
        }
        V findViewById = this.f68192b.findViewById(i11);
        if (findViewById != null) {
            this.f68191a.put(i11, new WeakReference(findViewById));
        }
        return findViewById;
    }

    public ImageView c(int i11) {
        return (ImageView) b(i11);
    }

    public final void d() {
        this.f68191a = new SparseArray<>();
    }

    public TextView e(int i11) {
        return (TextView) b(i11);
    }

    public r(Window window) {
        this.f68192b = new c(window);
        d();
    }

    public r(Activity activity) {
        this(activity.getWindow());
    }
}
