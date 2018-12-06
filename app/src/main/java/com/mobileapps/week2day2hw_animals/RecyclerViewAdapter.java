package com.mobileapps.week2day2hw_animals;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class RecyclerViewAdapter extends Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<Animal> list;

    public RecyclerViewAdapter(Context context, ArrayList<Animal> passedList) {
        this.context = context;
        this.list = passedList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder viewHolder = new ViewHolder(inflater.inflate(R.layout.animal, viewGroup,false));
        View itemView = inflater.inflate(R.layout.activity_main, viewGroup, false);
        return viewHolder;
    }

    public Context getContext() {
        return context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView tvAnimalName;
        ImageView ivAnimalPic;
        TextView tvAnimalDesc;
        Animal thisItemsAnimal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            tvAnimalName = itemView.findViewById(R.id.tvAnimalName);
            ivAnimalPic = itemView.findViewById(R.id.ivAnimal);
            tvAnimalDesc = itemView.findViewById(R.id.tvAnimalDesc);

        }

        public void setAnimal(Animal animal) {
            this.thisItemsAnimal = animal;
        }

        public Animal getThisItemsAnimal() {
            return thisItemsAnimal;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        final Context context = getContext();
        //int id = 1;
        //((ImageView)v.findViewById(R.id.ivAnimal)).setImageResource(id);
        String check = list.get(i).animalPic;
        Log.d("TAG", "onBindViewHolder: Pic check: " + check);
        //int id = c.getResources().getIdentifier(check, "drawable", c.getPackageName());

        //Log.d("TAG", "onBindViewHolder: ResourceID: " + id);
        //Resources rs = context.getResources();
        //int resId = rs.getIdentifier("@drawable/"+list.get(i).animalPic);
        //int resId = rs.getIdentifier("dog_3277416_960_720", "drawable", get);

        viewHolder.tvAnimalName.setText(list.get(i).animalName);
        int id = context.getResources().getIdentifier(list.get(i).animalPic, "drawable", context.getPackageName());
        viewHolder.ivAnimalPic.setImageResource(id);
        viewHolder.tvAnimalDesc.setText(list.get(i).animalDesc);

        viewHolder.setAnimal(list.get(i));

        viewHolder.ivAnimalPic.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent sendIntent = new Intent(context.getApplicationContext(), AnimalDetails.class);
                Bundle sbundle = new Bundle();

                //sbundle.putString("AnimalName",name);
                Animal thisAnimal = viewHolder.thisItemsAnimal;
                Log.d("TAG", "onClick--ivAnimalPic: name: " + thisAnimal.getAnimalName());
                sbundle.putParcelable("animal", thisAnimal);

                sendIntent.putExtra("bundle", sbundle);
                context.getApplicationContext().startActivity(sendIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}