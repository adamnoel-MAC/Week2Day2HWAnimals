package com.mobileapps.week2day2hw_animals;

import android.media.Image;

public class Animal {
    String animalName;
    String animalPic;
    String animalDesc;

    public Animal(String animalName, String animalPic, String animalDesc) {
        this.animalName = animalName;
        this.animalPic = animalPic;
        this.animalDesc = animalDesc;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalPic() {
        return animalPic;
    }

    public void setAnimalPic(String animalPic) {
        this.animalPic = animalPic;
    }

    public String getAnimalDesc() {
        return animalDesc;
    }

    public void setAnimalDesc(String animalDesc) {
        this.animalDesc = animalDesc;
    }
}
