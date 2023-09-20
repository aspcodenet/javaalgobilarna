package se.systementor.bilarna;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import se.systementor.bilarna.models.Car;

@SpringBootApplication
public class BilarnaApplication implements CommandLineRunner {
    private static Random random = new Random();   


	public static void main(String[] args) {
		SpringApplication.run(BilarnaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		var algo = new BilarnaHashmap();
		String searchPlace1000 = "";
		String searchPlace9999999 = "";

		Instant start = Instant.now();
        for(int i = 0; i < 10000000;i++){
			var car =generateCar(); 
			algo.add(car);
			if(i == 1000){
				searchPlace1000 = car.getRegno();
			}
			if(i == 9_999_999){
				searchPlace9999999 = car.getRegno();
			}
			
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println(timeElapsed);


		
        start = Instant.now();
		var find = algo.search(searchPlace1000);
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Hitta på plats 1000:" +  timeElapsed);

		
        start = Instant.now();
		find = algo.search(searchPlace9999999);
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Hitta på plats 9999999:" +  timeElapsed);

        
	}




	private Car generateCar() {
        var car = new Car();
        var number =  String.valueOf(random.nextInt(100,999));

        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < 3; i++){
            number = number + abc.charAt(random.nextInt(abc.length()));
        }

        car.setRegno(number);
        return car;
    }



}
