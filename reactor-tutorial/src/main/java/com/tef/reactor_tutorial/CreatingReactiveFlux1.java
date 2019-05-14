package com.tef.reactor_tutorial;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;


public class CreatingReactiveFlux1 
{
	
	public static Flux<String> getFluxSample1() {
		return Flux.just("Apple", "Orange", "Grape", "Strawberry");
	}
	
    public static void main( String[] args ) throws InterruptedException
    {
    	Flux<String> fluxSample = getFluxSample1();
    	
    	fluxSample.log().doOnTerminate(() -> {
    		System.exit(0);
    	}).subscribe(data -> {
    		System.out.println(data);
    	});
    	
    }
}
