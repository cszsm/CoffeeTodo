package com.zscseh93.coffeetodo;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zscseh93.coffeetodo.coffee.Coffee;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static String LOG_TAG = MainActivity.class.getName();

    private MenuType mMenuType;

    private KitchenFragment mKitchenFragment;
    private CupFragment mCupFragment;
    private FloatingActionButton mMenuChangerButton;

    private ArrayList<Coffee> mCoffees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CoffeeInitializer coffeeInitializer = new CoffeeInitializer();
        InputStream jsonFile = getResources().openRawResource(R.raw.coffees);
        mCoffees = coffeeInitializer.readCoffees(jsonFile);

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Coffee.KEY, mCoffees);

        mKitchenFragment = new KitchenFragment();
        mKitchenFragment.setArguments(bundle);
        mCupFragment = new CupFragment();
        mCupFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.categories, mKitchenFragment)
                .commit();
        mMenuType = MenuType.KITCHEN;

        mMenuChangerButton = (FloatingActionButton) findViewById(R.id.menu_changer_button);
        assert mMenuChangerButton != null;
        mMenuChangerButton.setImageResource(R.drawable.ic_cup);
        mMenuChangerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMenuType();
            }
        });

        for (Coffee coffee :
                mCoffees) {
            Log.d(LOG_TAG, coffee.getName());
        }

//        Set<Coffee> coffees = new HashSet<>();
//        coffees.add(new Coffee("it_01", "Espresso Italiano", Kitchen.ITALIAN, Cup.GREEN));
//        coffees.add(new Coffee("it_02", "Milánói espresso", Kitchen.ITALIAN, Cup.GREEN));
//        coffees.add(new Coffee("it_06", "Cappuccino", Kitchen.ITALIAN, Cup.ORANGE));
//        coffees.add(new Coffee("fr_03", "Bécsi kapucíner", Kitchen.FRENCH, Cup.ORANGE));
//        coffees.add(new Coffee("la_01", "Kubai espresso", Kitchen.LATINO, Cup.GREEN));
//        coffees.add(new Coffee("ar_01", "Arab kávé - gahwa", Kitchen.ARABIC, Cup.OTHER));
//        coffees.add(new Coffee("am_06", "Miami beach-i vanília latte", Kitchen.AMERICAN, Cup
// .GLASS));
//        coffees.add(new Coffee("jp_02", "Tokiói csokoládés málna", Kitchen.JAPANESE, Cup.OTHER));
//        coffees.add(new Coffee("ar_01", "Cannes-i fagylaltkávé", Kitchen.ARCTIC, Cup.ICE));

//        Gson gson = new Gson();
//        String json = gson.toJson(coffees);
//        Log.d(LOG_TAG, json);
    }

    private void changeMenuType() {
        Log.d(LOG_TAG, "changeMenuType");
        if (mMenuType == MenuType.KITCHEN) {
            changeMenuToCup();
        } else {
            changeMenuToKitchen();
        }
    }

    private void changeMenuToKitchen() {
        Log.d(LOG_TAG, "changeMenuToKitchen");
        getSupportFragmentManager().beginTransaction().replace(R.id.categories, mKitchenFragment)
                .commit();
        mMenuType = MenuType.KITCHEN;
        mMenuChangerButton.setImageResource(R.drawable.ic_cup);
    }

    private void changeMenuToCup() {
        Log.d(LOG_TAG, "changeMenuToCup");
        getSupportFragmentManager().beginTransaction().replace(R.id.categories, mCupFragment)
                .commit();
        mMenuType = MenuType.CUP;
        mMenuChangerButton.setImageResource(R.drawable.ic_explore);
    }

    private enum MenuType {
        KITCHEN,
        CUP
    }
}
