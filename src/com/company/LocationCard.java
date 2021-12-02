package com.company;

import java.util.ArrayList;

public class LocationCard {
    private String location;
    private LocationCard prevLocation;
    private Integer totalDistance;
    private ArrayList<LocationCard> attachedLocations;

    public LocationCard(String location) {
        this.location = location;
        totalDistance = 0;
        attachedLocations = new ArrayList<>();
        if(!Data.getLocationCardList().containsKey(location)) {
            Data.addLocationCardToList(this);
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocationCard getPrevLocation() {
        return prevLocation;
    }

    public void setPrevLocation(LocationCard prevLocation) {
        this.prevLocation = prevLocation;
    }

    public Integer getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
    }

    public ArrayList<LocationCard> getAttachedLocations() {
        return attachedLocations;
    }

    public void addAttachedLocation(String locationToAdd, Integer distance) {
        LocationCard newLocation = Data.getLocationCardList().get(locationToAdd);
        if(newLocation != null) {
            attachedLocations.add(newLocation);
            Data.addNewLocationDistancePair(this.location,locationToAdd,distance);
            Data.addNewLocationDistancePair(locationToAdd,this.location,distance);
        }
        else {
            System.out.println("Unable to attach requested location to this spot.");
        }

    }
}
