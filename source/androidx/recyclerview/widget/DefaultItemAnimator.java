package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.h0;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    public ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList<>();
    public ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList<>();
    public ArrayList<ArrayList<i>> mChangesList = new ArrayList<>();
    public ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList<>();
    public ArrayList<ArrayList<j>> mMovesList = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList<>();
    private ArrayList<i> mPendingChanges = new ArrayList<>();
    private ArrayList<j> mPendingMoves = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList<>();
    public ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList<>();

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f10536b;

        public a(ArrayList arrayList) {
            this.f10536b = arrayList;
        }

        public void run() {
            Iterator it2 = this.f10536b.iterator();
            while (it2.hasNext()) {
                j jVar = (j) it2.next();
                DefaultItemAnimator.this.animateMoveImpl(jVar.f10570a, jVar.f10571b, jVar.f10572c, jVar.f10573d, jVar.f10574e);
            }
            this.f10536b.clear();
            DefaultItemAnimator.this.mMovesList.remove(this.f10536b);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f10538b;

        public b(ArrayList arrayList) {
            this.f10538b = arrayList;
        }

        public void run() {
            Iterator it2 = this.f10538b.iterator();
            while (it2.hasNext()) {
                DefaultItemAnimator.this.animateChangeImpl((i) it2.next());
            }
            this.f10538b.clear();
            DefaultItemAnimator.this.mChangesList.remove(this.f10538b);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f10540b;

        public c(ArrayList arrayList) {
            this.f10540b = arrayList;
        }

        public void run() {
            Iterator it2 = this.f10540b.iterator();
            while (it2.hasNext()) {
                DefaultItemAnimator.this.animateAddImpl((RecyclerView.ViewHolder) it2.next());
            }
            this.f10540b.clear();
            DefaultItemAnimator.this.mAdditionsList.remove(this.f10540b);
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f10542b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f10543c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f10544d;

        public d(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f10542b = viewHolder;
            this.f10543c = viewPropertyAnimator;
            this.f10544d = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f10543c.setListener((Animator.AnimatorListener) null);
            this.f10544d.setAlpha(1.0f);
            DefaultItemAnimator.this.dispatchRemoveFinished(this.f10542b);
            DefaultItemAnimator.this.mRemoveAnimations.remove(this.f10542b);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchRemoveStarting(this.f10542b);
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f10546b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f10547c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f10548d;

        public e(RecyclerView.ViewHolder viewHolder, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f10546b = viewHolder;
            this.f10547c = view;
            this.f10548d = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            this.f10547c.setAlpha(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            this.f10548d.setListener((Animator.AnimatorListener) null);
            DefaultItemAnimator.this.dispatchAddFinished(this.f10546b);
            DefaultItemAnimator.this.mAddAnimations.remove(this.f10546b);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchAddStarting(this.f10546b);
        }
    }

    public class f extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f10550b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f10551c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f10552d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f10553e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f10554f;

        public f(RecyclerView.ViewHolder viewHolder, int i11, View view, int i12, ViewPropertyAnimator viewPropertyAnimator) {
            this.f10550b = viewHolder;
            this.f10551c = i11;
            this.f10552d = view;
            this.f10553e = i12;
            this.f10554f = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f10551c != 0) {
                this.f10552d.setTranslationX(0.0f);
            }
            if (this.f10553e != 0) {
                this.f10552d.setTranslationY(0.0f);
            }
        }

        public void onAnimationEnd(Animator animator) {
            this.f10554f.setListener((Animator.AnimatorListener) null);
            DefaultItemAnimator.this.dispatchMoveFinished(this.f10550b);
            DefaultItemAnimator.this.mMoveAnimations.remove(this.f10550b);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchMoveStarting(this.f10550b);
        }
    }

    public class g extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f10556b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f10557c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f10558d;

        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f10556b = iVar;
            this.f10557c = viewPropertyAnimator;
            this.f10558d = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f10557c.setListener((Animator.AnimatorListener) null);
            this.f10558d.setAlpha(1.0f);
            this.f10558d.setTranslationX(0.0f);
            this.f10558d.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.f10556b.f10564a, true);
            DefaultItemAnimator.this.mChangeAnimations.remove(this.f10556b.f10564a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.f10556b.f10564a, true);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f10560b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f10561c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f10562d;

        public h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f10560b = iVar;
            this.f10561c = viewPropertyAnimator;
            this.f10562d = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f10561c.setListener((Animator.AnimatorListener) null);
            this.f10562d.setAlpha(1.0f);
            this.f10562d.setTranslationX(0.0f);
            this.f10562d.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.f10560b.f10565b, false);
            DefaultItemAnimator.this.mChangeAnimations.remove(this.f10560b.f10565b);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.f10560b.f10565b, false);
        }
    }

    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.ViewHolder f10570a;

        /* renamed from: b  reason: collision with root package name */
        public int f10571b;

        /* renamed from: c  reason: collision with root package name */
        public int f10572c;

        /* renamed from: d  reason: collision with root package name */
        public int f10573d;

        /* renamed from: e  reason: collision with root package name */
        public int f10574e;

        public j(RecyclerView.ViewHolder viewHolder, int i11, int i12, int i13, int i14) {
            this.f10570a = viewHolder;
            this.f10571b = i11;
            this.f10572c = i12;
            this.f10573d = i13;
            this.f10574e = i14;
        }
    }

    private void animateRemoveImpl(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.mRemoveAnimations.add(viewHolder);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new d(viewHolder, animate, view)).start();
    }

    private void endChangeAnimation(List<i> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (endChangeAnimationIfNecessary(iVar, viewHolder) && iVar.f10564a == null && iVar.f10565b == null) {
                list.remove(iVar);
            }
        }
    }

    private void endChangeAnimationIfNecessary(i iVar) {
        RecyclerView.ViewHolder viewHolder = iVar.f10564a;
        if (viewHolder != null) {
            endChangeAnimationIfNecessary(iVar, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = iVar.f10565b;
        if (viewHolder2 != null) {
            endChangeAnimationIfNecessary(iVar, viewHolder2);
        }
    }

    private void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(viewHolder);
        return true;
    }

    public void animateAddImpl(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.mAddAnimations.add(viewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new e(viewHolder, view, animate)).start();
    }

    @SuppressLint({"UnknownNullness"})
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i11, int i12, int i13, int i14) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i11, i12, i13, i14);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        resetAnimation(viewHolder);
        int i15 = (int) (((float) (i13 - i11)) - translationX);
        int i16 = (int) (((float) (i14 - i12)) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            resetAnimation(viewHolder2);
            viewHolder2.itemView.setTranslationX((float) (-i15));
            viewHolder2.itemView.setTranslationY((float) (-i16));
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new i(viewHolder, viewHolder2, i11, i12, i13, i14));
        return true;
    }

    public void animateChangeImpl(i iVar) {
        View view;
        RecyclerView.ViewHolder viewHolder = iVar.f10564a;
        View view2 = null;
        if (viewHolder == null) {
            view = null;
        } else {
            view = viewHolder.itemView;
        }
        RecyclerView.ViewHolder viewHolder2 = iVar.f10565b;
        if (viewHolder2 != null) {
            view2 = viewHolder2.itemView;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(iVar.f10564a);
            duration.translationX((float) (iVar.f10568e - iVar.f10566c));
            duration.translationY((float) (iVar.f10569f - iVar.f10567d));
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.mChangeAnimations.add(iVar.f10565b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i11, int i12, int i13, int i14) {
        View view = viewHolder.itemView;
        int translationX = i11 + ((int) view.getTranslationX());
        int translationY = i12 + ((int) viewHolder.itemView.getTranslationY());
        resetAnimation(viewHolder);
        int i15 = i13 - translationX;
        int i16 = i14 - translationY;
        if (i15 == 0 && i16 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i15 != 0) {
            view.setTranslationX((float) (-i15));
        }
        if (i16 != 0) {
            view.setTranslationY((float) (-i16));
        }
        this.mPendingMoves.add(new j(viewHolder, translationX, translationY, i13, i14));
        return true;
    }

    public void animateMoveImpl(RecyclerView.ViewHolder viewHolder, int i11, int i12, int i13, int i14) {
        View view = viewHolder.itemView;
        int i15 = i13 - i11;
        int i16 = i14 - i12;
        if (i15 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i16 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.mMoveAnimations.add(viewHolder);
        animate.setDuration(getMoveDuration()).setListener(new f(viewHolder, i15, view, i16, animate)).start();
    }

    @SuppressLint({"UnknownNullness"})
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        this.mPendingRemovals.add(viewHolder);
        return true;
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list);
    }

    public void cancelAll(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    public void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.mPendingMoves.get(size).f10570a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(viewHolder);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, viewHolder);
        if (this.mPendingRemovals.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.mPendingAdditions.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.mChangesList.get(size2);
            endChangeAnimation(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size2);
            }
        }
        for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.mMovesList.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((j) arrayList2.get(size4)).f10570a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.mMovesList.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.mAdditionsList.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(viewHolder);
        this.mAddAnimations.remove(viewHolder);
        this.mChangeAnimations.remove(viewHolder);
        this.mMoveAnimations.remove(viewHolder);
        dispatchFinishedWhenDone();
    }

    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.mPendingMoves.get(size);
            View view = jVar.f10570a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(jVar.f10570a);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(size2));
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.mPendingAdditions.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            endChangeAnimationIfNecessary(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.f10570a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(jVar2.f10570a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = (RecyclerView.ViewHolder) arrayList2.get(size8);
                    viewHolder2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    endChangeAnimationIfNecessary((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    public boolean isRunning() {
        return !this.mPendingAdditions.isEmpty() || !this.mPendingChanges.isEmpty() || !this.mPendingMoves.isEmpty() || !this.mPendingRemovals.isEmpty() || !this.mMoveAnimations.isEmpty() || !this.mRemoveAnimations.isEmpty() || !this.mAddAnimations.isEmpty() || !this.mChangeAnimations.isEmpty() || !this.mMovesList.isEmpty() || !this.mAdditionsList.isEmpty() || !this.mChangesList.isEmpty();
    }

    public void runPendingAnimations() {
        boolean z11 = !this.mPendingRemovals.isEmpty();
        boolean z12 = !this.mPendingMoves.isEmpty();
        boolean z13 = !this.mPendingChanges.isEmpty();
        boolean z14 = !this.mPendingAdditions.isEmpty();
        if (z11 || z12 || z14 || z13) {
            Iterator<RecyclerView.ViewHolder> it2 = this.mPendingRemovals.iterator();
            while (it2.hasNext()) {
                animateRemoveImpl(it2.next());
            }
            this.mPendingRemovals.clear();
            if (z12) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                a aVar = new a(arrayList);
                if (z11) {
                    h0.q0(((j) arrayList.get(0)).f10570a.itemView, aVar, getRemoveDuration());
                } else {
                    aVar.run();
                }
            }
            if (z13) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList2);
                this.mPendingChanges.clear();
                b bVar = new b(arrayList2);
                if (z11) {
                    h0.q0(((i) arrayList2.get(0)).f10564a.itemView, bVar, getRemoveDuration());
                } else {
                    bVar.run();
                }
            }
            if (z14) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList3);
                this.mPendingAdditions.clear();
                c cVar = new c(arrayList3);
                if (z11 || z12 || z13) {
                    long j11 = 0;
                    long removeDuration = z11 ? getRemoveDuration() : 0;
                    long moveDuration = z12 ? getMoveDuration() : 0;
                    if (z13) {
                        j11 = getChangeDuration();
                    }
                    h0.q0(((RecyclerView.ViewHolder) arrayList3.get(0)).itemView, cVar, removeDuration + Math.max(moveDuration, j11));
                    return;
                }
                cVar.run();
            }
        }
    }

    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.ViewHolder f10564a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.ViewHolder f10565b;

        /* renamed from: c  reason: collision with root package name */
        public int f10566c;

        /* renamed from: d  reason: collision with root package name */
        public int f10567d;

        /* renamed from: e  reason: collision with root package name */
        public int f10568e;

        /* renamed from: f  reason: collision with root package name */
        public int f10569f;

        public i(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.f10564a = viewHolder;
            this.f10565b = viewHolder2;
        }

        @SuppressLint({"UnknownNullness"})
        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f10564a + ", newHolder=" + this.f10565b + ", fromX=" + this.f10566c + ", fromY=" + this.f10567d + ", toX=" + this.f10568e + ", toY=" + this.f10569f + '}';
        }

        public i(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i11, int i12, int i13, int i14) {
            this(viewHolder, viewHolder2);
            this.f10566c = i11;
            this.f10567d = i12;
            this.f10568e = i13;
            this.f10569f = i14;
        }
    }

    private boolean endChangeAnimationIfNecessary(i iVar, RecyclerView.ViewHolder viewHolder) {
        boolean z11 = false;
        if (iVar.f10565b == viewHolder) {
            iVar.f10565b = null;
        } else if (iVar.f10564a != viewHolder) {
            return false;
        } else {
            iVar.f10564a = null;
            z11 = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(viewHolder, z11);
        return true;
    }
}
