package com.altusgroup.arm.resource.util;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

public class LinkAdapter extends XmlAdapter<LinkJaxb, Link> {

	public LinkAdapter() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
	 */
	public Link unmarshal(LinkJaxb link) {
		Link.Builder builder = Link.fromUri(link.getUri());
		for (Map.Entry<QName, Object> entry : link.getParams().entrySet()) {
			builder.param(entry.getKey().getLocalPart(), "" + entry.getValue());
		}
		return builder.build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
	 */
	public LinkJaxb marshal(Link link) {
		System.out.println(link.getTitle());

		Map<QName, Object> params = new HashMap<>();
		for (Map.Entry<String, String> entry : link.getParams().entrySet()) {
			params.put(new QName("", entry.getKey()), entry.getValue());

			System.out.println("key -->> " + entry.getKey());
			System.out.println("value -->> " + entry.getValue());

		}
		return new LinkJaxb(link.getUri(), params);
	}
}

class LinkJaxb {

	private URI uri;
	private Map<QName, Object> params;

	public LinkJaxb() {
		this(null, null);
	}

	public LinkJaxb(URI uri) {
		this(uri, null);
	}

	public LinkJaxb(URI uri, Map<QName, Object> map) {

		this.uri = uri;
		this.params = map != null ? map : new HashMap<QName, Object>();

	}

	@XmlAttribute(name = "href")
	public URI getUri() {
		return uri;
	}

	@XmlAnyAttribute
	public Map<QName, Object> getParams() {
		return params;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	public void setParams(Map<QName, Object> params) {
		this.params = params;
	}
}