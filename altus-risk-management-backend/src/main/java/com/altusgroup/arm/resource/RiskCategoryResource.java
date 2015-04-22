package com.altusgroup.arm.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.altusgroup.arm.representation.RiskCategoryRepresentation;

@Path("category")
@Produces(MediaType.APPLICATION_JSON)
public class RiskCategoryResource {

	@GET
	@Path("category")
	public List<RiskCategoryRepresentation> finAllByLevelId(
			@DefaultValue("50") @QueryParam("limit") Integer limit,
			@DefaultValue("0") @QueryParam("offset") Integer offset) {

		List<RiskCategoryRepresentation> categories = new ArrayList<RiskCategoryRepresentation>();
		//
		RiskCategoryRepresentation category = new RiskCategoryRepresentation();
		category.setId("1");
		category.setLabel("first category");
		category.setDescription("some description");

		categories.add(category);
		//
		category = new RiskCategoryRepresentation();
		category.setId("2");
		category.setLabel("second category");
		category.setDescription("some description");

		categories.add(category);
		//
		category = new RiskCategoryRepresentation();
		category.setId("3");
		category.setLabel("third category");
		category.setDescription("some description");

		categories.add(category);
		// level.getCategories().add(category);
		return categories;
	}
}
