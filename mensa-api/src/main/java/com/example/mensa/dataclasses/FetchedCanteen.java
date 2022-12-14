package com.example.mensa.dataclasses;

import com.example.mensa.dataclasses.interfaces.FetchedOpeningHours;
import com.example.mensa.dataclasses.enums.FetchedFoodProviderType;
import com.example.mensa.dataclasses.enums.Location;
import com.example.mensa.dataclasses.interfaces.FetchedFoodProvider;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class FetchedCanteen implements FetchedFoodProvider {
    private final String name;
    private Location location;
    private final String info;
    private final List<FetchedOpeningHours> fetchedOpeningHours;
    private final String additional;

    private final String linkToFoodPlan;

    private final String linkToMoreInfo;
    private final List<FetchedDay> menusPerFetchedDay;

    private String description;

    private String address;

    public FetchedCanteen(
            String name,
            Location location,
            String info,
            List<FetchedOpeningHours> fetchedOpeningHours,
            String additional,
            String linkToMoreInfo,
            String linkToFoodPlan,
            List<FetchedDay> menusPerFetchedDay,
            String description,
            String address
    ) {
        this.name = name;
        this.location = location;
        this.info = info;
        this.fetchedOpeningHours = fetchedOpeningHours;
        this.additional = additional;
        this.linkToFoodPlan = linkToFoodPlan;
        this.linkToMoreInfo = linkToMoreInfo;
        this.menusPerFetchedDay = menusPerFetchedDay;
        this.description = description;
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public String getTitleInfo() {
        return info;
    }

    @Override
    public List<FetchedOpeningHours> getOpeningHours() {
        return fetchedOpeningHours;
    }

    @Override
    public String getBodyInfo() {
        return additional;
    }

    @Override
    public String getLinkToFoodPlan() {
        return linkToFoodPlan;
    }

    @Override
    public String getLinkToMoreInformation() {
        return linkToMoreInfo;
    }

    @Override
    public List<FetchedDay> getMenus() {
        return menusPerFetchedDay;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public Optional<FetchedDay> getMenuOfDay(LocalDate date) {
        return menusPerFetchedDay.stream().filter(menu -> menu.getDate().equals(date)).findFirst();
    }

    @Override
    public FetchedFoodProviderType getType() {
        return FetchedFoodProviderType.CANTEEN;
    }

    @Override
    public String toString() {
        return "Canteen{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", info='" + info + '\'' +
                ", openingHours=" + fetchedOpeningHours +
                ", additional='" + additional + '\'' +
                ", linkToFoodPlan=" + linkToFoodPlan +
                ", meals=" + menusPerFetchedDay +
                "}\n";
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }
}
