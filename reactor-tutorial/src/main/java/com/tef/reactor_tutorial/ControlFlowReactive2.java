package com.tef.reactor_tutorial;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


public class ControlFlowReactive2 
{
	
	public static Mono<String> getUser(String key) {
		return Mono.empty();
	}
	
	
	public static Mono<String> getUser2(String key) {
		return Mono.just("Peter");
	}
	
    public static void main( String[] args ) throws InterruptedException
    {
    	
    	
    	getUser("Peter").switchIfEmpty(
    			Mono.error(new Throwable("Resource not found"))
    	).log()
    	.doOnTerminate(() -> {
    		System.out.println("Finish");
    	}).subscribe(data -> {
    		System.out.println(data);
    	});
    
//    	getUser2("Peter").handle((user, sink )-> {
//    		sink.error(new Throwable("Resource not found"));
//    	})
//    	.doOnTerminate(() -> {
//    		System.out.println("Finish");
//    	}).subscribe(data -> {
//    		System.out.println(data);
//    	});
    	
    	long start = System.currentTimeMillis();
    	Thread.sleep(3000);
    	System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
    	
    }
}
