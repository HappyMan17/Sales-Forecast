/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pronostico;

import controller.ForecastController;
import model.ForecastModel;
import view.ForecastView;

/**
 * @author Sebastian Grisales - 2124024
 * @author Santiago Garcia - 2025228
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ForecastView view = new ForecastView();
        ForecastModel model = new ForecastModel();
        ForecastController controller = new ForecastController(model, view);
    }

}
