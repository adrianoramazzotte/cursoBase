package com.ramazzotte.estudoBase.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ramazzotte.estudoBase.domain.Cliente;
import com.ramazzotte.estudoBase.domain.ItemPedido;
import com.ramazzotte.estudoBase.domain.PagamentoComBoleto;
import com.ramazzotte.estudoBase.domain.Pedido;
import com.ramazzotte.estudoBase.domain.enuns.EstadoPagamento;
import com.ramazzotte.estudoBase.repository.ItemPedidoRepository;
import com.ramazzotte.estudoBase.repository.PagamentoRepository;
import com.ramazzotte.estudoBase.repository.PedidoRepository;
import com.ramazzotte.estudoBase.security.UserSS;
import com.ramazzotte.estudoBase.services.exception.AuthorizationException;
import com.ramazzotte.estudoBase.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private EmailService emailservice;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		emailservice.sendOrderConfirmationHtmlEmail(obj);			
		emailservice.sendOrderConfirmationHtmlEmail(obj);		
		return obj;
	}
	
	public Page<Pedido >findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		UserSS user = UserService.authenticated();
		if(user==null) {
			throw new AuthorizationException("Acesso negado");
			
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction),orderBy);
		Cliente cliente = clienteService.find(user.getId());
		return repo.findByCliente(cliente, pageRequest);
	}
}
