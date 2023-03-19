package com.movieapptask.databinding;
import com.movieapptask.R;
import com.movieapptask.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ToolbarBindingImpl extends ToolbarBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 3);
    }
    // views
    @NonNull
    private final com.google.android.material.appbar.AppBarLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ToolbarBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ToolbarBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (androidx.appcompat.widget.Toolbar) bindings[3]
            , (android.widget.TextView) bindings[2]
            );
        this.llBack.setTag(null);
        this.mboundView0 = (com.google.android.material.appbar.AppBarLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.lang == variableId) {
            setLang((java.lang.String) variable);
        }
        else if (BR.title == variableId) {
            setTitle((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLang(@Nullable java.lang.String Lang) {
        this.mLang = Lang;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.lang);
        super.requestRebind();
    }
    public void setTitle(@Nullable java.lang.String Title) {
        this.mTitle = Title;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.title);
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
        java.lang.String lang = mLang;
        java.lang.String title = mTitle;
        int langEqualsJavaLangStringArInt180Int0 = 0;
        boolean langEqualsJavaLangStringAr = false;

        if ((dirtyFlags & 0x5L) != 0) {



                if (lang != null) {
                    // read lang.equals("ar")
                    langEqualsJavaLangStringAr = lang.equals("ar");
                }
            if((dirtyFlags & 0x5L) != 0) {
                if(langEqualsJavaLangStringAr) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }


                // read lang.equals("ar") ? 180 : 0
                langEqualsJavaLangStringArInt180Int0 = ((langEqualsJavaLangStringAr) ? (180) : (0));
        }
        if ((dirtyFlags & 0x6L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 11
            if(getBuildSdkInt() >= 11) {

                this.llBack.setRotation(langEqualsJavaLangStringArInt180Int0);
            }
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvTitle, title);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): lang
        flag 1 (0x2L): title
        flag 2 (0x3L): null
        flag 3 (0x4L): lang.equals("ar") ? 180 : 0
        flag 4 (0x5L): lang.equals("ar") ? 180 : 0
    flag mapping end*/
    //end
}