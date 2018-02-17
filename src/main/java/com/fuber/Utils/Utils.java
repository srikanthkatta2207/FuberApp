package fuber.Utils;


import fuber.model.Location;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.StrictMath.sin;
import static java.lang.StrictMath.sqrt;

public final class Utils
{
    /*This is the method recommended for calculating short distances by Bob Chamberlain*/

    public static double calculateDistanceBetween( Location location1, Location location2 )
    {
        double d_longitude = location1.getLongitude() - location2.getLongitude();
        double d_latitude = location1.getLatitude() - location2.getLatitude();
        double a = Math.pow( (sin( d_latitude / 2 )), 2 ) + +cos( location1.getLatitude() ) * cos( location2.getLatitude() ) * Math.pow( (sin( d_longitude   / 2 )), 2 );
        double c = 2 * atan2( sqrt( a ), sqrt( 1 - a ) );
        double distance = 6373 * c;

        return distance/1000;
    };
}
