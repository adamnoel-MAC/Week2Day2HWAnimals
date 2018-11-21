package com.mobileapps.week2day2hw_animals;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AnimalDetails extends AppCompatActivity {

    Context context;
    ArrayList<Animal> list;

    TextView tvAnimalName;
    TextView tvAnimalSpecies;
    ImageView ivAnimalPic;
    TextView tvAnimalHabitat;
    TextView tvAnimalDescLong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        tvAnimalName = findViewById(R.id.tvAnimalName_det);
        tvAnimalSpecies= findViewById(R.id.tvAnimalSpecies_det);
        ivAnimalPic= findViewById(R.id.ivAnimal_det);
        tvAnimalHabitat= findViewById(R.id.tvAnimalHabitat);
        tvAnimalDescLong= findViewById(R.id.tvAnimalDescLong);

        Bundle extrasBundle = getIntent().getBundleExtra("bundle");
        if(extrasBundle != null) {

            String AnimalName = extrasBundle.getString("AnimalName");
            String AnimalNameCk;
            tvAnimalName.setText(AnimalName);

            Log.d("TAG", "onCreate: ");

            list = ;

            for (int i=0; i < list.size(); i++){
                Log.d("TAG", "AnimalDetails onCreate: for loop i: " + i);
                AnimalNameCk = list.get(i).animalName;
                Log.d("TAG", "AnimalDetails onCreate: AnimalNameCk " + AnimalNameCk);
                if (AnimalName != null && AnimalNameCk.compareTo(AnimalName) == 0) {
                    Log.d("TAG", "AnimalDetails onCreate: Found");
                }
            }
        } //Should not get to this activity unless clicking on Animal Pic.
    }
}
