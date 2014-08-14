package com.hotelcalifornia.view;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

import com.hotelcalifornia.model.objects.Quarto;
import com.hotelcalifornia.model.objects.TipoQuarto;

public class TableQuarto extends AbstractTableModel {
	
	private static final int COL_NUM = 0;
	private static final int COL_VALOR = 1;
	private static final int COL_TIPO = 2;
	List<Quarto> linhas;
	private String[] colunas = new String[]{"Numero","Preco Diaria","Tipo Quarto"};
	
	

	/**
	 * Create the panel.
	 */
	public TableQuarto(List<Quarto> quartos) {
		this.linhas =  quartos;
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
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case COL_NUM:
			return Integer.class;
		case COL_TIPO:
			return TipoQuarto.class;
		case COL_VALOR:
			return Double.class;
		default:
			return null;
		
		}
		
		
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int row,int column) {
		Quarto quarto = linhas.get(row);
		
		switch (column) {
		case COL_NUM:
			return quarto.getNumero();
		case COL_TIPO:
			return quarto.getTipoQuarto();
		case COL_VALOR:
			return quarto.getValorDiaria();
		default:
			return "";
		}
		
	}
	
	
	
	public Quarto getQuarto(int indiceLinha){
		return linhas.get(indiceLinha);
	}
	
	
	public void addListaDeQuartos(List<Quarto> quartos) {
		// Pega o tamanho antigo da tabela.
		int tamanhoAntigo = getRowCount();

		// Adiciona os registros.
		linhas.addAll(quartos);

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
