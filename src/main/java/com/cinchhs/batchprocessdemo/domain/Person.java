package com.cinchhs.batchprocessdemo.domain;

import lombok.Builder;

@Builder
public record Person(String firstName, String lastName) {

}
