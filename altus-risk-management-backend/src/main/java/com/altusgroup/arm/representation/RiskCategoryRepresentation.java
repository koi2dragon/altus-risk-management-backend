package com.altusgroup.arm.representation;


/**
 * 
 * @author hitokiri
 *
 */
public class RiskCategoryRepresentation extends AbstractRepresetationalEntity {

	private String label;
	private String description;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
