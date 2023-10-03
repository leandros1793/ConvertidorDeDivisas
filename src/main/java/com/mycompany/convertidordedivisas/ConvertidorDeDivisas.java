package com.mycompany.convertidordedivisas;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class ConvertidorDeDivisas {
    public static void main(String[] args) {
        DecimalFormat formato = new DecimalFormat("0.00");

        String[] monedas = {"Peso Argentino", "Dólar", "Euro", "Libra Esterlina", "Yen Japonés", "Won Surcoreano"};

        String monedaOrigen = (String) JOptionPane.showInputDialog(null, "Selecciona la moneda de origen:",
                                                                    "Convertidor de Divisas",
                                                                    JOptionPane.PLAIN_MESSAGE,
                                                                    null, monedas, monedas[0]);

        String monedaDestino = (String) JOptionPane.showInputDialog(null, "Selecciona la moneda de destino:",
                                                                     "Convertidor de Divisas",
                                                                     JOptionPane.PLAIN_MESSAGE,
                                                                     null, monedas, monedas[0]);

        String cantidadStr = JOptionPane.showInputDialog("Ingresa la cantidad en " + monedaOrigen + ":");
        double cantidad = Double.parseDouble(cantidadStr);
        double resultado = convertirMoneda(monedaOrigen, monedaDestino, cantidad);

        String mensajeResultado = cantidad + " " + monedaOrigen + " son " + formato.format(resultado) + " " + monedaDestino;
        JOptionPane.showMessageDialog(null, mensajeResultado);
    }

    public static double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        // Define las tasas de cambio para cada moneda con respecto al Peso Argentino.
        double tasaPesoADolar = 0.0029;
        double tasaPesoAEuro = 0.0027;
        double tasaPesoALibra = 0.0023;
        double tasaPesoAYen = 0.42;
        double tasaPesoAWon = 3.81;

        double resultado = 0;

        if (monedaOrigen.equals("Peso Argentino")) {
            switch (monedaDestino) {
                case "Dólar":
                    resultado = cantidad * tasaPesoADolar;
                    break;
                case "Euro":
                    resultado = cantidad * tasaPesoAEuro;
                    break;
                case "Libra Esterlina":
                    resultado = cantidad * tasaPesoALibra;
                    break;
                case "Yen Japonés":
                    resultado = cantidad * tasaPesoAYen;
                    break;
                case "Won Surcoreano":
                    resultado = cantidad * tasaPesoAWon;
                    break;
            }
        } else if (monedaOrigen.equals("Dólar")) {
            double tasaDolarAPeso = 1 / tasaPesoADolar;
            switch (monedaDestino) {
                case "Peso Argentino":
                    resultado = cantidad * tasaDolarAPeso;
                    break;
                case "Euro":
                    resultado = cantidad * (tasaPesoAEuro / tasaPesoADolar);
                    break;
                case "Libra Esterlina":
                    resultado = cantidad * (tasaPesoALibra / tasaPesoADolar);
                    break;
                case "Yen Japonés":
                    resultado = cantidad * (tasaPesoAYen / tasaPesoADolar);
                    break;
                case "Won Surcoreano":
                    resultado = cantidad * (tasaPesoAWon / tasaPesoADolar);
                    break;
            }
        } else if (monedaOrigen.equals("Euro")) {
            double tasaEuroAPeso = 1 / tasaPesoAEuro;
            switch (monedaDestino) {
                case "Peso Argentino":
                    resultado = cantidad * tasaEuroAPeso;
                    break;
                case "Dólar":
                    resultado = cantidad / tasaPesoAEuro * tasaPesoADolar;
                    break;
                case "Libra Esterlina":
                    resultado = cantidad / tasaPesoAEuro * tasaPesoALibra;
                    break;
                case "Yen Japonés":
                    resultado = cantidad / tasaPesoAEuro * tasaPesoAYen;
                    break;
                case "Won Surcoreano":
                    resultado = cantidad / tasaPesoAEuro * tasaPesoAWon;
                    break;
            }
        } else if (monedaOrigen.equals("Libra Esterlina")) {
            double tasaLibraAPeso = 1 / tasaPesoALibra;
            switch (monedaDestino) {
                case "Peso Argentino":
                    resultado = cantidad * tasaLibraAPeso;
                    break;
                case "Dólar":
                    resultado = cantidad / tasaPesoALibra * tasaPesoADolar;
                    break;
                case "Euro":
                    resultado = cantidad / tasaPesoALibra * tasaPesoAEuro;
                    break;
                case "Yen Japonés":
                    resultado = cantidad / tasaPesoALibra * tasaPesoAYen;
                    break;
                case "Won Surcoreano":
                    resultado = cantidad / tasaPesoALibra * tasaPesoAWon;
                    break;
            }
        } else if (monedaOrigen.equals("Yen Japonés")) {
            double tasaYenAPeso = 1 / tasaPesoAYen;
            switch (monedaDestino) {
                case "Peso Argentino":
                    resultado = cantidad * tasaYenAPeso;
                    break;
                case "Dólar":
                    resultado = cantidad / tasaPesoAYen * tasaPesoADolar;
                    break;
                case "Euro":
                    resultado = cantidad / tasaPesoAYen * tasaPesoAEuro;
                    break;
                case "Libra Esterlina":
                    resultado = cantidad / tasaPesoAYen * tasaPesoALibra;
                    break;
                case "Won Surcoreano":
                    resultado = cantidad / tasaPesoAYen * tasaPesoAWon;
                    break;
            }
        } else if (monedaOrigen.equals("Won Surcoreano")) {
            double tasaWonAPeso = 1 / tasaPesoAWon;
            switch (monedaDestino) {
                case "Peso Argentino":
                    resultado = cantidad * tasaWonAPeso;
                    break;
                case "Dólar":
                    resultado = cantidad / tasaPesoAWon * tasaPesoADolar;
                    break;
                case "Euro":
                    resultado = cantidad / tasaPesoAWon * tasaPesoAEuro;
                    break;
                case "Libra Esterlina":
                    resultado = cantidad / tasaPesoAWon * tasaPesoALibra;
                    break;
                case "Yen Japonés":
                    resultado = cantidad / tasaPesoAWon * tasaPesoAYen;
                    break;
            }
        }

        return resultado;
    }
}
