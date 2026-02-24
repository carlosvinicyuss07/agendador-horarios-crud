package com.meuportifolio.agendador_horarios_crud.controller;

import com.meuportifolio.agendador_horarios_crud.infrastructure.entity.AgendamentoEntity;
import com.meuportifolio.agendador_horarios_crud.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoEntity> salvarAgendamento(@RequestBody AgendamentoEntity agendamento) {
        return ResponseEntity.ok().body(agendamentoService.salvarAgendamento(agendamento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAgendamento(@RequestParam String cliente,
                                                   @RequestParam LocalDateTime dataHoraAgendamento) {
        agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<AgendamentoEntity> buscarAgendamentosDoDia(@RequestParam LocalDate date) {
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDoDia(date));
    }

    @PutMapping
    public ResponseEntity<AgendamentoEntity> alterarAgendamentos(@RequestBody AgendamentoEntity agendamento,
                                                                 @RequestParam String cliente,
                                                                 @RequestParam LocalDateTime dataHoraAgendamento) {
        return ResponseEntity.accepted().body(
                agendamentoService.alterarAgendamento(
                        agendamento,
                        cliente,
                        dataHoraAgendamento
                )
        );
    }
}
