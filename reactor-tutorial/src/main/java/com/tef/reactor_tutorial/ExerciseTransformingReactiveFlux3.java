package com.tef.reactor_tutorial;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class ExerciseTransformingReactiveFlux3 
{
	
	public static Flux<String> getFluxSample1() {
		return Flux.just("Peter", "Charles");
	}
	
	public static Flux<String> getFluxSample2() {
		return Flux.just("Onion", "Garlic", "Lettuce", "Cucumber");
	}
	
    public static void main( String[] args ) throws InterruptedException
    {
    	Flux<String> users = getFluxSample1();
    	Flux<String> veggies = getFluxSample2();
    	
    	// Peter hates Onion
    	// Peter hates Garlic
    	// .......
    	// Charles hates Onion
    	// ........
    	
    	users.flatMap(userStr -> veggies.map(veggie -> userStr + " hates " + veggie)).log().doOnComplete(() -> {
    		//System.exit(0);
    	}).subscribe(data -> {
    		System.out.println(data);
    	});
    	
    	
    	
    	long start = System.currentTimeMillis();
    	Thread.sleep(3000);
    	System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
    	
    }
}
