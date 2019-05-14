package com.tef.reactor_tutorial;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Mono;


public class ExerciseCreatingMono2 
{
	
	public static Mono<List<String>> getMonoSample1() {
		List<String> fruits = new ArrayList<>();
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Grape");
		fruits.add("Strawberry");
		return Mono.just(fruits);
	}
	
    public static void main( String[] args ) throws InterruptedException
    {
    	Mono<List<String>> monoSample = getMonoSample1().delayElement(Duration.ofMillis(2500));;
    	
    	monoSample.log().doOnTerminate(() -> {
    		//System.exit(0);
    	}).subscribe(data -> {
    		System.out.println(data);
    	});
    	
    	
    	long start = System.currentTimeMillis();
    	Thread.sleep(3000);
    	System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
    }
}
