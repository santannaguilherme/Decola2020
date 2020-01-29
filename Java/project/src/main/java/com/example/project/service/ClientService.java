package com.example.project.service;

import java.util.List;
import java.util.Optional;

import com.example.project.domain.entities.Client;
import com.example.project.exception.DataNotFoundException;
import com.example.project.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client model) {
        return clientRepository.save(model);
    }

    public List<Client> listClient() {
        return clientRepository.findAll();
    }

	public Client findById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new DataNotFoundException("Client Not found"));
    }
    
    public void deletClient(Integer id)throws DataNotFoundException{
        findById(id);
        clientRepository.deleteById(id);
    }

    public Client updateClient(Client model,Integer id) throws DataNotFoundException{
        Client c = findById(id);
        c.setName(model.getName());
        c.setPhone(model.getPhone());
        return clientRepository.save(c);
        
    }
    public  List<String> listDistinct() {
        return clientRepository.listDistinct();
    }
    
    public  List<Client> listByPhone(String phone) {
        return clientRepository.findByPhone(phone);
	}

}