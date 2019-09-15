package com.example.test.exampletest2.databinding;
import com.example.test.exampletest2.R;
import com.example.test.exampletest2.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentAddBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.button, 4);
    }
    // views
    @NonNull
    public final android.widget.Button button;
    @NonNull
    public final android.widget.EditText editText;
    @NonNull
    public final android.widget.EditText editText2;
    @NonNull
    public final android.widget.EditText editText3;
    @NonNull
    public final android.support.constraint.ConstraintLayout frameLayout;
    // variables
    @Nullable
    private com.example.test.exampletest2.viewmodels.EditProductViewModel mEditProduct;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener editTextandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of editProduct.name
            //         is editProduct.setName((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(editText);
            // localize variables for thread safety
            // editProduct != null
            boolean editProductJavaLangObjectNull = false;
            // editProduct.name
            java.lang.String editProductName = null;
            // editProduct
            com.example.test.exampletest2.viewmodels.EditProductViewModel editProduct = mEditProduct;



            editProductJavaLangObjectNull = (editProduct) != (null);
            if (editProductJavaLangObjectNull) {




                editProduct.setName(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener editText2androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of editProduct.content
            //         is editProduct.setContent((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(editText2);
            // localize variables for thread safety
            // editProduct != null
            boolean editProductJavaLangObjectNull = false;
            // editProduct
            com.example.test.exampletest2.viewmodels.EditProductViewModel editProduct = mEditProduct;
            // editProduct.content
            java.lang.String editProductContent = null;



            editProductJavaLangObjectNull = (editProduct) != (null);
            if (editProductJavaLangObjectNull) {




                editProduct.setContent(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private android.databinding.InverseBindingListener editText3androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of editProduct.value
            //         is editProduct.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(editText3);
            // localize variables for thread safety
            // editProduct != null
            boolean editProductJavaLangObjectNull = false;
            // editProduct
            com.example.test.exampletest2.viewmodels.EditProductViewModel editProduct = mEditProduct;
            // editProduct.value
            java.lang.String editProductValue = null;



            editProductJavaLangObjectNull = (editProduct) != (null);
            if (editProductJavaLangObjectNull) {




                editProduct.setValue(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentAddBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.button = (android.widget.Button) bindings[4];
        this.editText = (android.widget.EditText) bindings[1];
        this.editText.setTag(null);
        this.editText2 = (android.widget.EditText) bindings[2];
        this.editText2.setTag(null);
        this.editText3 = (android.widget.EditText) bindings[3];
        this.editText3.setTag(null);
        this.frameLayout = (android.support.constraint.ConstraintLayout) bindings[0];
        this.frameLayout.setTag(null);
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
        if (BR.editProduct == variableId) {
            setEditProduct((com.example.test.exampletest2.viewmodels.EditProductViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setEditProduct(@Nullable com.example.test.exampletest2.viewmodels.EditProductViewModel EditProduct) {
        this.mEditProduct = EditProduct;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.editProduct);
        super.requestRebind();
    }
    @Nullable
    public com.example.test.exampletest2.viewmodels.EditProductViewModel getEditProduct() {
        return mEditProduct;
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
        com.example.test.exampletest2.viewmodels.EditProductViewModel editProduct = mEditProduct;
        java.lang.String editProductContent = null;
        java.lang.String editProductValue = null;
        java.lang.String editProductName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (editProduct != null) {
                    // read editProduct.content
                    editProductContent = editProduct.getContent();
                    // read editProduct.value
                    editProductValue = editProduct.getValue();
                    // read editProduct.name
                    editProductName = editProduct.getName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.editText, editProductName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.editText2, editProductContent);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.editText3, editProductValue);
        }
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editText, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editTextandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editText2, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editText2androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.editText3, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, editText3androidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentAddBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentAddBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentAddBinding>inflate(inflater, com.example.test.exampletest2.R.layout.fragment_add, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentAddBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentAddBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.example.test.exampletest2.R.layout.fragment_add, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentAddBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentAddBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_add_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentAddBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): editProduct
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}