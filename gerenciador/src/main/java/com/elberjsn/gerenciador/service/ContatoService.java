package com.elberjsn.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.elberjsn.gerenciador.model.Contato;
import com.elberjsn.gerenciador.repository.ContatoRepository;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    public Contato salvarContato(Contato contato){
        return contatoRepository.save(contato);
    }
    public Contato buscarPorId(Long id){
        var contato = contatoRepository.findById(id);
        if (contato.isEmpty()) {
            try {
                throw new NotFoundException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contato.get();
    }
    public List<Contato> buscarContatosDoFornecedor(String forn){
        return contatoRepository.findByFornecedorNomeContainingIgnoringCase(forn);
    }
    public List<Contato> buscarContatos(Long id){
        return contatoRepository.findByFornecedorId(id);
    }
    public Contato editarContato(Contato contato){
        var cont = buscarPorId(contato.getId());

        cont.setTelefone(contato.getTelefone());
        cont.setEndereco(contato.getEndereco());
        cont.setEmail(contato.getEmail());

        return contatoRepository.save(cont);
    }
    public void deleatarContato(Contato contato){
        contatoRepository.delete(contato);
    }

}
