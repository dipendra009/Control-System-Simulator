package Bode;


public class DataInput {
	
	public String[] SimpleZeros;
	public String[] SimplePoles;
	public String[] ComplexZero;
	public String[] ComplexPole;
	public double NumeratorConst,DenominatorConst;
	public void setSimpleZeros(String[] str)
	{
		this.SimpleZeros = str;
	
	}
	public void setSimplePole(String[] str)
	{
		this.SimplePoles = str;
	}
	public void setComplexZero(String[] str)
	{
		this.ComplexZero = str;
	}
	public void setComplexPole(String[] str)
	{
		this.ComplexPole = str;
	}
	public void setNumerator(double value)
	{
		this.NumeratorConst = value;
	}
	public void setDenominator(double value)
	{
		this.DenominatorConst = value;
	}
}
