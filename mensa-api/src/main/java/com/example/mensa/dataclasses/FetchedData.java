package com.example.mensa.dataclasses;

import com.example.mensa.dataclasses.enums.FetchedFoodProviderType;
import com.example.mensa.dataclasses.interfaces.FetchedFoodProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FetchedData {
    List<FetchedFoodProvider> fetchedFoodProviders;

    public FetchedData() {
        this.fetchedFoodProviders = new ArrayList<>();
    }

    public List<FetchedCanteen> getFetchedCanteens() {
        return fetchedFoodProviders.stream()
                .filter(fetchedFoodProvider -> fetchedFoodProvider.getType() == FetchedFoodProviderType.CANTEEN)
                .map(FetchedCanteen.class::cast)
                .collect(Collectors.toList());
    }

    public void addFetchedCanteen(FetchedFoodProvider fetchedCanteen) {
        this.fetchedFoodProviders.add(fetchedCanteen);
    }

    public List<FetchedCafeteria> getFetchedCafeterias() {
        return fetchedFoodProviders.stream()
                .filter(fetchedFoodProvider -> fetchedFoodProvider.getType() == FetchedFoodProviderType.CAFETERIA)
                .map(FetchedCafeteria.class::cast)
                .collect(Collectors.toList());
    }

    public void addFetchedCafeteria(FetchedFoodProvider fetchedCafeteria) {
        this.fetchedFoodProviders.add(fetchedCafeteria);
    }

    public List<FetchedFoodProvider> getFetchedFoodProviders() {
        return fetchedFoodProviders;
    }

    public boolean isEmpty() {
        return fetchedFoodProviders.isEmpty();
    }
}
