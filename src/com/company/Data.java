package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Data {
    private static ArrayList<String> locationsList;
    private static HashMap<String,LocationCard> locationCardList;
    private static HashMap<String, Integer> locationDistances;
    private static PriorityQueue<LocationCard> dijkstraPQ;

    public static void prepareDataStructures() {
        locationsList = new ArrayList<>();
        locationCardList = new HashMap<>();
        locationDistances = new HashMap<>();
        dijkstraPQ = new PriorityQueue<>(new LocationCardComparator());
    }

    public static void createLocationCards() {
        LocationCard chapel = new LocationCard("Chapel");
        LocationCard mariani = new LocationCard("Mariani");
        LocationCard cohen = new LocationCard("Cohen");
        LocationCard performingArts = new LocationCard("Performing Arts");
        LocationCard athletics = new LocationCard("Athletics");

        chapel.addAttachedLocation(mariani.getLocation(),3);
        mariani.addAttachedLocation(cohen.getLocation(), 1);
        mariani.addAttachedLocation(performingArts.getLocation(), 1);
        performingArts.addAttachedLocation(athletics.getLocation(), 2);
    }
    

    public static ArrayList<String> getLocationsList() {
        return locationsList;
    }

    public static void setLocationsList(ArrayList<String> locationsList) {
        Data.locationsList = locationsList;
    }

    public static HashMap<String, LocationCard> getLocationCardList() {
        return locationCardList;
    }

    public static void addLocationCardToList(LocationCard locationCard) {
        locationCardList.put(locationCard.getLocation(),locationCard);
    }

    public static HashMap<String, Integer> getLocationDistances() {
        return locationDistances;
    }

    public static void addNewLocationDistancePair(String locationA, String locationB, Integer distance) {
        locationDistances.put(locationA+locationB,distance);
        locationDistances.put(locationB+locationA,distance);
    }

    public static PriorityQueue<LocationCard> getDijkstraPQ() {
        return dijkstraPQ;
    }

    public static void addToDijkstraPQ(LocationCard locationCard) {
        dijkstraPQ.add(locationCard);
    }
}
