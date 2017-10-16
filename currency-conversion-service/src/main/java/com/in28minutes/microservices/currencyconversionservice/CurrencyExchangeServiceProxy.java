package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//If the currency-exchange-service exposes 100 services all these 100 service declartaion will come in this single proxy file.
//Thus we can use a Single Proxy File to talk to many rest services.

//@FeignClient(name="currency-exchange-service", url="localhost:8000")

//If we give the url in the FeignClient then we can communicate with only one server. Hence moving to application.properties.

@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	//Though the actual retrieveExchangeValue returns a ExchangeValue Object we have used CurrencyConversionBean.
	//Because the propety names in both the ExchangeValue and CurrencyConversionBean are similar.
	//Thats how the mapping happens. 
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);
}
