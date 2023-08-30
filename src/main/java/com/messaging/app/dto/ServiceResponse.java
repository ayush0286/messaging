package com.messaging.app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class ServiceResponse implements Serializable {

    private static final long serialVersionUID = -8059180865633357287L;
    private String statusCode;
    private String statusMessage;
    private transient Object payload;
}
