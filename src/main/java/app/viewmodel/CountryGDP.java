package app.viewmodel;

import java.util.List;

public class CountryGDP implements Comparable<CountryGDP>{
	
	private String name;
	private String code;	
	private List<Double> values;
	
	public CountryGDP(String name, String code, List<Double> values){
		this.name = name;
		if (name.startsWith("Germany")){
			this.name = "Germany";
		}else if (name.startsWith("Former Yugoslav")){
			this.name = "Republic of Macedonia";
		}else if (name.startsWith("European Union")){
			this.name = "European Union";
		}else if (name.startsWith("Euro area")){
			this.name = "Euro area";
		}
		this.values = values;
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	public String getCode(){
		return code;
	}
	public void setCode(String code){
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Double> getValues() {
		return values;
	}


	public void setValues(List<Double> values) {
		this.values = values;
	}

	@Override
	public int compareTo(CountryGDP cGDP) {
		return name.compareTo(cGDP.getName());
	}

}
