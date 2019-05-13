package com.tef.reactor_tutorial;

import reactor.core.publisher.Flux;


public class CreatingReactiveFlux3 
{
	
	public static Flux<Integer> getFluxSample1() {
		return Flux.range(1, 5).repeat().take(7);
	}
	
    public static void main( String[] args )
    {
    	Flux<Integer> fluxSample = getFluxSample1();
    	
    	fluxSample.log().doOnComplete(() -> {
    		System.exit(0);
    	}).subscribe(data -> {
    		System.out.println(data);
    	});
    }
}
