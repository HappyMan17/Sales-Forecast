package model;

public class Year {

    private double sales;
    private int yearNumber;
    private double salesSquared;
    private int yearSquared;
    private double yearsForSales;

    public Year(double sales, int yearNumber) {
        this.sales = sales;
        this.yearNumber = yearNumber;
    }

    public void setSales(double newSale) {
        this.sales = newSale;
    }
    
    public double getSales(){
        return sales;
    }

    public void setYear(int newYear) {
        this.yearNumber = newYear;
    }
    
    public int getYearNumber(){
        return yearNumber;
    }

    public void calculateSalesSquared() {
        this.salesSquared = sales * sales;
    }

    public double getSalesSquared() {
        calculateSalesSquared();
        return salesSquared;
    }

    public void calculateYearSquared() {
        this.yearSquared = yearNumber * yearNumber;
    }

    public int getYearSquared() {
        calculateYearSquared();
        return yearSquared;
    }

    public void calculateYearsForSales() {
        this.yearsForSales = sales * yearNumber;
    }

    public double getYearForSales() {
        calculateYearsForSales();
        return yearsForSales;
    }

}
