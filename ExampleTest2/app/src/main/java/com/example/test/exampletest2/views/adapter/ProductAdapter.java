package com.example.test.exampletest2.views.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.test.exampletest2.R;
import com.example.test.exampletest2.service.models.Product;
import com.example.test.exampletest2.viewmodels.ProductListViewModel;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private ProductListViewModel productListViewModel;

    public ProductAdapter(ProductListViewModel productListViewModel) {
        this.productListViewModel = productListViewModel;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_item, viewGroup, false);
        ProductViewHolder pvh = new ProductViewHolder(view);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder personViewHolder, final int i) {

        Product product = productListViewModel.getProducts().getValue().get(i);

        personViewHolder.getName().setText(product.getName());
        personViewHolder.getContent().setText(product.getContent());
        personViewHolder.getValue().setImageResource(product.getValue());
        personViewHolder.getBtnDelete().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productListViewModel.removeProduct(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productListViewModel.getProducts().getValue().size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
