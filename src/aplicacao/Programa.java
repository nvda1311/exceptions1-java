package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("N�mero do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data do check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva. O check-out � anterior ao check-in.");
		}else {
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			
			System.out.println("Reserva: " + reserva + " dias.");
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva: ");
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
				String erro = reserva.atualizacaoDatas(checkIn, checkOut);
				if(erro != null) {
						System.out.println("Erro na reserva: " + erro);
					}else {
						System.out.println("Reserva atualizada: " + reserva + " dias.");
					}
				
			}	
		sc.close();
		
	}
}
