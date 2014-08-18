package com.hotelcalifornia.controller.funcionario;

import com.hotelcalifornia.model.bo.QuartoBo;
import com.hotelcalifornia.model.objects.Quarto;

public class CadastroQuartoControl {
	
	private QuartoBo quartoBO;
	
	public CadastroQuartoControl(){
		this.quartoBO = new QuartoBo();
	}
	
	public boolean cadastraQuarto(Quarto quarto){
		return quartoBO.salvar(quarto);
	}

}
