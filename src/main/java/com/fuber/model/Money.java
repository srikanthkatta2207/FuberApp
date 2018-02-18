package fuber.model;

public class Money
{
    private double amount;
    private Currency currency;

    public Money( double amount, Currency currency )
    {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount()
    {
        return amount;
    }

    public Currency getCurrency()
    {
        return currency;
    }

    @Override public boolean equals( Object obj )
    {
        Money money = (Money) obj;

        return (amount == ((Money) obj).getAmount() &&
            currency.equals( ((Money) obj).getCurrency() ));
    }
}
