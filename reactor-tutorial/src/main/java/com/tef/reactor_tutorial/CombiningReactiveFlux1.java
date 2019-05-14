package com.tef.reactor_tutorial;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;


public class CombiningReactiveFlux1 
{
	
	public static Flux<String> getFluxSample1() {
		return Flux.just("Apple", "Orange", "Grape", "Strawberry", "Pinneapple", "Lemon", "Watermelon", "Banana", "Cherry");
	}
	
	public static Flux<String> getFluxSample2() {
		return Flux.just("Onion", "Garlic", "Lettuce", "Cucumber");
	}
	
    public static void main( String[] args ) throws InterruptedException
    {
    	Flux<String> fruits = getFluxSample1().delayElements(Duration.ofMillis(250)).delaySubscription(Duration.ofMillis(260));
    	Flux<String> veggies = getFluxSample2().delayElements(Duration.ofMillis(500));
    	
    	fruits.mergeWith(veggies).log().doOnTerminate(() -> {
    		System.exit(0);
    	}).subscribe(data -> {
    		System.out.println(data);
    	});
    	
    	long start = System.currentTimeMillis();
    	Thread.sleep(3000);
    	System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
    	
    }
}
