package com.example.android.visitsommieres;

/**
 * Created by JamieC on 02/04/2018.
 */

public class Items {

    private int imageResourceID;
    private String nameOfAttraction, shortdesc, moreInfo, gMapsLocation;

    public Items (int imageResourceID, String gMapsLocation, String nameOfAttraction,
                  String shortdesc, String moreInfo) {

        this.imageResourceID = imageResourceID;
        this.gMapsLocation = gMapsLocation;
        this.nameOfAttraction = nameOfAttraction;
        this.shortdesc = shortdesc;
        this.moreInfo = moreInfo;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public String getgMapsLocation() {
        return gMapsLocation;
    }

    public String getNameOfAttraction() {
        return nameOfAttraction;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public String getMoreInfo() {
        return moreInfo;
    }
}




