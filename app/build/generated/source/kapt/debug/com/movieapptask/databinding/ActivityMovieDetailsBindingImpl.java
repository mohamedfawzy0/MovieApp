package com.movieapptask.databinding;
import com.movieapptask.R;
import com.movieapptask.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMovieDetailsBindingImpl extends ActivityMovieDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toollbar, 8);
        sViewsWithIds.put(R.id.refresh, 9);
        sViewsWithIds.put(R.id.movieImg, 10);
        sViewsWithIds.put(R.id.recViewGenre, 11);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView5;
    @NonNull
    private final android.widget.TextView mboundView6;
    @NonNull
    private final android.widget.TextView mboundView7;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMovieDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ActivityMovieDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageView) bindings[10]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) bindings[9]
            , (androidx.appcompat.widget.Toolbar) bindings[8]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            );
        this.icFav.setTag(null);
        this.llBack.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.tvBody.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.model == variableId) {
            setModel((com.movieapptask.domain.model.response.MoviesModel.Movie) variable);
        }
        else if (BR.fav == variableId) {
            setFav((java.lang.Boolean) variable);
        }
        else if (BR.lang == variableId) {
            setLang((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.movieapptask.domain.model.response.MoviesModel.Movie Model) {
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }
    public void setFav(@Nullable java.lang.Boolean Fav) {
        this.mFav = Fav;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.fav);
        super.requestRebind();
    }
    public void setLang(@Nullable java.lang.String Lang) {
        this.mLang = Lang;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.lang);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.movieapptask.domain.model.response.MoviesModel.Movie model = mModel;
        java.lang.String modelOverview = null;
        java.lang.String modelBudgetJavaLangStringMboundView7AndroidStringDollar = null;
        java.lang.String modelBudgetJavaLangString = null;
        java.lang.String modelReleaseDate = null;
        java.lang.Boolean fav = mFav;
        java.lang.String lang = mLang;
        android.graphics.drawable.Drawable favIcFavAndroidDrawableIcFavoriteIcFavAndroidDrawableIcUnfavorite = null;
        int langEqualsJavaLangStringArInt180Int0 = 0;
        java.lang.String modelTitle = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxFav = false;
        int modelBudget = 0;
        boolean langEqualsJavaLangStringAr = false;

        if ((dirtyFlags & 0x9L) != 0) {



                if (model != null) {
                    // read model.overview
                    modelOverview = model.getOverview();
                    // read model.release_date
                    modelReleaseDate = model.getRelease_date();
                    // read model.title
                    modelTitle = model.getTitle();
                    // read model.budget
                    modelBudget = model.getBudget();
                }


                // read (model.budget) + (" ")
                modelBudgetJavaLangString = (modelBudget) + (" ");


                // read ((model.budget) + (" ")) + (@android:string/dollar)
                modelBudgetJavaLangStringMboundView7AndroidStringDollar = (modelBudgetJavaLangString) + (mboundView7.getResources().getString(R.string.dollar));
        }
        if ((dirtyFlags & 0xaL) != 0) {



                // read androidx.databinding.ViewDataBinding.safeUnbox(fav)
                androidxDatabindingViewDataBindingSafeUnboxFav = androidx.databinding.ViewDataBinding.safeUnbox(fav);
            if((dirtyFlags & 0xaL) != 0) {
                if(androidxDatabindingViewDataBindingSafeUnboxFav) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }


                // read androidx.databinding.ViewDataBinding.safeUnbox(fav) ? @android:drawable/ic_favorite : @android:drawable/ic_unfavorite
                favIcFavAndroidDrawableIcFavoriteIcFavAndroidDrawableIcUnfavorite = ((androidxDatabindingViewDataBindingSafeUnboxFav) ? (androidx.appcompat.content.res.AppCompatResources.getDrawable(icFav.getContext(), R.drawable.ic_favorite)) : (androidx.appcompat.content.res.AppCompatResources.getDrawable(icFav.getContext(), R.drawable.ic_unfavorite)));
        }
        if ((dirtyFlags & 0xcL) != 0) {



                if (lang != null) {
                    // read lang.equals("ar")
                    langEqualsJavaLangStringAr = lang.equals("ar");
                }
            if((dirtyFlags & 0xcL) != 0) {
                if(langEqualsJavaLangStringAr) {
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x40L;
                }
            }


                // read lang.equals("ar") ? 180 : 0
                langEqualsJavaLangStringArInt180Int0 = ((langEqualsJavaLangStringAr) ? (180) : (0));
        }
        // batch finished
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.icFav, favIcFavAndroidDrawableIcFavoriteIcFavAndroidDrawableIcUnfavorite);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 11
            if(getBuildSdkInt() >= 11) {

                this.llBack.setRotation(langEqualsJavaLangStringArInt180Int0);
            }
        }
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, modelOverview);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, modelReleaseDate);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, modelBudgetJavaLangStringMboundView7AndroidStringDollar);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvBody, modelTitle);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvTitle, modelTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): fav
        flag 2 (0x3L): lang
        flag 3 (0x4L): null
        flag 4 (0x5L): androidx.databinding.ViewDataBinding.safeUnbox(fav) ? @android:drawable/ic_favorite : @android:drawable/ic_unfavorite
        flag 5 (0x6L): androidx.databinding.ViewDataBinding.safeUnbox(fav) ? @android:drawable/ic_favorite : @android:drawable/ic_unfavorite
        flag 6 (0x7L): lang.equals("ar") ? 180 : 0
        flag 7 (0x8L): lang.equals("ar") ? 180 : 0
    flag mapping end*/
    //end
}