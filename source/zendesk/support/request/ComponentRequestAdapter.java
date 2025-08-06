package zendesk.support.request;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import c1.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mz.a;
import zendesk.support.request.CellType;
import zendesk.support.suas.Listener;
import zendesk.support.suas.State;
import zendesk.support.suas.StateSelector;

class ComponentRequestAdapter implements Listener<List<CellType.Base>> {
    private static final long UPDATE_TIME_WINDOW = 200;
    private final p listUpdateCallback;
    private final RecyclerView recyclerView;
    private final RequestAdapterSelector requestAdapterSelector;
    /* access modifiers changed from: private */
    public final List<CellType.Base> requestMessageList;
    private Runnable updateRunnable = null;

    public static class DiffCalculator extends DiffUtil.Callback {
        private final List<CellType.Base> newList;
        private final List<CellType.Base> oldList;

        public boolean areContentsTheSame(int i11, int i12) {
            return this.oldList.get(i11).areContentsTheSame(this.newList.get(i12));
        }

        public boolean areItemsTheSame(int i11, int i12) {
            return this.oldList.get(i11).getUniqueId() == this.newList.get(i12).getUniqueId();
        }

        public int getNewListSize() {
            return this.newList.size();
        }

        public int getOldListSize() {
            return this.oldList.size();
        }

        private DiffCalculator(List<CellType.Base> list, List<CellType.Base> list2) {
            this.oldList = list;
            this.newList = list2;
        }
    }

    public static class RequestAdapter extends RecyclerView.Adapter<RequestViewHolder> {
        private final ComponentRequestAdapter dataSource;
        private int lastPosition = -1;

        public RequestAdapter(ComponentRequestAdapter componentRequestAdapter) {
            setHasStableIds(true);
            this.dataSource = componentRequestAdapter;
        }

        public int getItemCount() {
            return this.dataSource.getMessageCount();
        }

        public long getItemId(int i11) {
            return this.dataSource.getMessageForPos(i11).getUniqueId();
        }

        public int getItemViewType(int i11) {
            return this.dataSource.getMessageForPos(i11).getLayoutId();
        }

        @SuppressLint({"RecyclerView"})
        public void onBindViewHolder(RequestViewHolder requestViewHolder, int i11) {
            this.dataSource.getMessageForPos(i11).bind(requestViewHolder);
            int i12 = this.lastPosition;
            if (i11 > i12 && i12 != -1) {
                this.lastPosition = i11;
                requestViewHolder.startAnimation();
            }
            if (this.lastPosition == -1) {
                this.lastPosition = i11;
            }
        }

        public RequestViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new RequestViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false));
        }

        public void onViewDetachedFromWindow(RequestViewHolder requestViewHolder) {
            super.onViewDetachedFromWindow(requestViewHolder);
            requestViewHolder.clearAnimation();
        }
    }

    public static class RequestAdapterSelector implements StateSelector<List<CellType.Base>> {
        private final CellFactory messageFactory;

        public RequestAdapterSelector(CellFactory cellFactory) {
            this.messageFactory = cellFactory;
        }

        public List<CellType.Base> selectData(State state) {
            StateConversation fromState = StateConversation.fromState(state);
            StateSettings settings = StateConfig.fromState(state).getSettings();
            return this.messageFactory.generateCells(fromState.getMessages(), fromState.getUsers(), fromState.getStatus(), settings.getSystemMessage());
        }
    }

    public static class RequestViewHolder extends RecyclerView.ViewHolder {
        private static final long ANIMATION_DURATION = 250;
        private static final float ANIMATION_HEIGHT_RATIO = 0.6666667f;
        private static final TimeInterpolator TIME_INTERPOLATOR = b.a(0.2f, 0.0f, 0.4f, 1.0f);
        private ValueAnimator animation;
        @SuppressLint({"UseSparseArrays"})
        private final Map<Integer, View> viewCache = new HashMap();

        public RequestViewHolder(View view) {
            super(view);
        }

        public void clearAnimation() {
            ValueAnimator valueAnimator = this.animation;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.itemView.setTranslationY(0.0f);
            }
        }

        public <E extends View> E findCachedView(int i11) {
            E e11;
            synchronized (this.viewCache) {
                if (this.viewCache.containsKey(Integer.valueOf(i11))) {
                    e11 = (View) this.viewCache.get(Integer.valueOf(i11));
                } else {
                    E findViewById = this.itemView.findViewById(i11);
                    this.viewCache.put(Integer.valueOf(i11), findViewById);
                    e11 = findViewById;
                }
            }
            return e11;
        }

        public void startAnimation() {
            int measuredHeight = this.itemView.getMeasuredHeight();
            if (measuredHeight == 0) {
                this.itemView.measure(0, 0);
                measuredHeight = this.itemView.getMeasuredHeight();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{((float) measuredHeight) * ANIMATION_HEIGHT_RATIO, 0.0f});
            this.animation = ofFloat;
            ofFloat.setInterpolator(TIME_INTERPOLATOR);
            this.animation.setDuration(250);
            this.animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RequestViewHolder.this.itemView.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.animation.start();
        }
    }

    public ComponentRequestAdapter(p pVar, CellFactory cellFactory, RecyclerView recyclerView2) {
        this.listUpdateCallback = pVar;
        this.recyclerView = recyclerView2;
        this.requestMessageList = new ArrayList();
        this.requestAdapterSelector = new RequestAdapterSelector(cellFactory);
    }

    /* access modifiers changed from: private */
    public void updateDataSet(List<CellType.Base> list, List<CellType.Base> list2) {
        DiffUtil.d c11 = DiffUtil.c(new DiffCalculator(list, list2), true);
        this.requestMessageList.clear();
        this.requestMessageList.addAll(list2);
        c11.b(this.listUpdateCallback);
    }

    public int getMessageCount() {
        return this.requestMessageList.size();
    }

    public CellType.Base getMessageForPos(int i11) {
        return this.requestMessageList.get(i11);
    }

    public StateSelector<List<CellType.Base>> getSelector() {
        return this.requestAdapterSelector;
    }

    public void update(final List<CellType.Base> list) {
        this.recyclerView.removeCallbacks(this.updateRunnable);
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                ComponentRequestAdapter.this.updateDataSet(a.c(ComponentRequestAdapter.this.requestMessageList), a.c(list));
            }
        };
        this.updateRunnable = r02;
        this.recyclerView.postDelayed(r02, 200);
    }

    public ComponentRequestAdapter(List<CellType.Base> list, p pVar, RequestAdapterSelector requestAdapterSelector2, RecyclerView recyclerView2) {
        this.requestMessageList = list;
        this.listUpdateCallback = pVar;
        this.requestAdapterSelector = requestAdapterSelector2;
        this.recyclerView = recyclerView2;
    }
}
