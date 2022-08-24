package com.qaproject.palmedor.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class NomineesNotFoundByWinner extends EntityNotFoundException{}


