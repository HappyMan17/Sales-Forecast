package model;

import java.util.ArrayList;

public class ForecastModel {

    private ArrayList<Year> years;
    private int position;
    private int contador;

    public ForecastModel() {
        this.years = new ArrayList<>();
        this.position = 1;
        this.contador = 1;
    }

    public void createYear(double sales) {
        Year año = new Year(sales, position);
        years.add(año);
        position++;
    }
    
    public ArrayList<Year> getArrayYears(){
        return years;
    }
    
    public void resetPosition() {
        this.position = 1;
    }
    
    public void positionMinusOne(){
        position = position - 1;
    }

    public void setYear(int newYear, int arrayPosition) {
        if (arrayPosition < 1 || arrayPosition > years.size()) {
            System.out.println("nonas rey, posicion del array invalida");
        }
        years.get(arrayPosition - 1).setYear(newYear);
    }

    public void deleteYear(int arrayPosition) {
        if (arrayPosition < 1 || arrayPosition > years.size()) {
            System.out.println("nonas rey, posicion del array invalida");
        }
        years.remove(arrayPosition - 1);
        updatePosition(arrayPosition);
    }

    public void updatePosition(int arrayPosition) {
        while (arrayPosition <= years.size()) {
            years.get(arrayPosition - 1).setYear(arrayPosition);
            arrayPosition++;
        }
    }
    
    public void setNewSales(Double newSale, int arrayPosition){
        if (arrayPosition < 1 || arrayPosition > years.size()) {
            System.out.println("nonas rey, posicion del array invalida");
        }
        years.get(arrayPosition - 1).setSales(newSale);
    }

    public void newForecast() {
        years.clear();
    }

    public double getSalesSquared(int whichYear) {
        double saleSquared = years.get(whichYear).getSalesSquared();
        return saleSquared;
    }

    public double sumOfSalesSquared() {
        double sumOfSales = 0;
        for (Year year : years) {
            sumOfSales = sumOfSales + year.getSalesSquared();
        }
        return sumOfSales;
    }

    public int getYearSquared(int whichYear) {
        int yearSqua = years.get(whichYear).getYearSquared();
        return yearSqua;
    }

    public int sumOfYearSquared() {
        int result = sumOfYears() * sumOfYears();
        return result;
    }

    public double getYearForSale(int whichYear) {
        double yearXSale = years.get(whichYear).getYearForSales();
        return yearXSale;
    }

    public double sumOfYearForSale() {
        double sumOfYearXSale = 0;
        for (Year year : years) {
            sumOfYearXSale += year.getYearForSales();
        }
        return sumOfYearXSale;
    }

    public int sumOfSquaredYear() {
        int sumatoria = 0;
        for (Year year : years) {
            sumatoria += year.getYearSquared();
        }
        return sumatoria;
    }

    public int sumOfYears() {
        int sumatoria = 0;
        for (Year year : years) {
            sumatoria += year.getYearNumber();
        }
        return sumatoria;
    }

    public double sumOfSales() {
        double sumatoria = 0;
        for (Year year : years) {
            sumatoria += year.getSales();
        }
        return sumatoria;
    }

    public double calculateFormulaB() {
        Double dividend = (years.size() * sumOfYearForSale()) - (sumOfYears() * sumOfSales());
        int divisor = (years.size() * sumOfSquaredYear()) - sumOfYearSquared();
        return dividend / divisor;
    }

    public double calculateFormulaA() {
        double total = ((sumOfSales() - (calculateFormulaB() * sumOfYears()))
                / years.size());
        return total;
    }
    
    public Double calculateFormulaC() {
        Double dividend = (calculateFormulaB()*years.size());
        Double divisor = sumOfSales();
        return dividend / divisor;
    }

    public Double calculateForecast(int cantidadDeAños) {
        Double pronostic = calculateFormulaA() + calculateFormulaB()
            * (cantidadDeAños + contador);
        contador++;
        return pronostic;
        /*
        for (int i = 1; i <= cantidadDeAños; i++) {
            double pronostic = calculateFormulaA() + calculateFormulaB()
                    * (i + years.size());
            System.out.println(" El pronostico del anio " + (i + years.size())
                    + " es : " + pronostic);
        }
        */
    }
}
