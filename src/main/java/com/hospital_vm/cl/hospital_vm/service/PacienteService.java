package com.hospital_vm.cl.hospital_vm.service;

import com.hospital_vm.cl.hospital_vm.model.Paciente;
import com.hospital_vm.cl.hospital_vm.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente findById(Integer id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.orElseThrow(() -> new RuntimeException("Paciente no encontrado con ID: " + id));
    }

    public void delete(Long id) {
        // Convertir Long a Integer para coincidir con el tipo de ID
        pacienteRepository.deleteById(id.intValue());
    }
}