import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
public class NReinas {
	 final int N = 8; 
	    void mostrarResultado(int tablero[][]) 
	    { 
	        for (int i = 0; i < N; i++) { 
	            for (int j = 0; j < N; j++) 
	                System.out.print(" " + tablero[i][j] 
	                                 + " "); 
	            System.out.println(); 
	        } 
	    } 
	  
	    boolean esSeguro(int tablero[][], int row, int col) 
	    { 
	        int i, j; 
	        for (i = 0; i < col; i++) 
	            if (tablero[row][i] == 1) 
	                return false; 
	        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
	            if (tablero[i][j] == 1) 
	                return false; 
	        for (i = row, j = col; j >= 0 && i < N; i++, j--) 
	            if (tablero[i][j] == 1) 
	                return false; 
	  
	        return true; 
	    } 
	    boolean ResolverNReinasUtil(int tablero[][], int col) 
	    { 
	        if (col >= N) 
	            return true; 
	        for (int i = 0; i < N; i++) { 
	            if (esSeguro(tablero, i, col)) { 
	                tablero[i][col] = 1; 
	                if (ResolverNReinasUtil(tablero, col + 1) == true) 
	                    return true; 
	                tablero[i][col] = 0; // BACKTRACKIN 
	            } 
	        } 
	        return false; 
	    } 
	 
	    boolean resolverNreinas() 
	    { 
	        int tablero[][] = { { 0, 0, 0, 0,0, 0, 0, 0 }, 
								{ 0, 0, 0, 0,0, 0, 0, 0 }, 
	                            { 0, 0, 0, 0,0, 0, 0, 0 }, 
								{ 0, 0, 0, 0,0, 0, 0, 0 },
								{ 0, 0, 0, 0,0, 0, 0, 0 }, 
								{ 0, 0, 0, 0,0, 0, 0, 0 }, 
	                            { 0, 0, 0, 0,0, 0, 0, 0 }, 
								{ 0, 0, 0, 0,0, 0, 0, 0 } }; 
	  
	        if (ResolverNReinasUtil(tablero, 0) == false) { 
	            System.out.print("La Soluci�n no existe"); 
	            return false; 
	        } 
	  
	        mostrarResultado(tablero); 
	        return true; 
	    } 
	  
	   
	    public static void main(String args[]) 
	    { 
	        NReinas Reina = new NReinas(); 
	        Reina.resolverNreinas(); 
	    } 
	} 