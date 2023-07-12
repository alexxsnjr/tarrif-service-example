package com.alexxsnjr.tariffservice.infrastructure.rest;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorResponse {

    private List<String> errors;

}
