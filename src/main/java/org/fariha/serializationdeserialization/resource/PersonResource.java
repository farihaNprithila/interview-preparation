package org.fariha.serializationdeserialization.resource;

import org.fariha.serializationdeserialization.entity.Person;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class PersonResource{

    private static final Logger logger = LoggerFactory.getLogger(PersonResource.class);

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        // Log the deserialized object
        logger.info("Received Person object: {}", person);

        // Process the object (for demo purposes, just return the same object)
        return person;
    }
}
