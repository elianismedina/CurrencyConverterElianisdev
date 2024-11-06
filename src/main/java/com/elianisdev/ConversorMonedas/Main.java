package com.elianisdev.ConversorMonedas;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner lectura = new Scanner(System.in);
		Convertidor converter = new Convertidor("",0,"","");
		boolean salir=true;

		String menu = "++++++++++Conversor de Monedas++++++++++\n" +
                      "1) D\u00F3lar =>> Peso argentino\n\n" +
                      "2) Peso argentino =>> D\u00F3lar\n\n" +
                      "3) D\u00F3lar =>> Peso Chileno\n\n" +
                      "4) Peso Chileno=>> D\u00F3lar\n\n" +
                      "5) D\u00F3lar =>> Real Brasile\u00F1o\n\n" +
                      "6) Real Brasile\u00F1o =>> D\u00F3lar\n\n" +
                      "7) Salir\n\n";
		String menuConverted = "Ingrese la cantidad que deseas convertir:  ";




		while(salir){
			System.out.println(menu);
			try{
				int option = lectura.nextInt();
				if (option == 7) {
					salir = false;
					System.out.println("Gracias por usar el conversor de monedas.");
					break;
				}
				Scanner cantConvertir = new Scanner(System.in);
				System.out.println(menuConverted);
				int qt = cantConvertir.nextInt();
				switch (option) {
					case 1: {
						// Dólar estadounidense -> Peso Argentino
						converter.setCantidad(qt);
						converter.setPrimerPais("USD");
						converter.setSegundoPais("ARS");
						System.out.println(converter.conversion()+"\n");
						break;
					}
					case 2: {
						// Peso Argentino -> Dólar estadounidense
						converter.setCantidad(qt);
						converter.setPrimerPais("ARS");
						converter.setSegundoPais("USD");
						System.out.println(converter.conversion()+"\n");
						break;
					}
					case 3: {
						// Dólar estadounidense -> Peso Chileno
						converter.setCantidad(qt);
						converter.setPrimerPais("USD");
						converter.setSegundoPais("CLP");
						System.out.println(converter.conversion()+"\n");
						break;
					}
					case 4: {
						// Peso Chileno -> Dólar estadounidense
						converter.setCantidad(qt);
						converter.setPrimerPais("CLP");
						converter.setSegundoPais("USD");
						System.out.println(converter.conversion()+"\n");
						break;
					}
					case 5: {
						// Dólar estadounidense -> Real brasileño
						converter.setCantidad(qt);
						converter.setPrimerPais("USD");
						converter.setSegundoPais("BRL");
						System.out.println(converter.conversion()+"\n");
						break;
					}
					case 6: {
						// Real brasileño -> Dólar estadounidense
						converter.setCantidad(qt);
						converter.setPrimerPais("BRL");
						converter.setSegundoPais("USD");
						System.out.println(converter.conversion()+"\n");
						break;
					}default: {
						System.out.println("Opción Inválida. Elija una opción entre 1 y 7.");
						break;
					}
				}
			}catch (InputMismatchException ex){
				System.out.println("Debe ingresar un número entero.");
				lectura.next();
			}
        }

	}
}
