package com.pmdf.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.pmdf.dscatalog.dto.ItemPedidoDTO;
import com.pmdf.dscatalog.dto.PedidoDTO;
//import com.pmdf.dscatalog.entities.ItemPedido;
import com.pmdf.dscatalog.entities.Pedido;
//import com.pmdf.dscatalog.repositories.ItemPedidoRepository;
import com.pmdf.dscatalog.repositories.PedidoRepository;
import com.pmdf.dscatalog.services.exceptions.ResourceNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	//@Autowired
	//private ItemPedidoRepository itemPedidoRepository;
	
	
	
	

	@Transactional(readOnly = true)
	public List<PedidoDTO> findAll() {
		List<Pedido> list = repository.findAll();

		return list.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());

	}

	// Método FindById - Para buscar todas as categorias por Id
	@Transactional(readOnly = true)
	public PedidoDTO findbyId(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		Pedido entity = obj.orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
		return new PedidoDTO(entity);
	}
	
	
	// Método auxiliar copyDtoToEntity
//	private void copyDtoToEntity(PedidoDTO dto, Pedido entity) {
//		entity.setDate(dto.getDate());
//		entity.setPagamento(dto.getPagamento());
//		entity.setCliente(dto.getCliente());
//	
//
//		// Carregando os pedidos no dto para a entidade
//		entity.getItens().clear(); // para limpar as categorias
//		for (ItemPedidoDTO itensDto : dto.getItens()) {
//			ItemPedido itens = itemPedidoRepository.getOne(itensDto.getId());
//			entity.getItens().add(itens);
//
//		}
//
//	}
	
	
	
	

}
