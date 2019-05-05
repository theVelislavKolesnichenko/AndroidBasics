package com.example.test.exampletest2.viewmodels;

import android.arch.lifecycle.ViewModel;
import com.example.test.exampletest2.service.models.Product;

public class EditProductViewModel extends ViewModel {

    public Product product;

    public String getName() {
        return product.getName();
    }

    public void setName(String name) {
        this.product.setName(name);
    }

    public String getContent() {
        return product.getContent();
    }

    public void setContent(String content) {
        this.product.setContent(content);
    }

    public String getValue() {
        return Integer.toString(product.getValue());
    }

    public void setValue(String value) {
        this.product.setValue(Integer.parseInt(value));
    }

    public Product getProduct() {
        return product;
    }

    public EditProductViewModel() {
        product = new Product();
    }
}
