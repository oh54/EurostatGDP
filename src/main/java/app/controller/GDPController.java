package app.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import app.model.EurostatGDP;
import app.viewmodel.EurostatGDPViewModel;

@Controller
public class GDPController {

	@RequestMapping("/greeting")
	public String greeting() {
		return "greeting";
	}
	
	// TODO Use map instead of string for api request parameters
	@RequestMapping("/index")
	public String index(Model model) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String apiUrl = "http://ec.europa.eu/eurostat/wdds/rest/data/v2.1/json/en/";
		String datasetId = "namq_aux_gph";
		
		//String as = "namq_aux_gph?precision=1&sinceTimePeriod=2004Q1&indic_na=RGDPH&s_adj=SCA";
		
		String as = "nama_10_pc?precision=1&na_item=B1GQ&sinceTimePeriod=2004&unit=CP_PPS_HAB";
		
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("precision", "1");
		queryParams.put("sinceTimePeriod", "2004Q1");
		queryParams.put("indic_na", "RGDPH");
		queryParams.put("s_adj", "SCA");

	
		//String webResourceLocation = "http://ec.europa.eu/eurostat/wdds/rest/data/v2.1/json/en/teina010?unit=MIO_EUR_SCA&precision=1&unitLabel=code";
		String apiResponseString = restTemplate.getForObject(apiUrl+as, String.class);
		System.out.println(apiResponseString);
		
		EurostatGDP apiResponse = restTemplate.getForObject(apiUrl+as, EurostatGDP.class);
		
		
		//EurostatGDP apiResponse = restTemplate.getForObject(webResourceLocation, EurostatGDP.class);

		EurostatGDPViewModel vm = new EurostatGDPViewModel(apiResponse);
		
		model.addAttribute("model", vm);
		
		System.out.println("break");
		return "index";
	}

}