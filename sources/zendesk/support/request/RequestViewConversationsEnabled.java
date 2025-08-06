package zendesk.support.request;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.h0;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import c1.b;
import com.squareup.picasso.Picasso;
import com.zendesk.sdk.R$dimen;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$layout;
import zendesk.belvedere.BelvedereUi;
import zendesk.belvedere.ImageStream;
import zendesk.support.request.CellType;
import zendesk.support.request.ComponentRequestAdapter;
import zendesk.support.request.ViewMessageComposer;
import zendesk.support.suas.CombinedSubscription;
import zendesk.support.suas.Store;
import zendesk.support.suas.Subscription;

@SuppressLint({"ViewConstructor"})
public class RequestViewConversationsEnabled extends FrameLayout implements RequestView {
    private AppCompatActivity activity;

    /* renamed from: af  reason: collision with root package name */
    public ActionFactory f62981af;
    public CellFactory cellFactory;
    private ImagePickerDragAnimation imagePickerDragAnimation;
    private ImageStream imageStream;
    private ComponentMessageComposer messageComposerComponent;
    private ViewMessageComposer messageComposerView;
    public Picasso picasso;
    private RecyclerView recyclerView;
    public Store store;
    private Subscription subscription;
    private View toolbar;
    private View toolbarContainer;

    public static class ImagePickerDragAnimation implements ImageStream.c {
        private final Interpolator cubicBezierInterpolator = b.a(0.19f, 0.0f, 0.2f, 1.0f);
        private final View messageComposer;
        private final View recycler;
        private final View toolbar;
        private final View toolbarContainer;

        public ImagePickerDragAnimation(View view, View view2, View view3, View view4) {
            this.toolbarContainer = view;
            this.messageComposer = view2;
            this.recycler = view3;
            this.toolbar = view4;
        }

        private void animateBackground(int i11, float f11) {
            float interpolation = (float) ((int) (this.cubicBezierInterpolator.getInterpolation(f11 * 0.3f) * -1.0f * ((float) i11)));
            this.messageComposer.setTranslationY(interpolation);
            this.recycler.setTranslationY(interpolation);
        }

        private void animateToolbar(int i11, float f11) {
            float f12 = (float) i11;
            float f13 = f11 * f12;
            int G = h0.G(this.toolbar);
            if (i11 > 0) {
                float f14 = f12 - f13;
                float f15 = (float) G;
                if (f14 < f15) {
                    this.toolbarContainer.setTranslationY(f14 - f15);
                    return;
                }
            }
            this.toolbarContainer.setTranslationY(0.0f);
        }

        public void onScroll(int i11, int i12, float f11) {
            animateToolbar(i12, f11);
            animateBackground(i12, f11);
        }
    }

    public static class RecyclerListener implements ViewMessageComposer.OnHeightChangeListener, View.OnFocusChangeListener, View.OnLayoutChangeListener, p {
        private static final int FIXED_SCROLL_TIME = 50;
        private static final int SCROLL_INSTANT = 1;
        private static final int SCROLL_SMOOTH_FIXED_TIME = 3;
        private static final int SCROLL_SMOOTH_FIXED_VELOCITY = 2;
        private final LinearLayoutManager linearLayoutManager;
        /* access modifiers changed from: private */
        public final int recyclerDefaultBottomPadding;
        /* access modifiers changed from: private */
        public final RecyclerView recyclerView;

        public RecyclerListener(RecyclerView recyclerView2, LinearLayoutManager linearLayoutManager2) {
            this.recyclerView = recyclerView2;
            this.linearLayoutManager = linearLayoutManager2;
            this.recyclerDefaultBottomPadding = recyclerView2.getResources().getDimensionPixelOffset(R$dimen.zs_request_recycler_padding_bottom);
        }

