package com.kimjio.dgitdroid.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public final class BindingHelper {

    private BindingHelper() {
    }

    @BindingAdapter("srcUrl")
    public static void setDrawable(ImageView view, String url) {
        Picasso.get().load(url).into(view);
    }
}
