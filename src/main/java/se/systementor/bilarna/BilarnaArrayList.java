package se.systementor.bilarna;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

import se.systementor.bilarna.models.Car;

public class BilarnaArrayList {

    private static ArrayList<Car> arrayList = new ArrayList<Car>();

    public void add(Car car){
        arrayList.add(car);
    }
    
    public Car search(String regno){
        return getCarByRegnoShortcut(regno);
    } 

    private Car getCarByRegnoShortcut(String regno){
		for(Car car : arrayList)	{
			if(car.getRegno().equals(regno)){
				return car;					
			}
		}
		return null;
	}


	private Car getCarByRegno(String regno){
		Car result = null;
		for(Car car : arrayList)	{
			if(car.getRegno().equals(regno)){
				result = car;					
			}
		}
		return result;
	}

}
