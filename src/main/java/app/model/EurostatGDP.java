package app.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class EurostatGDP {
	private double version;
	private String label;
	private String href;
	private String source;
	private Date updated;
	private Map<Integer, Character> status;
	private Extension extension;
	private Map<Integer, Double> value;
	private Dimension dimension;
	private List<String> id;
	private List<Integer> size;

	public static class Extension {
		private String datasetId;
		private String lang;
		private String description;
		private String subTitle;
		private Status status;

		public String getDatasetId() {
			return datasetId;
		}

		public void setDatasetId(String datasetId) {
			this.datasetId = datasetId;
		}

		public String getLang() {
			return lang;
		}

		public void setLang(String lang) {
			this.lang = lang;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getSubTitle() {
			return subTitle;
		}

		public void setSubTitle(String subTitle) {
			this.subTitle = subTitle;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public static class Status {
			private Map<Character, String> label;

			public Map<Character, String> getLabel() {
				return label;
			}

			public void setLabel(Map<Character, String> label) {
				this.label = label;
			}
		}
	}

	public static class Dimension {
		private DimensionElement unit;
		private DimensionElement geo;
		private DimensionElement time;

		public DimensionElement getUnit() {
			return unit;
		}

		public void setUnit(DimensionElement unit) {
			this.unit = unit;
		}

		public DimensionElement getGeo() {
			return geo;
		}

		public void setGeo(DimensionElement geo) {
			this.geo = geo;
		}

		public DimensionElement getTime() {
			return time;
		}

		public void setTime(DimensionElement time) {
			this.time = time;
		}
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public List<String> getId() {
		return id;
	}

	public void setId(List<String> id) {
		this.id = id;
	}

	public List<Integer> getSize() {
		return size;
	}

	public void setSize(List<Integer> size) {
		this.size = size;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Map<Integer, Character> getStatus() {
		return status;
	}

	public void setStatus(Map<Integer, Character> status) {
		this.status = status;
	}

	public Map<Integer, Double> getValue() {
		return value;
	}

	public void setValue(Map<Integer, Double> value) {
		this.value = value;
	}
}
