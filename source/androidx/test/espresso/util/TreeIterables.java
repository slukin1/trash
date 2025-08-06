package androidx.test.espresso.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.test.espresso.core.internal.deps.guava.base.Function;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.AbstractIterator;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.core.internal.deps.guava.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class TreeIterables {

    /* renamed from: a  reason: collision with root package name */
    public static final TreeViewer<View> f11371a = new ViewTreeViewer();

    public static class DistanceRecordingTreeViewer<T> implements TreeViewer<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f11373a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<T, Integer> f11374b = Maps.b();

        /* renamed from: c  reason: collision with root package name */
        public final TreeViewer<T> f11375c;

        public DistanceRecordingTreeViewer(T t11, TreeViewer<T> treeViewer) {
            this.f11373a = Preconditions.i(t11);
            this.f11375c = (TreeViewer) Preconditions.i(treeViewer);
        }

        public Collection<T> a(T t11) {
            if (t11 == this.f11373a) {
                this.f11374b.put(t11, 0);
            }
            int b11 = b(t11) + 1;
            Collection<T> a11 = this.f11375c.a(t11);
            for (T put : a11) {
                this.f11374b.put(put, Integer.valueOf(b11));
            }
            return a11;
        }

        public int b(T t11) {
            return ((Integer) Preconditions.k(this.f11374b.get(t11), "Never seen %s before", t11)).intValue();
        }
    }

    public enum TraversalStrategy {
        BREADTH_FIRST {
            public <T> void combineNewChildren(LinkedList<T> linkedList, Collection<T> collection) {
                linkedList.addAll(collection);
            }
        },
        DEPTH_FIRST {
            public <T> void combineNewChildren(LinkedList<T> linkedList, Collection<T> collection) {
                linkedList.addAll(0, collection);
            }
        };

        public abstract <T> void combineNewChildren(LinkedList<T> linkedList, Collection<T> collection);

        public <T> T next(LinkedList<T> linkedList) {
            return linkedList.removeFirst();
        }
    }

    public static class TreeTraversalIterable<T> implements Iterable<T> {

        /* renamed from: b  reason: collision with root package name */
        public final T f11376b;

        /* renamed from: c  reason: collision with root package name */
        public final TraversalStrategy f11377c;

        /* renamed from: d  reason: collision with root package name */
        public final TreeViewer<T> f11378d;

        public Iterator<T> iterator() {
            final LinkedList k11 = Lists.k();
            k11.add(this.f11376b);
            return new AbstractIterator<T>() {
                public T a() {
                    if (k11.isEmpty()) {
                        return b();
                    }
                    T j11 = Preconditions.j(TreeTraversalIterable.this.f11377c.next(k11), "Null items not allowed!");
                    TreeTraversalIterable.this.f11377c.combineNewChildren(k11, TreeTraversalIterable.this.f11378d.a(j11));
                    return j11;
                }
            };
        }

        public TreeTraversalIterable(T t11, TraversalStrategy traversalStrategy, TreeViewer<T> treeViewer) {
            this.f11376b = Preconditions.i(t11);
            this.f11377c = (TraversalStrategy) Preconditions.i(traversalStrategy);
            this.f11378d = (TreeViewer) Preconditions.i(treeViewer);
        }
    }

    public interface TreeViewer<T> {
        Collection<T> a(T t11);
    }

    public static class ViewAndDistance {

        /* renamed from: a  reason: collision with root package name */
        public final View f11381a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11382b;

        public int a() {
            return this.f11382b;
        }

        public View b() {
            return this.f11381a;
        }

        public ViewAndDistance(View view, int i11) {
            this.f11381a = view;
            this.f11382b = i11;
        }
    }

    public static class ViewTreeViewer implements TreeViewer<View> {
        /* renamed from: b */
        public Collection<View> a(View view) {
            Preconditions.i(view);
            if (!(view instanceof ViewGroup)) {
                return Collections.emptyList();
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            ArrayList g11 = Lists.g();
            for (int i11 = 0; i11 < childCount; i11++) {
                g11.add(viewGroup.getChildAt(i11));
            }
            return g11;
        }
    }

    public static <T> Iterable<T> a(T t11, TreeViewer<T> treeViewer) {
        Preconditions.i(t11);
        Preconditions.i(treeViewer);
        return new TreeTraversalIterable(t11, TraversalStrategy.DEPTH_FIRST, treeViewer);
    }

    public static Iterable<ViewAndDistance> b(View view) {
        final DistanceRecordingTreeViewer distanceRecordingTreeViewer = new DistanceRecordingTreeViewer(view, f11371a);
        return Iterables.d(a(view, distanceRecordingTreeViewer), new Function<View, ViewAndDistance>() {
            /* renamed from: a */
            public ViewAndDistance apply(View view) {
                return new ViewAndDistance(view, DistanceRecordingTreeViewer.this.b(view));
            }
        });
    }
}
