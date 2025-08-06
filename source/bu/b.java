package bu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.UtilCollections;
import com.huobi.trade.bean.TradingBotSelectMarketInfo;
import java.util.List;
import pro.huobi.R;

public class b extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public List<TradingBotSelectMarketInfo> f77050a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f77051b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public Rect f77052c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public int f77053d = PixelUtils.a(20.0f);

    /* renamed from: e  reason: collision with root package name */
    public int f77054e;

    /* renamed from: f  reason: collision with root package name */
    public int f77055f;

    /* renamed from: g  reason: collision with root package name */
    public int f77056g;

    public b(Context context, int i11) {
        this.f77051b.setTextSize((float) PixelUtils.a(14.0f));
        this.f77051b.setAntiAlias(true);
        this.f77054e = i11;
        this.f77055f = context.getResources().getColor(R.color.baseColorContentBackground);
        this.f77056g = context.getResources().getColor(R.color.kColorThreeLevelText);
    }

    public final void a(Canvas canvas, int i11, int i12, View view, RecyclerView.LayoutParams layoutParams, int i13) {
        this.f77051b.setColor(this.f77055f);
        canvas.drawRect((float) i11, (float) ((view.getTop() - layoutParams.topMargin) - this.f77053d), (float) i12, (float) (view.getTop() - layoutParams.topMargin), this.f77051b);
        this.f77051b.setColor(this.f77056g);
        this.f77051b.getTextBounds(this.f77050a.get(i13).getLetter(), 0, this.f77050a.get(i13).getLetter().length(), this.f77052c);
        canvas.drawText(this.f77050a.get(i13).getLetter(), (float) view.getPaddingLeft(), (float) ((view.getTop() - layoutParams.topMargin) - ((this.f77053d / 2) - (this.f77052c.height() / 2))), this.f77051b);
    }

    public void b(List<TradingBotSelectMarketInfo> list) {
        this.f77050a = list;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        if (viewLayoutPosition > 0) {
            int i11 = this.f77054e;
            if (viewLayoutPosition < i11) {
                rect.set(0, 0, 0, 0);
            } else if (viewLayoutPosition == i11) {
                rect.set(0, this.f77053d, 0, 0);
            } else if (this.f77050a.get(viewLayoutPosition).getLetter() == null || this.f77050a.get(viewLayoutPosition).getLetter().equals(this.f77050a.get(viewLayoutPosition - 1).getLetter())) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(0, this.f77053d, 0, 0);
            }
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i11;
        super.onDraw(canvas, recyclerView, state);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            if (viewLayoutPosition > 0 && viewLayoutPosition >= (i11 = this.f77054e)) {
                if (viewLayoutPosition == i11) {
                    a(canvas, paddingLeft, width, childAt, layoutParams, viewLayoutPosition);
                } else if (this.f77050a.get(viewLayoutPosition).getLetter() != null && !this.f77050a.get(viewLayoutPosition).getLetter().equals(this.f77050a.get(viewLayoutPosition - 1).getLetter())) {
                    a(canvas, paddingLeft, width, childAt, layoutParams, viewLayoutPosition);
                }
            }
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition >= this.f77054e && UtilCollections.h(this.f77050a, findFirstVisibleItemPosition)) {
            String letter = this.f77050a.get(findFirstVisibleItemPosition).getLetter();
            View view = recyclerView.findViewHolderForLayoutPosition(findFirstVisibleItemPosition).itemView;
            boolean z11 = true;
            int i11 = findFirstVisibleItemPosition + 1;
            if (i11 >= this.f77050a.size() || letter == null || letter.equals(this.f77050a.get(i11).getLetter()) || view.getHeight() + view.getTop() >= this.f77053d) {
                z11 = false;
            } else {
                canvas.save();
                canvas.translate(0.0f, (float) ((view.getHeight() + view.getTop()) - this.f77053d));
            }
            this.f77051b.setColor(this.f77055f);
            canvas.drawRect((float) recyclerView.getPaddingLeft(), (float) recyclerView.getPaddingTop(), (float) (recyclerView.getRight() - recyclerView.getPaddingRight()), (float) (recyclerView.getPaddingTop() + this.f77053d), this.f77051b);
            this.f77051b.setColor(this.f77056g);
            this.f77051b.getTextBounds(letter, 0, letter.length(), this.f77052c);
            int paddingTop = recyclerView.getPaddingTop();
            int i12 = this.f77053d;
            canvas.drawText(letter, (float) view.getPaddingLeft(), (float) ((paddingTop + i12) - ((i12 / 2) - (this.f77052c.height() / 2))), this.f77051b);
            if (z11) {
                canvas.restore();
            }
        }
    }
}
