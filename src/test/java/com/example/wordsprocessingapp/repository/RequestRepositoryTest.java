package com.example.wordsprocessingapp.repository;

import com.example.wordsprocessingapp.entities.Request;
import com.example.wordsprocessingapp.repositories.RequestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RequestRepositoryTest {
    @Autowired
    private RequestRepository requestRepository;

    @Test
    public void SavingAndFindingRequestByPayloadTest() {
        var request = new Request();
        String payload = "word";
        request.setPayload(payload);
        requestRepository.save(request);

        boolean isExist = requestRepository.existsByPayload(payload);
        assertTrue(isExist);
    }

}
