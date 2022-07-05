package controller;

import creadorDeArchivos.CreadorDeArchivos;
import java.awt.event.ActionEvent;
import model.ForecastModel;
import view.ForecastView;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Year;

public class ForecastController {

    private ForecastModel model;
    private ForecastView view;
    private CreadorDeArchivos archivo;
    private ArrayList<Year> years = new ArrayList<>();
    private int acumulator;
    private int contadorDeFilasTabla2;

    public ForecastController(ForecastModel model, ForecastView view, CreadorDeArchivos archivo) {
        this.model = model;
        this.view = view;
        this. archivo = archivo;
        this.acumulator = 0;
        this.contadorDeFilasTabla2 = 0;

        view.setVisible(true);

        this.view.addListenerBtnAgregarAño(new CalculateListener());
        this.view.addListenerBtnBorrarAño(new CalculateListener());
        this.view.addListenerBtnModificarAño(new CalculateListener());
        this.view.addListenerBtnNuevoPronostico(new CalculateListener());
        this.view.addListenerBtnCalcularPronostico(new CalculateListener());
        this.view.addListenerBtnAceptar(new CalculateListener());

    }

    class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Agregar año")){
                double sales;
                try{
                    sales = view.getSales();
                    
                    model.createYear(sales);
                    years = model.getArrayYears();
                    view.pintarLista(years.get(acumulator));
                    view.sellsModifier();
                    acumulator++;
       
                }catch(NumberFormatException x){
                    view.displayErrorMessage("El tipo de dato debe ser númerico.");
                }
                view.setTotales(model.sumOfYears(), model.sumOfSales(), 
                    model.sumOfYearSquared(), model.sumOfSalesSquared(), 
                    model.sumOfYearForSale());
            }
            
            if (e.getActionCommand().equalsIgnoreCase("Borrar año")){
                view.menuBorrar(true);
            }
            
            if (e.getActionCommand().equalsIgnoreCase("Aceptar")){
                int yearToDelete = 0;
                try{
                    yearToDelete = view.getWhichYear();
                }catch(NumberFormatException x){
                    view.displayErrorMessage("El tipo de dato debe ser númerico.");
                }
                model.deleteYear(yearToDelete);
                model.positionMinusOne();
                view.updateTable(years);
                view.menuBorrar(false);
                view.sellsModifier();
                view.setTotales(model.sumOfYears(), model.sumOfSales(), 
                    model.sumOfYearSquared(), model.sumOfSalesSquared(), 
                    model.sumOfYearForSale());
                acumulator = acumulator-1;
            }
            
            if (e.getActionCommand().equalsIgnoreCase("Modifica año")){
                view.menuModificar(true);
            }
            
            if (e.getActionCommand().equalsIgnoreCase("Modificar")){
                int yearToModify = 0;
                Double newSale = 0.0;
                try{
                    yearToModify = view.getWhichYear();
                    newSale = view.getNewSale();
                }catch(NumberFormatException x){
                    view.displayErrorMessage("El tipo de dato debe ser númerico.");
                }
                model.setNewSales(newSale, yearToModify);
                view.updateTable(years);
                view.setTotales(model.sumOfYears(), model.sumOfSales(), 
                    model.sumOfYearSquared(), model.sumOfSalesSquared(), 
                    model.sumOfYearForSale());
                view.sellsModifier();
                view.menuModificar(false);
            }
            
            if (e.getActionCommand().equalsIgnoreCase("Nuevo pronostico")){
                model.newForecast();
                model.resetPosition();
                acumulator = 0;
                contadorDeFilasTabla2 = 0;
                view.updateTable(years);
                view.removeRowsTable2();
                view.clearTotales();
            }
            
            if (e.getActionCommand().equalsIgnoreCase("Calcular pronostico")){
                int forecastYears = 0;
                try{
                    forecastYears = view.getForecastYears();
                }catch(NumberFormatException x){
                    view.displayErrorMessage("Forecast years are necesary.");
                }
                String number = String.format("%.2f", (model.calculateFormulaC()*100));
                String txt = ""+number+"%";
                view.setAverageGrowth(txt);
                for(int i = 0; i < forecastYears; i++){
                    Double result = model.calculateForecast(forecastYears);
                    
                    view.printRowsTable2(years.get(contadorDeFilasTabla2),
                        result);
                    
                    archivo.añadirTxt(years.get(contadorDeFilasTabla2).getYearNumber()+" - "
                        +result+"\n");
                    
                    contadorDeFilasTabla2++;
                }
                archivo.añadirTxt("\n\n-----------Sales Forecast-----------\n\n");
            }
        }
    }
}
