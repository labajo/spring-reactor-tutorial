package com.tef.reactor_tutorial;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


public class TransformingReactiveFlux4 
{
	
	public static Mono<String> getFluxSample1() {
		return Mono.just("Peter");
	}
	
	public static Flux<String> getFluxSample2() {
		return Flux.just("Onion", "Garlic", "Lettuce", "Cucumber");
	}
	
    public static void main( String[] args ) throws InterruptedException
    {
    	Mono<String> user = getFluxSample1();
    	Flux<String> veggies = getFluxSample2();
    	
    	// Peter hates Onion
    	// Peter hates Garlic
    	// .......
    	
//    	veggies.flatMap(veggie ->  user.map(userStr -> userStr + " hates " + veggie).subscribeOn(Schedulers.parallel())).log().doOnComplete(() -> {
//    		//System.exit(0);
//    	}).subscribe(data -> {
//    		System.out.println(data);
//    	});
    	
    	
    	user.flatMapMany(userStr -> veggies.map(veggie -> userStr + " hates " + veggie).subscribeOn(Schedulers.newSingle("my-thread"))).log().doOnComplete(() -> {
    		//System.exit(0);
    	}).subscribe(data -> {
    		System.out.println(data);
    	});
//    	
    	
    	
    	long start = System.currentTimeMillis();
    	Thread.sleep(3000);
    	System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
    	
    }
}
