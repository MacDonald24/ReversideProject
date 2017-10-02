package com.mrdfood.demo.boot.repository;

import com.mrdfood.demo.boot.repository.RandomStringRepository;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import static com.mrdfood.demo.boot.util.ToImmutableListCollector.toImmutableList;

@Repository
class ChuckNorrisRandomStringRepository implements RandomStringRepository{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final Random randomIntGenerator = new Random();
    private ImmutableList<String> facts;

    @Value("file:data/chuck-norris-favorite-facts.txt")
    private Resource chuckNorrisFacts;


    @Override
    public String load() {
        return facts.get(randomIntGenerator.nextInt(facts.size()));
    }

    @PostConstruct
    void init() throws IOException {
        if (chuckNorrisFacts.exists()) {
            Path path = chuckNorrisFacts.getFile().toPath();
            facts = Files.lines(path).filter(line -> !line.isEmpty() && !line.startsWith("#")).collect(toImmutableList());
        } else {
            facts = ImmutableList.of("Chuck Norris counted to infinity - twice.");
        }
        logger.info("loaded facts: {}", facts);
    }
}
