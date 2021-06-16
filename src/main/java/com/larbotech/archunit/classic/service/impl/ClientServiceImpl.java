package com.larbotech.archunit.classic.service.impl;


import java.util.Optional;

import com.larbotech.archunit.classic.service.ClientService;
import com.larbotech.archunit.classic.service.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.larbotech.archunit.classic.model.Client;
import com.larbotech.archunit.classic.repository.ClientRepository;

@Service
public class ClientServiceImpl extends ServiceBase implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Boolean delete(Long id) {

        Optional<Client> client = clientRepository.findById(id);

        if(client.isPresent()) {
            client.get().setActive(Boolean.FALSE);
            clientRepository.save(client.get());
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
