package com.algaworks.algacomments.moderationservice.api.controller;

import com.algaworks.algacomments.moderationservice.api.model.ModerationInput;
import com.algaworks.algacomments.moderationservice.api.model.ModerationOutput;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/moderate")
@Slf4j
public class ModerationController {

private static final List<String> PALAVRAS_PROIBIDAS = Arrays.asList("odio", "ódio", "xingamento");

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ModerationOutput moderate(@RequestBody ModerationInput input) {
        String textoParaTeste = input.getText().toLowerCase();
        log.info("testo caixa baixa: {}", textoParaTeste);
        boolean algumaPresente = PALAVRAS_PROIBIDAS.stream()
                         .anyMatch(palavra -> textoParaTeste.contains(palavra));

        String palavrasEncontradas = PALAVRAS_PROIBIDAS.stream()
                .filter(palavra -> textoParaTeste.contains(palavra))
                .collect(Collectors.joining(","));

        log.info("palavras encontradas: {} ", palavrasEncontradas);

        log.info("contem palavras proibidas: {} ", algumaPresente);

        return ModerationOutput.builder()
                .reason(palavrasEncontradas)
                .approved(!algumaPresente)
                .build();

    }
}
