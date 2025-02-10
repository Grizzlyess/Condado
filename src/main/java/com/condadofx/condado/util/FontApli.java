package com.condadofx.condado.util;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class FontApli {

    private String pfont = "src/main/resources/com/condadofx/condado/font/UncialAntiqua-Regular.ttf";

    // Use na hora de aplicar fonte a um único texto
    public void AplicarFonte1Tx(Text tx){
        try {
            Font font = Font.loadFont(new FileInputStream(pfont),tx.getFont().getSize());
            tx.setFont(font);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Use na hora de aplicar fonte a uma única label
    public void AplicarFonte1Label(Label lb){
        try {
            Font font = Font.loadFont(new FileInputStream(pfont),lb.getFont().getSize());
            lb.setFont(font);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Aplica fonte em uma lista de Textos
    public void AplicarFonteTx(List<Text>ListaT){
        for (Text tx: ListaT){
            try {
                Font font = Font.loadFont(new FileInputStream(pfont),tx.getFont().getSize());
                tx.setFont(font);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Aplica fonte em uma lista de TextFields (Talvez não precise usar)
    public void AplicarFonteTxField(List<TextField>ListaTF){
        for (TextField tx: ListaTF){
            try {
                Font font = Font.loadFont(new FileInputStream(pfont),tx.getFont().getSize());
                tx.setFont(font);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Aplica fonte em uma lista de Labels
    public void AplicarFonteLabel(List<Label>ListaLB){
        for (Label tx: ListaLB){
            try {
                Font font = Font.loadFont(new FileInputStream(pfont),tx.getFont().getSize());
                tx.setFont(font);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}