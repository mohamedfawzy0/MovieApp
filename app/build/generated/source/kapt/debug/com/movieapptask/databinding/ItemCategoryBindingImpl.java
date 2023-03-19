package com.movieapptask.databinding;
import com.movieapptask.R;
import com.movieapptask.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemCategoryBindingImpl extends ItemCategoryBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemCategoryBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private ItemCategoryBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[0]
            , (android.widget.TextView) bindings[1]
            );
        this.card.setTag(null);
        this.tvName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
            setModel((com.movieapptask.domain.model.response.GenresModel.Genre) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.movieapptask.domain.model.response.GenresModel.Genre Model) {
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
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
        com.movieapptask.domain.model.response.GenresModel.Genre model = mModel;
        java.lang.String modelName = null;
        int modelSelectedTvNameAndroidColorWhiteTvNameAndroidColorColorPrimary = 0;
        int modelSelectedCardAndroidColorColorPrimaryCardAndroidColorWhite = 0;
        boolean modelSelected = false;

        if ((dirtyFlags & 0x3L) != 0) {



                if (model != null) {
                    // read model.name
                    modelName = model.getName();
                    // read model.selected
                    modelSelected = model.isSelected();
                }
            if((dirtyFlags & 0x3L) != 0) {
                if(modelSelected) {
                        dirtyFlags |= 0x8L;
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x4L;
                        dirtyFlags |= 0x10L;
                }
            }


                // read model.selected ? @android:color/white : @android:color/colorPrimary
                modelSelectedTvNameAndroidColorWhiteTvNameAndroidColorColorPrimary = ((modelSelected) ? (getColorFromResource(tvName, R.color.white)) : (getColorFromResource(tvName, R.color.colorPrimary)));
                // read model.selected ? @android:color/colorPrimary : @android:color/white
                modelSelectedCardAndroidColorColorPrimaryCardAndroidColorWhite = ((modelSelected) ? (getColorFromResource(card, R.color.colorPrimary)) : (getColorFromResource(card, R.color.white)));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.card.setCardBackgroundColor(modelSelectedCardAndroidColorColorPrimaryCardAndroidColorWhite);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvName, modelName);
            this.tvName.setTextColor(modelSelectedTvNameAndroidColorWhiteTvNameAndroidColorColorPrimary);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): null
        flag 2 (0x3L): model.selected ? @android:color/white : @android:color/colorPrimary
        flag 3 (0x4L): model.selected ? @android:color/white : @android:color/colorPrimary
        flag 4 (0x5L): model.selected ? @android:color/colorPrimary : @android:color/white
        flag 5 (0x6L): model.selected ? @android:color/colorPrimary : @android:color/white
    flag mapping end*/
    //end
}