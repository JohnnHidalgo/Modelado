package Graficas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Graficator{

    public static void main(String []args){
        XYSeries carro = new XYSeries("Automovil");
        carro.add(0.001, 1.0);
        carro.add(0.003, 4.0);
        carro.add(0.007, 3.0);

        XYSeries bici = new XYSeries("Bicicleta");
        bici.add(1.0, 4.0);
        bici.add(2.0, 5.0);
        bici.add(3.0, 6.0);

        XYSeries moto = new XYSeries("Motocicleta");
        moto.add(3.0, 4.0);
        moto.add(4.0, 5.0);
        moto.add(5.0, 4.0);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(carro);
        dataset.addSeries(bici);
        dataset.addSeries(moto);

        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Grafica XY",
                "Transporte",
                "Putuacion",
                dataset,
                PlotOrientation.VERTICAL, true, true, false);


        XYPlot plot = xylineChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.YELLOW);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        plot.setRenderer(renderer);

        ChartPanel panel = new ChartPanel(xylineChart);

        // Creamos la ventana
        JFrame ventana = new JFrame("Grafica");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.add(panel);
    }

    public static ChartPanel graficar(List<Double> listvalores){
        XYSeries values=new XYSeries("Distribución normal");
        double value=0.0;
        for(int i=0;i<listvalores.size();i++){

            values.add(value,listvalores.get(i));
            value+=0.1;
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(values);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Grafica",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = xylineChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        plot.setRenderer(renderer);

        ChartPanel panel = new ChartPanel(xylineChart);
        return  panel;
    }

    public static ChartPanel graficar2(List<Double> listvalores,List<Double> xList){
        XYSeries values=new XYSeries("Distribución normal");
        for(int i=0;i<listvalores.size();i++){
            values.add(xList.get(i),listvalores.get(i));
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(values);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Grafica",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = xylineChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        plot.setRenderer(renderer);

        ChartPanel panel = new ChartPanel(xylineChart);
        return  panel;
    }

}


