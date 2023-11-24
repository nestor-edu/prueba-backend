package com.nestor.dev.api.exceptions;

import lombok.Getter;

import java.util.Date;

@Getter
public record CustomErrors(Date timestamp, String message, String details) {

}
