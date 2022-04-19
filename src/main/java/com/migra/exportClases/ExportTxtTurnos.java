package com.migra.exportClases;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExportTxtTurnos extends Messages{

    static List<Double> turnos=List.of(1.1,2.1,3.1,1.2,2.2,3.2,1.3,2.3,3.3,4.1,1.7,1.8,2.7,2.8,3.7,3.8,4.5,4.6,4.7,4.8,5.2,1.4,2.4,3.4,4.2,5.1,1.5,2.5,3.5,4.3,1.6,2.6,3.6,4.4);

    static List<String> ips=List.of("0.0.3{10.5.236.113}255","0.0.3{10.5.236.113}1","0.0.3{10.5.236.113}2","0.0.3{10.5.236.114}255","0.0.3{10.5.236.114}1","0.0.3{10.5.236.114}2","0.0.3{10.5.236.115}255","0.0.3{10.5.236.115}1","0.0.3{10.5.236.115}2","0.0.3{10.5.236.115}3","0.0.3{10.5.236.120}255","0.0.3{10.5.236.121}255","0.0.3{10.5.236.123}255","0.0.3{10.5.236.122}255","0.0.3{10.5.236.126}255","0.0.3{10.5.236.125}255","0.0.3{10.5.236.101}255","0.0.3{10.5.236.100}255","0.0.3{10.5.236.104}255","0.0.3{10.5.236.103}255","0.0.3{10.5.236.105}255","0.0.3{10.5.236.110}255","0.0.3{10.5.236.110}1","0.0.3{10.5.236.110}2","0.0.3{10.5.236.110}3","0.0.3{10.5.236.110}4","0.0.3{10.5.236.111}255","0.0.3{10.5.236.111}1","0.0.3{10.5.236.111}2","0.0.3{10.5.236.111}3","0.0.3{10.5.236.112}255","0.0.3{10.5.236.112}1","0.0.3{10.5.236.112}2","0.0.3{10.5.236.112}3");
    
    static List<String> nombres=List.of("N_Micrologic_1","N_Micrologic_2","N_Micrologic_3","N_Micrologic_4","N_Micrologic_5","N_Micrologic_6","N_Micrologic_7","N_Micrologic_8","N_Micrologic_9","N_Micrologic_10","N_Micrologic_11","N_Micrologic_12","N_Micrologic_13","N_Micrologic_14","N_Micrologic_15","N_Micrologic_16","P_Micrologic_1","P_Micrologic_2","P_Micrologic_3","P_Micrologic_4","P_Micrologic_5","P_Micrologic_6","P_Micrologic_7","P_Micrologic_8","P_Micrologic_9","P_Micrologic_10","P_Micrologic_11","P_Micrologic_12","P_Micrologic_13","P_Micrologic_14","P_Micrologic_15","P_Micrologic_16","P_Micrologic_17","P_Micrologic_18");
    
    static List<String> salidasPlc=List.of("N_Q1A1","N_Q1A2","N_Q1A3","N_Q2A1","N_Q2A2","N_Q2A3","N_Q3A1","N_Q3A2","N_Q3A3","N_Q3A4","N_ETH_5A1","N_ETH_5A2","N_Q6A3","N_ETH_6A1","N_Q7A3","N_ETH_7A1","P_Q1A3","P_ETH_1A1","P_Q2A3","P_ETH2A1","P_ETH3A1","P_Q5A1","P_Q5A2","P_Q5A3","P_Q5A4","P_Q5A5","P_Q6A1","P_Q6A2","P_Q6A3","P_Q6A4","P_Q7A1","P_Q7A2","P_Q7A3","P_Q7A4");
        
    static List<MicrologicMB> funciones=new ArrayList<>();
    
    private static List<String> generaDeclaracion(List<MicrologicMB> funciones){
        Collections.sort(funciones, (o1, o2) -> o1.turno.compareTo(o2.turno));
        List<String> listaDeclaracion=new ArrayList<>();
        int i=0;
        boolean bandera=false;
        for(MicrologicMB funcion:funciones){

            String comentario="";
            if(i!=funcion.turno.intValue()){
                i=funcion.turno.intValue();
                comentario="\n(*Turno: "+i+"*)\n";
                bandera=true;
            }

            String cadena="IF NOT "+funcion.salida+"_Deshabilitado THEN\n"
                            +"  "+funcion.nombre+"  (TurnoActual := Turno_Actual,\n"
                            +"                      TurnoFuncion := "+funcion.turno.intValue()+",\n"
                            +"                      DirMB := '"+funcion.ip+"',\n"
                            +"                      Micrologic := "+funcion.salida+");\n"
                            +"END_IF;\n";

            if(bandera)listaDeclaracion.add(comentario);
            bandera=false;
            listaDeclaracion.add(cadena);
       
            
        }
        return listaDeclaracion;
    }
 
    public static void generarTrunos(List<MicrologicMB> funciones,String ruta){
        List<String> lineas=generaDeclaracion(funciones);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);

            for(String linea:lineas){

                pw.println(linea);
            }
            
            exito(ruta);
        } catch (Exception e) {
            e.printStackTrace();
            error(ruta, e);
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
              error(ruta, e2);
           }
        }
        for(int x=0;x<ips.size();x++){
            MicrologicMB m=new MicrologicMB(salidasPlc.get(x), ips.get(x), turnos.get(x),nombres.get(x));
             funciones.add(m);

        }
    }
        

          
      

        
    }

  
    


