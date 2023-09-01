package com.pegue.pague.api.service.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pegue.pague.api.Repository.ClienteCustomRepository;
import com.pegue.pague.api.Repository.ClienteRepository;
import com.pegue.pague.api.Repository.PessoaRepository;
import com.pegue.pague.api.Repository.TelefoneRepository;
import com.pegue.pague.api.controller.dto.ClienteDto;
import com.pegue.pague.api.controller.dto.TelefoneDto;
import com.pegue.pague.api.entity.Cliente;
import com.pegue.pague.api.entity.Pessoa;
import com.pegue.pague.api.entity.Telefone;
import com.pegue.pague.api.service.ClienteService;



@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private PessoaRepository repoPessoa;
	@Autowired
	private TelefoneRepository repoTel;

	@Autowired
	private ClienteRepository repoCli;

	@Autowired
	private ClienteCustomRepository repoCustomCli;

	
	@Override
	@Transactional
	public Cliente save(ClienteDto dto) {

		Pessoa pessoa = new Pessoa();
		Cliente cliente = new Cliente();
		String cpfcnpj = dto.getCpfCnpj();
		cpfcnpj = cpfcnpj.replace(".", "");
		cpfcnpj = cpfcnpj.replace("-", "");

		pessoa.setCpfCnpj(cpfcnpj);
		pessoa.setEmail(dto.getEmail());
		pessoa.setNome(dto.getNome().trim());
		pessoa.setCliente("S");
		pessoa.setTipoPessoa(dto.getTipoPessoa());
		cliente.setPessoa(pessoa);
		cliente.setAtivo(true);
		cliente.setDataCadastro(new Date());
		repoPessoa.save(pessoa);

		if (!dto.getTelefones().isEmpty()) {
			List<Telefone> telefones = telefoneForDto(pessoa, dto.getTelefones());
			repoTel.saveAll(telefones);

		}

		repoCli.save(cliente);
		return cliente;
	}

	@Override
	public List<ClienteDto> findByAllCliente() {
		return repoCustomCli.findByAllCliente().stream().map(this::convertClienteClienteDto)
				.collect(Collectors.toList());
	}

	private List<Telefone> telefoneForDto(Pessoa pessoa, List<TelefoneDto> telDto) {
		if (telDto.isEmpty()) {
			return null;
		}

		return telDto.stream().map(dto -> {
			Telefone telefones = new Telefone();
			telefones.setTipoTelefone(dto.getTipoTelefone());
			telefones.setDdd(dto.getDdd());
			telefones.setOperadora(dto.getOperadora());
			telefones.setNumero(dto.getNumero());
			telefones.setPessoa(pessoa);
			return telefones;

		}).collect(Collectors.toList());
	}


	private ClienteDto convertClienteClienteDto(Cliente cli) {
		ClienteDto dto = new ClienteDto();
		dto.setAtivo(cli.getAtivo());
		dto.setCpfCnpj(cli.getPessoa().getCpfCnpj());
		dto.setNome(cli.getPessoa().getNome());
		return dto;
	}


	@Override
	public Pessoa editar(Pessoa pes, Long codigo) {
		Pessoa pessoa = repoPessoa.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
		Cliente cli = repoCli.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
		String cpfcnpj = pes.getCpfCnpj();
		cpfcnpj = cpfcnpj.replace(".", "");
		cpfcnpj = cpfcnpj.replace("-", "");
		pessoa.setNome(pes.getNome());
		pessoa.setCpfCnpj(cpfcnpj);
		pessoa.setEmail(pes.getEmail());
		cli.setLimiteCredido(pes.getClienteObject().getLimiteCredido());

		
		pessoa.getTelefones().clear();
		pessoa.getTelefones().addAll(pes.getTelefones());
		pessoa.getTelefones().forEach( c -> c.setPessoa(pessoa) );
		
//		BeanUtils.copyProperties(pes, pessoa, "limiteCredido");
		repoPessoa.save(pessoa);
		return pessoa;
	}

	@Override
	public Optional<ClienteDto> findByIdCliente(Long codigo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
	

}
