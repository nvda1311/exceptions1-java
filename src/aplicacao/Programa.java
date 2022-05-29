package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Reserva;
import model.excecoes.ExcecaoDeDominio;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			
			System.out.println("Reserva: " + reserva + " dias.");
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva: ");
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizacaoDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}	
		catch (ParseException e){
			System.out.println("Fromato de data inválido.");
		}
		catch(ExcecaoDeDominio e) {

			System.out.println("Erro na reserva " + e.getLocalizedMessage());
		
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado.");
		}
		
		sc.close();
		
	}
}
