package com.example.hoho;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private Button btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        // Initialize RecyclerView and Button
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btnCart = findViewById(R.id.btnCart);

        // Handle "View Cart" button click
        btnCart.setOnClickListener(v -> {
            // Open CartActivity to view the cart
            Intent intent = new Intent(ProductListActivity.this, CartActivity.class);
            startActivity(intent);
        });

        // Fetch the category ID from the intent
        int categoryId = getIntent().getIntExtra("CATEGORY_ID", -1);
        if (categoryId != -1) {
            fetchProducts(categoryId);
        }
    }

    // Method to fetch products from API based on category
    private void fetchProducts(int categoryId) {
        apiset api = apicontroller.getInstance().getapi();

        Call<List<Product>> call = api.getProductsByCategory(categoryId);

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Populate the RecyclerView with products
                    List<Product> products = response.body();
                    productAdapter = new ProductAdapter(products, ProductListActivity.this);
                    recyclerView.setAdapter(productAdapter);
                } else {
                    // Handle failure to fetch products
                    Log.e("ProductListActivity", "Response code: " + response.code());
                    Log.e("ProductListActivity", "Response body: " + response.body());
                    Toast.makeText(ProductListActivity.this, "Failed to fetch products", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Product>> call, @NonNull Throwable t) {
                // Handle API call failure
                Log.e("ProductListActivity", "Error: " + t.getMessage());
                Toast.makeText(ProductListActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
