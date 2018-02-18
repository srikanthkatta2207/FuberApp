package fuber.model;

public class Currency
{
    private int centFactor;
    private String stringRepresentation;

    public Currency( int centFactor, String stringRepresentation )
    {
        this.centFactor = centFactor;
        this.stringRepresentation = stringRepresentation;
    }


    public int getCentFactor()
    {
        return centFactor;
    }

    public String getStringRepresentation()
    {
        return stringRepresentation;
    }

    public static Currency dogeCoin()
    {
        return new Currency( 1, "dogecoin" );
    }

    @Override public boolean equals( Object obj )
    {
        Currency currency = (Currency) obj;

        return (centFactor == currency.getCentFactor() &&
            stringRepresentation == currency.getStringRepresentation());
    }
}
