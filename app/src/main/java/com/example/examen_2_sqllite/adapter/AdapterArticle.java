package com.example.examen_2_sqllite.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_2_sqllite.R;
import com.example.examen_2_sqllite.entities.Article;

import java.util.ArrayList;

public class AdapterArticle extends RecyclerView.Adapter<AdapterArticle.ViewArticle> {

    private ArrayList<Article> list_articles;

    public AdapterArticle(ArrayList<Article> list_article) {
        this.list_articles = list_article;
    }

    @NonNull
    @Override
    public ViewArticle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.article, null, false
        );
        return new ViewArticle(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewArticle holder, int position) {
        Article article = this.list_articles.get(position);
        holder.set_data(article);
    }

    @Override
    public int getItemCount() {
        return list_articles.size();
    }


    // =====================================================================================
    // =====================================================================================
    // =====================================================================================

    public class ViewArticle extends RecyclerView.ViewHolder {

        ImageView imageView_article;
        TextView textView_nameArticle, textView_brand, textView_cost, textView_amount;


        public ViewArticle(@NonNull View itemView) {
            super(itemView);
            init_components(itemView);
        }

        private void init_components(View itemView) {
            imageView_article = itemView.findViewById(R.id.imageView_article);
            textView_nameArticle = itemView.findViewById(R.id.textView_nameArticle);
            textView_brand = itemView.findViewById(R.id.textView_brand);
            textView_cost = itemView.findViewById(R.id.textView_cost);
            textView_amount = itemView.findViewById(R.id.textView_amount);
        }

        public void set_data(Article article) {
            // create set img method
            textView_nameArticle.setText(article.getName());
            textView_brand.setText(article.getBrand());
            textView_cost.setText("$ " + article.getCost());
            textView_amount.setText("unidades: " + String.valueOf(article.getAmount()));
        }
    }
}
