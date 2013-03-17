
package cadenanumero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutar{
    
    public static void main ( String args []){
        
        Permutar objPermutar = new Permutar();
        String sLeerConsola = objPermutar.leerConsola();
        
        int iResultadoFactorial = getFactorial(sLeerConsola.length()); 
        
        String[] ne = generarPermutacion(sLeerConsola,iResultadoFactorial);

        mostrar(ne);
    }


    /*
     * Metodo que lee los datos de consola.
     * 
     * return sCadenaRetorno.
     */
    private String leerConsola(){
        
        String sCadenaRetorno = null;
        
        System.out.println("Por favor ingrese los digitos para la permutacion:\n");
        try {            
            InputStreamReader objInputStream = new InputStreamReader(System.in);
            BufferedReader objBufferReader = new BufferedReader (objInputStream);
            sCadenaRetorno = objBufferReader.readLine();
            
        } catch (IOException ex) {
            System.err.println("Error al capturar: " + ex.getMessage());
            sCadenaRetorno = null;
        }
        
        return sCadenaRetorno;
    }

    /*
     * Metodo que genera la permutacion
     */    
    public static String[] generarPermutacion(String sCadena,int iResultadoFactorial)
    {
            String[] a_sTMP = new String[iResultadoFactorial];
            
            int iTamaCadena = sCadena.length();
            
            String[] aux = permutacion(sCadena);
            
            int pos = 0;

            if(iResultadoFactorial == 1|| iTamaCadena == 1){
                a_sTMP[0] = sCadena;
                return a_sTMP;
            }

            for(int i=0;i<aux.length;i++)
            {
                    String[] auxiliar = generarPermutacion(aux[i].substring(1),getFactorial(iTamaCadena-1)); 
                    for(int j=0;j<auxiliar.length;j++)
                    {
                            a_sTMP[pos]=aux[i].charAt(0)+auxiliar[j];
                            pos++;
                    }			
            }
            return a_sTMP;
    }
    
    public static String[] permutacion(String cadena)
    {
            int n = cadena.length();
            String temporal = "" ;
            String[] vector = new String[n];
            vector[0] = cadena;
            int i = 1;
            
            while(i < n){
                
                int j = 0;
                
                while(j < n){
                    if(j==n-1){
                        temporal = cadena.charAt(j)+temporal;
                    }else {
                        temporal += cadena.charAt(j);
                    }
                    
                    j++;
                }
                
                cadena=temporal;
                vector[i]=temporal;
                temporal="";
                
                i++;
            }
            
            return vector;
    }
    
    /*
     * Metodo que genera la factorial de permutacion.
     */
    public static int getFactorial (int iTamanhoArreglo) {
        
        int iResultado;
        
        if(iTamanhoArreglo == 1 || iTamanhoArreglo == 0){
            return 1;
        }

        iResultado = getFactorial(iTamanhoArreglo-1) * iTamanhoArreglo;
        
        return iResultado;
    }
    
    
    public static void mostrar (String[] vector) {
        
        System.out.println("\n\n\n\n\n");
        
        for(int i = 0; i < vector.length; i++){
            
            System.out.println((i+1) + ". => " + vector[i]);
        }
    }
}