        private void postScrollToBottom(final int i11) {
            this.recyclerView.post(new Runnable() {
                public void run() {
                    RecyclerListener.this.scrollToBottom(i11);
                }
            });
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
            r3 = r3.itemView;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void scrollToBottom(int r3) {
            /*
                r2 = this;
                androidx.recyclerview.widget.RecyclerView r0 = r2.recyclerView
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
                int r0 = r0.getItemCount()
                r1 = 1
                int r0 = r0 - r1
                if (r0 < 0) goto L_0x0066
                if (r3 != r1) goto L_0x0031
                androidx.recyclerview.widget.RecyclerView r3 = r2.recyclerView
                androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = r3.findViewHolderForAdapterPosition(r0)
                if (r3 == 0) goto L_0x0021
                android.view.View r3 = r3.itemView
                if (r3 == 0) goto L_0x0021
                int r3 = r3.getHeight()
                goto L_0x0022
            L_0x0021:
                r3 = 0
            L_0x0022:
                androidx.recyclerview.widget.RecyclerView r1 = r2.recyclerView
                int r1 = r1.getPaddingBottom()
                int r1 = r1 + r3
                int r1 = r1 * -1
                androidx.recyclerview.widget.LinearLayoutManager r3 = r2.linearLayoutManager
                r3.scrollToPositionWithOffset(r0, r1)
                goto L_0x0066
            L_0x0031:
                r1 = 3
                if (r3 != r1) goto L_0x004c
                zendesk.support.request.RequestViewConversationsEnabled$RecyclerListener$2 r3 = new zendesk.support.request.RequestViewConversationsEnabled$RecyclerListener$2
                androidx.recyclerview.widget.RecyclerView r1 = r2.recyclerView
                android.content.Context r1 = r1.getContext()
                r3.<init>(r1)
                r3.setTargetPosition(r0)
                androidx.recyclerview.widget.RecyclerView r0 = r2.recyclerView
                androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
                r0.startSmoothScroll(r3)
                goto L_0x0066
            L_0x004c:
                r1 = 2
                if (r3 != r1) goto L_0x0066
                androidx.recyclerview.widget.n r3 = new androidx.recyclerview.widget.n
                androidx.recyclerview.widget.RecyclerView r1 = r2.recyclerView
                android.content.Context r1 = r1.getContext()
                r3.<init>(r1)
                r3.setTargetPosition(r0)
                androidx.recyclerview.widget.RecyclerView r0 = r2.recyclerView
                androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
                r0.startSmoothScroll(r3)
            L_0x0066:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.support.request.RequestViewConversationsEnabled.RecyclerListener.scrollToBottom(int):void");
        }

        public void onChanged(int i11, int i12, Object obj) {
            this.recyclerView.getAdapter().notifyItemRangeChanged(i11, i12, obj);
        }

        public void onFocusChange(View view, boolean z11) {
            if (z11) {
                postScrollToBottom(2);
            }
        }

        public void onHeightChange(final int i11) {
            this.recyclerView.post(new Runnable() {
                public void run() {
                    int paddingLeft = RecyclerListener.this.recyclerView.getPaddingLeft();
                    int paddingRight = RecyclerListener.this.recyclerView.getPaddingRight();
                    int paddingTop = RecyclerListener.this.recyclerView.getPaddingTop();
                    int access$100 = RecyclerListener.this.recyclerDefaultBottomPadding;
                    int i11 = i11;
                    if (i11 > 0) {
                        access$100 += i11;
                    }
                    if (access$100 != RecyclerListener.this.recyclerView.getPaddingBottom()) {
                        RecyclerListener.this.recyclerView.setPadding(paddingLeft, paddingTop, paddingRight, access$100);
                        RecyclerListener.this.scrollToBottom(1);
                    }
                }
            });
        }

        public void onInserted(int i11, int i12) {
            this.recyclerView.getAdapter().notifyItemRangeChanged(i11, i12);
            postScrollToBottom(3);
        }

        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            if (i14 < i18) {
                postScrollToBottom(1);
            }
        }

        public void onMoved(int i11, int i12) {
            this.recyclerView.getAdapter().notifyItemMoved(i11, i12);
        }

        public void onRemoved(int i11, int i12) {
            this.recyclerView.getAdapter().notifyItemRangeRemoved(i11, i12);
        }
    }

    public static class RequestItemAnimator extends DefaultItemAnimator {
        private final ComponentRequestAdapter component;

        public RequestItemAnimator(ComponentRequestAdapter componentRequestAdapter) {
            this.component = componentRequestAdapter;
            setSupportsChangeAnimations(false);
        }

        public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder) {
            if (this.component.getMessageForPos(viewHolder.getAdapterPosition()) instanceof CellType.Attachment) {
                return true;
            }
            return super.canReuseUpdatedViewHolder(viewHolder);
        }
    }

    public RequestViewConversationsEnabled(Context context) {
        super(context);
        viewInit(context);
    }

    private Subscription bindComponents(Store store2) {
        return CombinedSubscription.from(bindMessageComposer(store2), bindRecycler(store2), bindDialogComponent(store2));
    }

    private Subscription bindDialogComponent(Store store2) {
        return store2.addListener(StateUi.class, new ComponentDialog(this.activity, this.f62981af, store2));
    }

    private Subscription bindMessageComposer(Store store2) {
        ComponentMessageComposer componentMessageComposer = new ComponentMessageComposer(this.activity, this.imageStream, this.messageComposerView, store2, this.f62981af);
        this.messageComposerComponent = componentMessageComposer;
        return store2.addListener(componentMessageComposer.getSelector(), this.messageComposerComponent);
    }

    private Subscription bindRecycler(Store store2) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.activity);
        RecyclerListener recyclerListener = new RecyclerListener(this.recyclerView, linearLayoutManager);
        ComponentRequestAdapter componentRequestAdapter = new ComponentRequestAdapter(recyclerListener, this.cellFactory, this.recyclerView);
        CellMarginDecorator cellMarginDecorator = new CellMarginDecorator(componentRequestAdapter, this.activity);
        RequestItemAnimator requestItemAnimator = new RequestItemAnimator(componentRequestAdapter);
        ComponentRequestAdapter.RequestAdapter requestAdapter = new ComponentRequestAdapter.RequestAdapter(componentRequestAdapter);
        this.recyclerView.setItemAnimator(requestItemAnimator);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.addItemDecoration(cellMarginDecorator);
        this.recyclerView.setAdapter(requestAdapter);
        this.recyclerView.setNestedScrollingEnabled(false);
        this.messageComposerView.setOnHeightChangeListener(recyclerListener);
        this.messageComposerView.addOnFocusChangeListener(recyclerListener);
        this.recyclerView.addOnLayoutChangeListener(recyclerListener);
        return store2.addListener(componentRequestAdapter.getSelector(), componentRequestAdapter);
    }

    private void bindViews() {
        this.imageStream = BelvedereUi.c(this.activity);
        this.recyclerView = (RecyclerView) findViewById(R$id.activity_request_recycler_view);
        this.messageComposerView = (ViewMessageComposer) findViewById(R$id.activity_request_message_composer);
        this.toolbarContainer = this.activity.findViewById(R$id.activity_request_appbar);
        this.toolbar = this.activity.findViewById(R$id.activity_request_toolbar);
        this.messageComposerView.init(this.imageStream);
        installDragAnimation();
    }

    private void installDragAnimation() {
        ImagePickerDragAnimation imagePickerDragAnimation2 = new ImagePickerDragAnimation(this.toolbarContainer, this.messageComposerView, this.recyclerView, this.toolbar);
        this.imagePickerDragAnimation = imagePickerDragAnimation2;
        this.imageStream.rh(imagePickerDragAnimation2);
    }

    private void viewInit(Context context) {
        FrameLayout.inflate(context, R$layout.zs_view_request_conversations_enabled, this);
        this.activity = (AppCompatActivity) context;
    }

    public boolean hasUnsavedInput() {
        ComponentMessageComposer componentMessageComposer = this.messageComposerComponent;
        return componentMessageComposer != null && componentMessageComposer.hasUnsavedInput();
    }

    public boolean inflateMenu(MenuInflater menuInflater, Menu menu) {
        return false;
    }

    public void init(RequestComponent requestComponent, boolean z11) {
        requestComponent.inject(this);
        bindViews();
        Subscription bindComponents = bindComponents(this.store);
        this.subscription = bindComponents;
        bindComponents.informWithCurrentState();
        if (z11) {
            this.store.dispatch(this.f62981af.loadCommentsFromCacheAsync());
            this.store.dispatch(this.f62981af.loadRequestAsync());
            this.store.dispatch(this.f62981af.initialLoadCommentsAsync());
            this.messageComposerView.requestFocusForInput();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.removeListener();
        }
    }

    public boolean onOptionsItemClicked(MenuItem menuItem) {
        return false;
    }

    public RequestViewConversationsEnabled(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        viewInit(context);
    }

    public RequestViewConversationsEnabled(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        viewInit(context);
    }
}
