package com.example.hoho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoho.Product;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<Product> cartProducts;
    private Context context;

    public CartAdapter(List<Product> cartProducts, Context context) {
        this.cartProducts = cartProducts;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Product product = cartProducts.get(position);
        holder.cartProductName.setText(product.getPname());
        holder.cartProductPrice.setText(String.format("$%.2f", product.getPrice()));

        // Handle "Remove" button click
        holder.btnRemove.setOnClickListener(v -> {
            cartProducts.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartProducts.size());
            Toast.makeText(context, product.getPname() + " removed from cart", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return cartProducts.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView cartProductName;
        TextView cartProductPrice;
        Button btnRemove; // Button for removing the product from cart

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            cartProductName = itemView.findViewById(R.id.cartProductName);
            cartProductPrice = itemView.findViewById(R.id.cartProductPrice);
            btnRemove = itemView.findViewById(R.id.btnRemove);
        }
    }
}