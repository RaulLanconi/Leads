/*
 * UtilErrorInputOutput.java
 *
 * Classe que inclui uma coleção de métodos úteis em diversas situações,
 * como validação de dados a tratamento de excessões.
 *
 * © 2017 - Raul Lançoni de Paula - Todos os direitos reservados.
 *
 * Histórico
 * 24/11/2017 - Versão 1.0 - Raul Lançoni de Paula - Criação do arquivo.
 *
 */
package com.raullanconi.leads.util;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 
 * Classe de TRATAMENTO DE EXCESSÕES DE ENTRADA DE DADOS PELO TECLADO.
 * 
 * Realiza tratamento de excessões em leitura de caracteres (byte, short, int,
 * long, float, double, char e String, obrigando o sistema a repetir a
 * solicitação de entrada de dados enquando um valor válido e sem erros não
 * for inserido quando solicitado, sendo assim, evitanto que erros inesperados
 * acontecam em tempo de execução que possam  causar uma parada brusca e
 * finalizar o sistema.
 * 
 * Versão 2.5.1
 * 
 * @author Raul Lançoni de Paula
 * 
 */
public final class UtilErrorInputOutput {

    /**
     * Atributo SCAN resposavel por armazenar o dado a ser tratato.
     * static - é inerente a propria classe e nao a um objeto;
     * final - é um atributo constante;
     */
    private static Scanner SCAN;

    static {
    	 SCAN = new Scanner(System.in);
    }
    
    /**
     * Metodo que faz tratamento de excessao exclusivamente do tipo de dado BYTE.
     * 
     * @return Byte.parseByte(SCAN.nextLine())
     */
    public static byte lerByte() {
    	
    	byte b;
    	SCAN = new Scanner(System.in);
    	
        while(true) {
        	
            try {
            	
                b =  Byte.parseByte(SCAN.nextLine());
                break;
                
            }
            catch(Exception e) {
            	
                System.out.print("Valor inválido. Digite outro valor: ");
                
            }
            
        }
        
        fecharException_T();
        
        return b;
        
    }
    
    /**
     * Metodo que faz tratamento de excessao exclusivamente do tipo de dado SHORT.
     * 
     * @return Short.parseShort(SCAN.nextLine())
     */
    public static short lerShort() {
    	
    	short s;
    	SCAN = new Scanner(System.in);
    	
        while(true) {
        	
            try {
            	
                s =  Short.parseShort(SCAN.nextLine());
                break;
                
            }
            catch(Exception e) {
            	
                System.out.print("Valor inválido. Digite outro valor: ");
                
            }
            
        }

        fecharException_T();
        
        return s;
        
    }
    
    /**
     * Metodo que faz tratamento de excessao exclusivamente do tipo de dado INTEGER.
     * 
     * @return Integer.parseInt(SCAN.nextLine())
     */
    public static int lerInt() {
    	
    	int i;
    	SCAN = new Scanner(System.in);
    	
        while(true) {
        	
            try {
            	
                i =  Integer.parseInt(SCAN.nextLine());
                break;
                
            }
            catch(Exception e) {
            	
                System.out.print("Valor inválido. Digite outro valor: ");
                
            }
            
        }

        fecharException_T();
        
        return i;
        
    }
    
    /**
     * Metodo que faz tratamento de excessao exclusivamente do tipo de dado LONG.
     * 
     * @return Long.parseLong(SCAN.nextLine())
     */
    public static long lerLong() {
    	
    	long l;
    	SCAN = new Scanner(System.in);
    	
        while(true) {
        	
            try {
            	
                l = Long.parseLong(SCAN.nextLine());
                break;
                
            }
            catch(Exception e) {
            	
                System.out.print("Valor inválido. Digite outro valor: ");
                
            }
            
        }

        fecharException_T();
        
        return l;
        
    }

    /**
     * Metodo que faz tratamento de excessao exclusivamente do tipo de dado FLOAT.
     * 
     * @return Float.parseFloat(SCAN.nextLine())
     */
    public static float lerFloat() {
    	
    	float f;
    	SCAN = new Scanner(System.in);
    	
        while(true) {
        	
            try {
            	
                f = Float.parseFloat(SCAN.nextLine());
                break;
                
            }
            catch(Exception e) {
            	
                System.out.print("Valor inválido. Digite outro valor: ");
                
            }
            
        }

        fecharException_T();
        
        return f;
        
    }
    
    /**
     * Metodo que faz tratamento de excessao exclusivamente do tipo de dado DOUBLE.
     * 
     * @return Double.parseDouble(SCAN.nextLine())
     */
    public static double lerDouble() {
    	
    	double d;
    	SCAN = new Scanner(System.in);
    	
        while(true) {
        	
            try {
            	
                d = Double.parseDouble(SCAN.nextLine());
                break;
                
            }
            catch(Exception e) {
            	
                System.out.print("Valor inválido. Digite outro valor: ");
                
            }
            
        }

        fecharException_T();
        
        return d;
        
    }

    /**
     * Metodo que faz tratamento de excessao exclusivamente do tipo de dado CHAR.
     * 
     * @return (ch = (char) System.in.read())
     */
    public static char lerChar() {

    	char ch = 0;
    	
        while(true) {
        	
            try {
            	
                ch = (char) System.in.read();
                break;
                
            }
            catch(IOException erro) {
            	
            	System.out.print("Valor inválido. Digite outro valor: ");
            	
            }
            
        }
        
        //SCAN.nextLine();
        
        return ch;
        
    }
    
     /**
     * Metodo que faz tratamento de excessao exclusivamente do tipo de dado STRING.
     * 
     * @return SCAN.nextLine()
     */
    public static String lerString() {
    	
    	String s;
    	
        while(true) {
        	
            try {
            	
                s = SCAN.nextLine();
                break;
                
            }
            catch(Exception e) {
            	
                System.out.print("Valor inválido. Digite outro valor: ");
                
            }
            
        }
        
        return s;
        
    }
    
    /**
     * Metodo que faz tratamento de excessao exclusivamente do tipo de dado BOOLEAN.
     * 
     * @return Boolean.parseBoolean(SCAN.nextLine())
     */
    public static boolean lerBoolean() {
    	
    	boolean b;
    	SCAN = new Scanner(System.in);
    	
        while(true) {
        	
            try {
            	
                b = Boolean.parseBoolean(SCAN.nextLine());
                break;
                
            }
            catch(Exception e) {
            	
                System.out.print("Valor inválido. Digite outro valor: ");
                
            }
            
        }

        fecharException_T();
        
        return b;
        
    }
    
    /**
     * Metodo que fecha o objeto SCAN.
     */
    public static void fecharException_T() {
    	
        SCAN.close();
        
    }
    
    /**
     * Metodo que mostra as mensagens de erro das exceptions.
     * 
     * @param pException
     * @param pMensagem
     */
    public static void mostrarErro(Exception pException, String pMensagem) {
		
		System.out.println("\n" + pMensagem);
		System.out.println("Exception... : " + pException.getClass().getName());
		System.out.println("Mensagem.... : " + pException.getMessage());
		
		if(pException instanceof SQLException) {
			
			SQLException sqlException = (SQLException)pException;
			System.out.println("SQLState.... : " + sqlException.getSQLState());
			System.out.println("Error Code.. : " + sqlException.getErrorCode());
			DriverManager.println("SQLState.... : " + sqlException.getSQLState());
			DriverManager.println("Error Code.. : " + sqlException.getErrorCode());
			
		}
		
		Throwable causa = pException.getCause();
		
		while(causa != null) {
			
			System.out.println("Causa....... : " + causa.getMessage());
			causa = causa.getCause();
			
		}
		
		System.out.println("Pilha de Execução: ");
		pException.printStackTrace(System.out);
		
	}

}