package com.altusgroup.arm.representation;

import java.net.URI;

import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author hitokiri
 *
 */
public class LevelRepresentation extends AbstractRepresetationalEntity {

	private String label;
	private String description;

	@InjectLink(value = "{value}/${instance.id}/categories", 
			bindings = {  @Binding("${resource.getPath()}") }, 
			style = Style.ABSOLUTE)
	@JsonProperty("categories")
	private URI link;
	
	

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

	public URI getLink() {
		return link;
	}

	public void setLink(URI link) {
		this.link = link;
	}

	

}
