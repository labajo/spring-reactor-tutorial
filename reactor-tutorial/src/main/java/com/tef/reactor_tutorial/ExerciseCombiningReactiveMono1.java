package com.tef.reactor_tutorial;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class ExerciseCombiningReactiveMono1 
{
	
	public static Mono<String> getMonoSample1() {
		return Mono.just("Politicians");
	}
	
	public static Mono<String> getMonoSample2() {
		return Mono.just("Corruption");
	}
	
	public static Mono<String> getMonoSample3(String key) {
		HashMap<String, Mono<String>> hash = new HashMap<String, Mono<String>>();
		hash.put("Politicians", Mono.just("Corruption"));
		hash.put("Veggies", Mono.just("Good"));
		hash.put("Fruits", Mono.just("Yummy"));
		return hash.get(key);
	}
	
    public static void main( String[] args ) throws InterruptedException
    {
    	
//    	Mono.zip(getMonoSample1(),getMonoSample2()).log().doOnTerminate(() -> {
//    		//System.exit(0);
//    	}).subscribe(data -> {
//    		System.out.println(data);
//    	});
    	
//    	getMonoSample1().zipWith(getMonoSample2()).log().doOnTerminate(() -> {
//    		//System.exit(0);
//    	}).subscribe(data -> {
//    		System.out.println(data);
//    	});
    	
    	
//    	getMonoSample1().zipWhen((data1)-> getMonoSample2()).log().doOnTerminate(() -> {
//    		//System.exit(0);
//    	}).subscribe(data -> {
//    		System.out.println(data);
//    	});
    	
    	getMonoSample1().zipWhen((data1)-> getMonoSample3(data1)).log().doOnTerminate(() -> {
		//System.exit(0);
		}).subscribe(data -> {
			System.out.println(data);
		});
    	
    	long start = System.currentTimeMillis();
    	Thread.sleep(3000);
    	System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
    	
    }
}
