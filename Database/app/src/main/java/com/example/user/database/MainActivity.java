package com.example.user.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.user.database.model.ProductModel;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createProduct();
        getAllProduct();
        updateProducts();
        getAllProduct();

    }

    private void createProduct(){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        //Set values to model
       ProductModel productModel = realm.createObject(ProductModel.class);
       productModel.setSku("1234");
       productModel.setName("Gatito lindo");
       productModel.setPrice(1000);

        realm.commitTransaction();
    }

    private void getAllProduct(){
        Realm realm = Realm.getDefaultInstance();

        RealmQuery<ProductModel> query = realm.where(ProductModel.class);
        RealmResults<ProductModel> results = query.findAll();

        for(ProductModel productModel : results){

            Log.i("Name:",productModel.getName());
            Log.i("SKU:",productModel.getSku());
            Log.i("Price:", String.valueOf(productModel.getPrice()));

        }

    }
     private void updateProducts() {
         Realm realm = Realm.getDefaultInstance();

         RealmQuery<ProductModel> query = realm.where(ProductModel.class);
         RealmResults<ProductModel> results = query.findAll();

         for (ProductModel productModel : results) {
             updateProduct(productModel);
         }
     }

     private void updateProduct(ProductModel productModel){
         Realm realm = Realm.getDefaultInstance();

         realm.beginTransaction();
         productModel.setName("Dog lindo");
         realm.commitTransaction();
     }

}
