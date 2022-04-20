package com.migra;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

import com.migra.exportClases.ExportErrorCDesha;
import com.migra.exportClases.ExportTxtCalculo;
import com.migra.exportClases.ExportTxtEscrituraScada;
import com.migra.exportClases.ExportTxtTurnos;
import com.migra.exportClases.Messages;
import com.migra.exportClases.MicrologicMB;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;

public class PrimaryController extends Messages {

    @FXML
    private TextField nombreArchivo;
    @FXML
    private TextField cuadroTv;
    @FXML
    private TextField cuadroTv2;
    @FXML
    private TextField cuadroTv3;
    @FXML
    private TextArea cuadroList;
    @FXML
    private TextArea cuadroList2;
    @FXML
    private TextArea cuadroList3;
    @FXML
    private TextArea cuadroList4;
    @FXML
    private TextField salidaTf;
    @FXML
    private TextField ipTf;
    @FXML
    private TextField turnoTf;
    @FXML
    private TextField nombreTf;
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField wordTf;
    @FXML
    private TextField bitTf;
    private int word;
    private int bit;
    @FXML
    private void pasaElTexto() throws IOException {

        if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Exportar Cálculos")) {

            pasaElTextoA(cuadroList, cuadroTv);

        } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Variables que faltan en excel")) {

            pasaElTextoA(cuadroList2, cuadroTv2);
        } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Funcion Escritura SCADA")) {

            pasaElTextoA(cuadroList3, cuadroTv3);

        } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Turnos")) {

            pasaLosTextosA(salidaTf, ipTf, turnoTf, nombreTf, cuadroList4);
        }

    }



    @FXML
    public Optional<String> explorar() {
        String ruta = null;
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Buscar Imagen");
        File file = directoryChooser.showDialog(null);
        if (file != null) {

            ruta = file.getAbsolutePath() + "\\" + nombreArchivo.getText();
        }
        return Optional.of(ruta);
    }

    private void pasaLosTextosA(TextField salidaTf2, TextField ipTf2, TextField turnoTf2, TextField nombreTf2,
            TextArea cuadroList) {

        if (!salidaTf2.getText().isEmpty() && !ipTf2.getText().isEmpty() && !turnoTf2.getText().isEmpty()
                && !nombreTf2.getText().isEmpty()) {
            String cadena = "";
            cadena = cuadroList.getText();
            if (cadena.isEmpty()) {
                cadena = salidaTf2.getText() + "," + ipTf2.getText() + "," + turnoTf2.getText() + ","
                        + nombreTf2.getText();
            } else {
                cadena = salidaTf2.getText() + "," + ipTf2.getText() + "," + turnoTf2.getText() + ","
                        + nombreTf2.getText() + "\n" + cadena;
            }

            cuadroList.setText(cadena);
        }

    }

    @FXML
    private void ConvierteTxt() {
        convierteRuta(explorar()).ifPresentOrElse(x -> {
            if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Exportar Cálculos")) {

                ExportTxtCalculo.generaTxt(generaLista(cuadroList), x);

            } else if (tabPane.getSelectionModel().getSelectedItem().getText()
                    .equals("Variables que faltan en excel")) {
                controlaMarca();
                ExportErrorCDesha.generarXml(generaLista(cuadroList2), x,bit,word);

            } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Funcion Escritura SCADA")) {

                ExportTxtEscrituraScada.crearEscrituras(generaLista(cuadroList3), x);

            } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Turnos")) {
                List<MicrologicMB> micrologics = consigueMB(cuadroList4);
                if (micrologics != null) {
                    ExportTxtTurnos.generarTrunos(micrologics, x);

                }
            }
        },() ->   error("Error en la ruta", new Exception()));

    }



    private void controlaMarca() {
        if(wordTf==null || wordTf.getText().isEmpty()||wordTf.getText().matches("[^0-9]")){
            word=0;
        }else{
            word=Integer.valueOf(wordTf.getText());
            
        }
        if(bitTf==null || bitTf.getText().isEmpty()||bitTf.getText().matches("[^0-9]")){
            bit=0;
        }else{
            bit=Integer.valueOf(bitTf.getText());
            
        }
    }



    @FXML
    private void cambiaNombreArchivo() {
        if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Exportar Cálculos")) {
            if(this.nombreArchivo!=null)nombreArchivo.setText("Calculos.txt");

        } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Variables que faltan en excel")) {

            nombreArchivo.setText("Declaracion_variables.xml");
        } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Funcion Escritura SCADA")) {

            nombreArchivo.setText("Declaracion_ordenes.txt");

        } else if (tabPane.getSelectionModel().getSelectedItem().getText().equals("Turnos")) {
            nombreArchivo.setText("Declaracion_turnos.txt");
        }
    }

    private List<MicrologicMB> consigueMB(TextArea cuadroList) {
        StringTokenizer st = new StringTokenizer(cuadroList.getText(), "\n");
        List<MicrologicMB> micrologics = new ArrayList<MicrologicMB>();
        while (st.hasMoreTokens()) {

            String[] atributos = st.nextToken().split(",");
            if (atributos.length == 4) {
                micrologics.add(
                        new MicrologicMB(atributos[0], atributos[1], Double.parseDouble(atributos[2]), atributos[3]));

            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Aviso");
                alert.setHeaderText(null);
                alert.setContentText("Hay alguna línea que no cumple los requisitos");
                alert.showAndWait();
                return null;
            }

        }

        return micrologics;
    }

    private static List<String> generaLista(TextArea cuadroList) {
        List<String> salidas = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(cuadroList.getText(), "\n");

        while (st.hasMoreTokens()) {
            salidas.add(st.nextToken());
        }

        return salidas;
    }

    private Optional<String> convierteRuta(Optional<String> rutaS) {
        String ruta = null;
        if (rutaS.isPresent()) {

            ruta = rutaS.get().replace("\\", "\\\\");

        }
        return Optional.of(ruta);

    }

    private static void pasaElTextoA(TextArea cuadroList, TextField cuadroTv) {

        if (!cuadroTv.getText().isEmpty()) {
            String cadena = "";
            cadena = cuadroList.getText();
            if (cadena.isEmpty()) {
                cadena = cuadroTv.getText();
            } else {
                cadena = cuadroTv.getText() + "\n" + cadena;
            }

            cuadroList.setText(cadena);
        }
    }

}
