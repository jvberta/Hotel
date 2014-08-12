package com.hotelcalifornia.model.dao.endereco;

import org.springframework.stereotype.Repository;

import com.hotelcalifornia.model.dao.BasicDao;
import com.hotelcalifornia.model.objects.Endereco;


@Repository("enderecoDao")
public class EnderecoDaoImpl extends BasicDao<Endereco, Long> implements EnderecoDao{
	
}
