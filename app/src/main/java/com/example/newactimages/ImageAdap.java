package com.example.newactimages;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;

public class ImageAdap extends RecyclerView.Adapter<ImageAdap.ViewHolder> {

    Context context;
    int[] image;
    String[] names;

    public ImageAdap(Context context, int[] image, String[] names) {
        this.context = context;
        this.image = image;
        this.names = names;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageHolder;
        TextView nameHolder;
        Button buttonHolder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageHolder = itemView.findViewById(R.id.imageView);
            nameHolder = itemView.findViewById(R.id.textView2);
            buttonHolder = itemView.findViewById(R.id.button);

            buttonHolder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, NewActivity.class);

                    i.putExtra("NAME", nameHolder.getText().toString());

                    int ResiD = image[getPosition()];

                    Bitmap bmp = BitmapFactory.decodeResource(imageHolder.getResources(), ResiD);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] byteArray = stream.toByteArray();

                    i.putExtra("IMAGE", byteArray);

                    context.startActivity(i);
                }
            });

        }


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.image_layout,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageHolder.setBackgroundResource(image[position]);
        holder.nameHolder.setText(names[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }


}
