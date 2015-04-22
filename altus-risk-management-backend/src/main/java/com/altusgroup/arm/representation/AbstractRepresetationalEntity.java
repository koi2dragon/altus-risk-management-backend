package com.altusgroup.arm.representation;

import java.util.List;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;
import org.glassfish.jersey.linking.InjectLinks;

import com.altusgroup.arm.resource.LevelResource;
import com.altusgroup.arm.resource.util.LinkAdapter;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author hitokiri
 *
 */
public class AbstractRepresetationalEntity {
	public static final String SELF_LINK_PARAM_NAME = "self";
	public static final String LINK_PARAM_NAME = "links";
	
	
	/*@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")*/
	private String id;
	
	@JsonIgnore
	private int offset,limit;
	
	
	/**
	 * 
	 */

	@InjectLinks({ 
		     @InjectLink(value = "{value}/${instance.id}", bindings = { 
				   @Binding("${resource.getPath()}") }, 
				   style = Style.ABSOLUTE, 
				   rel = SELF_LINK_PARAM_NAME),
		     @InjectLink(//value = "{value}/${instance.id}",
		    		 // condition = "${instance.offset + instance.limit < instance.modelLimit}",  
		    		          resource=LevelResource.class,
		    		        		  method = "query",  
		    		          bindings = {  
		    		            @Binding(name = "id", value = "${instance.id}")  
		    		          },  
		    		          rel = "next",  
		  		   style = Style.ABSOLUTE 
		  		   )
				})
	@XmlJavaTypeAdapter(LinkAdapter.class)
	private List<Link> links;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	
}
