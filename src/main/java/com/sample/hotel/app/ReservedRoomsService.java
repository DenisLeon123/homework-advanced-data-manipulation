package com.sample.hotel.app;

import com.sample.hotel.entity.Client;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservedRoomsService {
    @Autowired
    private DataManager dataManager;

    public Client getAllFieldClient(Client client) {
        return dataManager.load(Client.class).id(client.getId()).one();
    }
}
