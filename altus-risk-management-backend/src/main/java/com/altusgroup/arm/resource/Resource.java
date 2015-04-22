package com.altusgroup.arm.resource;

import javax.ws.rs.Path;

public class Resource {
	/**
	 * 
	 * @return
	 */
	public String getPath() {
		return ((javax.ws.rs.Path) this.getClass().getAnnotation(Path.class))
				.value();
	}
}
