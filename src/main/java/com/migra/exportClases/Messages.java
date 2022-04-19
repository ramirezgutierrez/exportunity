package com.migra.exportClases;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Messages  {
    public static void exito(String ruta){
        ruta=ruta.replace("\\\\", "\\");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("El archivo se ha creado en: ");
        alert.setContentText(ruta);
        alert.showAndWait();
    }
    public static void error(String ruta,Exception e){
        ruta=ruta.replace("\\\\", "\\");
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText("Ha habido algún error en la exportacion en la ruta:"+ruta+"\n\n"+e.getMessage());
        alert.showAndWait();
       
    }

}
