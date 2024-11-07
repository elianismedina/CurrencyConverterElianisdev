package com.elianisdev.ConversorMonedas;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner lectura = new Scanner(System.in);
		Convertidor converter = new Convertidor("",0,"","");
		boolean salir=true;

		String menu = """
                +++++++++++CURRENCY CONVERTER++++++++++
                Seleccione la operación que desea realizar:
                1) Dólar =>> Peso argentino
                
                2) Peso argentino =>> Dólar
                
                3) Dólar =>> Peso Chileno
                
                4) Peso Chileno=>> Dólar
                
                5) Dólar =>> Real Brasileño
                
                6) Real Brasileño =>> Dólar
                
                7) Salir
                
                """;
		String menuConverted = "Ingrese la cantidad que deseas convertir: ";

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
				int amount = cantConvertir.nextInt();
				switch (option) {
					case 1: {
						// Dólar estadounidense -> Peso Argentino
						converter.setCantidad(amount);
						converter.setPrimerPais("USD");
						converter.setSegundoPais("ARS");
						System.out.println(converter.conversion()+"\n");
						break;
					}
					case 2: {
						// Peso Argentino -> Dólar estadounidense
						converter.setCantidad(amount);
						converter.setPrimerPais("ARS");
						converter.setSegundoPais("USD");
						System.out.println(converter.conversion()+"\n");
						break;
					}
					case 3: {
						// Dólar estadounidense -> Peso Chileno
						converter.setCantidad(amount);
						converter.setPrimerPais("USD");
						converter.setSegundoPais("CLP");
						System.out.println(converter.conversion()+"\n");
						break;
					}
					case 4: {
						// Peso Chileno -> Dólar estadounidense
						converter.setCantidad(amount);
						converter.setPrimerPais("CLP");
						converter.setSegundoPais("USD");
						System.out.println(converter.conversion()+"\n");
						break;
					}
					case 5: {
						// Dólar estadounidense -> Real brasileño
						converter.setCantidad(amount);
						converter.setPrimerPais("USD");
						converter.setSegundoPais("BRL");
						System.out.println(converter.conversion()+"\n");
						break;
					}
					case 6: {
						// Real brasileño -> Dólar estadounidense
						converter.setCantidad(amount);
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
				System.out.println("Por favor ingrese un número entero.");
				lectura.next();
			}
        }

	}
}
