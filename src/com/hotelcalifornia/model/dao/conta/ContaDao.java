package com.hotelcalifornia.model.dao.conta;

import com.hotelcalifornia.model.dao.GenericDao;
import com.hotelcalifornia.model.objects.Conta;

public interface ContaDao extends GenericDao<Conta, Long>{

	public void pagarConta(Conta c);
}
