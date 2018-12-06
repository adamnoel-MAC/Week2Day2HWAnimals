package com.mobileapps.week2day2hw_animals;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    String animalName;
    String animalPic;
    String animalDesc;

    public Animal(String animalName, String animalPic, String animalDesc) {
        this.animalName = animalName;
        this.animalPic = animalPic;
        this.animalDesc = animalDesc;
    }

    protected Animal(Parcel in) {
        animalName = in.readString();
        animalPic = in.readString();
        animalDesc = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(animalName);
        dest.writeString(animalPic);
        dest.writeString(animalDesc);
    }
}
