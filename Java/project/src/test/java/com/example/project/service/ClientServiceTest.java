package com.example.project.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.project.domain.entities.Client;
import com.example.project.exception.DataNotFoundException;
import com.example.project.repository.ClientRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * ClientServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private ClientRepository repositoryMock;

    @InjectMocks
    private ClientService service;

    private final Integer id = 1;
    private final String name = "Some string";
    private final String phone = "987654321";

    Client entity = Client.builder().id(id).name(name).phone(phone).build();

    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {

        // given no data

        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Client Not found");

        // when
        service.findById(1);
    }

    @Test
    public void should_findById() {

        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

        // when
        Client model = service.findById(anyInt());

        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Client deve ser encontrado!", model);
    }

    @Test
    public void should_ListOneItem() {
        List<Client> list = new ArrayList<>();
        list.add(entity);
        when(repositoryMock.findAll()).thenReturn(list);

        List<Client> listR = service.listClient();

        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", listR);
        assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    }

    @Test
    public void should_CreateClient() {
        when(repositoryMock.save(entity)).thenReturn(entity);

        Client c = service.createClient(entity);
        assertNotNull("Model não deve ser nulo", c);
        assertEquals(entity, c);
    }

    @Test
    public void should_DeleteClient() {

        should_findById();

        // when
        service.deletClient(1);

    }

    @Test
    public void should_UpdateClient() {

        when(repositoryMock.save(entity)).thenReturn(entity);
        should_findById();
        Client c = service.updateClient(entity, 1);

        // Client test = verify(repositoryMock, times(1)).save(entity);
        assertNotNull("Model não deve ser nulo", c);
        assertEquals(entity, c);
    }

    @Test
    public void should_ListByPhone() {
        List<Client> list = new ArrayList<>();
        list.add(entity);
        when(repositoryMock.findByPhone(anyString())).thenReturn(list);

        List<Client> c = service.listByPhone(anyString());

        // Client test = verify(repositoryMock, times(1)).save(entity);
        assertNotNull("Array não deve ser nulo", c);
        assertEquals("Array deve ser de tamanho 1", 1, c.size());
    }

    @Test
    public void should_ListDisticnt() {
        List<String> list = new ArrayList<>();
        list.add(entity.getName());
        when(repositoryMock.listDistinct()).thenReturn(list);

        List<String> c = service.listDistinct();

        // Client test = verify(repositoryMock, times(1)).save(entity);
        assertNotNull("Array não deve ser nulo", c);
        assertEquals("Array deve ser de tamanho 1", 1, c.size());
    }

}