package br.com.fiap.autoescola.dto;

import br.com.fiap.autoescola.vo.Endereco;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoDTO {
    @NotBlank
    private String logradouro;
    private String numero;
    private String complemento;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String uf;
    @NotBlank
    private String cep;

    public Endereco toEntity() {
        return Endereco.builder()
                .logradouro(this.logradouro)
                .numero(this.numero)
                .complemento(this.complemento)
                .bairro(this.bairro)
                .cidade(this.cidade)
                .uf(this.uf)
                .cep(this.cep)
                .build();
    }
}