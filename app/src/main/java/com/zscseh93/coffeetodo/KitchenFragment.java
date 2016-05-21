package com.zscseh93.coffeetodo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zscseh93.coffeetodo.coffee.Coffee;
import com.zscseh93.coffeetodo.coffee.Kitchen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KitchenFragment extends Fragment {

    private Map<Kitchen, List<Coffee>> mCoffees;

    public KitchenFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCoffees = new HashMap<>();
        mCoffees.put(Kitchen.ITALIAN, new ArrayList<Coffee>());
        mCoffees.put(Kitchen.FRENCH, new ArrayList<Coffee>());
        mCoffees.put(Kitchen.LATINO, new ArrayList<Coffee>());
        mCoffees.put(Kitchen.ARABIC, new ArrayList<Coffee>());
        mCoffees.put(Kitchen.AMERICAN, new ArrayList<Coffee>());
        mCoffees.put(Kitchen.JAPANESE, new ArrayList<Coffee>());
        mCoffees.put(Kitchen.ARCTIC, new ArrayList<Coffee>());

        List<Coffee> coffees = getArguments().getParcelableArrayList(Coffee.KEY);
        assert coffees != null;
        for (Coffee coffee :
                coffees) {
            switch (coffee.getKitchen()) {
                case ITALIAN:
                    mCoffees.get(Kitchen.ITALIAN).add(coffee);
                    break;
                case FRENCH:
                    mCoffees.get(Kitchen.FRENCH).add(coffee);
                    break;
                case LATINO:
                    mCoffees.get(Kitchen.LATINO).add(coffee);
                    break;
                case ARABIC:
                    mCoffees.get(Kitchen.ARABIC).add(coffee);
                    break;
                case AMERICAN:
                    mCoffees.get(Kitchen.AMERICAN).add(coffee);
                    break;
                case JAPANESE:
                    mCoffees.get(Kitchen.JAPANESE).add(coffee);
                    break;
                case ARCTIC:
                    mCoffees.get(Kitchen.ARCTIC).add(coffee);
                    break;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kitchen, container, false);
    }
}
