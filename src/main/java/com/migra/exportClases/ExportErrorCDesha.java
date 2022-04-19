package com.migra.exportClases;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class ExportErrorCDesha extends Messages{
     
    public static void generarXml(List<String> salidasPlc,String ruta,int bitX,int byteM){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);


            /*List<String> salidasPlc=List.of(
            "N_Q1A1",
            "N_Q1A2",
            "N_Q1A3",
            "N_Q2A1",
            "N_Q2A2",
            "N_Q2A3",
            "N_Q3A1",
            "N_Q3A2",
            "N_Q3A3",
            "N_Q3A4",
            "N_ETH_5A1",
            "N_ETH_5A2",
            "N_Q6A3",
            "N_ETH_6A1",
            "N_Q7A3",
            "N_ETH_7A1",
            "P_Q1A3",
            "P_ETH_1A1",
            "P_Q2A3",
            "P_ETH2A1",
            "P_ETH3A1",
            "P_Q5A1",
            "P_Q5A2",
            "P_Q5A3",
            "P_Q5A4",
            "P_Q5A5",
            "P_Q6A1",
            "P_Q6A2",
            "P_Q6A3",
            "P_Q6A4",
            "P_Q7A1",
            "P_Q7A2",
            "P_Q7A3",
            "P_Q7A4");*/
            
            List<String> variablesBool=List.of("errorcomm","Deshabilitado","Orden_Rearme","Fallo_Orden","Orden_OK","Orden_RST","RST_VAL");
            String comadoExportacion="";

            for(String salida:salidasPlc){
                for(String variable:variablesBool){

                    if(bitX>=16){
                        bitX=0;
                        byteM++;
                    }
                     comadoExportacion="<variables name=\""+salida+"_"+variable+"\" typeName=\"BOOL\" topologicalAddress=\"%MW"+byteM+"."+bitX+"\"><attribute name=\"TimeStampSource\" value=\"0\"></attribute></variables>";
                     bitX++;
                     pw.println(comadoExportacion);
                }
            };

            exito(ruta);

        } catch (Exception e) {
            e.printStackTrace();
            error(ruta, e);
        } finally {
           try {

           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
              error(ruta, e2);
           }
        }
        
    }

}