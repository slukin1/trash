package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.coroutines.c;
import kotlin.sequences.g;

public final class ViewGroupKt {

    public static final class a implements g<View> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f8491a;

        public a(ViewGroup viewGroup) {
            this.f8491a = viewGroup;
        }

        public Iterator<View> iterator() {
            return ViewGroupKt.c(this.f8491a);
        }
    }

    public static final class b implements Iterator<View>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public int f8492b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f8493c;

        public b(ViewGroup viewGroup) {
            this.f8493c = viewGroup;
        }

        /* renamed from: a */
        public View next() {
            ViewGroup viewGroup = this.f8493c;
            int i11 = this.f8492b;
            this.f8492b = i11 + 1;
            View childAt = viewGroup.getChildAt(i11);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }

        public boolean hasNext() {
            return this.f8492b < this.f8493c.getChildCount();
        }

        public void remove() {
            ViewGroup viewGroup = this.f8493c;
            int i11 = this.f8492b - 1;
            this.f8492b = i11;
            viewGroup.removeViewAt(i11);
        }
    }

    public static final g<View> a(ViewGroup viewGroup) {
        return new a(viewGroup);
    }

    public static final g<View> b(ViewGroup viewGroup) {
        return SequencesKt__SequenceBuilderKt.b(new ViewGroupKt$descendants$1(viewGroup, (c<? super ViewGroupKt$descendants$1>) null));
    }

    public static final Iterator<View> c(ViewGroup viewGroup) {
        return new b(viewGroup);
    }
}
