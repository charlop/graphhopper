package com.graphhopper.routing.util;

import com.graphhopper.util.EdgeIteratorState;
import com.graphhopper.util.EdgeIteratorState;
import java.util.HashSet;
/**
 * Places higher priority on lit routes (safer routes)
 *
**/
public class LitWeighting implements Weighting
{
	// This sets the priority for using lit streets
	// A factor of 2 is the same as saying the distance is 1/2 compared to a street not in the set
	private final int LIT_PRIORITY_FACTOR = 8;

	private final FlagEncoder flagEncoder;
	private final double maxSpeed;
	private static HashSet<String> litEdges;

    public LitWeighting( FlagEncoder encoder )
    {
		this.flagEncoder = encoder;
        maxSpeed = encoder.getMaxSpeed();
		determineLitEdges();
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
		// Indoor edge; cut weight in 12
		if(edge.getName() != null && litEdges.contains(edge.getName()))
			return edge.getDistance() / (speed * LIT_PRIORITY_FACTOR);

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
        return "lit";
    }
	
	public static void determineLitEdges() {
		litEdges = new HashSet<String>();
		
		litEdges.add("Sunset Avenue Pedestrian Area");
		litEdges.add("Sunset Avenue");
		litEdges.add("DH Courtyard");
		litEdges.add("DH Courtyard 2");
		litEdges.add("Leddy 1");
		
	}
}
