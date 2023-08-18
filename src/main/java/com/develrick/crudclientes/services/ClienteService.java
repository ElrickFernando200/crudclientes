package com.develrick.crudclientes.services;

import com.develrick.crudclientes.dtos.ClienteDTO;
import com.develrick.crudclientes.entities.Cliente;
import com.develrick.crudclientes.repositories.ClienteRepository;
import com.develrick.crudclientes.services.exceptions.RecursoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoException("Recurso não existe"));
        return  new ClienteDTO(cliente);
    }

    @Transactional(readOnly = true)
    public Page<ClienteDTO> findAll(Pageable pageable){
        return clienteRepository.findAll(pageable).map(c -> new ClienteDTO(c));
    }

    @Transactional
    public ClienteDTO save(ClienteDTO dto){
        Cliente c = new Cliente();
        copiaDTO(dto,c);
        c = clienteRepository.save(c);
        return new ClienteDTO(c);
    }

    @Transactional
    public ClienteDTO update(Long id, ClienteDTO dto){
        try {
            Cliente entity = clienteRepository.getReferenceById(id);
            copiaDTO(dto, entity);
            entity = clienteRepository.save(entity);
            return new ClienteDTO(entity);
        } catch(EntityNotFoundException e){
            throw new RecursoException("Recurso inválido");
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id){
        if (!clienteRepository.existsById(id)){
            throw new RecursoException("Recurso inexistente");
        }
        clienteRepository.deleteById(id);
    }


    public void copiaDTO(ClienteDTO dto, Cliente entity){
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setRenda(entity.getRenda());
        entity.setDataNascimento(entity.getDataNascimento());
        entity.setQuantidadeFilhos(entity.getQuantidadeFilhos());
    }
}
