package com.migra.exportClases;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ExportTxtEscrituraScada extends Messages {
    List<String> salidasPlc=List.of(
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
        "P_Q7A4");

        static final List<String> variablesO=List.of(
            "Estado_Interruptor",
            "Estado_Disparo",
            "Muelles_Cargados",
            "ALarma_Largo_Retardo",
            "ALarma_Corto_Retardo",
            "ALarma_Instan_li",
            "ALarma_Inst_Integrado",
            "ALarma_Prot_Vigi_Inst",
            "ALarma_Disparo_Reflejo",
            "ALarma_Exceso_Mani_OF",
            "ALarma_Exceso_Orden_Cierre",
            "ALarma_Desagaste_Contactos",
            "Prep_Rearme",
            "Corriente_r",
            "Corriente_s",
            "Corriente_t",
            "Corriente_n",
            "Tension_rn",
            "Tension_sn",
            "Tension_tn",
            "Max_Pot_Activa",
            "Max_Pot_Reactiva",
            "Frecuencia",
            "Frecuencia_MAX",
            "Cos_fi",
            "THD_I_r",
            "THD_I_s",
            "THD_I_t",
            "THD_V_rs",
            "THD_V_st",
            "THD_V_tr",
            "Demanda_P_Act",
            "Demanda_P_React",
            "Ir_max",
            "Is_max",
            "It_max",
            "In_max",
            "Vrn_min",
            "Vsn_min",
            "Vtn_min",
            "f_min",
            "cosfi_max",
            "cosfi_min",
            "cosfi_med",
            "THD_I_r_med",
            "THD_I_s_med",
            "THD_I_t_med",
            "THD_V_rs_med",
            "THD_V_st_med",
            "THD_V_tr_med",
            "Deshabilitado",
            "errorcomm"

                        );
  
    private static List<String> generaDeclaracion(List<String> salidasPlc){

        List<String> listaDeclaracion=new ArrayList<>();
        for(String salida:salidasPlc){

         String cadena=salida+"_Ordenes (EstadoInterruptor := "+salida+"_Estado_Interruptor (*BOOL*),\n"
                                +"      EstadoDisparo := "+salida+"_Estado_Disparo(*BOOL*),\n"
                                +"      P1S := %S6(*BOOL*),\n"
                                +"      OApertura := "+salida+"_Orden_Apertura(*BOOL*),\n"
                                +"      OCierre := "+salida+"_Orden_Cierre(*BOOL*),\n"
                                +"      ORearme := "+salida+"_Orden_Rearme(*BOOL*),\n"
                                +"      FalloOrden := "+salida+"_Fallo_Orden(*BOOL*),\n"
                                +"      OrdenOK := "+salida+"_Orden_OK(*BOOL*),\n"
                                +"      Q := "+salida+"(*Micrologic_St*),\n"
                                +"      RST := "+salida+"_Orden_RST(*BOOL*));\n";

         listaDeclaracion.add(cadena);
            
        }
        return listaDeclaracion;
    }
     
     
        
   
    public static void crearEscrituras(List<String> salidasPlc,String ruta){
        FileWriter fichero = null;
        PrintWriter pw = null;    
        try
            {
                
                fichero = new FileWriter(ruta);
                pw = new PrintWriter(fichero);
                 
                List<String> lineas=generaDeclaracion(salidasPlc);               
                for(String linea:lineas){
    
                    pw.println(linea);
                }
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
