package com.destivar89.randomusers.infrastructure.binding;


import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.destivar89.randomusers.presentation.common.utils.EndlessScrollListener;
import com.squareup.picasso.Picasso;

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

    @BindingAdapter("itemtouchhelper")
    public static void setItemTouchHelper(RecyclerView recyclerView, ItemTouchHelper itemTouchHelper){
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @BindingAdapter("scrolllistener")
    public static void setAdapter(RecyclerView recyclerView, EndlessScrollListener scrollListener){
        recyclerView.addOnScrollListener(scrollListener);
    }

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String thumbUrl){
        if ( thumbUrl == null || thumbUrl.isEmpty() ) return;
        Picasso.with(imageView.getContext())
                .load( thumbUrl )
                .noFade()
                .into(imageView);
    }
}
