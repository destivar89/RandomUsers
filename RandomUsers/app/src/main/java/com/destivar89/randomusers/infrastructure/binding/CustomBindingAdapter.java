package com.destivar89.randomusers.infrastructure.binding;


import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBindingAdapter {

    @BindingAdapter("visibility")
    public static void setVisibility(View view, int visibility){
        view.setVisibility(visibility);
    }

    @BindingAdapter("imageresource")
    public static void setImageResource(ImageView imageView, int resource){
        imageView.setImageResource(resource);
    }

    @BindingAdapter("background")
    public static void setBackgound(View view, int resource){
        view.setBackgroundResource(resource);
    }

    @BindingAdapter("textColor")
    public static void setTextColor(TextView textView, int color){
        textView.setTextColor(color);
    }

    @BindingAdapter("layoutmanager")
    public static void setLayoutManager(RecyclerView recyclerView, RecyclerView.LayoutManager layoutManager){
        recyclerView.setLayoutManager(layoutManager);
    }

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter){
        recyclerView.setAdapter(adapter);
    }

}
