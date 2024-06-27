package map.ordenacao.agenda_eventos;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        eventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        // A classe LocalDate automaticamente já sabe como organizar a data.
        // A classe LocalDate implementa ChronoLocalDate que estende de Comparable<ChronoLocalDate>
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        DateTimeFormatter padraoFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            proximaData = entry.getKey();
            proximoEvento = entry.getValue();
            if (proximaData.isEqual(dataAtual) || proximaData.isAfter(dataAtual)) {
                System.out.println("O próximo evento '" + proximoEvento.getNome() + "' acontecerá na data " + proximaData.format(padraoFormatter));
                break;
            }
        }
    }

    public static void main(String[] args) {

        var agendaEventos = new AgendaEventos();

        // Adiciona eventos na Agenda de Eventos.
        agendaEventos.adicionarEvento(LocalDate.of(2023, 7, 9), "Evento1", "Atração1");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 10), "Evento2", "Atração2");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.AUGUST, 21), "Evento3", "Atração3");
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Evento4", "Atração4");
        //agendaEventos.adicionarEvento(LocalDate.now(), "Evento5", "Atração 5");

        System.out.println("Exibe a agenda de eventos:");
        agendaEventos.exibirAgenda();
        System.out.println();

        System.out.println("Exibe o próximo evento (nome e data do evento):");
        agendaEventos.obterProximoEvento();
    }
}
