/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbh;

import java.io.*; 
import java.util.ArrayList;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.chart.ChartUtilities; 
/**
 *
 * @author Golden Darkness
 */
public class THONGKEDT {
    
    // <editor-fold defaultstate="collapsed" desc=" Khoi tao singleton cho THONGKEDT ">
    private static THONGKEDT instance = new THONGKEDT();

    private THONGKEDT() {
    }

    public static THONGKEDT getInstance() {
        return instance;
    }
    // </editor-fold>
    
    public static void DrawTK(ArrayList<String[]> al)throws Exception {                      
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( ); 

      for(int i = 1; i< 4;i++)
      {
          String s="";
          if(i == 1)
              s= "Doanh thu";
          else if(i == 2)
              s = "Tiền nợ";
          else if(i == 3)
              s = "Lợi nhuận";
          for(int j=0;j<al.size();j++)
          {
              float f = Float.parseFloat(al.get(j)[i]);
              dataset.addValue( f , s, al.get(j)[0] );
          }
      }
            
      
      JFreeChart barChart = ChartFactory.createBarChart3D(
         "Car Usage Statistics",             
         "Category",             
         "Score",             
         dataset,            
         PlotOrientation.VERTICAL,             
         true, true, false);
         
      int width = 640; /* Width of the image */              
      int height = 480; /* Height of the image */                              
      File barChart3D = new File( "src/Library/barChart3D.jpeg" );                            
      ChartUtilities.saveChartAsJPEG( barChart3D, barChart, width, height);
   }
}
