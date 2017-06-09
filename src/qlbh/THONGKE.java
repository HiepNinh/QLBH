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
import java.util.ArrayList;

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

    public void DrawTK(ArrayList<String[]> al, float tong) throws Exception {
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for(int i=0;i<al.size();i++)
        {
            String name = al.get(i)[1];
            float tt = Float.parseFloat(al.get(i)[3])/tong;
            dataset.setValue(name, new Double(tt));
        }

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
        int width = 700;
        /* Width of the image */
        int height = 500;
        /* Height of the image */
        File pieChart3D = new File("src/Library/pie_Chart3D.jpeg");
        ChartUtilities.saveChartAsJPEG(pieChart3D, chart, width, height);
    }
}
