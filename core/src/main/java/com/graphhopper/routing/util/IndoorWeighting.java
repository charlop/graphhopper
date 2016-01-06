package com.graphhopper.routing.util;

import com.graphhopper.util.EdgeIteratorState;
import com.graphhopper.util.EdgeIteratorState;
import java.util.HashSet;
/**
 * Places higher priority on indoor routes
 *	The indoorEdges set contains a list of indoor streets by name
 *  It is generated in this file for better code separation
**/
public class IndoorWeighting implements Weighting
{
	// This sets the priority for using indoor streets
	// A factor of 2 is the same as saying the distance is 1/2 compared to a street not in the set
	private final int INDOOR_PRIORITY_FACTOR = 8;

	private final FlagEncoder flagEncoder;
	private final double maxSpeed;
	
	// Initialized by determineIndoorEdges() at the end of this class
	private static HashSet<String> indoorEdges;

    public IndoorWeighting( FlagEncoder encoder)
    {
		this.flagEncoder = encoder;
        maxSpeed = encoder.getMaxSpeed();
		determineIndoorEdges();
    }
	
	@Override
    public double getMinWeight( double distance )
    {
        return distance / maxSpeed;
    }

    @Override
    public double calcWeight( EdgeIteratorState edge, boolean reverse, int prevOrNextEdgeId )
    {
		double speed = reverse ? flagEncoder.getReverseSpeed(edge.getFlags()) : flagEncoder.getSpeed(edge.getFlags());
		if(indoorEdges.contains(edge.getName()))
			return edge.getDistance() / (speed * INDOOR_PRIORITY_FACTOR);

		// Outdoor routes get normal weighting
		return edge.getDistance() / speed;
    }

    @Override
    public boolean matches( String weightingAsStr, FlagEncoder encoder )
    {
        return getName().equals(weightingAsStr) && encoder == flagEncoder;
    }	
	
	@Override
    public FlagEncoder getFlagEncoder()
    {
        return flagEncoder;
    }
	
    @Override
    public String getName()
    {
        return "indoors";
    }
	
	
	public static void determineIndoorEdges() {
		indoorEdges = new HashSet<String>();
		
		indoorEdges.add("BB1");
		indoorEdges.add("BB3");
		indoorEdges.add("BB2");
		indoorEdges.add("Chrysler Hall 1");
		indoorEdges.add("Chrysler Hall 2");
		indoorEdges.add("Chrysler Hall 3");
		indoorEdges.add("Chrysler Hall South 1");
		indoorEdges.add("Odette 1");
		indoorEdges.add("Odette 2");
		indoorEdges.add("CHN 1");
		indoorEdges.add("CHN 4");
		indoorEdges.add("CHN 2");
		indoorEdges.add("Essex 1");
		indoorEdges.add("Essex 4");
		indoorEdges.add("Essex 7");
		indoorEdges.add("Essex 8");
		indoorEdges.add("DH1");
		indoorEdges.add("DH3");
		indoorEdges.add("DH4");
		indoorEdges.add("DH2");
		indoorEdges.add("Memorial Hall");
		indoorEdges.add("MH1");
		indoorEdges.add("MH2");
		indoorEdges.add("Law Library");
		indoorEdges.add("Toldo");
		indoorEdges.add("CAW 4");
		indoorEdges.add("CAW 5");
		indoorEdges.add("CAW 6");
		indoorEdges.add("CAW 7");
		indoorEdges.add("CAW 9");
		indoorEdges.add("CAW 10");
		indoorEdges.add("LT 1");
		indoorEdges.add("Erie 1");
		indoorEdges.add("Leddy 2"); // Incomplete list; only for testing purposes
	}
}
