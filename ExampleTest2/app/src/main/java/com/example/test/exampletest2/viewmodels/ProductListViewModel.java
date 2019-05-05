package com.example.test.exampletest2.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.example.test.exampletest2.service.Repository;
import com.example.test.exampletest2.service.models.Product;

import java.util.List;

public class ProductListViewModel extends ViewModel {

    private MutableLiveData<List<Product>> products = new MutableLiveData<>();
    private Repository repository;

    public MutableLiveData<List<Product>> getProducts() {
        return products;
    }

    public void setProducts(MutableLiveData<List<Product>> products) {
        this.products = products;
    }

    public ProductListViewModel(Repository repository) {
        this.repository = repository;
        this.products.setValue(this.repository);
    }

    public void addProduct(Product product) {
        repository.add(product);
        products.setValue(repository);
    }

    public void removeProduct(int position) {
        repository.remove(position);
        products.setValue(repository);
    }
}
