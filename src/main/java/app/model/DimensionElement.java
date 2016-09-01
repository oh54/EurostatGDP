package app.model;

import java.util.Map;

public class DimensionElement {
	private String label;
	private Category category;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static class Category {
		private Map<String, Integer> index;
		private Map<String, String> label;

		public Map<String, Integer> getIndex() {
			return index;
		}

		public void setIndex(Map<String, Integer> index) {
			this.index = index;
		}

		public Map<String, String> getLabel() {
			return label;
		}

		public void setLabel(Map<String, String> label) {
			this.label = label;
		}
	}
}