/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbh;

/**
 *
 * @author Golden Darkness
 */
import java.io.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartUtilities;

public class THONGKE {

    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho THONGKE ">
    private static THONGKE instance = new THONGKE();

    private THONGKE() {
    }

    public static THONGKE getInstance() {
        return instance;
    }
    // </editor-fold>

    public void DrawTK() throws Exception {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("IPhone 5s", new Double(25));
        dataset.setValue("SamSung Grand", new Double(5));
        dataset.setValue("MotoG", new Double(50));
        dataset.setValue("Nokia Lumia", new Double(20));

        JFreeChart chart = ChartFactory.createPieChart3D(
                "Maria", // chart title                   
                dataset, // data 
                true, // include legend                   
                true,
                false);

        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(270);
        plot.setForegroundAlpha(0.60f);
        plot.setInteriorGap(0.02);
        int width = 640;
        /* Width of the image */
        int height = 480;
        /* Height of the image */
        File pieChart3D = new File("pie_Chart3D.jpeg");
        ChartUtilities.saveChartAsJPEG(pieChart3D, chart, width, height);
    }
}
