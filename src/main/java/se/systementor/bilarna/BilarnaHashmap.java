package se.systementor.bilarna;

import java.util.ArrayList;
import java.util.HashMap;

import se.systementor.bilarna.models.Car;

public class BilarnaHashmap {
        private static HashMap<String,Car> hashMap = new HashMap<>();

        public void add(Car car){
            hashMap.put(car.getRegno(), car);
        }

        public Car search(String regno){
            return hashMap.get(regno);
        } 
    
    
    
}
