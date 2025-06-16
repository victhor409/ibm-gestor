package com.ibm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest {
    private String para;
    private String assunto;
    private String corpo;
    private String path_anexo;
}