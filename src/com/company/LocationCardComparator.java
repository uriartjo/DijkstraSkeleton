package com.company;

import java.util.Comparator;

public class LocationCardComparator implements Comparator<LocationCard> {
    @Override
    public int compare(LocationCard o1, LocationCard o2) {
        return o1.getTotalDistance().compareTo(o2.getTotalDistance());
    }
}
