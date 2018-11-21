package com.mobileapps.week2day2hw_animals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

RecyclerView rvRecyclerView;
TextView tvAnimalName;
Animal animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRecyclerView = findViewById(R.id.rvRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this,getAnimals());

        rvRecyclerView.setLayoutManager(layoutManager);
        rvRecyclerView.setAdapter(recyclerViewAdapter);

    }

    public ArrayList<Animal> getAnimals() {
        ArrayList<Animal> returnList = new ArrayList<>();
        returnList.add(new Animal("Dog", "dog_3277416_960_720","This is a dog."));
        returnList.add(new Animal("Cat", "cat_2068462_960_720","This is a cat."));
        returnList.add(new Animal("Bird", "dog_3277416_960_720","A"));
        returnList.add(new Animal("Snake", "cat_2068462_960_720","A"));
        returnList.add(new Animal("Fish", "dog_3277416_960_720","B"));
        returnList.add(new Animal("Hamster", "cat_2068462_960_720","A"));
        return returnList;
    }


    public void ivClick(View view) {

        tvAnimalName = findViewById(R.id.tvAnimalName);
        String name = tvAnimalName.getText().toString();
        Log.d("TAG", "ivClick: name: " + name);

        Intent sendIntent = new Intent(this, AnimalDetails.class);
        Bundle sbundle = new Bundle();

        sbundle.putString("AnimalName",name);
        sbundle.putSerializable("animal", getThisItemsAnimal());

        sendIntent.putExtra("bundle", sbundle);
        startActivity(sendIntent);
        finish();
    }
}
