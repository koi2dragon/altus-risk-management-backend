package com.altusgroup.arm.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.altusgroup.arm.representation.LevelRepresentation;
import com.altusgroup.arm.representation.RiskCategoryRepresentation;

@Path("level")
@Produces(MediaType.APPLICATION_JSON)
public class LevelResource extends Resource {

	@GET
	@Path("/")
	public List<LevelRepresentation> findAll(
			@DefaultValue("50") @QueryParam("limit") Integer limit,
			@DefaultValue("0") @QueryParam("offset") Integer offset) {

		List<LevelRepresentation> levels = new ArrayList<LevelRepresentation>();
		LevelRepresentation level = new LevelRepresentation();
		level.setOffset(0);
		level.setLimit(50);
		level.setId("1");
		level.setLabel("Portfolio");
		levels.add(level);
		//
		RiskCategoryRepresentation category = new RiskCategoryRepresentation();
		category.setId("1");
		category.setLabel("first category");
		category.setDescription("some description");
		// level.getCategories().add(category);
		return levels;
		// return Response.ok(levels).build();
	}
}
