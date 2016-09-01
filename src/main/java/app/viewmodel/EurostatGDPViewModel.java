package app.viewmodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import app.model.EurostatGDP;

public class EurostatGDPViewModel {

	private String[] timeLabels;
	private List<CountryGDP> countryGDPs;
	private String chartLabel;
	private String yLabel;

	public EurostatGDPViewModel(EurostatGDP apiResponse) {
		Map<String, Integer> timeMap = apiResponse.getDimension().getTime().getCategory().getIndex();
		timeLabels = timeMap.keySet().toArray(new String[timeMap.size()]);
		Arrays.sort(timeLabels);

		yLabel = apiResponse.getDimension().getUnit().getCategory().getLabel().values().toArray()[0].toString();
		
		chartLabel = apiResponse.getLabel() + " (" + yLabel + ")";

		Map<Integer, Double> indexValueMap = apiResponse.getValue();

		Map<String, Integer> countryIndices = apiResponse.getDimension().getGeo().getCategory().getIndex();

		String[] countryCodes = countryIndices.keySet().toArray(new String[countryIndices.size()]);
		Arrays.sort(countryCodes);

		Map<String, String> countriesShortVerboseMap = apiResponse.getDimension().getGeo().getCategory().getLabel();

		int i = 0;

		countryGDPs = new ArrayList<CountryGDP>();

		for (String countryCode : countryCodes) {
			String name = countriesShortVerboseMap.get(countryCode);

			if (name.startsWith("Euro area") && !name.startsWith("Euro area (19 countries)")
					|| name.startsWith("European Union") && !name.startsWith("European Union (28 countries)")) {
				i += timeLabels.length;
				continue;
			}

			List<Double> values = new ArrayList<Double>();

			for (int j = i; j < i + timeLabels.length; j++) {
				values.add(indexValueMap.get(j));
			}
			i += timeLabels.length;
			countryGDPs.add(new CountryGDP(name, countryCode, values));
		}
		Collections.sort(countryGDPs);
	}

	public String[] getTimeLabels() {
		return timeLabels;
	}

	public void setTimeLabels(String[] timeLabels) {
		this.timeLabels = timeLabels;
	}

	public List<CountryGDP> getCountryGDPs() {
		return countryGDPs;
	}

	public void setCountryGDPs(List<CountryGDP> countryGDPs) {
		this.countryGDPs = countryGDPs;
	}

	public void setChartLabel(String chartLabel) {
		this.chartLabel = chartLabel;
	}

	public String getChartLabel() {
		return chartLabel;
	}

	public String getyLabel() {
		return yLabel;
	}

	public void setyLabel(String yLabel) {
		this.yLabel = yLabel;
	}

}
