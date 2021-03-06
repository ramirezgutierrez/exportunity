package com.migra.exportClases;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class ExportTxtCalculo extends Messages{
    static String funcionCalculoVtn(String salida){
         String comadoExportacion=salida+"_Vtn (PV :="+salida+"_Tension_tn,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\r\n"
                +"  MAX => Aux_real,\r\n"
                +"  MED => Aux_real,\r\n"
                +"  MIN => "+salida+".Vtn_min);\r\n";  
        return comadoExportacion;
    }

    static String funcionCalculoVsn(String salida){
       
      
        String  comadoExportacion=salida+"_Vsn (PV :="+salida+"_Tension_sn,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\n"
                +"  MAX => Aux_real,\r\n"
                +"  MED => Aux_real,\r\n"
                +"  MIN => "+salida+".Vsn_min);\r\n";

        return comadoExportacion;
    }
    static String funcionCalculoVrn(String salida){
       
      
        String  comadoExportacion=salida+"_Vrn (PV :="+salida+"_Tension_rn,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\n"
                +"  MAX => Aux_real,\r\n"
                +"  MED => Aux_real,\r\n"
                +"  MIN => "+salida+".Vrn_min);\r\n";

        return comadoExportacion;
    }
    static String funcionCalculoTHDVtr(String salida){
       
      
        String  comadoExportacion=salida+"_THDVtr (PV :="+salida+"_THD_V_tr,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\n"
                +"  MAX => Aux_real,\r\n"
                +"  MED => "+salida+".THD_V_tr_med,\r\n"
                +"  MIN => Aux_real);\r\n";

        return comadoExportacion;
    }

    static String funcionCalculoTHDVst(String salida){
       
      
        String  comadoExportacion=salida+"_THDVst (PV :="+salida+"_THD_V_st,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\n"
                +"  MAX => Aux_real,\r\n"
                +"  MED => "+salida+".THD_V_st_med,\r\n"
                +"  MIN => Aux_real);\r\n";

        return comadoExportacion;
    }

    static String funcionCalculoTHDVrs(String salida){
       
      
        String  comadoExportacion=salida+"_THDVrs (PV :="+salida+"_THD_V_rs,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\n"
                +"  MAX => Aux_real,\r\n"
                +"  MED => "+salida+".THD_V_rs_med,\r\n"
                +"  MIN => Aux_real);\r\n";

        return comadoExportacion;
    }
    static String funcionCalculoTHDIt(String salida){
       
      
        String  comadoExportacion=salida+"_THDIt (PV :="+salida+"_THD_I_t,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\n"
                +"  MAX => Aux_real,\r\n"
                +"  MED => "+salida+".THD_I_t_med,\r\n"
                +"  MIN => Aux_real);\r\n";

        return comadoExportacion;
    }
    static String funcionCalculoTHDIs(String salida){
       
      
        String  comadoExportacion=salida+"_THDIs (PV :="+salida+"_THD_I_s,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\n"
                +"  MAX => Aux_real,\r\n"
                +"  MED => "+salida+".THD_I_s_med,\r\n"
                +"  MIN => Aux_real);\r\n";

        return comadoExportacion;
    }

    static String funcionCalculoTHDIr(String salida){
       
      
        String  comadoExportacion=salida+"_THDIr (PV :="+salida+"_THD_I_r,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\n"
                +"  MAX => Aux_real,\r\n"
                +"  MED => "+salida+".THD_I_r_med,\r\n"
                +"  MIN => Aux_real);\r\n";

        return comadoExportacion;
    }
    static String funcionCalculoIt(String salida){
       
      
        String  comadoExportacion=salida+"_It (PV :="+salida+"_Corriente_t,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\n"
                +"  MAX => "+salida+".It_max,\r\n"
                +"  MED => Aux_real,\r\n"
                +"  MIN => Aux_real);\r\n";

        return comadoExportacion;
    }
    static String funcionCalculoIs(String salida){
       
      
        String  comadoExportacion=salida+"_Is (PV :="+salida+"_Corriente_s,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\n"
                +"  MAX => "+salida+".Is_max,\r\n"
                +"  MED => Aux_real,\r\n"
                +"  MIN => Aux_real);\r\n";

        return comadoExportacion;
    }

    static String funcionCalculoIn(String salida){
       
      
        String  comadoExportacion=salida+"_In (PV :="+salida+"_Corriente_n,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\n"
                +"  MAX => "+salida+".In_max,\r\n"
                +"  MED => Aux_real,\r\n"
                +"  MIN => Aux_real);\r\n";

        return comadoExportacion;
    }

    static String funcionCalculoIr(String salida){
       
      
        String  comadoExportacion=salida+"_Ir (PV :="+salida+"_Corriente_r,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\n"
                +"  MAX => "+salida+".Ir_max,\r\n"
                +"  MED => Aux_real,\r\n"
                +"  MIN => Aux_real);\r\n";

        return comadoExportacion;
    }

    static String funcionCalculof(String salida){
       
      
        String  comadoExportacion=salida+"_f (PV :="+salida+"_Frecuencia,\r\n"
                +"  RST := "+salida+"_RST_VAL,\r\n"
                +"  MAX => Aux_real,\r\n"
                +"  MED => Aux_real,\r\n"
                +"  MIN => "+salida+".f_min);\r\n";

        return comadoExportacion;
    }

    static String funcionCalculoCosfi(String salida){
       
      
        String  comadoExportacion=salida+"_cosfi (PV :="+salida+"_cos_fi,\r\n"
                +"  RST := "+salida+"_RST_VAL\r\n"
                +"  MAX => "+salida+".cosfi_max,\r\n"
                +"  MED => "+salida+".cosfi_med,\r\n"
                +"  MIN => "+salida+".cosfi_min);\r\n";

        return comadoExportacion;
    }


     
      

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
 
            //generaTxt(salidasPlc,"pruebaValor");
     
       
        
    
    public static void generaTxt(List<String> salidasPlc,String ruta){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);
            String cabeceraIf="";
            String pieIf="";
            for(String salida:salidasPlc){
            cabeceraIf="if "+salida+"_Estado_Interruptor or "+salida+"_RST_VAL then\r\n";
            pw.println(cabeceraIf);
            pw.println(funcionCalculoVtn(salida));
            pw.println(funcionCalculoVsn(salida));
            pw.println(funcionCalculoVrn(salida));
            pw.println(funcionCalculoTHDVtr(salida));
            pw.println(funcionCalculoTHDVst(salida));
            pw.println(funcionCalculoTHDVrs(salida));
            pw.println(funcionCalculoTHDIt(salida));
            pw.println(funcionCalculoTHDIs(salida));
            pw.println(funcionCalculoTHDIr(salida));
            pw.println(funcionCalculoIt(salida));
            pw.println(funcionCalculoIs(salida));
            pw.println(funcionCalculoIr(salida));
            pw.println(funcionCalculoIn(salida));
            pw.println(funcionCalculof(salida));
            pw.println(funcionCalculoCosfi(salida));
            pieIf=salida+"_RST_VAL := false;\r\n"
            +"else "+salida+"_RST_VAL := false;\r\nend_if;\r\n";
            pw.println(pieIf);
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
