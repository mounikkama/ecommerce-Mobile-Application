package com.example.amazoncopy;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_products);

    db= FirebaseFirestore.getInstance();

    productList = new ArrayList<>();

    recyclerView= findViewById(R.id.recyclerView_products);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchProductsFromFirestore();


//    productList.add(new Product("Nike","$120",R.drawable.sneaker_image2));
//    productList.add(new Product("Puma","$180",R.drawable.sneaker2));
//    productList.add(new Product("adiddas","$110",R.drawable.sneaker3));
//    productList.add(new Product("Nike","$90",R.drawable.sneaker6));
//    productList.add(new Product("Sketchers","$170",R.drawable.sneaker7));
//    productList.add(new Product("Puma","$140",R.drawable.sneaker8));
//    productList.add(new Product("Nike","$110",R.drawable.sneaker3));
//    productList.add(new Product("Fila","$80",R.drawable.sneaker2));


        productAdapter = new ProductAdapter(this,productList);
        recyclerView.setAdapter(productAdapter);

    }

    private void fetchProductsFromFirestore(){
        db.collection("sneakers")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                String productName = document.getString("Name");
                                String productPrice = document.getString("Price");
                                String productImageUrl = document.getString("Image");

                                productList.add(new Product(productName,productPrice,productImageUrl));
                            }

                        }
                        else{
                            Log.e("Firestore","Error getting documents",task.getException());
                        }

                    }
                });
    }
}
