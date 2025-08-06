package zendesk.support.guide;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.zendesk.guide.sdk.R$attr;
import com.zendesk.guide.sdk.R$color;
import com.zendesk.guide.sdk.R$drawable;
import com.zendesk.guide.sdk.R$id;
import com.zendesk.guide.sdk.R$layout;
import com.zendesk.guide.sdk.R$string;
import com.zendesk.logger.Logger;
import java.util.List;
import u0.a;
import zendesk.core.NetworkInfoProvider;
import zendesk.support.CategoryItem;
import zendesk.support.HelpCenterProvider;
import zendesk.support.HelpItem;
import zendesk.support.SectionItem;
import zendesk.support.SeeAllArticlesItem;

class HelpRecyclerViewAdapter extends RecyclerView.Adapter<HelpViewHolder> implements HelpMvp$View {
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public int defaultCategoryTitleColour;
    /* access modifiers changed from: private */
    public final HelpCenterConfiguration helpCenterUiConfig;
    /* access modifiers changed from: private */
    public int highlightCategoryTitleColour;
    /* access modifiers changed from: private */
    public HelpMvp$Presenter presenter;

    public class ArticleViewHolder extends HelpViewHolder {
        public ArticleViewHolder(View view) {
            super(view);
            this.textView = (TextView) view;
        }

        public void bindTo(final HelpItem helpItem, int i11) {
            if (helpItem == null || helpItem.getId() == null) {
                Logger.d(HelpCenterActivity.LOG_TAG, "Article item was null, cannot bind", new Object[0]);
                return;
            }
            this.textView.setText(UiUtils.decodeHtmlEntities(helpItem.getName()));
            this.textView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    ViewArticleActivity.builder(helpItem.getId().longValue()).show(HelpRecyclerViewAdapter.this.context, HelpRecyclerViewAdapter.this.helpCenterUiConfig.getConfigurations());
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
    }

    public class CategoryViewHolder extends HelpViewHolder {
        private static final int ROTATION_END_LEVEL = 10000;
        private static final String ROTATION_PROPERTY_NAME = "level";
        private static final int ROTATION_START_LEVEL = 0;
        /* access modifiers changed from: private */
        public boolean expanded;
        /* access modifiers changed from: private */
        public Drawable expanderDrawable;

        public CategoryViewHolder(View view) {
            super(view);
            this.textView = (TextView) view;
            Drawable mutate = a.r(ContextCompat.getDrawable(view.getContext(), R$drawable.zs_help_ic_expand_more)).mutate();
            this.expanderDrawable = mutate;
            a.n(mutate, UiUtils.themeAttributeToColor(16842808, HelpRecyclerViewAdapter.this.context, R$color.zs_fallback_text_color));
            a.p(this.expanderDrawable, PorterDuff.Mode.SRC_IN);
            ((TextView) view).setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, this.expanderDrawable, (Drawable) null);
        }

        /* access modifiers changed from: private */
        public void setHighlightColor(boolean z11) {
            if (z11) {
                this.textView.setTextColor(HelpRecyclerViewAdapter.this.highlightCategoryTitleColour);
                this.expanderDrawable.setColorFilter(HelpRecyclerViewAdapter.this.highlightCategoryTitleColour, PorterDuff.Mode.SRC_IN);
                return;
            }
            this.textView.setTextColor(HelpRecyclerViewAdapter.this.defaultCategoryTitleColour);
            this.expanderDrawable.setColorFilter(HelpRecyclerViewAdapter.this.defaultCategoryTitleColour, PorterDuff.Mode.SRC_IN);
        }

        public void bindTo(HelpItem helpItem, final int i11) {
            int i12 = 0;
            if (helpItem == null) {
                Logger.d(HelpCenterActivity.LOG_TAG, "Category item was null, cannot bind", new Object[0]);
                return;
            }
            this.textView.setText(UiUtils.decodeHtmlEntities(helpItem.getName()));
            final CategoryItem categoryItem = (CategoryItem) helpItem;
            boolean isExpanded = categoryItem.isExpanded();
            this.expanded = isExpanded;
            Drawable drawable = this.expanderDrawable;
            if (isExpanded) {
                i12 = 10000;
            }
            drawable.setLevel(i12);
            setHighlightColor(categoryItem.isExpanded());
            this.textView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    CategoryViewHolder categoryViewHolder = CategoryViewHolder.this;
                    boolean unused = categoryViewHolder.expanded = HelpRecyclerViewAdapter.this.presenter.onCategoryClick(categoryItem, i11);
                    Drawable access$300 = CategoryViewHolder.this.expanderDrawable;
                    int[] iArr = new int[2];
                    int i11 = 10000;
                    iArr[0] = CategoryViewHolder.this.expanded ? 0 : 10000;
                    if (!CategoryViewHolder.this.expanded) {
                        i11 = 0;
                    }
                    iArr[1] = i11;
                    ObjectAnimator.ofInt(access$300, "level", iArr).start();
                    CategoryViewHolder categoryViewHolder2 = CategoryViewHolder.this;
                    categoryViewHolder2.setHighlightColor(categoryViewHolder2.expanded);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }

        public boolean isExpanded() {
            return this.expanded;
        }
    }

    public class ExtraPaddingViewHolder extends HelpViewHolder {
        public ExtraPaddingViewHolder(View view) {
            super(view);
        }

        public void bindTo(HelpItem helpItem, int i11) {
        }
    }

    public static abstract class HelpViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public HelpViewHolder(View view) {
            super(view);
        }

