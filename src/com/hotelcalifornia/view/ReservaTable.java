package com.hotelcalifornia.view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.Reserva;
import com.hotelcalifornia.model.objects.TipoQuarto;

public class ReservaTable extends AbstractTableModel{
	
	private static final int COL_CLIENTE = 0;
	private static final int COL_NUM = 1;
	private static final int COL_VALOR = 2;
	private static final int COL_DATA_ENTRADA = 3;
	private static final int COL_DATA_SAIDA = 4;
	private static final int COL_TOTAL = 5;
	
	
	List<Reserva> linhas;
	private String[] colunas = new String[]{"Cliente","Numero Quarto","Preco Diaria","Data Entrada","Data Saida","Total"};
	
	

	/**
	 * Create the panel.
	 */
	public ReservaTable(List<Reserva> reservas) {
		this.linhas =  reservas;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.linhas.size();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colunas[column];
	}
	
	
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	@Override
	public Object getValueAt(int row,int column) {
		Reserva reserva = linhas.get(row);
		SimpleDateFormat s = new SimpleDateFormat("dd/M/yyyy");
		switch (column) {
		case COL_NUM:
			return reserva.getQuarto().getNumero();
		case COL_CLIENTE:
			return reserva.getCliente().getNome();
		case COL_VALOR:
			return reserva.getPrecoCobranca();
		case COL_DATA_ENTRADA:
			return s.format(reserva.getDataEntrada().getTime());
		case COL_DATA_SAIDA:
			if(reserva.getDataSaida() == null){
				return "";
			}else{
				return s.format(reserva.getDataSaida().getTime());
			}
		case COL_TOTAL:
			if(reserva.getDataSaida() == null){
				return "Em Aberto";
			}else{
				return reserva.calculaTotal();
			}
		default:
			return "";
		}
		
	}
	
	
	
	public Reserva getReserva(int indiceLinha){
		return linhas.get(indiceLinha);
	}
	
	
	public void addListaReserva(List<Reserva> reserva) {
		// Pega o tamanho antigo da tabela.
		int tamanhoAntigo = getRowCount();

		// Adiciona os registros.
		linhas.addAll(reserva);

		// Reporta a mudança. O JTable recebe a notificação
		// e se redesenha permitindo que visualizemos a atualização.
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	
	
	
	/* Remove todos os registros. */
	
	public void limpar() {
		// Remove todos os elementos da lista de sócios.
		linhas.clear();

		// Reporta a mudança. O JTable recebe a notificação
		// e se redesenha permitindo que visualizemos a atualização.
		fireTableDataChanged();
	}


}
