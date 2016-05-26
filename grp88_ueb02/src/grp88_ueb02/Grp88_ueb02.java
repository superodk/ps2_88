/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp88_ueb02;

import java.util.Arrays;

/**
 *
 * @author iaw100728
 */
public class Grp88_ueb02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        float[] tempdata;
//        int offset = 100;
//        
//        tempdata = TemperatureValues.getTemperatures(100, 4);
//        
//        for (int i = 0; i < offset; i++){
//            System.out.println(tempdata[i]);
//            
//        }
        System.out.println(Arrays.toString(TemperatureValues.getTemperatures(110, 50)));
        
    }
    
}
