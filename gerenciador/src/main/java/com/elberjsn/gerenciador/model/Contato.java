package com.elberjsn.gerenciador.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Contato {

    @Id
    private Long id;
    
    @NotNull(message = "O Contato do Fornecedor não pode ser vazio")
    @NonNull
    private String telefone;

    private String email;

    private String endereco;

    
    @ManyToOne
    Fornecedor fornecedorContatos;
}
