package fuber.model;

import org.springframework.stereotype.Component;

@Component
public class Customer
{
    String name;

    Location location;

    public Customer()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation( Location location )
    {
        this.location = location;
    }
}