        public abstract void bindTo(HelpItem helpItem, int i11);
    }

    public class LoadingViewHolder extends HelpViewHolder {
        public LoadingViewHolder(View view) {
            super(view);
        }

        public void bindTo(HelpItem helpItem, int i11) {
        }
    }

    public class NoResultsViewHolder extends HelpViewHolder {
        public NoResultsViewHolder(View view) {
            super(view);
        }

        public void bindTo(HelpItem helpItem, int i11) {
        }
    }

    public class SectionViewHolder extends HelpViewHolder {
        public SectionViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R$id.section_title);
        }

        public void bindTo(HelpItem helpItem, int i11) {
            if (helpItem == null) {
                Logger.d(HelpCenterActivity.LOG_TAG, "Section item was null, cannot bind", new Object[0]);
            } else {
                this.textView.setText(UiUtils.decodeHtmlEntities(helpItem.getName()));
            }
        }
    }

    public class SeeAllViewHolder extends HelpViewHolder {
        /* access modifiers changed from: private */
        public ProgressBar progressBar;

        public SeeAllViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R$id.help_section_action_button);
            this.progressBar = (ProgressBar) view.findViewById(R$id.help_section_loading_progress);
        }

        public void bindTo(final HelpItem helpItem, int i11) {
            String str;
            if (!(helpItem instanceof SeeAllArticlesItem)) {
                Logger.d(HelpCenterActivity.LOG_TAG, "SeeAll item was null, cannot bind", new Object[0]);
                return;
            }
            final SeeAllArticlesItem seeAllArticlesItem = (SeeAllArticlesItem) helpItem;
            if (seeAllArticlesItem.isLoading()) {
                this.textView.setVisibility(8);
                this.progressBar.setVisibility(0);
            } else {
                this.textView.setVisibility(0);
                this.progressBar.setVisibility(8);
            }
            SectionItem section = seeAllArticlesItem.getSection();
            if (section != null) {
                str = HelpRecyclerViewAdapter.this.context.getString(R$string.support_help_see_all_n_articles_label, new Object[]{Integer.valueOf(section.getTotalArticlesCount())});
            } else {
                str = HelpRecyclerViewAdapter.this.context.getString(R$string.support_help_see_all_articles_label);
            }
            this.textView.setText(str);
            this.textView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    SeeAllViewHolder.this.textView.setVisibility(8);
                    SeeAllViewHolder.this.progressBar.setVisibility(0);
                    HelpRecyclerViewAdapter.this.presenter.onSeeAllClick((SeeAllArticlesItem) helpItem);
                    seeAllArticlesItem.setLoading(true);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }
    }

    public HelpRecyclerViewAdapter(HelpCenterConfiguration helpCenterConfiguration, HelpCenterProvider helpCenterProvider, NetworkInfoProvider networkInfoProvider) {
        this.presenter = new HelpAdapterPresenter(this, new HelpModel(helpCenterProvider), networkInfoProvider, helpCenterConfiguration);
        this.helpCenterUiConfig = helpCenterConfiguration;
    }

    private View inflateView(ViewGroup viewGroup, int i11) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
    }

    public void addItem(int i11, HelpItem helpItem) {
        notifyItemInserted(i11);
    }

    public int getItemCount() {
        return this.presenter.getItemCount();
    }

    public int getItemViewType(int i11) {
        return this.presenter.getItemViewType(i11);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        Context context2 = recyclerView.getContext();
        this.context = context2;
        this.highlightCategoryTitleColour = UiUtils.themeAttributeToColor(R$attr.colorPrimary, context2, R$color.zs_fallback_text_color);
        this.defaultCategoryTitleColour = ContextCompat.getColor(this.context, R$color.zs_help_text_color_primary);
        this.presenter.onAttached();
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.presenter.onDetached();
        this.context = null;
    }

    public void removeItem(int i11) {
        notifyItemRemoved(i11);
    }

    public void setContentUpdateListener(HelpCenterMvp$Presenter helpCenterMvp$Presenter) {
        HelpMvp$Presenter helpMvp$Presenter = this.presenter;
        if (helpMvp$Presenter != null) {
            helpMvp$Presenter.setContentPresenter(helpCenterMvp$Presenter);
        }
    }

    public void showItems(List<HelpItem> list) {
        notifyDataSetChanged();
    }

    public void onBindViewHolder(HelpViewHolder helpViewHolder, int i11) {
        if (helpViewHolder == null) {
            Logger.l(HelpCenterActivity.LOG_TAG, "Holder was null, possible unexpected item type", new Object[0]);
        } else {
            helpViewHolder.bindTo(this.presenter.getItemForBinding(i11), i11);
        }
    }

    public HelpViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        switch (i11) {
            case 1:
                return new CategoryViewHolder(inflateView(viewGroup, R$layout.zs_row_category));
            case 2:
                return new SectionViewHolder(inflateView(viewGroup, R$layout.zs_row_section));
            case 3:
                return new ArticleViewHolder(inflateView(viewGroup, R$layout.zs_row_article));
            case 4:
                return new SeeAllViewHolder(inflateView(viewGroup, R$layout.zs_row_action));
            case 5:
                return new LoadingViewHolder(inflateView(viewGroup, R$layout.zs_row_loading_progress));
            case 7:
                return new NoResultsViewHolder(inflateView(viewGroup, R$layout.zs_row_no_articles_found));
            case 8:
                return new ExtraPaddingViewHolder(inflateView(viewGroup, R$layout.zs_row_padding));
            default:
                Logger.l(HelpCenterActivity.LOG_TAG, "Unknown item type, returning null for holder", new Object[0]);
                return null;
        }
    }
}
