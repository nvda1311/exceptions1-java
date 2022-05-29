package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excecoes.ExcecaoDeDominio;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) throws ExcecaoDeDominio {
		if(!checkOut.after(checkIn)) {
			throw new ExcecaoDeDominio("Data de check-out deve ser superior à data de check-in.");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizacaoDatas(Date checkIn, Date checkOut) throws ExcecaoDeDominio {
		Date agora = new Date();
		if(checkIn.before(agora) || checkOut.before(agora)){
			throw new ExcecaoDeDominio("Datas para atualização de reservas devem ser para datas futuras.");
		}
		if(!checkOut.after(checkIn)) {
			throw new ExcecaoDeDominio("Data de check-out deve ser após a data de check-in.");
		}
			
			this.checkIn = checkIn;
			this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", duração: "
				+ duracao();
				
	}

}
