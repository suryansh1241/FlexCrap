package com.example.hoho;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CartAdapter cartAdapter;
    private List<Product> cartItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.cartRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get the cart items (assuming you already have a method for this)
        cartItems = ProductAdapter.getCartItems();

        if (cartItems.isEmpty()) {
            Toast.makeText(this, "Cart is empty", Toast.LENGTH_SHORT).show();
        } else {
            // Set up the CartAdapter
            cartAdapter = new CartAdapter(cartItems, this);
            recyclerView.setAdapter(cartAdapter);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the cart data when resuming the activity
        cartAdapter.notifyDataSetChanged();
    }
}
