package com.tef.reactor_tutorial;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


public class ControlFlowReactive1 
{
	
	public static Flux<String> getAllUsers() {
		return Flux.just("Peter", "Charles");
	}
	
	public static Flux<String> getFluxSample2() {
		return Flux.just("Onion", "Garlic", "Lettuce", "Cucumber");
	}
	
	public static Mono<Boolean> deleteItem(String key) {
		return Mono.just(true);
	}
	
	
    public static void main( String[] args ) throws InterruptedException
    {
    	
//    	getAllUsers().flatMap(user -> deleteItem(user)).log().doOnTerminate(() -> {
//    		//System.exit(0);
//    	}).subscribe(data -> {
//    		System.out.println(data);
//    	});
    	
//    	getAllUsers().flatMap(user -> deleteItem(user).thenReturn(user)).log().doOnTerminate(() -> {
//    		//System.exit(0);
//    	}).subscribe(data -> {
//    		System.out.println(data);
//    	});
    	
    	getAllUsers().flatMap(user -> deleteItem(user)).then(Mono.just("OK")).log().doOnTerminate(() -> {
    		System.out.println("Finish");
    	}).subscribe(data -> {
    		System.out.println(data);
    	});
    	
//    	getAllUsers().flatMap(user -> deleteItem(user)).then().log().doOnTerminate(() -> {
//    		System.out.println("Finish");
//    	}).subscribe(data -> {
//    		System.out.println(data);
//    	});
    	
    	long start = System.currentTimeMillis();
    	Thread.sleep(3000);
    	System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
    	
    }
}
