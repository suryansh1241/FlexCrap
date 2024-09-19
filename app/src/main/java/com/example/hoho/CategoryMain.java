package com.example.hoho;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class CategoryMain extends AppCompatActivity implements CategoryAdapter.OnCategoryClickListener {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchCategories();
    }

    private void fetchCategories() {
        apiset api = apicontroller.getInstance().getapi();
        Call<List<category>> call = api.getCategories();

        call.enqueue(new Callback<List<category>>() {
            @Override
            public void onResponse(@NonNull Call<List<category>> call, @NonNull Response<List<category>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<category> categories = response.body();
                    categoryAdapter = new CategoryAdapter(categories, CategoryMain.this);
                    recyclerView.setAdapter(categoryAdapter);
                } else {
                    Toast.makeText(CategoryMain.this, "Failed to fetch categories", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<category>> call, @NonNull Throwable t) {
                Toast.makeText(CategoryMain.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCategoryClick(category category) {
        Intent intent = new Intent(CategoryMain.this, ProductListActivity.class);
        intent.putExtra("CATEGORY_ID", category.getId());
        startActivity(intent);
    }
}
