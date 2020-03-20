package com.kc.mylearnings.springcloud.microservices.netflizzuulgatewayserver;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NetflizZuulGatewayServerApplication {

	public static void main(String[] args) {

		// Individual instance URL to be exposed via gateway on following URL pattern
		// htt://hostname:{ZUUL-GATEWAY-PORT}/{APPLICATION-NAME}/{URI}
		// http://localhost:8000/currency-exchange/from/USD/to/INR
		// http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR

		SpringApplication.run(NetflizZuulGatewayServerApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
}
