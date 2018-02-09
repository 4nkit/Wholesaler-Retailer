package com.example.ankit.KandC;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    //this context we will use to inflate the layout
    public Context mCtx;
//add a;
//    DatabaseReference databasepBrand;

    //we are storing all the products in a list
    private List<Product> productList;
//    List<String> keyList;
//    DatabaseReference myref ;
//    DatabaseReference mychild,mlike,mcheck;

    //getting the context and product list with constructor
    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_products, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        final Product product = productList.get(position);

        //myref = FirebaseDatabase.getInstance().getReference().child("Adidas").child("T-shirt");
//        final String key = keyList.get(position).toString();
        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getpName());
        holder.textViewShortDesc.setText(product.getpDescription());
        holder.textViewPrice.setText(String.valueOf(product.getpPrice()));
        Glide.with(mCtx.getApplicationContext()).load(String.valueOf(product.getImgurl())).into(holder.imageView);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //   myref.child(productList.toString()).removeValue();
            }
        });
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewPrice;
        ImageView imageView;
        ImageButton delete;

        public ProductViewHolder(final View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
            delete = itemView.findViewById(R.id.delete);
        }

    }
}

