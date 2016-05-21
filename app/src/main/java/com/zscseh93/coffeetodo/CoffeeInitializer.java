package com.zscseh93.coffeetodo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zscseh93.coffeetodo.coffee.Coffee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoffeeInitializer {

    public ArrayList<Coffee> readCoffees(InputStream source) {

        String jsonSource = readFromStream(source);

        Gson gson = new Gson();
        Type collectionType = new TypeToken<ArrayList<Coffee>>(){}.getType();
        return gson.fromJson(jsonSource, collectionType);
    }

    private String readFromStream(InputStream stream) {
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return writer.toString();
    }
}
