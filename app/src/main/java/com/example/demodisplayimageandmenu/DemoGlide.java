package com.example.demodisplayimageandmenu;

import static android.content.ContentValues.TAG;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;

public class DemoGlide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_glide);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Glide.with(this)
                .load("https://vntalking.com/wp-content/uploads/2019/04/hoc-react-native-tu-co-ban.png")
                .into(imageView);

        Glide.with(this)
                .load("https://vntalking.com/wp-content/uploads/2019/04/hoc-react-native-tu-co-ban.png")
                .override(800, 200).centerCrop()
                .into(imageView);
//
        Glide.with(this)
                .load("https://vntalking.com/wp-content/uploads/2019/04/hoc-react-native-tu-co-ban.png")
                .override(800, 200).fitCenter()
                .into(imageView);
//
        Glide.with(this)
                .load("https://media.giphy.com/media/duzpaTbCUy9Vu/giphy.gif").override(800,800).fitCenter()
                .into(imageView);
//
        Glide.with(this)
                .load("https://media.giphy.com/media/duzpaTbCUy9Vu/giphy.gi") // Đường dẫn URL của ảnh
                .override(800, 800) // Thiết lập kích thước ảnh
                .fitCenter()
                .placeholder(R.drawable.baseline_account_box_24)// Căn chỉnh ảnh theo khung hình
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, @Nullable Object model, @NonNull Target<Drawable> target, boolean isFirstResource) {
                        // Xử lý khi có lỗi xảy ra trong quá trình tải ảnh
                        Log.e(TAG, "Error loading image", e);

                        return false; // Trả về false để Glide xử lý tiếp
                    }

                    @Override
                    public boolean onResourceReady(@NonNull Drawable resource, @NonNull Object model, Target<Drawable> target, @NonNull DataSource dataSource, boolean isFirstResource) {
                        Log.d(TAG, "Image loaded successfully");
                        return false; // Trả về false để Glide xử lý tiếp
                    }


                })
                .into(imageView); // Hiển thị ảnh vào ImageView có id là imageView (thay imageView bằng ID của ImageView của bạn)
//


    }
}